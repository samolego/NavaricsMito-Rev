package com.navatics.xlog;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import com.navatics.xlog.WLog;

/* loaded from: classes2.dex */
public class DefaultLogger implements WLog.LogImp {
    public static Context toastSupportContext;
    private Handler handler = new Handler(Looper.getMainLooper());

    @Override // com.navatics.xlog.WLog.LogImp
    public void appenderClose() {
    }

    @Override // com.navatics.xlog.WLog.LogImp
    public void appenderFlush(boolean z) {
    }

    @Override // com.navatics.xlog.WLog.LogImp
    public void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        if (WLog.getLogLevel() <= 0) {
            Log.v(str, str4);
        }
    }

    @Override // com.navatics.xlog.WLog.LogImp
    public void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        if (WLog.getLogLevel() <= 2) {
            Log.i(str, str4);
        }
    }

    @Override // com.navatics.xlog.WLog.LogImp
    public void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        if (WLog.getLogLevel() <= 1) {
            Log.d(str, str4);
        }
    }

    @Override // com.navatics.xlog.WLog.LogImp
    public void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        if (WLog.getLogLevel() <= 3) {
            Log.w(str, str4);
        }
    }

    @Override // com.navatics.xlog.WLog.LogImp
    public void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        if (WLog.getLogLevel() <= 4) {
            Log.e(str, str4);
        }
    }

    @Override // com.navatics.xlog.WLog.LogImp
    public void logF(String str, String str2, String str3, int i, int i2, long j, long j2, final String str4) {
        if (WLog.getLogLevel() > 5) {
            return;
        }
        Log.e(str, str4);
        if (toastSupportContext != null) {
            this.handler.post(new Runnable() { // from class: com.navatics.xlog.DefaultLogger.1
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(DefaultLogger.toastSupportContext, str4, 1).show();
                }
            });
        }
    }

    @Override // com.navatics.xlog.WLog.LogImp
    public int getLogLevel() {
        return WLog.getLogLevel();
    }
}
