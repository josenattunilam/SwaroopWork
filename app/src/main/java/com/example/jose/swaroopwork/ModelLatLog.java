package com.example.jose.swaroopwork;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by HP on 20-10-2017.
 */

public class ModelLatLog {
   int lattitude;
    int longitude;
    String title;

    public ModelLatLog(int lattitude, int longitude, String title) {
        this.lattitude = lattitude;
        this.longitude = longitude;
        this.title = title;
    }

    public int getLattitude() {
        return lattitude;
    }

    public void setLattitude(int lattitude) {
        this.lattitude = lattitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
