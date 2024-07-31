package com.senseplay.sdk.cache;

import android.util.Log;
import com.adapt.SPM_Manager;
import com.adapt.SPM_Rc;
import com.common.RC_MODE;
import com.common.SPCD_INFO;
import com.senseplay.sdk.log.SPDebug;
import com.senseplay.sdk.model.device.DeviceData;
import com.senseplay.sdk.model.device.DeviceInfo;
import com.senseplay.sdk.tool.Hex16;
import com.senseplay.sdk.tool.SPUtilTool;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceSearch extends Thread {
    private SearchListener searchListener;
    private List<String> idList = new ArrayList();
    private boolean working = true;
    private SPM_Rc spm_rc = SPM_Manager.GetInstance().GetRc();

    /* loaded from: classes2.dex */
    public interface SearchListener {
        void finish();

        void search(DeviceInfo deviceInfo);
    }

    public void setListener(SearchListener searchListener) {
        this.searchListener = searchListener;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        SPCD_INFO spcd_info = new SPCD_INFO();
        byte[] bArr = new byte[5];
        while (this.working) {
            try {
                if (RC_MODE.RC_SEARCH_TIMEOUT == this.spm_rc.GetRCMode()) {
                    if (this.searchListener != null) {
                        this.searchListener.finish();
                    }
                    Log.w("search", "RC_SEARCH_TIMEOUT");
                    realse();
                    return;
                }
                if (this.spm_rc.GetSearchRel(bArr, spcd_info) == 0) {
                    String encodeHexStr = Hex16.encodeHexStr(bArr);
                    String asciiToString = SPUtilTool.asciiToString(spcd_info.SerialNo);
                    Log.w("search", "search id: " + encodeHexStr + " sn: " + asciiToString);
                    if (!SPUtilTool.isNull(encodeHexStr) && this.idList != null && !this.idList.contains(encodeHexStr)) {
                        this.idList.add(encodeHexStr);
                        if (this.searchListener != null) {
                            this.searchListener.search(DeviceData.toDeviceInfo(encodeHexStr, spcd_info));
                        }
                    }
                }
                sleep(10L);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public void startSearch() {
        this.working = true;
        List<String> list = this.idList;
        if (list != null) {
            list.clear();
        } else {
            this.idList = new ArrayList();
        }
        SPDebug.m5816d("search device cmd");
        this.spm_rc.DeviceSearch();
    }

    public void realse() {
        this.working = false;
        List<String> list = this.idList;
        if (list != null) {
            list.clear();
            this.idList = null;
        }
    }
}
