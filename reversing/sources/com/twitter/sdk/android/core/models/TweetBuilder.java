package com.twitter.sdk.android.core.models;

import java.util.List;

/* renamed from: com.twitter.sdk.android.core.models.o */
/* loaded from: classes2.dex */
public class TweetBuilder {

    /* renamed from: A */
    private String f8757A;

    /* renamed from: B */
    private List<Integer> f8758B;

    /* renamed from: C */
    private boolean f8759C;

    /* renamed from: D */
    private User f8760D;

    /* renamed from: E */
    private boolean f8761E;

    /* renamed from: F */
    private List<String> f8762F;

    /* renamed from: G */
    private String f8763G;

    /* renamed from: H */
    private Card f8764H;

    /* renamed from: a */
    private Coordinates f8765a;

    /* renamed from: b */
    private String f8766b;

    /* renamed from: c */
    private Object f8767c;

    /* renamed from: d */
    private TweetEntities f8768d;

    /* renamed from: e */
    private TweetEntities f8769e;

    /* renamed from: f */
    private Integer f8770f;

    /* renamed from: g */
    private boolean f8771g;

    /* renamed from: h */
    private String f8772h;

    /* renamed from: i */
    private long f8773i = -1;

    /* renamed from: j */
    private String f8774j;

    /* renamed from: k */
    private String f8775k;

    /* renamed from: l */
    private long f8776l;

    /* renamed from: m */
    private String f8777m;

    /* renamed from: n */
    private long f8778n;

    /* renamed from: o */
    private String f8779o;

    /* renamed from: p */
    private String f8780p;

    /* renamed from: q */
    private Place f8781q;

    /* renamed from: r */
    private boolean f8782r;

    /* renamed from: s */
    private Object f8783s;

    /* renamed from: t */
    private long f8784t;

    /* renamed from: u */
    private String f8785u;

    /* renamed from: v */
    private Tweet f8786v;

    /* renamed from: w */
    private int f8787w;

    /* renamed from: x */
    private boolean f8788x;

    /* renamed from: y */
    private Tweet f8789y;

    /* renamed from: z */
    private String f8790z;

    /* renamed from: a */
    public TweetBuilder m4243a(boolean z) {
        this.f8771g = z;
        return this;
    }

    /* renamed from: a */
    public TweetBuilder m4245a(long j) {
        this.f8773i = j;
        return this;
    }

    /* renamed from: a */
    public TweetBuilder m4244a(Tweet tweet) {
        this.f8765a = tweet.f8731a;
        this.f8766b = tweet.f8732b;
        this.f8767c = tweet.f8733c;
        this.f8768d = tweet.f8734d;
        this.f8769e = tweet.f8735e;
        this.f8770f = tweet.f8736f;
        this.f8771g = tweet.f8737g;
        this.f8772h = tweet.f8738h;
        this.f8773i = tweet.f8739i;
        this.f8774j = tweet.f8740j;
        this.f8775k = tweet.f8741k;
        this.f8776l = tweet.f8742l;
        this.f8777m = tweet.f8743m;
        this.f8778n = tweet.f8744n;
        this.f8779o = tweet.f8743m;
        this.f8780p = tweet.f8746p;
        this.f8781q = tweet.f8747q;
        this.f8782r = tweet.f8748r;
        this.f8783s = tweet.f8749s;
        this.f8784t = tweet.f8750t;
        this.f8785u = tweet.f8751u;
        this.f8786v = tweet.f8752v;
        this.f8787w = tweet.f8753w;
        this.f8788x = tweet.f8754x;
        this.f8789y = tweet.f8755y;
        this.f8790z = tweet.f8756z;
        this.f8757A = tweet.f8723A;
        this.f8758B = tweet.f8724B;
        this.f8759C = tweet.f8725C;
        this.f8760D = tweet.f8726D;
        this.f8761E = tweet.f8727E;
        this.f8762F = tweet.f8728F;
        this.f8763G = tweet.f8729G;
        this.f8764H = tweet.f8730H;
        return this;
    }

    /* renamed from: a */
    public Tweet m4246a() {
        return new Tweet(this.f8765a, this.f8766b, this.f8767c, this.f8768d, this.f8769e, this.f8770f, this.f8771g, this.f8772h, this.f8773i, this.f8774j, this.f8775k, this.f8776l, this.f8777m, this.f8778n, this.f8779o, this.f8780p, this.f8781q, this.f8782r, this.f8783s, this.f8784t, this.f8785u, this.f8786v, this.f8787w, this.f8788x, this.f8789y, this.f8790z, this.f8757A, this.f8758B, this.f8759C, this.f8760D, this.f8761E, this.f8762F, this.f8763G, this.f8764H);
    }
}
