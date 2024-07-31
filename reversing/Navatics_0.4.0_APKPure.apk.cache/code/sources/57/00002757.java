package org.mp4parser.p133a;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import com.adapt.SPM_Rc;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: IsoTypeReader.java */
/* renamed from: org.mp4parser.a.d, reason: use source file name */
/* loaded from: classes2.dex */
public final class IsoTypeReader {
    /* renamed from: a */
    public static int m12074a(byte b) {
        return b < 0 ? b + 256 : b;
    }

    /* renamed from: a */
    public static long m12075a(ByteBuffer byteBuffer) {
        long j = byteBuffer.getInt();
        return j < 0 ? j + IjkMediaMeta.AV_CH_WIDE_RIGHT : j;
    }

    /* renamed from: b */
    public static int m12077b(ByteBuffer byteBuffer) {
        return (m12078c(byteBuffer) << 8) + 0 + m12074a(byteBuffer.get());
    }

    /* renamed from: c */
    public static int m12078c(ByteBuffer byteBuffer) {
        return (m12074a(byteBuffer.get()) << 8) + 0 + m12074a(byteBuffer.get());
    }

    /* renamed from: d */
    public static int m12079d(ByteBuffer byteBuffer) {
        return m12074a(byteBuffer.get());
    }

    /* renamed from: a */
    public static String m12076a(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return C3373k.m12104a(bArr);
    }

    /* renamed from: e */
    public static long m12080e(ByteBuffer byteBuffer) {
        long m12075a = (m12075a(byteBuffer) << 32) + 0;
        if (m12075a < 0) {
            throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
        }
        return m12075a + m12075a(byteBuffer);
    }

    /* renamed from: f */
    public static double m12081f(ByteBuffer byteBuffer) {
        byteBuffer.get(new byte[4]);
        return ((((0 | ((r0[0] << 24) & ViewCompat.MEASURED_STATE_MASK)) | ((r0[1] << SPM_Rc.VIBRATION_MODE.PLAY_ONCE) & 16711680)) | ((r0[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)) | (r0[3] & 255)) / 65536.0d;
    }

    /* renamed from: g */
    public static double m12082g(ByteBuffer byteBuffer) {
        byteBuffer.get(new byte[4]);
        return ((((0 | ((r0[0] << 24) & ViewCompat.MEASURED_STATE_MASK)) | ((r0[1] << SPM_Rc.VIBRATION_MODE.PLAY_ONCE) & 16711680)) | ((r0[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)) | (r0[3] & 255)) / 1.073741824E9d;
    }

    /* renamed from: h */
    public static float m12083h(ByteBuffer byteBuffer) {
        byteBuffer.get(new byte[2]);
        return ((short) (((short) (0 | ((r0[0] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK))) | (r0[1] & 255))) / 256.0f;
    }

    /* renamed from: i */
    public static String m12084i(ByteBuffer byteBuffer) {
        int m12078c = m12078c(byteBuffer);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append((char) (((m12078c >> ((2 - i) * 5)) & 31) + 96));
        }
        return sb.toString();
    }

    /* renamed from: j */
    public static String m12085j(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}