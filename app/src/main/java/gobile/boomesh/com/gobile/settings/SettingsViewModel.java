package gobile.boomesh.com.gobile.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.Bindable;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import javax.inject.Inject;

import gobile.boomesh.com.gobile.App;
import gobile.boomesh.com.gobile.Consts;
import gobile.boomesh.com.gobile.R;
import gobile.boomesh.com.gobile.base.viewmodel.BaseViewModel;

/**
 * View model structure for {@link SettingsFragment}
 * <p/>
 * Created by sumesh on 12/29/15.
 */
public class SettingsViewModel extends BaseViewModel {

    @NonNull
    private final Context appContext;

    @Inject
    SharedPreferences preferences;

    
    //region Instance methods

    public SettingsViewModel(@NonNull final Context context,
                             @Nullable final BaseState savedViewState) {
        super(savedViewState);
        appContext = context.getApplicationContext();
        App.get(context).getAppComponent().inject(this);
    }


    //region View calling ViewModel methods

    public void onLeakCanaryCheckedChanged(final boolean isChecked) {
        if (isLeakCanaryOn() == isChecked) {
            return;
        }

        final String appName = appContext.getString(R.string.app_name);
        final String restartString = appContext.getString(R.string.debug_toast_restart_app);
        final String toastContent = String.format(restartString, appName);
        try {
            Toast.makeText(appContext, toastContent, Toast.LENGTH_SHORT).show();
        } catch (RuntimeException e) {
            // swallow exception...because unit testing.
            // I can use robolectric potentially, but I want to avoid using it because
            // JUnit is faster.
        }

        final SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(Consts.PREFS_LEAK_CANARY_ON, isChecked);
        editor.apply();
    }

    //endregion


    //region Bindable methods
    @Bindable
    public boolean isLeakCanaryOn() {
        return preferences.getBoolean(Consts.PREFS_LEAK_CANARY_ON, false);
    }
    //endregion

    //endregion


    //region BaseViewModel methods
    @Override
    public BaseState getViewState() {
        return new SettingsState(this);
    }
    //endregion


    //region Inner classes
    private static class SettingsState extends BaseState {
        public static final Creator<SettingsState> CREATOR = new Creator<SettingsState>() {
            public SettingsState createFromParcel(Parcel source) {
                return new SettingsState(source);
            }

            public SettingsState[] newArray(int size) {
                return new SettingsState[size];
            }
        };

        //Right now this is empty.  Add more when necessary
        SettingsState(@NonNull BaseViewModel viewModel) {
            super(viewModel);
        }

        SettingsState(Parcel in) {
            super(in);
        }

        @Override
        public int describeContents() {
            return 0;
        }
    }
    //endregion
}
