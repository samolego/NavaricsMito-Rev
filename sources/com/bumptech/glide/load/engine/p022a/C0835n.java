package com.bumptech.glide.load.engine.p022a;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.util.C0791i;
import com.senseplay.sdk.tool.IniEditor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

@RequiresApi(19)
/* renamed from: com.bumptech.glide.load.engine.a.n */
/* loaded from: classes.dex */
public class SizeConfigStrategy implements LruPoolStrategy {

    /* renamed from: a */
    private static final Bitmap.Config[] f795a;

    /* renamed from: b */
    private static final Bitmap.Config[] f796b;

    /* renamed from: c */
    private static final Bitmap.Config[] f797c;

    /* renamed from: d */
    private static final Bitmap.Config[] f798d;

    /* renamed from: e */
    private static final Bitmap.Config[] f799e;

    /* renamed from: f */
    private final C0699b f800f = new C0699b();

    /* renamed from: g */
    private final GroupedLinkedMap<C0698a, Bitmap> f801g = new GroupedLinkedMap<>();

    /* renamed from: h */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f802h = new HashMap();

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, configArr.length + 1);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f795a = configArr;
        f796b = f795a;
        f797c = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f798d = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f799e = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    @Override // com.bumptech.glide.load.engine.p022a.LruPoolStrategy
    /* renamed from: a */
    public void mo12161a(Bitmap bitmap) {
        C0698a m12151a = this.f800f.m12151a(C0791i.m11568a(bitmap), bitmap.getConfig());
        this.f801g.m12215a(m12151a, bitmap);
        NavigableMap<Integer, Integer> m12162a = m12162a(bitmap.getConfig());
        Integer num = (Integer) m12162a.get(Integer.valueOf(m12151a.f804a));
        m12162a.put(Integer.valueOf(m12151a.f804a), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.p022a.LruPoolStrategy
    @Nullable
    /* renamed from: a */
    public Bitmap mo12164a(int i, int i2, Bitmap.Config config) {
        C0698a m12158b = m12158b(C0791i.m11570a(i, i2, config), config);
        Bitmap m12216a = this.f801g.m12216a((GroupedLinkedMap<C0698a, Bitmap>) m12158b);
        if (m12216a != null) {
            m12160a(Integer.valueOf(m12158b.f804a), m12216a);
            m12216a.reconfigure(i, i2, m12216a.getConfig() != null ? m12216a.getConfig() : Bitmap.Config.ARGB_8888);
        }
        return m12216a;
    }

    /* renamed from: b */
    private C0698a m12158b(int i, Bitmap.Config config) {
        Bitmap.Config[] m12157b;
        C0698a m12151a = this.f800f.m12151a(i, config);
        for (Bitmap.Config config2 : m12157b(config)) {
            Integer ceilingKey = m12162a(config2).ceilingKey(Integer.valueOf(i));
            if (ceilingKey != null && ceilingKey.intValue() <= i * 8) {
                if (ceilingKey.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return m12151a;
                        }
                    } else if (config2.equals(config)) {
                        return m12151a;
                    }
                }
                this.f800f.m12222a(m12151a);
                return this.f800f.m12151a(ceilingKey.intValue(), config2);
            }
        }
        return m12151a;
    }

    @Override // com.bumptech.glide.load.engine.p022a.LruPoolStrategy
    @Nullable
    /* renamed from: a */
    public Bitmap mo12165a() {
        Bitmap m12218a = this.f801g.m12218a();
        if (m12218a != null) {
            m12160a(Integer.valueOf(C0791i.m11568a(m12218a)), m12218a);
        }
        return m12218a;
    }

    /* renamed from: a */
    private void m12160a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> m12162a = m12162a(bitmap.getConfig());
        Integer num2 = (Integer) m12162a.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + mo12156b(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            m12162a.remove(num);
        } else {
            m12162a.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    /* renamed from: a */
    private NavigableMap<Integer, Integer> m12162a(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f802h.get(config);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f802h.put(config, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    @Override // com.bumptech.glide.load.engine.p022a.LruPoolStrategy
    /* renamed from: b */
    public String mo12156b(Bitmap bitmap) {
        return m12163a(C0791i.m11568a(bitmap), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.p022a.LruPoolStrategy
    /* renamed from: b */
    public String mo12159b(int i, int i2, Bitmap.Config config) {
        return m12163a(C0791i.m11570a(i, i2, config), config);
    }

    @Override // com.bumptech.glide.load.engine.p022a.LruPoolStrategy
    /* renamed from: c */
    public int mo12155c(Bitmap bitmap) {
        return C0791i.m11568a(bitmap);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f801g);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f802h.entrySet()) {
            sb.append(entry.getKey());
            sb.append(IniEditor.Section.HEADER_START);
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f802h.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.a.n$b */
    /* loaded from: classes.dex */
    public static class C0699b extends BaseKeyPool<C0698a> {
        C0699b() {
        }

        /* renamed from: a */
        public C0698a m12151a(int i, Bitmap.Config config) {
            C0698a c = m12221c();
            c.m12153a(i, config);
            return c;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.p022a.BaseKeyPool
        /* renamed from: a */
        public C0698a mo12150b() {
            return new C0698a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.a.n$a */
    /* loaded from: classes.dex */
    public static final class C0698a implements Poolable {

        /* renamed from: a */
        int f804a;

        /* renamed from: b */
        private final C0699b f805b;

        /* renamed from: c */
        private Bitmap.Config f806c;

        public C0698a(C0699b c0699b) {
            this.f805b = c0699b;
        }

        /* renamed from: a */
        public void m12153a(int i, Bitmap.Config config) {
            this.f804a = i;
            this.f806c = config;
        }

        @Override // com.bumptech.glide.load.engine.p022a.Poolable
        /* renamed from: a */
        public void mo12154a() {
            this.f805b.m12222a(this);
        }

        public String toString() {
            return SizeConfigStrategy.m12163a(this.f804a, this.f806c);
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0698a) {
                C0698a c0698a = (C0698a) obj;
                return this.f804a == c0698a.f804a && C0791i.m11566a(this.f806c, c0698a.f806c);
            }
            return false;
        }

        public int hashCode() {
            int i = this.f804a * 31;
            Bitmap.Config config = this.f806c;
            return i + (config != null ? config.hashCode() : 0);
        }
    }

    /* renamed from: a */
    static String m12163a(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    /* renamed from: b */
    private static Bitmap.Config[] m12157b(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f796b;
        }
        switch (C06971.f803a[config.ordinal()]) {
            case 1:
                return f795a;
            case 2:
                return f797c;
            case 3:
                return f798d;
            case 4:
                return f799e;
            default:
                return new Bitmap.Config[]{config};
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    /* renamed from: com.bumptech.glide.load.engine.a.n$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C06971 {

        /* renamed from: a */
        static final /* synthetic */ int[] f803a = new int[Bitmap.Config.values().length];

        static {
            try {
                f803a[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f803a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f803a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f803a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
