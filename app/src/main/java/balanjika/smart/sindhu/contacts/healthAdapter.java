package balanjika.smart.sindhu.contacts;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import balanjika.smart.sindhu.smartbalanjka.R;

public class healthAdapter extends BaseAdapter {

    Context context;
    ArrayList<HealthItems> contactList;

    public healthAdapter(Context context, ArrayList<HealthItems> list) {
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
        HealthItems contactListItems = contactList.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.health_tips, null);

        }
        TextView healthtips = (TextView) convertView.findViewById(R.id.healthtips);
        healthtips.setText(contactListItems.getTitle());

        TextView healthtitle = (TextView) convertView.findViewById(R.id.healthtitle);
        healthtitle.setText(contactListItems.getIngredients());

        TextView date = (TextView) convertView.findViewById(R.id.date);
        date.setText(contactListItems.getTime());

        TextView directions = (TextView) convertView.findViewById(R.id.directions);
        directions.setText(contactListItems.getDirection());

        return convertView;
    }

}