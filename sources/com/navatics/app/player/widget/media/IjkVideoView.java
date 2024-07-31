package com.navatics.app.player.widget.media;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.p011v7.app.AlertDialog;
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
import com.navatics.app.player.C1860a;
import com.navatics.app.player.services.MediaPlayerService;
import com.navatics.app.player.widget.media.IRenderView;
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
    private static final int[] f4898Q = {0, 1, 2, 4, 5};

    /* renamed from: A */
    private C1860a f4899A;

    /* renamed from: B */
    private IRenderView f4900B;

    /* renamed from: C */
    private int f4901C;

    /* renamed from: D */
    private int f4902D;

    /* renamed from: E */
    private InfoHudViewHolder f4903E;

    /* renamed from: F */
    private long f4904F;

    /* renamed from: G */
    private long f4905G;

    /* renamed from: H */
    private long f4906H;

    /* renamed from: I */
    private long f4907I;

    /* renamed from: J */
    private TextView f4908J;

    /* renamed from: K */
    private IMediaPlayer.OnCompletionListener f4909K;

    /* renamed from: L */
    private IMediaPlayer.OnInfoListener f4910L;

    /* renamed from: M */
    private IMediaPlayer.OnErrorListener f4911M;

    /* renamed from: N */
    private IMediaPlayer.OnBufferingUpdateListener f4912N;

    /* renamed from: O */
    private IMediaPlayer.OnSeekCompleteListener f4913O;

    /* renamed from: P */
    private IMediaPlayer.OnTimedTextListener f4914P;

    /* renamed from: R */
    private int f4915R;

    /* renamed from: S */
    private int f4916S;

    /* renamed from: T */
    private List<Integer> f4917T;

    /* renamed from: U */
    private int f4918U;

    /* renamed from: V */
    private int f4919V;

    /* renamed from: W */
    private InterfaceC1876a f4920W;

    /* renamed from: a */
    IMediaPlayer.OnVideoSizeChangedListener f4921a;

    /* renamed from: aa */
    private boolean f4922aa;

    /* renamed from: b */
    IMediaPlayer.OnPreparedListener f4923b;

    /* renamed from: c */
    IRenderView.InterfaceC1881a f4924c;

    /* renamed from: d */
    private String f4925d;

    /* renamed from: e */
    private Uri f4926e;

    /* renamed from: f */
    private Map<String, String> f4927f;

    /* renamed from: g */
    private int f4928g;

    /* renamed from: h */
    private int f4929h;

    /* renamed from: i */
    private IRenderView.InterfaceC1882b f4930i;

    /* renamed from: j */
    private IMediaPlayer f4931j;

    /* renamed from: k */
    private int f4932k;

    /* renamed from: l */
    private int f4933l;

    /* renamed from: m */
    private int f4934m;

    /* renamed from: n */
    private int f4935n;

    /* renamed from: o */
    private int f4936o;

    /* renamed from: p */
    private IMediaController f4937p;

    /* renamed from: q */
    private IMediaPlayer.OnCompletionListener f4938q;

    /* renamed from: r */
    private IMediaPlayer.OnPreparedListener f4939r;

    /* renamed from: s */
    private int f4940s;

    /* renamed from: t */
    private IMediaPlayer.OnErrorListener f4941t;

    /* renamed from: u */
    private IMediaPlayer.OnInfoListener f4942u;

    /* renamed from: v */
    private int f4943v;

    /* renamed from: w */
    private boolean f4944w;

    /* renamed from: x */
    private boolean f4945x;

    /* renamed from: y */
    private boolean f4946y;

    /* renamed from: z */
    private Context f4947z;

    /* renamed from: com.navatics.app.player.widget.media.IjkVideoView$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1876a {
        /* renamed from: a */
        void mo7579a();

        /* renamed from: b */
        void mo7578b();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    public IjkVideoView(Context context) {
        super(context);
        this.f4925d = "IjkVideoView";
        this.f4928g = 0;
        this.f4929h = 0;
        this.f4930i = null;
        this.f4931j = null;
        this.f4944w = true;
        this.f4945x = true;
        this.f4946y = true;
        this.f4904F = 0L;
        this.f4905G = 0L;
        this.f4906H = 0L;
        this.f4907I = 0L;
        this.f4921a = new IMediaPlayer.OnVideoSizeChangedListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.1
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
                IjkVideoView.this.f4932k = iMediaPlayer.getVideoWidth();
                IjkVideoView.this.f4933l = iMediaPlayer.getVideoHeight();
                IjkVideoView.this.f4901C = iMediaPlayer.getVideoSarNum();
                IjkVideoView.this.f4902D = iMediaPlayer.getVideoSarDen();
                if (IjkVideoView.this.f4932k == 0 || IjkVideoView.this.f4933l == 0) {
                    return;
                }
                if (IjkVideoView.this.f4900B != null) {
                    IjkVideoView.this.f4900B.mo7564a(IjkVideoView.this.f4932k, IjkVideoView.this.f4933l);
                    IjkVideoView.this.f4900B.mo7562b(IjkVideoView.this.f4901C, IjkVideoView.this.f4902D);
                }
                Log.i("layout_debug", "requestLayout");
                IjkVideoView.this.requestLayout();
            }
        };
        this.f4923b = new IMediaPlayer.OnPreparedListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.2
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.f4905G = System.currentTimeMillis();
                if (IjkVideoView.this.f4903E != null) {
                    IjkVideoView.this.f4903E.m7554a(IjkVideoView.this.f4905G - IjkVideoView.this.f4904F);
                }
                IjkVideoView.this.f4928g = 2;
                if (IjkVideoView.this.f4939r != null) {
                    IjkVideoView.this.f4939r.onPrepared(IjkVideoView.this.f4931j);
                }
                if (IjkVideoView.this.f4937p != null) {
                    IjkVideoView.this.f4937p.setEnabled(true);
                }
                IjkVideoView.this.f4932k = iMediaPlayer.getVideoWidth();
                IjkVideoView.this.f4933l = iMediaPlayer.getVideoHeight();
                int i = IjkVideoView.this.f4943v;
                if (i != 0) {
                    IjkVideoView.this.seekTo(i);
                }
                if (IjkVideoView.this.f4932k == 0 || IjkVideoView.this.f4933l == 0) {
                    if (IjkVideoView.this.f4929h == 3) {
                        IjkVideoView.this.start();
                    }
                } else if (IjkVideoView.this.f4900B != null) {
                    IjkVideoView.this.f4900B.mo7564a(IjkVideoView.this.f4932k, IjkVideoView.this.f4933l);
                    IjkVideoView.this.f4900B.mo7562b(IjkVideoView.this.f4901C, IjkVideoView.this.f4902D);
                    if (!IjkVideoView.this.f4900B.mo7565a() || (IjkVideoView.this.f4934m == IjkVideoView.this.f4932k && IjkVideoView.this.f4935n == IjkVideoView.this.f4933l)) {
                        if (IjkVideoView.this.f4929h == 3) {
                            IjkVideoView.this.start();
                            if (IjkVideoView.this.f4937p != null) {
                                IjkVideoView.this.f4937p.show();
                            }
                        } else if (IjkVideoView.this.isPlaying()) {
                        } else {
                            if ((i != 0 || IjkVideoView.this.getCurrentPosition() > 0) && IjkVideoView.this.f4937p != null) {
                                IjkVideoView.this.f4937p.show(0);
                            }
                        }
                    }
                }
            }
        };
        this.f4909K = new IMediaPlayer.OnCompletionListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.3
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.f4928g = 5;
                IjkVideoView.this.f4929h = 5;
                if (IjkVideoView.this.f4937p != null) {
                    IjkVideoView.this.f4937p.hide();
                }
                if (IjkVideoView.this.f4938q != null) {
                    IjkVideoView.this.f4938q.onCompletion(IjkVideoView.this.f4931j);
                }
            }
        };
        this.f4910L = new IMediaPlayer.OnInfoListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.4
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
                if (IjkVideoView.this.f4942u != null) {
                    IjkVideoView.this.f4942u.onInfo(iMediaPlayer, i, i2);
                }
                switch (i) {
                    case 3:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_VIDEO_RENDERING_START:");
                        return true;
                    case 700:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_BUFFERING_START:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_BUFFERING_END:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                        String str = IjkVideoView.this.f4925d;
                        Log.d(str, "MEDIA_INFO_NETWORK_BANDWIDTH: " + i2);
                        return true;
                    case 800:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_BAD_INTERLEAVING:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_NOT_SEEKABLE:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_METADATA_UPDATE:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_UNSUPPORTED_SUBTITLE /* 901 */:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_SUBTITLE_TIMED_OUT /* 902 */:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
                        return true;
                    case 10001:
                        IjkVideoView.this.f4936o = i2;
                        String str2 = IjkVideoView.this.f4925d;
                        Log.d(str2, "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
                        if (IjkVideoView.this.f4900B != null) {
                            IjkVideoView.this.f4900B.setVideoRotation(i2);
                            return true;
                        }
                        return true;
                    case 10002:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_AUDIO_RENDERING_START:");
                        return true;
                    default:
                        return true;
                }
            }
        };
        this.f4911M = new IMediaPlayer.OnErrorListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.5
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
                String str = IjkVideoView.this.f4925d;
                Log.d(str, "Error: " + i + "," + i2);
                IjkVideoView.this.f4928g = -1;
                IjkVideoView.this.f4929h = -1;
                if (IjkVideoView.this.f4937p != null) {
                    IjkVideoView.this.f4937p.hide();
                }
                if ((IjkVideoView.this.f4941t == null || !IjkVideoView.this.f4941t.onError(IjkVideoView.this.f4931j, i, i2)) && IjkVideoView.this.getWindowToken() != null) {
                    IjkVideoView.this.f4947z.getResources();
                    new AlertDialog.Builder(IjkVideoView.this.getContext()).setMessage(i == 200 ? R.string.VideoView_error_text_invalid_progressive_playback : R.string.VideoView_error_text_unknown).setPositiveButton(R.string.VideoView_error_button, new DialogInterface.OnClickListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.5.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            if (IjkVideoView.this.f4938q != null) {
                                IjkVideoView.this.f4938q.onCompletion(IjkVideoView.this.f4931j);
                            }
                        }
                    }).setCancelable(false).show();
                }
                return true;
            }
        };
        this.f4912N = new IMediaPlayer.OnBufferingUpdateListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.6
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
                IjkVideoView.this.f4940s = i;
            }
        };
        this.f4913O = new IMediaPlayer.OnSeekCompleteListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.7
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.f4907I = System.currentTimeMillis();
                if (IjkVideoView.this.f4903E != null) {
                    IjkVideoView.this.f4903E.m7549b(IjkVideoView.this.f4907I - IjkVideoView.this.f4906H);
                }
            }
        };
        this.f4914P = new IMediaPlayer.OnTimedTextListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.8
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener
            public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
                if (ijkTimedText != null) {
                    IjkVideoView.this.f4908J.setText(ijkTimedText.getText());
                }
            }
        };
        this.f4924c = new IRenderView.InterfaceC1881a() { // from class: com.navatics.app.player.widget.media.IjkVideoView.9
            @Override // com.navatics.app.player.widget.media.IRenderView.InterfaceC1881a
            /* renamed from: a */
            public void mo7558a(@NonNull IRenderView.InterfaceC1882b interfaceC1882b, int i, int i2, int i3) {
                if (interfaceC1882b.mo7557a() != IjkVideoView.this.f4900B) {
                    Log.e(IjkVideoView.this.f4925d, "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.f4934m = i2;
                IjkVideoView.this.f4935n = i3;
                boolean z = true;
                boolean z2 = IjkVideoView.this.f4929h == 3;
                if (IjkVideoView.this.f4900B.mo7565a() && (IjkVideoView.this.f4932k != i2 || IjkVideoView.this.f4933l != i3)) {
                    z = false;
                }
                if (IjkVideoView.this.f4931j != null && z2 && z) {
                    if (IjkVideoView.this.f4943v != 0) {
                        IjkVideoView ijkVideoView = IjkVideoView.this;
                        ijkVideoView.seekTo(ijkVideoView.f4943v);
                    }
                    IjkVideoView.this.start();
                }
            }

            @Override // com.navatics.app.player.widget.media.IRenderView.InterfaceC1881a
            /* renamed from: a */
            public void mo7559a(@NonNull IRenderView.InterfaceC1882b interfaceC1882b, int i, int i2) {
                if (interfaceC1882b.mo7557a() != IjkVideoView.this.f4900B) {
                    Log.e(IjkVideoView.this.f4925d, "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.f4930i = interfaceC1882b;
                if (IjkVideoView.this.f4931j == null) {
                    IjkVideoView.this.m7609f();
                    return;
                }
                IjkVideoView ijkVideoView = IjkVideoView.this;
                ijkVideoView.m7624a(ijkVideoView.f4931j, interfaceC1882b);
            }

            @Override // com.navatics.app.player.widget.media.IRenderView.InterfaceC1881a
            /* renamed from: a */
            public void mo7560a(@NonNull IRenderView.InterfaceC1882b interfaceC1882b) {
                if (interfaceC1882b.mo7557a() != IjkVideoView.this.f4900B) {
                    Log.e(IjkVideoView.this.f4925d, "onSurfaceDestroyed: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.f4930i = null;
                IjkVideoView.this.m7622b();
            }
        };
        this.f4915R = 0;
        this.f4916S = f4898Q[0];
        this.f4917T = new ArrayList();
        this.f4918U = 0;
        this.f4919V = 0;
        this.f4922aa = false;
        m7631a(context);
    }

    public IjkVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4925d = "IjkVideoView";
        this.f4928g = 0;
        this.f4929h = 0;
        this.f4930i = null;
        this.f4931j = null;
        this.f4944w = true;
        this.f4945x = true;
        this.f4946y = true;
        this.f4904F = 0L;
        this.f4905G = 0L;
        this.f4906H = 0L;
        this.f4907I = 0L;
        this.f4921a = new IMediaPlayer.OnVideoSizeChangedListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.1
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
                IjkVideoView.this.f4932k = iMediaPlayer.getVideoWidth();
                IjkVideoView.this.f4933l = iMediaPlayer.getVideoHeight();
                IjkVideoView.this.f4901C = iMediaPlayer.getVideoSarNum();
                IjkVideoView.this.f4902D = iMediaPlayer.getVideoSarDen();
                if (IjkVideoView.this.f4932k == 0 || IjkVideoView.this.f4933l == 0) {
                    return;
                }
                if (IjkVideoView.this.f4900B != null) {
                    IjkVideoView.this.f4900B.mo7564a(IjkVideoView.this.f4932k, IjkVideoView.this.f4933l);
                    IjkVideoView.this.f4900B.mo7562b(IjkVideoView.this.f4901C, IjkVideoView.this.f4902D);
                }
                Log.i("layout_debug", "requestLayout");
                IjkVideoView.this.requestLayout();
            }
        };
        this.f4923b = new IMediaPlayer.OnPreparedListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.2
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.f4905G = System.currentTimeMillis();
                if (IjkVideoView.this.f4903E != null) {
                    IjkVideoView.this.f4903E.m7554a(IjkVideoView.this.f4905G - IjkVideoView.this.f4904F);
                }
                IjkVideoView.this.f4928g = 2;
                if (IjkVideoView.this.f4939r != null) {
                    IjkVideoView.this.f4939r.onPrepared(IjkVideoView.this.f4931j);
                }
                if (IjkVideoView.this.f4937p != null) {
                    IjkVideoView.this.f4937p.setEnabled(true);
                }
                IjkVideoView.this.f4932k = iMediaPlayer.getVideoWidth();
                IjkVideoView.this.f4933l = iMediaPlayer.getVideoHeight();
                int i = IjkVideoView.this.f4943v;
                if (i != 0) {
                    IjkVideoView.this.seekTo(i);
                }
                if (IjkVideoView.this.f4932k == 0 || IjkVideoView.this.f4933l == 0) {
                    if (IjkVideoView.this.f4929h == 3) {
                        IjkVideoView.this.start();
                    }
                } else if (IjkVideoView.this.f4900B != null) {
                    IjkVideoView.this.f4900B.mo7564a(IjkVideoView.this.f4932k, IjkVideoView.this.f4933l);
                    IjkVideoView.this.f4900B.mo7562b(IjkVideoView.this.f4901C, IjkVideoView.this.f4902D);
                    if (!IjkVideoView.this.f4900B.mo7565a() || (IjkVideoView.this.f4934m == IjkVideoView.this.f4932k && IjkVideoView.this.f4935n == IjkVideoView.this.f4933l)) {
                        if (IjkVideoView.this.f4929h == 3) {
                            IjkVideoView.this.start();
                            if (IjkVideoView.this.f4937p != null) {
                                IjkVideoView.this.f4937p.show();
                            }
                        } else if (IjkVideoView.this.isPlaying()) {
                        } else {
                            if ((i != 0 || IjkVideoView.this.getCurrentPosition() > 0) && IjkVideoView.this.f4937p != null) {
                                IjkVideoView.this.f4937p.show(0);
                            }
                        }
                    }
                }
            }
        };
        this.f4909K = new IMediaPlayer.OnCompletionListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.3
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.f4928g = 5;
                IjkVideoView.this.f4929h = 5;
                if (IjkVideoView.this.f4937p != null) {
                    IjkVideoView.this.f4937p.hide();
                }
                if (IjkVideoView.this.f4938q != null) {
                    IjkVideoView.this.f4938q.onCompletion(IjkVideoView.this.f4931j);
                }
            }
        };
        this.f4910L = new IMediaPlayer.OnInfoListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.4
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
                if (IjkVideoView.this.f4942u != null) {
                    IjkVideoView.this.f4942u.onInfo(iMediaPlayer, i, i2);
                }
                switch (i) {
                    case 3:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_VIDEO_RENDERING_START:");
                        return true;
                    case 700:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_BUFFERING_START:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_BUFFERING_END:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                        String str = IjkVideoView.this.f4925d;
                        Log.d(str, "MEDIA_INFO_NETWORK_BANDWIDTH: " + i2);
                        return true;
                    case 800:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_BAD_INTERLEAVING:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_NOT_SEEKABLE:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_METADATA_UPDATE:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_UNSUPPORTED_SUBTITLE /* 901 */:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_SUBTITLE_TIMED_OUT /* 902 */:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
                        return true;
                    case 10001:
                        IjkVideoView.this.f4936o = i2;
                        String str2 = IjkVideoView.this.f4925d;
                        Log.d(str2, "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
                        if (IjkVideoView.this.f4900B != null) {
                            IjkVideoView.this.f4900B.setVideoRotation(i2);
                            return true;
                        }
                        return true;
                    case 10002:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_AUDIO_RENDERING_START:");
                        return true;
                    default:
                        return true;
                }
            }
        };
        this.f4911M = new IMediaPlayer.OnErrorListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.5
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
                String str = IjkVideoView.this.f4925d;
                Log.d(str, "Error: " + i + "," + i2);
                IjkVideoView.this.f4928g = -1;
                IjkVideoView.this.f4929h = -1;
                if (IjkVideoView.this.f4937p != null) {
                    IjkVideoView.this.f4937p.hide();
                }
                if ((IjkVideoView.this.f4941t == null || !IjkVideoView.this.f4941t.onError(IjkVideoView.this.f4931j, i, i2)) && IjkVideoView.this.getWindowToken() != null) {
                    IjkVideoView.this.f4947z.getResources();
                    new AlertDialog.Builder(IjkVideoView.this.getContext()).setMessage(i == 200 ? R.string.VideoView_error_text_invalid_progressive_playback : R.string.VideoView_error_text_unknown).setPositiveButton(R.string.VideoView_error_button, new DialogInterface.OnClickListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.5.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            if (IjkVideoView.this.f4938q != null) {
                                IjkVideoView.this.f4938q.onCompletion(IjkVideoView.this.f4931j);
                            }
                        }
                    }).setCancelable(false).show();
                }
                return true;
            }
        };
        this.f4912N = new IMediaPlayer.OnBufferingUpdateListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.6
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
                IjkVideoView.this.f4940s = i;
            }
        };
        this.f4913O = new IMediaPlayer.OnSeekCompleteListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.7
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.f4907I = System.currentTimeMillis();
                if (IjkVideoView.this.f4903E != null) {
                    IjkVideoView.this.f4903E.m7549b(IjkVideoView.this.f4907I - IjkVideoView.this.f4906H);
                }
            }
        };
        this.f4914P = new IMediaPlayer.OnTimedTextListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.8
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener
            public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
                if (ijkTimedText != null) {
                    IjkVideoView.this.f4908J.setText(ijkTimedText.getText());
                }
            }
        };
        this.f4924c = new IRenderView.InterfaceC1881a() { // from class: com.navatics.app.player.widget.media.IjkVideoView.9
            @Override // com.navatics.app.player.widget.media.IRenderView.InterfaceC1881a
            /* renamed from: a */
            public void mo7558a(@NonNull IRenderView.InterfaceC1882b interfaceC1882b, int i, int i2, int i3) {
                if (interfaceC1882b.mo7557a() != IjkVideoView.this.f4900B) {
                    Log.e(IjkVideoView.this.f4925d, "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.f4934m = i2;
                IjkVideoView.this.f4935n = i3;
                boolean z = true;
                boolean z2 = IjkVideoView.this.f4929h == 3;
                if (IjkVideoView.this.f4900B.mo7565a() && (IjkVideoView.this.f4932k != i2 || IjkVideoView.this.f4933l != i3)) {
                    z = false;
                }
                if (IjkVideoView.this.f4931j != null && z2 && z) {
                    if (IjkVideoView.this.f4943v != 0) {
                        IjkVideoView ijkVideoView = IjkVideoView.this;
                        ijkVideoView.seekTo(ijkVideoView.f4943v);
                    }
                    IjkVideoView.this.start();
                }
            }

            @Override // com.navatics.app.player.widget.media.IRenderView.InterfaceC1881a
            /* renamed from: a */
            public void mo7559a(@NonNull IRenderView.InterfaceC1882b interfaceC1882b, int i, int i2) {
                if (interfaceC1882b.mo7557a() != IjkVideoView.this.f4900B) {
                    Log.e(IjkVideoView.this.f4925d, "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.f4930i = interfaceC1882b;
                if (IjkVideoView.this.f4931j == null) {
                    IjkVideoView.this.m7609f();
                    return;
                }
                IjkVideoView ijkVideoView = IjkVideoView.this;
                ijkVideoView.m7624a(ijkVideoView.f4931j, interfaceC1882b);
            }

            @Override // com.navatics.app.player.widget.media.IRenderView.InterfaceC1881a
            /* renamed from: a */
            public void mo7560a(@NonNull IRenderView.InterfaceC1882b interfaceC1882b) {
                if (interfaceC1882b.mo7557a() != IjkVideoView.this.f4900B) {
                    Log.e(IjkVideoView.this.f4925d, "onSurfaceDestroyed: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.f4930i = null;
                IjkVideoView.this.m7622b();
            }
        };
        this.f4915R = 0;
        this.f4916S = f4898Q[0];
        this.f4917T = new ArrayList();
        this.f4918U = 0;
        this.f4919V = 0;
        this.f4922aa = false;
        m7631a(context);
    }

    public IjkVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4925d = "IjkVideoView";
        this.f4928g = 0;
        this.f4929h = 0;
        this.f4930i = null;
        this.f4931j = null;
        this.f4944w = true;
        this.f4945x = true;
        this.f4946y = true;
        this.f4904F = 0L;
        this.f4905G = 0L;
        this.f4906H = 0L;
        this.f4907I = 0L;
        this.f4921a = new IMediaPlayer.OnVideoSizeChangedListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.1
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i2, int i22, int i3, int i4) {
                IjkVideoView.this.f4932k = iMediaPlayer.getVideoWidth();
                IjkVideoView.this.f4933l = iMediaPlayer.getVideoHeight();
                IjkVideoView.this.f4901C = iMediaPlayer.getVideoSarNum();
                IjkVideoView.this.f4902D = iMediaPlayer.getVideoSarDen();
                if (IjkVideoView.this.f4932k == 0 || IjkVideoView.this.f4933l == 0) {
                    return;
                }
                if (IjkVideoView.this.f4900B != null) {
                    IjkVideoView.this.f4900B.mo7564a(IjkVideoView.this.f4932k, IjkVideoView.this.f4933l);
                    IjkVideoView.this.f4900B.mo7562b(IjkVideoView.this.f4901C, IjkVideoView.this.f4902D);
                }
                Log.i("layout_debug", "requestLayout");
                IjkVideoView.this.requestLayout();
            }
        };
        this.f4923b = new IMediaPlayer.OnPreparedListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.2
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.f4905G = System.currentTimeMillis();
                if (IjkVideoView.this.f4903E != null) {
                    IjkVideoView.this.f4903E.m7554a(IjkVideoView.this.f4905G - IjkVideoView.this.f4904F);
                }
                IjkVideoView.this.f4928g = 2;
                if (IjkVideoView.this.f4939r != null) {
                    IjkVideoView.this.f4939r.onPrepared(IjkVideoView.this.f4931j);
                }
                if (IjkVideoView.this.f4937p != null) {
                    IjkVideoView.this.f4937p.setEnabled(true);
                }
                IjkVideoView.this.f4932k = iMediaPlayer.getVideoWidth();
                IjkVideoView.this.f4933l = iMediaPlayer.getVideoHeight();
                int i2 = IjkVideoView.this.f4943v;
                if (i2 != 0) {
                    IjkVideoView.this.seekTo(i2);
                }
                if (IjkVideoView.this.f4932k == 0 || IjkVideoView.this.f4933l == 0) {
                    if (IjkVideoView.this.f4929h == 3) {
                        IjkVideoView.this.start();
                    }
                } else if (IjkVideoView.this.f4900B != null) {
                    IjkVideoView.this.f4900B.mo7564a(IjkVideoView.this.f4932k, IjkVideoView.this.f4933l);
                    IjkVideoView.this.f4900B.mo7562b(IjkVideoView.this.f4901C, IjkVideoView.this.f4902D);
                    if (!IjkVideoView.this.f4900B.mo7565a() || (IjkVideoView.this.f4934m == IjkVideoView.this.f4932k && IjkVideoView.this.f4935n == IjkVideoView.this.f4933l)) {
                        if (IjkVideoView.this.f4929h == 3) {
                            IjkVideoView.this.start();
                            if (IjkVideoView.this.f4937p != null) {
                                IjkVideoView.this.f4937p.show();
                            }
                        } else if (IjkVideoView.this.isPlaying()) {
                        } else {
                            if ((i2 != 0 || IjkVideoView.this.getCurrentPosition() > 0) && IjkVideoView.this.f4937p != null) {
                                IjkVideoView.this.f4937p.show(0);
                            }
                        }
                    }
                }
            }
        };
        this.f4909K = new IMediaPlayer.OnCompletionListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.3
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.f4928g = 5;
                IjkVideoView.this.f4929h = 5;
                if (IjkVideoView.this.f4937p != null) {
                    IjkVideoView.this.f4937p.hide();
                }
                if (IjkVideoView.this.f4938q != null) {
                    IjkVideoView.this.f4938q.onCompletion(IjkVideoView.this.f4931j);
                }
            }
        };
        this.f4910L = new IMediaPlayer.OnInfoListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.4
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i2, int i22) {
                if (IjkVideoView.this.f4942u != null) {
                    IjkVideoView.this.f4942u.onInfo(iMediaPlayer, i2, i22);
                }
                switch (i2) {
                    case 3:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_VIDEO_RENDERING_START:");
                        return true;
                    case 700:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_BUFFERING_START:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_BUFFERING_END:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                        String str = IjkVideoView.this.f4925d;
                        Log.d(str, "MEDIA_INFO_NETWORK_BANDWIDTH: " + i22);
                        return true;
                    case 800:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_BAD_INTERLEAVING:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_NOT_SEEKABLE:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_METADATA_UPDATE:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_UNSUPPORTED_SUBTITLE /* 901 */:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_SUBTITLE_TIMED_OUT /* 902 */:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
                        return true;
                    case 10001:
                        IjkVideoView.this.f4936o = i22;
                        String str2 = IjkVideoView.this.f4925d;
                        Log.d(str2, "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i22);
                        if (IjkVideoView.this.f4900B != null) {
                            IjkVideoView.this.f4900B.setVideoRotation(i22);
                            return true;
                        }
                        return true;
                    case 10002:
                        Log.d(IjkVideoView.this.f4925d, "MEDIA_INFO_AUDIO_RENDERING_START:");
                        return true;
                    default:
                        return true;
                }
            }
        };
        this.f4911M = new IMediaPlayer.OnErrorListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.5
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public boolean onError(IMediaPlayer iMediaPlayer, int i2, int i22) {
                String str = IjkVideoView.this.f4925d;
                Log.d(str, "Error: " + i2 + "," + i22);
                IjkVideoView.this.f4928g = -1;
                IjkVideoView.this.f4929h = -1;
                if (IjkVideoView.this.f4937p != null) {
                    IjkVideoView.this.f4937p.hide();
                }
                if ((IjkVideoView.this.f4941t == null || !IjkVideoView.this.f4941t.onError(IjkVideoView.this.f4931j, i2, i22)) && IjkVideoView.this.getWindowToken() != null) {
                    IjkVideoView.this.f4947z.getResources();
                    new AlertDialog.Builder(IjkVideoView.this.getContext()).setMessage(i2 == 200 ? R.string.VideoView_error_text_invalid_progressive_playback : R.string.VideoView_error_text_unknown).setPositiveButton(R.string.VideoView_error_button, new DialogInterface.OnClickListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.5.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            if (IjkVideoView.this.f4938q != null) {
                                IjkVideoView.this.f4938q.onCompletion(IjkVideoView.this.f4931j);
                            }
                        }
                    }).setCancelable(false).show();
                }
                return true;
            }
        };
        this.f4912N = new IMediaPlayer.OnBufferingUpdateListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.6
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i2) {
                IjkVideoView.this.f4940s = i2;
            }
        };
        this.f4913O = new IMediaPlayer.OnSeekCompleteListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.7
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.f4907I = System.currentTimeMillis();
                if (IjkVideoView.this.f4903E != null) {
                    IjkVideoView.this.f4903E.m7549b(IjkVideoView.this.f4907I - IjkVideoView.this.f4906H);
                }
            }
        };
        this.f4914P = new IMediaPlayer.OnTimedTextListener() { // from class: com.navatics.app.player.widget.media.IjkVideoView.8
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener
            public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
                if (ijkTimedText != null) {
                    IjkVideoView.this.f4908J.setText(ijkTimedText.getText());
                }
            }
        };
        this.f4924c = new IRenderView.InterfaceC1881a() { // from class: com.navatics.app.player.widget.media.IjkVideoView.9
            @Override // com.navatics.app.player.widget.media.IRenderView.InterfaceC1881a
            /* renamed from: a */
            public void mo7558a(@NonNull IRenderView.InterfaceC1882b interfaceC1882b, int i2, int i22, int i3) {
                if (interfaceC1882b.mo7557a() != IjkVideoView.this.f4900B) {
                    Log.e(IjkVideoView.this.f4925d, "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.f4934m = i22;
                IjkVideoView.this.f4935n = i3;
                boolean z = true;
                boolean z2 = IjkVideoView.this.f4929h == 3;
                if (IjkVideoView.this.f4900B.mo7565a() && (IjkVideoView.this.f4932k != i22 || IjkVideoView.this.f4933l != i3)) {
                    z = false;
                }
                if (IjkVideoView.this.f4931j != null && z2 && z) {
                    if (IjkVideoView.this.f4943v != 0) {
                        IjkVideoView ijkVideoView = IjkVideoView.this;
                        ijkVideoView.seekTo(ijkVideoView.f4943v);
                    }
                    IjkVideoView.this.start();
                }
            }

            @Override // com.navatics.app.player.widget.media.IRenderView.InterfaceC1881a
            /* renamed from: a */
            public void mo7559a(@NonNull IRenderView.InterfaceC1882b interfaceC1882b, int i2, int i22) {
                if (interfaceC1882b.mo7557a() != IjkVideoView.this.f4900B) {
                    Log.e(IjkVideoView.this.f4925d, "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.f4930i = interfaceC1882b;
                if (IjkVideoView.this.f4931j == null) {
                    IjkVideoView.this.m7609f();
                    return;
                }
                IjkVideoView ijkVideoView = IjkVideoView.this;
                ijkVideoView.m7624a(ijkVideoView.f4931j, interfaceC1882b);
            }

            @Override // com.navatics.app.player.widget.media.IRenderView.InterfaceC1881a
            /* renamed from: a */
            public void mo7560a(@NonNull IRenderView.InterfaceC1882b interfaceC1882b) {
                if (interfaceC1882b.mo7557a() != IjkVideoView.this.f4900B) {
                    Log.e(IjkVideoView.this.f4925d, "onSurfaceDestroyed: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.f4930i = null;
                IjkVideoView.this.m7622b();
            }
        };
        this.f4915R = 0;
        this.f4916S = f4898Q[0];
        this.f4917T = new ArrayList();
        this.f4918U = 0;
        this.f4919V = 0;
        this.f4922aa = false;
        m7631a(context);
    }

    /* renamed from: a */
    private void m7631a(Context context) {
        this.f4947z = context.getApplicationContext();
        this.f4899A = new C1860a(this.f4947z);
        m7594k();
        m7597j();
        this.f4932k = 0;
        this.f4933l = 0;
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f4928g = 0;
        this.f4929h = 0;
        this.f4908J = new TextView(context);
        this.f4908J.setTextSize(24.0f);
        this.f4908J.setGravity(17);
        addView(this.f4908J, new FrameLayout.LayoutParams(-1, -2));
    }

    public void setRenderView(IRenderView iRenderView) {
        int i;
        int i2;
        if (this.f4900B != null) {
            IMediaPlayer iMediaPlayer = this.f4931j;
            if (iMediaPlayer != null) {
                iMediaPlayer.setDisplay(null);
            }
            View view = this.f4900B.getView();
            this.f4900B.mo7561b(this.f4924c);
            this.f4900B = null;
            removeView(view);
        }
        if (iRenderView == null) {
            return;
        }
        this.f4900B = iRenderView;
        iRenderView.setAspectRatio(this.f4916S);
        int i3 = this.f4932k;
        if (i3 > 0 && (i2 = this.f4933l) > 0) {
            iRenderView.mo7564a(i3, i2);
        }
        int i4 = this.f4901C;
        if (i4 > 0 && (i = this.f4902D) > 0) {
            iRenderView.mo7562b(i4, i);
        }
        View view2 = this.f4900B.getView();
        view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, iRenderView.getVideoPosition()));
        addView(view2);
        this.f4900B.mo7563a(this.f4924c);
        this.f4900B.setVideoRotation(this.f4936o);
    }

    public Bitmap getFrameBitmap() {
        return this.f4900B.getFrameBitmap();
    }

    public void setRender(int i) {
        switch (i) {
            case 0:
                setRenderView(null);
                Log.d(this.f4925d, "Using RENDER_NONE");
                return;
            case 1:
                Log.d(this.f4925d, "Using RENDER_SURFACE_VIEW");
                setRenderView(new SurfaceRenderView(getContext()));
                return;
            case 2:
                TextureRenderView textureRenderView = new TextureRenderView(getContext());
                if (this.f4931j != null) {
                    textureRenderView.getSurfaceHolder().mo7556a(this.f4931j);
                    textureRenderView.mo7564a(this.f4931j.getVideoWidth(), this.f4931j.getVideoHeight());
                    textureRenderView.mo7562b(this.f4931j.getVideoSarNum(), this.f4931j.getVideoSarDen());
                    textureRenderView.setAspectRatio(this.f4916S);
                }
                setRenderView(textureRenderView);
                Log.d(this.f4925d, "Using RENDER_TEXTURE_VIEW");
                return;
            default:
                Log.e(this.f4925d, String.format(Locale.getDefault(), "invalid render %d\n", Integer.valueOf(i)));
                return;
        }
    }

    public void setHudView(TableLayout tableLayout) {
        this.f4903E = new InfoHudViewHolder(getContext(), tableLayout);
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        m7630a(uri, (Map<String, String>) null);
    }

    /* renamed from: a */
    private void m7630a(Uri uri, Map<String, String> map) {
        this.f4926e = uri;
        this.f4927f = map;
        this.f4943v = 0;
        m7609f();
        requestLayout();
        invalidate();
    }

    /* renamed from: a */
    public void m7633a() {
        IMediaPlayer iMediaPlayer = this.f4931j;
        if (iMediaPlayer != null) {
            iMediaPlayer.stop();
            this.f4931j.release();
            this.f4931j = null;
            InfoHudViewHolder infoHudViewHolder = this.f4903E;
            if (infoHudViewHolder != null) {
                infoHudViewHolder.m7550a((IMediaPlayer) null);
            }
            this.f4928g = 0;
            this.f4929h = 0;
            ((AudioManager) this.f4947z.getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    /* renamed from: f */
    public void m7609f() {
        if (this.f4926e == null || this.f4930i == null) {
            return;
        }
        m7623a(false);
        ((AudioManager) this.f4947z.getSystemService("audio")).requestAudioFocus(null, 3, 1);
        try {
            this.f4931j = m7632a(this.f4899A.m7661b());
            getContext();
            this.f4931j.setOnPreparedListener(this.f4923b);
            this.f4931j.setOnVideoSizeChangedListener(this.f4921a);
            this.f4931j.setOnCompletionListener(this.f4909K);
            this.f4931j.setOnErrorListener(this.f4911M);
            this.f4931j.setOnInfoListener(this.f4910L);
            this.f4931j.setOnBufferingUpdateListener(this.f4912N);
            this.f4931j.setOnSeekCompleteListener(this.f4913O);
            this.f4931j.setOnTimedTextListener(this.f4914P);
            this.f4940s = 0;
            String scheme = this.f4926e.getScheme();
            if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase("nvix")) {
                this.f4900B.setVideoPosition(0);
            }
            if (Build.VERSION.SDK_INT >= 23 && this.f4899A.m7651l() && (TextUtils.isEmpty(scheme) || scheme.equalsIgnoreCase("file"))) {
                this.f4931j.setDataSource(new FileMediaDataSource(new File(this.f4926e.toString())));
            } else if (Build.VERSION.SDK_INT >= 14) {
                this.f4931j.setDataSource(this.f4947z, this.f4926e, this.f4927f);
            } else {
                this.f4931j.setDataSource(this.f4926e.toString());
            }
            m7624a(this.f4931j, this.f4930i);
            this.f4931j.setAudioStreamType(3);
            this.f4931j.setScreenOnWhilePlaying(true);
            this.f4904F = System.currentTimeMillis();
            this.f4931j.prepareAsync();
            if (this.f4903E != null) {
                this.f4903E.m7550a(this.f4931j);
            }
            this.f4928g = 1;
            m7606g();
        } catch (IOException e) {
            String str = this.f4925d;
            Log.w(str, "Unable to open content: " + this.f4926e, e);
            this.f4928g = -1;
            this.f4929h = -1;
            this.f4911M.onError(this.f4931j, 1, 0);
        } catch (IllegalArgumentException e2) {
            String str2 = this.f4925d;
            Log.w(str2, "Unable to open content: " + this.f4926e, e2);
            this.f4928g = -1;
            this.f4929h = -1;
            this.f4911M.onError(this.f4931j, 1, 0);
        }
    }

    public void setMediaController(IMediaController iMediaController) {
        IMediaController iMediaController2 = this.f4937p;
        if (iMediaController2 != null) {
            iMediaController2.hide();
        }
        this.f4937p = iMediaController;
        m7606g();
    }

    /* renamed from: g */
    private void m7606g() {
        IMediaController iMediaController;
        if (this.f4931j == null || (iMediaController = this.f4937p) == null) {
            return;
        }
        iMediaController.setMediaPlayer(this);
        this.f4937p.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
        this.f4937p.setEnabled(m7600i());
    }

    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.f4939r = onPreparedListener;
    }

    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.f4938q = onCompletionListener;
    }

    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.f4941t = onErrorListener;
    }

    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.f4942u = onInfoListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7624a(IMediaPlayer iMediaPlayer, IRenderView.InterfaceC1882b interfaceC1882b) {
        if (iMediaPlayer == null) {
            return;
        }
        if (interfaceC1882b == null) {
            iMediaPlayer.setDisplay(null);
        } else {
            interfaceC1882b.mo7556a(iMediaPlayer);
        }
    }

    /* renamed from: b */
    public void m7622b() {
        IMediaPlayer iMediaPlayer = this.f4931j;
        if (iMediaPlayer != null) {
            iMediaPlayer.setDisplay(null);
        }
    }

    /* renamed from: a */
    public void m7623a(boolean z) {
        IMediaPlayer iMediaPlayer = this.f4931j;
        if (iMediaPlayer != null) {
            iMediaPlayer.reset();
            this.f4931j.release();
            this.f4931j = null;
            this.f4928g = 0;
            if (z) {
                this.f4929h = 0;
            }
            ((AudioManager) this.f4947z.getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!m7600i() || this.f4937p == null) {
            return false;
        }
        m7603h();
        return false;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!m7600i() || this.f4937p == null) {
            return false;
        }
        m7603h();
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 164 || i == 82 || i == 5 || i == 6) ? false : true;
        if (m7600i() && z && this.f4937p != null) {
            if (i == 79 || i == 85) {
                if (this.f4931j.isPlaying()) {
                    pause();
                    this.f4937p.show();
                } else {
                    start();
                    this.f4937p.hide();
                }
                return true;
            } else if (i == 126) {
                if (!this.f4931j.isPlaying()) {
                    start();
                    this.f4937p.hide();
                }
                return true;
            } else if (i == 86 || i == 127) {
                if (this.f4931j.isPlaying()) {
                    pause();
                    this.f4937p.show();
                }
                return true;
            } else {
                m7603h();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* renamed from: h */
    private void m7603h() {
        if (this.f4937p.isShowing()) {
            this.f4937p.hide();
        } else {
            this.f4937p.show();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (m7600i()) {
            this.f4931j.start();
            this.f4928g = 3;
            InterfaceC1876a interfaceC1876a = this.f4920W;
            if (interfaceC1876a != null) {
                interfaceC1876a.mo7579a();
            }
        }
        this.f4929h = 3;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (m7600i() && this.f4931j.isPlaying()) {
            this.f4931j.pause();
            this.f4928g = 4;
            InterfaceC1876a interfaceC1876a = this.f4920W;
            if (interfaceC1876a != null) {
                interfaceC1876a.mo7578b();
            }
        }
        this.f4929h = 4;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (m7600i()) {
            return (int) this.f4931j.getDuration();
        }
        return -1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (m7600i()) {
            return (int) this.f4931j.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (m7600i()) {
            this.f4906H = System.currentTimeMillis();
            this.f4931j.seekTo(i);
            this.f4943v = 0;
            return;
        }
        this.f4943v = i;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return m7600i() && this.f4931j.isPlaying();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.f4931j != null) {
            return this.f4940s;
        }
        return 0;
    }

    /* renamed from: i */
    private boolean m7600i() {
        int i;
        return (this.f4931j == null || (i = this.f4928g) == -1 || i == 0 || i == 1) ? false : true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return this.f4944w;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.f4945x;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.f4946y;
    }

    /* renamed from: j */
    private void m7597j() {
        this.f4917T.clear();
        if (this.f4899A.m7654i()) {
            this.f4917T.add(1);
        }
        if (this.f4899A.m7653j() && Build.VERSION.SDK_INT >= 14) {
            this.f4917T.add(2);
        }
        if (this.f4899A.m7655h()) {
            this.f4917T.add(0);
        }
        if (this.f4917T.isEmpty()) {
            this.f4917T.add(1);
        }
        this.f4919V = this.f4917T.get(this.f4918U).intValue();
        setRender(this.f4919V);
    }

    public void setOnPlayerStatusListener(InterfaceC1876a interfaceC1876a) {
        this.f4920W = interfaceC1876a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public IMediaPlayer m7632a(int i) {
        AndroidMediaPlayer androidMediaPlayer = null;
        if (i == 1) {
            androidMediaPlayer = new AndroidMediaPlayer();
        } else if (i == 3) {
            try {
                throw new Exception("player type error");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (this.f4926e != null) {
            IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
            IjkMediaPlayer.native_setLogLevel(4);
            if (this.f4899A.m7660c()) {
                Log.d(this.f4925d, "Video decoding using MediaCodec");
                ijkMediaPlayer.setOption(4, "mediacodec", 1L);
                if (this.f4899A.m7659d()) {
                    ijkMediaPlayer.setOption(4, "mediacodec-auto-rotate", 1L);
                } else {
                    ijkMediaPlayer.setOption(4, "mediacodec-auto-rotate", 0L);
                }
                if (this.f4899A.m7658e()) {
                    ijkMediaPlayer.setOption(4, "mediacodec-handle-resolution-change", 1L);
                } else {
                    ijkMediaPlayer.setOption(4, "mediacodec-handle-resolution-change", 0L);
                }
            } else {
                Log.d(this.f4925d, "Video decoding using soft codec");
                ijkMediaPlayer.setOption(4, "mediacodec", 0L);
            }
            ijkMediaPlayer.setOption(1, "max-buffer-size", 4096L);
            ijkMediaPlayer.setOption(1, "fflags", "nobuffer");
            ijkMediaPlayer.setOption(1, "max_delay", 0L);
            ijkMediaPlayer.setOption(4, "packet-buffering", 0L);
            if (this.f4899A.m7657f()) {
                ijkMediaPlayer.setOption(4, "opensles", 1L);
            } else {
                ijkMediaPlayer.setOption(4, "opensles", 0L);
            }
            String m7656g = this.f4899A.m7656g();
            if (TextUtils.isEmpty(m7656g)) {
                ijkMediaPlayer.setOption(4, "overlay-format", 842225234L);
            } else {
                ijkMediaPlayer.setOption(4, "overlay-format", m7656g);
            }
            ijkMediaPlayer.setOption(4, "framedrop", 1L);
            ijkMediaPlayer.setOption(4, "start-on-prepared", 0L);
            ijkMediaPlayer.setOption(1, "http-detect-range-support", 0L);
            ijkMediaPlayer.setOption(2, "skip_loop_filter", 48L);
            androidMediaPlayer = ijkMediaPlayer;
        }
        return this.f4899A.m7652k() ? new TextureMediaPlayer(androidMediaPlayer) : androidMediaPlayer;
    }

    /* renamed from: k */
    private void m7594k() {
        this.f4922aa = this.f4899A.m7662a();
        if (this.f4922aa) {
            MediaPlayerService.m7637b(getContext());
            this.f4931j = MediaPlayerService.m7640a();
            InfoHudViewHolder infoHudViewHolder = this.f4903E;
            if (infoHudViewHolder != null) {
                infoHudViewHolder.m7550a(this.f4931j);
            }
        }
    }

    /* renamed from: c */
    public boolean m7618c() {
        return this.f4922aa;
    }

    /* renamed from: d */
    public void m7615d() {
        MediaPlayerService.m7638a(this.f4931j);
    }

    /* renamed from: e */
    public void m7612e() {
        MediaPlayerService.m7638a((IMediaPlayer) null);
    }

    public ITrackInfo[] getTrackInfo() {
        IMediaPlayer iMediaPlayer = this.f4931j;
        if (iMediaPlayer == null) {
            return null;
        }
        return iMediaPlayer.getTrackInfo();
    }
}
