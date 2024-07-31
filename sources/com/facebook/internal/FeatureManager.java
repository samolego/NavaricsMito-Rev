package com.facebook.internal;

import android.support.annotation.RestrictTo;
import android.support.p008v4.internal.view.SupportMenu;
import android.support.p008v4.view.InputDeviceCompat;
import android.support.p008v4.view.ViewCompat;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppGateKeepersManager;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class FeatureManager {

    /* renamed from: com.facebook.internal.FeatureManager$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0926a {
        /* renamed from: a */
        void mo10784a(boolean z);
    }

    /* renamed from: a */
    public static void m10812a(final Feature feature, final InterfaceC0926a interfaceC0926a) {
        FetchedAppGateKeepersManager.m10705a(new FetchedAppGateKeepersManager.InterfaceC0956a() { // from class: com.facebook.internal.FeatureManager.1
            @Override // com.facebook.internal.FetchedAppGateKeepersManager.InterfaceC0956a
            /* renamed from: a */
            public void mo10693a() {
                InterfaceC0926a.this.mo10784a(FeatureManager.m10813a(feature));
            }
        });
    }

    /* renamed from: a */
    public static boolean m10813a(Feature feature) {
        if (Feature.Unknown == feature) {
            return false;
        }
        if (Feature.Core == feature) {
            return true;
        }
        Feature parent = feature.getParent();
        if (parent == feature) {
            return m10811b(feature);
        }
        return m10813a(parent) && m10811b(feature);
    }

    /* renamed from: b */
    private static boolean m10811b(Feature feature) {
        return FetchedAppGateKeepersManager.m10702a("FBSDKFeature" + feature.toString(), FacebookSdk.m10865l(), m10810c(feature));
    }

    /* renamed from: c */
    private static boolean m10810c(Feature feature) {
        switch (feature) {
            case RestrictiveDataFiltering:
            case Instrument:
            case CrashReport:
            case ErrorReport:
            case AAM:
            case PrivacyProtection:
            case SuggestedEvents:
            case PIIFiltering:
                return false;
            default:
                return true;
        }
    }

    /* loaded from: classes.dex */
    public enum Feature {
        Unknown(-1),
        Core(0),
        AppEvents(65536),
        CodelessEvents(65792),
        RestrictiveDataFiltering(66048),
        AAM(66304),
        PrivacyProtection(66560),
        SuggestedEvents(66561),
        PIIFiltering(66562),
        Instrument(131072),
        CrashReport(131328),
        ErrorReport(131584),
        Login(16777216),
        Share(33554432),
        Places(50331648);
        
        private final int code;

        Feature(int i) {
            this.code = i;
        }

        @Override // java.lang.Enum
        public String toString() {
            switch (this) {
                case RestrictiveDataFiltering:
                    return "RestrictiveDataFiltering";
                case Instrument:
                    return "Instrument";
                case CrashReport:
                    return "CrashReport";
                case ErrorReport:
                    return "ErrorReport";
                case AAM:
                    return "AAM";
                case PrivacyProtection:
                    return "PrivacyProtection";
                case SuggestedEvents:
                    return "SuggestedEvents";
                case PIIFiltering:
                    return "PIIFiltering";
                case Core:
                    return "CoreKit";
                case AppEvents:
                    return "AppEvents";
                case CodelessEvents:
                    return "CodelessEvents";
                case Login:
                    return "LoginKit";
                case Share:
                    return "ShareKit";
                case Places:
                    return "PlacesKit";
                default:
                    return "unknown";
            }
        }

        static Feature fromInt(int i) {
            Feature[] values;
            for (Feature feature : values()) {
                if (feature.code == i) {
                    return feature;
                }
            }
            return Unknown;
        }

        public Feature getParent() {
            int i = this.code;
            if ((i & 255) > 0) {
                return fromInt(i & InputDeviceCompat.SOURCE_ANY);
            }
            if ((65280 & i) > 0) {
                return fromInt(i & SupportMenu.CATEGORY_MASK);
            }
            if ((16711680 & i) > 0) {
                return fromInt(i & ViewCompat.MEASURED_STATE_MASK);
            }
            return fromInt(0);
        }
    }
}
