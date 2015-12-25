package gobile.boomesh.com.gobile;

import dagger.Component;
import gobile.boomesh.com.gobile.base.BaseFragment;
import gobile.boomesh.com.gobile.developer.DeveloperSettingsModule;

/**
 * Required for Dagger to map modules (and injection)
 * <p>
 * Created by sumesh on 12/24/15.
 */

@Component(
        modules = {
                AppModule.class,
                DeveloperSettingsModule.class
        }
)
public interface AppComponent {
    /**
     * {@link BaseFragment} specific instances should call this method to have {@code @Inject}
     * fields filled in.
     *
     * @param baseFragment provide an instance of {@link BaseFragment} to inject
     */
    void inject(final BaseFragment baseFragment);
}
