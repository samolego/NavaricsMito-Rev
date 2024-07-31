package com.navatics.app.framework.network.service;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import com.navatics.app.framework.network.p056a.ConnectionUtils;

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
        if (ConnectionUtils.m7977e(getApplicationContext())) {
            m7963a(2);
        } else {
            m7963a(1);
        }
    }

    /* renamed from: a */
    private void m7963a(int i) {
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

    @Override // android.service.quicksettings.TileService
    public void onClick() {
        super.onClick();
        switch (getQsTile().getState()) {
            case 1:
                m7964a();
                m7963a(2);
                return;
            case 2:
                m7962b();
                break;
        }
        m7963a(1);
    }

    @Override // android.service.quicksettings.TileService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: a */
    private void m7964a() {
        Intent intent = new Intent("com.navatics.app.framework.action.START_FTPSERVER");
        intent.putExtras(new Bundle());
        sendBroadcast(intent);
    }

    /* renamed from: b */
    private void m7962b() {
        Intent intent = new Intent("com.navatics.app.framework.action.STOP_FTPSERVER");
        intent.putExtras(new Bundle());
        sendBroadcast(intent);
    }
}
