package com.example.jose.swaroopwork;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<ModelLatLog> latLogList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        LatLondAdd();



    }

    private void LatLondAdd() {
        ModelLatLog modelLatLog = new ModelLatLog(-34,155,"first");
        latLogList.add(modelLatLog);
        modelLatLog = new ModelLatLog(-34,158,"second");
        latLogList.add(modelLatLog);
        modelLatLog = new ModelLatLog(-34,160,"third");
        latLogList.add(modelLatLog);
        modelLatLog = new ModelLatLog(-34,165,"forth");
        latLogList.add(modelLatLog);
        modelLatLog = new ModelLatLog(-34,170,"fifth");
        latLogList.add(modelLatLog);
        modelLatLog = new ModelLatLog(-34,180,"sixth");
        latLogList.add(modelLatLog);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        for(int i = 0 ; i < latLogList.size() ; i++ ) {

            createMarker(latLogList.get(i).getLattitude(), latLogList.get(i).getLongitude(), latLogList.get(i).getTitle());
        }

        // Add a marker in Sydney and move the camera
      /*  LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));*/
        LatLng sydney = new LatLng(latLogList.get(1).getLattitude(),latLogList.get(1).getLongitude());
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }




    protected Marker createMarker(double latitude, double longitude, String title) {

        return mMap.addMarker(new MarkerOptions()
                .position(new LatLng(latitude, longitude))
                .anchor(0.5f, 0.5f)
                .title(title));


    }
}
