package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.C2930c;
import okio.ByteString;

/* renamed from: okhttp3.internal.http2.c */
/* loaded from: classes2.dex */
public final class Http2 {

    /* renamed from: a */
    static final ByteString f10333a = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: d */
    private static final String[] f10336d = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: b */
    static final String[] f10334b = new String[64];

    /* renamed from: c */
    static final String[] f10335c = new String[256];

    static {
        int[] iArr;
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = f10335c;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = C2930c.m2886a("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = f10334b;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr2 = {1};
        strArr2[8] = "PADDED";
        for (int i3 : iArr2) {
            f10334b[i3 | 8] = f10334b[i3] + "|PADDED";
        }
        String[] strArr3 = f10334b;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        for (int i4 : new int[]{4, 32, 36}) {
            for (int i5 : iArr2) {
                int i6 = i5 | i4;
                f10334b[i6] = f10334b[i5] + '|' + f10334b[i4];
                f10334b[i6 | 8] = f10334b[i5] + '|' + f10334b[i4] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr4 = f10334b;
            if (i >= strArr4.length) {
                return;
            }
            if (strArr4[i] == null) {
                strArr4[i] = f10335c[i];
            }
            i++;
        }
    }

    private Http2() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static IllegalArgumentException m2722a(String str, Object... objArr) {
        throw new IllegalArgumentException(C2930c.m2886a(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static IOException m2720b(String str, Object... objArr) throws IOException {
        throw new IOException(C2930c.m2886a(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m2721a(boolean z, int i, int i2, byte b, byte b2) {
        String[] strArr = f10336d;
        String m2886a = b < strArr.length ? strArr[b] : C2930c.m2886a("0x%02x", Byte.valueOf(b));
        String m2723a = m2723a(b, b2);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = m2886a;
        objArr[4] = m2723a;
        return C2930c.m2886a("%s 0x%08x %5d %-13s %s", objArr);
    }

    /* renamed from: a */
    static String m2723a(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        switch (b) {
            case 2:
            case 3:
            case 7:
            case 8:
                return f10335c[b2];
            case 4:
            case 6:
                return b2 == 1 ? "ACK" : f10335c[b2];
            case 5:
            default:
                String[] strArr = f10334b;
                String str = b2 < strArr.length ? strArr[b2] : f10335c[b2];
                if (b != 5 || (b2 & 4) == 0) {
                    return (b != 0 || (b2 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
        }
    }
}
