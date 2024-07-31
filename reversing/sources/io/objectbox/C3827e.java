package io.objectbox;

import com.google.flatbuffers.FlatBufferBuilder;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.p091a.C2821b;
import io.objectbox.p091a.IdUid;
import io.objectbox.p091a.ModelEntity;
import io.objectbox.p091a.ModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

@Internal
/* renamed from: io.objectbox.e */
/* loaded from: classes2.dex */
public class ModelBuilder {

    /* renamed from: a */
    final FlatBufferBuilder f9497a = new FlatBufferBuilder();

    /* renamed from: b */
    final List<Integer> f9498b = new ArrayList();

    /* renamed from: c */
    long f9499c = 1;

    /* renamed from: d */
    Integer f9500d;

    /* renamed from: e */
    Long f9501e;

    /* renamed from: f */
    Integer f9502f;

    /* renamed from: g */
    Long f9503g;

    /* renamed from: h */
    Integer f9504h;

    /* renamed from: i */
    Long f9505i;

    /* compiled from: ModelBuilder.java */
    /* renamed from: io.objectbox.e$b */
    /* loaded from: classes2.dex */
    public class C2831b {

        /* renamed from: a */
        boolean f9517a;

        /* renamed from: c */
        private final int f9519c;

        /* renamed from: d */
        private final int f9520d;

        /* renamed from: e */
        private final int f9521e;

        /* renamed from: f */
        private final int f9522f;

        /* renamed from: g */
        private int f9523g;

        /* renamed from: h */
        private int f9524h;

        /* renamed from: i */
        private int f9525i;

        /* renamed from: j */
        private long f9526j;

        /* renamed from: k */
        private int f9527k;

        /* renamed from: l */
        private long f9528l;

        /* renamed from: m */
        private int f9529m;

        C2831b(String str, String str2, @Nullable String str3, @Nullable int i) {
            this.f9519c = i;
            this.f9521e = ModelBuilder.this.f9497a.createString(str);
            this.f9522f = str2 != null ? ModelBuilder.this.f9497a.createString(str2) : 0;
            this.f9520d = str3 != null ? ModelBuilder.this.f9497a.createString(str3) : 0;
        }

        /* renamed from: a */
        public C2831b m3326a(int i, long j) {
            m3325b();
            this.f9525i = i;
            this.f9526j = j;
            return this;
        }

        /* renamed from: b */
        public C2831b m3324b(int i, long j) {
            m3325b();
            this.f9527k = i;
            this.f9528l = j;
            return this;
        }

        /* renamed from: a */
        public C2831b m3327a(int i) {
            m3325b();
            this.f9524h = i;
            return this;
        }

        /* renamed from: b */
        private void m3325b() {
            if (this.f9517a) {
                throw new IllegalStateException("Already finished");
            }
        }

        /* renamed from: a */
        public int m3328a() {
            m3325b();
            this.f9517a = true;
            ModelProperty.m3395a(ModelBuilder.this.f9497a);
            ModelProperty.m3391b(ModelBuilder.this.f9497a, this.f9521e);
            if (this.f9522f != 0) {
                ModelProperty.m3387e(ModelBuilder.this.f9497a, this.f9522f);
            }
            if (this.f9520d != 0) {
                ModelProperty.m3386f(ModelBuilder.this.f9497a, this.f9520d);
            }
            if (this.f9523g != 0) {
                ModelProperty.m3385g(ModelBuilder.this.f9497a, this.f9523g);
            }
            if (this.f9525i != 0) {
                ModelProperty.m3394a(ModelBuilder.this.f9497a, IdUid.m3413a(ModelBuilder.this.f9497a, this.f9525i, this.f9526j));
            }
            if (this.f9527k != 0) {
                ModelProperty.m3388d(ModelBuilder.this.f9497a, IdUid.m3413a(ModelBuilder.this.f9497a, this.f9527k, this.f9528l));
            }
            if (this.f9529m > 0) {
                ModelProperty.m3390b(ModelBuilder.this.f9497a, this.f9529m);
            }
            ModelProperty.m3389c(ModelBuilder.this.f9497a, this.f9519c);
            if (this.f9524h != 0) {
                ModelProperty.m3393a(ModelBuilder.this.f9497a, this.f9524h);
            }
            return ModelProperty.m3392b(ModelBuilder.this.f9497a);
        }
    }

    /* compiled from: ModelBuilder.java */
    /* renamed from: io.objectbox.e$a */
    /* loaded from: classes2.dex */
    public class C2830a {

        /* renamed from: a */
        final String f9506a;

        /* renamed from: b */
        final List<Integer> f9507b = new ArrayList();

        /* renamed from: c */
        final List<Integer> f9508c = new ArrayList();

        /* renamed from: d */
        Integer f9509d;

        /* renamed from: e */
        Long f9510e;

        /* renamed from: f */
        Integer f9511f;

        /* renamed from: g */
        Integer f9512g;

        /* renamed from: h */
        Long f9513h;

        /* renamed from: i */
        C2831b f9514i;

        /* renamed from: j */
        boolean f9515j;

        C2830a(String str) {
            this.f9506a = str;
        }

        /* renamed from: a */
        public C2830a m3335a(int i, long j) {
            m3329c();
            this.f9509d = Integer.valueOf(i);
            this.f9510e = Long.valueOf(j);
            return this;
        }

        /* renamed from: b */
        public C2830a m3330b(int i, long j) {
            m3329c();
            this.f9512g = Integer.valueOf(i);
            this.f9513h = Long.valueOf(j);
            return this;
        }

        /* renamed from: a */
        public C2830a m3336a(int i) {
            this.f9511f = Integer.valueOf(i);
            return this;
        }

        /* renamed from: c */
        private void m3329c() {
            if (this.f9515j) {
                throw new IllegalStateException("Already finished");
            }
        }

        /* renamed from: a */
        public C2831b m3334a(String str, int i) {
            return m3333a(str, null, i);
        }

        /* renamed from: a */
        public C2831b m3333a(String str, @Nullable String str2, int i) {
            return m3332a(str, str2, null, i);
        }

        /* renamed from: a */
        public C2831b m3332a(String str, @Nullable String str2, @Nullable String str3, int i) {
            m3329c();
            m3337a();
            this.f9514i = new C2831b(str, str2, str3, i);
            return this.f9514i;
        }

        /* renamed from: a */
        void m3337a() {
            C2831b c2831b = this.f9514i;
            if (c2831b != null) {
                this.f9507b.add(Integer.valueOf(c2831b.m3328a()));
                this.f9514i = null;
            }
        }

        /* renamed from: b */
        public ModelBuilder m3331b() {
            m3329c();
            m3337a();
            this.f9515j = true;
            int createString = ModelBuilder.this.f9497a.createString(this.f9506a);
            int m3340a = ModelBuilder.this.m3340a(this.f9507b);
            int m3340a2 = this.f9508c.isEmpty() ? 0 : ModelBuilder.this.m3340a(this.f9508c);
            ModelEntity.m3403a(ModelBuilder.this.f9497a);
            ModelEntity.m3399b(ModelBuilder.this.f9497a, createString);
            ModelEntity.m3398c(ModelBuilder.this.f9497a, m3340a);
            if (m3340a2 != 0) {
                ModelEntity.m3396e(ModelBuilder.this.f9497a, m3340a2);
            }
            if (this.f9509d != null && this.f9510e != null) {
                ModelEntity.m3402a(ModelBuilder.this.f9497a, IdUid.m3413a(ModelBuilder.this.f9497a, this.f9509d.intValue(), this.f9510e.longValue()));
            }
            if (this.f9512g != null) {
                ModelEntity.m3397d(ModelBuilder.this.f9497a, IdUid.m3413a(ModelBuilder.this.f9497a, this.f9512g.intValue(), this.f9513h.longValue()));
            }
            if (this.f9511f != null) {
                ModelEntity.m3401a(ModelBuilder.this.f9497a, this.f9511f.intValue());
            }
            ModelBuilder.this.f9498b.add(Integer.valueOf(ModelEntity.m3400b(ModelBuilder.this.f9497a)));
            return ModelBuilder.this;
        }
    }

    /* renamed from: a */
    int m3340a(List<Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = list.get(i).intValue();
        }
        return this.f9497a.createVectorOfTables(iArr);
    }

    /* renamed from: a */
    public C2830a m3341a(String str) {
        return new C2830a(str);
    }

    /* renamed from: a */
    public ModelBuilder m3342a(int i, long j) {
        this.f9500d = Integer.valueOf(i);
        this.f9501e = Long.valueOf(j);
        return this;
    }

    /* renamed from: b */
    public ModelBuilder m3339b(int i, long j) {
        this.f9502f = Integer.valueOf(i);
        this.f9503g = Long.valueOf(j);
        return this;
    }

    /* renamed from: c */
    public ModelBuilder m3338c(int i, long j) {
        this.f9504h = Integer.valueOf(i);
        this.f9505i = Long.valueOf(j);
        return this;
    }

    /* renamed from: a */
    public byte[] m3343a() {
        int createString = this.f9497a.createString("default");
        int m3340a = m3340a(this.f9498b);
        C2821b.m3412a(this.f9497a);
        C2821b.m3411a(this.f9497a, createString);
        C2821b.m3410a(this.f9497a, 2L);
        C2821b.m3407b(this.f9497a, 1L);
        C2821b.m3408b(this.f9497a, m3340a);
        Integer num = this.f9500d;
        if (num != null) {
            C2821b.m3406c(this.f9497a, IdUid.m3413a(this.f9497a, num.intValue(), this.f9501e.longValue()));
        }
        Integer num2 = this.f9502f;
        if (num2 != null) {
            C2821b.m3405d(this.f9497a, IdUid.m3413a(this.f9497a, num2.intValue(), this.f9503g.longValue()));
        }
        Integer num3 = this.f9504h;
        if (num3 != null) {
            C2821b.m3404e(this.f9497a, IdUid.m3413a(this.f9497a, num3.intValue(), this.f9505i.longValue()));
        }
        this.f9497a.finish(C2821b.m3409b(this.f9497a));
        return this.f9497a.sizedByteArray();
    }
}
