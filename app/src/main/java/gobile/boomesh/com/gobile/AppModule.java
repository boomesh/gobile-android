package gobile.boomesh.com.gobile;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Should only contain generic, app related dependencies.
 * <p/>
 * Created by sumesh on 12/24/15.
 */
@Module
public class AppModule {
    @NonNull
    private RefWatcher refWatcher;

    public AppModule(@NonNull final Application application) {
        this.refWatcher = LeakCanary.install(application);
    }

    @NonNull
    @Provides
    RefWatcher providesRefWatcher() {
        return refWatcher;
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(@NonNull final Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}
