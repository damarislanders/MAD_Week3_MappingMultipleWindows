package uk.co.damaris.mapping;

import android.preference.PreferenceActivity;
import android.os.Bundle;

/**
 * Created by 3landd22 on 15/02/2018.
 */

public class MyPrefsActivity extends PreferenceActivity
{

    public void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

}
