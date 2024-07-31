package com.navatics.app.player.widget.media;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.TableLayout;
import android.widget.TextView;
import com.navatics.app.R;
import com.navatics.app.player.Settings;
import com.navatics.app.player.services.MediaPlayerService;
import com.navatics.app.player.widget.media.InterfaceC1776c;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.ijk.media.player.AndroidMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.IjkTimedText;
import tv.danmaku.ijk.media.player.TextureMediaPlayer;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

/* loaded from: classes.dex */
public class IjkVideoView extends FrameLayout implements MediaController.MediaPlayerControl {

    /* renamed from: Q */
    private static final int[] f4920Q = {0, 1, 2, 4, 5};

    /* renamed from: A */
    private Settings f4921A;

    /* renamed from: B */
    private InterfaceC1776c f4922B;

    /* renamed from: C */
    private int f4923C;

    /* renamed from: D */
    private int f4924D;

    /* renamed from: E */
    private InfoHudViewHolder f4925E;

    /* renamed from: F */
    private long f4926F;

    /* renamed from: G */
    private long f4927G;

    /* renamed from: H */
    private long f4928H;

    /* renamed from: I */
    private long f4929I;

    /* renamed from: J */
    private TextView f4930J;

    /* renamed from: K */
    private IMediaPlayer.OnCompletionListener f4931K;

    /* renamed from: L */
    private IMediaPlayer.OnInfoListener f4932L;

    /* renamed from: M */
    private IMediaPlayer.OnErrorListener f4933M;

    /* renamed from: N */
    private IMediaPlayer.OnBufferingUpdateListener f4934N;

    /* renamed from: O */
    private IMediaPlayer.OnSeekCompleteListener f4935O;

    /* renamed from: P */
    private IMediaPlayer.OnTimedTextListener f4936P;

    /* renamed from: R */
    private int f4937R;

    /* renamed from: S */
    private int f4938S;

    /* renamed from: T */
    private List<Integer> f4939T;

    /* renamed from: U */
    private int f4940U;

    /* renamed from: V */
    private int f4941V;

    /* renamed from: W */
    private InterfaceC1769a f4942W;

    /* renamed from: a */
    IMediaPlayer.OnVideoSizeChangedListener f4943a;

    /* renamed from: aa */
    private boolean f4944aa;

    /* renamed from: b */
    IMediaPlayer.OnPreparedListener f4945b;

    /* renamed from: c */
    InterfaceC1776c.a f4946c;

    /* renamed from: d */
    private String f4947d;

    /* renamed from: e */
    private Uri f4948e;

    /* renamed from: f */
    private Map<String, String> f4949f;

    /* renamed from: g */
    private int f4950g;

    /* renamed from: h */
    private int f4951h;

    /* renamed from: i */
    private InterfaceC1776c.b f4952i;

    /* renamed from: j */
    private IMediaPlayer f4953j;

    /* renamed from: k */
    private int f4954k;

    /* renamed from: l */
    private int f4955l;

    /* renamed from: m */
    private int f4956m;

    /* renamed from: n */
    private int f4957n;

    /* renamed from: o */
    private int f4958o;

    /* renamed from: p */
    private InterfaceC1775b f4959p;

    /* renamed from: q */
    private IMediaPlayer.OnCompletionListener f4960q;

    /* renamed from: r */
    private IMediaPlayer.OnPreparedListener f4961r;

    /* renamed from: s */
    private int f4962s;

    /* renamed from: t */
    private IMediaPlayer.OnErrorListener f4963t;

    /* renamed from: u */
    private IMediaPlayer.OnInfoListener f4964u;

    /* renamed from: v */
    private int f4965v;

    /* renamed from: w */
    private boolean f4966w;

    /* renamed from: x */
    private boolean f4967x;

    /* renamed from: y */
    private boolean f4968y;

    /* renamed from: z */
    private Context f4969z;

    /* renamed from: com.navatics.app.player.widget.media.IjkVideoView$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1769a {
        /* renamed from: a */
        void mo3974a();

        /* renamed from: b */
        void mo3975b();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    public IjkVideoView(Context context) {
        super(context);
        this.f4947d = "IjkVideoView";
        this.f4950g = 0;
        this.f4951h = 0;
        this.f4952i = null;
        this.f4953j = null;
        this.f4966w = true;
        this.f4967x = true;
        this.f4968y = true;
        this.f4926F = 0L;
        this.f4927G = 0L;
        this.f4928H = 0L;
        this.f4929I = 0L;
        this.f4943a = new IMediaPlayer.OnVideoSizeChangedListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.1
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
                IjkVideoView.this.f4954k = iMediaPlayer.getVideoWidth();
                IjkVideoView.this.f4955l = iMediaPlayer.getVideoHeight();
                IjkVideoView.this.f4923C = iMediaPlayer.getVideoSarNum();
                IjkVideoView.this.f4924D = iMediaPlayer.getVideoSarDen();
                if (IjkVideoView.this.f4954k == 0 || IjkVideoView.this.f4955l == 0) {
                    return;
                }
                if (IjkVideoView.this.f4922B != null) {
                    IjkVideoView.this.f4922B.mo5337a(IjkVideoView.this.f4954k, IjkVideoView.this.f4955l);
                    IjkVideoView.this.f4922B.mo5340b(IjkVideoView.this.f4923C, IjkVideoView.this.f4924D);
                }
                Log.i("layout_debug", "requestLayout");
                IjkVideoView.this.requestLayout();
            }
        };
        this.f4945b = new IMediaPlayer.OnPreparedListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.2
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.f4927G = System.currentTimeMillis();
                if (IjkVideoView.this.f4925E != null) {
                    IjkVideoView.this.f4925E.m5367a(IjkVideoView.this.f4927G - IjkVideoView.this.f4926F);
                }
                IjkVideoView.this.f4950g = 2;
                if (IjkVideoView.this.f4961r != null) {
                    IjkVideoView.this.f4961r.onPrepared(IjkVideoView.this.f4953j);
                }
                if (IjkVideoView.this.f4959p != null) {
                    IjkVideoView.this.f4959p.setEnabled(true);
                }
                IjkVideoView.this.f4954k = iMediaPlayer.getVideoWidth();
                IjkVideoView.this.f4955l = iMediaPlayer.getVideoHeight();
                int i = IjkVideoView.this.f4965v;
                if (i != 0) {
                    IjkVideoView.this.seekTo(i);
                }
                if (IjkVideoView.this.f4954k == 0 || IjkVideoView.this.f4955l == 0) {
                    if (IjkVideoView.this.f4951h == 3) {
                        IjkVideoView.this.start();
                        return;
                    }
                    return;
                }
                if (IjkVideoView.this.f4922B != null) {
                    IjkVideoView.this.f4922B.mo5337a(IjkVideoView.this.f4954k, IjkVideoView.this.f4955l);
                    IjkVideoView.this.f4922B.mo5340b(IjkVideoView.this.f4923C, IjkVideoView.this.f4924D);
                    if (!IjkVideoView.this.f4922B.mo5339a() || (IjkVideoView.this.f4956m == IjkVideoView.this.f4954k && IjkVideoView.this.f4957n == IjkVideoView.this.f4955l)) {
                        if (IjkVideoView.this.f4951h == 3) {
                            IjkVideoView.this.start();
                            if (IjkVideoView.this.f4959p != null) {
                                IjkVideoView.this.f4959p.show();
                                return;
                            }
                            return;
                        }
                        if (IjkVideoView.this.isPlaying()) {
                            return;
                        }
                        if ((i != 0 || IjkVideoView.this.getCurrentPosition() > 0) && IjkVideoView.this.f4959p != null) {
                            IjkVideoView.this.f4959p.show(0);
                        }
                    }
                }
            }
        };
        this.f4931K = new IMediaPlayer.OnCompletionListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.3
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.f4950g = 5;
                IjkVideoView.this.f4951h = 5;
                if (IjkVideoView.this.f4959p != null) {
                    IjkVideoView.this.f4959p.hide();
                }
                if (IjkVideoView.this.f4960q != null) {
                    IjkVideoView.this.f4960q.onCompletion(IjkVideoView.this.f4953j);
                }
            }
        };
        this.f4932L = new IMediaPlayer.OnInfoListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.4
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
                if (IjkVideoView.this.f4964u != null) {
                    IjkVideoView.this.f4964u.onInfo(iMediaPlayer, i, i2);
                }
                switch (i) {
                    case 3:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_VIDEO_RENDERING_START:");
                        return true;
                    case 700:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_BUFFERING_START:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_BUFFERING_END:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_NETWORK_BANDWIDTH: " + i2);
                        return true;
                    case 800:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_BAD_INTERLEAVING:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_NOT_SEEKABLE:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_METADATA_UPDATE:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_UNSUPPORTED_SUBTITLE /* 901 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_SUBTITLE_TIMED_OUT /* 902 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
                        return true;
                    case 10001:
                        IjkVideoView.this.f4958o = i2;
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
                        if (IjkVideoView.this.f4922B == null) {
                            return true;
                        }
                        IjkVideoView.this.f4922B.setVideoRotation(i2);
                        return true;
                    case 10002:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_AUDIO_RENDERING_START:");
                        return true;
                    default:
                        return true;
                }
            }
        };
        this.f4933M = new IMediaPlayer.OnErrorListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.5
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
                Log.d(IjkVideoView.this.f4947d, "Error: " + i + "," + i2);
                IjkVideoView.this.f4950g = -1;
                IjkVideoView.this.f4951h = -1;
                if (IjkVideoView.this.f4959p != null) {
                    IjkVideoView.this.f4959p.hide();
                }
                if ((IjkVideoView.this.f4963t == null || !IjkVideoView.this.f4963t.onError(IjkVideoView.this.f4953j, i, i2)) && IjkVideoView.this.getWindowToken() != null) {
                    IjkVideoView.this.f4969z.getResources();
                    new AlertDialog.Builder(IjkVideoView.this.getContext()).setMessage(i == 200 ? R.string.VideoView_error_text_invalid_progressive_playback : R.string.VideoView_error_text_unknown).setPositiveButton(R.string.VideoView_error_button, new DialogInterface.OnClickListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.5.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            if (IjkVideoView.this.f4960q != null) {
                                IjkVideoView.this.f4960q.onCompletion(IjkVideoView.this.f4953j);
                            }
                        }
                    }).setCancelable(false).show();
                }
                return true;
            }
        };
        this.f4934N = new IMediaPlayer.OnBufferingUpdateListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.6
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
                IjkVideoView.this.f4962s = i;
            }
        };
        this.f4935O = new IMediaPlayer.OnSeekCompleteListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.7
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.f4929I = System.currentTimeMillis();
                if (IjkVideoView.this.f4925E != null) {
                    IjkVideoView.this.f4925E.m5369b(IjkVideoView.this.f4929I - IjkVideoView.this.f4928H);
                }
            }
        };
        this.f4936P = new IMediaPlayer.OnTimedTextListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.8
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener
            public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
                if (ijkTimedText != null) {
                    IjkVideoView.this.f4930J.setText(ijkTimedText.getText());
                }
            }
        };
        this.f4946c = new InterfaceC1776c.a() { // from class: com.navatics.app.player.widget.media.IjkVideoView.9
            @Override // com.navatics.app.player.widget.media.InterfaceC1776c.a
            /* renamed from: a */
            public void mo5335a(@NonNull InterfaceC1776c.b bVar, int i, int i2, int i3) {
                if (bVar.mo5342a() != IjkVideoView.this.f4922B) {
                    Log.e(IjkVideoView.this.f4947d, "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.f4956m = i2;
                IjkVideoView.this.f4957n = i3;
                boolean z = true;
                boolean z2 = IjkVideoView.this.f4951h == 3;
                if (IjkVideoView.this.f4922B.mo5339a() && (IjkVideoView.this.f4954k != i2 || IjkVideoView.this.f4955l != i3)) {
                    z = false;
                }
                if (IjkVideoView.this.f4953j != null && z2 && z) {
                    if (IjkVideoView.this.f4965v != 0) {
                        IjkVideoView ijkVideoView = IjkVideoView.this;
                        ijkVideoView.seekTo(ijkVideoView.f4965v);
                    }
                    IjkVideoView.this.start();
                }
            }

            @Override // com.navatics.app.player.widget.media.InterfaceC1776c.a
            /* renamed from: a */
            public void mo5334a(@NonNull InterfaceC1776c.b bVar, int i, int i2) {
                if (bVar.mo5342a() != IjkVideoView.this.f4922B) {
                    Log.e(IjkVideoView.this.f4947d, "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.f4952i = bVar;
                if (IjkVideoView.this.f4953j == null) {
                    IjkVideoView.this.m5298f();
                } else {
                    IjkVideoView ijkVideoView = IjkVideoView.this;
                    ijkVideoView.m5286a(ijkVideoView.f4953j, bVar);
                }
            }

            @Override // com.navatics.app.player.widget.media.InterfaceC1776c.a
            /* renamed from: a */
            public void mo5333a(@NonNull InterfaceC1776c.b bVar) {
                if (bVar.mo5342a() != IjkVideoView.this.f4922B) {
                    Log.e(IjkVideoView.this.f4947d, "onSurfaceDestroyed: unmatched render callback\n");
                } else {
                    IjkVideoView.this.f4952i = null;
                    IjkVideoView.this.m5329b();
                }
            }
        };
        this.f4937R = 0;
        this.f4938S = f4920Q[0];
        this.f4939T = new ArrayList();
        this.f4940U = 0;
        this.f4941V = 0;
        this.f4944aa = false;
        m5283a(context);
    }

    public IjkVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4947d = "IjkVideoView";
        this.f4950g = 0;
        this.f4951h = 0;
        this.f4952i = null;
        this.f4953j = null;
        this.f4966w = true;
        this.f4967x = true;
        this.f4968y = true;
        this.f4926F = 0L;
        this.f4927G = 0L;
        this.f4928H = 0L;
        this.f4929I = 0L;
        this.f4943a = new IMediaPlayer.OnVideoSizeChangedListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.1
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
                IjkVideoView.this.f4954k = iMediaPlayer.getVideoWidth();
                IjkVideoView.this.f4955l = iMediaPlayer.getVideoHeight();
                IjkVideoView.this.f4923C = iMediaPlayer.getVideoSarNum();
                IjkVideoView.this.f4924D = iMediaPlayer.getVideoSarDen();
                if (IjkVideoView.this.f4954k == 0 || IjkVideoView.this.f4955l == 0) {
                    return;
                }
                if (IjkVideoView.this.f4922B != null) {
                    IjkVideoView.this.f4922B.mo5337a(IjkVideoView.this.f4954k, IjkVideoView.this.f4955l);
                    IjkVideoView.this.f4922B.mo5340b(IjkVideoView.this.f4923C, IjkVideoView.this.f4924D);
                }
                Log.i("layout_debug", "requestLayout");
                IjkVideoView.this.requestLayout();
            }
        };
        this.f4945b = new IMediaPlayer.OnPreparedListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.2
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.f4927G = System.currentTimeMillis();
                if (IjkVideoView.this.f4925E != null) {
                    IjkVideoView.this.f4925E.m5367a(IjkVideoView.this.f4927G - IjkVideoView.this.f4926F);
                }
                IjkVideoView.this.f4950g = 2;
                if (IjkVideoView.this.f4961r != null) {
                    IjkVideoView.this.f4961r.onPrepared(IjkVideoView.this.f4953j);
                }
                if (IjkVideoView.this.f4959p != null) {
                    IjkVideoView.this.f4959p.setEnabled(true);
                }
                IjkVideoView.this.f4954k = iMediaPlayer.getVideoWidth();
                IjkVideoView.this.f4955l = iMediaPlayer.getVideoHeight();
                int i = IjkVideoView.this.f4965v;
                if (i != 0) {
                    IjkVideoView.this.seekTo(i);
                }
                if (IjkVideoView.this.f4954k == 0 || IjkVideoView.this.f4955l == 0) {
                    if (IjkVideoView.this.f4951h == 3) {
                        IjkVideoView.this.start();
                        return;
                    }
                    return;
                }
                if (IjkVideoView.this.f4922B != null) {
                    IjkVideoView.this.f4922B.mo5337a(IjkVideoView.this.f4954k, IjkVideoView.this.f4955l);
                    IjkVideoView.this.f4922B.mo5340b(IjkVideoView.this.f4923C, IjkVideoView.this.f4924D);
                    if (!IjkVideoView.this.f4922B.mo5339a() || (IjkVideoView.this.f4956m == IjkVideoView.this.f4954k && IjkVideoView.this.f4957n == IjkVideoView.this.f4955l)) {
                        if (IjkVideoView.this.f4951h == 3) {
                            IjkVideoView.this.start();
                            if (IjkVideoView.this.f4959p != null) {
                                IjkVideoView.this.f4959p.show();
                                return;
                            }
                            return;
                        }
                        if (IjkVideoView.this.isPlaying()) {
                            return;
                        }
                        if ((i != 0 || IjkVideoView.this.getCurrentPosition() > 0) && IjkVideoView.this.f4959p != null) {
                            IjkVideoView.this.f4959p.show(0);
                        }
                    }
                }
            }
        };
        this.f4931K = new IMediaPlayer.OnCompletionListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.3
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.f4950g = 5;
                IjkVideoView.this.f4951h = 5;
                if (IjkVideoView.this.f4959p != null) {
                    IjkVideoView.this.f4959p.hide();
                }
                if (IjkVideoView.this.f4960q != null) {
                    IjkVideoView.this.f4960q.onCompletion(IjkVideoView.this.f4953j);
                }
            }
        };
        this.f4932L = new IMediaPlayer.OnInfoListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.4
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
                if (IjkVideoView.this.f4964u != null) {
                    IjkVideoView.this.f4964u.onInfo(iMediaPlayer, i, i2);
                }
                switch (i) {
                    case 3:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_VIDEO_RENDERING_START:");
                        return true;
                    case 700:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_BUFFERING_START:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_BUFFERING_END:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_NETWORK_BANDWIDTH: " + i2);
                        return true;
                    case 800:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_BAD_INTERLEAVING:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_NOT_SEEKABLE:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_METADATA_UPDATE:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_UNSUPPORTED_SUBTITLE /* 901 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_SUBTITLE_TIMED_OUT /* 902 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
                        return true;
                    case 10001:
                        IjkVideoView.this.f4958o = i2;
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
                        if (IjkVideoView.this.f4922B == null) {
                            return true;
                        }
                        IjkVideoView.this.f4922B.setVideoRotation(i2);
                        return true;
                    case 10002:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_AUDIO_RENDERING_START:");
                        return true;
                    default:
                        return true;
                }
            }
        };
        this.f4933M = new IMediaPlayer.OnErrorListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.5
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
                Log.d(IjkVideoView.this.f4947d, "Error: " + i + "," + i2);
                IjkVideoView.this.f4950g = -1;
                IjkVideoView.this.f4951h = -1;
                if (IjkVideoView.this.f4959p != null) {
                    IjkVideoView.this.f4959p.hide();
                }
                if ((IjkVideoView.this.f4963t == null || !IjkVideoView.this.f4963t.onError(IjkVideoView.this.f4953j, i, i2)) && IjkVideoView.this.getWindowToken() != null) {
                    IjkVideoView.this.f4969z.getResources();
                    new AlertDialog.Builder(IjkVideoView.this.getContext()).setMessage(i == 200 ? R.string.VideoView_error_text_invalid_progressive_playback : R.string.VideoView_error_text_unknown).setPositiveButton(R.string.VideoView_error_button, new DialogInterface.OnClickListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.5.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            if (IjkVideoView.this.f4960q != null) {
                                IjkVideoView.this.f4960q.onCompletion(IjkVideoView.this.f4953j);
                            }
                        }
                    }).setCancelable(false).show();
                }
                return true;
            }
        };
        this.f4934N = new IMediaPlayer.OnBufferingUpdateListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.6
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
                IjkVideoView.this.f4962s = i;
            }
        };
        this.f4935O = new IMediaPlayer.OnSeekCompleteListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.7
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.f4929I = System.currentTimeMillis();
                if (IjkVideoView.this.f4925E != null) {
                    IjkVideoView.this.f4925E.m5369b(IjkVideoView.this.f4929I - IjkVideoView.this.f4928H);
                }
            }
        };
        this.f4936P = new IMediaPlayer.OnTimedTextListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.8
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener
            public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
                if (ijkTimedText != null) {
                    IjkVideoView.this.f4930J.setText(ijkTimedText.getText());
                }
            }
        };
        this.f4946c = new InterfaceC1776c.a() { // from class: com.navatics.app.player.widget.media.IjkVideoView.9
            @Override // com.navatics.app.player.widget.media.InterfaceC1776c.a
            /* renamed from: a */
            public void mo5335a(@NonNull InterfaceC1776c.b bVar, int i, int i2, int i3) {
                if (bVar.mo5342a() != IjkVideoView.this.f4922B) {
                    Log.e(IjkVideoView.this.f4947d, "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.f4956m = i2;
                IjkVideoView.this.f4957n = i3;
                boolean z = true;
                boolean z2 = IjkVideoView.this.f4951h == 3;
                if (IjkVideoView.this.f4922B.mo5339a() && (IjkVideoView.this.f4954k != i2 || IjkVideoView.this.f4955l != i3)) {
                    z = false;
                }
                if (IjkVideoView.this.f4953j != null && z2 && z) {
                    if (IjkVideoView.this.f4965v != 0) {
                        IjkVideoView ijkVideoView = IjkVideoView.this;
                        ijkVideoView.seekTo(ijkVideoView.f4965v);
                    }
                    IjkVideoView.this.start();
                }
            }

            @Override // com.navatics.app.player.widget.media.InterfaceC1776c.a
            /* renamed from: a */
            public void mo5334a(@NonNull InterfaceC1776c.b bVar, int i, int i2) {
                if (bVar.mo5342a() != IjkVideoView.this.f4922B) {
                    Log.e(IjkVideoView.this.f4947d, "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.f4952i = bVar;
                if (IjkVideoView.this.f4953j == null) {
                    IjkVideoView.this.m5298f();
                } else {
                    IjkVideoView ijkVideoView = IjkVideoView.this;
                    ijkVideoView.m5286a(ijkVideoView.f4953j, bVar);
                }
            }

            @Override // com.navatics.app.player.widget.media.InterfaceC1776c.a
            /* renamed from: a */
            public void mo5333a(@NonNull InterfaceC1776c.b bVar) {
                if (bVar.mo5342a() != IjkVideoView.this.f4922B) {
                    Log.e(IjkVideoView.this.f4947d, "onSurfaceDestroyed: unmatched render callback\n");
                } else {
                    IjkVideoView.this.f4952i = null;
                    IjkVideoView.this.m5329b();
                }
            }
        };
        this.f4937R = 0;
        this.f4938S = f4920Q[0];
        this.f4939T = new ArrayList();
        this.f4940U = 0;
        this.f4941V = 0;
        this.f4944aa = false;
        m5283a(context);
    }

    public IjkVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4947d = "IjkVideoView";
        this.f4950g = 0;
        this.f4951h = 0;
        this.f4952i = null;
        this.f4953j = null;
        this.f4966w = true;
        this.f4967x = true;
        this.f4968y = true;
        this.f4926F = 0L;
        this.f4927G = 0L;
        this.f4928H = 0L;
        this.f4929I = 0L;
        this.f4943a = new IMediaPlayer.OnVideoSizeChangedListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.1
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i2, int i22, int i3, int i4) {
                IjkVideoView.this.f4954k = iMediaPlayer.getVideoWidth();
                IjkVideoView.this.f4955l = iMediaPlayer.getVideoHeight();
                IjkVideoView.this.f4923C = iMediaPlayer.getVideoSarNum();
                IjkVideoView.this.f4924D = iMediaPlayer.getVideoSarDen();
                if (IjkVideoView.this.f4954k == 0 || IjkVideoView.this.f4955l == 0) {
                    return;
                }
                if (IjkVideoView.this.f4922B != null) {
                    IjkVideoView.this.f4922B.mo5337a(IjkVideoView.this.f4954k, IjkVideoView.this.f4955l);
                    IjkVideoView.this.f4922B.mo5340b(IjkVideoView.this.f4923C, IjkVideoView.this.f4924D);
                }
                Log.i("layout_debug", "requestLayout");
                IjkVideoView.this.requestLayout();
            }
        };
        this.f4945b = new IMediaPlayer.OnPreparedListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.2
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.f4927G = System.currentTimeMillis();
                if (IjkVideoView.this.f4925E != null) {
                    IjkVideoView.this.f4925E.m5367a(IjkVideoView.this.f4927G - IjkVideoView.this.f4926F);
                }
                IjkVideoView.this.f4950g = 2;
                if (IjkVideoView.this.f4961r != null) {
                    IjkVideoView.this.f4961r.onPrepared(IjkVideoView.this.f4953j);
                }
                if (IjkVideoView.this.f4959p != null) {
                    IjkVideoView.this.f4959p.setEnabled(true);
                }
                IjkVideoView.this.f4954k = iMediaPlayer.getVideoWidth();
                IjkVideoView.this.f4955l = iMediaPlayer.getVideoHeight();
                int i2 = IjkVideoView.this.f4965v;
                if (i2 != 0) {
                    IjkVideoView.this.seekTo(i2);
                }
                if (IjkVideoView.this.f4954k == 0 || IjkVideoView.this.f4955l == 0) {
                    if (IjkVideoView.this.f4951h == 3) {
                        IjkVideoView.this.start();
                        return;
                    }
                    return;
                }
                if (IjkVideoView.this.f4922B != null) {
                    IjkVideoView.this.f4922B.mo5337a(IjkVideoView.this.f4954k, IjkVideoView.this.f4955l);
                    IjkVideoView.this.f4922B.mo5340b(IjkVideoView.this.f4923C, IjkVideoView.this.f4924D);
                    if (!IjkVideoView.this.f4922B.mo5339a() || (IjkVideoView.this.f4956m == IjkVideoView.this.f4954k && IjkVideoView.this.f4957n == IjkVideoView.this.f4955l)) {
                        if (IjkVideoView.this.f4951h == 3) {
                            IjkVideoView.this.start();
                            if (IjkVideoView.this.f4959p != null) {
                                IjkVideoView.this.f4959p.show();
                                return;
                            }
                            return;
                        }
                        if (IjkVideoView.this.isPlaying()) {
                            return;
                        }
                        if ((i2 != 0 || IjkVideoView.this.getCurrentPosition() > 0) && IjkVideoView.this.f4959p != null) {
                            IjkVideoView.this.f4959p.show(0);
                        }
                    }
                }
            }
        };
        this.f4931K = new IMediaPlayer.OnCompletionListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.3
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.f4950g = 5;
                IjkVideoView.this.f4951h = 5;
                if (IjkVideoView.this.f4959p != null) {
                    IjkVideoView.this.f4959p.hide();
                }
                if (IjkVideoView.this.f4960q != null) {
                    IjkVideoView.this.f4960q.onCompletion(IjkVideoView.this.f4953j);
                }
            }
        };
        this.f4932L = new IMediaPlayer.OnInfoListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.4
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i2, int i22) {
                if (IjkVideoView.this.f4964u != null) {
                    IjkVideoView.this.f4964u.onInfo(iMediaPlayer, i2, i22);
                }
                switch (i2) {
                    case 3:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_VIDEO_RENDERING_START:");
                        return true;
                    case 700:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_BUFFERING_START:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_BUFFERING_END:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_NETWORK_BANDWIDTH: " + i22);
                        return true;
                    case 800:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_BAD_INTERLEAVING:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_NOT_SEEKABLE:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_METADATA_UPDATE:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_UNSUPPORTED_SUBTITLE /* 901 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_SUBTITLE_TIMED_OUT /* 902 */:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
                        return true;
                    case 10001:
                        IjkVideoView.this.f4958o = i22;
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i22);
                        if (IjkVideoView.this.f4922B == null) {
                            return true;
                        }
                        IjkVideoView.this.f4922B.setVideoRotation(i22);
                        return true;
                    case 10002:
                        Log.d(IjkVideoView.this.f4947d, "MEDIA_INFO_AUDIO_RENDERING_START:");
                        return true;
                    default:
                        return true;
                }
            }
        };
        this.f4933M = new IMediaPlayer.OnErrorListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.5
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public boolean onError(IMediaPlayer iMediaPlayer, int i2, int i22) {
                Log.d(IjkVideoView.this.f4947d, "Error: " + i2 + "," + i22);
                IjkVideoView.this.f4950g = -1;
                IjkVideoView.this.f4951h = -1;
                if (IjkVideoView.this.f4959p != null) {
                    IjkVideoView.this.f4959p.hide();
                }
                if ((IjkVideoView.this.f4963t == null || !IjkVideoView.this.f4963t.onError(IjkVideoView.this.f4953j, i2, i22)) && IjkVideoView.this.getWindowToken() != null) {
                    IjkVideoView.this.f4969z.getResources();
                    new AlertDialog.Builder(IjkVideoView.this.getContext()).setMessage(i2 == 200 ? R.string.VideoView_error_text_invalid_progressive_playback : R.string.VideoView_error_text_unknown).setPositiveButton(R.string.VideoView_error_button, new DialogInterface.OnClickListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.5.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            if (IjkVideoView.this.f4960q != null) {
                                IjkVideoView.this.f4960q.onCompletion(IjkVideoView.this.f4953j);
                            }
                        }
                    }).setCancelable(false).show();
                }
                return true;
            }
        };
        this.f4934N = new IMediaPlayer.OnBufferingUpdateListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.6
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i2) {
                IjkVideoView.this.f4962s = i2;
            }
        };
        this.f4935O = new IMediaPlayer.OnSeekCompleteListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.7
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.f4929I = System.currentTimeMillis();
                if (IjkVideoView.this.f4925E != null) {
                    IjkVideoView.this.f4925E.m5369b(IjkVideoView.this.f4929I - IjkVideoView.this.f4928H);
                }
            }
        };
        this.f4936P = new IMediaPlayer.OnTimedTextListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.8
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener
            public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
                if (ijkTimedText != null) {
                    IjkVideoView.this.f4930J.setText(ijkTimedText.getText());
                }
            }
        };
        this.f4946c = new InterfaceC1776c.a() { // from class: com.navatics.app.player.widget.media.IjkVideoView.9
            @Override // com.navatics.app.player.widget.media.InterfaceC1776c.a
            /* renamed from: a */
            public void mo5335a(@NonNull InterfaceC1776c.b bVar, int i2, int i22, int i3) {
                if (bVar.mo5342a() != IjkVideoView.this.f4922B) {
                    Log.e(IjkVideoView.this.f4947d, "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.f4956m = i22;
                IjkVideoView.this.f4957n = i3;
                boolean z = true;
                boolean z2 = IjkVideoView.this.f4951h == 3;
                if (IjkVideoView.this.f4922B.mo5339a() && (IjkVideoView.this.f4954k != i22 || IjkVideoView.this.f4955l != i3)) {
                    z = false;
                }
                if (IjkVideoView.this.f4953j != null && z2 && z) {
                    if (IjkVideoView.this.f4965v != 0) {
                        IjkVideoView ijkVideoView = IjkVideoView.this;
                        ijkVideoView.seekTo(ijkVideoView.f4965v);
                    }
                    IjkVideoView.this.start();
                }
            }

            @Override // com.navatics.app.player.widget.media.InterfaceC1776c.a
            /* renamed from: a */
            public void mo5334a(@NonNull InterfaceC1776c.b bVar, int i2, int i22) {
                if (bVar.mo5342a() != IjkVideoView.this.f4922B) {
                    Log.e(IjkVideoView.this.f4947d, "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.f4952i = bVar;
                if (IjkVideoView.this.f4953j == null) {
                    IjkVideoView.this.m5298f();
                } else {
                    IjkVideoView ijkVideoView = IjkVideoView.this;
                    ijkVideoView.m5286a(ijkVideoView.f4953j, bVar);
                }
            }

            @Override // com.navatics.app.player.widget.media.InterfaceC1776c.a
            /* renamed from: a */
            public void mo5333a(@NonNull InterfaceC1776c.b bVar) {
                if (bVar.mo5342a() != IjkVideoView.this.f4922B) {
                    Log.e(IjkVideoView.this.f4947d, "onSurfaceDestroyed: unmatched render callback\n");
                } else {
                    IjkVideoView.this.f4952i = null;
                    IjkVideoView.this.m5329b();
                }
            }
        };
        this.f4937R = 0;
        this.f4938S = f4920Q[0];
        this.f4939T = new ArrayList();
        this.f4940U = 0;
        this.f4941V = 0;
        this.f4944aa = false;
        m5283a(context);
    }

    /* renamed from: a */
    private void m5283a(Context context) {
        this.f4969z = context.getApplicationContext();
        this.f4921A = new Settings(this.f4969z);
        m5312k();
        m5310j();
        this.f4954k = 0;
        this.f4955l = 0;
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f4950g = 0;
        this.f4951h = 0;
        this.f4930J = new TextView(context);
        this.f4930J.setTextSize(24.0f);
        this.f4930J.setGravity(17);
        addView(this.f4930J, new FrameLayout.LayoutParams(-1, -2));
    }

    public void setRenderView(InterfaceC1776c interfaceC1776c) {
        int i;
        int i2;
        if (this.f4922B != null) {
            IMediaPlayer iMediaPlayer = this.f4953j;
            if (iMediaPlayer != null) {
                iMediaPlayer.setDisplay(null);
            }
            View view = this.f4922B.getView();
            this.f4922B.mo5341b(this.f4946c);
            this.f4922B = null;
            removeView(view);
        }
        if (interfaceC1776c == null) {
            return;
        }
        this.f4922B = interfaceC1776c;
        interfaceC1776c.setAspectRatio(this.f4938S);
        int i3 = this.f4954k;
        if (i3 > 0 && (i2 = this.f4955l) > 0) {
            interfaceC1776c.mo5337a(i3, i2);
        }
        int i4 = this.f4923C;
        if (i4 > 0 && (i = this.f4924D) > 0) {
            interfaceC1776c.mo5340b(i4, i);
        }
        View view2 = this.f4922B.getView();
        view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, interfaceC1776c.getVideoPosition()));
        addView(view2);
        this.f4922B.mo5338a(this.f4946c);
        this.f4922B.setVideoRotation(this.f4958o);
    }

    public Bitmap getFrameBitmap() {
        return this.f4922B.getFrameBitmap();
    }

    public void setRender(int i) {
        switch (i) {
            case 0:
                setRenderView(null);
                Log.d(this.f4947d, "Using RENDER_NONE");
                return;
            case 1:
                Log.d(this.f4947d, "Using RENDER_SURFACE_VIEW");
                setRenderView(new SurfaceRenderView(getContext()));
                return;
            case 2:
                TextureRenderView textureRenderView = new TextureRenderView(getContext());
                if (this.f4953j != null) {
                    textureRenderView.getSurfaceHolder().mo5343a(this.f4953j);
                    textureRenderView.mo5337a(this.f4953j.getVideoWidth(), this.f4953j.getVideoHeight());
                    textureRenderView.mo5340b(this.f4953j.getVideoSarNum(), this.f4953j.getVideoSarDen());
                    textureRenderView.setAspectRatio(this.f4938S);
                }
                setRenderView(textureRenderView);
                Log.d(this.f4947d, "Using RENDER_TEXTURE_VIEW");
                return;
            default:
                Log.e(this.f4947d, String.format(Locale.getDefault(), "invalid render %d\n", Integer.valueOf(i)));
                return;
        }
    }

    public void setHudView(TableLayout tableLayout) {
        this.f4925E = new InfoHudViewHolder(getContext(), tableLayout);
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        m5284a(uri, (Map<String, String>) null);
    }

    /* renamed from: a */
    private void m5284a(Uri uri, Map<String, String> map) {
        this.f4948e = uri;
        this.f4949f = map;
        this.f4965v = 0;
        m5298f();
        requestLayout();
        invalidate();
    }

    /* renamed from: a */
    public void m5327a() {
        IMediaPlayer iMediaPlayer = this.f4953j;
        if (iMediaPlayer != null) {
            iMediaPlayer.stop();
            this.f4953j.release();
            this.f4953j = null;
            InfoHudViewHolder infoHudViewHolder = this.f4925E;
            if (infoHudViewHolder != null) {
                infoHudViewHolder.m5368a((IMediaPlayer) null);
            }
            this.f4950g = 0;
            this.f4951h = 0;
            ((AudioManager) this.f4969z.getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    /* renamed from: f */
    public void m5298f() {
        if (this.f4948e == null || this.f4952i == null) {
            return;
        }
        m5328a(false);
        ((AudioManager) this.f4969z.getSystemService("audio")).requestAudioFocus(null, 3, 1);
        try {
            this.f4953j = m5326a(this.f4921A.player());
            getContext();
            this.f4953j.setOnPreparedListener(this.f4945b);
            this.f4953j.setOnVideoSizeChangedListener(this.f4943a);
            this.f4953j.setOnCompletionListener(this.f4931K);
            this.f4953j.setOnErrorListener(this.f4933M);
            this.f4953j.setOnInfoListener(this.f4932L);
            this.f4953j.setOnBufferingUpdateListener(this.f4934N);
            this.f4953j.setOnSeekCompleteListener(this.f4935O);
            this.f4953j.setOnTimedTextListener(this.f4936P);
            this.f4962s = 0;
            String scheme = this.f4948e.getScheme();
            if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase("nvix")) {
                this.f4922B.setVideoPosition(0);
            }
            if (Build.VERSION.SDK_INT >= 23 && this.f4921A.m5261l() && (TextUtils.isEmpty(scheme) || scheme.equalsIgnoreCase("file"))) {
                this.f4953j.setDataSource(new FileMediaDataSource(new File(this.f4948e.toString())));
            } else if (Build.VERSION.SDK_INT >= 14) {
                this.f4953j.setDataSource(this.f4969z, this.f4948e, this.f4949f);
            } else {
                this.f4953j.setDataSource(this.f4948e.toString());
            }
            m5286a(this.f4953j, this.f4952i);
            this.f4953j.setAudioStreamType(3);
            this.f4953j.setScreenOnWhilePlaying(true);
            this.f4926F = System.currentTimeMillis();
            this.f4953j.prepareAsync();
            if (this.f4925E != null) {
                this.f4925E.m5368a(this.f4953j);
            }
            this.f4950g = 1;
            m5301g();
        } catch (IOException e) {
            Log.w(this.f4947d, "Unable to open content: " + this.f4948e, e);
            this.f4950g = -1;
            this.f4951h = -1;
            this.f4933M.onError(this.f4953j, 1, 0);
        } catch (IllegalArgumentException e2) {
            Log.w(this.f4947d, "Unable to open content: " + this.f4948e, e2);
            this.f4950g = -1;
            this.f4951h = -1;
            this.f4933M.onError(this.f4953j, 1, 0);
        }
    }

    public void setMediaController(InterfaceC1775b interfaceC1775b) {
        InterfaceC1775b interfaceC1775b2 = this.f4959p;
        if (interfaceC1775b2 != null) {
            interfaceC1775b2.hide();
        }
        this.f4959p = interfaceC1775b;
        m5301g();
    }

    /* renamed from: g */
    private void m5301g() {
        InterfaceC1775b interfaceC1775b;
        if (this.f4953j == null || (interfaceC1775b = this.f4959p) == null) {
            return;
        }
        interfaceC1775b.setMediaPlayer(this);
        this.f4959p.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
        this.f4959p.setEnabled(m5307i());
    }

    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.f4961r = onPreparedListener;
    }

    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.f4960q = onCompletionListener;
    }

    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.f4963t = onErrorListener;
    }

    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.f4964u = onInfoListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5286a(IMediaPlayer iMediaPlayer, InterfaceC1776c.b bVar) {
        if (iMediaPlayer == null) {
            return;
        }
        if (bVar == null) {
            iMediaPlayer.setDisplay(null);
        } else {
            bVar.mo5343a(iMediaPlayer);
        }
    }

    /* renamed from: b */
    public void m5329b() {
        IMediaPlayer iMediaPlayer = this.f4953j;
        if (iMediaPlayer != null) {
            iMediaPlayer.setDisplay(null);
        }
    }

    /* renamed from: a */
    public void m5328a(boolean z) {
        IMediaPlayer iMediaPlayer = this.f4953j;
        if (iMediaPlayer != null) {
            iMediaPlayer.reset();
            this.f4953j.release();
            this.f4953j = null;
            this.f4950g = 0;
            if (z) {
                this.f4951h = 0;
            }
            ((AudioManager) this.f4969z.getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!m5307i() || this.f4959p == null) {
            return false;
        }
        m5304h();
        return false;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!m5307i() || this.f4959p == null) {
            return false;
        }
        m5304h();
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 164 || i == 82 || i == 5 || i == 6) ? false : true;
        if (m5307i() && z && this.f4959p != null) {
            if (i == 79 || i == 85) {
                if (this.f4953j.isPlaying()) {
                    pause();
                    this.f4959p.show();
                } else {
                    start();
                    this.f4959p.hide();
                }
                return true;
            }
            if (i == 126) {
                if (!this.f4953j.isPlaying()) {
                    start();
                    this.f4959p.hide();
                }
                return true;
            }
            if (i == 86 || i == 127) {
                if (this.f4953j.isPlaying()) {
                    pause();
                    this.f4959p.show();
                }
                return true;
            }
            m5304h();
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* renamed from: h */
    private void m5304h() {
        if (this.f4959p.isShowing()) {
            this.f4959p.hide();
        } else {
            this.f4959p.show();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (m5307i()) {
            this.f4953j.start();
            this.f4950g = 3;
            InterfaceC1769a interfaceC1769a = this.f4942W;
            if (interfaceC1769a != null) {
                interfaceC1769a.mo3974a();
            }
        }
        this.f4951h = 3;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (m5307i() && this.f4953j.isPlaying()) {
            this.f4953j.pause();
            this.f4950g = 4;
            InterfaceC1769a interfaceC1769a = this.f4942W;
            if (interfaceC1769a != null) {
                interfaceC1769a.mo3975b();
            }
        }
        this.f4951h = 4;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (m5307i()) {
            return (int) this.f4953j.getDuration();
        }
        return -1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (m5307i()) {
            return (int) this.f4953j.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (m5307i()) {
            this.f4928H = System.currentTimeMillis();
            this.f4953j.seekTo(i);
            this.f4965v = 0;
            return;
        }
        this.f4965v = i;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return m5307i() && this.f4953j.isPlaying();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.f4953j != null) {
            return this.f4962s;
        }
        return 0;
    }

    /* renamed from: i */
    private boolean m5307i() {
        int i;
        return (this.f4953j == null || (i = this.f4950g) == -1 || i == 0 || i == 1) ? false : true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return this.f4966w;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.f4967x;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.f4968y;
    }

    /* renamed from: j */
    private void m5310j() {
        this.f4939T.clear();
        if (this.f4921A.m5258i()) {
            this.f4939T.add(1);
        }
        if (this.f4921A.m5259j() && Build.VERSION.SDK_INT >= 14) {
            this.f4939T.add(2);
        }
        if (this.f4921A.m5257h()) {
            this.f4939T.add(0);
        }
        if (this.f4939T.isEmpty()) {
            this.f4939T.add(1);
        }
        this.f4941V = this.f4939T.get(this.f4940U).intValue();
        setRender(this.f4941V);
    }

    public void setOnPlayerStatusListener(InterfaceC1769a interfaceC1769a) {
        this.f4942W = interfaceC1769a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public IMediaPlayer m5326a(int i) {
        AndroidMediaPlayer androidMediaPlayer = null;
        if (i == 1) {
            androidMediaPlayer = new AndroidMediaPlayer();
        } else if (i == 3) {
            try {
                throw new Exception("player type error");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (this.f4948e != null) {
            IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
            IjkMediaPlayer.native_setLogLevel(4);
            if (this.f4921A.usingMediaCodec()) {
                Log.d(this.f4947d, "Video decoding using MediaCodec");
                ijkMediaPlayer.setOption(4, "mediacodec", 1L);
                if (this.f4921A.usingMediaCodecAutoRotate()) {
                    ijkMediaPlayer.setOption(4, "mediacodec-auto-rotate", 1L);
                } else {
                    ijkMediaPlayer.setOption(4, "mediacodec-auto-rotate", 0L);
                }
                if (this.f4921A.mediaCodecHandleResolutionChange()) {
                    ijkMediaPlayer.setOption(4, "mediacodec-handle-resolution-change", 1L);
                } else {
                    ijkMediaPlayer.setOption(4, "mediacodec-handle-resolution-change", 0L);
                }
            } else {
                Log.d(this.f4947d, "Video decoding using soft codec");
                ijkMediaPlayer.setOption(4, "mediacodec", 0L);
            }
            ijkMediaPlayer.setOption(1, "max-buffer-size", 4096L);
            ijkMediaPlayer.setOption(1, "fflags", "nobuffer");
            ijkMediaPlayer.setOption(1, "max_delay", 0L);
            ijkMediaPlayer.setOption(4, "packet-buffering", 0L);
            if (this.f4921A.m5255f()) {
                ijkMediaPlayer.setOption(4, "opensles", 1L);
            } else {
                ijkMediaPlayer.setOption(4, "opensles", 0L);
            }
            String m5256g = this.f4921A.m5256g();
            if (TextUtils.isEmpty(m5256g)) {
                ijkMediaPlayer.setOption(4, "overlay-format", 842225234L);
            } else {
                ijkMediaPlayer.setOption(4, "overlay-format", m5256g);
            }
            ijkMediaPlayer.setOption(4, "framedrop", 1L);
            ijkMediaPlayer.setOption(4, "start-on-prepared", 0L);
            ijkMediaPlayer.setOption(1, "http-detect-range-support", 0L);
            ijkMediaPlayer.setOption(2, "skip_loop_filter", 48L);
            androidMediaPlayer = ijkMediaPlayer;
        }
        return this.f4921A.m5260k() ? new TextureMediaPlayer(androidMediaPlayer) : androidMediaPlayer;
    }

    /* renamed from: k */
    private void m5312k() {
        this.f4944aa = this.f4921A.enableBackgroundPlay();
        if (this.f4944aa) {
            MediaPlayerService.m5275b(getContext());
            this.f4953j = MediaPlayerService.m5273a();
            InfoHudViewHolder infoHudViewHolder = this.f4925E;
            if (infoHudViewHolder != null) {
                infoHudViewHolder.m5368a(this.f4953j);
            }
        }
    }

    /* renamed from: c */
    public boolean m5330c() {
        return this.f4944aa;
    }

    /* renamed from: d */
    public void m5331d() {
        MediaPlayerService.m5274a(this.f4953j);
    }

    /* renamed from: e */
    public void m5332e() {
        MediaPlayerService.m5274a((IMediaPlayer) null);
    }

    public ITrackInfo[] getTrackInfo() {
        IMediaPlayer iMediaPlayer = this.f4953j;
        if (iMediaPlayer == null) {
            return null;
        }
        return iMediaPlayer.getTrackInfo();
    }
}