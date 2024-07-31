package com.senseplay.sdk;

import android.os.Handler;
import android.os.Message;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.model.slam.SlamThread;

/* loaded from: classes2.dex */
public class SPSlam {
    public static MCallBack<Integer> arCallBack;
    public static MCallBack<String> slamCallBack;
    private static SPSlam spSlam;
    private byte[] arBytes = null;
    private final int type_ar = 1;
    private final int type_slam = 2;
    Handler handler = new Handler() { // from class: com.senseplay.sdk.SPSlam.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1 && SPSlam.arCallBack != null) {
                SPSlam.this.arBytes = (byte[]) message.obj;
                SPSlam.arCallBack.onResult(Integer.valueOf(message.arg1));
            } else if (i != 2 || SPSlam.slamCallBack == null) {
            } else {
                SPSlam.slamCallBack.onResult((String) message.obj);
            }
        }
    };
    private SlamThread slamThread = new SlamThread();

    public static SPSlam getInstance() {
        if (spSlam == null) {
            synchronized (SPSlam.class) {
                if (spSlam == null) {
                    spSlam = new SPSlam();
                }
            }
        }
        return spSlam;
    }

    private SPSlam() {
        this.slamThread.setSlamListener(new SlamThread.SlamListener() { // from class: com.senseplay.sdk.SPSlam.1
            @Override // com.senseplay.sdk.model.slam.SlamThread.SlamListener
            public void arData(byte[] bArr, int i) {
                Message message = new Message();
                message.what = 1;
                message.obj = bArr;
                message.arg1 = i;
                SPSlam.this.handler.sendMessage(message);
            }

            @Override // com.senseplay.sdk.model.slam.SlamThread.SlamListener
            public void slamData(String str, int i) {
                Message message = new Message();
                message.what = 2;
                message.obj = str;
                SPSlam.this.handler.sendMessage(message);
            }
        });
        this.slamThread.start();
    }

    public void getArData(MCallBack<Integer> mCallBack) {
        arCallBack = mCallBack;
    }

    public byte[] getArBytes() {
        return this.arBytes;
    }

    public void getSlamInfo(MCallBack<String> mCallBack) {
        slamCallBack = mCallBack;
    }

    public void release() {
        SlamThread slamThread = this.slamThread;
        if (slamThread != null) {
            slamThread.release();
        }
        spSlam = null;
    }
}
