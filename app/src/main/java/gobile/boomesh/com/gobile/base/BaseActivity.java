package gobile.boomesh.com.gobile.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Put only generic activity related code here.  No specific implementation should go in here.
 * <p>
 * Subclasses will use:
 * - {@link ButterKnife}
 * <p>
 * Created by sumesh on 12/25/15.
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * Life cycle methods
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewLayoutID());
        ButterKnife.bind(this);
    }


    /**
     * Subclass methods
     */

    /**
     * Supply a content layout xml for the activity
     *
     * @return the layout id of the content view
     */
    @LayoutRes
    protected abstract int getContentViewLayoutID();
}
