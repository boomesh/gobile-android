package gobile.boomesh.com.gobile;

import android.support.annotation.NonNull;

import gobile.boomesh.com.gobile.developer.DeveloperSettingsModule;
import gobile.boomesh.com.gobile.developer.TestDeveloperSettingsModule;

/**
 * Overridden so that custom modules can be supplied for {@link App}
 * <p/>
 * Created by sumesh on 12/24/15.
 */
public class TestApp extends App {
    @NonNull
    @Override
    protected AppModule createAppModule() {
        return new TestAppModule(this);
    }

    @NonNull
    @Override
    protected DeveloperSettingsModule createDevSettingsModule(@NonNull AppModule appModule) {
        return new TestDeveloperSettingsModule(this, appModule.providesSharedPreferences());
    }
}
