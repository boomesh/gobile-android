package gobile.boomesh.com.gobile.main;

import android.support.annotation.DrawableRes;

import gobile.boomesh.com.gobile.base.viewmodel.BaseViewModelFragment;

/**
 * This serves as a wrapper class for tab layout on the {@link MainActivity}
 * Created by sumesh on 1/1/16.
 */
public abstract class BaseMainPageFragment extends BaseViewModelFragment {
    @DrawableRes
    public abstract int getTabIcon();
}
