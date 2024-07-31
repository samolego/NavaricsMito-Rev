package com.navatics.app.player.widget.media;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.View;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* renamed from: com.navatics.app.player.widget.media.c */
/* loaded from: classes.dex */
public interface IRenderView {

    /* compiled from: IRenderView.java */
    /* renamed from: com.navatics.app.player.widget.media.c$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1881a {
        /* renamed from: a */
        void mo7560a(@NonNull InterfaceC1882b interfaceC1882b);

        /* renamed from: a */
        void mo7559a(@NonNull InterfaceC1882b interfaceC1882b, int i, int i2);

        /* renamed from: a */
        void mo7558a(@NonNull InterfaceC1882b interfaceC1882b, int i, int i2, int i3);
    }

    /* compiled from: IRenderView.java */
    /* renamed from: com.navatics.app.player.widget.media.c$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1882b {
        @NonNull
        /* renamed from: a */
        IRenderView mo7557a();

        /* renamed from: a */
        void mo7556a(IMediaPlayer iMediaPlayer);
    }

    /* renamed from: a */
    void mo7564a(int i, int i2);

    /* renamed from: a */
    void mo7563a(@NonNull InterfaceC1881a interfaceC1881a);

    /* renamed from: a */
    boolean mo7565a();

    /* renamed from: b */
    void mo7562b(int i, int i2);

    /* renamed from: b */
    void mo7561b(@NonNull InterfaceC1881a interfaceC1881a);

    Bitmap getFrameBitmap();

    int getVideoPosition();

    View getView();

    void setAspectRatio(int i);

    void setVideoPosition(int i);

    void setVideoRotation(int i);
}
