package com.senseplay.sdk.cache;

import com.adapt.SPM_Device;
import com.adapt.SPM_Manager;
import com.adapt.SPM_Rc;
import com.common.SP_DEV_LEAPLINK_INFO;
import com.common.SP_RC_LEAPLINK_INFO;
import com.senseplay.sdk.log.SPDebug;
import com.senseplay.sdk.model.device.DeviceData;
import com.senseplay.sdk.model.device.LinkInfo;

/* loaded from: classes2.dex */
public class DeviceLink extends Thread {
    private static boolean isRcLinkDev = false;
    private LinkListener linkListener;
    private boolean working = true;
    private LinkInfo linkInfo = new LinkInfo();
    private SPM_Rc spm_rc = SPM_Manager.GetInstance().GetRc();
    private SPM_Device spm_device = SPM_Manager.GetInstance().GetDevice();

    /* loaded from: classes2.dex */
    public interface LinkListener {
        void linkInfo(LinkInfo linkInfo);
    }

    public DeviceLink() {
        setName("DeviceLink");
    }

    public void setListener(LinkListener linkListener) {
        this.linkListener = linkListener;
    }

    public void startLink() {
        this.working = true;
        if (this.linkInfo == null) {
            this.linkInfo = new LinkInfo();
        }
        this.linkInfo.setLinked(false);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        SP_RC_LEAPLINK_INFO sp_rc_leaplink_info = new SP_RC_LEAPLINK_INFO();
        SP_DEV_LEAPLINK_INFO sp_dev_leaplink_info = new SP_DEV_LEAPLINK_INFO();
        while (this.working) {
            try {
                sleep(200L);
                this.spm_rc.GetLeaplinkInfo(sp_rc_leaplink_info);
                this.spm_device.GetLeaplinkInfo(sp_dev_leaplink_info);
                DeviceData.toLinkInfo(this.linkInfo, sp_rc_leaplink_info, sp_dev_leaplink_info);
                if (this.linkInfo != null) {
                    isRcLinkDev = this.linkInfo.isLinked();
                }
                if (this.linkListener != null) {
                    this.linkListener.linkInfo(this.linkInfo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isNotRcLinkDev() {
        return !isRcLinkDev();
    }

    public static boolean isRcLinkDev() {
        SPDebug.m5816d("isRcLinkDev: " + isRcLinkDev);
        return isRcLinkDev;
    }

    public static void clearRcLinkDev() {
        isRcLinkDev = false;
    }

    public void realse() {
        this.linkInfo = null;
        this.working = false;
        isRcLinkDev = false;
    }
}
