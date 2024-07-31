package com.google.android.gms.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class zzany {
    private final Field bkC;

    public zzany(Field field) {
        zzaoz.zzy(field);
        this.bkC = field;
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return (T) this.bkC.getAnnotation(cls);
    }
}
