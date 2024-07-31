package org.mp4parser.p144a;

import java.nio.ByteBuffer;

/* renamed from: org.mp4parser.a.g */
/* loaded from: classes2.dex */
public final class IsoTypeWriterVariable {
    /* renamed from: a */
    public static void m717a(long j, ByteBuffer byteBuffer, int i) {
        if (i != 8) {
            switch (i) {
                case 1:
                    IsoTypeWriter.m718c(byteBuffer, (int) (j & 255));
                    return;
                case 2:
                    IsoTypeWriter.m721b(byteBuffer, (int) (j & 65535));
                    return;
                case 3:
                    IsoTypeWriter.m725a(byteBuffer, (int) (j & 16777215));
                    return;
                case 4:
                    IsoTypeWriter.m720b(byteBuffer, j);
                    return;
                default:
                    throw new RuntimeException("I don't know how to read " + i + " bytes");
            }
        }
        IsoTypeWriter.m724a(byteBuffer, j);
    }
}
