package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.p008v4.content.LocalBroadcastManager;
import com.facebook.appevents.InternalAppEventsLogger;

/* loaded from: classes.dex */
public class BoltsMeasurementEventListener extends BroadcastReceiver {

    /* renamed from: a */
    private static BoltsMeasurementEventListener f1880a;

    /* renamed from: b */
    private Context f1881b;

    private BoltsMeasurementEventListener(Context context) {
        this.f1881b = context.getApplicationContext();
    }

    /* renamed from: a */
    private void m10823a() {
        LocalBroadcastManager.getInstance(this.f1881b).registerReceiver(this, new IntentFilter("com.parse.bolts.measurement_event"));
    }

    /* renamed from: b */
    private void m10821b() {
        LocalBroadcastManager.getInstance(this.f1881b).unregisterReceiver(this);
    }

    /* renamed from: a */
    public static BoltsMeasurementEventListener m10822a(Context context) {
        BoltsMeasurementEventListener boltsMeasurementEventListener = f1880a;
        if (boltsMeasurementEventListener != null) {
            return boltsMeasurementEventListener;
        }
        f1880a = new BoltsMeasurementEventListener(context);
        f1880a.m10823a();
        return f1880a;
    }

    protected void finalize() throws Throwable {
        try {
            m10821b();
        } finally {
            super.finalize();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(context);
        String str = "bf_" + intent.getStringExtra("event_name");
        Bundle bundleExtra = intent.getBundleExtra("event_args");
        Bundle bundle = new Bundle();
        for (String str2 : bundleExtra.keySet()) {
            bundle.putString(str2.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String) bundleExtra.get(str2));
        }
        internalAppEventsLogger.m11060a(str, bundle);
    }
}
