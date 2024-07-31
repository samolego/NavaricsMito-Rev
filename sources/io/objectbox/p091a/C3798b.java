package io.objectbox.p091a;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

/* compiled from: Model.java */
/* renamed from: io.objectbox.a.b */
/* loaded from: classes2.dex */
public final class C2821b extends Table {
    /* renamed from: a */
    public static void m3412a(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(8);
    }

    /* renamed from: a */
    public static void m3410a(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(0, (int) j, 0);
    }

    /* renamed from: a */
    public static void m3411a(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    /* renamed from: b */
    public static void m3407b(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(2, j, 0L);
    }

    /* renamed from: b */
    public static void m3408b(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(3, i, 0);
    }

    /* renamed from: c */
    public static void m3406c(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addStruct(4, i, 0);
    }

    /* renamed from: d */
    public static void m3405d(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addStruct(5, i, 0);
    }

    /* renamed from: e */
    public static void m3404e(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addStruct(7, i, 0);
    }

    /* renamed from: b */
    public static int m3409b(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }
}
