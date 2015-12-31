package gobile.boomesh.com.gobile.developer;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import gobile.boomesh.com.gobile.App;

/**
 * Created by sumesh on 12/30/15.
 */
public class TestDeveloperSettingsModule extends DeveloperSettingsModule {
    public TestDeveloperSettingsModule(@NonNull App app,
                                       @NonNull SharedPreferences sharedPreferences) {
        super(app, sharedPreferences);
    }
}
