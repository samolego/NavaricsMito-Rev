package org.mp4parser.p133a;

import java.nio.ByteBuffer;

/* compiled from: IsoTypeReaderVariable.java */
/* renamed from: org.mp4parser.a.e, reason: use source file name */
/* loaded from: classes2.dex */
public final class IsoTypeReaderVariable {
    /* renamed from: a */
    public static long m12086a(ByteBuffer byteBuffer, int i) {
        if (i != 8) {
            switch (i) {
                case 1:
                    return IsoTypeReader.m12079d(byteBuffer);
                case 2:
                    return IsoTypeReader.m12078c(byteBuffer);
                case 3:
                    return IsoTypeReader.m12077b(byteBuffer);
                case 4:
                    return IsoTypeReader.m12075a(byteBuffer);
                default:
                    throw new RuntimeException("I don't know how to read " + i + " bytes");
            }
        }
        return IsoTypeReader.m12080e(byteBuffer);
    }
}