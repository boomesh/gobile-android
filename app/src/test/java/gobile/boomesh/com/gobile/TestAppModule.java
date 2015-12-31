package gobile.boomesh.com.gobile;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/**
 * Created by sumesh on 12/30/15.
 */
public class TestAppModule extends AppModule {
    public TestAppModule(@NonNull App app) {
        super(app);
    }

    @Override
    SharedPreferences providesSharedPreferences() {
        return getAppInstance().getSharedPreferences(TestConsts.PREFS_NAME, Context.MODE_PRIVATE);
    }
}
