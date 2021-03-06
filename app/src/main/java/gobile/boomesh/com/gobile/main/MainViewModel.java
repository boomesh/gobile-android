package gobile.boomesh.com.gobile.main;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import gobile.boomesh.com.gobile.R;
import gobile.boomesh.com.gobile.base.BaseActivity;
import gobile.boomesh.com.gobile.base.viewmodel.BaseViewModel;
import gobile.boomesh.com.gobile.main.departures.DeparturesFragment;
import gobile.boomesh.com.gobile.main.favourites.FavouritesFragment;
import gobile.boomesh.com.gobile.main.schedules.ScheduleBuilderFragment;
import gobile.boomesh.com.gobile.settings.SettingsActivity;
import gobile.boomesh.com.gobile.utils.customtabs.CustomTabActivityHelper;

/**
 * View model representation of {@link MainActivity}.
 * <p>
 * Created by sumesh on 12/31/15.
 */
public class MainViewModel extends BaseViewModel {

    @NonNull
    private final BaseActivity activity;
    @NonNull
    private final TabLayout tabLayout;
    private final List<BaseMainPageFragment> pages = Arrays.asList(
            DeparturesFragment.newInstance(),
            FavouritesFragment.newInstance(),
            ScheduleBuilderFragment.newInstance());
    private final CustomTabActivityHelper customTabActivityHelper;
    private final CustomTabActivityHelper.CustomTabFallback customTabFallback = new CustomTabActivityHelper.CustomTabFallback() {
        @Override
        public void openUri(final Activity activity, Uri uri) {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
    };
    private final Uri serviceStatusWebUri;
    private SectionsPagerAdapter pagerAdapter;


    //region Instance methods

    MainViewModel(@Nullable final BaseState savedViewState,
                  @NonNull final BaseActivity activity,
                  @NonNull final TabLayout tabLayout) {
        super(savedViewState);
        this.activity = activity;
        this.tabLayout = tabLayout;
        this.customTabActivityHelper = new CustomTabActivityHelper();
        this.serviceStatusWebUri = Uri.parse(activity.getString(R.string.service_status_url));
    }

    /**
     * The pager used to manage the fragments for tab switching.
     *
     * @return a single instance of a {@link PagerAdapter}
     */
    @NonNull
    public PagerAdapter getSectionsPagerAdapter() {
        if (pagerAdapter == null) {
            pagerAdapter = new SectionsPagerAdapter(activity.getSupportFragmentManager());
        }
        return pagerAdapter;
    }

    //endregion

    //region View calling ViewModel methods

    /**
     * Method for consuming {@link MainActivity#onOptionsItemSelected(MenuItem)} events
     *
     * @param menuId the id (specified in the menu xml) that was clicked
     * @return {@code true} to say the menu item was consumed.  {@code false} otherwise.
     */
    public boolean onOptionsItemSelected(@IdRes final int menuId) {
        if (menuId == R.id.action_settings) {
            activity.startActivity(new Intent(activity, SettingsActivity.class));
            return true;
        } else if (menuId == R.id.action_service_status) {
            final CustomTabsIntent.Builder intentBuilder =
                    new CustomTabsIntent
                            .Builder()
                            .setToolbarColor(
                                    ContextCompat.getColor(activity, R.color.colorPrimary))
                            .setShowTitle(true);

            CustomTabActivityHelper.openCustomTab(
                    activity, intentBuilder.build(), serviceStatusWebUri, customTabFallback);

            return true;
        }

        return false;
    }

    /**
     * Refresh the tabs (after they have been set)
     */
    public void refreshTabs() {
        final int tabCount = tabLayout.getTabCount();
        if (tabCount == 0) {
            return;
        }

        for (int i = 0; i < tabCount; i++) {
            final TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setIcon(pages.get(i).getTabIcon());
            }
        }
    }

    //endregion


    //region BaseViewModel methods

    @Override
    public BaseState getViewState() {
        return new MainViewState(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        customTabActivityHelper.bindCustomTabsService(activity);
        customTabActivityHelper.mayLaunchUrl(serviceStatusWebUri, null, null);
    }

    @Override
    public void onStop() {
        super.onStop();
        customTabActivityHelper.unbindCustomTabsService(activity);
    }

    //endregion


    //region Inner classes

    private static class MainViewState extends BaseState {

        public static final Creator<MainViewState> CREATOR = new Creator<MainViewState>() {
            public MainViewState createFromParcel(Parcel source) {
                return new MainViewState(source);
            }

            public MainViewState[] newArray(int size) {
                return new MainViewState[size];
            }
        };

        MainViewState(@NonNull BaseViewModel viewModel) {
            super(viewModel);
        }

        MainViewState(Parcel in) {
            super(in);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @SuppressWarnings("EmptyMethod")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return pages.get(position);
        }

        @Override
        public int getCount() {
            return pages.size();
        }
    }

    //endregion
}
