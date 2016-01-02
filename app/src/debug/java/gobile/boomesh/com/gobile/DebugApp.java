package gobile.boomesh.com.gobile;


import com.facebook.stetho.Stetho;

/**
 * Created so that if developer configurations for an app does not leak into release builds.
 * Technique grabbed from:
 * https://github.com/facebook/stetho/commit/c53a222fe4765d2da7fe8f5e353b4f5155c31b76
 * <p/>
 * Created by sumesh on 12/24/15.
 */
public class DebugApp extends App {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build()
        );
    }
}
