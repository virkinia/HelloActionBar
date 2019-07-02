package com.example.helloactionbar;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    private FragmentManager FM ;
    private FragmentTransaction FT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setFragment(new SearchFragment());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment newFragment;
        switch (item.getItemId()) {
            case R.id.action_nuevo:
                Log.i("ActionBar", "Nuevo!");

                Toasty.success(getApplicationContext(), "Success!", Toast.LENGTH_SHORT, true).show();
                newFragment = new NewFragment();

             break;
            case R.id.action_buscar:
                Log.i("ActionBar", "Buscar!");;
                newFragment = new NewFragment();
             break;
            case R.id.action_settings:
                Log.i("ActionBar", "Settings!");;
                newFragment = new SettingsFragment();
             break;
            default:
                return super.onOptionsItemSelected(item);

        }

        this.setFragment(newFragment);
        return true;
    }


    private void setFragment(Fragment newFragment) {
        FM  = getSupportFragmentManager();
        FT = FM.beginTransaction();
        FT.replace(R.id.main_container, newFragment);
        FT.commit();
    }
}
