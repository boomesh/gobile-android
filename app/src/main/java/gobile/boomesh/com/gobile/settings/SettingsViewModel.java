package gobile.boomesh.com.gobile.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.Bindable;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import gobile.boomesh.com.gobile.App;
import gobile.boomesh.com.gobile.R;
import gobile.boomesh.com.gobile.base.viewmodel.BaseViewModel;

/**
 * View model structure for {@link SettingsFragment}
 * <p/>
 * Created by sumesh on 12/29/15.
 */
public class SettingsViewModel extends BaseViewModel {
    private static final String TAG = SettingsViewModel.class.getSimpleName();
    private static final String PREFS_LEAK_CANARY_ON = TAG + ".leak_canary_on";

    @Inject
    SharedPreferences preferences;

    public SettingsViewModel(@NonNull final Context context,
                             @Nullable final BaseState savedViewState) {
        super(savedViewState);
        App.get(context).getAppComponent().inject(this);
    }

    public void onLeakCanaryCheckedChanged(boolean isChecked) {
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(PREFS_LEAK_CANARY_ON, isChecked);
        editor.apply();
    }

    public void refreshView() {
        notifyPropertyChanged(R.id.leak_canary_sw);
    }


    /**
     * {@link Bindable} methods
     */

    @Bindable
    public boolean isLeakCanaryOn() {
        return preferences.getBoolean(PREFS_LEAK_CANARY_ON, false);
    }


    /**
     * {@link BaseViewModel} methods
     */

    @Override
    public BaseState getViewState() {
        return new SettingsState(this);
    }


    /**
     * Inner classes
     */

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
}
