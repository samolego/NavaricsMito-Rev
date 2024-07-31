package com.p035dg;

import android.util.Log;
import com.google.gson.Gson;

/* renamed from: com.dg.SysConfigs */
/* loaded from: classes.dex */
public class SysConfigs {
    private int ArCubicSpanX;
    private int ArCubicSpanY;
    private int ArCubicSpanZ;
    private int ArCubicUnitX;
    private int ArCubicUnitY;
    private int ArCubicUnitZ;
    private int ArHandleProcPeriod;
    private boolean ArKitIncMode;
    private boolean ArKitRelSaveToFile;
    private boolean ArUseTestData;
    private int CmdHandlePeriod;
    private int CmdProcDelayCnt;
    private boolean EnArThread;
    private boolean EnUsbHeartbeat;
    private int OtgWriteAndReadTimerout;
    private int PointsSizeUpperLimit;
    private boolean SaveArDataToFile;
    private int SendToUsbPeriod;
    private boolean SlamLogEn;
    private boolean StatisticsLogEn;
    private int UsbHeartbeatPeriod;
    private int UsbTryOpenCnt;
    private int VideoProcHandlePeriod;

    public boolean isEnArThread() {
        return this.EnArThread;
    }

    public void setEnArThread(boolean z) {
        this.EnArThread = z;
    }

    public boolean isSlamLogEn() {
        return this.SlamLogEn;
    }

    public void setSlamLogEn(boolean z) {
        this.SlamLogEn = z;
    }

    public boolean isArKitRelSaveToFile() {
        return this.ArKitRelSaveToFile;
    }

    public void setArKitRelSaveToFile(boolean z) {
        this.ArKitRelSaveToFile = z;
    }

    public int getPointsSizeUpperLimit() {
        return this.PointsSizeUpperLimit;
    }

    public void setPointsSizeUpperLimit(int i) {
        this.PointsSizeUpperLimit = i;
    }

    public boolean isArKitIncMode() {
        return this.ArKitIncMode;
    }

    public void setArKitIncMode(boolean z) {
        this.ArKitIncMode = z;
    }

    public int getVideoProcHandlePeriod() {
        return this.VideoProcHandlePeriod;
    }

    public void setVideoProcHandlePeriod(int i) {
        this.VideoProcHandlePeriod = i;
    }

    public int getCmdHandlePeriod() {
        return this.CmdHandlePeriod;
    }

    public void setCmdHandlePeriod(int i) {
        this.CmdHandlePeriod = i;
    }

    public boolean isArUseTestData() {
        return this.ArUseTestData;
    }

    public void setArUseTestData(boolean z) {
        this.ArUseTestData = z;
    }

    public int getCmdProcDelayCnt() {
        return this.CmdProcDelayCnt;
    }

    public void setCmdProcDelayCnt(int i) {
        this.CmdProcDelayCnt = i;
    }

    public int getArHandleProcPeriod() {
        return this.ArHandleProcPeriod;
    }

    public void setArHandleProcPeriod(int i) {
        this.ArHandleProcPeriod = i;
    }

    public int getArCubicUnitX() {
        return this.ArCubicUnitX;
    }

    public void setArCubicUnitX(int i) {
        this.ArCubicUnitX = i;
    }

    public int getArCubicUnitY() {
        return this.ArCubicUnitY;
    }

    public void setArCubicUnitY(int i) {
        this.ArCubicUnitY = i;
    }

    public int getArCubicUnitZ() {
        return this.ArCubicUnitZ;
    }

    public void setArCubicUnitZ(int i) {
        this.ArCubicUnitZ = i;
    }

    public int getArCubicSpanX() {
        return this.ArCubicSpanX;
    }

    public void setArCubicSpanX(int i) {
        this.ArCubicSpanX = i;
    }

    public int getArCubicSpanY() {
        return this.ArCubicSpanY;
    }

    public void setArCubicSpanY(int i) {
        this.ArCubicSpanY = i;
    }

    public int getArCubicSpanZ() {
        return this.ArCubicSpanZ;
    }

    public void setArCubicSpanZ(int i) {
        this.ArCubicSpanZ = i;
    }

    public boolean isSaveArDataToFile() {
        return this.SaveArDataToFile;
    }

    public void setSaveArDataToFile(boolean z) {
        this.SaveArDataToFile = z;
    }

    public boolean isStatisticsLogEn() {
        return this.StatisticsLogEn;
    }

    public void setStatisticsLogEn(boolean z) {
        this.StatisticsLogEn = z;
    }

    public int getSendToUsbPeriod() {
        return this.SendToUsbPeriod;
    }

    public void setSendToUsbPeriod(int i) {
        this.SendToUsbPeriod = i;
    }

    public int getUsbTryOpenCnt() {
        return this.UsbTryOpenCnt;
    }

    public void setUsbTryOpenCnt(int i) {
        this.UsbTryOpenCnt = i;
    }

    public int getOtgWriteAndReadTimerout() {
        return this.OtgWriteAndReadTimerout;
    }

    public void setOtgWriteAndReadTimerout(int i) {
        this.OtgWriteAndReadTimerout = i;
    }

    public boolean isEnUsbHeartbeat() {
        return this.EnUsbHeartbeat;
    }

    public void setEnUsbHeartbeat(boolean z) {
        this.EnUsbHeartbeat = z;
    }

    public int getUsbHeartbeatPeriod() {
        return this.UsbHeartbeatPeriod;
    }

    public void setUsbHeartbeatPeriod(int i) {
        this.UsbHeartbeatPeriod = i;
    }

    public static String convertObjectToJsonString(SysConfigs sysConfigs) {
        try {
            return new Gson().toJson(sysConfigs);
        } catch (Exception unused) {
            return null;
        }
    }

    public static SysConfigs getConfigsFormJson(String str) {
        try {
            return (SysConfigs) new Gson().fromJson(str, (Class<Object>) SysConfigs.class);
        } catch (Exception e) {
            Log.e("SYS_CONFIG", e.toString());
            return null;
        }
    }

    public static SysConfigs getDefault() {
        SysConfigs sysConfigs = new SysConfigs();
        sysConfigs.ArCubicSpanX = 1000;
        sysConfigs.UsbTryOpenCnt = 5;
        sysConfigs.EnUsbHeartbeat = true;
        sysConfigs.SaveArDataToFile = false;
        sysConfigs.StatisticsLogEn = true;
        sysConfigs.SendToUsbPeriod = 10;
        sysConfigs.UsbHeartbeatPeriod = 380;
        sysConfigs.OtgWriteAndReadTimerout = 1000;
        sysConfigs.ArHandleProcPeriod = 8;
        sysConfigs.CmdProcDelayCnt = 20;
        sysConfigs.ArUseTestData = false;
        sysConfigs.CmdHandlePeriod = 15;
        sysConfigs.VideoProcHandlePeriod = 10;
        sysConfigs.ArKitIncMode = true;
        sysConfigs.PointsSizeUpperLimit = 5000;
        sysConfigs.ArKitRelSaveToFile = false;
        sysConfigs.SlamLogEn = false;
        sysConfigs.EnArThread = true;
        return sysConfigs;
    }

    public String toString() {
        return "SysConfigs{\n ArCubicUnitX=" + this.ArCubicUnitX + "\n ArCubicUnitY=" + this.ArCubicUnitY + "\n ArCubicUnitZ=" + this.ArCubicUnitZ + "\n ArCubicSpanX=" + this.ArCubicSpanX + "\n ArCubicSpanY=" + this.ArCubicSpanY + "\n ArCubicSpanZ=" + this.ArCubicSpanZ + "\n SaveArDataToFile=" + this.SaveArDataToFile + "\n StatisticsLogEn=" + this.StatisticsLogEn + "\n SendToUsbPeriod=" + this.SendToUsbPeriod + "\n UsbTryOpenCnt=" + this.UsbTryOpenCnt + "\n OtgWriteAndReadTimerout=" + this.OtgWriteAndReadTimerout + "\n EnUsbHeartbeat=" + this.EnUsbHeartbeat + "\n UsbHeartbeatPeriod=" + this.UsbHeartbeatPeriod + "\n CmdHandlePeriod=" + this.CmdHandlePeriod + "\n ArHandleProcPeriod=" + this.ArHandleProcPeriod + "\n CmdProcDelayCnt=" + this.CmdProcDelayCnt + "\n ArUseTestData=" + this.ArUseTestData + "\n VideoProcHandlePeriod=" + this.VideoProcHandlePeriod + "\n ArKitIncMode=" + this.ArKitIncMode + "\n ArKitRelSaveToFile=" + this.ArKitRelSaveToFile + "\n PointsSizeUpperLimit=" + this.PointsSizeUpperLimit + "\n}";
    }
}
