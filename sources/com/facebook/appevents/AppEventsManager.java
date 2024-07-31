package com.facebook.appevents;

import android.support.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.appevents.p039a.MetadataIndexer;
import com.facebook.appevents.p040b.RestrictiveDataManager;
import com.facebook.appevents.p042ml.ModelManager;
import com.facebook.internal.FeatureManager;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.facebook.appevents.f */
/* loaded from: classes.dex */
public class AppEventsManager {
    /* renamed from: a */
    public static void m11064a() {
        if (FacebookSdk.m10861p()) {
            FeatureManager.m10812a(FeatureManager.Feature.AAM, new FeatureManager.InterfaceC0926a() { // from class: com.facebook.appevents.f.1
                @Override // com.facebook.internal.FeatureManager.InterfaceC0926a
                /* renamed from: a */
                public void mo10784a(boolean z) {
                    if (z) {
                        MetadataIndexer.m11278a();
                    }
                }
            });
            FeatureManager.m10812a(FeatureManager.Feature.RestrictiveDataFiltering, new FeatureManager.InterfaceC0926a() { // from class: com.facebook.appevents.f.2
                @Override // com.facebook.internal.FeatureManager.InterfaceC0926a
                /* renamed from: a */
                public void mo10784a(boolean z) {
                    if (z) {
                        RestrictiveDataManager.m11245a();
                    }
                }
            });
            FeatureManager.m10812a(FeatureManager.Feature.PrivacyProtection, new FeatureManager.InterfaceC0926a() { // from class: com.facebook.appevents.f.3
                @Override // com.facebook.internal.FeatureManager.InterfaceC0926a
                /* renamed from: a */
                public void mo10784a(boolean z) {
                    if (z) {
                        ModelManager.m10935a();
                    }
                }
            });
        }
    }
}
