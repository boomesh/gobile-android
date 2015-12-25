package gobile.boomesh.com.gobile;


import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

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
    @SuppressWarnings("NullableProblems")
    @NonNull
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

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .developerSettingsModule(new DeveloperSettingsModule(this))
                .build();
    }

    /**
     * Can use this to help inject members.
     *
     * @return the instance of {@link AppComponent} created in {@link #onCreate()}
     */
    @NonNull
    public AppComponent getAppComponent() {
        return appComponent;
    }
}
