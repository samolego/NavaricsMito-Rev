package com.navatics.robot.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* renamed from: com.navatics.robot.utils.i */
/* loaded from: classes2.dex */
public class NetworkUtil {
    /* renamed from: a */
    public static boolean m5875a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (Network network : connectivityManager.getAllNetworks()) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities.hasTransport(1)) {
                z = true;
            }
            if (networkCapabilities.hasTransport(0)) {
                z2 = true;
            }
            if (networkCapabilities.hasTransport(4)) {
                z3 = true;
            }
        }
        return z || z2 || z3;
    }

    /* renamed from: b */
    public static boolean m5874b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        for (Network network : connectivityManager.getAllNetworks()) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities.hasTransport(1)) {
                z = true;
            }
            if (networkCapabilities.hasTransport(4)) {
                z2 = true;
            }
        }
        return z || z2;
    }
}
