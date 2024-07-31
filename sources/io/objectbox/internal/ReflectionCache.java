package io.objectbox.internal;

import io.objectbox.annotation.apihint.Internal;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

@Internal
/* renamed from: io.objectbox.internal.e */
/* loaded from: classes2.dex */
public class ReflectionCache {

    /* renamed from: a */
    private static final ReflectionCache f9542a = new ReflectionCache();

    /* renamed from: b */
    private final Map<Class, Map<String, Field>> f9543b = new HashMap();

    /* renamed from: a */
    public static ReflectionCache m3313a() {
        return f9542a;
    }

    @Nonnull
    /* renamed from: a */
    public synchronized Field m3312a(Class cls, String str) {
        Field field;
        Map<String, Field> map = this.f9543b.get(cls);
        if (map == null) {
            map = new HashMap<>();
            this.f9543b.put(cls, map);
        }
        field = map.get(str);
        if (field == null) {
            try {
                field = cls.getDeclaredField(str);
                field.setAccessible(true);
                map.put(str, field);
            } catch (NoSuchFieldException e) {
                throw new IllegalStateException(e);
            }
        }
        return field;
    }
}
