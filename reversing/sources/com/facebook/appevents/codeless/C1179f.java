package com.facebook.appevents.codeless;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* renamed from: com.facebook.appevents.codeless.f */
/* loaded from: classes.dex */
class ViewIndexingTrigger implements SensorEventListener {

    /* renamed from: a */
    private InterfaceC0869a f1665a;

    /* compiled from: ViewIndexingTrigger.java */
    /* renamed from: com.facebook.appevents.codeless.f$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0869a {
        /* renamed from: a */
        void mo11125a();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void setOnShakeListener(InterfaceC0869a interfaceC0869a) {
        this.f1665a = interfaceC0869a;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.f1665a != null) {
            double d = sensorEvent.values[0] / 9.80665f;
            double d2 = sensorEvent.values[1] / 9.80665f;
            double d3 = sensorEvent.values[2] / 9.80665f;
            if (Math.sqrt((d * d) + (d2 * d2) + (d3 * d3)) > 2.299999952316284d) {
                this.f1665a.mo11125a();
            }
        }
    }
}
