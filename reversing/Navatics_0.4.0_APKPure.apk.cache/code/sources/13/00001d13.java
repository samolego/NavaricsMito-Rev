package com.senseplay.mframe.ota;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/* loaded from: classes2.dex */
public class OtaReceiver extends BroadcastReceiver {
    private static OtaListener otaListener;

    public static void setOtaListener(OtaListener otaListener2) {
        otaListener = otaListener2;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        long longExtra = intent.getLongExtra("extra_download_id", -1L);
        Toast.makeText(context, "任务:" + longExtra + " 下载完成!", 1).show();
        OtaListener otaListener2 = otaListener;
        if (otaListener2 != null) {
            otaListener2.onDownFinish(longExtra);
        }
    }
}