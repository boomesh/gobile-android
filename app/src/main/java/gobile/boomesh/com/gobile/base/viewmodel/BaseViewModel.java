package gobile.boomesh.com.gobile.base.viewmodel;

import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * ViewModel pattern being used in this app; if UI is involved, you must be using this class to tie
 * the UI to model information.
 * <p/>
 * Code attained from:
 * - {@code https://medium.com/@hiBrianLee/writing-testable-android-mvvm-app-part-1-ac2c39f31710}
 * Created by sumesh on 12/26/15.
 */
public abstract class BaseViewModel extends BaseObservable {
    @SuppressWarnings("UnusedParameters")
    protected BaseViewModel(@Nullable final BaseState savedViewState) {
    }

    /**
     * Get a {@link BaseState} representation of this class
     *
     * @return new instance state of the view
     */
    public BaseState getViewState() {
        return new BaseState(this);
    }

    /**
     * Call in appropriate activities/fragments/service {@code #onStart()} methods
     */
    @SuppressWarnings("EmptyMethod")
    @CallSuper
    public void onStart() {
    }

    /**
     * Call in appropriate activities/fragments/service {@code #onStop()} methods
     */
    @SuppressWarnings("EmptyMethod")
    @CallSuper
    public void onStop() {
    }

    /**
     * Helper class to preserve the state of this view model
     */
    public static class BaseState implements Parcelable {

        @SuppressWarnings("UnusedParameters")
        protected BaseState(@NonNull final BaseViewModel viewModel) {

        }

        @SuppressWarnings("UnusedParameters")
        protected BaseState(Parcel in) {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }
    }
}
