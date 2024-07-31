package org.mp4parser.boxes.iso14496.p147b;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BitReaderBuffer;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BitWriterBuffer;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;

/* renamed from: org.mp4parser.boxes.iso14496.b.b */
/* loaded from: classes2.dex */
public class AvcDecoderConfigurationRecord {

    /* renamed from: a */
    public int f12078a;

    /* renamed from: b */
    public int f12079b;

    /* renamed from: c */
    public int f12080c;

    /* renamed from: d */
    public int f12081d;

    /* renamed from: e */
    public int f12082e;

    /* renamed from: f */
    public List<ByteBuffer> f12083f;

    /* renamed from: g */
    public List<ByteBuffer> f12084g;

    /* renamed from: h */
    public boolean f12085h;

    /* renamed from: i */
    public int f12086i;

    /* renamed from: j */
    public int f12087j;

    /* renamed from: k */
    public int f12088k;

    /* renamed from: l */
    public List<ByteBuffer> f12089l;

    /* renamed from: m */
    public int f12090m;

    /* renamed from: n */
    public int f12091n;

    /* renamed from: o */
    public int f12092o;

    /* renamed from: p */
    public int f12093p;

    /* renamed from: q */
    public int f12094q;

    public AvcDecoderConfigurationRecord() {
        this.f12083f = new ArrayList();
        this.f12084g = new ArrayList();
        this.f12085h = true;
        this.f12086i = 1;
        this.f12087j = 0;
        this.f12088k = 0;
        this.f12089l = new ArrayList();
        this.f12090m = 63;
        this.f12091n = 7;
        this.f12092o = 31;
        this.f12093p = 31;
        this.f12094q = 31;
    }

    public AvcDecoderConfigurationRecord(ByteBuffer byteBuffer) {
        int i;
        this.f12083f = new ArrayList();
        this.f12084g = new ArrayList();
        this.f12085h = true;
        this.f12086i = 1;
        this.f12087j = 0;
        this.f12088k = 0;
        this.f12089l = new ArrayList();
        this.f12090m = 63;
        this.f12091n = 7;
        this.f12092o = 31;
        this.f12093p = 31;
        this.f12094q = 31;
        this.f12078a = IsoTypeReader.m734d(byteBuffer);
        this.f12079b = IsoTypeReader.m734d(byteBuffer);
        this.f12080c = IsoTypeReader.m734d(byteBuffer);
        this.f12081d = IsoTypeReader.m734d(byteBuffer);
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
        this.f12090m = bitReaderBuffer.m528a(6);
        this.f12082e = bitReaderBuffer.m528a(2);
        this.f12091n = bitReaderBuffer.m528a(3);
        int m528a = bitReaderBuffer.m528a(5);
        for (int i2 = 0; i2 < m528a; i2++) {
            byte[] bArr = new byte[IsoTypeReader.m735c(byteBuffer)];
            byteBuffer.get(bArr);
            this.f12083f.add(ByteBuffer.wrap(bArr));
        }
        long m734d = IsoTypeReader.m734d(byteBuffer);
        for (int i3 = 0; i3 < m734d; i3++) {
            byte[] bArr2 = new byte[IsoTypeReader.m735c(byteBuffer)];
            byteBuffer.get(bArr2);
            this.f12084g.add(ByteBuffer.wrap(bArr2));
        }
        if (byteBuffer.remaining() < 4) {
            this.f12085h = false;
        }
        if (this.f12085h && ((i = this.f12079b) == 100 || i == 110 || i == 122 || i == 144)) {
            BitReaderBuffer bitReaderBuffer2 = new BitReaderBuffer(byteBuffer);
            this.f12092o = bitReaderBuffer2.m528a(6);
            this.f12086i = bitReaderBuffer2.m528a(2);
            this.f12093p = bitReaderBuffer2.m528a(5);
            this.f12087j = bitReaderBuffer2.m528a(3);
            this.f12094q = bitReaderBuffer2.m528a(5);
            this.f12088k = bitReaderBuffer2.m528a(3);
            long m734d2 = IsoTypeReader.m734d(byteBuffer);
            for (int i4 = 0; i4 < m734d2; i4++) {
                byte[] bArr3 = new byte[IsoTypeReader.m735c(byteBuffer)];
                byteBuffer.get(bArr3);
                this.f12089l.add(ByteBuffer.wrap(bArr3));
            }
            return;
        }
        this.f12086i = -1;
        this.f12087j = -1;
        this.f12088k = -1;
    }

    /* renamed from: a */
    public void m529a(ByteBuffer byteBuffer) {
        IsoTypeWriter.m718c(byteBuffer, this.f12078a);
        IsoTypeWriter.m718c(byteBuffer, this.f12079b);
        IsoTypeWriter.m718c(byteBuffer, this.f12080c);
        IsoTypeWriter.m718c(byteBuffer, this.f12081d);
        BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
        bitWriterBuffer.m527a(this.f12090m, 6);
        bitWriterBuffer.m527a(this.f12082e, 2);
        bitWriterBuffer.m527a(this.f12091n, 3);
        bitWriterBuffer.m527a(this.f12084g.size(), 5);
        for (ByteBuffer byteBuffer2 : this.f12083f) {
            IsoTypeWriter.m721b(byteBuffer, byteBuffer2.limit());
            byteBuffer.put((ByteBuffer) byteBuffer2.rewind());
        }
        IsoTypeWriter.m718c(byteBuffer, this.f12084g.size());
        for (ByteBuffer byteBuffer3 : this.f12084g) {
            IsoTypeWriter.m721b(byteBuffer, byteBuffer3.limit());
            byteBuffer.put((ByteBuffer) byteBuffer3.rewind());
        }
        if (this.f12085h) {
            int i = this.f12079b;
            if (i == 100 || i == 110 || i == 122 || i == 144) {
                BitWriterBuffer bitWriterBuffer2 = new BitWriterBuffer(byteBuffer);
                bitWriterBuffer2.m527a(this.f12092o, 6);
                bitWriterBuffer2.m527a(this.f12086i, 2);
                bitWriterBuffer2.m527a(this.f12093p, 5);
                bitWriterBuffer2.m527a(this.f12087j, 3);
                bitWriterBuffer2.m527a(this.f12094q, 5);
                bitWriterBuffer2.m527a(this.f12088k, 3);
                for (ByteBuffer byteBuffer4 : this.f12089l) {
                    IsoTypeWriter.m721b(byteBuffer, byteBuffer4.limit());
                    byteBuffer.put((ByteBuffer) byteBuffer4.reset());
                }
            }
        }
    }

    /* renamed from: a */
    public long m530a() {
        int i;
        long j = 6;
        for (ByteBuffer byteBuffer : this.f12083f) {
            j = j + 2 + byteBuffer.limit();
        }
        long j2 = j + 1;
        for (ByteBuffer byteBuffer2 : this.f12084g) {
            j2 = j2 + 2 + byteBuffer2.limit();
        }
        if (this.f12085h && ((i = this.f12079b) == 100 || i == 110 || i == 122 || i == 144)) {
            j2 += 4;
            for (ByteBuffer byteBuffer3 : this.f12089l) {
                j2 = j2 + 2 + byteBuffer3.limit();
            }
        }
        return j2;
    }

    public String toString() {
        return "AvcDecoderConfigurationRecord{configurationVersion=" + this.f12078a + ", avcProfileIndication=" + this.f12079b + ", profileCompatibility=" + this.f12080c + ", avcLevelIndication=" + this.f12081d + ", lengthSizeMinusOne=" + this.f12082e + ", hasExts=" + this.f12085h + ", chromaFormat=" + this.f12086i + ", bitDepthLumaMinus8=" + this.f12087j + ", bitDepthChromaMinus8=" + this.f12088k + ", lengthSizeMinusOnePaddingBits=" + this.f12090m + ", numberOfSequenceParameterSetsPaddingBits=" + this.f12091n + ", chromaFormatPaddingBits=" + this.f12092o + ", bitDepthLumaMinus8PaddingBits=" + this.f12093p + ", bitDepthChromaMinus8PaddingBits=" + this.f12094q + '}';
    }
}
