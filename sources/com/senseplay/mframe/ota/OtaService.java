package com.senseplay.mframe.ota;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.p008v4.app.NotificationCompat;
import android.util.Log;
import com.senseplay.mframe.client.MCallBack;
import java.util.Date;

/* loaded from: classes2.dex */
public class OtaService extends Service {
    private OtaHttp otaHttp;

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        doSomething();
        ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).set(2, SystemClock.elapsedRealtime() + 14400000, PendingIntent.getBroadcast(this, 0, new Intent(this, OtaServiceReceiver.class), 0));
        return super.onStartCommand(intent, i, i2);
    }

    private void doSomething() {
        Log.d("OtaService", "executed at " + new Date().toString());
        if (this.otaHttp == null) {
            this.otaHttp = new OtaHttp(this);
        }
        this.otaHttp.checkVersion("", "", "", "", "", new MCallBack<OtaInfo>() { // from class: com.senseplay.mframe.ota.OtaService.1
            @Override // com.senseplay.mframe.client.MCallBack
            public void onResult(OtaInfo otaInfo) {
                OtaService.this.notifyfication(otaInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyfication(OtaInfo otaInfo) {
        if (otaInfo == null) {
            return;
        }
        OtaNotification.sendNotification(this, 1, "", "");
    }
}
