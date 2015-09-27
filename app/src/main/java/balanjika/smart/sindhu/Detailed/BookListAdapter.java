package balanjika.smart.sindhu.Detailed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import balanjika.smart.sindhu.smartbalanjka.R;


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
        View rowView = convertView;
        try {
            if (rowView == null) {
                LayoutInflater inflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                rowView = inflater.inflate(R.layout.book_adaptor, parent, false);
            }
            TextView book_name = (TextView) rowView.findViewById(R.id.book_name);
            book_name.setText(values[position] + ".pdf");
            String[] valuesbook = context.getResources().getStringArray(R.array.bookArrayString);
            int identifier = context.getResources().getIdentifier(valuesbook[position], "drawable", context.getPackageName());

            ImageView bookimageView = (ImageView) rowView.findViewById(R.id.bookimageView);
            bookimageView.setImageResource(identifier);

            return rowView;
        }catch (Exception e) {

        }
        return rowView;
    }
}