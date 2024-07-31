package com.senseplay.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import com.senseplay.sdk.log.SPDebug;

/* loaded from: classes2.dex */
public class SPManager {
    private static String clientId = "";
    private static String clientSecret = "";
    private static Context mContext;
    private static SPManager spManager;
    private Handler mHandler;
    private final String tag = "SPManager";

    public static SPManager getInstance() {
        if (spManager == null) {
            synchronized (SPManager.class) {
                if (spManager == null) {
                    spManager = new SPManager();
                }
            }
        }
        return spManager;
    }

    public static Context getContent() {
        if (mContext == null) {
            Log.e("Connect", "Connect is null");
        }
        return mContext;
    }

    public Handler getHandler() {
        Context context = mContext;
        if (context != null) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(context.getMainLooper());
            }
        } else {
            Log.e("SPManager", "Connect is null");
        }
        return this.mHandler;
    }

    public void init(Context context) {
        mContext = context;
        this.mHandler = new Handler(mContext.getMainLooper());
    }

    public void setClient(String str, String str2) {
        SPDebug.m5815d("client_id", str);
        SPDebug.m5815d("client_secret", str2);
        clientId = str;
        clientSecret = str2;
    }

    public static String getClientId() {
        return clientId;
    }

    public static String getClientSecret() {
        return clientSecret;
    }

    public static void exit() {
        Process.killProcess(Process.myPid());
    }
}
