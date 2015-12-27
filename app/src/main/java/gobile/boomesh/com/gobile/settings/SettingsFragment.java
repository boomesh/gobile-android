package gobile.boomesh.com.gobile.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import gobile.boomesh.com.gobile.R;
import gobile.boomesh.com.gobile.base.BaseFragment;

/**
 * The view for the settings portion of the app
 * <p/>
 * Created by sumesh on 12/25/15.
 */
public class SettingsFragment extends BaseFragment {
    private static final String TAG = SettingsFragment.class.getSimpleName();

    @Inject
    SharedPreferences preferences;

    public static SettingsFragment newInstance() {
        final Bundle args = new Bundle();
        final SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public String getFragmentTag() {
        return TAG;
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_settings;
    }
}
