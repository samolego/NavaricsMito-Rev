package com.hwfit.otg;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.usb.UsbRequest;
import android.os.Debug;
import android.util.Log;
import com.MThread.C0591MThread;
import com.MThread.MThreadI;
import com.hwfit.artosyn.IArtosynAck;
import com.hwfit.common.StatisticsInfo;
import com.jnilib.CppSDKConnectors;
import com.p035dg.ConfigManager;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class OTGManager {
    public static int CmdGetCnt = 0;
    public static boolean EN_USB_REQUEST_M = true;
    private static OTGManager mInatance;
    public static int mReadCnt;
    public static int mSendCnt;
    public static IOTG_VideoCB mVideoCb;
    private C0591MThread DataRequestThread;
    private Timer mArTestTimer;
    private Timer mTimer;
    private String TAG = "OTG-Manager";

    /* renamed from: DG */
    private boolean f3444DG = true;
    private int usbOpenTryCnt = 0;
    private MThreadI mIDataRequest = new MThreadI() { // from class: com.hwfit.otg.OTGManager.1
        @Override // com.MThread.MThreadI
        public void Exec() {
            try {
                UsbRequest requestWait = USBHal.GetInstance().getConnection().requestWait();
                if (requestWait != null) {
                    USBCmdHal.getInstance().requestStream(requestWait);
                    USBCustomerHal.getInstance().requestStream(requestWait);
                    USBVideo0Hal.getInstance().requestStream(requestWait);
                    USBVideo1Hal.getInstance().requestStream(requestWait);
                }
            } catch (Exception unused) {
            }
        }
    };

    /* loaded from: classes.dex */
    public interface IOTG_VideoCB {
        void video0Data(byte[] bArr, int i);

        void video0Data(byte[] bArr, int i, int i2);

        void video1Data(byte[] bArr, int i);
    }

    public void artosynCmd(IArtosynAck iArtosynAck) {
    }

    private OTGManager() {
    }

    public static OTGManager GetInstance() {
        synchronized (OTGManager.class) {
            if (mInatance == null) {
                mInatance = new OTGManager();
            }
        }
        return mInatance;
    }

    public boolean Connect(Context context) throws Exception {
        USBHal.GetInstance().Init(context);
        if (!USBHal.GetInstance().USB_Ready()) {
            if (this.f3444DG) {
                Log.e(this.TAG, "USB Open Failed!");
            }
            return false;
        }
        if (USBHal.GetInstance().USB_Ready()) {
            USBCmdHal.getInstance().start();
            USBCustomerHal.getInstance().start();
            USBVideo0Hal.getInstance().start();
            USBVideo1Hal.getInstance().start();
            CppSDKConnectors.SendUsbHreatbeat();
            CppSDKConnectors.UsbStartCmd();
            if (EN_USB_REQUEST_M && this.DataRequestThread == null) {
                this.DataRequestThread = new C0591MThread(this.mIDataRequest, "USB-Request");
            }
            if (EN_USB_REQUEST_M && !this.DataRequestThread.IsRunning()) {
                this.DataRequestThread.start();
            }
            if (EN_USB_REQUEST_M && this.DataRequestThread.isPause()) {
                this.DataRequestThread.resumeThread();
            }
            Thread.sleep(30L);
            CppSDKConnectors.UsbStartCmd();
        } else {
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.usbOpenTryCnt++;
            if (this.usbOpenTryCnt > ConfigManager.GetInstance().getConfig().getUsbTryOpenCnt()) {
                Log.e(this.TAG, "USB Try open failed!!!");
                this.usbOpenTryCnt = 0;
                return false;
            }
            Log.e(this.TAG, "USB open failed,try again: " + this.usbOpenTryCnt);
            try {
                Connect(context);
            } catch (Exception e2) {
                Log.e(this.TAG, e2.toString());
            }
        }
        StatisticsLog();
        if (this.f3444DG) {
            Log.i(this.TAG, "hardware type is usb!");
        }
        return true;
    }

    public void disconnect() {
        C0591MThread c0591MThread;
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
        Timer timer2 = this.mArTestTimer;
        if (timer2 != null) {
            timer2.cancel();
            this.mArTestTimer = null;
        }
        CppSDKConnectors.UsbStopCmd();
        if (EN_USB_REQUEST_M && (c0591MThread = this.DataRequestThread) != null) {
            c0591MThread.pauseThread();
        }
        USBCmdHal.getInstance().disconnect();
        USBCustomerHal.getInstance().disconnect();
        USBVideo0Hal.getInstance().disconnect();
        USBVideo1Hal.getInstance().disconnect();
        USBHal.GetInstance().close();
        exit();
    }

    public void ConfigVideoCb(IOTG_VideoCB iOTG_VideoCB) {
        mVideoCb = iOTG_VideoCB;
    }

    public void exit() {
        C0591MThread c0591MThread;
        USBCmdHal.getInstance().exit();
        USBCustomerHal.getInstance().exit();
        USBVideo0Hal.getInstance().exit();
        USBVideo1Hal.getInstance().exit();
        if (!EN_USB_REQUEST_M || (c0591MThread = this.DataRequestThread) == null) {
            return;
        }
        c0591MThread.exit();
        this.DataRequestThread = null;
    }

    public boolean hwConnectReady() {
        return USBHal.GetInstance().USB_Ready();
    }

    public void usbHdrbeat() {
        if (hwConnectReady()) {
            if (ConfigManager.GetInstance().getConfig().isEnUsbHeartbeat()) {
                CppSDKConnectors.SendUsbHreatbeat();
            }
        } else {
            Log.e(this.TAG, "[UsbHreatbeat] usb not connected!");
        }
        try {
            Thread.sleep(ConfigManager.GetInstance().getConfig().getUsbHeartbeatPeriod());
        } catch (InterruptedException unused) {
        }
    }

    @TargetApi(19)
    public static int getMemory() {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        int totalPrivateClean = memoryInfo.getTotalPrivateClean();
        int totalPrivateDirty = memoryInfo.getTotalPrivateDirty();
        int totalPss = memoryInfo.getTotalPss();
        int totalSharedClean = memoryInfo.getTotalSharedClean();
        return totalPrivateClean + totalPrivateDirty + totalPss + totalSharedClean + memoryInfo.getTotalSharedDirty() + memoryInfo.getTotalSwappablePss();
    }

    private void StatisticsLog() {
        if (this.mTimer == null) {
            this.mTimer = new Timer();
            if (ConfigManager.GetInstance().getConfig().isStatisticsLogEn()) {
                this.mTimer.schedule(new TimerTask() { // from class: com.hwfit.otg.OTGManager.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        DecimalFormat decimalFormat = new DecimalFormat("##0.00");
                        int i = StatisticsInfo.V0_CodeRate;
                        int i2 = StatisticsInfo.V1_CodeRate;
                        StatisticsInfo.SendPktNum = OTGManager.mSendCnt;
                        StatisticsInfo.ReadPktNum = OTGManager.mReadCnt;
                        StatisticsInfo.V0_CodeRate = 0;
                        StatisticsInfo.V1_CodeRate = 0;
                        OTGManager.mSendCnt = 0;
                        OTGManager.mReadCnt = 0;
                        if (USBVideo0Hal.NATIVE_SEARCH_FRAME_EN) {
                            StatisticsInfo.V0TotalFrameCnt = CppSDKConnectors.getFrameCnt(0);
                            StatisticsInfo.V0FrameRate = StatisticsInfo.V0TotalFrameCnt - StatisticsInfo.V0LastFrameCnt;
                            StatisticsInfo.V0LastFrameCnt = StatisticsInfo.V0TotalFrameCnt;
                        }
                        Log.d("STATISTICS_V", "[V0:" + StatisticsInfo.V0FrameRate + "f " + decimalFormat.format(((i * 8.0f) / 1024.0f) / 1024.0f) + "M] - [V1: " + decimalFormat.format(((i2 * 8.0f) / 1024.0f) / 1024.0f) + "Mbps ] | RdPkt: " + StatisticsInfo.ReadPktNum + " WrPkt: " + StatisticsInfo.SendPktNum + " Memory: " + OTGManager.getMemory());
                        int i3 = StatisticsInfo.ArGetUsbFrameCodeRate;
                        int GetArFrameCnt = CppSDKConnectors.GetArFrameCnt();
                        int i4 = StatisticsInfo.ArU3DGetRate;
                        int GetArKitPktsCnt = CppSDKConnectors.GetArKitPktsCnt();
                        CppSDKConnectors.ArKitPktsCntReset();
                        StatisticsInfo.ArGetUsbFrameCodeRate = 0;
                        StatisticsInfo.ArU3DGetRate = 0;
                        StatisticsInfo.ArTotatlPkts = StatisticsInfo.ArTotatlPkts + GetArFrameCnt;
                        StatisticsInfo.ArKitTotalPkts = StatisticsInfo.ArKitTotalPkts + GetArKitPktsCnt;
                        Log.d("STATISTICS_AR", "[USB {Frame:" + GetArFrameCnt + "f/s }{Rate:" + decimalFormat.format((i3 * 8.0f) / 1024.0f) + " kbps}{PsuhMesh:" + GetArKitPktsCnt + "}] [U3D:{Rate:" + decimalFormat.format(i4 / 1024.0f) + "}{TotatlPkt: " + StatisticsInfo.ArTotatlPkts + "}{KitTotal:" + StatisticsInfo.ArKitTotalPkts + "}]");
                    }
                }, 100L, 1000L);
            }
        }
    }
}
