package com.facebook.share.internal;

import com.facebook.internal.InterfaceC0904e;

/* loaded from: classes.dex */
public enum OpenGraphActionDialogFeature implements InterfaceC0904e {
    OG_ACTION_DIALOG(20130618);

    private int minVersion;

    @Override // com.facebook.internal.InterfaceC0904e
    public String getAction() {
        return "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    }

    OpenGraphActionDialogFeature(int i) {
        this.minVersion = i;
    }

    @Override // com.facebook.internal.InterfaceC0904e
    public int getMinVersion() {
        return this.minVersion;
    }
}