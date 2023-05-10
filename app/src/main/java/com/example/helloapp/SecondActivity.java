package com.example.helloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static final String CAT = "PMR";

    private void alerter(String s) {
        Log.i(CAT,s);
        Toast t = Toast.makeText(this,s,Toast.LENGTH_LONG);
        t.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle data = this.getIntent().getExtras();
        alerter(data.getString("nom","anonyme"));
        TextView tv2 = findViewById(R.id.txtNom2);
        tv2.setText(data.getString("nom","anonyme"));
    }
}