package com.senseplay.sdk.video;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.Surface;

/* loaded from: classes2.dex */
public class VideoLocal {
    private VideoListener listener;
    private MediaPlayer mMediaPlayer;
    private String streamPath;
    private Surface surface;

    /* loaded from: classes2.dex */
    public interface VideoListener {
        void playFinish();
    }

    public VideoLocal(Surface surface) {
        this.surface = surface;
    }

    public void setVideoListener(VideoListener videoListener) {
        this.listener = videoListener;
    }

    public void play(String str) {
        try {
            this.mMediaPlayer = new MediaPlayer();
            this.mMediaPlayer.setDataSource(str);
            playVideo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playRaw(Context context, int i) {
        try {
            this.mMediaPlayer = MediaPlayer.create(context, i);
            playVideo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playVideo() throws Exception {
        this.mMediaPlayer.setSurface(this.surface);
        this.mMediaPlayer.setAudioStreamType(3);
        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.senseplay.sdk.video.VideoLocal.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (VideoLocal.this.listener != null) {
                    VideoLocal.this.listener.playFinish();
                }
            }
        });
        this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.senseplay.sdk.video.VideoLocal.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoLocal.this.mMediaPlayer.start();
            }
        });
        this.mMediaPlayer.prepare();
    }

    public void reset() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(0);
            this.mMediaPlayer.start();
        }
    }

    public void stop() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
        }
    }
}
