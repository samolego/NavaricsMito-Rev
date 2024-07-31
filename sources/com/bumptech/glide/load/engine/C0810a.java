package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.util.C0791i;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.a */
/* loaded from: classes.dex */
final class ActiveResources {

    /* renamed from: b */
    private final boolean f750b;

    /* renamed from: d */
    private EngineResource.InterfaceC0734a f752d;
    @Nullable

    /* renamed from: e */
    private ReferenceQueue<EngineResource<?>> f753e;
    @Nullable

    /* renamed from: f */
    private Thread f754f;

    /* renamed from: g */
    private volatile boolean f755g;
    @Nullable

    /* renamed from: h */
    private volatile InterfaceC0688a f756h;

    /* renamed from: c */
    private final Handler f751c = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.bumptech.glide.load.engine.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ActiveResources.this.m12232a((C0689b) message.obj);
                return true;
            }
            return false;
        }
    });
    @VisibleForTesting

    /* renamed from: a */
    final Map<Key, C0689b> f749a = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActiveResources.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0688a {
        /* renamed from: a */
        void m12228a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActiveResources(boolean z) {
        this.f750b = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m12231a(EngineResource.InterfaceC0734a interfaceC0734a) {
        this.f752d = interfaceC0734a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m12233a(Key key, EngineResource<?> engineResource) {
        C0689b put = this.f749a.put(key, new C0689b(key, engineResource, m12230b(), this.f750b));
        if (put != null) {
            put.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m12234a(Key key) {
        C0689b remove = this.f749a.remove(key);
        if (remove != null) {
            remove.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: b */
    public EngineResource<?> m12229b(Key key) {
        C0689b c0689b = this.f749a.get(key);
        if (c0689b == null) {
            return null;
        }
        EngineResource<?> engineResource = (EngineResource) c0689b.get();
        if (engineResource == null) {
            m12232a(c0689b);
        }
        return engineResource;
    }

    /* renamed from: a */
    void m12232a(@NonNull C0689b c0689b) {
        C0791i.m11575a();
        this.f749a.remove(c0689b.f759a);
        if (!c0689b.f760b || c0689b.f761c == null) {
            return;
        }
        EngineResource<?> engineResource = new EngineResource<>(c0689b.f761c, true, false);
        engineResource.m12042a(c0689b.f759a, this.f752d);
        this.f752d.mo12038a(c0689b.f759a, engineResource);
    }

    /* renamed from: b */
    private ReferenceQueue<EngineResource<?>> m12230b() {
        if (this.f753e == null) {
            this.f753e = new ReferenceQueue<>();
            this.f754f = new Thread(new Runnable() { // from class: com.bumptech.glide.load.engine.a.2
                @Override // java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(10);
                    ActiveResources.this.m12235a();
                }
            }, "glide-active-resources");
            this.f754f.start();
        }
        return this.f753e;
    }

    /* renamed from: a */
    void m12235a() {
        while (!this.f755g) {
            try {
                this.f751c.obtainMessage(1, (C0689b) this.f753e.remove()).sendToTarget();
                InterfaceC0688a interfaceC0688a = this.f756h;
                if (interfaceC0688a != null) {
                    interfaceC0688a.m12228a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActiveResources.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.a$b */
    /* loaded from: classes.dex */
    public static final class C0689b extends WeakReference<EngineResource<?>> {

        /* renamed from: a */
        final Key f759a;

        /* renamed from: b */
        final boolean f760b;
        @Nullable

        /* renamed from: c */
        Resource<?> f761c;

        C0689b(@NonNull Key key, @NonNull EngineResource<?> engineResource, @NonNull ReferenceQueue<? super EngineResource<?>> referenceQueue, boolean z) {
            super(engineResource, referenceQueue);
            this.f759a = (Key) Preconditions.m11580a(key);
            this.f761c = (engineResource.m12041b() && z) ? (Resource) Preconditions.m11580a(engineResource.m12043a()) : null;
            this.f760b = engineResource.m12041b();
        }

        void a() {
            this.f761c = null;
            clear();
        }
    }
}
