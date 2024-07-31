package com.senseplay.sdk.tool;

import android.util.Log;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.SPManager;

/* loaded from: classes2.dex */
public class HandlerPost {
    public static <T> void post(final MCallBack<T> mCallBack, final T t) {
        if (SPManager.getInstance().getHandler() == null || mCallBack == null) {
            Log.e("HandlerPost", "handler not init or callback is null");
        } else {
            SPManager.getInstance().getHandler().post(new Runnable() { // from class: com.senseplay.sdk.tool.HandlerPost.1
                @Override // java.lang.Runnable
                public void run() {
                    MCallBack.this.onResult(t);
                }
            });
        }
    }

    public static <T> void postDelayed(final MCallBack<T> mCallBack, final T t, int i) {
        if (SPManager.getInstance().getHandler() == null || mCallBack == null) {
            Log.e("HandlerPost", "handler not init or callback is null");
        } else {
            SPManager.getInstance().getHandler().postDelayed(new Runnable() { // from class: com.senseplay.sdk.tool.HandlerPost.2
                @Override // java.lang.Runnable
                public void run() {
                    MCallBack.this.onResult(t);
                }
            }, i);
        }
    }
}
