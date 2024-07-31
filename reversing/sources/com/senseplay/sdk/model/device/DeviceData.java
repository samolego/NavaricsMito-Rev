package com.senseplay.sdk.model.device;

import android.util.Log;
import com.common.SPCD_INFO;
import com.common.SPRC_INFO;
import com.common.SP_DEV_LEAPLINK_INFO;
import com.common.SP_RC_LEAPLINK_INFO;
import com.common.SP_REQUEST_REL;
import com.senseplay.sdk.SPUsb;
import com.senseplay.sdk.tool.SPUtilTool;

/* loaded from: classes2.dex */
public class DeviceData {
    public static final int type_login_sec = 12;
    public static final int type_no_device = -1;
    public static final int type_no_uid = 5;

    public static void toLinkInfo(LinkInfo linkInfo, SP_RC_LEAPLINK_INFO sp_rc_leaplink_info, SP_DEV_LEAPLINK_INFO sp_dev_leaplink_info) {
        if (sp_rc_leaplink_info == null) {
            return;
        }
        linkInfo.setLinked(sp_rc_leaplink_info.Linked && SPUsb.isUsbIsReady());
        linkInfo.setSnr(sp_rc_leaplink_info.Snr);
        linkInfo.setRc_rssi0(sp_rc_leaplink_info.Ch0_Rssi);
        linkInfo.setRc_rssi1(sp_rc_leaplink_info.Ch1_Rssi);
        if (sp_dev_leaplink_info == null) {
            return;
        }
        linkInfo.setDev_snr0(sp_dev_leaplink_info.CH0_SNR);
        linkInfo.setDev_snr1(sp_dev_leaplink_info.CH1_SNR);
        linkInfo.setDev_rssi0(sp_dev_leaplink_info.CH0_RSSI);
        linkInfo.setDev_rssi1(sp_dev_leaplink_info.CH1_RSSI);
    }

    public static DeviceInfo toDeviceInfo(String str, SPCD_INFO spcd_info) {
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setLinkID(str);
        deviceInfo.setCategory(spcd_info.Category.toString());
        deviceInfo.setManufacturerID(spcd_info.ManufacturerID);
        deviceInfo.setModelID(spcd_info.ModelID);
        deviceInfo.setSerialNo(SPUtilTool.asciiToString(spcd_info.SerialNo));
        deviceInfo.setManufactureDate(((int) spcd_info.ManufactureDate.Year) + "-" + ((int) spcd_info.ManufactureDate.Month) + "-" + ((int) spcd_info.ManufactureDate.Day));
        deviceInfo.setFirmwareVersion(spcd_info.FirmwareVersion);
        deviceInfo.setHardwareVersion(spcd_info.HardwareVersion);
        deviceInfo.setHardwareVersionStr(spcd_info.HardwareVersionStr);
        deviceInfo.setFirmwareVersionStr(spcd_info.FirmwareVersionStr);
        return deviceInfo;
    }

    public static DeviceInfo toDeviceInfo(SPCD_INFO spcd_info, SP_REQUEST_REL sp_request_rel) {
        if (sp_request_rel == null || sp_request_rel.ERR_CODE != 0) {
            Log.e("toDeviceInfo", "ERR_CODE: " + ((int) sp_request_rel.ERR_CODE));
            return null;
        }
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setCategory(spcd_info.Category.toString());
        deviceInfo.setManufacturerID(spcd_info.ManufacturerID);
        deviceInfo.setModelID(spcd_info.ModelID);
        deviceInfo.setSerialNo(SPUtilTool.asciiToString(spcd_info.SerialNo));
        deviceInfo.setManufactureDate(((int) spcd_info.ManufactureDate.Year) + "-" + ((int) spcd_info.ManufactureDate.Month) + "-" + ((int) spcd_info.ManufactureDate.Day));
        deviceInfo.setFirmwareVersion(spcd_info.FirmwareVersion);
        deviceInfo.setHardwareVersion(spcd_info.HardwareVersion);
        deviceInfo.setHardwareVersionStr(spcd_info.HardwareVersionStr);
        deviceInfo.setFirmwareVersionStr(spcd_info.FirmwareVersionStr);
        deviceInfo.setVersion(spcd_info.Version);
        Log.d("toRcInfo", "dev sn:" + deviceInfo.getSerialNo());
        return deviceInfo;
    }

    public static DeviceInfo toRcInfo(SPRC_INFO sprc_info, SP_REQUEST_REL sp_request_rel) {
        if (sp_request_rel == null || sp_request_rel.ERR_CODE != 0) {
            return null;
        }
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setCategory(sprc_info.Category.toString());
        deviceInfo.setManufacturerID(sprc_info.ManufacturerID);
        deviceInfo.setModelID(sprc_info.ModelID);
        deviceInfo.setSerialNo(SPUtilTool.asciiToString(sprc_info.SerialNo));
        Log.d("toRcInfo", "rc sn:" + deviceInfo.getSerialNo());
        deviceInfo.setManufactureDate(((int) sprc_info.ManufactureDate.Year) + "-" + ((int) sprc_info.ManufactureDate.Month) + "-" + ((int) sprc_info.ManufactureDate.Day));
        deviceInfo.setHardwareVersion(sprc_info.HardwareVersion);
        deviceInfo.setFirmwareVersion(sprc_info.FirmwareVersion);
        deviceInfo.setHardwareVersionStr(sprc_info.HardwareVersionStr);
        deviceInfo.setFirmwareVersionStr(sprc_info.FirmwareVersionStr);
        deviceInfo.setVersion(sprc_info.Version);
        return deviceInfo;
    }
}
