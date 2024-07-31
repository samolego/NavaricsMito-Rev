package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.twitter.sdk.android.tweetui.internal.VideoControlView;

/* loaded from: classes2.dex */
public class VideoView extends SurfaceView implements VideoControlView.InterfaceC2742a {

    /* renamed from: A */
    private GestureDetector f9018A;

    /* renamed from: a */
    MediaPlayer.OnVideoSizeChangedListener f9019a;

    /* renamed from: b */
    MediaPlayer.OnPreparedListener f9020b;

    /* renamed from: c */
    SurfaceHolder.Callback f9021c;

    /* renamed from: d */
    private String f9022d;

    /* renamed from: e */
    private Uri f9023e;

    /* renamed from: f */
    private int f9024f;

    /* renamed from: g */
    private int f9025g;

    /* renamed from: h */
    private SurfaceHolder f9026h;

    /* renamed from: i */
    private MediaPlayer f9027i;

    /* renamed from: j */
    private int f9028j;

    /* renamed from: k */
    private int f9029k;

    /* renamed from: l */
    private int f9030l;

    /* renamed from: m */
    private int f9031m;

    /* renamed from: n */
    private int f9032n;

    /* renamed from: o */
    private VideoControlView f9033o;

    /* renamed from: p */
    private MediaPlayer.OnCompletionListener f9034p;

    /* renamed from: q */
    private MediaPlayer.OnPreparedListener f9035q;

    /* renamed from: r */
    private int f9036r;

    /* renamed from: s */
    private MediaPlayer.OnErrorListener f9037s;

    /* renamed from: t */
    private MediaPlayer.OnInfoListener f9038t;

    /* renamed from: u */
    private int f9039u;

    /* renamed from: v */
    private boolean f9040v;

    /* renamed from: w */
    private MediaPlayer.OnCompletionListener f9041w;

    /* renamed from: x */
    private MediaPlayer.OnInfoListener f9042x;

    /* renamed from: y */
    private MediaPlayer.OnErrorListener f9043y;

    /* renamed from: z */
    private MediaPlayer.OnBufferingUpdateListener f9044z;

    public VideoView(Context context) {
        super(context);
        this.f9022d = "VideoView";
        this.f9024f = 0;
        this.f9025g = 0;
        this.f9026h = null;
        this.f9027i = null;
        this.f9019a = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.twitter.sdk.android.tweetui.internal.VideoView.1
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                VideoView.this.f9029k = mediaPlayer.getVideoWidth();
                VideoView.this.f9030l = mediaPlayer.getVideoHeight();
                if (VideoView.this.f9029k == 0 || VideoView.this.f9030l == 0) {
                    return;
                }
                VideoView.this.getHolder().setFixedSize(VideoView.this.f9029k, VideoView.this.f9030l);
                VideoView.this.requestLayout();
            }
        };
        this.f9020b = new MediaPlayer.OnPreparedListener() { // from class: com.twitter.sdk.android.tweetui.internal.VideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoView.this.f9024f = 2;
                if (VideoView.this.f9035q != null) {
                    VideoView.this.f9035q.onPrepared(VideoView.this.f9027i);
                }
                if (VideoView.this.f9033o != null) {
                    VideoView.this.f9033o.setEnabled(true);
                }
                VideoView.this.f9029k = mediaPlayer.getVideoWidth();
                VideoView.this.f9030l = mediaPlayer.getVideoHeight();
                int i = VideoView.this.f9039u;
                if (i != 0) {
                    VideoView.this.mo4003a(i);
                }
                if (VideoView.this.f9029k == 0 || VideoView.this.f9030l == 0) {
                    if (VideoView.this.f9025g == 3) {
                        VideoView.this.mo4004a();
                        return;
                    }
                    return;
                }
                VideoView.this.getHolder().setFixedSize(VideoView.this.f9029k, VideoView.this.f9030l);
                if (VideoView.this.f9031m == VideoView.this.f9029k && VideoView.this.f9032n == VideoView.this.f9030l) {
                    if (VideoView.this.f9025g == 3) {
                        VideoView.this.mo4004a();
                        if (VideoView.this.f9033o != null) {
                            VideoView.this.f9033o.m4007j();
                        }
                    } else if (VideoView.this.mo3993c()) {
                    } else {
                        if ((i != 0 || VideoView.this.getCurrentPosition() > 0) && VideoView.this.f9033o != null) {
                            VideoView.this.f9033o.m4007j();
                        }
                    }
                }
            }
        };
        this.f9041w = new MediaPlayer.OnCompletionListener() { // from class: com.twitter.sdk.android.tweetui.internal.VideoView.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoView.this.f9024f = 5;
                VideoView.this.f9025g = 5;
                if (VideoView.this.f9034p != null) {
                    VideoView.this.f9034p.onCompletion(VideoView.this.f9027i);
                }
            }
        };
        this.f9042x = new MediaPlayer.OnInfoListener() { // from class: com.twitter.sdk.android.tweetui.internal.VideoView.4
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoView.this.f9038t != null) {
                    VideoView.this.f9038t.onInfo(mediaPlayer, i, i2);
                    return true;
                }
                return true;
            }
        };
        this.f9043y = new MediaPlayer.OnErrorListener() { // from class: com.twitter.sdk.android.tweetui.internal.VideoView.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                String str = VideoView.this.f9022d;
                Log.d(str, "Error: " + i + "," + i2);
                VideoView.this.f9024f = -1;
                VideoView.this.f9025g = -1;
                if (VideoView.this.f9033o != null) {
                    VideoView.this.f9033o.m4008i();
                }
                return (VideoView.this.f9037s == null || VideoView.this.f9037s.onError(VideoView.this.f9027i, i, i2)) ? true : true;
            }
        };
        this.f9044z = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.twitter.sdk.android.tweetui.internal.VideoView.6
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                VideoView.this.f9036r = i;
            }
        };
        this.f9018A = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.twitter.sdk.android.tweetui.internal.VideoView.7
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (!VideoView.this.m3976i() || VideoView.this.f9033o == null) {
                    return false;
                }
                VideoView.this.m3978h();
                return false;
            }
        });
        this.f9021c = new SurfaceHolder.Callback() { // from class: com.twitter.sdk.android.tweetui.internal.VideoView.8
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                VideoView.this.f9031m = i2;
                VideoView.this.f9032n = i3;
                boolean z = true;
                boolean z2 = VideoView.this.f9025g == 3;
                z = (VideoView.this.f9029k == i2 && VideoView.this.f9030l == i3) ? false : false;
                if (VideoView.this.f9027i != null && z2 && z) {
                    if (VideoView.this.f9039u != 0) {
                        VideoView videoView = VideoView.this;
                        videoView.mo4003a(videoView.f9039u);
                    }
                    VideoView.this.mo4004a();
                    if (VideoView.this.f9033o != null) {
                        VideoView.this.f9033o.m4007j();
                    }
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoView.this.f9026h = surfaceHolder;
                VideoView.this.m3984f();
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoView.this.f9026h = null;
                if (VideoView.this.f9033o != null) {
                    VideoView.this.f9033o.m4008i();
                }
                VideoView.this.m3997a(true);
            }
        };
        m3987e();
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9022d = "VideoView";
        this.f9024f = 0;
        this.f9025g = 0;
        this.f9026h = null;
        this.f9027i = null;
        this.f9019a = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.twitter.sdk.android.tweetui.internal.VideoView.1
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i22) {
                VideoView.this.f9029k = mediaPlayer.getVideoWidth();
                VideoView.this.f9030l = mediaPlayer.getVideoHeight();
                if (VideoView.this.f9029k == 0 || VideoView.this.f9030l == 0) {
                    return;
                }
                VideoView.this.getHolder().setFixedSize(VideoView.this.f9029k, VideoView.this.f9030l);
                VideoView.this.requestLayout();
            }
        };
        this.f9020b = new MediaPlayer.OnPreparedListener() { // from class: com.twitter.sdk.android.tweetui.internal.VideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoView.this.f9024f = 2;
                if (VideoView.this.f9035q != null) {
                    VideoView.this.f9035q.onPrepared(VideoView.this.f9027i);
                }
                if (VideoView.this.f9033o != null) {
                    VideoView.this.f9033o.setEnabled(true);
                }
                VideoView.this.f9029k = mediaPlayer.getVideoWidth();
                VideoView.this.f9030l = mediaPlayer.getVideoHeight();
                int i2 = VideoView.this.f9039u;
                if (i2 != 0) {
                    VideoView.this.mo4003a(i2);
                }
                if (VideoView.this.f9029k == 0 || VideoView.this.f9030l == 0) {
                    if (VideoView.this.f9025g == 3) {
                        VideoView.this.mo4004a();
                        return;
                    }
                    return;
                }
                VideoView.this.getHolder().setFixedSize(VideoView.this.f9029k, VideoView.this.f9030l);
                if (VideoView.this.f9031m == VideoView.this.f9029k && VideoView.this.f9032n == VideoView.this.f9030l) {
                    if (VideoView.this.f9025g == 3) {
                        VideoView.this.mo4004a();
                        if (VideoView.this.f9033o != null) {
                            VideoView.this.f9033o.m4007j();
                        }
                    } else if (VideoView.this.mo3993c()) {
                    } else {
                        if ((i2 != 0 || VideoView.this.getCurrentPosition() > 0) && VideoView.this.f9033o != null) {
                            VideoView.this.f9033o.m4007j();
                        }
                    }
                }
            }
        };
        this.f9041w = new MediaPlayer.OnCompletionListener() { // from class: com.twitter.sdk.android.tweetui.internal.VideoView.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoView.this.f9024f = 5;
                VideoView.this.f9025g = 5;
                if (VideoView.this.f9034p != null) {
                    VideoView.this.f9034p.onCompletion(VideoView.this.f9027i);
                }
            }
        };
        this.f9042x = new MediaPlayer.OnInfoListener() { // from class: com.twitter.sdk.android.tweetui.internal.VideoView.4
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i22) {
                if (VideoView.this.f9038t != null) {
                    VideoView.this.f9038t.onInfo(mediaPlayer, i2, i22);
                    return true;
                }
                return true;
            }
        };
        this.f9043y = new MediaPlayer.OnErrorListener() { // from class: com.twitter.sdk.android.tweetui.internal.VideoView.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i22) {
                String str = VideoView.this.f9022d;
                Log.d(str, "Error: " + i2 + "," + i22);
                VideoView.this.f9024f = -1;
                VideoView.this.f9025g = -1;
                if (VideoView.this.f9033o != null) {
                    VideoView.this.f9033o.m4008i();
                }
                return (VideoView.this.f9037s == null || VideoView.this.f9037s.onError(VideoView.this.f9027i, i2, i22)) ? true : true;
            }
        };
        this.f9044z = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.twitter.sdk.android.tweetui.internal.VideoView.6
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                VideoView.this.f9036r = i2;
            }
        };
        this.f9018A = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.twitter.sdk.android.tweetui.internal.VideoView.7
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (!VideoView.this.m3976i() || VideoView.this.f9033o == null) {
                    return false;
                }
                VideoView.this.m3978h();
                return false;
            }
        });
        this.f9021c = new SurfaceHolder.Callback() { // from class: com.twitter.sdk.android.tweetui.internal.VideoView.8
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i22, int i3) {
                VideoView.this.f9031m = i22;
                VideoView.this.f9032n = i3;
                boolean z = true;
                boolean z2 = VideoView.this.f9025g == 3;
                z = (VideoView.this.f9029k == i22 && VideoView.this.f9030l == i3) ? false : false;
                if (VideoView.this.f9027i != null && z2 && z) {
                    if (VideoView.this.f9039u != 0) {
                        VideoView videoView = VideoView.this;
                        videoView.mo4003a(videoView.f9039u);
                    }
                    VideoView.this.mo4004a();
                    if (VideoView.this.f9033o != null) {
                        VideoView.this.f9033o.m4007j();
                    }
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoView.this.f9026h = surfaceHolder;
                VideoView.this.m3984f();
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoView.this.f9026h = null;
                if (VideoView.this.f9033o != null) {
                    VideoView.this.f9033o.m4008i();
                }
                VideoView.this.m3997a(true);
            }
        };
        m3987e();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int defaultSize = getDefaultSize(this.f9029k, i);
        int defaultSize2 = getDefaultSize(this.f9030l, i2);
        if (this.f9029k <= 0 || this.f9030l <= 0) {
            i3 = defaultSize;
        } else {
            int mode = View.MeasureSpec.getMode(i);
            i3 = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i4 = this.f9029k;
                int i5 = i4 * size;
                int i6 = this.f9030l;
                if (i5 < i3 * i6) {
                    defaultSize2 = size;
                    i3 = (i4 * size) / i6;
                } else {
                    if (i4 * size > i3 * i6) {
                        defaultSize2 = (i6 * i3) / i4;
                    }
                    defaultSize2 = size;
                }
            } else if (mode == 1073741824) {
                int i7 = (this.f9030l * i3) / this.f9029k;
                if (mode2 != Integer.MIN_VALUE || i7 <= size) {
                    defaultSize2 = i7;
                }
                defaultSize2 = size;
            } else if (mode2 == 1073741824) {
                int i8 = (this.f9029k * size) / this.f9030l;
                if (mode != Integer.MIN_VALUE || i8 <= i3) {
                    i3 = i8;
                }
                defaultSize2 = size;
            } else {
                int i9 = this.f9029k;
                int i10 = this.f9030l;
                if (mode2 != Integer.MIN_VALUE || i10 <= size) {
                    defaultSize2 = i10;
                } else {
                    i9 = (i9 * size) / i10;
                    defaultSize2 = size;
                }
                if (mode != Integer.MIN_VALUE || i9 <= i3) {
                    i3 = i9;
                } else {
                    defaultSize2 = (this.f9030l * i3) / this.f9029k;
                }
            }
        }
        setMeasuredDimension(i3, defaultSize2);
    }

    /* renamed from: e */
    private void m3987e() {
        this.f9029k = 0;
        this.f9030l = 0;
        getHolder().addCallback(this.f9021c);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setClickable(true);
        requestFocus();
        this.f9024f = 0;
        this.f9025g = 0;
    }

    /* renamed from: a */
    public void m4002a(Uri uri, boolean z) {
        this.f9023e = uri;
        this.f9040v = z;
        this.f9039u = 0;
        m3984f();
        requestLayout();
        invalidate();
    }

    /* renamed from: d */
    public void m3990d() {
        MediaPlayer mediaPlayer = this.f9027i;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f9027i.release();
            this.f9027i = null;
            this.f9024f = 0;
            this.f9025g = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m3984f() {
        if (this.f9023e == null || this.f9026h == null) {
            return;
        }
        m3997a(false);
        try {
            this.f9027i = new MediaPlayer();
            if (this.f9028j != 0) {
                this.f9027i.setAudioSessionId(this.f9028j);
            } else {
                this.f9028j = this.f9027i.getAudioSessionId();
            }
            this.f9027i.setOnPreparedListener(this.f9020b);
            this.f9027i.setOnVideoSizeChangedListener(this.f9019a);
            this.f9027i.setOnCompletionListener(this.f9041w);
            this.f9027i.setOnErrorListener(this.f9043y);
            this.f9027i.setOnInfoListener(this.f9042x);
            this.f9027i.setOnBufferingUpdateListener(this.f9044z);
            this.f9036r = 0;
            this.f9027i.setLooping(this.f9040v);
            this.f9027i.setDataSource(getContext(), this.f9023e);
            this.f9027i.setDisplay(this.f9026h);
            this.f9027i.setAudioStreamType(3);
            this.f9027i.setScreenOnWhilePlaying(true);
            this.f9027i.prepareAsync();
            this.f9024f = 1;
            m3981g();
        } catch (Exception e) {
            String str = this.f9022d;
            Log.w(str, "Unable to open content: " + this.f9023e, e);
            this.f9024f = -1;
            this.f9025g = -1;
            this.f9043y.onError(this.f9027i, 1, 0);
        }
    }

    public void setMediaController(VideoControlView videoControlView) {
        VideoControlView videoControlView2 = this.f9033o;
        if (videoControlView2 != null) {
            videoControlView2.m4008i();
        }
        this.f9033o = videoControlView;
        m3981g();
    }

    /* renamed from: g */
    private void m3981g() {
        VideoControlView videoControlView;
        if (this.f9027i == null || (videoControlView = this.f9033o) == null) {
            return;
        }
        videoControlView.setMediaPlayer(this);
        this.f9033o.setEnabled(m3976i());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f9018A.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.f9035q = onPreparedListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f9034p = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.f9037s = onErrorListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.f9038t = onInfoListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3997a(boolean z) {
        MediaPlayer mediaPlayer = this.f9027i;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.f9027i.release();
            this.f9027i = null;
            this.f9024f = 0;
            if (z) {
                this.f9025g = 0;
            }
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 82 || i == 5 || i == 6) ? false : true;
        if (m3976i() && z && this.f9033o != null) {
            if (i == 79 || i == 85) {
                if (this.f9027i.isPlaying()) {
                    mo3996b();
                    this.f9033o.m4007j();
                } else {
                    mo4004a();
                    this.f9033o.m4008i();
                }
                return true;
            } else if (i == 126) {
                if (!this.f9027i.isPlaying()) {
                    mo4004a();
                    this.f9033o.m4008i();
                }
                return true;
            } else if (i == 86 || i == 127) {
                if (this.f9027i.isPlaying()) {
                    mo3996b();
                    this.f9033o.m4007j();
                }
                return true;
            } else {
                m3978h();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m3978h() {
        if (this.f9033o.m4006k()) {
            this.f9033o.m4008i();
        } else {
            this.f9033o.m4007j();
        }
    }

    @Override // com.twitter.sdk.android.tweetui.internal.VideoControlView.InterfaceC2742a
    /* renamed from: a */
    public void mo4004a() {
        if (m3976i()) {
            this.f9027i.start();
            this.f9024f = 3;
        }
        this.f9025g = 3;
    }

    @Override // com.twitter.sdk.android.tweetui.internal.VideoControlView.InterfaceC2742a
    /* renamed from: b */
    public void mo3996b() {
        if (m3976i() && this.f9027i.isPlaying()) {
            this.f9027i.pause();
            this.f9024f = 4;
        }
        this.f9025g = 4;
    }

    @Override // com.twitter.sdk.android.tweetui.internal.VideoControlView.InterfaceC2742a
    public int getDuration() {
        if (m3976i()) {
            return this.f9027i.getDuration();
        }
        return -1;
    }

    @Override // com.twitter.sdk.android.tweetui.internal.VideoControlView.InterfaceC2742a
    public int getCurrentPosition() {
        if (m3976i()) {
            return this.f9027i.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.twitter.sdk.android.tweetui.internal.VideoControlView.InterfaceC2742a
    /* renamed from: a */
    public void mo4003a(int i) {
        if (m3976i()) {
            this.f9027i.seekTo(i);
            this.f9039u = 0;
            return;
        }
        this.f9039u = i;
    }

    @Override // com.twitter.sdk.android.tweetui.internal.VideoControlView.InterfaceC2742a
    /* renamed from: c */
    public boolean mo3993c() {
        return m3976i() && this.f9027i.isPlaying();
    }

    @Override // com.twitter.sdk.android.tweetui.internal.VideoControlView.InterfaceC2742a
    public int getBufferPercentage() {
        if (this.f9027i != null) {
            return this.f9036r;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public boolean m3976i() {
        int i;
        return (this.f9027i == null || (i = this.f9024f) == -1 || i == 0 || i == 1) ? false : true;
    }
}
