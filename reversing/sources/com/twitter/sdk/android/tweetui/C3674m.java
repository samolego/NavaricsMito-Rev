package com.twitter.sdk.android.tweetui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.twitter.sdk.android.core.C2644g;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.tweetui.PlayerActivity;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener;
import com.twitter.sdk.android.tweetui.internal.VideoControlView;
import com.twitter.sdk.android.tweetui.internal.VideoView;

/* renamed from: com.twitter.sdk.android.tweetui.m */
/* loaded from: classes2.dex */
class PlayerController {

    /* renamed from: a */
    final VideoView f9101a;

    /* renamed from: b */
    final VideoControlView f9102b;

    /* renamed from: c */
    final ProgressBar f9103c;

    /* renamed from: d */
    final TextView f9104d;

    /* renamed from: e */
    final View f9105e;

    /* renamed from: f */
    int f9106f;

    /* renamed from: g */
    boolean f9107g = true;

    /* renamed from: h */
    final SwipeToDismissTouchListener.InterfaceC2759a f9108h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayerController(View view, SwipeToDismissTouchListener.InterfaceC2759a interfaceC2759a) {
        this.f9105e = view;
        this.f9101a = (VideoView) view.findViewById(R.id.video_view);
        this.f9102b = (VideoControlView) view.findViewById(R.id.video_control_view);
        this.f9103c = (ProgressBar) view.findViewById(R.id.video_progress_view);
        this.f9104d = (TextView) view.findViewById(R.id.call_to_action_view);
        this.f9108h = interfaceC2759a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3913a(PlayerActivity.PlayerItem playerItem) {
        try {
            m3909b(playerItem);
            m3911a(playerItem.looping, playerItem.showVideoControls);
            this.f9101a.setOnTouchListener(SwipeToDismissTouchListener.m3938a(this.f9101a, this.f9108h));
            this.f9101a.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.twitter.sdk.android.tweetui.m.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    PlayerController.this.f9103c.setVisibility(8);
                }
            });
            this.f9101a.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.twitter.sdk.android.tweetui.m.2
                @Override // android.media.MediaPlayer.OnInfoListener
                public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                    if (i == 702) {
                        PlayerController.this.f9103c.setVisibility(8);
                        return true;
                    } else if (i == 701) {
                        PlayerController.this.f9103c.setVisibility(0);
                        return true;
                    } else {
                        return false;
                    }
                }
            });
            this.f9101a.m4002a(Uri.parse(playerItem.url), playerItem.looping);
            this.f9101a.requestFocus();
        } catch (Exception e) {
            Twitter.m4253h().mo4556c("PlayerController", "Error occurred during video playback", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3914a() {
        int i = this.f9106f;
        if (i != 0) {
            this.f9101a.mo4003a(i);
        }
        if (this.f9107g) {
            this.f9101a.mo4004a();
            this.f9102b.m4005l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m3910b() {
        this.f9107g = this.f9101a.mo3993c();
        this.f9106f = this.f9101a.getCurrentPosition();
        this.f9101a.mo3996b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m3908c() {
        this.f9101a.m3990d();
    }

    /* renamed from: a */
    void m3911a(boolean z, boolean z2) {
        if (z && !z2) {
            m3907d();
        } else {
            m3906e();
        }
    }

    /* renamed from: d */
    void m3907d() {
        this.f9102b.setVisibility(4);
        this.f9101a.setOnClickListener(new View.OnClickListener() { // from class: com.twitter.sdk.android.tweetui.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PlayerController.this.f9101a.mo3993c()) {
                    PlayerController.this.f9101a.mo3996b();
                } else {
                    PlayerController.this.f9101a.mo4004a();
                }
            }
        });
    }

    /* renamed from: e */
    void m3906e() {
        this.f9101a.setMediaController(this.f9102b);
    }

    /* renamed from: b */
    void m3909b(PlayerActivity.PlayerItem playerItem) {
        if (playerItem.callToActionText == null || playerItem.callToActionUrl == null) {
            return;
        }
        this.f9104d.setVisibility(0);
        this.f9104d.setText(playerItem.callToActionText);
        m3912a(playerItem.callToActionUrl);
        m3905f();
    }

    /* renamed from: a */
    void m3912a(final String str) {
        this.f9104d.setOnClickListener(new View.OnClickListener() { // from class: com.twitter.sdk.android.tweetui.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C2644g.m4563b(PlayerController.this.f9104d.getContext(), new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }
        });
    }

    /* renamed from: f */
    void m3905f() {
        this.f9105e.setOnClickListener(new View.OnClickListener() { // from class: com.twitter.sdk.android.tweetui.m.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PlayerController.this.f9104d.getVisibility() == 0) {
                    PlayerController.this.f9104d.setVisibility(8);
                } else {
                    PlayerController.this.f9104d.setVisibility(0);
                }
            }
        });
    }
}
