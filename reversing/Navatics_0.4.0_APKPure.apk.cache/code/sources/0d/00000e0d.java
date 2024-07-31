package com.facebook.share.internal;

import com.facebook.internal.InterfaceC0904e;

/* loaded from: classes.dex */
public enum CameraEffectFeature implements InterfaceC0904e {
    SHARE_CAMERA_EFFECT(20170417);

    private int minVersion;

    @Override // com.facebook.internal.InterfaceC0904e
    public String getAction() {
        return "com.facebook.platform.action.request.CAMERA_EFFECT";
    }

    CameraEffectFeature(int i) {
        this.minVersion = i;
    }

    @Override // com.facebook.internal.InterfaceC0904e
    public int getMinVersion() {
        return this.minVersion;
    }
}