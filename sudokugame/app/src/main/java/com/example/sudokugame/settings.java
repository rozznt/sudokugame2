package com.example.sudokugame;

import com.example.sudokugame.R;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class settings extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.Settings);


    }
}