package com.facebook.share.internal;

import com.facebook.internal.InterfaceC0904e;

/* loaded from: classes.dex */
public enum ShareDialogFeature implements InterfaceC0904e {
    SHARE_DIALOG(20130618),
    PHOTOS(20140204),
    VIDEO(20141028),
    MULTIMEDIA(20160327),
    HASHTAG(20160327),
    LINK_SHARE_QUOTES(20160327);

    private int minVersion;

    @Override // com.facebook.internal.InterfaceC0904e
    public String getAction() {
        return "com.facebook.platform.action.request.FEED_DIALOG";
    }

    ShareDialogFeature(int i) {
        this.minVersion = i;
    }

    @Override // com.facebook.internal.InterfaceC0904e
    public int getMinVersion() {
        return this.minVersion;
    }
}