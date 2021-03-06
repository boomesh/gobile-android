package gobile.boomesh.com.gobile;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/**
 * Class is overridden to provide a custom shared preferences.
 * <p/>
 * Created by sumesh on 12/30/15.
 */
class TestAppModule extends AppModule {
    public TestAppModule(@NonNull App app) {
        super(app);
    }

    @Override
    SharedPreferences providesSharedPreferences() {
        return getAppInstance().getSharedPreferences(TestConsts.PREFS_NAME, Context.MODE_PRIVATE);
    }
}
