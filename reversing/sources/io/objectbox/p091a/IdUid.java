package io.objectbox.p091a;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Struct;

/* renamed from: io.objectbox.a.a */
/* loaded from: classes2.dex */
public final class IdUid extends Struct {
    /* renamed from: a */
    public static int m3413a(FlatBufferBuilder flatBufferBuilder, long j, long j2) {
        flatBufferBuilder.prep(8, 16);
        flatBufferBuilder.putLong(j2);
        flatBufferBuilder.pad(4);
        flatBufferBuilder.putInt((int) j);
        return flatBufferBuilder.offset();
    }
}
