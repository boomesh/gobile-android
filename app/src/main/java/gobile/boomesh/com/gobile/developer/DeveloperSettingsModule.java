package gobile.boomesh.com.gobile.developer;

import android.support.annotation.NonNull;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import dagger.Module;
import dagger.Provides;
import gobile.boomesh.com.gobile.App;

/**
 * Insert developer specific setup/access to parts of developer-specific details here.  Code here
 * should not functionally affect the end-user.
 * <p>
 * Created by sumesh on 12/24/15.
 */
@Module
public class DeveloperSettingsModule {
    @NonNull
    private final RefWatcher refWatcher;

    public DeveloperSettingsModule(@NonNull final App app) {
        this.refWatcher = LeakCanary.install(app);
    }

    @SuppressWarnings("unused")
    @NonNull
    @Provides
    RefWatcher providesRefWatcher() {
        return refWatcher;
    }
}