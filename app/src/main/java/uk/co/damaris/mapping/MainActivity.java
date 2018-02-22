package uk.co.damaris.mapping;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity implements OnClickListener
{

    /****** GLOBAL VARIABLES ******/
    MapView mv;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        // This line sets the user agent, a requirement to download OSM maps
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

        setContentView(R.layout.activity_main);

        mv = (MapView)findViewById(R.id.map1);


        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(16);
        mv.getController().setCenter(new GeoPoint(50.9115,-1.4156));

        /*
        Button b = (Button)findViewById(R.id.goButton);
        b.setOnClickListener(this);
        */
    }

    public void onClick(View view) {

        mv = (MapView)findViewById(R.id.map1);
        EditText et_lat = (EditText)findViewById(R.id.latitudeEditText);
        EditText et_lon = (EditText)findViewById(R.id.longitudeEditText);

        double latitude = Double.parseDouble(et_lat.getText().toString());
        double longitude = Double.parseDouble(et_lon.getText().toString());

        // This line sets the user agent, a requirement to download OSM maps
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

        mv.getController().setCenter(new GeoPoint(latitude,longitude));

    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.choosemap)
        {
            // react to the menu item being selected...
            Intent intent = new Intent(this, MapChooseActivity.class);
            startActivityForResult(intent,0);
            return true;

        } else if (item.getItemId() == R.id.setlatlon) {

            Intent intent = new Intent(this, MyLatLonActivity.class);
            startActivityForResult(intent,1);
            return true;

        } else if (item.getItemId() == R.id.preferences) {

            Intent intent = new Intent(this, MyPrefsActivity.class);
            startActivityForResult(intent,2);
            return true;

        }
        return false;
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent intent)
    {
        if(requestCode==0)
        {
            if (resultCode==RESULT_OK)
            {
                Bundle extras=intent.getExtras();
                boolean hikebike = extras.getBoolean("com.example.hikebikemap");

                if(hikebike==true)
                {
                    mv.setTileSource(TileSourceFactory.HIKEBIKEMAP);
                }
                else
                {
                    mv.setTileSource(TileSourceFactory.MAPNIK);
                }


            }
        }
        else if (requestCode == 1)
        {
            if (resultCode == RESULT_OK)
            {
                Bundle bundle =intent.getExtras();
                double lat = bundle.getDouble("lat");
                double lon = bundle.getDouble("lon");
                mv.getController().setCenter(new GeoPoint(lat,lon));

            }

        }
    }

    public void onStart()
    {
        super.onStart();

        //new AlertDialog.Builder(this).setPositiveButton("OK", null).setMessage("onStart() called").show();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        double lat = Double.parseDouble ( prefs.getString("lat", "50.9") );
        double lon = Double.parseDouble ( prefs.getString("lon", "-1.4") );
        int zoom = Integer.parseInt ( prefs.getString("zoom", "16"));
        boolean autodownload = prefs.getBoolean("autodownload", true);
        //String pizzaCode = prefs.getString("pizza", "NONE");

        // do something with the preference data...
    }

    public void onStop()
    {
        super.onStop();
        //Toast.makeText(this, "onStop() called", Toast.LENGTH_SHORT).show();
    }





}
