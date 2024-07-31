package com.jnilib;

import android.util.Log;
import android.view.Surface;
import java.io.File;

/* loaded from: classes.dex */
public class CppSDKConnectors {
    public static native void ArFrameToFile(String str);

    public static native void ArKitPktsCntReset();

    public static native int ArProcHandler();

    public static native void ArSetIncMode(byte b);

    public static native void ArSetPointsSizeUpperLimit(int i);

    public static native void ArSetSlamLogEn(boolean z);

    public static native int BinarySend(byte b, byte[] bArr, int i);

    public static native String BuildDate();

    public static native int ChangeGear(byte b);

    public static native int CmdHandler();

    public static native int DevChangeAcCode(byte[] bArr, byte[] bArr2);

    public static native int DevChangeUid(byte[] bArr, byte[] bArr2);

    public static native int DevEraseAcCode(byte[] bArr);

    public static native int DevEraseUid(byte[] bArr);

    public static native void DevGetAcCodeRel(byte[] bArr, byte[] bArr2);

    public static native byte DevGetAcVerifyRel();

    public static native void DevGetBattAttribute(byte[] bArr, byte[] bArr2);

    public static native void DevGetBattCurData(byte[] bArr, byte[] bArr2);

    public static native void DevGetBattName(byte[] bArr, byte[] bArr2);

    public static native int DevGetBatteryStatus(byte[] bArr);

    public static native int DevGetChangeAcCodeRel();

    public static native byte DevGetEraseAcCodeRel();

    public static native byte DevGetEraseUidRel();

    public static native int DevGetGpsInfo(byte[] bArr, double[] dArr, float[] fArr);

    public static native int DevGetInfoRel(byte[] bArr, byte[] bArr2);

    public static native void DevGetRequsetSnNum(byte[] bArr, byte[] bArr2);

    public static native int DevGetStatusInfoRel(byte[] bArr, byte[] bArr2);

    public static native void DevGetUid(byte[] bArr, byte[] bArr2);

    public static native byte DevGetUidChangeRel();

    public static native byte DevGetUidVerifyRel();

    public static native void DevGetUsageInfo(byte[] bArr, byte[] bArr2);

    public static native int DevLogDump(byte[] bArr);

    public static native int DevRequestAcCode(byte[] bArr);

    public static native int DevRequestAcVerify(byte[] bArr);

    public static native byte DevRequestInfo();

    public static native byte DevRequestStatusInfo();

    public static native int DevRequestUid();

    public static native int DevRequestUidVerify(byte[] bArr);

    public static native int DevRequsetBattAttribute();

    public static native int DevRequsetBattCurData();

    public static native int DevRequsetBattName();

    public static native int DevRequsetBattUsageInfo();

    public static native int DevRequsetSn();

    public static native int DevRfDisconnect();

    public static native int DevSendLogConfigCmd(byte b, byte b2);

    public static native int DeviceLink(byte[] bArr);

    public static native int DeviceSearch();

    public static native int DfmGetCidWriteRel();

    public static native void DfmGetRequestCidRel(byte[] bArr, byte[] bArr2);

    public static native void DfmGetRequestFlagRel(byte[] bArr, byte[] bArr2);

    public static native void DfmGetRequestSnRel(byte[] bArr, byte[] bArr2);

    public static native int DfmGetSnWriteRel();

    public static native int DfmGetWriteFlagRel();

    public static native int DfmRequestCid();

    public static native int DfmRequestFlag();

    public static native int DfmRequestSn();

    public static native void DfmSwitch(boolean z);

    public static native int DfmWriteChipID(byte[] bArr);

    public static native int DfmWriteFlag(byte[] bArr);

    public static native int DfmWriteSn(byte[] bArr);

    public static native int Drive(byte b);

    public static native int EnRfCommunication(boolean z);

    public static native int GetAOAPkts(byte[] bArr);

    public static native int GetAckData(byte[] bArr);

    public static native int GetArData(byte[] bArr);

    public static native int GetArFrameCnt();

    public static native int GetArKitPktsCnt();

    public static native int GetArtCmdPkt(short s, byte[] bArr);

    public static native int GetBrake();

    public static native int GetCamCount();

    public static native boolean GetChangeGearRel();

    public static native int GetCurSpeed();

    public static native int GetCustomInfo0(byte[] bArr);

    public static native int GetDevIMUState(byte[] bArr, float[] fArr);

    public static native int GetDevLeaplinkInfo(byte[] bArr);

    public static native byte GetDevStatus();

    public static native boolean GetDriveRel();

    public static native boolean GetGearRel();

    public static native int GetLocalInfo(byte[] bArr);

    public static native byte GetMajorGear();

    public static native byte GetMinorGear();

    public static native int GetMotorRotateSpeed();

    public static native byte GetRCMode();

    public static native int GetRcIMUState(short[] sArr);

    public static native int GetRcLeaplinkInfo(byte[] bArr);

    public static native boolean GetRcRfStateRel();

    public static native int GetResidueBytes();

    public static native int GetSearchRel(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native boolean GetSetSpeedRel();

    public static native boolean GetSetSteerRel();

    public static native int GetSteerAngle();

    public static native boolean GetStreamingResult();

    public static native int GetThrottle();

    public static native short GetWarning();

    public static native int InifileTest(String str);

    public static native boolean KeymapWrite(byte[] bArr);

    public static native boolean KeymapWriteResult();

    public static native int Landing();

    public static native void OtaAckProc(byte[] bArr);

    public static native void OtaBinaryLoad(byte[] bArr, byte b);

    public static native void OtaClean();

    public static native float OtaFileSendProgress();

    public static native void OtaInit();

    public static native boolean OtaUpdateOver();

    public static native int PushAOAPkts(byte[] bArr);

    public static native int RcChangeAcCode(byte[] bArr, byte[] bArr2);

    public static native int RcChangeUid(byte[] bArr, byte[] bArr2);

    public static native int RcChangeUidRel();

    public static native int RcEraseAcCode(byte[] bArr);

    public static native int RcEraseUid(byte[] bArr);

    public static native void RcGetAcCodeRel(byte[] bArr, byte[] bArr2);

    public static native byte RcGetAcVerifyRel();

    public static native int RcGetBatteryStatus(byte[] bArr);

    public static native int RcGetChangeAcCodeRel();

    public static native byte RcGetEraseAcCodeRel();

    public static native int RcGetEraseRel();

    public static native int RcGetFireRel();

    public static native int RcGetGpsInfo(byte[] bArr, double[] dArr, float[] fArr);

    public static native int RcGetInfoRel(byte[] bArr, byte[] bArr2);

    public static native void RcGetSn(byte[] bArr, byte[] bArr2);

    public static native int RcGetSwitchWeaponRel();

    public static native void RcGetUid(byte[] bArr, byte[] bArr2);

    public static native byte RcGetUidVerifyRel();

    public static native int RcLogDump(byte[] bArr);

    public static native int RcRead(byte[] bArr);

    public static native int RcRequestAcCode();

    public static native int RcRequestAcVerify(byte[] bArr);

    public static native int RcRequestInfo();

    public static native int RcRequestUid();

    public static native int RcRequestUidVerify(byte[] bArr);

    public static native int RcRequsetSn();

    public static native int RcSendLogConfigCmd(byte b, byte b2);

    public static native byte RcStartVibrationAckRel();

    public static native int RcVibration(byte[] bArr);

    public static native int RcWrite(byte[] bArr, int i);

    public static native int RequestAttribute(byte b);

    public static native int RequestCamCount();

    public static native int RequestStatus(byte b);

    public static native int ReturnHome();

    public static native int RobPushUsbData(byte[] bArr, int i);

    public static native void RobTest();

    public static native int SendUsbHreatbeat();

    public static native int SendUserCmd(byte b, byte[] bArr);

    public static native int SendUserCmd2(byte b, byte[] bArr, int i, int i2);

    public static native void SetAutomativeLighting(byte b, byte b2);

    public static native int SetGear(byte b);

    public static native int SetHomePosition(byte[] bArr);

    public static native int SetSpeed(float f);

    public static native int SetStreaming(byte[] bArr);

    public static native int StartSendVibrationPkt(String str);

    public static native int Steer(byte b);

    public static native int Steer2(byte b, short s);

    public static native int Steer3(byte b, short s, byte b2);

    public static native int TakeOff();

    public static native int TakePhoto(byte b, byte b2, byte b3);

    public static native int UsbStartCmd();

    public static native int UsbStopCmd();

    public static native int destoryVideoCdecodec(int i);

    public static native int gerRequestEscVerRel(byte[] bArr, byte[] bArr2);

    public static native byte getCeuiseCtrl();

    public static native int getConfigCmdRel();

    public static native int getCruiseControlVal();

    public static native int getCurConfigData(byte[] bArr);

    public static native int getEscOtaDataRel(byte[] bArr);

    public static native int getFrameCnt(int i);

    public static native int getKeycode(byte[] bArr);

    public static native int getMotorParamLearnRel(byte[] bArr);

    public static native int getReadConfigData(byte[] bArr, byte[] bArr2);

    public static native int getReqCmaAttributeRel(byte[] bArr, byte[] bArr2);

    public static native int getRequestEscErasureRel(byte[] bArr);

    public static native int getRequestEscLinkRel(byte[] bArr);

    public static native int getRequestMfiStateRel(byte[] bArr, byte[] bArr2);

    public static native int getRequestPwmDutyCycleRel(byte[] bArr, byte[] bArr2);

    public static native int getRrequestEscDisconnectRel(byte[] bArr);

    public static native void getVideoParam(byte[] bArr, short[] sArr, short[] sArr2, byte[] bArr2);

    public static native int initVideoDecodec(int i, int i2, int i3, Surface surface);

    public static native int loadEscOtaFile(String str);

    public static native int loadInifile(String str);

    public static native int readConfigInfo(byte b);

    public static native void requestEscDisconnect();

    public static native void requestEscErasure();

    public static native void requestEscLink();

    public static native void requestEscVer();

    public static native int requestMfiState();

    public static native int requestPwmDutyCycle();

    public static native int rqusetCamAttribute(int i);

    public static native String sdkVersion();

    public static native int sendCurtSingleConfigCmd();

    public static native int sendEscNextSingleOtaData();

    public static native int sendEscSurSingleOtaData();

    public static native int sendNextSingleConfigCmd();

    public static native int setCamAttribute(byte[] bArr);

    public static native int setCamAttributeRel(byte[] bArr);

    public static native int setCeuiseCtrl(byte b);

    public static native int shutdownVideoDecodec(int i);

    public static native int startMotorParamLearn();

    public static native int startVideoDecodec(int i);

    public static native int vehicleSaveCfgs();

    public static native int videoPushStreamData(int i, byte[] bArr, int i2);

    public static void CreatDir(String str, int i) {
        File file = new File(str);
        if (file.exists() || file.mkdir()) {
            return;
        }
        Log.v("SDK_DIR", str + " create not success!");
    }

    static {
        System.loadLibrary("SDKNativeLib");
    }
}
