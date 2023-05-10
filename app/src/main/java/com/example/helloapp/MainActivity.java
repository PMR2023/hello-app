package com.example.helloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String CAT = "PMR";
    private Button btnOK;
    private EditText txtPseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alerter("onCreate");
        btnOK = findViewById(R.id.btnOK);
        txtPseudo = findViewById(R.id.txtPseudo);

        /*btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alerter("click 2");
            }
        });*/
        btnOK.setOnClickListener(this);
        txtPseudo.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        alerter("onStart");
    }

    private void alerter(String s) {
        Log.i(CAT,s);
        Toast t = Toast.makeText(this,s,Toast.LENGTH_LONG);
        t.show();
    }


    public void foo(View view) {
        alerter("click !");
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnOK) {
                alerter("click click click");
        }
        if (view.getId() == R.id.txtPseudo) {
            alerter("saisir votre nom");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            alerter("préférences");
        }

        return super.onOptionsItemSelected(item);
    }


}