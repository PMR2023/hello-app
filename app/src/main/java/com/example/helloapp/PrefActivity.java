package com.example.helloapp;

import android.preference.PreferenceActivity;

public class PrefActivity extends PreferenceActivity {

    @Override
    protected void onStart() {
        super.onStart();
        //noinspection deprecation
        addPreferencesFromResource(R.xml.preferences);
    }
}
