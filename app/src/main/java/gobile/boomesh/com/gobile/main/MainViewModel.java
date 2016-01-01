package gobile.boomesh.com.gobile.main;

import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import gobile.boomesh.com.gobile.R;
import gobile.boomesh.com.gobile.base.BaseFragment;
import gobile.boomesh.com.gobile.base.viewmodel.BaseViewModel;

/**
 * View model representation of {@link MainActivity}.
 * <p/>
 * Created by sumesh on 12/31/15.
 */
public class MainViewModel extends BaseViewModel {

    private final FragmentManager fragmentManager;
    private SectionsPagerAdapter pagerAdapter;

    MainViewModel(@Nullable final BaseState savedViewState,
                  @NonNull final FragmentManager supportFragmentManager) {
        super(savedViewState);
        this.fragmentManager = supportFragmentManager;
    }

    /**
     * The pager used to manage the fragments for tab switching.
     *
     * @return a single instance of a {@link PagerAdapter}
     */
    @NonNull
    public PagerAdapter getSectionsPagerAdapter() {
        if (pagerAdapter == null) {
            pagerAdapter = new SectionsPagerAdapter(fragmentManager);
        }
        return pagerAdapter;
    }

    /**
     * {@link BaseViewModel} methods
     */

    @Override
    public BaseState getViewState() {
        return new MainViewState(this);
    }


    /**
     * Inner classes
     */

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


    /**
     * Inner classes
     */

    public static class PlaceholderFragment extends BaseFragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        @Bind(R.id.section_label)
        TextView textView;

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        }

        @NonNull
        @Override
        public String getFragmentTag() {
            return PlaceholderFragment.class.getSimpleName();
        }

        @Override
        protected int getLayoutResID() {
            return R.layout.fragment_main;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
