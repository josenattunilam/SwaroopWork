package com.example.jose.swaroopwork;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.jose.swaroopwork.fragments.AddSensorFragment;
import com.example.jose.swaroopwork.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,HomeFragment.OnFragmentInteractionListener,AddSensorFragment.OnFragmentInteractionListener {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialise();
        homeFragment();
    }

    private void initialise() {
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                homeFragment();
                break;
            case R.id.addsensor:
                addSensorFragment();
                break;
            case R.id.logout:
                logout();
                break;
        }
        return true;
    }

    private void logout() {
        finish();
        Intent logIntent = new Intent(getApplicationContext(),Login.class);
        startActivity(logIntent);
    }

    private void addSensorFragment() {
        FragmentManager fragManagerAddSensor = getSupportFragmentManager();
        AddSensorFragment addSensorFragment = new AddSensorFragment();
        FragmentTransaction fragTransactionAddSensor = fragManagerAddSensor.beginTransaction();
        fragTransactionAddSensor.replace(R.id.container,addSensorFragment,"addSensorFragment");
        fragTransactionAddSensor.commit();
    }

    private void homeFragment() {
        FragmentManager fragManagerHome = getSupportFragmentManager();
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragTransactionHome = fragManagerHome.beginTransaction();
        fragTransactionHome.replace(R.id.container,homeFragment,"homeFragment");
        fragTransactionHome.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
