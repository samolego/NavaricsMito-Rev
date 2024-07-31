package com.twitter.sdk.android.core.models;

import java.util.Collections;
import java.util.Map;

/* renamed from: com.twitter.sdk.android.core.models.c */
/* loaded from: classes2.dex */
public class BindingValues {

    /* renamed from: a */
    private final Map<String, Object> f8709a;

    public BindingValues() {
        this(Collections.EMPTY_MAP);
    }

    public BindingValues(Map<String, Object> map) {
        this.f8709a = Collections.unmodifiableMap(map);
    }

    /* renamed from: a */
    public <T> T m4252a(String str) {
        try {
            return (T) this.f8709a.get(str);
        } catch (ClassCastException unused) {
            return null;
        }
    }
}
