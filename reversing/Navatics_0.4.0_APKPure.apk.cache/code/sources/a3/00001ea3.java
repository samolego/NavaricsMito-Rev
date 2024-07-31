package com.senseplay.sdk.zxing.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import java.io.Closeable;

/* loaded from: classes2.dex */
public final class BeepManager implements MediaPlayer.OnErrorListener, Closeable {
    private static final float BEEP_VOLUME = 0.1f;
    private static final String TAG = "BeepManager";
    private static final long VIBRATE_DURATION = 200;
    private final Activity activity;
    private MediaPlayer mediaPlayer = null;
    private boolean playBeep;
    private boolean vibrate;

    public BeepManager(Activity activity) {
        this.activity = activity;
        updatePrefs();
    }

    public synchronized void updatePrefs() {
        this.playBeep = shouldBeep(PreferenceManager.getDefaultSharedPreferences(this.activity), this.activity);
        this.vibrate = true;
        if (this.playBeep && this.mediaPlayer == null) {
            this.activity.setVolumeControlStream(3);
            this.mediaPlayer = buildMediaPlayer(this.activity);
        }
    }

    public synchronized void playBeepSoundAndVibrate() {
        if (this.playBeep && this.mediaPlayer != null) {
            this.mediaPlayer.start();
        }
        if (this.vibrate) {
            ((Vibrator) this.activity.getSystemService("vibrator")).vibrate(VIBRATE_DURATION);
        }
    }

    private static boolean shouldBeep(SharedPreferences sharedPreferences, Context context) {
        return ((AudioManager) context.getSystemService("audio")).getRingerMode() == 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[Catch: IOException -> 0x0054, SYNTHETIC, TRY_LEAVE, TryCatch #2 {IOException -> 0x0054, blocks: (B:3:0x0006, B:7:0x0036, B:18:0x0047, B:15:0x0050, B:22:0x004c, B:16:0x0053), top: B:2:0x0006, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.media.MediaPlayer buildMediaPlayer(android.content.Context r10) {
        /*
            r9 = this;
            android.media.MediaPlayer r6 = new android.media.MediaPlayer
            r6.<init>()
            r7 = 0
            android.content.res.Resources r10 = r10.getResources()     // Catch: java.io.IOException -> L54
            int r0 = com.senseplay.sdk.C2111R.raw.beep     // Catch: java.io.IOException -> L54
            android.content.res.AssetFileDescriptor r10 = r10.openRawResourceFd(r0)     // Catch: java.io.IOException -> L54
            java.io.FileDescriptor r1 = r10.getFileDescriptor()     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3d
            long r2 = r10.getStartOffset()     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3d
            long r4 = r10.getLength()     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3d
            r0 = r6
            r0.setDataSource(r1, r2, r4)     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3d
            r6.setOnErrorListener(r9)     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3d
            r0 = 3
            r6.setAudioStreamType(r0)     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3d
            r0 = 0
            r6.setLooping(r0)     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3d
            r0 = 1036831949(0x3dcccccd, float:0.1)
            r6.setVolume(r0, r0)     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3d
            r6.prepare()     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3d
            if (r10 == 0) goto L39
            r10.close()     // Catch: java.io.IOException -> L54
        L39:
            return r6
        L3a:
            r0 = move-exception
            r1 = r7
            goto L43
        L3d:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L3f
        L3f:
            r1 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
        L43:
            if (r10 == 0) goto L53
            if (r1 == 0) goto L50
            r10.close()     // Catch: java.lang.Throwable -> L4b java.io.IOException -> L54
            goto L53
        L4b:
            r10 = move-exception
            r1.addSuppressed(r10)     // Catch: java.io.IOException -> L54
            goto L53
        L50:
            r10.close()     // Catch: java.io.IOException -> L54
        L53:
            throw r0     // Catch: java.io.IOException -> L54
        L54:
            r10 = move-exception
            java.lang.String r0 = com.senseplay.sdk.zxing.utils.BeepManager.TAG
            android.util.Log.w(r0, r10)
            r6.release()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.senseplay.sdk.zxing.utils.BeepManager.buildMediaPlayer(android.content.Context):android.media.MediaPlayer");
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public synchronized boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 100) {
            this.activity.finish();
        } else {
            close();
            updatePrefs();
        }
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.mediaPlayer != null) {
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
    }
}