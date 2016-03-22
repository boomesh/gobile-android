package gobile.boomesh.com.gobile.base.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sumesh on 1/9/16.
 */
public abstract class BaseSpinnerAdapter<T> extends ArrayAdapter<T> {

    @NonNull
    private final List<T> listOfObjects;

    public BaseSpinnerAdapter(Context context, int resource, int textViewResourceId, @NonNull final T[] objects) {
        super(context, resource, textViewResourceId, objects);
        listOfObjects = Arrays.asList(objects);
    }

    public BaseSpinnerAdapter(Context context, int resource, int textViewResourceId, @NonNull final List<T> objects) {
        super(context, resource, textViewResourceId, objects);
        listOfObjects = objects;
    }

    public BaseSpinnerAdapter(Context context, int resource, @NonNull final List<T> objects) {
        super(context, resource, objects);
        listOfObjects = objects;
    }

    public BaseSpinnerAdapter(Context context, int resource, @NonNull final T[] objects) {
        super(context, resource, objects);
        listOfObjects = Arrays.asList(objects);
    }

    /**
     * Fetch the data associated with the spinner
     *
     * @return data associated with spinner adapter
     */
    @NonNull
    public List<T> getListOfObjects() {
        return listOfObjects;
    }
}
