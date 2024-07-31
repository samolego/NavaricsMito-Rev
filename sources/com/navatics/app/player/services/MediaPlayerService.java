package com.navatics.app.player.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: classes.dex */
public class MediaPlayerService extends Service {

    /* renamed from: a */
    private static IMediaPlayer f4894a;

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* renamed from: a */
    public static Intent m7639a(Context context) {
        return new Intent(context, MediaPlayerService.class);
    }

    /* renamed from: b */
    public static void m7637b(Context context) {
        context.startService(m7639a(context));
    }

    /* renamed from: a */
    public static void m7638a(IMediaPlayer iMediaPlayer) {
        IMediaPlayer iMediaPlayer2 = f4894a;
        if (iMediaPlayer2 != null && iMediaPlayer2 != iMediaPlayer) {
            if (iMediaPlayer2.isPlaying()) {
                f4894a.stop();
            }
            f4894a.release();
            f4894a = null;
        }
        f4894a = iMediaPlayer;
    }

    /* renamed from: a */
    public static IMediaPlayer m7640a() {
        return f4894a;
    }
}
