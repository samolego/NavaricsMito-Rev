package com.hwfit.common;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.MThread.C0591MThread;
import com.MThread.MThreadI;
import com.common.ARTOSYN_ACK_FRAME;
import com.common.IOTA_State;
import com.common.OTA_ACK_STATUS;
import com.common.OTA_STATE;
import com.common.OTA_TARGET;
import com.common.OTA_UPDATE_STATUS;
import com.common.SP_Util;
import com.hwfit.otg.USBCmdHal;
import com.jnilib.CppSDKConnectors;
import com.p035dg.ConfigManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes.dex */
public class OTA_Proc {
    private static final int STOP_COUNTDOWN = 9;
    private static String Tag = "OTA_PROC";
    private static OTA_Proc mInatance;
    private int AckCount;
    private OTA_STATE OtaState;
    private StringBuilder ackLogSb;
    private C0591MThread mAckFrameProc;
    private CountDownTimer mCountDownTimer;
    private IOTA_State mOTA_Failed;
    private OTA_TARGET mOtaTarget;
    private final BlockingQueue<ARTOSYN_ACK_FRAME> blockingQueue = new ArrayBlockingQueue(20);
    private boolean mSendOver = false;
    private boolean mFlashing = false;
    private boolean mLasterPktSend = false;
    private boolean mSuccess = false;
    private boolean mFirstTickMask = true;
    private int mFlashTimerCnt = 0;
    private int mFirstTickCnt = 0;
    private MThreadI mIAckFrameProc = new MThreadI() { // from class: com.hwfit.common.OTA_Proc.1
        @Override // com.MThread.MThreadI
        public void Exec() {
            try {
                ARTOSYN_ACK_FRAME artosyn_ack_frame = (ARTOSYN_ACK_FRAME) OTA_Proc.this.blockingQueue.take();
                if (artosyn_ack_frame != null) {
                    OTA_Proc.this.OtaAckProc(artosyn_ack_frame);
                }
                Thread.sleep(5L);
            } catch (Exception unused) {
            }
        }
    };
    private Handler mHandler = new Handler() { // from class: com.hwfit.common.OTA_Proc.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 9) {
                if (OTA_Proc.this.mCountDownTimer != null) {
                    OTA_Proc.this.mCountDownTimer.cancel();
                    OTA_Proc.this.mCountDownTimer = null;
                    Log.v(OTA_Proc.Tag, "stop count down.");
                } else {
                    Log.v(OTA_Proc.Tag, "count down is null！");
                }
                OTA_Proc.this.mFlashTimerCnt = 0;
                OTA_Proc.this.mFirstTickCnt = 0;
            }
        }
    };
    private List<Integer> mOtaNeedRetransmitPktIdxs = new ArrayList();
    private boolean mOtaRetransmitMode = false;

    static /* synthetic */ int access$408(OTA_Proc oTA_Proc) {
        int i = oTA_Proc.mFirstTickCnt;
        oTA_Proc.mFirstTickCnt = i + 1;
        return i;
    }

    private OTA_Proc() {
        if (this.mAckFrameProc == null) {
            this.mAckFrameProc = new C0591MThread(this.mIAckFrameProc, "OTA Ack Proc Thread");
        }
    }

    public static OTA_Proc GetInstance() {
        synchronized (OTA_Proc.class) {
            if (mInatance == null) {
                mInatance = new OTA_Proc();
            }
        }
        return mInatance;
    }

    private byte[] getBinFile(String str) {
        File file = new File(str);
        byte[] bArr = new byte[2097152];
        byte[] bArr2 = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int read = fileInputStream.read(bArr);
            bArr2 = new byte[read];
            System.arraycopy(bArr, 0, bArr2, 0, read);
            fileInputStream.close();
            return bArr2;
        } catch (IOException e) {
            e.printStackTrace();
            return bArr2;
        }
    }

    private void otaRetransmitPktIdxs(List<Integer> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                sb.append("," + (it.next().intValue() & 255));
            }
            String str = Tag;
            Log.v(str, "----------> " + sb.toString());
        }
    }

    public void pushAckFrame(ARTOSYN_ACK_FRAME artosyn_ack_frame) {
        if (artosyn_ack_frame == null) {
            return;
        }
        try {
            this.blockingQueue.put(artosyn_ack_frame);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ackCheck() {
        if (this.AckCount == 0) {
            if (this.mFlashing) {
                this.mFlashTimerCnt++;
                if (this.mFlashTimerCnt <= 31) {
                    return;
                }
            }
            Log.v(Tag, "timerTask-->mSuccess:" + this.mSuccess);
            if (this.mSuccess) {
                this.OtaState = OTA_STATE.UPGRADE_SUCCESS;
            } else {
                this.OtaState = OTA_STATE.UPGRADE_FAILED;
                IOTA_State iOTA_State = this.mOTA_Failed;
                if (iOTA_State != null) {
                    iOTA_State.isFailed();
                }
            }
            C0591MThread c0591MThread = this.mAckFrameProc;
            if (c0591MThread != null) {
                c0591MThread.pauseThread();
                this.mAckFrameProc.exit();
                this.mAckFrameProc = null;
            }
            this.mHandler.sendEmptyMessage(9);
            return;
        }
        this.AckCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishProc() {
        this.OtaState = OTA_STATE.UPGRADE_FAILED;
        IOTA_State iOTA_State = this.mOTA_Failed;
        if (iOTA_State != null) {
            iOTA_State.isFailed();
        }
        C0591MThread c0591MThread = this.mAckFrameProc;
        if (c0591MThread != null) {
            c0591MThread.pauseThread();
            this.mAckFrameProc.exit();
            this.mAckFrameProc = null;
        }
        this.mHandler.sendEmptyMessage(9);
    }

    public boolean StartOTA(String str, OTA_TARGET ota_target, IOTA_State iOTA_State) {
        byte[] binFile = getBinFile(str);
        if (binFile == null) {
            return false;
        }
        this.blockingQueue.clear();
        if (this.mAckFrameProc == null) {
            this.mAckFrameProc = new C0591MThread(this.mIAckFrameProc, "OTA Ack Proc Thread");
        }
        this.mOtaTarget = ota_target;
        byte b = OTA_TARGET.OTA_RC == ota_target ? (byte) 0 : (byte) 1;
        String str2 = Tag;
        StringBuilder sb = new StringBuilder();
        sb.append("Target: ");
        sb.append(b == 0 ? "GND" : "SKY");
        Log.v(str2, sb.toString());
        byte[] bArr = new byte[512];
        CppSDKConnectors.OtaInit();
        CppSDKConnectors.OtaBinaryLoad(binFile, b);
        int BinarySend = CppSDKConnectors.BinarySend(OTA_UPDATE_STATUS.getValue(OTA_UPDATE_STATUS.OTA_INIT), bArr, 0);
        byte[] bArr2 = new byte[BinarySend];
        System.arraycopy(bArr, 0, bArr2, 0, BinarySend);
        String str3 = Tag;
        Log.e(str3, "Send Len:: " + BinarySend + "  " + SP_Util.byte2str(bArr2));
        if (!this.mAckFrameProc.IsRunning()) {
            this.mAckFrameProc.start();
        }
        if (this.mAckFrameProc.isPause()) {
            this.mAckFrameProc.resumeThread();
        }
        this.mFirstTickMask = true;
        this.mSendOver = false;
        this.mLasterPktSend = false;
        this.mFlashing = false;
        this.mSuccess = false;
        this.AckCount = 0;
        this.mFlashTimerCnt = 0;
        this.mFirstTickCnt = 0;
        this.OtaState = OTA_STATE.SENDING_BIN;
        this.mOTA_Failed = iOTA_State;
        ConfigManager.GetInstance().getConfig().setEnUsbHeartbeat(false);
        USBCmdHal.getInstance().write(bArr2, bArr2.length);
        this.mCountDownTimer = new CountDownTimer(240000L, 1500L) { // from class: com.hwfit.common.OTA_Proc.3
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (!OTA_Proc.this.mFirstTickMask) {
                    OTA_Proc.this.ackCheck();
                    return;
                }
                OTA_Proc.access$408(OTA_Proc.this);
                if (OTA_Proc.this.mOtaTarget == OTA_TARGET.OTA_RC) {
                    if (OTA_Proc.this.mFirstTickCnt >= 2) {
                        OTA_Proc.this.mFirstTickMask = false;
                    }
                } else if (OTA_Proc.this.mFirstTickCnt >= 10) {
                    OTA_Proc.this.mFirstTickMask = false;
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                OTA_Proc.this.finishProc();
            }
        };
        this.mCountDownTimer.start();
        return true;
    }

    public void OtaAckProc(ARTOSYN_ACK_FRAME artosyn_ack_frame) {
        int i;
        IOTA_State iOTA_State;
        this.ackLogSb = new StringBuilder();
        byte[] bArr = new byte[512];
        byte value = OTA_UPDATE_STATUS.getValue(OTA_UPDATE_STATUS.OTA_LAST_PKT_OK);
        this.AckCount++;
        if (this.mSendOver && this.mOTA_Failed != null && this.mOtaTarget == OTA_TARGET.OTA_DEVICE) {
            this.mFlashing = true;
            this.mOTA_Failed.isFlashWritting();
        }
        if (!this.mFlashing && !this.mSendOver && (iOTA_State = this.mOTA_Failed) != null) {
            iOTA_State.isProcessing(CppSDKConnectors.OtaFileSendProgress());
        }
        this.ackLogSb.append("[ACK] ,State:");
        this.ackLogSb.append(artosyn_ack_frame.AckStatus.toString() + " ,");
        if (OTA_ACK_STATUS.SUCCESS == artosyn_ack_frame.AckStatus) {
            List<Integer> list = this.mOtaNeedRetransmitPktIdxs;
            if (list != null && this.mOtaRetransmitMode) {
                if (list.size() != 0) {
                    this.mOtaNeedRetransmitPktIdxs.remove(0);
                    if (this.mOtaNeedRetransmitPktIdxs.size() != 0) {
                        i = this.mOtaNeedRetransmitPktIdxs.get(0).intValue();
                        value = OTA_UPDATE_STATUS.getValue(OTA_UPDATE_STATUS.OTA_RETRANSMIT_PKT);
                        this.ackLogSb.append(" [1]-- [SUCCESS] Retransmit pkt::" + i);
                    } else {
                        this.ackLogSb.append(" [A]-- Last Packet!");
                        value = OTA_UPDATE_STATUS.getValue(OTA_UPDATE_STATUS.OTA_END_PKT_SEND);
                        this.mOtaRetransmitMode = false;
                        this.ackLogSb.append(" [2]-- [SUCCESS] Retransmit Send Last PKT::0");
                        this.mLasterPktSend = true;
                        i = 0;
                    }
                } else {
                    value = OTA_UPDATE_STATUS.getValue(OTA_UPDATE_STATUS.OTA_END_PKT_SEND);
                    this.mOtaRetransmitMode = false;
                    this.ackLogSb.append(" [3]-- [SUCCESS] Send PKT:: 0");
                    i = 0;
                }
            } else {
                this.ackLogSb.append(" [P]-- [SUCCESS] Send next pkt. ");
                if (CppSDKConnectors.OtaUpdateOver()) {
                    this.ackLogSb.append(" [B]-- Send Over!");
                    Log.v(Tag, this.ackLogSb.toString());
                    if (this.mOtaTarget == OTA_TARGET.OTA_DEVICE) {
                        IOTA_State iOTA_State2 = this.mOTA_Failed;
                        if (iOTA_State2 != null) {
                            this.mSuccess = true;
                            iOTA_State2.isSuccess();
                        }
                        this.mHandler.sendEmptyMessage(9);
                        return;
                    } else if (this.mSendOver) {
                        IOTA_State iOTA_State3 = this.mOTA_Failed;
                        if (iOTA_State3 != null) {
                            this.mSuccess = true;
                            iOTA_State3.isSuccess();
                        }
                        this.mHandler.sendEmptyMessage(9);
                        return;
                    } else {
                        this.mSendOver = true;
                        IOTA_State iOTA_State4 = this.mOTA_Failed;
                        if (iOTA_State4 != null) {
                            this.mFlashing = true;
                            iOTA_State4.isFlashWritting();
                            return;
                        }
                        return;
                    }
                }
                value = OTA_UPDATE_STATUS.getValue(OTA_UPDATE_STATUS.OTA_LAST_PKT_OK);
                i = 0;
            }
        } else if (OTA_ACK_STATUS.FAIL != artosyn_ack_frame.AckStatus && OTA_ACK_STATUS.ARQ == artosyn_ack_frame.AckStatus) {
            List<Integer> errList = artosyn_ack_frame.getErrList();
            if (errList != null && errList.size() != 0) {
                this.mOtaNeedRetransmitPktIdxs = errList;
                this.mOtaRetransmitMode = true;
                otaRetransmitPktIdxs(errList);
                value = OTA_UPDATE_STATUS.getValue(OTA_UPDATE_STATUS.OTA_RETRANSMIT_PKT);
                i = this.mOtaNeedRetransmitPktIdxs.get(0).intValue();
                this.ackLogSb.append(" [4]-- Ota Retransmit Mode::Count " + this.mOtaNeedRetransmitPktIdxs.size() + ":::send pkt::" + i);
            } else {
                this.ackLogSb.append(" [C]-- Last Packet!");
                value = OTA_UPDATE_STATUS.getValue(OTA_UPDATE_STATUS.OTA_LAST_PKT_OK);
                this.ackLogSb.append(" [5]-- [ARQ4] Send Last PKT:0");
                i = 0;
            }
        } else {
            i = 0;
        }
        int BinarySend = CppSDKConnectors.BinarySend(value, bArr, i);
        if (BinarySend > 0) {
            byte[] bArr2 = new byte[BinarySend];
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
            this.ackLogSb.append("[6]-- Send pkt,State: " + ((int) value) + " size: " + BinarySend);
            USBCmdHal.getInstance().write(bArr2, bArr2.length);
        }
        if (CppSDKConnectors.OtaUpdateOver() && this.mOtaTarget == OTA_TARGET.OTA_DEVICE) {
            this.mSendOver = true;
            this.ackLogSb.append(" [H]-- Send Over!");
        }
        Log.v(Tag, this.ackLogSb.toString());
    }

    public float binSentProgress() {
        return CppSDKConnectors.OtaFileSendProgress();
    }

    public OTA_STATE getOtaState() {
        return this.OtaState;
    }
}
