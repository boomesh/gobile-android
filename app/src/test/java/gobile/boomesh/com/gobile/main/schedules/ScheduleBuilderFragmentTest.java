package gobile.boomesh.com.gobile.main.schedules;

import android.widget.Adapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import gobile.boomesh.com.gobile.BuildConfig;
import gobile.boomesh.com.gobile.base.adapter.BaseSpinnerAdapter;

import static org.robolectric.shadows.support.v4.SupportFragmentTestUtil.startVisibleFragment;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 18)
public class ScheduleBuilderFragmentTest {
    ScheduleBuilderFragment fragment;

    @Before
    void setUp() {
        fragment = ScheduleBuilderFragment.newInstance();
        startVisibleFragment(fragment);
    }

    @Test
    void testSwapStartAndEndStops() {
        final BaseSpinnerAdapter startStopAdapter = (BaseSpinnerAdapter) fragment.startSpinner.getAdapter();
        final BaseSpinnerAdapter endStopAdapter = (BaseSpinnerAdapter) fragment.endSpinner.getAdapter();


    }

}