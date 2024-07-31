package com.tencent.wxop.stat;

/* loaded from: classes2.dex */
public class StatAppMonitor implements Cloneable {
    public static final int FAILURE_RESULT_TYPE = 1;
    public static final int LOGIC_FAILURE_RESULT_TYPE = 2;
    public static final int SUCCESS_RESULT_TYPE = 0;

    /* renamed from: a */
    private String f7870a;

    /* renamed from: b */
    private long f7871b;

    /* renamed from: c */
    private long f7872c;

    /* renamed from: d */
    private int f7873d;

    /* renamed from: e */
    private long f7874e;

    /* renamed from: f */
    private int f7875f;

    /* renamed from: g */
    private int f7876g;

    public StatAppMonitor(String str) {
        this.f7870a = null;
        this.f7871b = 0L;
        this.f7872c = 0L;
        this.f7873d = 0;
        this.f7874e = 0L;
        this.f7875f = 0;
        this.f7876g = 1;
        this.f7870a = str;
    }

    public StatAppMonitor(String str, int i, int i2, long j, long j2, long j3, int i3) {
        this.f7870a = null;
        this.f7871b = 0L;
        this.f7872c = 0L;
        this.f7873d = 0;
        this.f7874e = 0L;
        this.f7875f = 0;
        this.f7876g = 1;
        this.f7870a = str;
        this.f7871b = j;
        this.f7872c = j2;
        this.f7873d = i;
        this.f7874e = j3;
        this.f7875f = i2;
        this.f7876g = i3;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public StatAppMonitor m12979clone() {
        try {
            return (StatAppMonitor) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String getInterfaceName() {
        return this.f7870a;
    }

    public long getMillisecondsConsume() {
        return this.f7874e;
    }

    public long getReqSize() {
        return this.f7871b;
    }

    public long getRespSize() {
        return this.f7872c;
    }

    public int getResultType() {
        return this.f7873d;
    }

    public int getReturnCode() {
        return this.f7875f;
    }

    public int getSampling() {
        return this.f7876g;
    }

    public void setInterfaceName(String str) {
        this.f7870a = str;
    }

    public void setMillisecondsConsume(long j) {
        this.f7874e = j;
    }

    public void setReqSize(long j) {
        this.f7871b = j;
    }

    public void setRespSize(long j) {
        this.f7872c = j;
    }

    public void setResultType(int i) {
        this.f7873d = i;
    }

    public void setReturnCode(int i) {
        this.f7875f = i;
    }

    public void setSampling(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.f7876g = i;
    }
}