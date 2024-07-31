package io.objectbox.android;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

/* compiled from: AndroidObjectBrowser.java */
/* renamed from: io.objectbox.android.a, reason: use source file name */
/* loaded from: classes2.dex */
public class AndroidObjectBrowser {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Notification.Builder m9449a(Context context, int i, NotificationManager notificationManager) {
        Notification.Builder builder;
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel("objectbox-browser", "ObjectBox Browser", 3));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            builder = new Notification.Builder(context, "objectbox-browser");
        } else {
            builder = new Notification.Builder(context);
        }
        builder.setContentTitle(context.getString(R.string.objectbox_objectBrowserNotificationTitle)).setContentText(context.getString(R.string.objectbox_objectBrowserNotificationText, Integer.valueOf(i))).setSmallIcon(R.drawable.objectbox_notification);
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Intent m9450a(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        return intent;
    }
}