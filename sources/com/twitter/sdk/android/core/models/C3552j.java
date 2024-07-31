package com.twitter.sdk.android.core.models;

import java.util.Collections;
import java.util.List;

/* renamed from: com.twitter.sdk.android.core.models.j */
/* loaded from: classes2.dex */
public final class ModelUtils {
    /* renamed from: a */
    public static <T> List<T> m4248a(List<T> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(list);
    }
}
