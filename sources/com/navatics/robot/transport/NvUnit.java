package com.navatics.robot.transport;

import java.util.Objects;

/* renamed from: com.navatics.robot.transport.v */
/* loaded from: classes.dex */
public final class NvUnit {

    /* renamed from: a */
    protected static final NvUnit f6683a = new NvUnit("Byte", 1, "B", 1);

    /* renamed from: b */
    protected static final NvUnit f6684b = new NvUnit("Kilobyte", 2, "KB", 1);

    /* renamed from: c */
    protected static final NvUnit f6685c = new NvUnit("Megabyte", 3, "MB", 1);

    /* renamed from: d */
    protected static final NvUnit f6686d = new NvUnit("Gigabyte", 4, "GB", 1);

    /* renamed from: e */
    protected static final NvUnit f6687e = new NvUnit("Yard", 6, "yd", 2);

    /* renamed from: f */
    protected static final NvUnit f6688f = new NvUnit("Feet", 7, "ft", 2);

    /* renamed from: g */
    protected static final NvUnit f6689g = new NvUnit("Meter", 5, "m", 2);

    /* renamed from: h */
    protected static final NvUnit f6690h = new NvUnit("Celsius", 8, "℃", 3);

    /* renamed from: i */
    protected static final NvUnit f6691i = new NvUnit("Fahrenheit", 9, "℉", 3);

    /* renamed from: j */
    private int f6692j;

    /* renamed from: k */
    private String f6693k;

    /* renamed from: l */
    private int f6694l;

    /* renamed from: m */
    private String f6695m;

    private NvUnit(String str, int i, String str2, int i2) {
        this.f6695m = str;
        this.f6692j = i;
        this.f6693k = str2;
        this.f6694l = i2;
    }

    /* renamed from: a */
    public int m6006a() {
        return this.f6692j;
    }

    /* renamed from: b */
    public String m6005b() {
        return this.f6693k;
    }

    /* renamed from: c */
    public int m6004c() {
        return this.f6694l;
    }

    /* renamed from: d */
    public String m6003d() {
        return this.f6695m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NvUnit) && this.f6692j == ((NvUnit) obj).f6692j;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f6692j));
    }

    public String toString() {
        return this.f6695m;
    }
}
