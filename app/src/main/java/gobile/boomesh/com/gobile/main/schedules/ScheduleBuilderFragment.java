package gobile.boomesh.com.gobile.main.schedules;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Spinner;

import butterknife.Bind;
import butterknife.OnClick;
import gobile.boomesh.com.gobile.R;
import gobile.boomesh.com.gobile.base.viewmodel.BaseViewModel;
import gobile.boomesh.com.gobile.main.BaseMainPageFragment;

/**
 * Fragment class for the schedule builder tab.  View configuring logic should sit here and the
 * xml.
 * <p>
 * Created by sumesh on 1/5/16.
 */
public class ScheduleBuilderFragment extends BaseMainPageFragment {
    private static final String TAG = ScheduleBuilderFragment.class.getSimpleName();

    @Bind(R.id.line_spinner)
    Spinner lineSpinner;
    @Bind(R.id.start_spinner)
    Spinner startSpinner;
    @Bind(R.id.end_spinner)
    Spinner endSpinner;
    private ScheduleBuilderViewModel viewModel;

    public static ScheduleBuilderFragment newInstance() {

        final Bundle args = new Bundle();

        final ScheduleBuilderFragment fragment = new ScheduleBuilderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lineSpinner.setAdapter(viewModel.getLineAdapter());
        startSpinner.setAdapter(viewModel.getStartStopAdapter());
        endSpinner.setAdapter(viewModel.getEndStopAdapter());
    }

    //region ButterKnife methods
    @OnClick(R.id.switch_start_end_btn)
    void onSwitchStopsButtonClicked() {
        viewModel.swapStartEndStops();
        endSpinner.setAdapter(viewModel.getEndStopAdapter());
        startSpinner.setAdapter(viewModel.getStartStopAdapter());
    }
    //endregion


    //region BaseMainPageFragment methods

    @Override
    public int getTabIcon() {
        return R.drawable.ic_directions_transit_white;
    }

    @Nullable
    @Override
    protected BaseViewModel createViewModel(@Nullable final BaseViewModel.BaseState savedViewModelState) {
        viewModel = new ScheduleBuilderViewModel(getContext(), savedViewModelState);
        return viewModel;
    }


    @NonNull
    @Override
    public String getFragmentTag() {
        return TAG;
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_schedule_builder;
    }

    //endregion
}
