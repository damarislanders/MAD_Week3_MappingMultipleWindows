package uk.co.damaris.mapping;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by 3landd22 on 01/03/2018.
 */

public class MapChooseListActivity extends ListActivity {

    String[] mapTypes;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mapTypes = new String[] { "Regular", "Hike/Bike" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mapTypes);
        setListAdapter(adapter);

    }

    public void onListItemClick(ListView lv, View view, int index, long id)
    {
        // handle list item selection
        boolean hikebike = false;
        if (index == 1)
        {
            hikebike=true;
        }

        Intent returnIntent = new Intent();
        Bundle bundle = new Bundle();

        bundle.putBoolean("com.example.hikebikemap",hikebike);
        returnIntent.putExtras(bundle);
        setResult(RESULT_OK, returnIntent);
        finish();
    }


}
