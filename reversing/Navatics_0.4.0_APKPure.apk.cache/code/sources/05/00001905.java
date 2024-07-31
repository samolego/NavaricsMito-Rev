package com.navatics.app.framework.network.service;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import com.navatics.app.framework.network.p050a.ConnectionUtils;

@TargetApi(24)
/* loaded from: classes.dex */
public class ServerService extends TileService {
    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.service.quicksettings.TileService
    public void onStartListening() {
        super.onStartListening();
        if (ConnectionUtils.m4959e(getApplicationContext())) {
            m4973a(2);
        } else {
            m4973a(1);
        }
    }

    /* renamed from: a */
    private void m4973a(int i) {
        Tile qsTile = getQsTile();
        if (qsTile != null) {
            qsTile.setState(i);
            Icon icon = qsTile.getIcon();
            if (i == 2) {
                icon.setTint(-1);
            } else {
                icon.setTint(-7829368);
            }
            qsTile.updateTile();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000b. Please report as an issue. */
    @Override // android.service.quicksettings.TileService
    public void onClick() {
        super.onClick();
        switch (getQsTile().getState()) {
            case 1:
                m4972a();
                m4973a(2);
                return;
            case 2:
                m4974b();
            default:
                m4973a(1);
                return;
        }
    }

    @Override // android.service.quicksettings.TileService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: a */
    private void m4972a() {
        Intent intent = new Intent("com.navatics.app.framework.action.START_FTPSERVER");
        intent.putExtras(new Bundle());
        sendBroadcast(intent);
    }

    /* renamed from: b */
    private void m4974b() {
        Intent intent = new Intent("com.navatics.app.framework.action.STOP_FTPSERVER");
        intent.putExtras(new Bundle());
        sendBroadcast(intent);
    }
}