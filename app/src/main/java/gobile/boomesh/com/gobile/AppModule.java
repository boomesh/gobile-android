package gobile.boomesh.com.gobile;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Should only contain generic, app related dependencies.
 * <p>
 * Created by sumesh on 12/24/15.
 */
@Module
class AppModule {
    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(@NonNull final Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}
