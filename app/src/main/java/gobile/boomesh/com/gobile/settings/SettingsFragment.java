package gobile.boomesh.com.gobile.settings;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.OnCheckedChanged;
import gobile.boomesh.com.gobile.R;
import gobile.boomesh.com.gobile.base.viewmodel.BaseViewModel;
import gobile.boomesh.com.gobile.base.viewmodel.BaseViewModelFragment;
import gobile.boomesh.com.gobile.databinding.FragmentSettingsBinding;

/**
 * The view for the settings portion of the app
 * <p/>
 * Created by sumesh on 12/25/15.
 */
public class SettingsFragment extends BaseViewModelFragment {
    private static final String TAG = SettingsFragment.class.getSimpleName();

    @Nullable
    private SettingsViewModel settingsViewModel;


    /**
     * instance methods
     */

    public static SettingsFragment newInstance() {
        final Bundle args = new Bundle();
        final SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    /**
     * Life cycle methods
     */

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        final View view = super.onCreateView(inflater, container, savedInstanceState);
        final FragmentSettingsBinding binding = DataBindingUtil.bind(view);
        if (binding != null && settingsViewModel != null) {
            binding.setSettings(settingsViewModel);
        }
        return view;
    }


    /**
     * {@link butterknife.ButterKnife} methods
     */

    @OnCheckedChanged(R.id.leak_canary_sw)
    void onLeakCanaryCheckedChanged(final boolean isChecked) {
        if (settingsViewModel != null) {
            settingsViewModel.onLeakCanaryCheckedChanged(isChecked);
        }
    }


    /**
     * {@link BaseViewModelFragment} methods
     */

    @NonNull
    @Override
    public String getFragmentTag() {
        return TAG;
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_settings;
    }

    @Nullable
    @Override
    protected BaseViewModel createViewModel(@Nullable BaseViewModel.BaseState savedViewModelState) {
        settingsViewModel = new SettingsViewModel(getContext(), savedViewModelState);
        return settingsViewModel;
    }
}
