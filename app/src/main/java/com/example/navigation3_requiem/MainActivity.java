package com.example.navigation3_requiem;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CreatListe();
    }

    public void CreatListe()
    {
        //Association de la vue avec son instance.
        ListView maListe = (ListView) findViewById(R.id.maListe);
        //Instance de l'objet ressource.
        Resources res = getResources();
        //Tableau de chaines.
        String[] tChaines = res.getStringArray(R.array.lesGachas);
        //Remplir l'adaptateur
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,tChaines);
        //Lier les données à la liste.
        maListe.setAdapter(adapter);

        maListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("ItemList","Position : "+position+" Nom : "+tChaines[position]);

                //LA NAVIGATION !!!
                final String EXTRA_GACHA="gacha";

                //Préparation de la navigation.
                Intent monIntent = new Intent(MainActivity.this,Gacha.class);
                monIntent.putExtra(EXTRA_GACHA,tChaines[position]);

                //Navigation
                startActivity(monIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}