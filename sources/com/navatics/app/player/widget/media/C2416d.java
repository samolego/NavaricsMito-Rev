package com.navatics.app.player.widget.media;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import android.widget.TableLayout;
import com.navatics.app.R;
import java.util.Locale;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.MediaPlayerProxy;

/* renamed from: com.navatics.app.player.widget.media.d */
/* loaded from: classes.dex */
public class InfoHudViewHolder {

    /* renamed from: a */
    private TableLayoutBinder f4987a;

    /* renamed from: c */
    private IMediaPlayer f4989c;

    /* renamed from: b */
    private SparseArray<View> f4988b = new SparseArray<>();

    /* renamed from: d */
    private long f4990d = 0;

    /* renamed from: e */
    private long f4991e = 0;

    /* renamed from: f */
    private Handler f4992f = new Handler() { // from class: com.navatics.app.player.widget.media.d.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IMediaPlayer internalMediaPlayer;
            if (message.what != 1) {
                return;
            }
            IjkMediaPlayer ijkMediaPlayer = null;
            if (InfoHudViewHolder.this.f4989c == null) {
                return;
            }
            if (InfoHudViewHolder.this.f4989c instanceof IjkMediaPlayer) {
                ijkMediaPlayer = (IjkMediaPlayer) InfoHudViewHolder.this.f4989c;
            } else if ((InfoHudViewHolder.this.f4989c instanceof MediaPlayerProxy) && (internalMediaPlayer = ((MediaPlayerProxy) InfoHudViewHolder.this.f4989c).getInternalMediaPlayer()) != null && (internalMediaPlayer instanceof IjkMediaPlayer)) {
                ijkMediaPlayer = (IjkMediaPlayer) internalMediaPlayer;
            }
            if (ijkMediaPlayer == null) {
                return;
            }
            switch (ijkMediaPlayer.getVideoDecoder()) {
                case 1:
                    InfoHudViewHolder.this.m7555a((int) R.string.vdec, "avcodec");
                    break;
                case 2:
                    InfoHudViewHolder.this.m7555a((int) R.string.vdec, "MediaCodec");
                    break;
                default:
                    InfoHudViewHolder.this.m7555a((int) R.string.vdec, "");
                    break;
            }
            InfoHudViewHolder.this.m7555a((int) R.string.fps, String.format(Locale.US, "%.2f / %.2f", Float.valueOf(ijkMediaPlayer.getVideoDecodeFramesPerSecond()), Float.valueOf(ijkMediaPlayer.getVideoOutputFramesPerSecond())));
            long videoCachedDuration = ijkMediaPlayer.getVideoCachedDuration();
            long audioCachedDuration = ijkMediaPlayer.getAudioCachedDuration();
            long videoCachedBytes = ijkMediaPlayer.getVideoCachedBytes();
            long audioCachedBytes = ijkMediaPlayer.getAudioCachedBytes();
            long tcpSpeed = ijkMediaPlayer.getTcpSpeed();
            long bitRate = ijkMediaPlayer.getBitRate();
            long seekLoadDuration = ijkMediaPlayer.getSeekLoadDuration();
            InfoHudViewHolder.this.m7555a((int) R.string.v_cache, String.format(Locale.US, "%s, %s", InfoHudViewHolder.m7542e(videoCachedDuration), InfoHudViewHolder.m7541f(videoCachedBytes)));
            InfoHudViewHolder.this.m7555a((int) R.string.a_cache, String.format(Locale.US, "%s, %s", InfoHudViewHolder.m7542e(audioCachedDuration), InfoHudViewHolder.m7541f(audioCachedBytes)));
            InfoHudViewHolder.this.m7555a((int) R.string.load_cost, String.format(Locale.US, "%d ms", Long.valueOf(InfoHudViewHolder.this.f4990d)));
            InfoHudViewHolder.this.m7555a((int) R.string.seek_cost, String.format(Locale.US, "%d ms", Long.valueOf(InfoHudViewHolder.this.f4991e)));
            InfoHudViewHolder.this.m7555a((int) R.string.seek_load_cost, String.format(Locale.US, "%d ms", Long.valueOf(seekLoadDuration)));
            InfoHudViewHolder.this.m7555a((int) R.string.tcp_speed, String.format(Locale.US, "%s", InfoHudViewHolder.m7548b(tcpSpeed, 1000L)));
            InfoHudViewHolder.this.m7555a((int) R.string.bit_rate, String.format(Locale.US, "%.2f kbs", Float.valueOf(((float) bitRate) / 1000.0f)));
            InfoHudViewHolder.this.f4992f.removeMessages(1);
            InfoHudViewHolder.this.f4992f.sendEmptyMessageDelayed(1, 500L);
        }
    };

    public InfoHudViewHolder(Context context, TableLayout tableLayout) {
        this.f4987a = new TableLayoutBinder(context, tableLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7555a(int i, String str) {
        View view = this.f4988b.get(i);
        if (view == null) {
            this.f4988b.put(i, this.f4987a.m7533a(i, str));
            return;
        }
        this.f4987a.m7530a(view, str);
    }

    /* renamed from: a */
    public void m7550a(IMediaPlayer iMediaPlayer) {
        this.f4989c = iMediaPlayer;
        if (this.f4989c != null) {
            this.f4992f.sendEmptyMessageDelayed(1, 500L);
        } else {
            this.f4992f.removeMessages(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static String m7542e(long j) {
        return j >= 1000 ? String.format(Locale.US, "%.2f sec", Float.valueOf(((float) j) / 1000.0f)) : String.format(Locale.US, "%d msec", Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m7548b(long j, long j2) {
        if (j2 > 0 && j > 0) {
            float f = (((float) j) * 1000.0f) / ((float) j2);
            return f >= 1000000.0f ? String.format(Locale.US, "%.2f MB/s", Float.valueOf((f / 1000.0f) / 1000.0f)) : f >= 1000.0f ? String.format(Locale.US, "%.1f KB/s", Float.valueOf(f / 1000.0f)) : String.format(Locale.US, "%d B/s", Long.valueOf(f));
        }
        return "0 B/s";
    }

    /* renamed from: a */
    public void m7554a(long j) {
        this.f4990d = j;
    }

    /* renamed from: b */
    public void m7549b(long j) {
        this.f4991e = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static String m7541f(long j) {
        return j >= 100000 ? String.format(Locale.US, "%.2f MB", Float.valueOf((((float) j) / 1000.0f) / 1000.0f)) : j >= 100 ? String.format(Locale.US, "%.1f KB", Float.valueOf(((float) j) / 1000.0f)) : String.format(Locale.US, "%d B", Long.valueOf(j));
    }
}
