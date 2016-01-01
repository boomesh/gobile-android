package gobile.boomesh.com.gobile.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.Bind;
import gobile.boomesh.com.gobile.R;
import gobile.boomesh.com.gobile.base.viewmodel.BaseViewModel;
import gobile.boomesh.com.gobile.base.viewmodel.BaseViewModelActivity;

/**
 * Only have one fragment in this class.  Purpose is to make sure UI is using fragments, and tablet
 * support in the future will not be difficult.
 * <p/>
 * Created by sumesh on 12/25/15.
 */
public abstract class BaseSingleFragmentActivity extends BaseViewModelActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;


    /**
     * Subclass methods should not override this.  Rely on other life cycle methods.
     * {@inheritDoc}
     */
    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupAppBar();
    }

    private void setupAppBar() {
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) {
            return;
        }
        final int titleID = getTitleStringResID();
        if (titleID != 0) {
            getSupportActionBar().setTitle(titleID);
        }

        View.OnClickListener onNavClickListener = null;
        if (isUpShown()) {
            onNavClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            };
        }

        toolbar.setNavigationOnClickListener(onNavClickListener);
        actionBar.setDisplayHomeAsUpEnabled(isUpShown());
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (savedInstanceState == null) {
            final BaseFragment baseFragment = newFragmentInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content, baseFragment, baseFragment.getFragmentTag())
                    .commit();
        }
    }


    /**
     * Subclass methods
     */

    /**
     * Subclasses must provide a fragment, that will serve as the view for the activity
     *
     * @return a {@link BaseFragment} instance
     */
    @NonNull
    protected abstract BaseFragment newFragmentInstance();

    /**
     * Supply a string resource id to populate the title with
     *
     * @return {@code 0} to use the default app name, or a valid string resource id
     */
    @StringRes
    protected int getTitleStringResID() {
        return 0;
    }

    /**
     * Indicate if up arrow is shown on app bar
     *
     * @return {@code true} to show it, {@code false} otherwise
     */
    protected boolean isUpShown() {
        return false;
    }

    /**
     * {@link BaseViewModelActivity} methods
     */

    /**
     * {@inheritDoc}
     */
    @Override
    protected final int getContentViewLayoutID() {
        return R.layout.activity_base_single_fragment;
    }


    @Nullable
    @Override
    protected BaseViewModel createViewModel(BaseViewModel.BaseState savedViewModelState) {
        // By default, no view model
        return null;
    }
}
