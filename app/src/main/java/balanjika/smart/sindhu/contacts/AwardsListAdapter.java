package balanjika.smart.sindhu.contacts;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import balanjika.smart.sindhu.smartbalanjka.R;

public class AwardsListAdapter extends BaseAdapter {

    Context context;
    ArrayList<KDListItems> contactList;

    public AwardsListAdapter(Context context, ArrayList<KDListItems> list) {

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
        KDListItems KDListItems = contactList.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.awards, null);

        }
        TextView year = (TextView) convertView.findViewById(R.id.year);
        TextView cbscname1 = (TextView) convertView.findViewById(R.id.cbscname1);
        TextView cbscparents1 = (TextView) convertView.findViewById(R.id.cbscparents1);
        TextView cbscmarks1 = (TextView) convertView.findViewById(R.id.cbscmarks1);
        TextView cbscname2 = (TextView) convertView.findViewById(R.id.section);

        year.setText(KDListItems.getyear());
        cbscname1.setText(KDListItems.getcbsename1());
        cbscparents1 .setText(KDListItems.getcbseparents1());
        cbscmarks1 .setText(KDListItems.getcbsemark1());
        cbscname2 .setText(KDListItems.getSection());
        return convertView;
    }

}
