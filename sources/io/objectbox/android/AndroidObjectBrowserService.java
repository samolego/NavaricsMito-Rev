package io.objectbox.android;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import javax.annotation.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes2.dex */
public class AndroidObjectBrowserService extends Service {
    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if ("objectBox_objectBrowserStop".equals(intent.getAction())) {
            Log.d("ObjectBrowserService", "Stopping");
            stopForeground(true);
            stopSelf();
            return 2;
        }
        String stringExtra = intent.getStringExtra("url");
        int intExtra = intent.getIntExtra(IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT, 0);
        int intExtra2 = intent.getIntExtra("notificationId", 0);
        if (stringExtra != null && stringExtra.startsWith("http") && intExtra > 0 && intExtra2 > 0) {
            Intent intent2 = new Intent(this, getClass());
            intent2.setAction("objectBox_objectBrowserStop");
            PendingIntent service = PendingIntent.getService(this, 0, intent2, 268435456);
            PendingIntent activity = PendingIntent.getActivity(this, 0, AndroidObjectBrowser.m3383a(stringExtra), 0);
            Notification.Builder m3384a = AndroidObjectBrowser.m3384a(this, intExtra, (NotificationManager) getSystemService("notification"));
            m3384a.setContentIntent(activity);
            m3384a.setDeleteIntent(service);
            if (Build.VERSION.SDK_INT >= 20) {
                m3384a.addAction(new Notification.Action.Builder(R.drawable.objectbox_stop, "Stop", service).build());
            }
            startForeground(intExtra2, m3384a.getNotification());
            Log.d("ObjectBrowserService", "Started");
            return 3;
        }
        Log.w("ObjectBrowserService", "Ignoring start command due to incomplete data");
        return 2;
    }
}
