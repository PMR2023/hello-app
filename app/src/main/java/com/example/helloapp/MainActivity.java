package com.example.helloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
    private Button btnSearch;
    private EditText txtPseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alerter("onCreate");
        btnOK = findViewById(R.id.btnOK);
        txtPseudo = findViewById(R.id.txtPseudo);
        btnSearch = findViewById(R.id.btnSearch);

        /*btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alerter("click 2");
            }
        });*/
        btnOK.setOnClickListener(this);
        txtPseudo.setOnClickListener(this);
        btnSearch.setOnClickListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        alerter("onStart");
        @SuppressWarnings("deprecation") SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (prefs.getBoolean("remember",false)) {
            txtPseudo.setText(prefs.getString("login",""));

        }
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
        alerter("ici");
        if (view.getId() == R.id.btnOK) {
            if (txtPseudo.getText().toString().isEmpty()) return;
            Intent toSecond = new Intent(this,SecondActivity.class);
            Bundle bdlData = new Bundle();
            bdlData.putString("nom", txtPseudo.getText().toString());
            toSecond.putExtras(bdlData);
            startActivity(toSecond);
        } else if (view.getId() == R.id.txtPseudo) {
            alerter("saisir votre nom");
        } else if (view.getId() == R.id.btnSearch) {
            String query = txtPseudo.getText().toString();
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, query);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

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
            alerter("preferences");
            Intent toPref= new Intent(this,PrefActivity.class);
            startActivity(toPref);

        } else if (id == R.id.action_account) {
            alerter("compte");
        }

        return super.onOptionsItemSelected(item);
    }


}