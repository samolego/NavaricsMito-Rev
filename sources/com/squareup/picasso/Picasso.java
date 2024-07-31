package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.p008v4.internal.view.SupportMenu;
import android.widget.ImageView;
import com.squareup.picasso.Action;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class Picasso {

    /* renamed from: a */
    static final Handler f6848a = new Handler(Looper.getMainLooper()) { // from class: com.squareup.picasso.Picasso.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 3) {
                Action action = (Action) message.obj;
                if (action.m5773j().f6859l) {
                    C2344aa.m5754a("Main", "canceled", action.f6883b.m5670a(), "target got garbage collected");
                }
                action.f6882a.m5788a(action.m5779d());
                return;
            }
            int i2 = 0;
            if (i == 8) {
                List list = (List) message.obj;
                int size = list.size();
                while (i2 < size) {
                    BitmapHunter bitmapHunter = (BitmapHunter) list.get(i2);
                    bitmapHunter.f6903b.m5791a(bitmapHunter);
                    i2++;
                }
            } else if (i == 13) {
                List list2 = (List) message.obj;
                int size2 = list2.size();
                while (i2 < size2) {
                    Action action2 = (Action) list2.get(i2);
                    action2.f6882a.m5784c(action2);
                    i2++;
                }
            } else {
                throw new AssertionError("Unknown handler message received: " + message.what);
            }
        }
    };

    /* renamed from: b */
    static volatile Picasso f6849b = null;

    /* renamed from: c */
    final Context f6850c;

    /* renamed from: d */
    final Dispatcher f6851d;

    /* renamed from: e */
    final Cache f6852e;

    /* renamed from: f */
    final Stats f6853f;

    /* renamed from: g */
    final Map<Object, Action> f6854g;

    /* renamed from: h */
    final Map<ImageView, DeferredRequestCreator> f6855h;

    /* renamed from: i */
    final ReferenceQueue<Object> f6856i;

    /* renamed from: j */
    final Bitmap.Config f6857j;

    /* renamed from: k */
    boolean f6858k;

    /* renamed from: l */
    volatile boolean f6859l;

    /* renamed from: m */
    boolean f6860m;

    /* renamed from: n */
    private final InterfaceC2340c f6861n;

    /* renamed from: o */
    private final InterfaceC2341d f6862o;

    /* renamed from: p */
    private final C2338b f6863p;

    /* renamed from: q */
    private final List<RequestHandler> f6864q;

    /* loaded from: classes2.dex */
    public enum Priority {
        LOW,
        NORMAL,
        HIGH
    }

    /* renamed from: com.squareup.picasso.Picasso$c */
    /* loaded from: classes2.dex */
    public interface InterfaceC2340c {
        /* renamed from: a */
        void m5782a(Picasso picasso, Uri uri, Exception exc);
    }

    /* renamed from: com.squareup.picasso.Picasso$d */
    /* loaded from: classes2.dex */
    public interface InterfaceC2341d {

        /* renamed from: a */
        public static final InterfaceC2341d f6881a = new InterfaceC2341d() { // from class: com.squareup.picasso.Picasso.d.1
            @Override // com.squareup.picasso.Picasso.InterfaceC2341d
            /* renamed from: a */
            public C2365q mo5781a(C2365q c2365q) {
                return c2365q;
            }
        };

        /* renamed from: a */
        C2365q mo5781a(C2365q c2365q);
    }

    Picasso(Context context, Dispatcher dispatcher, Cache cache, InterfaceC2340c interfaceC2340c, InterfaceC2341d interfaceC2341d, List<RequestHandler> list, Stats stats, Bitmap.Config config, boolean z, boolean z2) {
        this.f6850c = context;
        this.f6851d = dispatcher;
        this.f6852e = cache;
        this.f6861n = interfaceC2340c;
        this.f6862o = interfaceC2341d;
        this.f6857j = config;
        ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new ResourceRequestHandler(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new ContactsPhotoRequestHandler(context));
        arrayList.add(new MediaStoreRequestHandler(context));
        arrayList.add(new ContentStreamRequestHandler(context));
        arrayList.add(new AssetRequestHandler(context));
        arrayList.add(new FileRequestHandler(context));
        arrayList.add(new NetworkRequestHandler(dispatcher.f6936d, stats));
        this.f6864q = Collections.unmodifiableList(arrayList);
        this.f6853f = stats;
        this.f6854g = new WeakHashMap();
        this.f6855h = new WeakHashMap();
        this.f6858k = z;
        this.f6859l = z2;
        this.f6856i = new ReferenceQueue<>();
        this.f6863p = new C2338b(this.f6856i, f6848a);
        this.f6863p.start();
    }

    /* renamed from: a */
    public void m5795a(ImageView imageView) {
        m5788a((Object) imageView);
    }

    /* renamed from: a */
    public void m5789a(InterfaceC2371w interfaceC2371w) {
        m5788a((Object) interfaceC2371w);
    }

    /* renamed from: a */
    public RequestCreator m5796a(Uri uri) {
        return new RequestCreator(this, uri, 0);
    }

    /* renamed from: a */
    public RequestCreator m5787a(String str) {
        if (str == null) {
            return new RequestCreator(this, null, 0);
        }
        if (str.trim().length() == 0) {
            throw new IllegalArgumentException("Path must not be empty.");
        }
        return m5796a(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public List<RequestHandler> m5799a() {
        return this.f6864q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public C2365q m5790a(C2365q c2365q) {
        C2365q mo5781a = this.f6862o.mo5781a(c2365q);
        if (mo5781a != null) {
            return mo5781a;
        }
        throw new IllegalStateException("Request transformer " + this.f6862o.getClass().getCanonicalName() + " returned null for " + c2365q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m5794a(ImageView imageView, DeferredRequestCreator deferredRequestCreator) {
        this.f6855h.put(imageView, deferredRequestCreator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m5792a(Action action) {
        Object m5779d = action.m5779d();
        if (m5779d != null && this.f6854g.get(m5779d) != action) {
            m5788a(m5779d);
            this.f6854g.put(m5779d, action);
        }
        m5786b(action);
    }

    /* renamed from: b */
    void m5786b(Action action) {
        this.f6851d.m5711a(action);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public Bitmap m5785b(String str) {
        Bitmap mo5685a = this.f6852e.mo5685a(str);
        if (mo5685a != null) {
            this.f6853f.m5633a();
        } else {
            this.f6853f.m5627b();
        }
        return mo5685a;
    }

    /* renamed from: a */
    void m5791a(BitmapHunter bitmapHunter) {
        Action m5725i = bitmapHunter.m5725i();
        List<Action> m5723k = bitmapHunter.m5723k();
        boolean z = true;
        boolean z2 = (m5723k == null || m5723k.isEmpty()) ? false : true;
        if (m5725i == null && !z2) {
            z = false;
        }
        if (z) {
            Uri uri = bitmapHunter.m5726h().f6980d;
            Exception m5722l = bitmapHunter.m5722l();
            Bitmap m5729e = bitmapHunter.m5729e();
            LoadedFrom m5721m = bitmapHunter.m5721m();
            if (m5725i != null) {
                m5797a(m5729e, m5721m, m5725i);
            }
            if (z2) {
                int size = m5723k.size();
                for (int i = 0; i < size; i++) {
                    m5797a(m5729e, m5721m, m5723k.get(i));
                }
            }
            InterfaceC2340c interfaceC2340c = this.f6861n;
            if (interfaceC2340c == null || m5722l == null) {
                return;
            }
            interfaceC2340c.m5782a(this, uri, m5722l);
        }
    }

    /* renamed from: c */
    void m5784c(Action action) {
        Bitmap m5785b = MemoryPolicy.shouldReadFromMemoryCache(action.f6886e) ? m5785b(action.m5778e()) : null;
        if (m5785b != null) {
            m5797a(m5785b, LoadedFrom.MEMORY, action);
            if (this.f6859l) {
                String m5670a = action.f6883b.m5670a();
                C2344aa.m5754a("Main", "completed", m5670a, "from " + LoadedFrom.MEMORY);
                return;
            }
            return;
        }
        m5792a(action);
        if (this.f6859l) {
            C2344aa.m5755a("Main", "resumed", action.f6883b.m5670a());
        }
    }

    /* renamed from: a */
    private void m5797a(Bitmap bitmap, LoadedFrom loadedFrom, Action action) {
        if (action.m5777f()) {
            return;
        }
        if (!action.m5776g()) {
            this.f6854g.remove(action.m5779d());
        }
        if (bitmap == null) {
            action.mo5619a();
            if (this.f6859l) {
                C2344aa.m5755a("Main", "errored", action.f6883b.m5670a());
            }
        } else if (loadedFrom == null) {
            throw new AssertionError("LoadedFrom cannot be null.");
        } else {
            action.mo5618a(bitmap, loadedFrom);
            if (this.f6859l) {
                String m5670a = action.f6883b.m5670a();
                C2344aa.m5754a("Main", "completed", m5670a, "from " + loadedFrom);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5788a(Object obj) {
        C2344aa.m5770a();
        Action remove = this.f6854g.remove(obj);
        if (remove != null) {
            remove.mo5688b();
            this.f6851d.m5702b(remove);
        }
        if (obj instanceof ImageView) {
            DeferredRequestCreator remove2 = this.f6855h.remove((ImageView) obj);
            if (remove2 != null) {
                remove2.m5714a();
            }
        }
    }

    /* renamed from: com.squareup.picasso.Picasso$b */
    /* loaded from: classes2.dex */
    private static class C2338b extends Thread {

        /* renamed from: a */
        private final ReferenceQueue<Object> f6877a;

        /* renamed from: b */
        private final Handler f6878b;

        C2338b(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.f6877a = referenceQueue;
            this.f6878b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    Action.C2343a c2343a = (Action.C2343a) this.f6877a.remove(1000L);
                    Message obtainMessage = this.f6878b.obtainMessage();
                    if (c2343a != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = c2343a.f6894a;
                        this.f6878b.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e) {
                    this.f6878b.post(new Runnable() { // from class: com.squareup.picasso.Picasso.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new RuntimeException(e);
                        }
                    });
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public static Picasso m5798a(Context context) {
        if (f6849b == null) {
            synchronized (Picasso.class) {
                if (f6849b == null) {
                    f6849b = new C2337a(context).m5783a();
                }
            }
        }
        return f6849b;
    }

    /* renamed from: com.squareup.picasso.Picasso$a */
    /* loaded from: classes2.dex */
    public static class C2337a {

        /* renamed from: a */
        private final Context f6867a;

        /* renamed from: b */
        private Downloader f6868b;

        /* renamed from: c */
        private ExecutorService f6869c;

        /* renamed from: d */
        private Cache f6870d;

        /* renamed from: e */
        private InterfaceC2340c f6871e;

        /* renamed from: f */
        private InterfaceC2341d f6872f;

        /* renamed from: g */
        private List<RequestHandler> f6873g;

        /* renamed from: h */
        private Bitmap.Config f6874h;

        /* renamed from: i */
        private boolean f6875i;

        /* renamed from: j */
        private boolean f6876j;

        public C2337a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f6867a = context.getApplicationContext();
        }

        /* renamed from: a */
        public Picasso m5783a() {
            Context context = this.f6867a;
            if (this.f6868b == null) {
                this.f6868b = C2344aa.m5769a(context);
            }
            if (this.f6870d == null) {
                this.f6870d = new C2363l(context);
            }
            if (this.f6869c == null) {
                this.f6869c = new PicassoExecutorService();
            }
            if (this.f6872f == null) {
                this.f6872f = InterfaceC2341d.f6881a;
            }
            Stats stats = new Stats(this.f6870d);
            return new Picasso(context, new Dispatcher(context, this.f6869c, Picasso.f6848a, this.f6868b, this.f6870d, stats), this.f6870d, this.f6871e, this.f6872f, this.f6873g, stats, this.f6874h, this.f6875i, this.f6876j);
        }
    }

    /* loaded from: classes2.dex */
    public enum LoadedFrom {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(SupportMenu.CATEGORY_MASK);
        
        final int debugColor;

        LoadedFrom(int i) {
            this.debugColor = i;
        }
    }
}
