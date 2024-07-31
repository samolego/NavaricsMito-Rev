package com.facebook.share.internal;

import com.facebook.internal.InterfaceC0904e;

@Deprecated
/* loaded from: classes.dex */
public enum LikeDialogFeature implements InterfaceC0904e {
    LIKE_DIALOG(20140701);

    private int minVersion;

    @Override // com.facebook.internal.InterfaceC0904e
    public String getAction() {
        return "com.facebook.platform.action.request.LIKE_DIALOG";
    }

    LikeDialogFeature(int i) {
        this.minVersion = i;
    }

    @Override // com.facebook.internal.InterfaceC0904e
    public int getMinVersion() {
        return this.minVersion;
    }
}