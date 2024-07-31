package org.mp4parser.p133a;

import android.support.v4.view.ViewCompat;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: IsoTypeWriter.java */
/* renamed from: org.mp4parser.a.f, reason: use source file name */
/* loaded from: classes2.dex */
public final class IsoTypeWriter {

    /* renamed from: a */
    static final /* synthetic */ boolean f11769a = !IsoTypeWriter.class.desiredAssertionStatus();

    /* renamed from: a */
    public static void m12089a(ByteBuffer byteBuffer, long j) {
        if (!f11769a && j < 0) {
            throw new AssertionError("The given long is negative");
        }
        byteBuffer.putLong(j);
    }

    /* renamed from: b */
    public static void m12093b(ByteBuffer byteBuffer, long j) {
        if (f11769a || (j >= 0 && j <= IjkMediaMeta.AV_CH_WIDE_RIGHT)) {
            byteBuffer.putInt((int) j);
            return;
        }
        throw new AssertionError("The given long is not in the range of uint32 (" + j + ")");
    }

    /* renamed from: a */
    public static void m12088a(ByteBuffer byteBuffer, int i) {
        int i2 = i & ViewCompat.MEASURED_SIZE_MASK;
        m12092b(byteBuffer, i2 >> 8);
        m12095c(byteBuffer, i2);
    }

    /* renamed from: b */
    public static void m12092b(ByteBuffer byteBuffer, int i) {
        int i2 = i & 65535;
        m12095c(byteBuffer, i2 >> 8);
        m12095c(byteBuffer, i2 & 255);
    }

    /* renamed from: c */
    public static void m12095c(ByteBuffer byteBuffer, int i) {
        byteBuffer.put((byte) (i & 255));
    }

    /* renamed from: a */
    public static void m12087a(ByteBuffer byteBuffer, double d) {
        int i = (int) (d * 65536.0d);
        byteBuffer.put((byte) (((-16777216) & i) >> 24));
        byteBuffer.put((byte) ((16711680 & i) >> 16));
        byteBuffer.put((byte) ((65280 & i) >> 8));
        byteBuffer.put((byte) (i & 255));
    }

    /* renamed from: b */
    public static void m12091b(ByteBuffer byteBuffer, double d) {
        int i = (int) (d * 1.073741824E9d);
        byteBuffer.put((byte) (((-16777216) & i) >> 24));
        byteBuffer.put((byte) ((16711680 & i) >> 16));
        byteBuffer.put((byte) ((65280 & i) >> 8));
        byteBuffer.put((byte) (i & 255));
    }

    /* renamed from: c */
    public static void m12094c(ByteBuffer byteBuffer, double d) {
        short s = (short) (d * 256.0d);
        byteBuffer.put((byte) ((65280 & s) >> 8));
        byteBuffer.put((byte) (s & 255));
    }

    /* renamed from: a */
    public static void m12090a(ByteBuffer byteBuffer, String str) {
        if (str.getBytes().length != 3) {
            throw new IllegalArgumentException("\"" + str + "\" language string isn't exactly 3 characters long!");
        }
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            i += (str.getBytes()[i2] - 96) << ((2 - i2) * 5);
        }
        m12092b(byteBuffer, i);
    }
}