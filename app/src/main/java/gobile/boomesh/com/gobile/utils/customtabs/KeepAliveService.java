package gobile.boomesh.com.gobile.utils.customtabs;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Empty service used by the custom tab to bind to, raising the application's importance.
 * Code gotten from: https://github.com/hitherejoe/Tabby/blob/master/app/src/main/java/com/hitherejoe/tabby/util/KeepAliveService.java
 */
public class KeepAliveService extends Service {
    private static  Binder sBinder = new Binder();

    @Override
    public IBinder onBind(Intent intent) {
        return sBinder;
    }
}