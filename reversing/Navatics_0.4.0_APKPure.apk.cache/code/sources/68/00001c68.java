package com.navatics.robot.transport;

import java.util.Objects;

/* compiled from: NvUnit.java */
/* renamed from: com.navatics.robot.transport.v */
/* loaded from: classes.dex */
public final class NvUnit {

    /* renamed from: a */
    protected static final NvUnit byteUnit = new NvUnit("Byte", 1, "B", 1);

    /* renamed from: b */
    protected static final NvUnit kilobyteUnit = new NvUnit("Kilobyte", 2, "KB", 1);

    /* renamed from: c */
    protected static final NvUnit megabyteUnit = new NvUnit("Megabyte", 3, "MB", 1);

    /* renamed from: d */
    protected static final NvUnit gigabyteUnit = new NvUnit("Gigabyte", 4, "GB", 1);

    /* renamed from: e */
    protected static final NvUnit yardUnit = new NvUnit("Yard", 6, "yd", 2);

    /* renamed from: f */
    protected static final NvUnit feetUnit = new NvUnit("Feet", 7, "ft", 2);

    /* renamed from: g */
    protected static final NvUnit meterUnit = new NvUnit("Meter", 5, "m", 2);

    /* renamed from: h */
    protected static final NvUnit celsiusUnit = new NvUnit("Celsius", 8, "℃", 3);

    /* renamed from: i */
    protected static final NvUnit fahrenheitUnit = new NvUnit("Fahrenheit", 9, "℉", 3);

    /* renamed from: j */
    private int f6722j;

    /* renamed from: k */
    private String abbreviation;

    /* renamed from: l */
    private int f6724l;

    /* renamed from: m */
    private String unitName;

    private NvUnit(String unitName, int i, String abbreviation, int i2) {
        this.unitName = unitName;
        this.f6722j = i;
        this.abbreviation = abbreviation;
        this.f6724l = i2;
    }

    /* renamed from: a */
    public int m6848a() {
        return this.f6722j;
    }

    /* renamed from: b */
    public String getAbbreviation() {
        return this.abbreviation;
    }

    /* renamed from: c */
    public int m6850c() {
        return this.f6724l;
    }

    /* renamed from: d */
    public String getUnitName() {
        return this.unitName;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NvUnit) && this.f6722j == ((NvUnit) obj).f6722j;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f6722j));
    }

    public String toString() {
        return this.unitName;
    }
}