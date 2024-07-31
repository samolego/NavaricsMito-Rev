package org.mp4parser.boxes.iso14496.p146a;

import java.nio.ByteBuffer;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;

/* renamed from: org.mp4parser.boxes.iso14496.a.w */
/* loaded from: classes2.dex */
public class SampleFlags {

    /* renamed from: a */
    private byte f12023a;

    /* renamed from: b */
    private byte f12024b;

    /* renamed from: c */
    private byte f12025c;

    /* renamed from: d */
    private byte f12026d;

    /* renamed from: e */
    private byte f12027e;

    /* renamed from: f */
    private byte f12028f;

    /* renamed from: g */
    private boolean f12029g;

    /* renamed from: h */
    private int f12030h;

    public SampleFlags() {
    }

    public SampleFlags(ByteBuffer byteBuffer) {
        long m738a = IsoTypeReader.m738a(byteBuffer);
        this.f12023a = (byte) (((-268435456) & m738a) >> 28);
        this.f12024b = (byte) ((201326592 & m738a) >> 26);
        this.f12025c = (byte) ((50331648 & m738a) >> 24);
        this.f12026d = (byte) ((12582912 & m738a) >> 22);
        this.f12027e = (byte) ((3145728 & m738a) >> 20);
        this.f12028f = (byte) ((917504 & m738a) >> 17);
        this.f12029g = ((65536 & m738a) >> 16) > 0;
        this.f12030h = (int) (m738a & 65535);
    }

    /* renamed from: a */
    public void m558a(ByteBuffer byteBuffer) {
        IsoTypeWriter.m720b(byteBuffer, (this.f12023a << 28) | 0 | (this.f12024b << 26) | (this.f12025c << 24) | (this.f12026d << 22) | (this.f12027e << 20) | (this.f12028f << 17) | ((this.f12029g ? 1 : 0) << 16) | this.f12030h);
    }

    /* renamed from: a */
    public void m560a(byte b) {
        this.f12024b = b;
    }

    /* renamed from: a */
    public void m559a(int i) {
        this.f12025c = (byte) i;
    }

    /* renamed from: b */
    public void m556b(int i) {
        this.f12026d = (byte) i;
    }

    /* renamed from: c */
    public void m555c(int i) {
        this.f12027e = (byte) i;
    }

    /* renamed from: d */
    public void m554d(int i) {
        this.f12028f = (byte) i;
    }

    /* renamed from: a */
    public void m557a(boolean z) {
        this.f12029g = z;
    }

    /* renamed from: e */
    public void m553e(int i) {
        this.f12030h = i;
    }

    public String toString() {
        return "SampleFlags{reserved=" + ((int) this.f12023a) + ", isLeading=" + ((int) this.f12024b) + ", depOn=" + ((int) this.f12025c) + ", isDepOn=" + ((int) this.f12026d) + ", hasRedundancy=" + ((int) this.f12027e) + ", padValue=" + ((int) this.f12028f) + ", isDiffSample=" + this.f12029g + ", degradPrio=" + this.f12030h + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SampleFlags sampleFlags = (SampleFlags) obj;
        return this.f12024b == sampleFlags.f12024b && this.f12023a == sampleFlags.f12023a && this.f12030h == sampleFlags.f12030h && this.f12025c == sampleFlags.f12025c && this.f12027e == sampleFlags.f12027e && this.f12026d == sampleFlags.f12026d && this.f12029g == sampleFlags.f12029g && this.f12028f == sampleFlags.f12028f;
    }

    public int hashCode() {
        return (((((((((((((this.f12023a * 31) + this.f12024b) * 31) + this.f12025c) * 31) + this.f12026d) * 31) + this.f12027e) * 31) + this.f12028f) * 31) + (this.f12029g ? 1 : 0)) * 31) + this.f12030h;
    }
}
