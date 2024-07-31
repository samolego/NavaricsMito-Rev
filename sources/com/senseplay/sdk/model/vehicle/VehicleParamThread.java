package com.senseplay.sdk.model.vehicle;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.adapt.SPM_Manager;
import com.adapt.SPM_Vehicle;
import com.senseplay.sdk.tool.UTool;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: classes2.dex */
public class VehicleParamThread extends Thread {
    private static final String tag = "VehicleParamThread";
    private String path;
    private VehicleParamListener vpListener;
    private boolean isRun = false;
    private final int type_succ = 1;
    private final int type_fail = 2;
    private Handler handler = new Handler() { // from class: com.senseplay.sdk.model.vehicle.VehicleParamThread.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (VehicleParamThread.this.vpListener == null) {
                return;
            }
            if (message.what == 1) {
                VehicleParamThread.this.vpListener.succ();
            } else if (message.what == 2) {
                VehicleParamThread.this.vpListener.fail();
            }
        }
    };

    /* renamed from: ve */
    private SPM_Vehicle f6837ve = SPM_Manager.GetInstance().GetDevice().GetVehicle();

    /* loaded from: classes2.dex */
    public interface VehicleParamListener {
        void fail();

        void succ();
    }

    public void setListener(String str, VehicleParamListener vehicleParamListener) {
        this.path = str;
        this.vpListener = vehicleParamListener;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        if (this.f6837ve.loadIniConfigFile(this.path) != 0) {
            Log.w(tag, "文件加载失败!");
            this.handler.sendEmptyMessage(2);
            return;
        }
        Log.w(tag, "文件加载完成,准备写入: ");
        this.isRun = true;
        while (this.isRun) {
            byte[] bArr = new byte[512];
            if (-2 == this.f6837ve.sendNextSingleConfigCmd()) {
                this.isRun = false;
                this.f6837ve.saveCfgs();
                this.handler.sendEmptyMessageDelayed(1, 2000L);
                return;
            }
            if (this.f6837ve.getCurConfigData(bArr) == 0) {
                short byteToShort = UTool.byteToShort(bArr);
                byte b = bArr[2];
                int min = (short) Math.min(byteToShort - 3, bArr.length);
                System.arraycopy(bArr, 3, new byte[min], 0, min);
                i = 0;
                i2 = 100;
                i3 = 0;
            } else {
                i = 0;
                i2 = 100;
                i3 = 0;
            }
            while (255 == this.f6837ve.getConfigCmdWriteRel()) {
                try {
                    Thread.sleep(15L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                if (i > i2) {
                    i3++;
                    if (1 == i3) {
                        i2 = 100;
                    } else if (2 == i3) {
                        i2 = 200;
                    } else if (3 == i3) {
                        i2 = IjkMediaCodecInfo.RANK_SECURE;
                    }
                    if (i3 > 3) {
                        this.isRun = false;
                        this.handler.sendEmptyMessage(2);
                        return;
                    }
                    this.f6837ve.sendCurtSingleConfigCmd();
                    if (this.f6837ve.getCurConfigData(bArr) == 0) {
                        short byteToShort2 = UTool.byteToShort(bArr);
                        byte b2 = bArr[2];
                        int min2 = (short) Math.min(byteToShort2 - 3, bArr.length);
                        System.arraycopy(bArr, 3, new byte[min2], 0, min2);
                    }
                    i = 0;
                }
            }
        }
    }

    public void release() {
        this.isRun = false;
    }
}
