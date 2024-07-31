package com.navatics.app.framework.firmware;

/* renamed from: com.navatics.app.framework.firmware.f */
/* loaded from: classes.dex */
public class FirmwareUpdateInfo {

    /* renamed from: b */
    private String f4601b;

    /* renamed from: c */
    private String f4602c;

    /* renamed from: d */
    private String f4603d;

    /* renamed from: e */
    private String f4604e;

    /* renamed from: f */
    private int f4605f;

    /* renamed from: h */
    private int f4607h;

    /* renamed from: i */
    private String f4608i;

    /* renamed from: a */
    private int f4600a = 0;

    /* renamed from: g */
    private int f4606g = 3;

    /* renamed from: a */
    public String m8230a() {
        return this.f4603d;
    }

    /* renamed from: a */
    public void m8227a(String str) {
        this.f4603d = str;
    }

    /* renamed from: b */
    public String m8226b() {
        return this.f4601b;
    }

    /* renamed from: b */
    public void m8224b(String str) {
        this.f4601b = str;
    }

    /* renamed from: c */
    public String m8223c() {
        return this.f4602c;
    }

    /* renamed from: c */
    public void m8221c(String str) {
        this.f4602c = str;
    }

    /* renamed from: d */
    public String m8220d() {
        return this.f4604e;
    }

    /* renamed from: d */
    public void m8219d(String str) {
        this.f4604e = str;
    }

    /* renamed from: e */
    public int m8218e() {
        return this.f4605f;
    }

    /* renamed from: f */
    public int m8216f() {
        return this.f4606g;
    }

    /* renamed from: a */
    public void m8229a(int i) {
        this.f4606g = i;
    }

    /* renamed from: g */
    public int m8215g() {
        return this.f4607h;
    }

    /* renamed from: b */
    public void m8225b(int i) {
        this.f4607h = i;
    }

    /* renamed from: h */
    public int m8214h() {
        return this.f4600a;
    }

    /* renamed from: c */
    public void m8222c(int i) {
        this.f4600a = i;
    }

    /* renamed from: i */
    public String m8213i() {
        return this.f4608i;
    }

    /* renamed from: e */
    public void m8217e(String str) {
        this.f4608i = str;
    }

    /* renamed from: a */
    public void m8228a(FirmwareUpdateInfo firmwareUpdateInfo) {
        this.f4603d = firmwareUpdateInfo.m8230a();
        this.f4606g = firmwareUpdateInfo.m8216f();
        this.f4608i = firmwareUpdateInfo.f4608i;
        this.f4600a = firmwareUpdateInfo.m8214h();
        this.f4601b = firmwareUpdateInfo.m8226b();
        this.f4607h = firmwareUpdateInfo.m8215g();
        this.f4604e = firmwareUpdateInfo.m8220d();
        this.f4602c = firmwareUpdateInfo.m8223c();
        this.f4605f = firmwareUpdateInfo.m8218e();
    }
}
