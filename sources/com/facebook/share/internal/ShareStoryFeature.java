package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;

/* loaded from: classes.dex */
public enum ShareStoryFeature implements DialogFeature {
    SHARE_STORY_ASSET(20170417);
    
    private int minVersion;

    @Override // com.facebook.internal.DialogFeature
    public String getAction() {
        return "com.facebook.platform.action.request.SHARE_STORY";
    }

    ShareStoryFeature(int i) {
        this.minVersion = i;
    }

    @Override // com.facebook.internal.DialogFeature
    public int getMinVersion() {
        return this.minVersion;
    }
}
