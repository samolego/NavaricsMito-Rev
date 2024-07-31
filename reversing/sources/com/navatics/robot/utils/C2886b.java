package com.navatics.robot.utils;

import android.support.annotation.NonNull;

/* renamed from: com.navatics.robot.utils.b */
/* loaded from: classes2.dex */
public class CargoMsg implements Comparable<CargoMsg> {

    /* renamed from: f */
    private static int f6750f;

    /* renamed from: a */
    private int f6751a;

    /* renamed from: b */
    private int f6752b;

    /* renamed from: c */
    private int f6753c;

    /* renamed from: d */
    private Object f6754d;

    /* renamed from: e */
    private Object f6755e;

    /* renamed from: a */
    public static CargoMsg m5908a(int i) {
        return new CargoMsg(i);
    }

    /* renamed from: a */
    public static CargoMsg m5907a(int i, Object obj) {
        return new CargoMsg(i, obj);
    }

    /* renamed from: a */
    public static CargoMsg m5905a(Object obj) {
        return new CargoMsg(obj);
    }

    private CargoMsg() {
        int i = f6750f;
        f6750f = i + 1;
        this.f6751a = i;
    }

    private CargoMsg(int i) {
        this.f6752b = 1;
        this.f6753c = i;
    }

    private CargoMsg(int i, Object obj) {
        this.f6752b = 1;
        this.f6753c = i;
        this.f6754d = obj;
    }

    private CargoMsg(Object obj) {
        this.f6752b = 2;
        this.f6755e = obj;
    }

    /* renamed from: a */
    public int m5909a() {
        return this.f6752b;
    }

    /* renamed from: b */
    public int m5904b() {
        return this.f6753c;
    }

    /* renamed from: c */
    public Object m5903c() {
        return this.f6754d;
    }

    /* renamed from: d */
    public Object m5902d() {
        return this.f6755e;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull CargoMsg cargoMsg) {
        return this.f6752b == 1 ? cargoMsg.f6752b == 1 ? 0 : -1 : cargoMsg.f6752b == 1 ? 1 : 0;
    }
}
