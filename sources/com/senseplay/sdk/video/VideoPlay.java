package com.senseplay.sdk.video;

import android.content.Context;
import android.os.Environment;
import android.view.Surface;
import com.hwfit.abs.HwAbs;
import com.hwfit.otg.OTGManager;
import com.senseplay.sdk.SPManager;
import com.senseplay.sdk.SPUsb;
import com.senseplay.sdk.log.SPDebug;
import com.senseplay.sdk.tool.FileTool;
import com.senseplay.sdk.tool.SPUtilTool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public class VideoPlay {
    public static boolean flag = false;
    private UsbByteListener listener;
    private Context mContext;
    private HwAbs mHwAbs;
    VideoPlayerThread mVideo0PlayerThread;
    private FileOutputStream out;
    private int playType;
    private long bitsrteam0 = 0;
    private long bitsrteam1 = 0;
    private boolean isRecording = false;
    private String streamPath = "";
    private final long maxBtrate = 3145728;

    public VideoPlay() {
        init();
        this.playType = 1;
    }

    public VideoPlay(int i) {
        init();
        this.playType = i;
    }

    private void init() {
        this.mContext = SPManager.getContent();
        this.mHwAbs = SPUsb.getInstance().getUsb();
        flag = false;
    }

    public void setUsbByteListener(UsbByteListener usbByteListener) {
        this.listener = usbByteListener;
    }

    public void play(Surface surface) {
        play(surface, null);
    }

    private void play(Surface surface, Surface surface2) {
        flag = true;
        if (this.mHwAbs == null) {
            SPDebug.m5815d("mHwAbs", "mHwAbs is null");
            return;
        }
        try {
            this.mVideo0PlayerThread = new VideoPlayerThread(surface, this.playType);
            this.mHwAbs.OtgVideoDataAcceptCb(new OTGManager.IOTG_VideoCB() { // from class: com.senseplay.sdk.video.VideoPlay.1
                @Override // com.hwfit.otg.OTGManager.IOTG_VideoCB
                public void video0Data(byte[] bArr, int i, int i2) {
                }

                @Override // com.hwfit.otg.OTGManager.IOTG_VideoCB
                public void video0Data(byte[] bArr, int i) {
                    VideoPlay.this.addByte0(bArr, i);
                }

                @Override // com.hwfit.otg.OTGManager.IOTG_VideoCB
                public void video1Data(byte[] bArr, int i) {
                    VideoPlay.this.addByte0(bArr, i);
                }
            });
            if (this.mVideo0PlayerThread != null) {
                this.mVideo0PlayerThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playAr(Surface surface) {
        flag = true;
        if (this.mHwAbs == null) {
            SPDebug.m5815d("mHwAbs", "mHwAbs is null");
            return;
        }
        try {
            this.mVideo0PlayerThread = new VideoPlayerThread(surface, this.playType);
            this.mHwAbs.OtgVideoDataAcceptCb(new OTGManager.IOTG_VideoCB() { // from class: com.senseplay.sdk.video.VideoPlay.2
                @Override // com.hwfit.otg.OTGManager.IOTG_VideoCB
                public void video0Data(byte[] bArr, int i, int i2) {
                }

                @Override // com.hwfit.otg.OTGManager.IOTG_VideoCB
                public void video1Data(byte[] bArr, int i) {
                }

                @Override // com.hwfit.otg.OTGManager.IOTG_VideoCB
                public void video0Data(byte[] bArr, int i) {
                    VideoPlay.this.addByte0(bArr, i);
                }
            });
            this.mVideo0PlayerThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addByte0(byte[] bArr, int i) {
        if (bArr != null) {
            try {
                if (bArr.length == 0 || this.mVideo0PlayerThread == null) {
                    return;
                }
                this.mVideo0PlayerThread.AddData(bArr, i);
                if (this.out != null && this.isRecording) {
                    this.out.write(bArr, 0, i);
                }
                if (this.bitsrteam0 > 3145728) {
                    this.bitsrteam0 = 0L;
                }
                this.bitsrteam0 += i;
                if (this.listener != null) {
                    this.listener.usbByte(bArr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getBufferSize() {
        return VideoPlayerThread.bufferSize;
    }

    public void setStreamSavePath(String str) {
        this.streamPath = str;
    }

    public void startStreamRecording() {
        this.isRecording = true;
        try {
            String str = this.streamPath;
            if (SPUtilTool.isNull(str)) {
                str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/StreamFile_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".mp4";
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
            this.out = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void startStreamRecording(String str) {
        this.isRecording = true;
        try {
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
            this.out = new FileOutputStream(file);
            FileTool.refreshFile(this.mContext, file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void stopStreamRecording() {
        this.isRecording = false;
        try {
            if (this.out != null) {
                this.out.flush();
                this.out.close();
                this.out = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public float getBtrate0() {
        float f = ((((float) this.bitsrteam0) * 8.0f) / 1024.0f) / 1024.0f;
        this.bitsrteam0 = 0L;
        return f;
    }

    public float getBtrate1() {
        float f = ((((float) this.bitsrteam1) * 8.0f) / 1024.0f) / 1024.0f;
        this.bitsrteam1 = 0L;
        return f;
    }

    public void stop() {
        flag = false;
        this.bitsrteam0 = 0L;
        this.bitsrteam1 = 0L;
        this.mHwAbs = null;
        VideoPlayerThread videoPlayerThread = this.mVideo0PlayerThread;
        if (videoPlayerThread != null) {
            videoPlayerThread.realse();
            this.mVideo0PlayerThread = null;
        }
    }
}
