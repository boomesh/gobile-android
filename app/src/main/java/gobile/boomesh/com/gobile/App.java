package gobile.boomesh.com.gobile;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Custom override class of {@link Application}, for DI, potential other libraries
 * Created by sumesh on 12/24/15.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
