package com.facebook.appevents.codeless;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* compiled from: ViewIndexingTrigger.java */
/* renamed from: com.facebook.appevents.codeless.f, reason: use source file name */
/* loaded from: classes.dex */
class ViewIndexingTrigger implements SensorEventListener {

    /* renamed from: a */
    private a f1671a;

    /* compiled from: ViewIndexingTrigger.java */
    /* renamed from: com.facebook.appevents.codeless.f$a */
    /* loaded from: classes.dex */
    public interface a {
        /* renamed from: a */
        void mo1803a();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void setOnShakeListener(a aVar) {
        this.f1671a = aVar;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.f1671a != null) {
            double d = sensorEvent.values[0] / 9.80665f;
            double d2 = sensorEvent.values[1] / 9.80665f;
            double d3 = sensorEvent.values[2] / 9.80665f;
            if (Math.sqrt((d * d) + (d2 * d2) + (d3 * d3)) > 2.299999952316284d) {
                this.f1671a.mo1803a();
            }
        }
    }
}