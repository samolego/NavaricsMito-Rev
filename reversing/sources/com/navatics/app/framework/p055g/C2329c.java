package com.navatics.app.framework.p055g;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.support.p008v4.app.NotificationCompat;

/* renamed from: com.navatics.app.framework.g.c */
/* loaded from: classes.dex */
public class NotificationUtils extends ContextWrapper {

    /* renamed from: a */
    private NotificationManager f4681a;

    public NotificationUtils(Context context) {
        super(context);
    }

    @TargetApi(26)
    /* renamed from: a */
    public void m8077a() {
        m8075b().createNotificationChannel(new NotificationChannel("channel_1", "channel_name_1", 4));
    }

    /* renamed from: b */
    private NotificationManager m8075b() {
        if (this.f4681a == null) {
            this.f4681a = (NotificationManager) getSystemService("notification");
        }
        return this.f4681a;
    }

    @TargetApi(26)
    /* renamed from: a */
    public Notification.Builder m8076a(String str, String str2) {
        return new Notification.Builder(getApplicationContext(), "channel_1").setContentTitle(str).setContentText(str2).setSmallIcon(17301625).setAutoCancel(true);
    }

    /* renamed from: b */
    public NotificationCompat.Builder m8074b(String str, String str2) {
        return new NotificationCompat.Builder(getApplicationContext()).setContentTitle(str).setContentText(str2).setSmallIcon(17301625).setAutoCancel(true);
    }

    /* renamed from: c */
    public void m8073c(String str, String str2) {
        if (Build.VERSION.SDK_INT >= 26) {
            m8077a();
            m8075b().notify(1, m8076a(str, str2).build());
            return;
        }
        m8075b().notify(1, m8074b(str, str2).build());
    }
}
