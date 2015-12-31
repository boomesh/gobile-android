package gobile.boomesh.com.gobile;


import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;

import gobile.boomesh.com.gobile.developer.DeveloperSettingsModule;

/**
 * Custom override class of {@link Application}, for DI purposes, potential usages of other
 * libraries.
 * Created by sumesh on 12/24/15.
 */
public class App extends Application {

    /**
     * instantiated in {@link #onCreate()}
     */
    @Nullable
    private AppComponent appComponent;

    /**
     * Use this method to get access to an {@link App} instance.
     * Prevent need in a singleton (global) reference to the application object.
     *
     * @param context used to grab an instance of the application
     * @return non-null instance of {@link App}
     */
    @NonNull
    public static App get(@NonNull final Context context) {
        return (App) context.getApplicationContext();
    }

    /**
     * Can use this to help inject members.
     *
     * @return the instance of {@link AppComponent} created in {@link #onCreate()}
     */
    @NonNull
    public AppComponent getAppComponent() {
        if (appComponent == null) {
            final AppModule appModule = createAppModule();

            appComponent = DaggerAppComponent.builder()
                    .appModule(appModule)
                    .developerSettingsModule(createDevSettingsModule(appModule))
                    .build();
        }
        return appComponent;
    }

    /**
     * This method is made so that unit testing can provide a custom {@link AppModule} module
     *
     * @return an {@link AppModule} instance
     */
    @VisibleForTesting
    @NonNull
    protected AppModule createAppModule() {
        return new AppModule(this);
    }

    /**
     * This method is made so that unit testing can provide a custom {@link DeveloperSettingsModule}
     * module
     *
     * @param appModule a {@link AppModule} instance, with properly configured SharedPreferences
     * @return a {@link DeveloperSettingsModule} instance
     */
    @VisibleForTesting
    @NonNull
    protected DeveloperSettingsModule createDevSettingsModule(@NonNull final AppModule appModule) {
        return new DeveloperSettingsModule(
                this,
                appModule.providesSharedPreferences());
    }
}
