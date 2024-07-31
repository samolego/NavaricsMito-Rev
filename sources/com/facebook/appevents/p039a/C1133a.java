package com.facebook.appevents.p039a;

import android.app.Activity;
import android.support.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.facebook.appevents.a.a */
/* loaded from: classes.dex */
public final class MetadataIndexer {

    /* renamed from: a */
    private static final String f1535a = MetadataIndexer.class.getCanonicalName();

    /* renamed from: b */
    private static final AtomicBoolean f1536b = new AtomicBoolean(false);

    /* renamed from: a */
    public static void m11277a(Activity activity) {
        try {
            if (f1536b.get() && !MetadataRule.m11268a().isEmpty()) {
                MetadataViewObserver.m11260a(activity);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m11274d() {
        String m10681k;
        FetchedAppSettings m10806a = FetchedAppSettingsManager.m10806a(FacebookSdk.m10865l(), false);
        if (m10806a == null || (m10681k = m10806a.m10681k()) == null) {
            return;
        }
        MetadataRule.m11267a(m10681k);
    }

    /* renamed from: a */
    public static void m11278a() {
        try {
            FacebookSdk.m10871f().execute(new Runnable() { // from class: com.facebook.appevents.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AttributionIdentifiers.m10754a(FacebookSdk.m10869h())) {
                        return;
                    }
                    MetadataIndexer.f1536b.set(true);
                    MetadataIndexer.m11274d();
                }
            });
        } catch (Exception e) {
            Utility.m10528a(f1535a, e);
        }
    }
}
