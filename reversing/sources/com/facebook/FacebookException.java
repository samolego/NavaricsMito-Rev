package com.facebook;

import com.facebook.internal.FeatureManager;
import com.facebook.internal.p043a.p045b.ErrorReportHandler;
import java.util.Random;

/* loaded from: classes.dex */
public class FacebookException extends RuntimeException {
    static final long serialVersionUID = 1;

    public FacebookException() {
    }

    public FacebookException(final String str) {
        super(str);
        Random random = new Random();
        if (str == null || !FacebookSdk.m10885a() || random.nextInt(100) <= 50) {
            return;
        }
        FeatureManager.m10812a(FeatureManager.Feature.ErrorReport, new FeatureManager.InterfaceC0926a() { // from class: com.facebook.FacebookException.1
            @Override // com.facebook.internal.FeatureManager.InterfaceC0926a
            /* renamed from: a */
            public void mo10784a(boolean z) {
                if (z) {
                    try {
                        ErrorReportHandler.m10759a(str);
                    } catch (Exception unused) {
                    }
                }
            }
        });
    }

    public FacebookException(String str, Object... objArr) {
        this(String.format(str, objArr));
    }

    public FacebookException(String str, Throwable th) {
        super(str, th);
    }

    public FacebookException(Throwable th) {
        super(th);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getMessage();
    }
}
