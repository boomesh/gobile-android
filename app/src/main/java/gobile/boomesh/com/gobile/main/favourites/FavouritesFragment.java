package gobile.boomesh.com.gobile.main.favourites;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import gobile.boomesh.com.gobile.R;
import gobile.boomesh.com.gobile.base.viewmodel.BaseViewModel;
import gobile.boomesh.com.gobile.main.BaseMainPageFragment;

/**
 * Created by sumesh on 1/5/16.
 */
public class FavouritesFragment extends BaseMainPageFragment {
    private static final String TAG = FavouritesFragment.class.getSimpleName();

    public static FavouritesFragment newInstance() {

        final Bundle args = new Bundle();

        final FavouritesFragment fragment = new FavouritesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //region BaseMainPageFragment methods
    @Nullable
    @Override
    protected BaseViewModel createViewModel(@Nullable BaseViewModel.BaseState savedViewModelState) {
        // TODO: null for now
        return null;
    }

    @NonNull
    @Override
    public String getFragmentTag() {
        return TAG;
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_favourites;
    }

    @Override
    public int getTabIcon() {
        return R.drawable.ic_star_white;
    }
    //endregion
}
