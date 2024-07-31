package org.mp4parser.p144a;

import java.nio.ByteBuffer;

/* renamed from: org.mp4parser.a.e */
/* loaded from: classes2.dex */
public final class IsoTypeReaderVariable {
    /* renamed from: a */
    public static long m727a(ByteBuffer byteBuffer, int i) {
        if (i != 8) {
            switch (i) {
                case 1:
                    return IsoTypeReader.m734d(byteBuffer);
                case 2:
                    return IsoTypeReader.m735c(byteBuffer);
                case 3:
                    return IsoTypeReader.m736b(byteBuffer);
                case 4:
                    return IsoTypeReader.m738a(byteBuffer);
                default:
                    throw new RuntimeException("I don't know how to read " + i + " bytes");
            }
        }
        return IsoTypeReader.m733e(byteBuffer);
    }
}
