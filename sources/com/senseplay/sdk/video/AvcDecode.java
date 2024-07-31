package com.senseplay.sdk.video;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class AvcDecode {
    ByteBuffer[] inputBuffers;
    MediaCodec mediaCodec;
    String MIME_TYPE = "video/avc";
    int m_framerate = 10;
    long presentationTimeUs = 0;

    public AvcDecode(int i, int i2, Surface surface) {
        this.mediaCodec = null;
        this.inputBuffers = null;
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.MIME_TYPE, i, i2);
        try {
            this.mediaCodec = MediaCodec.createDecoderByType(this.MIME_TYPE);
            this.mediaCodec.configure(createVideoFormat, surface, (MediaCrypto) null, 0);
            this.mediaCodec.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.inputBuffers = this.mediaCodec.getInputBuffers();
    }

    public boolean decodeH264(byte[] bArr) {
        ByteBuffer[] inputBuffers = this.mediaCodec.getInputBuffers();
        int dequeueInputBuffer = this.mediaCodec.dequeueInputBuffer(100L);
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
            byteBuffer.clear();
            byteBuffer.put(bArr);
            this.mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, computePresentationTime(this.presentationTimeUs), 0);
            this.presentationTimeUs++;
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 100L);
            while (dequeueOutputBuffer >= 0) {
                this.mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, true);
                dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
            }
            Log.e("Media", "onFrame end");
            return true;
        }
        return false;
    }

    private long computePresentationTime(long j) {
        return ((j * 1000000) / this.m_framerate) + 132;
    }
}
