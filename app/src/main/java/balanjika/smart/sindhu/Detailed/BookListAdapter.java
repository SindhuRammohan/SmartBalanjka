package balanjika.smart.sindhu.Detailed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import balanjika.smart.sindhu.smartbalanjka.R;

/**
 * Created by rajesh on 07-09-2015.
 */
public class BookListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public BookListAdapter(Context context, String[] values) {
        super(context, R.layout.book_adaptor, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.book_adaptor, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.book_name);
        textView.setText(values[position]);
        return rowView;
    }
}