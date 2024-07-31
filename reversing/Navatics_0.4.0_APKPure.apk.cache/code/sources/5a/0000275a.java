package org.mp4parser.p133a;

import java.nio.ByteBuffer;

/* compiled from: IsoTypeWriterVariable.java */
/* renamed from: org.mp4parser.a.g, reason: use source file name */
/* loaded from: classes2.dex */
public final class IsoTypeWriterVariable {
    /* renamed from: a */
    public static void m12096a(long j, ByteBuffer byteBuffer, int i) {
        if (i != 8) {
            switch (i) {
                case 1:
                    IsoTypeWriter.m12095c(byteBuffer, (int) (j & 255));
                    return;
                case 2:
                    IsoTypeWriter.m12092b(byteBuffer, (int) (j & 65535));
                    return;
                case 3:
                    IsoTypeWriter.m12088a(byteBuffer, (int) (j & 16777215));
                    return;
                case 4:
                    IsoTypeWriter.m12093b(byteBuffer, j);
                    return;
                default:
                    throw new RuntimeException("I don't know how to read " + i + " bytes");
            }
        }
        IsoTypeWriter.m12089a(byteBuffer, j);
    }
}