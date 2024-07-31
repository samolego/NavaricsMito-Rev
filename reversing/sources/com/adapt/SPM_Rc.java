package com.adapt;

import com.common.LOG_OUTPUT_LEVEL;
import com.common.LOG_OUTPUT_PORT;
import com.common.RC_MODE;
import com.common.SPCD_INFO;
import com.common.SPRC_INFO;
import com.common.SP_BATTERY_INFO;
import com.common.SP_BATTERY_STATUS;
import com.common.SP_GPS_INFO;
import com.common.SP_RC_LEAPLINK_INFO;
import com.common.SP_REQUEST_REL;
import com.common.VIBRATION_DATA;
import com.jnilib.CppSDKConnectors;
import com.misc.C1514util;

/* loaded from: classes.dex */
public class SPM_Rc {
    private byte[] mLeaplinkInfoBuff = new byte[10];
    private byte[] mSearchDevInfoBuff = new byte[128];
    private byte[] mSearchDevIDBuff = new byte[5];
    private byte[] DevSearchVerBuff = new byte[1];
    private byte[] mSnBuff = new byte[32];
    byte[] mGetInfoBuff = new byte[128];
    private byte[] mBatteryBuff = new byte[2];
    private byte[] satellite = new byte[2];
    private double[] gpsData = new double[2];
    private float[] floatArr = new float[2];

    /* loaded from: classes.dex */
    public class VIBRATION_MODE {
        public static final byte CYCLE_MODE = 48;
        public static final byte MAX_VOLUME = 15;
        public static final byte MUTE = 0;
        public static final byte OFF = 0;
        public static final byte PLAY_ONCE = 16;

        public VIBRATION_MODE() {
        }
    }

    public SP_BATTERY_INFO GetBatteryInfo() {
        return new SP_BATTERY_INFO();
    }

    public SP_BATTERY_INFO GetBatteryInfo(byte b) {
        return new SP_BATTERY_INFO();
    }

    public void GetLeaplinkInfo(SP_RC_LEAPLINK_INFO sp_rc_leaplink_info) {
        if (sp_rc_leaplink_info == null) {
            return;
        }
        CppSDKConnectors.GetRcLeaplinkInfo(this.mLeaplinkInfoBuff);
        sp_rc_leaplink_info.fill(this.mLeaplinkInfoBuff);
    }

    public short[] GetRcIMUState() {
        short[] sArr = new short[9];
        CppSDKConnectors.GetRcIMUState(sArr);
        return sArr;
    }

    public int DeviceSearch() {
        return CppSDKConnectors.DeviceSearch();
    }

    public int GetSearchRel(byte[] bArr, SPCD_INFO spcd_info) {
        int GetSearchRel = CppSDKConnectors.GetSearchRel(this.mSearchDevIDBuff, this.mSearchDevInfoBuff, this.DevSearchVerBuff);
        if (GetSearchRel != 0) {
            return GetSearchRel;
        }
        spcd_info.fill(this.mSearchDevInfoBuff, 0, this.DevSearchVerBuff[0]);
        byte[] bArr2 = this.mSearchDevIDBuff;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        return GetSearchRel;
    }

    public int DeviceLink(byte[] bArr) {
        return CppSDKConnectors.DeviceLink(bArr);
    }

    public int EnRfCommunication(boolean z) {
        return CppSDKConnectors.EnRfCommunication(z);
    }

    public boolean GetRcRfStateRel() {
        return CppSDKConnectors.GetRcRfStateRel();
    }

    public int StartSendVibrationPkt(String str) {
        return CppSDKConnectors.StartSendVibrationPkt(str);
    }

    public int GetResidueBytes() {
        return CppSDKConnectors.GetResidueBytes();
    }

    public int RequestUid() {
        return CppSDKConnectors.RcRequestUid();
    }

    public void GetUid(byte[] bArr, SP_REQUEST_REL sp_request_rel) {
        if (bArr == null || sp_request_rel == null) {
            return;
        }
        CppSDKConnectors.RcGetUid(bArr, sp_request_rel.getBuff());
        sp_request_rel.fill(sp_request_rel.getBuff());
    }

    public int ChangeUid(byte[] bArr, byte[] bArr2) {
        return CppSDKConnectors.RcChangeUid(bArr, C1514util.bytesPatch(bArr2, 32));
    }

    public int ChangeUidRel() {
        return CppSDKConnectors.RcChangeUidRel();
    }

    public int EraseUid(byte[] bArr) {
        return CppSDKConnectors.RcEraseUid(bArr);
    }

    public int GetEraseRel() {
        return CppSDKConnectors.RcGetEraseRel();
    }

    public int RequestAcCode() {
        return CppSDKConnectors.RcRequestAcCode();
    }

    public void GetRcGetAcCodeRel(byte[] bArr, SP_REQUEST_REL sp_request_rel) {
        if (bArr == null || sp_request_rel == null) {
            return;
        }
        CppSDKConnectors.RcGetAcCodeRel(bArr, sp_request_rel.getBuff());
        sp_request_rel.fill(sp_request_rel.getBuff());
    }

    public int ChangeAcCode(byte[] bArr, byte[] bArr2) {
        return CppSDKConnectors.RcChangeAcCode(bArr, bArr2);
    }

    public int GetChangeAcCodeRel() {
        return CppSDKConnectors.RcGetChangeAcCodeRel();
    }

    public int RequsetSn() {
        return CppSDKConnectors.RcRequsetSn();
    }

    public void GetSn(byte[] bArr, SP_REQUEST_REL sp_request_rel) {
        if (sp_request_rel == null || bArr == null) {
            return;
        }
        CppSDKConnectors.RcGetSn(this.mSnBuff, sp_request_rel.getBuff());
        sp_request_rel.fill(sp_request_rel.getBuff());
        byte[] validBytes = C1514util.getValidBytes(this.mSnBuff);
        int length = bArr.length < validBytes.length ? bArr.length : validBytes.length;
        sp_request_rel.REL_LEN = (byte) (length & 255);
        System.arraycopy(validBytes, 0, bArr, 0, length);
    }

    public int EraseAcCode(byte[] bArr) {
        return CppSDKConnectors.RcEraseAcCode(bArr);
    }

    public byte GetEraseAcCodeRel() {
        return CppSDKConnectors.RcGetEraseAcCodeRel();
    }

    public int RequestUidVerify(byte[] bArr) {
        return CppSDKConnectors.RcRequestUidVerify(bArr);
    }

    public byte GetUidVerifyRel() {
        return CppSDKConnectors.RcGetUidVerifyRel();
    }

    public int RequestAcVerify(byte[] bArr) {
        return CppSDKConnectors.RcRequestAcVerify(bArr);
    }

    public byte GetAcVerityRel() {
        return CppSDKConnectors.RcGetAcVerifyRel();
    }

    public int RequestInfo() {
        return CppSDKConnectors.RcRequestInfo();
    }

    public int GetInfoRel(SPRC_INFO sprc_info, SP_REQUEST_REL sp_request_rel) {
        if (sprc_info == null || sp_request_rel == null) {
            return -1;
        }
        int RcGetInfoRel = CppSDKConnectors.RcGetInfoRel(this.mGetInfoBuff, sp_request_rel.getBuff());
        if (RcGetInfoRel != 0) {
            return RcGetInfoRel;
        }
        sp_request_rel.fill(sp_request_rel.getBuff());
        if (sp_request_rel.ERR_CODE != 0) {
            return sp_request_rel.ERR_CODE;
        }
        sprc_info.fill(this.mGetInfoBuff, 0, sp_request_rel.REL_VER);
        return RcGetInfoRel;
    }

    public RC_MODE GetRCMode() {
        RC_MODE rc_mode = RC_MODE.RC_ERR;
        switch (CppSDKConnectors.GetRCMode()) {
            case 0:
                return RC_MODE.RC_IDL;
            case 1:
                return RC_MODE.RC_SEARCHING;
            case 2:
                return RC_MODE.RC_SEARCH_TIMEOUT;
            case 3:
                return RC_MODE.RC_LINKING;
            case 4:
                return RC_MODE.RC_LINKED;
            case 5:
                return RC_MODE.RC_LIBK_TIMEOUT;
            default:
                return rc_mode;
        }
    }

    public int SendLogConfigCmd(LOG_OUTPUT_PORT log_output_port, LOG_OUTPUT_LEVEL log_output_level) {
        return CppSDKConnectors.RcSendLogConfigCmd((byte) (log_output_port.value() & 255), (byte) (log_output_level.value() & 255));
    }

    public int RcLogDump(byte[] bArr) {
        return CppSDKConnectors.RcLogDump(bArr);
    }

    public int StartVibration(VIBRATION_DATA vibration_data) {
        if (vibration_data == null) {
            return -1;
        }
        return CppSDKConnectors.RcVibration(vibration_data.getBytes());
    }

    public byte StartVibrationAckRel() {
        return CppSDKConnectors.RcStartVibrationAckRel();
    }

    public void GetBatteryStatus(SP_BATTERY_STATUS sp_battery_status) {
        if (sp_battery_status == null) {
            return;
        }
        CppSDKConnectors.RcGetBatteryStatus(this.mBatteryBuff);
        sp_battery_status.fill(this.mBatteryBuff, 0);
    }

    public void GetGpsInfo(SP_GPS_INFO sp_gps_info) {
        if (sp_gps_info != null && CppSDKConnectors.RcGetGpsInfo(this.satellite, this.gpsData, this.floatArr) == 0) {
            sp_gps_info.fill(this.satellite, this.gpsData, this.floatArr);
        }
    }

    public int GetSwitchWeaponRel() {
        return CppSDKConnectors.RcGetSwitchWeaponRel();
    }

    public int GetFireRel() {
        return CppSDKConnectors.RcGetFireRel();
    }
}
