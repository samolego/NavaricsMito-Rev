package com.navatics.miya.util;

import com.navatics.miya.MiyaException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/* compiled from: GenericsUtil.java */
/* renamed from: com.navatics.miya.b.d, reason: use source file name */
/* loaded from: classes.dex */
public class GenericsUtil {
    /* renamed from: a */
    public static Type m6158a(Class cls, Class cls2, Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof TypeVariable) {
            return m6159a(cls, cls2, type, true);
        }
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof GenericArrayType) {
            int i = 1;
            while (true) {
                type = ((GenericArrayType) type).getGenericComponentType();
                if (!(type instanceof GenericArrayType)) {
                    break;
                }
                i++;
            }
            Type m6158a = m6158a(cls, cls2, type);
            if (!(m6158a instanceof Class)) {
                return type;
            }
            if (i == 1) {
                return Array.newInstance((Class<?>) m6158a, 0).getClass();
            }
            return Array.newInstance((Class<?>) m6158a, new int[i]).getClass();
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            Type type2 = wildcardType.getUpperBounds()[0];
            if (type2 != Object.class) {
                return m6158a(cls, cls2, type2);
            }
            Type[] lowerBounds = wildcardType.getLowerBounds();
            return lowerBounds.length != 0 ? m6158a(cls, cls2, lowerBounds[0]) : Object.class;
        }
        throw new MiyaException("Unable to resolve type: " + type);
    }

    /* renamed from: a */
    private static Type m6159a(Class cls, Class cls2, Type type, boolean z) {
        Class superclass = cls2.getSuperclass();
        TypeVariable[] typeParameters = superclass.getTypeParameters();
        if (typeParameters.length == 0) {
            return type;
        }
        int i = 0;
        if (superclass != cls) {
            if (superclass == null) {
                return type;
            }
            type = m6159a(cls, superclass, type, false);
            if (type instanceof Class) {
                return (Class) type;
            }
        }
        String obj = type.toString();
        int length = typeParameters.length;
        while (true) {
            if (i >= length) {
                break;
            }
            if (typeParameters[i].getName().equals(obj)) {
                Type genericSuperclass = cls2.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    Type type2 = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[i];
                    if (type2 instanceof Class) {
                        return (Class) type2;
                    }
                    if (type2 instanceof ParameterizedType) {
                        return m6158a(cls, cls2, type2);
                    }
                    if (type2 instanceof TypeVariable) {
                        return z ? type : type2;
                    }
                }
            }
            i++;
        }
        throw new MiyaException("Unable to resolve type variable: " + type);
    }
}