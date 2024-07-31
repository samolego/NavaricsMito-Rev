package okhttp3.internal.http2;

import android.support.p008v4.view.PointerIconCompat;
import android.support.p011v7.widget.helper.ItemTouchHelper;
import com.adapt.SPM_Rc;
import com.common.LOGIN_ACK_REL;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import okio.BufferedSink;
import okio.ByteString;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: okhttp3.internal.http2.i */
/* loaded from: classes2.dex */
class Huffman {

    /* renamed from: a */
    private static final int[] f10462a = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 4090, 8185, 21, 248, 2042, PointerIconCompat.TYPE_ZOOM_IN, PointerIconCompat.TYPE_ZOOM_OUT, 249, 2043, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, PointerIconCompat.TYPE_GRAB, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, IjkMediaMeta.FF_PROFILE_H264_HIGH_422, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* renamed from: b */
    private static final byte[] f10463b = {LOGIN_ACK_REL.LOGIN_ACK_REL_SN_ERR, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, LOGIN_ACK_REL.LOGIN_ACK_REL_REPEAT_LOGIN, LOGIN_ACK_REL.LOGIN_ACK_REL_SN_ERR, 6, 8, LOGIN_ACK_REL.LOGIN_ACK_REL_SN_EMPTY, 10, 10, 8, LOGIN_ACK_REL.LOGIN_ACK_REL_SN_EMPTY, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, SPM_Rc.VIBRATION_MODE.MAX_VOLUME, 6, LOGIN_ACK_REL.LOGIN_ACK_REL_REPEAT_LOGIN, 10, LOGIN_ACK_REL.LOGIN_ACK_REL_SN_ERR, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, LOGIN_ACK_REL.LOGIN_ACK_REL_SN_ERR, 19, LOGIN_ACK_REL.LOGIN_ACK_REL_SN_ERR, 14, 6, SPM_Rc.VIBRATION_MODE.MAX_VOLUME, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, SPM_Rc.VIBRATION_MODE.MAX_VOLUME, LOGIN_ACK_REL.LOGIN_ACK_REL_SN_EMPTY, 14, LOGIN_ACK_REL.LOGIN_ACK_REL_SN_ERR, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};

    /* renamed from: c */
    private static final Huffman f10464c = new Huffman();

    /* renamed from: d */
    private final C2970a f10465d = new C2970a();

    /* renamed from: a */
    public static Huffman m2607a() {
        return f10464c;
    }

    private Huffman() {
        m2602b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m2604a(ByteString byteString, BufferedSink bufferedSink) throws IOException {
        int i = 0;
        long j = 0;
        byte b = 0;
        while (i < byteString.size()) {
            int i2 = byteString.getByte(i) & 255;
            int i3 = f10462a[i2];
            byte b2 = f10463b[i2];
            j = (j << b2) | i3;
            int i4 = b + b2;
            while (i4 >= 8) {
                i4 = (i4 == 1 ? 1 : 0) - 8;
                bufferedSink.mo2251i((int) (j >> i4));
            }
            i++;
            b = i4;
        }
        if (b > 0) {
            bufferedSink.mo2251i((int) ((255 >>> b) | (j << (8 - b))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m2605a(ByteString byteString) {
        long j = 0;
        for (int i = 0; i < byteString.size(); i++) {
            j += f10463b[byteString.getByte(i) & 255];
        }
        return (int) ((j + 7) >> 3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public byte[] m2603a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C2970a c2970a = this.f10465d;
        int i = 0;
        int i2 = 0;
        for (byte b : bArr) {
            i = (i << 8) | (b & 255);
            i2 += 8;
            while (i2 >= 8) {
                c2970a = c2970a.f10466a[(i >>> (i2 - 8)) & 255];
                if (c2970a.f10466a == null) {
                    byteArrayOutputStream.write(c2970a.f10467b);
                    i2 -= c2970a.f10468c;
                    c2970a = this.f10465d;
                } else {
                    i2 -= 8;
                }
            }
        }
        while (i2 > 0) {
            C2970a c2970a2 = c2970a.f10466a[(i << (8 - i2)) & 255];
            if (c2970a2.f10466a != null || c2970a2.f10468c > i2) {
                break;
            }
            byteArrayOutputStream.write(c2970a2.f10467b);
            i2 -= c2970a2.f10468c;
            c2970a = this.f10465d;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: b */
    private void m2602b() {
        int i = 0;
        while (true) {
            byte[] bArr = f10463b;
            if (i >= bArr.length) {
                return;
            }
            m2606a(i, f10462a[i], bArr[i]);
            i++;
        }
    }

    /* renamed from: a */
    private void m2606a(int i, int i2, byte b) {
        C2970a c2970a = new C2970a(i, b);
        C2970a c2970a2 = this.f10465d;
        while (b > 8) {
            b = (byte) (b - 8);
            int i3 = (i2 >>> b) & 255;
            if (c2970a2.f10466a == null) {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
            if (c2970a2.f10466a[i3] == null) {
                c2970a2.f10466a[i3] = new C2970a();
            }
            c2970a2 = c2970a2.f10466a[i3];
        }
        int i4 = 8 - b;
        int i5 = (i2 << i4) & 255;
        int i6 = 1 << i4;
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            c2970a2.f10466a[i7] = c2970a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Huffman.java */
    /* renamed from: okhttp3.internal.http2.i$a */
    /* loaded from: classes2.dex */
    public static final class C2970a {

        /* renamed from: a */
        final C2970a[] f10466a;

        /* renamed from: b */
        final int f10467b;

        /* renamed from: c */
        final int f10468c;

        C2970a() {
            this.f10466a = new C2970a[256];
            this.f10467b = 0;
            this.f10468c = 0;
        }

        C2970a(int i, int i2) {
            this.f10466a = null;
            this.f10467b = i;
            int i3 = i2 & 7;
            this.f10468c = i3 == 0 ? 8 : i3;
        }
    }
}
