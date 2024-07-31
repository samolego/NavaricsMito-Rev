package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;

@Deprecated
/* loaded from: classes.dex */
public enum LikeDialogFeature implements DialogFeature {
    LIKE_DIALOG(20140701);
    
    private int minVersion;

    @Override // com.facebook.internal.DialogFeature
    public String getAction() {
        return "com.facebook.platform.action.request.LIKE_DIALOG";
    }

    LikeDialogFeature(int i) {
        this.minVersion = i;
    }

    @Override // com.facebook.internal.DialogFeature
    public int getMinVersion() {
        return this.minVersion;
    }
}
