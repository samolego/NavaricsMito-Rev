package com.senseplay.sdk.tool;

import android.os.Handler;
import com.senseplay.sdk.config.CacheConfig;

/* loaded from: classes2.dex */
public class HandleOpe {

    /* loaded from: classes2.dex */
    public interface OpeListener {
        void run();
    }

    public static void postDelayed(final OpeListener opeListener) {
        if (opeListener == null) {
            return;
        }
        new Handler().postDelayed(new Runnable() { // from class: com.senseplay.sdk.tool.HandleOpe.1
            @Override // java.lang.Runnable
            public void run() {
                OpeListener.this.run();
            }
        }, 150L);
    }

    public static void postDelayed(final OpeListener opeListener, int i) {
        if (opeListener == null) {
            return;
        }
        if (i < 150) {
            i = CacheConfig.Post_Delayed;
        }
        new Handler().postDelayed(new Runnable() { // from class: com.senseplay.sdk.tool.HandleOpe.2
            @Override // java.lang.Runnable
            public void run() {
                OpeListener.this.run();
            }
        }, i);
    }

    public static void postReadDelayed(final OpeListener opeListener) {
        if (opeListener == null) {
            return;
        }
        new Handler().postDelayed(new Runnable() { // from class: com.senseplay.sdk.tool.HandleOpe.3
            @Override // java.lang.Runnable
            public void run() {
                OpeListener.this.run();
            }
        }, 260L);
    }

    public static void postWriteDelayed(final OpeListener opeListener) {
        if (opeListener == null) {
            return;
        }
        new Handler().postDelayed(new Runnable() { // from class: com.senseplay.sdk.tool.HandleOpe.4
            @Override // java.lang.Runnable
            public void run() {
                OpeListener.this.run();
            }
        }, 580L);
    }
}
