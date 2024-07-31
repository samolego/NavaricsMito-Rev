package com.twitter.sdk.android.core.internal.scribe;

import java.util.List;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.t */
/* loaded from: classes2.dex */
public class ScribeEventFactory {
    /* renamed from: a */
    public static ScribeEvent m4275a(EventNamespace eventNamespace, String str, long j, String str2, String str3, List<ScribeItem> list) {
        String str4 = eventNamespace.f8601a;
        if (((str4.hashCode() == 114757 && str4.equals("tfw")) ? (char) 0 : (char) 65535) == 0) {
            return new SyndicationClientEvent(eventNamespace, str, j, str2, str3, list);
        }
        return new SyndicatedSdkImpressionEvent(eventNamespace, j, str2, str3, list);
    }
}
