package org.mp4parser.streaming.p148a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.mp4parser.streaming.SampleExtension;

/* renamed from: org.mp4parser.streaming.a.f */
/* loaded from: classes2.dex */
public class SampleFlagsSampleExtension implements SampleExtension {

    /* renamed from: a */
    public static Map<Long, SampleFlagsSampleExtension> f12120a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b */
    private byte f12121b;

    /* renamed from: c */
    private byte f12122c;

    /* renamed from: d */
    private byte f12123d;

    /* renamed from: e */
    private byte f12124e;

    /* renamed from: f */
    private byte f12125f;

    /* renamed from: g */
    private boolean f12126g;

    /* renamed from: h */
    private int f12127h;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("isLeading=");
        sb.append((int) this.f12121b);
        sb.append(", dependsOn=");
        sb.append((int) this.f12122c);
        sb.append(", isDependedOn=");
        sb.append((int) this.f12123d);
        sb.append(", hasRedundancy=");
        sb.append((int) this.f12124e);
        sb.append(", paddingValue=");
        sb.append((int) this.f12125f);
        sb.append(", isSyncSample=");
        sb.append(!this.f12126g);
        sb.append(", sampleDegradationPriority=");
        sb.append(this.f12127h);
        return sb.toString();
    }

    /* renamed from: a */
    public byte m508a() {
        return this.f12121b;
    }

    /* renamed from: b */
    public byte m505b() {
        return this.f12122c;
    }

    /* renamed from: a */
    public void m507a(int i) {
        this.f12122c = (byte) i;
    }

    /* renamed from: c */
    public byte m503c() {
        return this.f12123d;
    }

    /* renamed from: b */
    public void m504b(int i) {
        this.f12123d = (byte) i;
    }

    /* renamed from: d */
    public byte m502d() {
        return this.f12124e;
    }

    /* renamed from: e */
    public byte m501e() {
        return this.f12125f;
    }

    /* renamed from: f */
    public boolean m500f() {
        return this.f12126g;
    }

    /* renamed from: a */
    public void m506a(boolean z) {
        this.f12126g = z;
    }

    /* renamed from: g */
    public boolean m499g() {
        return !this.f12126g;
    }

    /* renamed from: h */
    public int m498h() {
        return this.f12127h;
    }
}
