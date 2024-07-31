package com.senseplay.sdk;

import android.util.Log;
import com.adapt.SPM_Manager;
import com.adapt.SPM_Rc;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.cache.DeviceLink;
import com.senseplay.sdk.cache.DeviceSearch;
import com.senseplay.sdk.cache.DeviceSearchListener;
import com.senseplay.sdk.cache.LinkFlag;
import com.senseplay.sdk.log.SPDebug;
import com.senseplay.sdk.model.device.DeviceInfo;
import com.senseplay.sdk.model.device.LinkInfo;
import com.senseplay.sdk.tool.HandlerPost;
import com.senseplay.sdk.tool.Hex16;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public class SPSearch {
    private static SPSearch spLink;
    private MCallBack<Boolean> devLinkCB;
    private DeviceSearch deviceSearch;
    private MCallBack<Boolean> directLinkCb;
    private MCallBack<LinkInfo> linkCallBack;
    private DeviceSearchListener searchListener;
    private Timer timer;
    private boolean isChange = false;
    private boolean lastLink = false;
    private int count = 0;
    private final int READ_TIME = 1000;
    private final int MAX_READ_TIME = 35000;
    private int search_time = 0;
    private int link_time = 0;
    private TimerTask timerTask = new TimerTask() { // from class: com.senseplay.sdk.SPSearch.4
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            SPSearch.this.search_time += 1000;
            SPSearch.this.link_time += 1000;
            if (SPSearch.this.search_time >= 35000) {
                SPSearch.this.searchPost(null, true);
            }
            if (SPSearch.this.link_time < 35000 || SPSearch.this.devLinkCB == null) {
                return;
            }
            HandlerPost.post(SPSearch.this.devLinkCB, false);
            SPSearch.this.devLinkCB = null;
        }
    };
    private SPM_Rc spm_rc = SPM_Manager.GetInstance().GetRc();
    private DeviceLink deviceLink = new DeviceLink();

    public static SPSearch getInstance() {
        if (spLink == null) {
            synchronized (SPSearch.class) {
                if (spLink == null) {
                    spLink = new SPSearch();
                }
            }
        }
        return spLink;
    }

    private SPSearch() {
        this.deviceLink.setListener(new DeviceLink.LinkListener() { // from class: com.senseplay.sdk.SPSearch.1
            @Override // com.senseplay.sdk.cache.DeviceLink.LinkListener
            public void linkInfo(LinkInfo linkInfo) {
                if (SPSearch.this.devLinkCB != null && linkInfo != null && linkInfo.isLinked()) {
                    LinkFlag.flag = true;
                    HandlerPost.post(SPSearch.this.devLinkCB, true);
                    SPSearch.this.devLinkCB = null;
                }
                if (SPSearch.this.linkCallBack != null) {
                    HandlerPost.post(SPSearch.this.linkCallBack, linkInfo);
                }
                SPSearch.this.linkInfoChg(linkInfo);
            }
        });
        this.deviceLink.startLink();
        this.deviceLink.start();
    }

    public void deviceSearch(DeviceSearchListener deviceSearchListener) {
        this.searchListener = deviceSearchListener;
        this.search_time = 0;
        LinkFlag.flag = false;
        startTimer();
        DeviceSearch deviceSearch = this.deviceSearch;
        if (deviceSearch == null) {
            this.deviceSearch = new DeviceSearch();
            this.deviceSearch.startSearch();
            this.deviceSearch.setListener(new DeviceSearch.SearchListener() { // from class: com.senseplay.sdk.SPSearch.2
                @Override // com.senseplay.sdk.cache.DeviceSearch.SearchListener
                public void search(DeviceInfo deviceInfo) {
                    SPSearch.this.searchPost(deviceInfo, false);
                }

                @Override // com.senseplay.sdk.cache.DeviceSearch.SearchListener
                public void finish() {
                    LinkFlag.flag = true;
                    SPSearch.this.deviceSearch = null;
                    SPSearch.this.searchPost(null, true);
                }
            });
            this.deviceSearch.start();
            return;
        }
        deviceSearch.startSearch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchPost(final DeviceInfo deviceInfo, final boolean z) {
        if (SPManager.getInstance().getHandler() == null || this.searchListener == null) {
            return;
        }
        SPManager.getInstance().getHandler().post(new Runnable() { // from class: com.senseplay.sdk.SPSearch.3
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    SPSearch.this.searchListener.finish();
                    SPSearch.this.searchListener = null;
                    return;
                }
                SPSearch.this.searchListener.search(deviceInfo);
            }
        });
    }

    public void deviceLink(String str, String str2, MCallBack<Boolean> mCallBack) {
        this.devLinkCB = mCallBack;
        this.link_time = 0;
        SPDebug.m5816d("deviceLink linkId:" + str + " deviceSn:" + str2);
        try {
            this.spm_rc.DeviceLink(Hex16.decodeHex(str.toCharArray()));
            SPDevice.curSn = str2;
        } catch (Exception e) {
            e.printStackTrace();
            mCallBack.onResult(false);
        }
    }

    public void getLinkInfo(MCallBack<LinkInfo> mCallBack) {
        this.linkCallBack = mCallBack;
    }

    public void directLinkState(MCallBack<Boolean> mCallBack) {
        this.directLinkCb = mCallBack;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void linkInfoChg(LinkInfo linkInfo) {
        if (this.directLinkCb == null || linkInfo == null || !LinkFlag.flag || LinkFlag.isOta) {
            return;
        }
        boolean isLinked = linkInfo.isLinked();
        Log.w("isLink", "isLink: " + isLinked);
        if (isLinked) {
            if (isLinked) {
                this.count++;
            }
            if (this.count == 5) {
                this.lastLink = true;
                this.isChange = true;
            }
        } else {
            this.count = 0;
            if (this.lastLink) {
                this.isChange = true;
            }
            this.lastLink = false;
        }
        if (this.isChange) {
            this.isChange = false;
            Log.w("isChange", "isLink: " + isLinked);
            HandlerPost.post(this.directLinkCb, Boolean.valueOf(isLinked));
        }
    }

    private void startTimer() {
        if (this.timer == null) {
            this.timer = new Timer();
            this.timer.schedule(this.timerTask, 1000L, 1000L);
        }
    }

    private void stopTimer() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }

    public void release() {
        spLink = null;
        DeviceLink deviceLink = this.deviceLink;
        if (deviceLink != null) {
            deviceLink.realse();
            this.deviceLink = null;
        }
        DeviceSearch deviceSearch = this.deviceSearch;
        if (deviceSearch != null) {
            deviceSearch.realse();
            this.deviceSearch = null;
        }
        stopTimer();
    }
}
