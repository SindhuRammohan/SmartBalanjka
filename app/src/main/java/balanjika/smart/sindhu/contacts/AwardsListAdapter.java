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
        TextView cbscname2 = (TextView) convertView.findViewById(R.id.cbscname2);
        TextView cbscparents2 = (TextView) convertView.findViewById(R.id.cbscparents2);
        TextView cbscmarks2 = (TextView) convertView.findViewById(R.id.cbscmarks2);
        TextView cbscname3 = (TextView) convertView.findViewById(R.id.cbscname3);
        TextView cbscmarks3 = (TextView) convertView.findViewById(R.id.cbscmarks3);
        TextView cbscparents3 = (TextView) convertView.findViewById(R.id.cbscparents3);
        TextView hscname1 = (TextView) convertView.findViewById(R.id.hscname1);
        TextView hscparents1 = (TextView) convertView.findViewById(R.id.hscparents1);
        TextView hscmarks1 = (TextView) convertView.findViewById(R.id.hscmarks1);
        TextView hscname2 = (TextView) convertView.findViewById(R.id.hscname2);
        TextView hscparents2 = (TextView) convertView.findViewById(R.id.hscparents2);
        TextView hscmarks2 = (TextView) convertView.findViewById(R.id.hscmarks2);
        TextView hscname3 = (TextView) convertView.findViewById(R.id.hscname3);
        TextView hscparents3 = (TextView) convertView.findViewById(R.id.hscparents3);
        TextView hscmarks3 = (TextView) convertView.findViewById(R.id.hscmarks3);
        TextView matricparents1 = (TextView) convertView.findViewById(R.id.matricparents1);
        TextView matricname1 = (TextView) convertView.findViewById(R.id.matricname1);
        TextView matricmarks1 = (TextView) convertView.findViewById(R.id.matricmarks1);
        TextView matricname2 = (TextView) convertView.findViewById(R.id.matricname2);
        TextView matricparents2 = (TextView) convertView.findViewById(R.id.matricparents2);
        TextView matricmarks2 = (TextView) convertView.findViewById(R.id.matricmarks2);
        TextView matricname3 = (TextView) convertView.findViewById(R.id.matricname3);
        TextView matricparents3 = (TextView) convertView.findViewById(R.id.matricparents3);
        TextView matricmarks3 = (TextView) convertView.findViewById(R.id.matricmarks3);

        year.setText(KDListItems.getyear());
        cbscname1.setText(KDListItems.getcbsename1());
        cbscparents1 .setText(KDListItems.getcbseparents1());
        cbscmarks1 .setText(KDListItems.getcbsemark1());
        cbscname2 .setText(KDListItems.getcbsename2());
        cbscparents2.setText(KDListItems.getcbseparents2());
        cbscmarks2 .setText(KDListItems.getcbsemark2());
        cbscname3 .setText(KDListItems.getcbsename3());
        cbscparents3 .setText(KDListItems.getcbseparents3());
        cbscmarks3.setText(KDListItems.getcbsemark3());
        hscname1 .setText(KDListItems.gettw_name1());
        hscparents1 .setText(KDListItems.gettw_parents1());
        hscmarks1 .setText(KDListItems.gettw_mark1());
        hscname2.setText(KDListItems.gettw_name2());
        hscparents2 .setText(KDListItems.gettw_parents2());
        hscmarks2 .setText(KDListItems.gettw_mark2());
        hscname3 .setText(KDListItems.gettw_name3());
        hscparents3.setText(KDListItems.gettw_parents3());
        hscmarks3 .setText(KDListItems.gettw_mark3());
        matricname1.setText(KDListItems.gette_name1());
        matricparents1.setText(KDListItems.gette_parents1());
        matricmarks1.setText(KDListItems.gette_mark1());
        matricname2.setText(KDListItems.gette_name2());
        matricparents2.setText(KDListItems.gette_parents2());
        matricmarks2 .setText(KDListItems.gette_mark2());
        matricname3 .setText(KDListItems.gette_name3());
        matricparents3.setText(KDListItems.gette_parents3());
        matricmarks3 .setText(KDListItems.gette_mark3());
        return convertView;
    }

}
