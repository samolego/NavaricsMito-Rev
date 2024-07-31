package com.twitter.sdk.android.tweetui.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.senseplay.sdk.config.CacheConfig;
import com.twitter.sdk.android.tweetui.R;

/* loaded from: classes2.dex */
public class VideoControlView extends FrameLayout {

    /* renamed from: a */
    InterfaceC2742a f9009a;

    /* renamed from: b */
    ImageButton f9010b;

    /* renamed from: c */
    TextView f9011c;

    /* renamed from: d */
    TextView f9012d;

    /* renamed from: e */
    SeekBar f9013e;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: f */
    private final Handler f9014f;

    /* renamed from: com.twitter.sdk.android.tweetui.internal.VideoControlView$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC2742a {
        /* renamed from: a */
        void mo4004a();

        /* renamed from: a */
        void mo4003a(int i);

        /* renamed from: b */
        void mo3996b();

        /* renamed from: c */
        boolean mo3993c();

        int getBufferPercentage();

        int getCurrentPosition();

        int getDuration();
    }

    public VideoControlView(Context context) {
        super(context);
        this.f9014f = new Handler() { // from class: com.twitter.sdk.android.tweetui.internal.VideoControlView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1001 || VideoControlView.this.f9009a == null) {
                    return;
                }
                VideoControlView.this.m4013d();
                VideoControlView.this.m4012e();
                if (VideoControlView.this.m4006k() && VideoControlView.this.f9009a.mo3993c()) {
                    sendMessageDelayed(obtainMessage(1001), 500L);
                }
            }
        };
    }

    public VideoControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9014f = new Handler() { // from class: com.twitter.sdk.android.tweetui.internal.VideoControlView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1001 || VideoControlView.this.f9009a == null) {
                    return;
                }
                VideoControlView.this.m4013d();
                VideoControlView.this.m4012e();
                if (VideoControlView.this.m4006k() && VideoControlView.this.f9009a.mo3993c()) {
                    sendMessageDelayed(obtainMessage(1001), 500L);
                }
            }
        };
    }

    public VideoControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9014f = new Handler() { // from class: com.twitter.sdk.android.tweetui.internal.VideoControlView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1001 || VideoControlView.this.f9009a == null) {
                    return;
                }
                VideoControlView.this.m4013d();
                VideoControlView.this.m4012e();
                if (VideoControlView.this.m4006k() && VideoControlView.this.f9009a.mo3993c()) {
                    sendMessageDelayed(obtainMessage(1001), 500L);
                }
            }
        };
    }

    public void setMediaPlayer(InterfaceC2742a interfaceC2742a) {
        this.f9009a = interfaceC2742a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        m4018a();
    }

    /* renamed from: a */
    void m4018a() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.tw__video_control, this);
        this.f9010b = (ImageButton) findViewById(R.id.tw__state_control);
        this.f9011c = (TextView) findViewById(R.id.tw__current_time);
        this.f9012d = (TextView) findViewById(R.id.tw__duration);
        this.f9013e = (SeekBar) findViewById(R.id.tw__progress);
        this.f9013e.setMax(1000);
        this.f9013e.setOnSeekBarChangeListener(m4014c());
        this.f9010b.setOnClickListener(m4015b());
        setDuration(0);
        setCurrentTime(0);
        m4017a(0, 0, 0);
    }

    /* renamed from: b */
    View.OnClickListener m4015b() {
        return new View.OnClickListener() { // from class: com.twitter.sdk.android.tweetui.internal.VideoControlView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoControlView.this.f9009a.mo3993c()) {
                    VideoControlView.this.f9009a.mo3996b();
                } else {
                    VideoControlView.this.f9009a.mo4004a();
                }
                VideoControlView.this.m4007j();
            }
        };
    }

    /* renamed from: c */
    SeekBar.OnSeekBarChangeListener m4014c() {
        return new SeekBar.OnSeekBarChangeListener() { // from class: com.twitter.sdk.android.tweetui.internal.VideoControlView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    int duration = (int) ((VideoControlView.this.f9009a.getDuration() * i) / 1000);
                    VideoControlView.this.f9009a.mo4003a(duration);
                    VideoControlView.this.setCurrentTime(duration);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControlView.this.f9014f.removeMessages(1001);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControlView.this.f9014f.sendEmptyMessage(1001);
            }
        };
    }

    /* renamed from: d */
    void m4013d() {
        int duration = this.f9009a.getDuration();
        int currentPosition = this.f9009a.getCurrentPosition();
        int bufferPercentage = this.f9009a.getBufferPercentage();
        setDuration(duration);
        setCurrentTime(currentPosition);
        m4017a(currentPosition, duration, bufferPercentage);
    }

    void setDuration(int i) {
        this.f9012d.setText(MediaTimeUtils.m3954a(i));
    }

    void setCurrentTime(int i) {
        this.f9011c.setText(MediaTimeUtils.m3954a(i));
    }

    /* renamed from: a */
    void m4017a(int i, int i2, int i3) {
        this.f9013e.setProgress((int) (i2 > 0 ? (i * 1000) / i2 : 0L));
        this.f9013e.setSecondaryProgress(i3 * 10);
    }

    /* renamed from: e */
    void m4012e() {
        if (this.f9009a.mo3993c()) {
            m4010g();
        } else if (this.f9009a.getCurrentPosition() > Math.max(this.f9009a.getDuration() - 500, 0)) {
            m4009h();
        } else {
            m4011f();
        }
    }

    /* renamed from: f */
    void m4011f() {
        this.f9010b.setImageResource(R.drawable.tw__video_play_btn);
        this.f9010b.setContentDescription(getContext().getString(R.string.tw__play));
    }

    /* renamed from: g */
    void m4010g() {
        this.f9010b.setImageResource(R.drawable.tw__video_pause_btn);
        this.f9010b.setContentDescription(getContext().getString(R.string.tw__pause));
    }

    /* renamed from: h */
    void m4009h() {
        this.f9010b.setImageResource(R.drawable.tw__video_replay_btn);
        this.f9010b.setContentDescription(getContext().getString(R.string.tw__replay));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public void m4008i() {
        this.f9014f.removeMessages(1001);
        AnimationUtils.m3967a(this, CacheConfig.Post_Delayed);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public void m4007j() {
        this.f9014f.sendEmptyMessage(1001);
        AnimationUtils.m3966b(this, CacheConfig.Post_Delayed);
    }

    /* renamed from: k */
    public boolean m4006k() {
        return getVisibility() == 0;
    }

    /* renamed from: l */
    public void m4005l() {
        this.f9014f.sendEmptyMessage(1001);
    }
}
