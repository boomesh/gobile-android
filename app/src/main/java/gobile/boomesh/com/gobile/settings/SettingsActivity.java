package gobile.boomesh.com.gobile.settings;

import android.support.annotation.NonNull;

import gobile.boomesh.com.gobile.R;
import gobile.boomesh.com.gobile.base.BaseFragment;
import gobile.boomesh.com.gobile.base.BaseSingleFragmentActivity;

/**
 * Container for {@link SettingsFragment}
 * Created by sumesh on 12/25/15.
 */
public class SettingsActivity extends BaseSingleFragmentActivity {


    //region BaseSingleFragmentActivity methods

    @NonNull
    @Override
    protected BaseFragment newFragmentInstance() {
        return SettingsFragment.newInstance();
    }

    @Override
    protected int getTitleStringResID() {
        return R.string.action_settings;
    }

    @Override
    protected boolean isUpShown() {
        return true;
    }

    //endregion
}
