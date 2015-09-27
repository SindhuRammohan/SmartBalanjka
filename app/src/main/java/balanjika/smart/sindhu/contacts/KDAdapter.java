package balanjika.smart.sindhu.contacts;


import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import balanjika.smart.sindhu.smartbalanjka.R;

public class KDAdapter extends BaseAdapter {

    Context context;
    ArrayList<KDItems> contactList;

    public KDAdapter(Context context, ArrayList<KDItems> list) {

        this.context = context;
        contactList = list;
    }

    @Override
    public int getCount() {

        return contactList.size();
    }

    @Override
    public Object getItem(int position) {

        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup arg2) {
        KDItems KDListItems = contactList.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.kdadaptor, null);

        }
        TextView Venue = (TextView) convertView.findViewById(R.id.Venue);
        TextView Date = (TextView) convertView.findViewById(R.id.Date);
        TextView Time = (TextView) convertView.findViewById(R.id.Time);
        TextView Contact = (TextView) convertView.findViewById(R.id.Contact);
        TextView Specification = (TextView) convertView.findViewById(R.id.Specification);
        TextView others = (TextView) convertView.findViewById(R.id.others);



        Venue.setText(KDListItems.getVenue());
        Date.setText(KDListItems.getDate());
        Time .setText(KDListItems.getTime());
        Contact .setText(KDListItems.getContact());
        Specification .setText(KDListItems.getSpecification());
        others.setText(KDListItems.getothers());

        return convertView;
    }

}
