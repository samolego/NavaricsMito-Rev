package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;
import okio.Buffer;
import org.apache.log4j.spi.LocationInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utils.java */
/* renamed from: retrofit2.o */
/* loaded from: classes2.dex */
public final class C3208o {

    /* renamed from: a */
    static final Type[] f12736a = new Type[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Class<?> m23a(Type type) {
        m25a(type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (!(rawType instanceof Class)) {
                throw new IllegalArgumentException();
            }
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(m23a(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return m23a(((WildcardType) type).getUpperBounds()[0]);
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
        }
    }

    /* renamed from: a */
    static boolean m19a(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                Type ownerType = parameterizedType.getOwnerType();
                Type ownerType2 = parameterizedType2.getOwnerType();
                return (ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return m19a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        } else if (type instanceof WildcardType) {
            if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                WildcardType wildcardType2 = (WildcardType) type2;
                return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
            }
            return false;
        } else if ((type instanceof TypeVariable) && (type2 instanceof TypeVariable)) {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
        } else {
            return false;
        }
    }

    /* renamed from: a */
    static Type m22a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return m22a(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return m22a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    /* renamed from: a */
    private static int m16a(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    /* renamed from: b */
    static String m14b(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static Type m13b(Type type, Class<?> cls, Class<?> cls2) {
        if (!cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException();
        }
        return m21a(type, cls, m22a(type, cls, cls2));
    }

    /* renamed from: a */
    static Type m21a(Type type, Class<?> cls, Type type2) {
        while (type2 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type2;
            Type m20a = m20a(type, cls, (TypeVariable<?>) typeVariable);
            if (m20a == typeVariable) {
                return m20a;
            }
            type2 = m20a;
        }
        if (type2 instanceof Class) {
            Class cls2 = (Class) type2;
            if (cls2.isArray()) {
                Class<?> componentType = cls2.getComponentType();
                Type m21a = m21a(type, cls, (Type) componentType);
                return componentType == m21a ? cls2 : new C3209a(m21a);
            }
        }
        if (type2 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type2;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            Type m21a2 = m21a(type, cls, genericComponentType);
            return genericComponentType == m21a2 ? genericArrayType : new C3209a(m21a2);
        }
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type m21a3 = m21a(type, cls, ownerType);
            boolean z = m21a3 != ownerType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            for (int i = 0; i < length; i++) {
                Type m21a4 = m21a(type, cls, actualTypeArguments[i]);
                if (m21a4 != actualTypeArguments[i]) {
                    if (!z) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        z = true;
                    }
                    actualTypeArguments[i] = m21a4;
                }
            }
            return z ? new C3210b(m21a3, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
        } else if (type2 instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type2;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                Type m21a5 = m21a(type, cls, lowerBounds[0]);
                if (m21a5 != lowerBounds[0]) {
                    return new C3211c(new Type[]{Object.class}, new Type[]{m21a5});
                }
            } else if (upperBounds.length == 1) {
                Type m21a6 = m21a(type, cls, upperBounds[0]);
                if (m21a6 != upperBounds[0]) {
                    return new C3211c(new Type[]{m21a6}, f12736a);
                }
            }
            return wildcardType;
        } else {
            return type2;
        }
    }

    /* renamed from: a */
    private static Type m20a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> m18a = m18a(typeVariable);
        if (m18a == null) {
            return typeVariable;
        }
        Type m22a = m22a(type, cls, m18a);
        if (m22a instanceof ParameterizedType) {
            return ((ParameterizedType) m22a).getActualTypeArguments()[m16a(m18a.getTypeParameters(), typeVariable)];
        }
        return typeVariable;
    }

    /* renamed from: a */
    private static Class<?> m18a(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    /* renamed from: c */
    static void m12c(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static <T> T m25a(@Nullable T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m15a(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static ResponseBody m17a(ResponseBody responseBody) throws IOException {
        Buffer buffer = new Buffer();
        responseBody.mo127d().mo2241a(buffer);
        return ResponseBody.m3004a(responseBody.mo129a(), responseBody.mo128b(), buffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static <T> void m26a(Class<T> cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        if (cls.getInterfaces().length > 0) {
            throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Type m27a(int i, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i < 0 || i >= actualTypeArguments.length) {
            throw new IllegalArgumentException("Index " + i + " not in range [0," + actualTypeArguments.length + ") for " + parameterizedType);
        }
        Type type = actualTypeArguments[i];
        return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static boolean m11d(@Nullable Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (m11d(type2)) {
                    return true;
                }
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            return m11d(((GenericArrayType) type).getGenericComponentType());
        } else {
            if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
                return true;
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static Type m10e(Type type) {
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
        }
        return m27a(0, (ParameterizedType) type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Utils.java */
    /* renamed from: retrofit2.o$b */
    /* loaded from: classes2.dex */
    public static final class C3210b implements ParameterizedType {

        /* renamed from: a */
        private final Type f12738a;

        /* renamed from: b */
        private final Type f12739b;

        /* renamed from: c */
        private final Type[] f12740c;

        C3210b(@Nullable Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                if ((type == null) != (((Class) type2).getEnclosingClass() == null)) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                C3208o.m25a(type3, "typeArgument == null");
                C3208o.m12c(type3);
            }
            this.f12738a = type;
            this.f12739b = type2;
            this.f12740c = (Type[]) typeArr.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f12740c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f12739b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f12738a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && C3208o.m19a(this, (ParameterizedType) obj);
        }

        public int hashCode() {
            int hashCode = Arrays.hashCode(this.f12740c) ^ this.f12739b.hashCode();
            Type type = this.f12738a;
            return hashCode ^ (type != null ? type.hashCode() : 0);
        }

        public String toString() {
            Type[] typeArr = this.f12740c;
            if (typeArr.length == 0) {
                return C3208o.m14b(this.f12739b);
            }
            StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
            sb.append(C3208o.m14b(this.f12739b));
            sb.append("<");
            sb.append(C3208o.m14b(this.f12740c[0]));
            for (int i = 1; i < this.f12740c.length; i++) {
                sb.append(", ");
                sb.append(C3208o.m14b(this.f12740c[i]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Utils.java */
    /* renamed from: retrofit2.o$a */
    /* loaded from: classes2.dex */
    public static final class C3209a implements GenericArrayType {

        /* renamed from: a */
        private final Type f12737a;

        C3209a(Type type) {
            this.f12737a = type;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f12737a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && C3208o.m19a(this, (GenericArrayType) obj);
        }

        public int hashCode() {
            return this.f12737a.hashCode();
        }

        public String toString() {
            return C3208o.m14b(this.f12737a) + "[]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Utils.java */
    /* renamed from: retrofit2.o$c */
    /* loaded from: classes2.dex */
    public static final class C3211c implements WildcardType {

        /* renamed from: a */
        private final Type f12741a;

        /* renamed from: b */
        private final Type f12742b;

        C3211c(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr2.length == 1) {
                if (typeArr2[0] == null) {
                    throw new NullPointerException();
                }
                C3208o.m12c(typeArr2[0]);
                if (typeArr[0] != Object.class) {
                    throw new IllegalArgumentException();
                }
                this.f12742b = typeArr2[0];
                this.f12741a = Object.class;
            } else if (typeArr[0] == null) {
                throw new NullPointerException();
            } else {
                C3208o.m12c(typeArr[0]);
                this.f12742b = null;
                this.f12741a = typeArr[0];
            }
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f12741a};
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.f12742b;
            return type != null ? new Type[]{type} : C3208o.f12736a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && C3208o.m19a(this, (WildcardType) obj);
        }

        public int hashCode() {
            Type type = this.f12742b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f12741a.hashCode() + 31);
        }

        public String toString() {
            if (this.f12742b != null) {
                return "? super " + C3208o.m14b(this.f12742b);
            } else if (this.f12741a == Object.class) {
                return LocationInfo.f11272NA;
            } else {
                return "? extends " + C3208o.m14b(this.f12741a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m24a(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
