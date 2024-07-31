package com.senseplay.sdk.activity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.p008v4.app.NotificationCompat;
import android.view.View;
import com.senseplay.control.SPControl;
import com.senseplay.control.SPControlServer;
import com.senseplay.sdk.C2189R;
import com.senseplay.sdk.SPManager;
import com.senseplay.sdk.config.SPVersion;

/* loaded from: classes2.dex */
public class TestActivity extends Activity {

    /* renamed from: id */
    String f6828id = "my_channel_01";
    String name = "我是渠道名字";
    Notification notification;
    SPControl spControl;
    SPControlServer spControlServer;

    public void testP1(View view) {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2189R.layout.sp_activity_test);
        SPManager.getInstance().init(this);
        SPManager.getInstance().setClient("44E7F9DC2DE558BFBC5D808E38267589", "");
        SPVersion.setVerType(SPVersion.v_test);
    }

    public void testP(View view) {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel(this.f6828id, this.name, 3));
            this.notification = new Notification.Builder(this).setChannelId(this.f6828id).setContentTitle("5 new messages").setContentText("hahaha").setSmallIcon(C2189R.mipmap.ic_launcher).build();
        } else {
            this.notification = new NotificationCompat.Builder(this).setContentTitle("5 new messages").setContentText("hahaha").setSmallIcon(C2189R.mipmap.ic_launcher).setOngoing(true).build();
        }
        notificationManager.notify(111123, this.notification);
    }
}
