package com.senseplay.mframe.ota;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* loaded from: classes2.dex */
public class OtaNotification {

    /* renamed from: id */
    private static final int f6824id = 10012;

    public static void sendNotification(Context context, Class cls, int i, String str, String str2) {
        Notification build;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        PendingIntent activity = PendingIntent.getActivity(context, 0, new Intent(context, cls), 0);
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel("ota_nofi_id", "ota_nifi_name", 3));
            build = new Notification.Builder(context, "ota_nofi_id").setContentTitle(str).setContentText(str2).setSmallIcon(i).setContentIntent(activity).build();
        } else {
            build = new Notification.Builder(context).setContentTitle(str).setContentText(str2).setSmallIcon(i).setDefaults(1).setContentIntent(activity).build();
        }
        build.flags = 16;
        notificationManager.notify(f6824id, build);
    }

    public static void sendNotification(Context context, int i, String str, String str2) {
        Notification build;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel("ota_nofi_id", "ota_nifi_name", 3));
            build = new Notification.Builder(context, "ota_nofi_id").setContentTitle(str).setContentText(str2).setSmallIcon(i).build();
        } else {
            build = new Notification.Builder(context).setContentTitle(str).setContentText(str2).setSmallIcon(i).setDefaults(1).build();
        }
        build.flags = 16;
        notificationManager.notify(f6824id, build);
    }
}
