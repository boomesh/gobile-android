package gobile.boomesh.com.gobile.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.Bind;
import butterknife.OnClick;
import gobile.boomesh.com.gobile.BuildConfig;
import gobile.boomesh.com.gobile.R;
import gobile.boomesh.com.gobile.base.BaseActivity;
import gobile.boomesh.com.gobile.base.viewmodel.BaseViewModel;
import gobile.boomesh.com.gobile.base.viewmodel.BaseViewModelActivity;
import gobile.boomesh.com.gobile.settings.SettingsActivity;

public class MainActivity extends BaseViewModelActivity {

    @Bind(R.id.container)
    ViewPager viewPager;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tablayout)
    TabLayout tabLayout;

    @Nullable
    private MainViewModel mainViewModel;


    /**
     * Life-cycle methods
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);

        if (mainViewModel != null) {
            final PagerAdapter sectionsPagerAdapter = mainViewModel.getSectionsPagerAdapter();
            viewPager.setAdapter(sectionsPagerAdapter);
            tabLayout.setTabsFromPagerAdapter(sectionsPagerAdapter);
            tabLayout.setupWithViewPager(viewPager);
            mainViewModel.refreshTabs();
        }

    }

    @Nullable
    @Override
    protected BaseViewModel createViewModel(@Nullable final BaseViewModel.BaseState savedViewModelState) {
        mainViewModel = new MainViewModel(
                savedViewModelState,
                getSupportFragmentManager(),
                tabLayout);
        return mainViewModel;
    }


    /**
     * {@link butterknife.ButterKnife} methods
     */

    @OnClick(R.id.fab)
    void onFabClicked(final View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }


    /**
     * {@link BaseActivity} methods
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //TODO add a feedback button
        return BuildConfig.DEBUG;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }
}
