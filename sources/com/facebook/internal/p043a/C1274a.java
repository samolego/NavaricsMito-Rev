package com.facebook.internal.p043a;

import android.support.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.p043a.p044a.CrashHandler;
import com.facebook.internal.p043a.p045b.ErrorReportHandler;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.facebook.internal.a.a */
/* loaded from: classes.dex */
public class InstrumentManager {
    /* renamed from: a */
    public static void m10785a() {
        if (FacebookSdk.m10861p()) {
            FeatureManager.m10812a(FeatureManager.Feature.CrashReport, new FeatureManager.InterfaceC0926a() { // from class: com.facebook.internal.a.a.1
                @Override // com.facebook.internal.FeatureManager.InterfaceC0926a
                /* renamed from: a */
                public void mo10784a(boolean z) {
                    if (z) {
                        CrashHandler.m10783a();
                    }
                }
            });
            FeatureManager.m10812a(FeatureManager.Feature.ErrorReport, new FeatureManager.InterfaceC0926a() { // from class: com.facebook.internal.a.a.2
                @Override // com.facebook.internal.FeatureManager.InterfaceC0926a
                /* renamed from: a */
                public void mo10784a(boolean z) {
                    if (z) {
                        ErrorReportHandler.m10760a();
                    }
                }
            });
        }
    }
}
