package com.navatics.miya.serializers;

import com.navatics.miya.p060b.Generics;
import com.navatics.miya.p060b.ObjectMap;
import com.navatics.miya.serializers.FieldSerializer;
import com.navatics.miya.serializers.ReflectField;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: com.navatics.miya.serializers.a */
/* loaded from: classes.dex */
public class CachedFields implements Comparator<FieldSerializer.AbstractC2017a> {

    /* renamed from: a */
    static final FieldSerializer.AbstractC2017a[] f6076a = new FieldSerializer.AbstractC2017a[0];

    /* renamed from: d */
    private final FieldSerializer f6079d;

    /* renamed from: b */
    FieldSerializer.AbstractC2017a[] f6077b = new FieldSerializer.AbstractC2017a[0];

    /* renamed from: c */
    FieldSerializer.AbstractC2017a[] f6078c = new FieldSerializer.AbstractC2017a[0];

    /* renamed from: e */
    private final ArrayList<Field> f6080e = new ArrayList<>();

    public CachedFields(FieldSerializer fieldSerializer) {
        this.f6079d = fieldSerializer;
    }

    /* renamed from: a */
    public void m6635a() {
        if (this.f6079d.f6058b.isInterface()) {
            FieldSerializer.AbstractC2017a[] abstractC2017aArr = f6076a;
            this.f6077b = abstractC2017aArr;
            this.f6078c = abstractC2017aArr;
            this.f6079d.m6639b();
            return;
        }
        ArrayList<FieldSerializer.AbstractC2017a> arrayList = new ArrayList<>();
        ArrayList<FieldSerializer.AbstractC2017a> arrayList2 = new ArrayList<>();
        for (Class cls = this.f6079d.f6058b; cls != Object.class; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                m6632a(field, arrayList, arrayList2);
            }
        }
        if (this.f6077b.length != arrayList.size()) {
            this.f6077b = new FieldSerializer.AbstractC2017a[arrayList.size()];
        }
        arrayList.toArray(this.f6077b);
        Arrays.sort(this.f6077b, this);
        if (this.f6078c.length != arrayList2.size()) {
            this.f6078c = new FieldSerializer.AbstractC2017a[arrayList2.size()];
        }
        arrayList2.toArray(this.f6078c);
        Arrays.sort(this.f6078c, this);
        this.f6079d.m6639b();
    }

    /* renamed from: a */
    private void m6632a(Field field, ArrayList<FieldSerializer.AbstractC2017a> arrayList, ArrayList<FieldSerializer.AbstractC2017a> arrayList2) {
        int modifiers = field.getModifiers();
        if (Modifier.isStatic(modifiers)) {
            return;
        }
        FieldSerializer.C2018b c2018b = this.f6079d.f6059c;
        if (field.isSynthetic() && c2018b.f6070c) {
            return;
        }
        boolean z = true;
        if (!field.isAccessible()) {
            if (!c2018b.f6069b) {
                return;
            }
            try {
                field.setAccessible(true);
            } catch (AccessControlException unused) {
                return;
            }
        }
        if (((FieldSerializer.Ignore) field.getAnnotation(FieldSerializer.Ignore.class)) != null) {
            return;
        }
        FieldSerializer.Optional optional = (FieldSerializer.Optional) field.getAnnotation(FieldSerializer.Optional.class);
        if ((optional == null || this.f6079d.f6057a.m6729d().m6671b((ObjectMap) optional.m6637a())) && !this.f6080e.contains(field)) {
            boolean isTransient = Modifier.isTransient(modifiers);
            if (!isTransient || c2018b.f6073f || c2018b.f6072e) {
                Class<?> declaringClass = field.getDeclaringClass();
                Generics.C2010a c2010a = new Generics.C2010a(declaringClass, this.f6079d.f6058b, field.getGenericType());
                Class<?> type = c2010a.m6706a() instanceof Class ? (Class) c2010a.m6706a() : field.getType();
                FieldSerializer.AbstractC2017a m6633a = m6633a(field, type, c2010a);
                m6633a.f6067f = c2018b.f6074g;
                if (c2018b.f6075h) {
                    m6633a.f6063b = declaringClass.getSimpleName() + "." + field.getName();
                } else {
                    m6633a.f6063b = field.getName();
                }
                if (m6633a instanceof ReflectField) {
                    m6633a.f6066e = c2018b.f6068a;
                    if (this.f6079d.f6057a.m6724f(type) || c2018b.f6071d) {
                        m6633a.f6064c = type;
                    }
                } else {
                    m6633a.f6066e = (type == String.class && c2018b.f6068a) ? false : false;
                    m6633a.f6064c = type;
                }
                if (isTransient) {
                    if (c2018b.f6073f) {
                        arrayList.add(m6633a);
                    }
                    if (c2018b.f6072e) {
                        arrayList2.add(m6633a);
                        return;
                    }
                    return;
                }
                arrayList.add(m6633a);
                arrayList2.add(m6633a);
            }
        }
    }

    /* renamed from: a */
    private FieldSerializer.AbstractC2017a m6633a(Field field, Class cls, Generics.C2010a c2010a) {
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                return new ReflectField.C2037f(field);
            }
            if (cls == Float.TYPE) {
                return new ReflectField.C2036e(field);
            }
            if (cls == Boolean.TYPE) {
                return new ReflectField.C2032a(field);
            }
            if (cls == Long.TYPE) {
                return new ReflectField.C2038g(field);
            }
            if (cls == Double.TYPE) {
                return new ReflectField.C2035d(field);
            }
            if (cls == Short.TYPE) {
                return new ReflectField.C2039h(field);
            }
            if (cls == Character.TYPE) {
                return new ReflectField.C2034c(field);
            }
            if (cls == Byte.TYPE) {
                return new ReflectField.C2033b(field);
            }
        }
        return new ReflectField(field, this.f6079d, c2010a);
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(FieldSerializer.AbstractC2017a abstractC2017a, FieldSerializer.AbstractC2017a abstractC2017a2) {
        return abstractC2017a.f6063b.compareTo(abstractC2017a2.f6063b);
    }
}
