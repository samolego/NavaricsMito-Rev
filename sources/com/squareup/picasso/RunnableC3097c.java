package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.NetworkRequestHandler;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.squareup.picasso.c */
/* loaded from: classes2.dex */
public class BitmapHunter implements Runnable {

    /* renamed from: t */
    private static final Object f6898t = new Object();

    /* renamed from: u */
    private static final ThreadLocal<StringBuilder> f6899u = new ThreadLocal<StringBuilder>() { // from class: com.squareup.picasso.c.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    };

    /* renamed from: v */
    private static final AtomicInteger f6900v = new AtomicInteger();

    /* renamed from: w */
    private static final RequestHandler f6901w = new RequestHandler() { // from class: com.squareup.picasso.c.2
        @Override // com.squareup.picasso.RequestHandler
        /* renamed from: a */
        public boolean mo5635a(C2365q c2365q) {
            return true;
        }

        @Override // com.squareup.picasso.RequestHandler
        /* renamed from: a */
        public RequestHandler.C2368a mo5634a(C2365q c2365q, int i) throws IOException {
            throw new IllegalStateException("Unrecognized type of request: " + c2365q);
        }
    };

    /* renamed from: a */
    final int f6902a = f6900v.incrementAndGet();

    /* renamed from: b */
    final Picasso f6903b;

    /* renamed from: c */
    final Dispatcher f6904c;

    /* renamed from: d */
    final Cache f6905d;

    /* renamed from: e */
    final Stats f6906e;

    /* renamed from: f */
    final String f6907f;

    /* renamed from: g */
    final C2365q f6908g;

    /* renamed from: h */
    final int f6909h;

    /* renamed from: i */
    int f6910i;

    /* renamed from: j */
    final RequestHandler f6911j;

    /* renamed from: k */
    Action f6912k;

    /* renamed from: l */
    List<Action> f6913l;

    /* renamed from: m */
    Bitmap f6914m;

    /* renamed from: n */
    Future<?> f6915n;

    /* renamed from: o */
    Picasso.LoadedFrom f6916o;

    /* renamed from: p */
    Exception f6917p;

    /* renamed from: q */
    int f6918q;

    /* renamed from: r */
    int f6919r;

    /* renamed from: s */
    Picasso.Priority f6920s;

    /* renamed from: a */
    private static boolean m5735a(boolean z, int i, int i2, int i3, int i4) {
        return !z || i > i3 || i2 > i4;
    }

    BitmapHunter(Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action, RequestHandler requestHandler) {
        this.f6903b = picasso;
        this.f6904c = dispatcher;
        this.f6905d = cache;
        this.f6906e = stats;
        this.f6912k = action;
        this.f6907f = action.m5778e();
        this.f6908g = action.m5780c();
        this.f6920s = action.m5772k();
        this.f6909h = action.m5775h();
        this.f6910i = action.m5774i();
        this.f6911j = requestHandler;
        this.f6919r = requestHandler.mo5647a();
    }

    /* renamed from: a */
    static Bitmap m5737a(InputStream inputStream, C2365q c2365q) throws IOException {
        MarkableInputStream markableInputStream = new MarkableInputStream(inputStream);
        long m5682a = markableInputStream.m5682a(65536);
        BitmapFactory.Options m5641c = RequestHandler.m5641c(c2365q);
        boolean m5644a = RequestHandler.m5644a(m5641c);
        boolean m5748c = C2344aa.m5748c(markableInputStream);
        markableInputStream.m5681a(m5682a);
        if (m5748c) {
            byte[] m5750b = C2344aa.m5750b(markableInputStream);
            if (m5644a) {
                BitmapFactory.decodeByteArray(m5750b, 0, m5750b.length, m5641c);
                RequestHandler.m5645a(c2365q.f6984h, c2365q.f6985i, m5641c, c2365q);
            }
            return BitmapFactory.decodeByteArray(m5750b, 0, m5750b.length, m5641c);
        }
        if (m5644a) {
            BitmapFactory.decodeStream(markableInputStream, null, m5641c);
            RequestHandler.m5645a(c2365q.f6984h, c2365q.f6985i, m5641c, c2365q);
            markableInputStream.m5681a(m5682a);
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(markableInputStream, null, m5641c);
        if (decodeStream != null) {
            return decodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                try {
                    try {
                        m5739a(this.f6908g);
                        if (this.f6903b.f6859l) {
                            C2344aa.m5755a("Hunter", "executing", C2344aa.m5763a(this));
                        }
                        this.f6914m = m5742a();
                        if (this.f6914m == null) {
                            this.f6904c.m5697c(this);
                        } else {
                            this.f6904c.m5709a(this);
                        }
                    } catch (NetworkRequestHandler.ContentLengthException e) {
                        this.f6917p = e;
                        this.f6904c.m5701b(this);
                    } catch (OutOfMemoryError e2) {
                        StringWriter stringWriter = new StringWriter();
                        this.f6906e.m5621e().m5620a(new PrintWriter(stringWriter));
                        this.f6917p = new RuntimeException(stringWriter.toString(), e2);
                        this.f6904c.m5697c(this);
                    }
                } catch (Downloader.ResponseException e3) {
                    if (!e3.localCacheOnly || e3.responseCode != 504) {
                        this.f6917p = e3;
                    }
                    this.f6904c.m5697c(this);
                } catch (Exception e4) {
                    this.f6917p = e4;
                    this.f6904c.m5697c(this);
                }
            } catch (IOException e5) {
                this.f6917p = e5;
                this.f6904c.m5701b(this);
            }
        } finally {
            Thread.currentThread().setName("Picasso-Idle");
        }
    }

    /* renamed from: a */
    Bitmap m5742a() throws IOException {
        Bitmap bitmap;
        if (MemoryPolicy.shouldReadFromMemoryCache(this.f6909h)) {
            bitmap = this.f6905d.mo5685a(this.f6907f);
            if (bitmap != null) {
                this.f6906e.m5633a();
                this.f6916o = Picasso.LoadedFrom.MEMORY;
                if (this.f6903b.f6859l) {
                    C2344aa.m5754a("Hunter", "decoded", this.f6908g.m5670a(), "from cache");
                }
                return bitmap;
            }
        } else {
            bitmap = null;
        }
        this.f6908g.f6979c = this.f6919r == 0 ? NetworkPolicy.OFFLINE.index : this.f6910i;
        RequestHandler.C2368a mo5634a = this.f6911j.mo5634a(this.f6908g, this.f6910i);
        if (mo5634a != null) {
            this.f6916o = mo5634a.m5638c();
            this.f6918q = mo5634a.m5637d();
            bitmap = mo5634a.m5640a();
            if (bitmap == null) {
                InputStream m5639b = mo5634a.m5639b();
                try {
                    Bitmap m5737a = m5737a(m5639b, this.f6908g);
                    C2344aa.m5758a(m5639b);
                    bitmap = m5737a;
                } catch (Throwable th) {
                    C2344aa.m5758a(m5639b);
                    throw th;
                }
            }
        }
        if (bitmap != null) {
            if (this.f6903b.f6859l) {
                C2344aa.m5755a("Hunter", "decoded", this.f6908g.m5670a());
            }
            this.f6906e.m5630a(bitmap);
            if (this.f6908g.m5666e() || this.f6918q != 0) {
                synchronized (f6898t) {
                    if (this.f6908g.m5665f() || this.f6918q != 0) {
                        bitmap = m5738a(this.f6908g, bitmap, this.f6918q);
                        if (this.f6903b.f6859l) {
                            C2344aa.m5755a("Hunter", "transformed", this.f6908g.m5670a());
                        }
                    }
                    if (this.f6908g.m5664g()) {
                        bitmap = m5736a(this.f6908g.f6983g, bitmap);
                        if (this.f6903b.f6859l) {
                            C2344aa.m5754a("Hunter", "transformed", this.f6908g.m5670a(), "from custom transformations");
                        }
                    }
                }
                if (bitmap != null) {
                    this.f6906e.m5625b(bitmap);
                }
            }
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m5740a(Action action) {
        boolean z = this.f6903b.f6859l;
        C2365q c2365q = action.f6883b;
        if (this.f6912k == null) {
            this.f6912k = action;
            if (z) {
                List<Action> list = this.f6913l;
                if (list == null || list.isEmpty()) {
                    C2344aa.m5754a("Hunter", "joined", c2365q.m5670a(), "to empty hunter");
                    return;
                } else {
                    C2344aa.m5754a("Hunter", "joined", c2365q.m5670a(), C2344aa.m5762a(this, "to "));
                    return;
                }
            }
            return;
        }
        if (this.f6913l == null) {
            this.f6913l = new ArrayList(3);
        }
        this.f6913l.add(action);
        if (z) {
            C2344aa.m5754a("Hunter", "joined", c2365q.m5670a(), C2344aa.m5762a(this, "to "));
        }
        Picasso.Priority m5772k = action.m5772k();
        if (m5772k.ordinal() > this.f6920s.ordinal()) {
            this.f6920s = m5772k;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m5732b(Action action) {
        boolean remove;
        if (this.f6912k == action) {
            this.f6912k = null;
            remove = true;
        } else {
            List<Action> list = this.f6913l;
            remove = list != null ? list.remove(action) : false;
        }
        if (remove && action.m5772k() == this.f6920s) {
            this.f6920s = m5719o();
        }
        if (this.f6903b.f6859l) {
            C2344aa.m5754a("Hunter", "removed", action.f6883b.m5670a(), C2344aa.m5762a(this, "from "));
        }
    }

    /* renamed from: o */
    private Picasso.Priority m5719o() {
        Picasso.Priority priority = Picasso.Priority.LOW;
        List<Action> list = this.f6913l;
        boolean z = true;
        boolean z2 = (list == null || list.isEmpty()) ? false : true;
        if (this.f6912k == null && !z2) {
            z = false;
        }
        if (z) {
            Action action = this.f6912k;
            if (action != null) {
                priority = action.m5772k();
            }
            if (z2) {
                int size = this.f6913l.size();
                for (int i = 0; i < size; i++) {
                    Picasso.Priority m5772k = this.f6913l.get(i).m5772k();
                    if (m5772k.ordinal() > priority.ordinal()) {
                        priority = m5772k;
                    }
                }
            }
            return priority;
        }
        return priority;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean m5733b() {
        Future<?> future;
        if (this.f6912k == null) {
            List<Action> list = this.f6913l;
            return (list == null || list.isEmpty()) && (future = this.f6915n) != null && future.cancel(false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean m5731c() {
        Future<?> future = this.f6915n;
        return future != null && future.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m5734a(boolean z, NetworkInfo networkInfo) {
        if (this.f6919r > 0) {
            this.f6919r--;
            return this.f6911j.mo5643a(z, networkInfo);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean m5730d() {
        return this.f6911j.mo5642b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public Bitmap m5729e() {
        return this.f6914m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public String m5728f() {
        return this.f6907f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public int m5727g() {
        return this.f6909h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public C2365q m5726h() {
        return this.f6908g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public Action m5725i() {
        return this.f6912k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public Picasso m5724j() {
        return this.f6903b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public List<Action> m5723k() {
        return this.f6913l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public Exception m5722l() {
        return this.f6917p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public Picasso.LoadedFrom m5721m() {
        return this.f6916o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public Picasso.Priority m5720n() {
        return this.f6920s;
    }

    /* renamed from: a */
    static void m5739a(C2365q c2365q) {
        String m5668c = c2365q.m5668c();
        StringBuilder sb = f6899u.get();
        sb.ensureCapacity(m5668c.length() + 8);
        sb.replace(8, sb.length(), m5668c);
        Thread.currentThread().setName(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static BitmapHunter m5741a(Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action) {
        C2365q m5780c = action.m5780c();
        List<RequestHandler> m5799a = picasso.m5799a();
        int size = m5799a.size();
        for (int i = 0; i < size; i++) {
            RequestHandler requestHandler = m5799a.get(i);
            if (requestHandler.mo5635a(m5780c)) {
                return new BitmapHunter(picasso, dispatcher, cache, stats, action, requestHandler);
            }
        }
        return new BitmapHunter(picasso, dispatcher, cache, stats, action, f6901w);
    }

    /* renamed from: a */
    static Bitmap m5736a(List<InterfaceC2372y> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            final InterfaceC2372y interfaceC2372y = list.get(i);
            try {
                Bitmap m5616a = interfaceC2372y.m5616a(bitmap);
                if (m5616a == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Transformation ");
                    sb.append(interfaceC2372y.m5617a());
                    sb.append(" returned null after ");
                    sb.append(i);
                    sb.append(" previous transformation(s).\n\nTransformation list:\n");
                    for (InterfaceC2372y interfaceC2372y2 : list) {
                        sb.append(interfaceC2372y2.m5617a());
                        sb.append('\n');
                    }
                    Picasso.f6848a.post(new Runnable() { // from class: com.squareup.picasso.c.4
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new NullPointerException(sb.toString());
                        }
                    });
                    return null;
                } else if (m5616a == bitmap && bitmap.isRecycled()) {
                    Picasso.f6848a.post(new Runnable() { // from class: com.squareup.picasso.c.5
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new IllegalStateException("Transformation " + InterfaceC2372y.this.m5617a() + " returned input Bitmap but recycled it.");
                        }
                    });
                    return null;
                } else if (m5616a != bitmap && !bitmap.isRecycled()) {
                    Picasso.f6848a.post(new Runnable() { // from class: com.squareup.picasso.c.6
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new IllegalStateException("Transformation " + InterfaceC2372y.this.m5617a() + " mutated input Bitmap but failed to recycle the original.");
                        }
                    });
                    return null;
                } else {
                    i++;
                    bitmap = m5616a;
                }
            } catch (RuntimeException e) {
                Picasso.f6848a.post(new Runnable() { // from class: com.squareup.picasso.c.3
                    @Override // java.lang.Runnable
                    public void run() {
                        throw new RuntimeException("Transformation " + InterfaceC2372y.this.m5617a() + " crashed with exception.", e);
                    }
                });
                return null;
            }
        }
        return bitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c4  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static android.graphics.Bitmap m5738a(com.squareup.picasso.C2365q r13, android.graphics.Bitmap r14, int r15) {
        /*
            Method dump skipped, instructions count: 198
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.BitmapHunter.m5738a(com.squareup.picasso.q, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }
}
