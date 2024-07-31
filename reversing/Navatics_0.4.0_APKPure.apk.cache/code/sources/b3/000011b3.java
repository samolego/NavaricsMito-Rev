package com.google.android.gms.internal;

import java.io.IOException;

/* loaded from: classes.dex */
public class zzarj extends IOException {
    public zzarj(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cT */
    public static zzarj m3337cT() {
        return new zzarj("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cU */
    public static zzarj m3338cU() {
        return new zzarj("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cV */
    public static zzarj m3339cV() {
        return new zzarj("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cW */
    public static zzarj m3340cW() {
        return new zzarj("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cX */
    public static zzarj m3341cX() {
        return new zzarj("Protocol message end-group tag did not match expected tag.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cY */
    public static zzarj m3342cY() {
        return new zzarj("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cZ */
    public static zzarj m3343cZ() {
        return new zzarj("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}