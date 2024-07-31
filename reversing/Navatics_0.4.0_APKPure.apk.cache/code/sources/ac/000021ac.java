package com.twitter.sdk.android.core.models;

import java.util.Collections;
import java.util.Map;

/* compiled from: BindingValues.java */
/* renamed from: com.twitter.sdk.android.core.models.c, reason: use source file name */
/* loaded from: classes2.dex */
public class BindingValues {

    /* renamed from: a */
    private final Map<String, Object> f8749a;

    public BindingValues() {
        this(Collections.EMPTY_MAP);
    }

    public BindingValues(Map<String, Object> map) {
        this.f8749a = Collections.unmodifiableMap(map);
    }

    /* renamed from: a */
    public <T> T m8603a(String str) {
        try {
            return (T) this.f8749a.get(str);
        } catch (ClassCastException unused) {
            return null;
        }
    }
}