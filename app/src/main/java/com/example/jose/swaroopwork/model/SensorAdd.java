package com.example.jose.swaroopwork.model;

/**
 * Created by HP on 23-10-2017.
 */

public class SensorAdd {
    String sensorName;
    int sensorId;

    public SensorAdd(String sensorName, int sensorId) {
        this.sensorName = sensorName;
        this.sensorId = sensorId;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }
}
