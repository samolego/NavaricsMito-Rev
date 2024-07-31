package com.navatics.miya.serializers;

import com.navatics.miya.Miya;
import com.navatics.miya.MiyaSerializable;
import com.navatics.miya.Serializer;
import com.navatics.miya.p059a.Output;
import java.util.Date;

/* renamed from: com.navatics.miya.serializers.b */
/* loaded from: classes.dex */
public class DefaultSerializers {

    /* compiled from: DefaultSerializers.java */
    /* renamed from: com.navatics.miya.serializers.b$m */
    /* loaded from: classes.dex */
    public static class C2031m extends ImmutableSerializer {
        @Override // com.navatics.miya.Serializer
        /* renamed from: a */
        public void mo6619a(Miya miya, Output output, Object obj) {
        }
    }

    /* compiled from: DefaultSerializers.java */
    /* renamed from: com.navatics.miya.serializers.b$a */
    /* loaded from: classes.dex */
    public static class C2019a extends ImmutableSerializer<Boolean> {
        @Override // com.navatics.miya.Serializer
        /* renamed from: a */
        public void mo6619a(Miya miya, Output output, Boolean bool) {
            output.m6752a(bool.booleanValue());
        }
    }

    /* compiled from: DefaultSerializers.java */
    /* renamed from: com.navatics.miya.serializers.b$b */
    /* loaded from: classes.dex */
    public static class C2020b extends ImmutableSerializer<Byte> {
        @Override // com.navatics.miya.Serializer
        /* renamed from: a */
        public void mo6619a(Miya miya, Output output, Byte b) {
            output.m6763a(b.byteValue());
        }
    }

    /* compiled from: DefaultSerializers.java */
    /* renamed from: com.navatics.miya.serializers.b$c */
    /* loaded from: classes.dex */
    public static class C2021c extends ImmutableSerializer<Character> {
        @Override // com.navatics.miya.Serializer
        /* renamed from: a */
        public void mo6619a(Miya miya, Output output, Character ch) {
            output.m6762a(ch.charValue());
        }
    }

    /* compiled from: DefaultSerializers.java */
    /* renamed from: com.navatics.miya.serializers.b$k */
    /* loaded from: classes.dex */
    public static class C2029k extends ImmutableSerializer<Short> {
        @Override // com.navatics.miya.Serializer
        /* renamed from: a */
        public void mo6619a(Miya miya, Output output, Short sh) {
            output.m6745d(sh.shortValue());
        }
    }

    /* compiled from: DefaultSerializers.java */
    /* renamed from: com.navatics.miya.serializers.b$h */
    /* loaded from: classes.dex */
    public static class C2026h extends ImmutableSerializer<Integer> {
        @Override // com.navatics.miya.Serializer
        /* renamed from: a */
        public void mo6619a(Miya miya, Output output, Integer num) {
            output.m6746c(num.intValue());
        }
    }

    /* compiled from: DefaultSerializers.java */
    /* renamed from: com.navatics.miya.serializers.b$i */
    /* loaded from: classes.dex */
    public static class C2027i extends ImmutableSerializer<Long> {
        @Override // com.navatics.miya.Serializer
        /* renamed from: a */
        public void mo6619a(Miya miya, Output output, Long l) {
            output.m6757a(l.longValue());
        }
    }

    /* compiled from: DefaultSerializers.java */
    /* renamed from: com.navatics.miya.serializers.b$g */
    /* loaded from: classes.dex */
    public static class C2025g extends ImmutableSerializer<Float> {
        @Override // com.navatics.miya.Serializer
        /* renamed from: a */
        public void mo6619a(Miya miya, Output output, Float f) {
            output.m6760a(f.floatValue());
        }
    }

    /* compiled from: DefaultSerializers.java */
    /* renamed from: com.navatics.miya.serializers.b$f */
    /* loaded from: classes.dex */
    public static class C2024f extends ImmutableSerializer<Double> {
        @Override // com.navatics.miya.Serializer
        /* renamed from: a */
        public void mo6619a(Miya miya, Output output, Double d) {
            output.m6761a(d.doubleValue());
        }
    }

    /* compiled from: DefaultSerializers.java */
    /* renamed from: com.navatics.miya.serializers.b$l */
    /* loaded from: classes.dex */
    public static class C2030l extends ImmutableSerializer<String> {
        public C2030l() {
            m6648a(true);
        }

        @Override // com.navatics.miya.Serializer
        /* renamed from: a */
        public void mo6619a(Miya miya, Output output, String str) {
            output.m6755a(str);
        }
    }

    /* compiled from: DefaultSerializers.java */
    /* renamed from: com.navatics.miya.serializers.b$d */
    /* loaded from: classes.dex */
    public static class C2022d extends ImmutableSerializer<Class> {
        public C2022d() {
            m6648a(true);
        }

        @Override // com.navatics.miya.Serializer
        /* renamed from: a */
        public void mo6619a(Miya miya, Output output, Class cls) {
            miya.m6743a(output, cls);
            output.m6748b((cls == null || !cls.isPrimitive()) ? 0 : 1);
        }
    }

    /* compiled from: DefaultSerializers.java */
    /* renamed from: com.navatics.miya.serializers.b$e */
    /* loaded from: classes.dex */
    public static class C2023e extends Serializer<Date> {
        @Override // com.navatics.miya.Serializer
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo6619a(Miya miya, Output output, Date date) {
            output.m6756a(date.getTime(), true);
        }
    }

    /* compiled from: DefaultSerializers.java */
    /* renamed from: com.navatics.miya.serializers.b$j */
    /* loaded from: classes.dex */
    public static class C2028j extends Serializer<MiyaSerializable> {
        @Override // com.navatics.miya.Serializer
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo6619a(Miya miya, Output output, MiyaSerializable miyaSerializable) {
            miyaSerializable.m6656a(miya, output);
        }
    }
}
