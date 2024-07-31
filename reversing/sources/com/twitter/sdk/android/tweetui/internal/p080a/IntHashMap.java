package com.twitter.sdk.android.tweetui.internal.p080a;

/* renamed from: com.twitter.sdk.android.tweetui.internal.a.b */
/* loaded from: classes2.dex */
public class IntHashMap {

    /* renamed from: a */
    private C2756a[] f9063a;

    /* renamed from: b */
    private int f9064b;

    /* renamed from: c */
    private int f9065c;

    /* renamed from: d */
    private float f9066d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IntHashMap.java */
    /* renamed from: com.twitter.sdk.android.tweetui.internal.a.b$a */
    /* loaded from: classes2.dex */
    public static class C2756a {

        /* renamed from: a */
        public final int f9067a;

        /* renamed from: b */
        public int f9068b;

        /* renamed from: c */
        public Object f9069c;

        /* renamed from: d */
        public C2756a f9070d;

        protected C2756a(int i, int i2, Object obj, C2756a c2756a) {
            this.f9067a = i;
            this.f9068b = i2;
            this.f9069c = obj;
            this.f9070d = c2756a;
        }
    }

    public IntHashMap() {
        this(20, 0.75f);
    }

    public IntHashMap(int i, float f) {
        if (i < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + i);
        } else if (f <= 0.0f) {
            throw new IllegalArgumentException("Illegal Load: " + f);
        } else {
            i = i == 0 ? 1 : i;
            this.f9066d = f;
            this.f9063a = new C2756a[i];
            this.f9065c = (int) (i * f);
        }
    }

    /* renamed from: a */
    protected void m3958a() {
        C2756a[] c2756aArr = this.f9063a;
        int length = c2756aArr.length;
        int i = (length * 2) + 1;
        C2756a[] c2756aArr2 = new C2756a[i];
        this.f9065c = (int) (i * this.f9066d);
        this.f9063a = c2756aArr2;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            C2756a c2756a = c2756aArr[i2];
            while (c2756a != null) {
                C2756a c2756a2 = c2756a.f9070d;
                int i3 = (c2756a.f9067a & Integer.MAX_VALUE) % i;
                c2756a.f9070d = c2756aArr2[i3];
                c2756aArr2[i3] = c2756a;
                c2756a = c2756a2;
            }
            length = i2;
        }
    }

    /* renamed from: a */
    public Object m3957a(int i, Object obj) {
        C2756a[] c2756aArr = this.f9063a;
        int i2 = Integer.MAX_VALUE & i;
        int length = i2 % c2756aArr.length;
        for (C2756a c2756a = c2756aArr[length]; c2756a != null; c2756a = c2756a.f9070d) {
            if (c2756a.f9067a == i) {
                Object obj2 = c2756a.f9069c;
                c2756a.f9069c = obj;
                return obj2;
            }
        }
        if (this.f9064b >= this.f9065c) {
            m3958a();
            c2756aArr = this.f9063a;
            length = i2 % c2756aArr.length;
        }
        c2756aArr[length] = new C2756a(i, i, obj, c2756aArr[length]);
        this.f9064b++;
        return null;
    }
}
