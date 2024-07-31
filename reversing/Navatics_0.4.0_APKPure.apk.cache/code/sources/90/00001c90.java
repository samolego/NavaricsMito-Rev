package com.navatics.robot.utils;

import android.support.annotation.NonNull;

/* compiled from: CargoMsg.java */
/* renamed from: com.navatics.robot.utils.b, reason: use source file name */
/* loaded from: classes2.dex */
public class CargoMsg implements Comparable<CargoMsg> {

    /* renamed from: f */
    private static int f6781f;

    /* renamed from: a */
    private int f6782a;

    /* renamed from: b */
    private int f6783b;

    /* renamed from: c */
    private int f6784c;

    /* renamed from: d */
    private Object f6785d;

    /* renamed from: e */
    private Object f6786e;

    /* renamed from: a */
    public static CargoMsg m6943a(int i) {
        return new CargoMsg(i);
    }

    /* renamed from: a */
    public static CargoMsg m6944a(int i, Object obj) {
        return new CargoMsg(i, obj);
    }

    /* renamed from: a */
    public static CargoMsg m6945a(Object obj) {
        return new CargoMsg(obj);
    }

    private CargoMsg() {
        int i = f6781f;
        f6781f = i + 1;
        this.f6782a = i;
    }

    private CargoMsg(int i) {
        this.f6783b = 1;
        this.f6784c = i;
    }

    private CargoMsg(int i, Object obj) {
        this.f6783b = 1;
        this.f6784c = i;
        this.f6785d = obj;
    }

    private CargoMsg(Object obj) {
        this.f6783b = 2;
        this.f6786e = obj;
    }

    /* renamed from: a */
    public int m6946a() {
        return this.f6783b;
    }

    /* renamed from: b */
    public int m6948b() {
        return this.f6784c;
    }

    /* renamed from: c */
    public Object m6949c() {
        return this.f6785d;
    }

    /* renamed from: d */
    public Object m6950d() {
        return this.f6786e;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull CargoMsg cargoMsg) {
        return this.f6783b == 1 ? cargoMsg.f6783b == 1 ? 0 : -1 : cargoMsg.f6783b == 1 ? 1 : 0;
    }
}