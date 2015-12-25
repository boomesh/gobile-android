package gobile.boomesh.com.gobile.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import gobile.boomesh.com.gobile.R;

/**
 * Only have one fragment in this class.  Purpose is to make sure UI is using fragments, and tablet
 * support in the future will not be difficult.
 * <p>
 * Created by sumesh on 12/25/15.
 */
public abstract class BaseSingleFragmentActivity extends BaseActivity {

    /**
     * Subclass methods should not override this.  Rely on other life cycle methods.
     * {@inheritDoc}
     */
    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
     * Subclasses must provide a fragment, that will server as the view for the activity
     *
     * @return a {@link BaseFragment} instance
     */
    @NonNull
    protected abstract BaseFragment newFragmentInstance();


    /**
     * {@link BaseActivity} methods
     */

    /**
     * {@inheritDoc}
     */
    @Override
    protected final int getContentViewLayoutID() {
        return R.layout.activity_base_single_fragment;
    }
}
