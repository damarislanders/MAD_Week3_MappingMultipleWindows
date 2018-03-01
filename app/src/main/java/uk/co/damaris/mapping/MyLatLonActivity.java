package uk.co.damaris.mapping;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

/**
 * Created by 3landd22 on 21/02/2018.
 */

public class MyLatLonActivity extends AppCompatActivity implements View.OnClickListener
{

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lat_lon_set);

        Button b = (Button)findViewById(R.id.goButton);
        b.setOnClickListener(this);

    }

    public void onClick(View view) {

        EditText et_lat = (EditText)findViewById(R.id.latitudeEditText);
        EditText et_lon = (EditText)findViewById(R.id.longitudeEditText);

        double latitude = Double.parseDouble(et_lat.getText().toString());
        double longitude = Double.parseDouble(et_lon.getText().toString());

        //Creating the bundle
        Bundle bundle = new Bundle();
        bundle.putDouble("lat", latitude);
        bundle.putDouble("lon", longitude);

        //Adding the bundle
        Intent intent = new Intent();
        intent.putExtras(bundle);

        //Fire off the intent
        setResult(RESULT_OK,intent);
        finish();

    }

}
