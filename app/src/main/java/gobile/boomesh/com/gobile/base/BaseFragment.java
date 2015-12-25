package gobile.boomesh.com.gobile.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.squareup.leakcanary.RefWatcher;

import javax.inject.Inject;

import gobile.boomesh.com.gobile.App;

/**
 * Used to override, and setup the most basic of libraries (e.g. LeakCanary, or google analytics)
 * <p>
 * Created by sumesh on 12/24/15.
 */
public class BaseFragment extends Fragment {

    @SuppressWarnings("WeakerAccess")
    @Inject
    RefWatcher refWatcher;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.get(getContext()).getAppComponent().inject(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        refWatcher.watch(this);
    }
}
