package com.senseplay.sdk.zxing.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.senseplay.sdk.zxing.camera.CameraManager;

/* loaded from: classes2.dex */
public final class AmbientLightManager implements SensorEventListener {
    private static final float BRIGHT_ENOUGH_LUX = 450.0f;
    private static final float TOO_DARK_LUX = 45.0f;
    private CameraManager cameraManager;
    private final Context context;
    private Sensor lightSensor;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public AmbientLightManager(Context context) {
        this.context = context;
    }

    public void start(CameraManager cameraManager) {
        this.cameraManager = cameraManager;
        SensorManager sensorManager = (SensorManager) this.context.getSystemService("sensor");
        this.lightSensor = sensorManager.getDefaultSensor(5);
        Sensor sensor = this.lightSensor;
        if (sensor != null) {
            sensorManager.registerListener(this, sensor, 3);
        }
    }

    public void stop() {
        if (this.lightSensor != null) {
            ((SensorManager) this.context.getSystemService("sensor")).unregisterListener(this);
            this.cameraManager = null;
            this.lightSensor = null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        CameraManager cameraManager = this.cameraManager;
        if (cameraManager != null) {
            if (f <= TOO_DARK_LUX) {
                cameraManager.setTorch(true);
            } else if (f >= BRIGHT_ENOUGH_LUX) {
                cameraManager.setTorch(false);
            }
        }
    }
}
