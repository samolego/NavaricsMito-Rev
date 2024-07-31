package com.twitter.sdk.android.tweetui.internal.p069a;

/* compiled from: IntHashMap.java */
/* renamed from: com.twitter.sdk.android.tweetui.internal.a.b, reason: use source file name */
/* loaded from: classes2.dex */
public class IntHashMap {

    /* renamed from: a */
    private a[] f9103a;

    /* renamed from: b */
    private int f9104b;

    /* renamed from: c */
    private int f9105c;

    /* renamed from: d */
    private float f9106d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IntHashMap.java */
    /* renamed from: com.twitter.sdk.android.tweetui.internal.a.b$a */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        public final int f9107a;

        /* renamed from: b */
        public int f9108b;

        /* renamed from: c */
        public Object f9109c;

        /* renamed from: d */
        public a f9110d;

        protected a(int i, int i2, Object obj, a aVar) {
            this.f9107a = i;
            this.f9108b = i2;
            this.f9109c = obj;
            this.f9110d = aVar;
        }
    }

    public IntHashMap() {
        this(20, 0.75f);
    }

    public IntHashMap(int i, float f) {
        if (i < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + i);
        }
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Illegal Load: " + f);
        }
        i = i == 0 ? 1 : i;
        this.f9106d = f;
        this.f9103a = new a[i];
        this.f9105c = (int) (i * f);
    }

    /* renamed from: a */
    protected void m8899a() {
        a[] aVarArr = this.f9103a;
        int length = aVarArr.length;
        int i = (length * 2) + 1;
        a[] aVarArr2 = new a[i];
        this.f9105c = (int) (i * this.f9106d);
        this.f9103a = aVarArr2;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            a aVar = aVarArr[i2];
            while (aVar != null) {
                a aVar2 = aVar.f9110d;
                int i3 = (aVar.f9107a & Integer.MAX_VALUE) % i;
                aVar.f9110d = aVarArr2[i3];
                aVarArr2[i3] = aVar;
                aVar = aVar2;
            }
            length = i2;
        }
    }

    /* renamed from: a */
    public Object m8898a(int i, Object obj) {
        a[] aVarArr = this.f9103a;
        int i2 = Integer.MAX_VALUE & i;
        int length = i2 % aVarArr.length;
        for (a aVar = aVarArr[length]; aVar != null; aVar = aVar.f9110d) {
            if (aVar.f9107a == i) {
                Object obj2 = aVar.f9109c;
                aVar.f9109c = obj;
                return obj2;
            }
        }
        if (this.f9104b >= this.f9105c) {
            m8899a();
            aVarArr = this.f9103a;
            length = i2 % aVarArr.length;
        }
        aVarArr[length] = new a(i, i, obj, aVarArr[length]);
        this.f9104b++;
        return null;
    }
}