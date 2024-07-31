package com.twitter.sdk.android.core.models;

import java.util.Collections;
import java.util.List;

/* compiled from: ModelUtils.java */
/* renamed from: com.twitter.sdk.android.core.models.j, reason: use source file name */
/* loaded from: classes2.dex */
public final class ModelUtils {
    /* renamed from: a */
    public static <T> List<T> m8607a(List<T> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(list);
    }
}