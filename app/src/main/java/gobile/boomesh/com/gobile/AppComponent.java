package gobile.boomesh.com.gobile;

import dagger.Component;
import gobile.boomesh.com.gobile.base.BaseFragment;
import gobile.boomesh.com.gobile.developer.DeveloperSettingsModule;
import gobile.boomesh.com.gobile.settings.SettingsViewModel;

/**
 * Required for Dagger to map modules (and injection)
 * <p/>
 * Created by sumesh on 12/24/15.
 */

@Component(
        modules = {
                AppModule.class,
                DeveloperSettingsModule.class
        }
)
public interface AppComponent {

    void inject(final BaseFragment baseFragment);

    //TODO move this to a Settings App component
    void inject(final SettingsViewModel settingsViewModel);
}
