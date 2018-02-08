package uk.co.damaris.mapping;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

/**
 * Created by 3landd22 on 08/02/2018.
 */

public class MapChooseActivity extends AppCompatActivity implements View.OnClickListener
{

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_choose);

        Button regular = (Button)findViewById(R.id.btnRegular);
        regular.setOnClickListener(this);


        Button hikebike = (Button)findViewById(R.id.btnHikeBikeMap);
        hikebike.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        boolean hikebike = false;
        if (view.getId()==R.id.btnHikeBikeMap)
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
