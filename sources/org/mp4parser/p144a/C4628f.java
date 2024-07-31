package org.mp4parser.p144a;

import android.support.p008v4.view.ViewCompat;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: org.mp4parser.a.f */
/* loaded from: classes2.dex */
public final class IsoTypeWriter {

    /* renamed from: a */
    static final /* synthetic */ boolean f11728a = !IsoTypeWriter.class.desiredAssertionStatus();

    /* renamed from: a */
    public static void m724a(ByteBuffer byteBuffer, long j) {
        if (!f11728a && j < 0) {
            throw new AssertionError("The given long is negative");
        }
        byteBuffer.putLong(j);
    }

    /* renamed from: b */
    public static void m720b(ByteBuffer byteBuffer, long j) {
        if (f11728a || (j >= 0 && j <= IjkMediaMeta.AV_CH_WIDE_RIGHT)) {
            byteBuffer.putInt((int) j);
            return;
        }
        throw new AssertionError("The given long is not in the range of uint32 (" + j + ")");
    }

    /* renamed from: a */
    public static void m725a(ByteBuffer byteBuffer, int i) {
        int i2 = i & ViewCompat.MEASURED_SIZE_MASK;
        m721b(byteBuffer, i2 >> 8);
        m718c(byteBuffer, i2);
    }

    /* renamed from: b */
    public static void m721b(ByteBuffer byteBuffer, int i) {
        int i2 = i & 65535;
        m718c(byteBuffer, i2 >> 8);
        m718c(byteBuffer, i2 & 255);
    }

    /* renamed from: c */
    public static void m718c(ByteBuffer byteBuffer, int i) {
        byteBuffer.put((byte) (i & 255));
    }

    /* renamed from: a */
    public static void m726a(ByteBuffer byteBuffer, double d) {
        int i = (int) (d * 65536.0d);
        byteBuffer.put((byte) (((-16777216) & i) >> 24));
        byteBuffer.put((byte) ((16711680 & i) >> 16));
        byteBuffer.put((byte) ((65280 & i) >> 8));
        byteBuffer.put((byte) (i & 255));
    }

    /* renamed from: b */
    public static void m722b(ByteBuffer byteBuffer, double d) {
        int i = (int) (d * 1.073741824E9d);
        byteBuffer.put((byte) (((-16777216) & i) >> 24));
        byteBuffer.put((byte) ((16711680 & i) >> 16));
        byteBuffer.put((byte) ((65280 & i) >> 8));
        byteBuffer.put((byte) (i & 255));
    }

    /* renamed from: c */
    public static void m719c(ByteBuffer byteBuffer, double d) {
        short s = (short) (d * 256.0d);
        byteBuffer.put((byte) ((65280 & s) >> 8));
        byteBuffer.put((byte) (s & 255));
    }

    /* renamed from: a */
    public static void m723a(ByteBuffer byteBuffer, String str) {
        if (str.getBytes().length != 3) {
            throw new IllegalArgumentException("\"" + str + "\" language string isn't exactly 3 characters long!");
        }
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            i += (str.getBytes()[i2] - 96) << ((2 - i2) * 5);
        }
        m721b(byteBuffer, i);
    }
}
