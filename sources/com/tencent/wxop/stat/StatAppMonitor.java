package com.tencent.wxop.stat;

/* loaded from: classes2.dex */
public class StatAppMonitor implements Cloneable {
    public static final int FAILURE_RESULT_TYPE = 1;
    public static final int LOGIC_FAILURE_RESULT_TYPE = 2;
    public static final int SUCCESS_RESULT_TYPE = 0;

    /* renamed from: a */
    private String f7832a;

    /* renamed from: b */
    private long f7833b;

    /* renamed from: c */
    private long f7834c;

    /* renamed from: d */
    private int f7835d;

    /* renamed from: e */
    private long f7836e;

    /* renamed from: f */
    private int f7837f;

    /* renamed from: g */
    private int f7838g;

    public StatAppMonitor(String str) {
        this.f7832a = null;
        this.f7833b = 0L;
        this.f7834c = 0L;
        this.f7835d = 0;
        this.f7836e = 0L;
        this.f7837f = 0;
        this.f7838g = 1;
        this.f7832a = str;
    }

    public StatAppMonitor(String str, int i, int i2, long j, long j2, long j3, int i3) {
        this.f7832a = null;
        this.f7833b = 0L;
        this.f7834c = 0L;
        this.f7835d = 0;
        this.f7836e = 0L;
        this.f7837f = 0;
        this.f7838g = 1;
        this.f7832a = str;
        this.f7833b = j;
        this.f7834c = j2;
        this.f7835d = i;
        this.f7836e = j3;
        this.f7837f = i2;
        this.f7838g = i3;
    }

    /* renamed from: clone */
    public StatAppMonitor m13137clone() {
        try {
            return (StatAppMonitor) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String getInterfaceName() {
        return this.f7832a;
    }

    public long getMillisecondsConsume() {
        return this.f7836e;
    }

    public long getReqSize() {
        return this.f7833b;
    }

    public long getRespSize() {
        return this.f7834c;
    }

    public int getResultType() {
        return this.f7835d;
    }

    public int getReturnCode() {
        return this.f7837f;
    }

    public int getSampling() {
        return this.f7838g;
    }

    public void setInterfaceName(String str) {
        this.f7832a = str;
    }

    public void setMillisecondsConsume(long j) {
        this.f7836e = j;
    }

    public void setReqSize(long j) {
        this.f7833b = j;
    }

    public void setRespSize(long j) {
        this.f7834c = j;
    }

    public void setResultType(int i) {
        this.f7835d = i;
    }

    public void setReturnCode(int i) {
        this.f7837f = i;
    }

    public void setSampling(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.f7838g = i;
    }
}
