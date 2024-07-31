package com.senseplay.sdk.video;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import com.adapt.SPM_Rc;
import com.common.AUTOMATIVE_LIGHT;
import java.nio.ByteBuffer;
import java.util.Timer;

/* loaded from: classes2.dex */
public class VideoPlayerThread extends Thread {
    public static int bufferSize;
    private boolean isOpenGl;
    private VideoFrameFIFO mVideoFrameFIFO;
    private Surface surface;
    private MediaCodec decoderSecond = null;
    private int mFrameIndexSec = 0;
    private String TAG = "VideoPlayerThread";
    private Timer timer = null;
    private ByteBuffer buffer = null;

    public VideoPlayerThread(Surface surface, int i) {
        this.isOpenGl = false;
        setName("VideoDecoder");
        this.surface = surface;
        if (surface == null) {
            this.isOpenGl = true;
        }
        this.mVideoFrameFIFO = new VideoFrameFIFO(i);
        this.mVideoFrameFIFO.start();
        bufferSize = 0;
    }

    public int AddData(byte[] bArr, int i) {
        return this.mVideoFrameFIFO.AddVideoData(bArr, i);
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
                this.decoderSecond.queueInputBuffer(dequeueInputBuffer, 0, byteBuffer.capacity(), i * 33333, 0);
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.decoderSecond.dequeueOutputBuffer(bufferInfo, 0L);
            while (dequeueOutputBuffer >= 0) {
                this.decoderSecond.releaseOutputBuffer(dequeueOutputBuffer, true);
                dequeueOutputBuffer = this.decoderSecond.dequeueOutputBuffer(bufferInfo, 0L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openGl(ByteBuffer byteBuffer) {
        VideoOpengl.openGl(byteBuffer);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.decoderSecond = MediaCodec.createDecoderByType("video/avc");
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", 1920, 1080);
            createVideoFormat.setInteger("max-width", 1920);
            createVideoFormat.setInteger("height", 1080);
            createVideoFormat.setInteger("max-input-size", 2073600);
            byte[] bArr = {0, 0, 0, 1, 103, 66, AUTOMATIVE_LIGHT.TRUN_ON, 40, -90, AUTOMATIVE_LIGHT.OVERTURN, 120, 2, 39, -27, AUTOMATIVE_LIGHT.TRUN_ON};
            byte[] bArr2 = {0, 0, 0, 1, 104, -50, SPM_Rc.VIBRATION_MODE.CYCLE_MODE, -92, AUTOMATIVE_LIGHT.OVERTURN, 0, 0, 0, 1, 101, -120};
            createVideoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(bArr));
            createVideoFormat.setByteBuffer("csd-1", ByteBuffer.wrap(bArr2));
            if (this.surface == null) {
                Log.e("DecodeActivity", "The Surface is NULL! ");
            } else {
                Log.e("DecodeActivity", "The Surface is OK ");
            }
            this.decoderSecond.configure(createVideoFormat, this.surface, (MediaCrypto) null, 0);
            this.decoderSecond.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (VideoPlay.flag) {
            try {
                if (this.mVideoFrameFIFO.HasFrame()) {
                    this.buffer = this.mVideoFrameFIFO.PopFrame();
                    if (this.buffer != null) {
                        offerDecoderBuffer(this.buffer);
                        this.buffer = null;
                    }
                }
                sleep(10L);
            } catch (Exception unused) {
                return;
            }
        }
    }

    public void realse() {
        VideoFrameFIFO videoFrameFIFO = this.mVideoFrameFIFO;
        if (videoFrameFIFO != null) {
            videoFrameFIFO.realse();
        }
        this.decoderSecond = null;
    }
}
