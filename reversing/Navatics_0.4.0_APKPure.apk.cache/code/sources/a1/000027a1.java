package org.mp4parser.streaming.p137a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.mp4parser.streaming.InterfaceC3428a;

/* compiled from: SampleFlagsSampleExtension.java */
/* renamed from: org.mp4parser.streaming.a.f, reason: use source file name */
/* loaded from: classes2.dex */
public class SampleFlagsSampleExtension implements InterfaceC3428a {

    /* renamed from: a */
    public static Map<Long, SampleFlagsSampleExtension> f12161a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b */
    private byte f12162b;

    /* renamed from: c */
    private byte f12163c;

    /* renamed from: d */
    private byte f12164d;

    /* renamed from: e */
    private byte f12165e;

    /* renamed from: f */
    private byte f12166f;

    /* renamed from: g */
    private boolean f12167g;

    /* renamed from: h */
    private int f12168h;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("isLeading=");
        sb.append((int) this.f12162b);
        sb.append(", dependsOn=");
        sb.append((int) this.f12163c);
        sb.append(", isDependedOn=");
        sb.append((int) this.f12164d);
        sb.append(", hasRedundancy=");
        sb.append((int) this.f12165e);
        sb.append(", paddingValue=");
        sb.append((int) this.f12166f);
        sb.append(", isSyncSample=");
        sb.append(!this.f12167g);
        sb.append(", sampleDegradationPriority=");
        sb.append(this.f12168h);
        return sb.toString();
    }

    /* renamed from: a */
    public byte m12309a() {
        return this.f12162b;
    }

    /* renamed from: b */
    public byte m12312b() {
        return this.f12163c;
    }

    /* renamed from: a */
    public void m12310a(int i) {
        this.f12163c = (byte) i;
    }

    /* renamed from: c */
    public byte m12314c() {
        return this.f12164d;
    }

    /* renamed from: b */
    public void m12313b(int i) {
        this.f12164d = (byte) i;
    }

    /* renamed from: d */
    public byte m12315d() {
        return this.f12165e;
    }

    /* renamed from: e */
    public byte m12316e() {
        return this.f12166f;
    }

    /* renamed from: f */
    public boolean m12317f() {
        return this.f12167g;
    }

    /* renamed from: a */
    public void m12311a(boolean z) {
        this.f12167g = z;
    }

    /* renamed from: g */
    public boolean m12318g() {
        return !this.f12167g;
    }

    /* renamed from: h */
    public int m12319h() {
        return this.f12168h;
    }
}