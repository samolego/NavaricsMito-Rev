package org.mp4parser.p144a;

import android.support.p008v4.view.MotionEventCompat;
import android.support.p008v4.view.ViewCompat;
import com.adapt.SPM_Rc;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: org.mp4parser.a.d */
/* loaded from: classes2.dex */
public final class IsoTypeReader {
    /* renamed from: a */
    public static int m739a(byte b) {
        return b < 0 ? b + 256 : b;
    }

    /* renamed from: a */
    public static long m738a(ByteBuffer byteBuffer) {
        long j = byteBuffer.getInt();
        return j < 0 ? j + IjkMediaMeta.AV_CH_WIDE_RIGHT : j;
    }

    /* renamed from: b */
    public static int m736b(ByteBuffer byteBuffer) {
        return (m735c(byteBuffer) << 8) + 0 + m739a(byteBuffer.get());
    }

    /* renamed from: c */
    public static int m735c(ByteBuffer byteBuffer) {
        return (m739a(byteBuffer.get()) << 8) + 0 + m739a(byteBuffer.get());
    }

    /* renamed from: d */
    public static int m734d(ByteBuffer byteBuffer) {
        return m739a(byteBuffer.get());
    }

    /* renamed from: a */
    public static String m737a(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return Utf8.m708a(bArr);
    }

    /* renamed from: e */
    public static long m733e(ByteBuffer byteBuffer) {
        long m738a = (m738a(byteBuffer) << 32) + 0;
        if (m738a < 0) {
            throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
        }
        return m738a + m738a(byteBuffer);
    }

    /* renamed from: f */
    public static double m732f(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        return ((((0 | ((bArr[0] << 24) & ViewCompat.MEASURED_STATE_MASK)) | ((bArr[1] << SPM_Rc.VIBRATION_MODE.PLAY_ONCE) & 16711680)) | ((bArr[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)) | (bArr[3] & 255)) / 65536.0d;
    }

    /* renamed from: g */
    public static double m731g(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        return ((((0 | ((bArr[0] << 24) & ViewCompat.MEASURED_STATE_MASK)) | ((bArr[1] << SPM_Rc.VIBRATION_MODE.PLAY_ONCE) & 16711680)) | ((bArr[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)) | (bArr[3] & 255)) / 1.073741824E9d;
    }

    /* renamed from: h */
    public static float m730h(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        return ((short) (((short) (0 | ((bArr[0] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK))) | (bArr[1] & 255))) / 256.0f;
    }

    /* renamed from: i */
    public static String m729i(ByteBuffer byteBuffer) {
        int m735c = m735c(byteBuffer);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append((char) (((m735c >> ((2 - i) * 5)) & 31) + 96));
        }
        return sb.toString();
    }

    /* renamed from: j */
    public static String m728j(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
