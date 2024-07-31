package com.squareup.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.squareup.picasso.u */
/* loaded from: classes2.dex */
public class Stats {

    /* renamed from: a */
    final HandlerThread f7028a = new HandlerThread("Picasso-Stats", 10);

    /* renamed from: b */
    final Cache f7029b;

    /* renamed from: c */
    final Handler f7030c;

    /* renamed from: d */
    long f7031d;

    /* renamed from: e */
    long f7032e;

    /* renamed from: f */
    long f7033f;

    /* renamed from: g */
    long f7034g;

    /* renamed from: h */
    long f7035h;

    /* renamed from: i */
    long f7036i;

    /* renamed from: j */
    long f7037j;

    /* renamed from: k */
    long f7038k;

    /* renamed from: l */
    int f7039l;

    /* renamed from: m */
    int f7040m;

    /* renamed from: n */
    int f7041n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Stats(Cache cache) {
        this.f7029b = cache;
        this.f7028a.start();
        C2344aa.m5764a(this.f7028a.getLooper());
        this.f7030c = new HandlerC2369a(this.f7028a.getLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m5630a(Bitmap bitmap) {
        m5629a(bitmap, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m5625b(Bitmap bitmap) {
        m5629a(bitmap, 3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m5631a(long j) {
        Handler handler = this.f7030c;
        handler.sendMessage(handler.obtainMessage(4, Long.valueOf(j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m5633a() {
        this.f7030c.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m5627b() {
        this.f7030c.sendEmptyMessage(1);
    }

    /* renamed from: c */
    void m5624c() {
        this.f7031d++;
    }

    /* renamed from: d */
    void m5622d() {
        this.f7032e++;
    }

    /* renamed from: a */
    void m5628a(Long l) {
        this.f7039l++;
        this.f7033f += l.longValue();
        this.f7036i = m5632a(this.f7039l, this.f7033f);
    }

    /* renamed from: b */
    void m5626b(long j) {
        this.f7040m++;
        this.f7034g += j;
        this.f7037j = m5632a(this.f7040m, this.f7034g);
    }

    /* renamed from: c */
    void m5623c(long j) {
        this.f7041n++;
        this.f7035h += j;
        this.f7038k = m5632a(this.f7040m, this.f7035h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public StatsSnapshot m5621e() {
        return new StatsSnapshot(this.f7029b.mo5683b(), this.f7029b.mo5687a(), this.f7031d, this.f7032e, this.f7033f, this.f7034g, this.f7035h, this.f7036i, this.f7037j, this.f7038k, this.f7039l, this.f7040m, this.f7041n, System.currentTimeMillis());
    }

    /* renamed from: a */
    private void m5629a(Bitmap bitmap, int i) {
        int m5765a = C2344aa.m5765a(bitmap);
        Handler handler = this.f7030c;
        handler.sendMessage(handler.obtainMessage(i, m5765a, 0));
    }

    /* renamed from: a */
    private static long m5632a(int i, long j) {
        return j / i;
    }

    /* compiled from: Stats.java */
    /* renamed from: com.squareup.picasso.u$a */
    /* loaded from: classes2.dex */
    private static class HandlerC2369a extends Handler {

        /* renamed from: a */
        private final Stats f7042a;

        public HandlerC2369a(Looper looper, Stats stats) {
            super(looper);
            this.f7042a = stats;
        }

        @Override // android.os.Handler
        public void handleMessage(final Message message) {
            switch (message.what) {
                case 0:
                    this.f7042a.m5624c();
                    return;
                case 1:
                    this.f7042a.m5622d();
                    return;
                case 2:
                    this.f7042a.m5626b(message.arg1);
                    return;
                case 3:
                    this.f7042a.m5623c(message.arg1);
                    return;
                case 4:
                    this.f7042a.m5628a((Long) message.obj);
                    return;
                default:
                    Picasso.f6848a.post(new Runnable() { // from class: com.squareup.picasso.u.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new AssertionError("Unhandled stats message." + message.what);
                        }
                    });
                    return;
            }
        }
    }
}
