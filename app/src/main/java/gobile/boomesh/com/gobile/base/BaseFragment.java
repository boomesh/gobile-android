package gobile.boomesh.com.gobile.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.leakcanary.RefWatcher;

import javax.inject.Inject;

import butterknife.ButterKnife;
import gobile.boomesh.com.gobile.App;

/**
 * Used to override, and setup the most basic of libraries (e.g. LeakCanary, or google analytics)
 * <p>
 * Created by sumesh on 12/24/15.
 */
public abstract class BaseFragment extends Fragment {

    @SuppressWarnings("WeakerAccess")
    @Inject
    RefWatcher refWatcher;


    /**
     * Life cycle methods
     */

    @Override
    public final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.get(getContext()).getAppComponent().inject(this);
    }

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public final void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        refWatcher.watch(this);
    }


    /**
     * Subclass methods
     */

    /**
     * Used in fragment transactions.
     *
     * @return should return {@code <subclass name>.class.getSimpleName()}
     */
    @NonNull
    public abstract String getFragmentTag();
}
