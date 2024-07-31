package com.senseplay.control;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/* loaded from: classes2.dex */
public class ControlService extends Service {
    private static final String TAG = "ControlService";
    private final MBinder mBinder = new MBinder();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        logE("onBind()");
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        logE("onCreate()");
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        logE("onStartCommand()");
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        logE("onUnbind()");
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        logE("onDestroy()");
        super.onDestroy();
    }

    private static void logE(String str) {
        Log.e(TAG, "--------" + str + "--------");
    }
}
