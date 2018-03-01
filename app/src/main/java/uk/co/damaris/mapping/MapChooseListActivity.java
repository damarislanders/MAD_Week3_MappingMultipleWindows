package uk.co.damaris.mapping;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by 3landd22 on 01/03/2018.
 */

public class MapChooseListActivity extends ListActivity {

    String[] names, details;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        names = new String[] { "Regular", "Hike/Bike" };
        details = new String[] { "Map for walkers", "Map for bike trails and walking" };
        MyAdapter adapter = new MyAdapter();
        setListAdapter(adapter);
    }

    public void onListItemClick(ListView lv, View view, int index, long id)
    {
        // handle list item selection
    }


    public class MyAdapter extends ArrayAdapter<String>
    {
        public MyAdapter()
        {
            // We have to use ExampleListActivity.this to refer to the outer class (the activity)
            super(MapChooseListActivity.this, android.R.layout.simple_list_item_1, names);
        }

        public View getView(int index, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.poientry, parent, false);
            TextView title = (TextView)view.findViewById(R.id.poi_name), detail =
                    (TextView)view.findViewById(R.id.poi_desc);
            title.setText(names[index]);
            detail.setText(details[index]);
            return view;
        }
    }


}
