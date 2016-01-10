package gobile.boomesh.com.gobile.main.departures;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import gobile.boomesh.com.gobile.R;
import gobile.boomesh.com.gobile.base.viewmodel.BaseViewModel;
import gobile.boomesh.com.gobile.main.BaseMainPageFragment;

/**
 * Created by sumesh on 1/5/16.
 */
public class DeparturesFragment extends BaseMainPageFragment {
    private static final String TAG = DeparturesFragment.class.getSimpleName();

    public static BaseMainPageFragment newInstance() {

        final Bundle args = new Bundle();

        final DeparturesFragment fragment = new DeparturesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //region BaseMainPageFragment methods

    @Override
    public int getTabIcon() {
        return R.drawable.ic_dvr_white;
    }

    @Nullable
    @Override
    protected BaseViewModel createViewModel(@Nullable BaseViewModel.BaseState savedViewModelState) {
        return null;
    }

    @NonNull
    @Override
    public String getFragmentTag() {
        return TAG;
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_departures;
    }

    //endregion
}
