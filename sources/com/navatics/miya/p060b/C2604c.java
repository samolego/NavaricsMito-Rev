package com.navatics.miya.p060b;

import com.navatics.miya.Miya;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

/* renamed from: com.navatics.miya.b.c */
/* loaded from: classes.dex */
public class Generics {

    /* renamed from: a */
    private final Miya f5992a;

    /* renamed from: b */
    private int f5993b;

    /* renamed from: e */
    private int f5996e;

    /* renamed from: c */
    private C2010a[] f5994c = new C2010a[16];

    /* renamed from: d */
    private final int[] f5995d = new int[16];

    /* renamed from: f */
    private Type[] f5997f = new Type[16];

    public Generics(Miya miya) {
        this.f5992a = miya;
    }

    /* renamed from: a */
    public void m6711a(C2010a c2010a) {
        if (c2010a.f5999b == null) {
            return;
        }
        int i = this.f5993b;
        int i2 = i + 1;
        C2010a[] c2010aArr = this.f5994c;
        if (i2 == c2010aArr.length) {
            C2010a[] c2010aArr2 = new C2010a[c2010aArr.length << 1];
            System.arraycopy(c2010aArr, 0, c2010aArr2, 0, i);
            this.f5994c = c2010aArr2;
        }
        this.f5993b = i2;
        this.f5994c[i] = c2010a;
        this.f5995d[i] = this.f5992a.m6727e();
    }

    /* renamed from: a */
    public void m6713a() {
        int i = this.f5993b;
        if (i == 0) {
            return;
        }
        int i2 = i - 1;
        if (this.f5995d[i2] < this.f5992a.m6727e()) {
            return;
        }
        this.f5994c[i2] = null;
        this.f5993b = i2;
    }

    /* renamed from: b */
    public C2010a[] m6708b() {
        int i = this.f5993b;
        if (i > 0) {
            int i2 = i - 1;
            C2010a c2010a = this.f5994c[i2];
            if (this.f5995d[i2] == this.f5992a.m6727e() - 1) {
                m6711a(c2010a.f5999b[c2010a.f5999b.length - 1]);
                return c2010a.f5999b;
            }
            return null;
        }
        return null;
    }

    /* renamed from: c */
    public Class m6707c() {
        C2010a[] m6708b = m6708b();
        if (m6708b == null) {
            return null;
        }
        return m6708b[0].m6705a(this);
    }

    /* renamed from: a */
    public int m6710a(C2011b c2011b, C2010a[] c2010aArr) {
        int i = this.f5996e;
        int i2 = c2011b.f6000a + i;
        Type[] typeArr = this.f5997f;
        if (i2 > typeArr.length) {
            Type[] typeArr2 = new Type[Math.max(i2, typeArr.length << 1)];
            System.arraycopy(this.f5997f, 0, typeArr2, 0, i);
            this.f5997f = typeArr2;
        }
        int[] iArr = c2011b.f6001b;
        TypeVariable[] typeVariableArr = c2011b.f6002c;
        int length = c2010aArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            C2010a c2010a = c2010aArr[i4];
            Class m6705a = c2010a.m6705a(this);
            if (m6705a != null) {
                int i5 = iArr[i4];
                if (c2010a == null) {
                    i3 += i5;
                } else {
                    int i6 = i5 + i3;
                    while (i3 < i6) {
                        Type[] typeArr3 = this.f5997f;
                        int i7 = this.f5996e;
                        typeArr3[i7] = typeVariableArr[i3];
                        typeArr3[i7 + 1] = m6705a;
                        this.f5996e = i7 + 2;
                        i3++;
                    }
                }
            }
        }
        return this.f5996e - i;
    }

    /* renamed from: a */
    public void m6712a(int i) {
        int i2 = this.f5996e;
        int i3 = i2 - i;
        this.f5996e = i3;
        while (i3 < i2) {
            this.f5997f[i3] = null;
            i3++;
        }
    }

    /* renamed from: a */
    public Class m6709a(TypeVariable typeVariable) {
        for (int i = this.f5996e - 2; i >= 0; i -= 2) {
            Type[] typeArr = this.f5997f;
            if (typeArr[i] == typeVariable) {
                return (Class) typeArr[i + 1];
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f5996e; i += 2) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(((TypeVariable) this.f5997f[i]).getName());
            sb.append("=");
            sb.append(((Class) this.f5997f[i + 1]).getSimpleName());
        }
        return sb.toString();
    }

    /* compiled from: Generics.java */
    /* renamed from: com.navatics.miya.b.c$b */
    /* loaded from: classes.dex */
    public static class C2011b {

        /* renamed from: a */
        final int f6000a;

        /* renamed from: b */
        final int[] f6001b;

        /* renamed from: c */
        final TypeVariable[] f6002c;

        public C2011b(Class cls) {
            ArrayList arrayList = new ArrayList();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            this.f6001b = new int[typeParameters.length];
            int length = typeParameters.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                TypeVariable typeVariable = typeParameters[i2];
                arrayList.add(typeVariable);
                this.f6001b[i2] = 1;
                TypeVariable typeVariable2 = typeVariable;
                Class cls2 = cls;
                while (true) {
                    Type genericSuperclass = cls2.getGenericSuperclass();
                    cls2 = cls2.getSuperclass();
                    if (!(genericSuperclass instanceof ParameterizedType)) {
                        break;
                    }
                    TypeVariable[] typeParameters2 = cls2.getTypeParameters();
                    Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    int length2 = actualTypeArguments.length;
                    TypeVariable typeVariable3 = typeVariable2;
                    for (int i3 = 0; i3 < length2; i3++) {
                        if (actualTypeArguments[i3] == typeVariable3) {
                            typeVariable3 = typeParameters2[i3];
                            arrayList.add(typeVariable3);
                            int[] iArr = this.f6001b;
                            iArr[i2] = iArr[i2] + 1;
                        }
                    }
                    typeVariable2 = typeVariable3;
                }
                i += this.f6001b[i2];
            }
            this.f6000a = i;
            this.f6002c = (TypeVariable[]) arrayList.toArray(new TypeVariable[arrayList.size()]);
        }
    }

    /* compiled from: Generics.java */
    /* renamed from: com.navatics.miya.b.c$a */
    /* loaded from: classes.dex */
    public static class C2010a {

        /* renamed from: a */
        Type f5998a;

        /* renamed from: b */
        C2010a[] f5999b;

        public C2010a(Class cls, Class cls2, Type type) {
            m6704a(cls, cls2, type);
        }

        /* renamed from: a */
        private void m6704a(Class cls, Class cls2, Type type) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class cls3 = (Class) parameterizedType.getRawType();
                this.f5998a = cls3;
                cls3.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                int length = actualTypeArguments.length;
                this.f5999b = new C2010a[length];
                for (int i = 0; i < length; i++) {
                    this.f5999b[i] = new C2010a(cls, cls2, actualTypeArguments[i]);
                }
            } else if (type instanceof GenericArrayType) {
                int i2 = 1;
                while (true) {
                    type = ((GenericArrayType) type).getGenericComponentType();
                    if (!(type instanceof GenericArrayType)) {
                        break;
                    }
                    i2++;
                }
                m6704a(cls, cls2, type);
                Type m6703a = GenericsUtil.m6703a(cls, cls2, type);
                if (m6703a instanceof Class) {
                    if (i2 == 1) {
                        this.f5998a = Array.newInstance((Class) m6703a, 0).getClass();
                    } else {
                        this.f5998a = Array.newInstance((Class) m6703a, new int[i2]).getClass();
                    }
                }
            } else {
                this.f5998a = GenericsUtil.m6703a(cls, cls2, type);
            }
        }

        /* renamed from: a */
        public Class m6705a(Generics generics) {
            Type type = this.f5998a;
            return type instanceof Class ? (Class) type : generics.m6709a((TypeVariable) type);
        }

        /* renamed from: a */
        public Type m6706a() {
            return this.f5998a;
        }

        public String toString() {
            boolean z;
            StringBuilder sb = new StringBuilder(32);
            Type type = this.f5998a;
            if (type instanceof Class) {
                Class cls = (Class) type;
                z = cls.isArray();
                if (z) {
                    cls = C2012j.m6657d(cls);
                }
                sb.append(cls.getSimpleName());
                if (this.f5999b != null) {
                    sb.append('<');
                    int length = this.f5999b.length;
                    for (int i = 0; i < length; i++) {
                        if (i > 0) {
                            sb.append(", ");
                        }
                        sb.append(this.f5999b[i].toString());
                    }
                    sb.append('>');
                }
            } else {
                sb.append(type.toString());
                z = false;
            }
            if (z) {
                int m6658c = C2012j.m6658c((Class) this.f5998a);
                for (int i2 = 0; i2 < m6658c; i2++) {
                    sb.append("[]");
                }
            }
            return sb.toString();
        }
    }
}
