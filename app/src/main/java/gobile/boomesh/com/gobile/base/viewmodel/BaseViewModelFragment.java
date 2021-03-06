package gobile.boomesh.com.gobile.base.viewmodel;

import android.os.Bundle;
import android.support.annotation.Nullable;

import gobile.boomesh.com.gobile.base.BaseFragment;

/**
 * All fragments must inherit from this class.
 * <p/>
 * Code attained from:
 * - {@code https://medium.com/@hiBrianLee/writing-testable-android-mvvm-app-part-1-ac2c39f31710}
 * Created by sumesh on 12/29/15.
 */
public abstract class BaseViewModelFragment extends BaseFragment {
    private static final String TAG = BaseViewModelFragment.class.getSimpleName();

    private static final String EXTRA_VIEW_MODEL_STATE = TAG + ".view_model_state";

    @Nullable
    private BaseViewModel viewModel;


    //region Lifecycle methods

    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BaseViewModel.BaseState savedViewModelState = null;
        if (savedInstanceState != null) {
            savedViewModelState = savedInstanceState.getParcelable(EXTRA_VIEW_MODEL_STATE);
        }
        viewModel = createViewModel(savedViewModelState);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (viewModel != null) {
            viewModel.onStart();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (viewModel != null) {
            viewModel.onStop();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (viewModel != null) {
            outState.putParcelable(EXTRA_VIEW_MODEL_STATE, viewModel.getViewState());
        }
    }

    //endregion


    //region Subclass methods

    /**
     * Child classes must create the view model instance.
     *
     * @param savedViewModelState the preserved view model state
     * @return can be null potentially.
     */
    @Nullable
    protected abstract BaseViewModel createViewModel(@Nullable final BaseViewModel.BaseState savedViewModelState);

    //endregion
}
