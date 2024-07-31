package com.navatics.app.framework.network.p056a;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.p008v4.app.NotificationCompat;
import com.navatics.app.framework.R;
import org.apache.log4j.C3044k;

/* compiled from: NotificationUtils.java */
/* renamed from: com.navatics.app.framework.network.a.b */
/* loaded from: classes.dex */
public class C1838b {

    /* renamed from: a */
    private static final C3044k f4732a = C3044k.m1564a(C1838b.class);

    /* renamed from: a */
    public static void m7975a(Context context, Intent intent, int i) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        long currentTimeMillis = System.currentTimeMillis();
        String m7974b = m7974b(context, R.string.ftp_notif_title);
        String format = String.format(m7974b(context, R.string.ftp_notif_text), ConnectionUtils.m7978d(context));
        String m7974b2 = m7974b(context, R.string.ftp_notif_starting);
        String m7974b3 = m7974b(context, R.string.ftp_notif_stop_server);
        Intent intent2 = new Intent();
        intent2.setAction("com.navatics.app.framework.FTP_ICON_CLICKED");
        if (intent.getExtras() != null) {
            intent2.putExtras(intent.getExtras());
        }
        intent2.setFlags(603979776);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent2, 0);
        Intent intent3 = new Intent("com.navatics.app.framework.action.STOP_FTPSERVER");
        if (intent.getExtras() != null) {
            intent3.putExtras(intent.getExtras());
        }
        notificationManager.notify(i, new NotificationCompat.Builder(context).setContentTitle(m7974b).setContentText(format).setContentIntent(activity).setSmallIcon(R.drawable.ic_stat_server).setTicker(m7974b2).setWhen(currentTimeMillis).setOngoing(true).setColor(context.getResources().getColor(R.color.defaultColor)).setVisibility(1).setCategory(NotificationCompat.CATEGORY_SERVICE).setPriority(2).addAction(R.drawable.ic_action_stop, m7974b3, PendingIntent.getBroadcast(context, 0, intent3, 1073741824)).setShowWhen(false).build());
        f4732a.mo1511a((Object) "Notification has sent");
    }

    /* renamed from: a */
    public static void m7976a(Context context, int i) {
        ((NotificationManager) context.getSystemService("notification")).cancel(i);
    }

    /* renamed from: b */
    private static String m7974b(Context context, int i) {
        return context.getResources().getString(i);
    }
}
