package com.squareup.picasso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.squareup.picasso.NetworkRequestHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.squareup.picasso.i */
/* loaded from: classes2.dex */
public class Dispatcher {

    /* renamed from: a */
    final HandlerThreadC2361b f6933a = new HandlerThreadC2361b();

    /* renamed from: b */
    final Context f6934b;

    /* renamed from: c */
    final ExecutorService f6935c;

    /* renamed from: d */
    final Downloader f6936d;

    /* renamed from: e */
    final Map<String, BitmapHunter> f6937e;

    /* renamed from: f */
    final Map<Object, Action> f6938f;

    /* renamed from: g */
    final Map<Object, Action> f6939g;

    /* renamed from: h */
    final Set<Object> f6940h;

    /* renamed from: i */
    final Handler f6941i;

    /* renamed from: j */
    final Handler f6942j;

    /* renamed from: k */
    final Cache f6943k;

    /* renamed from: l */
    final Stats f6944l;

    /* renamed from: m */
    final List<BitmapHunter> f6945m;

    /* renamed from: n */
    final C2362c f6946n;

    /* renamed from: o */
    final boolean f6947o;

    /* renamed from: p */
    boolean f6948p;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Dispatcher(Context context, ExecutorService executorService, Handler handler, Downloader downloader, Cache cache, Stats stats) {
        this.f6933a.start();
        C2344aa.m5764a(this.f6933a.getLooper());
        this.f6934b = context;
        this.f6935c = executorService;
        this.f6937e = new LinkedHashMap();
        this.f6938f = new WeakHashMap();
        this.f6939g = new WeakHashMap();
        this.f6940h = new HashSet();
        this.f6941i = new HandlerC2359a(this.f6933a.getLooper(), this);
        this.f6936d = downloader;
        this.f6942j = handler;
        this.f6943k = cache;
        this.f6944l = stats;
        this.f6945m = new ArrayList(4);
        this.f6948p = C2344aa.m5747d(this.f6934b);
        this.f6947o = C2344aa.m5751b(context, "android.permission.ACCESS_NETWORK_STATE");
        this.f6946n = new C2362c(this);
        this.f6946n.m5690a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m5711a(Action action) {
        Handler handler = this.f6941i;
        handler.sendMessage(handler.obtainMessage(1, action));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m5702b(Action action) {
        Handler handler = this.f6941i;
        handler.sendMessage(handler.obtainMessage(2, action));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m5709a(BitmapHunter bitmapHunter) {
        Handler handler = this.f6941i;
        handler.sendMessage(handler.obtainMessage(4, bitmapHunter));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m5701b(BitmapHunter bitmapHunter) {
        Handler handler = this.f6941i;
        handler.sendMessageDelayed(handler.obtainMessage(5, bitmapHunter), 500L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m5697c(BitmapHunter bitmapHunter) {
        Handler handler = this.f6941i;
        handler.sendMessage(handler.obtainMessage(6, bitmapHunter));
    }

    /* renamed from: a */
    void m5712a(NetworkInfo networkInfo) {
        Handler handler = this.f6941i;
        handler.sendMessage(handler.obtainMessage(9, networkInfo));
    }

    /* renamed from: a */
    void m5705a(boolean z) {
        Handler handler = this.f6941i;
        handler.sendMessage(handler.obtainMessage(10, z ? 1 : 0, 0));
    }

    /* renamed from: c */
    void m5698c(Action action) {
        m5710a(action, true);
    }

    /* renamed from: a */
    void m5710a(Action action, boolean z) {
        if (this.f6940h.contains(action.m5771l())) {
            this.f6939g.put(action.m5779d(), action);
            if (action.m5773j().f6859l) {
                String m5670a = action.f6883b.m5670a();
                C2344aa.m5754a("Dispatcher", "paused", m5670a, "because tag '" + action.m5771l() + "' is paused");
                return;
            }
            return;
        }
        BitmapHunter bitmapHunter = this.f6937e.get(action.m5778e());
        if (bitmapHunter != null) {
            bitmapHunter.m5740a(action);
        } else if (this.f6935c.isShutdown()) {
            if (action.m5773j().f6859l) {
                C2344aa.m5754a("Dispatcher", "ignored", action.f6883b.m5670a(), "because shut down");
            }
        } else {
            BitmapHunter m5741a = BitmapHunter.m5741a(action.m5773j(), this, this.f6943k, this.f6944l, action);
            m5741a.f6915n = this.f6935c.submit(m5741a);
            this.f6937e.put(action.m5778e(), m5741a);
            if (z) {
                this.f6938f.remove(action.m5779d());
            }
            if (action.m5773j().f6859l) {
                C2344aa.m5755a("Dispatcher", "enqueued", action.f6883b.m5670a());
            }
        }
    }

    /* renamed from: d */
    void m5696d(Action action) {
        String m5778e = action.m5778e();
        BitmapHunter bitmapHunter = this.f6937e.get(m5778e);
        if (bitmapHunter != null) {
            bitmapHunter.m5732b(action);
            if (bitmapHunter.m5733b()) {
                this.f6937e.remove(m5778e);
                if (action.m5773j().f6859l) {
                    C2344aa.m5755a("Dispatcher", "canceled", action.m5780c().m5670a());
                }
            }
        }
        if (this.f6940h.contains(action.m5771l())) {
            this.f6939g.remove(action.m5779d());
            if (action.m5773j().f6859l) {
                C2344aa.m5754a("Dispatcher", "canceled", action.m5780c().m5670a(), "because paused request got canceled");
            }
        }
        Action remove = this.f6938f.remove(action.m5779d());
        if (remove == null || !remove.m5773j().f6859l) {
            return;
        }
        C2344aa.m5754a("Dispatcher", "canceled", remove.m5780c().m5670a(), "from replaying");
    }

    /* renamed from: a */
    void m5707a(Object obj) {
        if (this.f6940h.add(obj)) {
            Iterator<BitmapHunter> it = this.f6937e.values().iterator();
            while (it.hasNext()) {
                BitmapHunter next = it.next();
                boolean z = next.m5724j().f6859l;
                Action m5725i = next.m5725i();
                List<Action> m5723k = next.m5723k();
                boolean z2 = (m5723k == null || m5723k.isEmpty()) ? false : true;
                if (m5725i != null || z2) {
                    if (m5725i != null && m5725i.m5771l().equals(obj)) {
                        next.m5732b(m5725i);
                        this.f6939g.put(m5725i.m5779d(), m5725i);
                        if (z) {
                            C2344aa.m5754a("Dispatcher", "paused", m5725i.f6883b.m5670a(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (z2) {
                        for (int size = m5723k.size() - 1; size >= 0; size--) {
                            Action action = m5723k.get(size);
                            if (action.m5771l().equals(obj)) {
                                next.m5732b(action);
                                this.f6939g.put(action.m5779d(), action);
                                if (z) {
                                    C2344aa.m5754a("Dispatcher", "paused", action.f6883b.m5670a(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (next.m5733b()) {
                        it.remove();
                        if (z) {
                            C2344aa.m5754a("Dispatcher", "canceled", C2344aa.m5763a(next), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    void m5700b(Object obj) {
        if (this.f6940h.remove(obj)) {
            ArrayList arrayList = null;
            Iterator<Action> it = this.f6939g.values().iterator();
            while (it.hasNext()) {
                Action next = it.next();
                if (next.m5771l().equals(obj)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                    it.remove();
                }
            }
            if (arrayList != null) {
                Handler handler = this.f6942j;
                handler.sendMessage(handler.obtainMessage(13, arrayList));
            }
        }
    }

    /* renamed from: d */
    void m5695d(BitmapHunter bitmapHunter) {
        if (bitmapHunter.m5731c()) {
            return;
        }
        boolean z = false;
        if (this.f6935c.isShutdown()) {
            m5708a(bitmapHunter, false);
            return;
        }
        NetworkInfo activeNetworkInfo = this.f6947o ? ((ConnectivityManager) C2344aa.m5767a(this.f6934b, "connectivity")).getActiveNetworkInfo() : null;
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean m5734a = bitmapHunter.m5734a(this.f6948p, activeNetworkInfo);
        boolean m5730d = bitmapHunter.m5730d();
        if (!m5734a) {
            if (this.f6947o && m5730d) {
                z = true;
            }
            m5708a(bitmapHunter, z);
            if (z) {
                m5692f(bitmapHunter);
            }
        } else if (!this.f6947o || z2) {
            if (bitmapHunter.m5724j().f6859l) {
                C2344aa.m5755a("Dispatcher", "retrying", C2344aa.m5763a(bitmapHunter));
            }
            if (bitmapHunter.m5722l() instanceof NetworkRequestHandler.ContentLengthException) {
                bitmapHunter.f6910i |= NetworkPolicy.NO_CACHE.index;
            }
            bitmapHunter.f6915n = this.f6935c.submit(bitmapHunter);
        } else {
            m5708a(bitmapHunter, m5730d);
            if (m5730d) {
                m5692f(bitmapHunter);
            }
        }
    }

    /* renamed from: e */
    void m5693e(BitmapHunter bitmapHunter) {
        if (MemoryPolicy.shouldWriteToMemoryCache(bitmapHunter.m5727g())) {
            this.f6943k.mo5684a(bitmapHunter.m5728f(), bitmapHunter.m5729e());
        }
        this.f6937e.remove(bitmapHunter.m5728f());
        m5691g(bitmapHunter);
        if (bitmapHunter.m5724j().f6859l) {
            C2344aa.m5754a("Dispatcher", "batched", C2344aa.m5763a(bitmapHunter), "for completion");
        }
    }

    /* renamed from: a */
    void m5713a() {
        ArrayList arrayList = new ArrayList(this.f6945m);
        this.f6945m.clear();
        Handler handler = this.f6942j;
        handler.sendMessage(handler.obtainMessage(8, arrayList));
        m5706a((List<BitmapHunter>) arrayList);
    }

    /* renamed from: a */
    void m5708a(BitmapHunter bitmapHunter, boolean z) {
        if (bitmapHunter.m5724j().f6859l) {
            String m5763a = C2344aa.m5763a(bitmapHunter);
            StringBuilder sb = new StringBuilder();
            sb.append("for error");
            sb.append(z ? " (will replay)" : "");
            C2344aa.m5754a("Dispatcher", "batched", m5763a, sb.toString());
        }
        this.f6937e.remove(bitmapHunter.m5728f());
        m5691g(bitmapHunter);
    }

    /* renamed from: b */
    void m5699b(boolean z) {
        this.f6948p = z;
    }

    /* renamed from: b */
    void m5703b(NetworkInfo networkInfo) {
        ExecutorService executorService = this.f6935c;
        if (executorService instanceof PicassoExecutorService) {
            ((PicassoExecutorService) executorService).m5672a(networkInfo);
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return;
        }
        m5704b();
    }

    /* renamed from: b */
    private void m5704b() {
        if (this.f6938f.isEmpty()) {
            return;
        }
        Iterator<Action> it = this.f6938f.values().iterator();
        while (it.hasNext()) {
            Action next = it.next();
            it.remove();
            if (next.m5773j().f6859l) {
                C2344aa.m5755a("Dispatcher", "replaying", next.m5780c().m5670a());
            }
            m5710a(next, false);
        }
    }

    /* renamed from: f */
    private void m5692f(BitmapHunter bitmapHunter) {
        Action m5725i = bitmapHunter.m5725i();
        if (m5725i != null) {
            m5694e(m5725i);
        }
        List<Action> m5723k = bitmapHunter.m5723k();
        if (m5723k != null) {
            int size = m5723k.size();
            for (int i = 0; i < size; i++) {
                m5694e(m5723k.get(i));
            }
        }
    }

    /* renamed from: e */
    private void m5694e(Action action) {
        Object m5779d = action.m5779d();
        if (m5779d != null) {
            action.f6892k = true;
            this.f6938f.put(m5779d, action);
        }
    }

    /* renamed from: g */
    private void m5691g(BitmapHunter bitmapHunter) {
        if (bitmapHunter.m5731c()) {
            return;
        }
        this.f6945m.add(bitmapHunter);
        if (this.f6941i.hasMessages(7)) {
            return;
        }
        this.f6941i.sendEmptyMessageDelayed(7, 200L);
    }

    /* renamed from: a */
    private void m5706a(List<BitmapHunter> list) {
        if (list == null || list.isEmpty() || !list.get(0).m5724j().f6859l) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (BitmapHunter bitmapHunter : list) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(C2344aa.m5763a(bitmapHunter));
        }
        C2344aa.m5755a("Dispatcher", "delivered", sb.toString());
    }

    /* compiled from: Dispatcher.java */
    /* renamed from: com.squareup.picasso.i$a */
    /* loaded from: classes2.dex */
    private static class HandlerC2359a extends Handler {

        /* renamed from: a */
        private final Dispatcher f6949a;

        public HandlerC2359a(Looper looper, Dispatcher dispatcher) {
            super(looper);
            this.f6949a = dispatcher;
        }

        @Override // android.os.Handler
        public void handleMessage(final Message message) {
            switch (message.what) {
                case 1:
                    this.f6949a.m5698c((Action) message.obj);
                    return;
                case 2:
                    this.f6949a.m5696d((Action) message.obj);
                    return;
                case 3:
                case 8:
                default:
                    Picasso.f6848a.post(new Runnable() { // from class: com.squareup.picasso.i.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new AssertionError("Unknown handler message received: " + message.what);
                        }
                    });
                    return;
                case 4:
                    this.f6949a.m5693e((BitmapHunter) message.obj);
                    return;
                case 5:
                    this.f6949a.m5695d((BitmapHunter) message.obj);
                    return;
                case 6:
                    this.f6949a.m5708a((BitmapHunter) message.obj, false);
                    return;
                case 7:
                    this.f6949a.m5713a();
                    return;
                case 9:
                    this.f6949a.m5703b((NetworkInfo) message.obj);
                    return;
                case 10:
                    this.f6949a.m5699b(message.arg1 == 1);
                    return;
                case 11:
                    this.f6949a.m5707a(message.obj);
                    return;
                case 12:
                    this.f6949a.m5700b(message.obj);
                    return;
            }
        }
    }

    /* compiled from: Dispatcher.java */
    /* renamed from: com.squareup.picasso.i$b */
    /* loaded from: classes2.dex */
    static class HandlerThreadC2361b extends HandlerThread {
        HandlerThreadC2361b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    /* compiled from: Dispatcher.java */
    /* renamed from: com.squareup.picasso.i$c */
    /* loaded from: classes2.dex */
    static class C2362c extends BroadcastReceiver {

        /* renamed from: a */
        private final Dispatcher f6952a;

        C2362c(Dispatcher dispatcher) {
            this.f6952a = dispatcher;
        }

        /* renamed from: a */
        void m5690a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f6952a.f6947o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f6952a.f6934b.registerReceiver(this, intentFilter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                if (intent.hasExtra("state")) {
                    this.f6952a.m5705a(intent.getBooleanExtra("state", false));
                }
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                this.f6952a.m5712a(((ConnectivityManager) C2344aa.m5767a(context, "connectivity")).getActiveNetworkInfo());
            }
        }
    }
}
