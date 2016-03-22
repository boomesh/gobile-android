package gobile.boomesh.com.gobile.main.schedules;

import android.content.Context;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.SpinnerAdapter;

import java.util.List;

import gobile.boomesh.com.gobile.base.adapter.BaseSpinnerAdapter;
import gobile.boomesh.com.gobile.base.viewmodel.BaseViewModel;

/**
 * Encompasses logic associated with the view for {@link ScheduleBuilderFragment}
 * <p>
 * Created by sumesh on 1/12/16.
 */
public class ScheduleBuilderViewModel extends BaseViewModel {

    private final SpinnerAdapter lineAdapter;
    private BaseSpinnerAdapter<String> startStopAdapter;
    private BaseSpinnerAdapter<String> endStopAdapter;

    protected ScheduleBuilderViewModel(@NonNull final Context context,
                                       @Nullable final BaseState savedViewState) {
        super(savedViewState);

        final String[] startStops;
        final String[] endStops;

        if (savedViewState instanceof ScheduleBuilderState) {
            final ScheduleBuilderState state = (ScheduleBuilderState) savedViewState;
            startStops = (String[]) state.startStops.toArray();
            endStops = (String[]) state.endStops.toArray();
        } else {
            startStops = new String[]{"a", "b", "c", "d", "e", "f"};
            endStops = new String[]{"1", "2", "3", "4", "5", "6"};
        }

        lineAdapter = new BaseSpinnerAdapter<String>(
                context,
                android.R.layout.simple_list_item_1,
                new String[]{"Hello", "there", "my", "name", "is", "galloom"}) {
        };
        startStopAdapter = new BaseSpinnerAdapter<String>(
                context,
                android.R.layout.simple_list_item_1,
                startStops) {
        };
        endStopAdapter = new BaseSpinnerAdapter<String>(
                context,
                android.R.layout.simple_list_item_1,
                endStops) {
        };
    }

    //region View calling ViewModel methods
    public SpinnerAdapter getLineAdapter() {
        return lineAdapter;
    }

    public SpinnerAdapter getStartStopAdapter() {
        return startStopAdapter;
    }

    public SpinnerAdapter getEndStopAdapter() {
        return endStopAdapter;
    }

    public void swapStartEndStops() {
        BaseSpinnerAdapter<String> tmpAdapter = startStopAdapter;
        startStopAdapter = endStopAdapter;
        endStopAdapter = tmpAdapter;
    }
    //endregion


    //region BaseViewModel methods
    @Override
    public BaseState getViewState() {
        return new ScheduleBuilderState(this);
    }
    //endregion

    private static class ScheduleBuilderState extends BaseState {
        public static final Creator<ScheduleBuilderState> CREATOR = new Creator<ScheduleBuilderState>() {
            public ScheduleBuilderState createFromParcel(Parcel source) {
                return new ScheduleBuilderState(source);
            }

            public ScheduleBuilderState[] newArray(int size) {
                return new ScheduleBuilderState[size];
            }
        };
        private final List<String> startStops;
        private final List<String> endStops;

        protected ScheduleBuilderState(@NonNull ScheduleBuilderViewModel viewModel) {
            super(viewModel);
            startStops = viewModel.startStopAdapter.getListOfObjects();
            endStops = viewModel.endStopAdapter.getListOfObjects();
        }

        protected ScheduleBuilderState(Parcel in) {
            super(in);
            this.startStops = in.createStringArrayList();
            this.endStops = in.createStringArrayList();
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeStringList(this.startStops);
            dest.writeStringList(this.endStops);
        }
    }
}
