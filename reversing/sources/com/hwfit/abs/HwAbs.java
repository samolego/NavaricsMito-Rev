package com.hwfit.abs;

import android.content.Context;
import android.util.Log;
import com.MThread.C0591MThread;
import com.MThread.MThreadI;
import com.common.IOTA_State;
import com.common.OTA_TARGET;
import com.hwfit.artosyn.IArtosynAck;
import com.hwfit.common.OTA_Proc;
import com.hwfit.otg.OTGManager;
import com.jnilib.CppSDKConnectors;
import com.p035dg.ConfigManager;
import com.p035dg.SpSdkDirectory;

/* loaded from: classes.dex */
public class HwAbs {
    public static final boolean EN_AR_THREAD = false;
    public static final int HW_TYPE_IS_AOA = 13;
    public static final int HW_TYPE_IS_OTG = 10;
    public static final int HW_TYPE_IS_UART = 11;
    public static final int HW_TYPE_IS_WIFI = 12;
    public static int hwType = 10;
    private C0591MThread UsbHreatbeatThread;
    private C0591MThread arHandlerThread;
    private C0591MThread cmdHandlerThread;
    private Context context;
    private OTGManager mOtgManager = null;
    private MThreadI cmdHandlerThreadLoop = new MThreadI() { // from class: com.hwfit.abs.HwAbs.1
        @Override // com.MThread.MThreadI
        public void Exec() {
            try {
                OTGManager unused = HwAbs.this.mOtgManager;
                if (OTGManager.CmdGetCnt >= ConfigManager.GetInstance().getConfig().getCmdProcDelayCnt()) {
                    CppSDKConnectors.CmdHandler();
                }
                Thread.sleep(ConfigManager.GetInstance().getConfig().getCmdHandlePeriod());
            } catch (InterruptedException unused2) {
            }
        }
    };
    private MThreadI arHandlerThreadLoop = new MThreadI() { // from class: com.hwfit.abs.HwAbs.2
        @Override // com.MThread.MThreadI
        public void Exec() {
            try {
                CppSDKConnectors.ArProcHandler();
                Thread.sleep(ConfigManager.GetInstance().getConfig().getArHandleProcPeriod());
            } catch (InterruptedException e) {
                Log.e("AR", e.toString());
            }
        }
    };
    private MThreadI mIUsbHreatbeat = new MThreadI() { // from class: com.hwfit.abs.HwAbs.3
        @Override // com.MThread.MThreadI
        public void Exec() {
            switch (HwAbs.hwType) {
                case 10:
                    HwAbs.this.mOtgManager.usbHdrbeat();
                    return;
                case 11:
                default:
                    return;
            }
        }
    };

    public void enterDfmModle() {
    }

    public HwAbs(Context context, int i) throws Exception {
        hwType = i;
        this.context = context;
        if (this.context == null) {
            throw new Exception("context is null!");
        }
        int i2 = hwType;
        if (10 != i2 && 11 != i2 && 12 != i2 && 13 != i2) {
            throw new Exception("hw type error!");
        }
        ConfigManager.GetInstance().GetConfigsFormFile();
        if (ConfigManager.GetInstance().getConfig().isSaveArDataToFile()) {
            CppSDKConnectors.ArFrameToFile(SpSdkDirectory.arFolder);
        }
        CppSDKConnectors.ArSetIncMode(ConfigManager.GetInstance().getConfig().isArKitIncMode() ? (byte) 1 : (byte) 0);
        CppSDKConnectors.ArSetPointsSizeUpperLimit(ConfigManager.GetInstance().getConfig().getPointsSizeUpperLimit());
        CppSDKConnectors.ArSetSlamLogEn(ConfigManager.GetInstance().getConfig().isSlamLogEn());
    }

    public boolean Connect() throws Exception {
        if (this.cmdHandlerThread == null) {
            this.cmdHandlerThread = new C0591MThread(this.cmdHandlerThreadLoop, "CMD-Handler");
        }
        if (!this.cmdHandlerThread.IsRunning()) {
            this.cmdHandlerThread.start();
        }
        if (this.cmdHandlerThread.isPause()) {
            this.cmdHandlerThread.resumeThread();
        }
        ConfigManager.GetInstance().getConfig().isEnArThread();
        switch (hwType) {
            case 10:
                if (this.mOtgManager == null) {
                    this.mOtgManager = OTGManager.GetInstance();
                }
                this.mOtgManager.Connect(this.context);
                break;
        }
        if (ConfigManager.GetInstance().getConfig().isEnUsbHeartbeat() && this.UsbHreatbeatThread == null) {
            this.UsbHreatbeatThread = new C0591MThread(this.mIUsbHreatbeat, "USB-Hreatbeat");
        }
        if (ConfigManager.GetInstance().getConfig().isEnUsbHeartbeat() && !this.UsbHreatbeatThread.IsRunning()) {
            this.UsbHreatbeatThread.start();
        }
        if (ConfigManager.GetInstance().getConfig().isEnUsbHeartbeat() && this.UsbHreatbeatThread.isPause()) {
            this.UsbHreatbeatThread.resumeThread();
            return true;
        }
        return true;
    }

    public boolean Disconnect() {
        C0591MThread c0591MThread;
        CppSDKConnectors.UsbStopCmd();
        if (ConfigManager.GetInstance().getConfig().isEnUsbHeartbeat() && (c0591MThread = this.UsbHreatbeatThread) != null) {
            c0591MThread.pauseThread();
        }
        C0591MThread c0591MThread2 = this.cmdHandlerThread;
        if (c0591MThread2 != null) {
            c0591MThread2.pauseThread();
        }
        C0591MThread c0591MThread3 = this.cmdHandlerThread;
        if (c0591MThread3 != null) {
            c0591MThread3.pauseThread();
        }
        int i = hwType;
        if (10 == i) {
            OTGManager oTGManager = this.mOtgManager;
            if (oTGManager == null) {
                return false;
            }
            oTGManager.disconnect();
        } else if (11 != i) {
        }
        Exit();
        return true;
    }

    public void OtgVideoDataAcceptCb(OTGManager.IOTG_VideoCB iOTG_VideoCB) {
        if (this.mOtgManager == null) {
            this.mOtgManager = OTGManager.GetInstance();
        }
        this.mOtgManager.ConfigVideoCb(iOTG_VideoCB);
    }

    public void Exit() {
        C0591MThread c0591MThread;
        if (ConfigManager.GetInstance().getConfig().isEnUsbHeartbeat() && (c0591MThread = this.UsbHreatbeatThread) != null) {
            c0591MThread.exit();
            this.UsbHreatbeatThread = null;
        }
        C0591MThread c0591MThread2 = this.cmdHandlerThread;
        if (c0591MThread2 != null) {
            c0591MThread2.exit();
            this.cmdHandlerThread = null;
        }
        if (hwType != 10) {
            return;
        }
        this.mOtgManager.exit();
    }

    public boolean HwConnectReady() {
        if (ConfigManager.GetInstance().getConfig().isArUseTestData()) {
            return true;
        }
        switch (hwType) {
            case 10:
                return this.mOtgManager.hwConnectReady();
            case 11:
            case 12:
            case 13:
            default:
                return false;
        }
    }

    public String SdkVersion() {
        return CppSDKConnectors.sdkVersion();
    }

    public void artosynCmd(IArtosynAck iArtosynAck) {
        if (hwType != 10) {
            return;
        }
        if (this.mOtgManager == null) {
            this.mOtgManager = OTGManager.GetInstance();
        }
        this.mOtgManager.artosynCmd(iArtosynAck);
    }

    public int GetHwType() {
        return hwType;
    }

    public boolean StartOTA(String str, OTA_TARGET ota_target, IOTA_State iOTA_State) {
        return OTA_Proc.GetInstance().StartOTA(str, ota_target, iOTA_State);
    }
}
