package gobile.boomesh.com.gobile.settings;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Test;

import gobile.boomesh.com.gobile.R;
import gobile.boomesh.com.gobile.TestApp;
import gobile.boomesh.com.gobile.TestConsts;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by sumesh on 12/30/15.
 */
public class SettingsViewModelTest {

    private SettingsViewModel viewModel;
    private SharedPreferences prefs;

    @Before
    public void setUp() throws Exception {
        final Context context = mock(Context.class);
        final Application app = spy(TestApp.class);
        prefs = mock(SharedPreferences.class);

        doReturn(prefs).when(app).getSharedPreferences(TestConsts.PREFS_NAME, Context.MODE_PRIVATE);
        doReturn("GOBile").when(app).getString(R.string.app_name);
        doReturn("GOBile").when(app).getString(R.string.debug_toast_restart_app);
        when(context.getApplicationContext()).thenReturn(app);
        viewModel = new SettingsViewModel(context, null);
    }

    @Test
    public void testOnLeakCanaryCheckedChanged_Saved() throws Exception {
        testOnLeakCanaryCheckedChanged(true, false);
        testOnLeakCanaryCheckedChanged(false, true);
    }

    @Test
    public void testOnLeakCanaryCheckedChanged_Not_Saved() throws Exception {
        testOnLeakCanaryCheckedChanged(true, true);
        testOnLeakCanaryCheckedChanged(false, false);
    }

    public void testOnLeakCanaryCheckedChanged(final boolean isChecked,
                                               final boolean savedIsCheckedBoolean) {
        final SharedPreferences.Editor editor = mock(SharedPreferences.Editor.class);
        when(prefs.edit()).thenReturn(editor);
        when(prefs.getBoolean(TestConsts.PREFS_LEAK_CANARY_ON, false))
                .thenReturn(savedIsCheckedBoolean);

        viewModel.onLeakCanaryCheckedChanged(isChecked);

        if (isChecked != savedIsCheckedBoolean) {
            verify(editor).putBoolean(TestConsts.PREFS_LEAK_CANARY_ON, isChecked);
            verify(editor).apply();
        } else {
            verify(editor, never()).putBoolean(TestConsts.PREFS_LEAK_CANARY_ON, isChecked);
            verify(editor, never()).apply();
        }
    }
}