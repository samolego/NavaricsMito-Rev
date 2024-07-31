package org.mp4parser;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import org.mp4parser.support.DoNotParseDetail;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

@DoNotParseDetail
/* renamed from: org.mp4parser.e */
/* loaded from: classes2.dex */
public class IsoFile extends BasicContainer implements Closeable {

    /* renamed from: a */
    private static InterfaceC3153b f12102a = C3154c.m262a(IsoFile.class);

    /* renamed from: b */
    private ReadableByteChannel f12103b;

    /* renamed from: a */
    public static byte[] m524a(String str) {
        byte[] bArr = new byte[4];
        if (str != null) {
            for (int i = 0; i < Math.min(4, str.length()); i++) {
                bArr[i] = (byte) str.charAt(i);
            }
        }
        return bArr;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f12103b.close();
    }

    @Override // org.mp4parser.BasicContainer
    public String toString() {
        return "model(" + this.f12103b.toString() + ")";
    }
}
