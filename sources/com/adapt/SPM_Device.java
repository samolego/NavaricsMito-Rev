package com.adapt;

import com.common.CAM_ATTRIBUTE;
import com.common.DEV_STATUS;
import com.common.LOG_OUTPUT_LEVEL;
import com.common.LOG_OUTPUT_PORT;
import com.common.SPCD_INFO;
import com.common.SPCD_STATUS;
import com.common.SP_BATTERY_INFO;
import com.common.SP_BATTERY_STATUS;
import com.common.SP_BATT_ATTRIBUTE;
import com.common.SP_BATT_CUR_DATA;
import com.common.SP_BATT_NAME;
import com.common.SP_BATT_USAGE_INFO;
import com.common.SP_DEV_LEAPLINK_INFO;
import com.common.SP_GPS_INFO;
import com.common.SP_IMU_DATA;
import com.common.SP_REQUEST_REL;
import com.common.VIDEO_PARAM;
import com.jnilib.CppSDKConnectors;
import com.misc.C1514util;

/* loaded from: classes.dex */
public class SPM_Device {
    private SPM_Camera mCamera;
    private SPCD_INFO mDeviceInfo;
    private SPCD_STATUS mDeviceStatus;
    private SPCD_Gimbal mGimbal;
    private SPM_Vehicle mSPM_Vehicle;
    private SP_BATTERY_STATUS mSP_BATTERY_STATUS = new SP_BATTERY_STATUS();
    private SP_REQUEST_REL mDevGetUidRel = new SP_REQUEST_REL();
    private byte[] mDevGetUidBuff = new byte[2];
    private SP_REQUEST_REL mGetAcCodeRel = new SP_REQUEST_REL();
    private SP_REQUEST_REL mRequsetSnNum = new SP_REQUEST_REL();
    private byte[] mSnNumBuff = new byte[32];
    private byte[] mGetInfoBuff = new byte[128];
    private byte[] mGetInfoRelBuf = new byte[3];
    private byte[] mStatusInfoRelBuff = new byte[3];
    private byte[] mStatusInfoBuff = new byte[128];
    private SP_GPS_INFO gps_info = new SP_GPS_INFO();
    private byte[] satellite = new byte[2];
    private double[] gpsData = new double[2];
    private float[] floatArr = new float[2];
    private SP_IMU_DATA mSP_IMU_DATA = new SP_IMU_DATA();
    private byte[] mImuType = new byte[1];
    private float[] mImuData = new float[7];
    private byte[] mAttributeBuff = new byte[128];
    byte[] mBattAttributeRelBuff = new byte[3];
    byte[] mBattCurDataBuff = new byte[128];
    byte[] mBattNameBuff = new byte[128];
    private byte[] mUsageInfoBuff = new byte[128];
    private byte[] videoMode = new byte[1];
    private short[] videoDpiLength = new short[1];
    private short[] videoDpiHeight = new short[1];
    private byte[] videoDpiFps = new byte[1];
    private VIDEO_PARAM mVIDEO_PARAM = new VIDEO_PARAM();
    private byte[] mCmaAttributeBuff = new byte[20];
    byte[] mLeaplinkInfoBuff = new byte[10];

    public SPM_Camera GetCam() {
        if (this.mCamera == null) {
            this.mCamera = new SPM_Camera();
        }
        return this.mCamera;
    }

    public SPCD_Gimbal GetGimbal() {
        if (this.mGimbal == null) {
            this.mGimbal = new SPCD_Gimbal();
        }
        return this.mGimbal;
    }

    public SPM_Vehicle GetVehicle() {
        if (this.mSPM_Vehicle == null) {
            this.mSPM_Vehicle = new SPM_Vehicle();
        }
        return this.mSPM_Vehicle;
    }

    public SP_BATTERY_INFO GetBatteryInfo() {
        return new SP_BATTERY_INFO();
    }

    public SP_BATTERY_INFO GetBatteryInfo(byte b) {
        return new SP_BATTERY_INFO();
    }

    public SP_BATTERY_STATUS GetBatteryStatus() {
        byte[] bArr = new byte[2];
        CppSDKConnectors.DevGetBatteryStatus(bArr);
        this.mSP_BATTERY_STATUS.fill(bArr, 0);
        return this.mSP_BATTERY_STATUS;
    }

    public void GetLeaplinkInfo(SP_DEV_LEAPLINK_INFO sp_dev_leaplink_info) {
        if (sp_dev_leaplink_info == null) {
            return;
        }
        CppSDKConnectors.GetDevLeaplinkInfo(this.mLeaplinkInfoBuff);
        sp_dev_leaplink_info.fill(this.mLeaplinkInfoBuff);
    }

    public SP_BATTERY_STATUS GetBatteryStatus(byte b) {
        return this.mSP_BATTERY_STATUS;
    }

    public byte GetDevStatus() {
        return CppSDKConnectors.GetDevStatus();
    }

    public int RequestUid() {
        return CppSDKConnectors.DevRequestUid();
    }

    public SP_REQUEST_REL GetUid(byte[] bArr) {
        CppSDKConnectors.DevGetUid(bArr, this.mDevGetUidBuff);
        this.mDevGetUidRel.fill(this.mDevGetUidBuff);
        return this.mDevGetUidRel;
    }

    public int ChangeUid(byte[] bArr, byte[] bArr2) {
        return CppSDKConnectors.DevChangeUid(bArr, C1514util.bytesPatch(bArr2, 32));
    }

    public int GetUidChangeRel() {
        return CppSDKConnectors.DevGetUidChangeRel();
    }

    public int RequestAcCode(byte[] bArr) {
        return CppSDKConnectors.DevRequestAcCode(bArr);
    }

    public SP_REQUEST_REL GetAcCodeRel(byte[] bArr) {
        CppSDKConnectors.DevGetAcCodeRel(bArr, this.mGetAcCodeRel.getBuff());
        SP_REQUEST_REL sp_request_rel = this.mGetAcCodeRel;
        sp_request_rel.fill(sp_request_rel.getBuff());
        return this.mGetAcCodeRel;
    }

    public int ChangeAcCode(byte[] bArr, byte[] bArr2) {
        return CppSDKConnectors.DevChangeAcCode(bArr, bArr2);
    }

    public int GetChangeAcCodeRel() {
        return CppSDKConnectors.DevGetChangeAcCodeRel();
    }

    public int RequsetSn() {
        return CppSDKConnectors.DevRequsetSn();
    }

    public SP_REQUEST_REL GetRequsetSnNum(byte[] bArr) {
        CppSDKConnectors.DevGetRequsetSnNum(this.mSnNumBuff, this.mRequsetSnNum.getBuff());
        SP_REQUEST_REL sp_request_rel = this.mRequsetSnNum;
        sp_request_rel.fill(sp_request_rel.getBuff());
        byte[] validBytes = C1514util.getValidBytes(this.mSnNumBuff);
        int length = bArr.length < validBytes.length ? bArr.length : validBytes.length;
        this.mRequsetSnNum.REL_LEN = (byte) (length & 255);
        for (int i = 0; i < length; i++) {
            bArr[i] = validBytes[i];
        }
        return this.mRequsetSnNum;
    }

    public int EraseUid(byte[] bArr) {
        return CppSDKConnectors.DevEraseUid(bArr);
    }

    public int GetEraseUidRel() {
        return CppSDKConnectors.DevGetEraseUidRel();
    }

    public int EraseAcCode(byte[] bArr) {
        return CppSDKConnectors.DevEraseAcCode(bArr);
    }

    public int GetEraseAcCodeRel() {
        return CppSDKConnectors.DevGetEraseAcCodeRel();
    }

    public int RequestUidVerify(byte[] bArr) {
        return CppSDKConnectors.DevRequestUidVerify(bArr);
    }

    public int GetUidVerifyRel() {
        return CppSDKConnectors.DevGetUidVerifyRel();
    }

    public int RequestAcVerify(byte[] bArr) {
        return CppSDKConnectors.DevRequestAcVerify(bArr);
    }

    public int GetAcVerifyRel() {
        return CppSDKConnectors.DevGetAcVerifyRel();
    }

    public int RequestInfo() {
        return CppSDKConnectors.DevRequestInfo();
    }

    public int GetInfoRel(SPCD_INFO spcd_info, SP_REQUEST_REL sp_request_rel) {
        int DevGetInfoRel = CppSDKConnectors.DevGetInfoRel(this.mGetInfoBuff, this.mGetInfoRelBuf);
        if (DevGetInfoRel != 0) {
            return DevGetInfoRel;
        }
        sp_request_rel.fill(this.mGetInfoRelBuf);
        if (sp_request_rel.ERR_CODE != 0) {
            return sp_request_rel.ERR_CODE;
        }
        spcd_info.fill(this.mGetInfoBuff, 0, sp_request_rel.REL_VER);
        return DevGetInfoRel;
    }

    public int RequestStatusInfo() {
        return CppSDKConnectors.DevRequestStatusInfo();
    }

    public int GetStatusInfoRel(DEV_STATUS dev_status, SP_REQUEST_REL sp_request_rel) {
        int DevGetStatusInfoRel = CppSDKConnectors.DevGetStatusInfoRel(this.mStatusInfoBuff, this.mStatusInfoRelBuff);
        dev_status.fill(this.mStatusInfoBuff, 0);
        sp_request_rel.fill(this.mStatusInfoRelBuff);
        return DevGetStatusInfoRel;
    }

    public int RfDisconnect() {
        return CppSDKConnectors.DevRfDisconnect();
    }

    public SP_GPS_INFO GetGpsInfo() {
        if (CppSDKConnectors.DevGetGpsInfo(this.satellite, this.gpsData, this.floatArr) == 0) {
            this.gps_info.fill(this.satellite, this.gpsData, this.floatArr);
        }
        return this.gps_info;
    }

    public SP_IMU_DATA GetIMUState() {
        CppSDKConnectors.GetDevIMUState(this.mImuType, this.mImuData);
        this.mSP_IMU_DATA.fill(this.mImuType[0], this.mImuData);
        return this.mSP_IMU_DATA;
    }

    public int SendLogConfigCmd(LOG_OUTPUT_PORT log_output_port, LOG_OUTPUT_LEVEL log_output_level) {
        return CppSDKConnectors.DevSendLogConfigCmd((byte) (log_output_port.value() & 255), (byte) (log_output_level.value() & 255));
    }

    public int RcLogDump(byte[] bArr) {
        return CppSDKConnectors.DevLogDump(bArr);
    }

    public int RequsetBattAttribute() {
        return CppSDKConnectors.DevRequsetBattAttribute();
    }

    public int RequsetBattCurData() {
        return CppSDKConnectors.DevRequsetBattCurData();
    }

    public int RequsetBattName() {
        return CppSDKConnectors.DevRequsetBattName();
    }

    public int RequsetUsageInfo() {
        return CppSDKConnectors.DevRequsetBattUsageInfo();
    }

    public void GetBattAttribute(SP_BATT_ATTRIBUTE sp_batt_attribute, SP_REQUEST_REL sp_request_rel) {
        CppSDKConnectors.DevGetBattAttribute(this.mAttributeBuff, this.mBattAttributeRelBuff);
        sp_batt_attribute.fill(this.mAttributeBuff, 0);
        sp_request_rel.fill(this.mBattAttributeRelBuff);
    }

    public void GetBattCurData(SP_BATT_CUR_DATA sp_batt_cur_data, SP_REQUEST_REL sp_request_rel) {
        if (sp_request_rel == null || sp_batt_cur_data == null) {
            return;
        }
        CppSDKConnectors.DevGetBattCurData(this.mBattCurDataBuff, sp_request_rel.getBuff());
        sp_batt_cur_data.fill(this.mBattCurDataBuff, 0);
        sp_request_rel.fill(sp_request_rel.getBuff());
    }

    public void GetBattName(SP_BATT_NAME sp_batt_name, SP_REQUEST_REL sp_request_rel) {
        CppSDKConnectors.DevGetBattName(this.mBattNameBuff, sp_request_rel.getBuff());
        sp_batt_name.fill(this.mBattNameBuff, 0);
        sp_request_rel.fill(sp_request_rel.getBuff());
    }

    public void GetUsageInfo(SP_BATT_USAGE_INFO sp_batt_usage_info, SP_REQUEST_REL sp_request_rel) {
        CppSDKConnectors.DevGetUsageInfo(this.mUsageInfoBuff, sp_request_rel.getBuff());
        sp_batt_usage_info.fill(this.mUsageInfoBuff, 0);
        sp_request_rel.fill(sp_request_rel.getBuff());
    }

    public VIDEO_PARAM GetVideoParam() {
        CppSDKConnectors.getVideoParam(this.videoMode, this.videoDpiLength, this.videoDpiHeight, this.videoDpiFps);
        this.mVIDEO_PARAM.fill(this.videoMode[0], this.videoDpiLength[0], this.videoDpiHeight[0], this.videoDpiFps[0]);
        return this.mVIDEO_PARAM;
    }

    public int setCamAttribute(CAM_ATTRIBUTE cam_attribute) {
        if (cam_attribute == null) {
            return -1;
        }
        return CppSDKConnectors.setCamAttribute(CAM_ATTRIBUTE.getBytes(cam_attribute));
    }

    public int setCamAttributeRel(SP_REQUEST_REL sp_request_rel) {
        int camAttributeRel = CppSDKConnectors.setCamAttributeRel(sp_request_rel.getBuff());
        sp_request_rel.fill(sp_request_rel.getBuff());
        return camAttributeRel;
    }

    public int rqusetCamAttribute(int i) {
        return CppSDKConnectors.rqusetCamAttribute(i);
    }

    public int getReqCmaAttributeRel(CAM_ATTRIBUTE cam_attribute, SP_REQUEST_REL sp_request_rel) {
        int reqCmaAttributeRel = CppSDKConnectors.getReqCmaAttributeRel(this.mCmaAttributeBuff, sp_request_rel.getBuff());
        sp_request_rel.fill(sp_request_rel.getBuff());
        if (sp_request_rel.ERR_CODE == 0) {
            cam_attribute.fill(this.mCmaAttributeBuff);
            return reqCmaAttributeRel;
        }
        return -1;
    }

    public int getCruiseControlVal() {
        return CppSDKConnectors.getCruiseControlVal();
    }
}
