package gobile.boomesh.com.gobile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Should only contain generic, app related dependencies.
 * <p/>
 * Created by sumesh on 12/24/15.
 */
@Module
class AppModule {

    private final App app;

    public AppModule(@NonNull final App app) {
        this.app = app;
    }

    @Singleton
    App getAppInstance() {
        return app;
    }

    @Provides
    SharedPreferences providesSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(getAppInstance());
    }
}
