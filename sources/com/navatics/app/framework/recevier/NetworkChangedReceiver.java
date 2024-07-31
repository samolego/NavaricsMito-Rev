package com.navatics.app.framework.recevier;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* loaded from: classes.dex */
public class NetworkChangedReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private final String f4781a = "NetworkChangedReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return;
        }
        for (Network network : connectivityManager.getAllNetworks()) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            networkCapabilities.hasTransport(1);
            networkCapabilities.hasTransport(0);
            networkCapabilities.hasTransport(4);
        }
    }
}
