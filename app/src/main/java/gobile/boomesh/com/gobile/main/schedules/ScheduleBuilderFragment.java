package gobile.boomesh.com.gobile.main.schedules;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import butterknife.Bind;
import butterknife.OnClick;
import gobile.boomesh.com.gobile.R;
import gobile.boomesh.com.gobile.base.viewmodel.BaseViewModel;
import gobile.boomesh.com.gobile.main.BaseMainPageFragment;

/**
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

    public static ScheduleBuilderFragment newInstance() {

        final Bundle args = new Bundle();

        final ScheduleBuilderFragment fragment = new ScheduleBuilderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final SpinnerAdapter linesAdapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                new String[]{"Hello", "there", "my", "name", "is", "galloom"});
        final SpinnerAdapter startStopsAdapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                new String[]{"a", "b", "c", "d", "e", "f"});
        final SpinnerAdapter endStopsAdapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                new String[]{"1", "2", "3", "4", "5", "6"});

        lineSpinner.setAdapter(linesAdapter);
        startSpinner.setAdapter(startStopsAdapter);
        endSpinner.setAdapter(endStopsAdapter);
    }

    //region ButterKnife methods
    @OnClick(R.id.switch_start_end_btn)
    void onSwitchStopsButtonClicked() {
        final SpinnerAdapter startAdapter = startSpinner.getAdapter();
        final SpinnerAdapter endAdapter = endSpinner.getAdapter();

        endSpinner.setAdapter(startAdapter);
        startSpinner.setAdapter(endAdapter);
    }
    //endregion


    //region BaseMainPageFragment methods

    @Override
    public int getTabIcon() {
        return R.drawable.ic_directions_transit_white;
    }

    @Nullable
    @Override
    protected BaseViewModel createViewModel(@Nullable BaseViewModel.BaseState savedViewModelState) {
        //TODO: for now
        return null;
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
