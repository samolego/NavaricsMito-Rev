package com.senseplay.sdk.video.host;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Timer;

/* loaded from: classes2.dex */
public class PlayerThread extends Thread {
    public static int bufferSize;
    private FrameFIFO frameFIFO;
    private boolean isOpenGl;
    private Surface surface;
    private MediaCodec decoderSecond = null;
    private int mFrameIndexSec = 0;
    private String TAG = "VideoPlayerThread";
    private Timer timer = null;
    private ByteBuffer buffer = null;

    public PlayerThread(Surface surface) {
        this.isOpenGl = false;
        this.surface = surface;
        if (surface == null) {
            this.isOpenGl = true;
        }
        this.frameFIFO = new FrameFIFO();
        this.frameFIFO.start();
        bufferSize = 0;
    }

    public int AddData(byte[] bArr, int i) {
        return this.frameFIFO.AddVideoData(bArr, i);
    }

    private void offerDecoderBuffer(ByteBuffer byteBuffer) {
        try {
            ByteBuffer[] inputBuffers = this.decoderSecond.getInputBuffers();
            int dequeueInputBuffer = this.decoderSecond.dequeueInputBuffer(-1L);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
                int i = this.mFrameIndexSec;
                this.mFrameIndexSec = i + 1;
                byteBuffer2.rewind();
                byteBuffer2.put(byteBuffer);
                this.decoderSecond.queueInputBuffer(dequeueInputBuffer, 0, byteBuffer.capacity(), i * 16666, 0);
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.decoderSecond.dequeueOutputBuffer(bufferInfo, 10000L);
            while (dequeueOutputBuffer >= 0) {
                this.decoderSecond.releaseOutputBuffer(dequeueOutputBuffer, true);
                dequeueOutputBuffer = this.decoderSecond.dequeueOutputBuffer(bufferInfo, 0L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.decoderSecond = MediaCodec.createDecoderByType("video/avc");
        } catch (IOException e) {
            e.printStackTrace();
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", 1920, 1080);
        createVideoFormat.setInteger("max-width", 1920);
        createVideoFormat.setInteger("height", 1080);
        createVideoFormat.setInteger("max-input-size", 2073600);
        createVideoFormat.setInteger("i-frame-interval", 30);
        createVideoFormat.setInteger("push-blank-buffers-on-shutdown", 1);
        if (this.surface == null) {
            Log.e("DecodeActivity", "The Surface is NULL! ");
        } else {
            Log.e("DecodeActivity", "The Surface is OK ");
        }
        this.decoderSecond.configure(createVideoFormat, this.surface, (MediaCrypto) null, 0);
        this.decoderSecond.start();
    }

    public void clear() {
        this.decoderSecond = null;
    }
}
