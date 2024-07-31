package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.p005a.p007b.FastSafeIterableMap;
import android.arch.p005a.p007b.SafeIterableMap;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* renamed from: android.arch.lifecycle.e */
/* loaded from: classes.dex */
public class LifecycleRegistry extends Lifecycle {

    /* renamed from: c */
    private final WeakReference<LifecycleOwner> f58c;

    /* renamed from: a */
    private FastSafeIterableMap<LifecycleObserver, C0016a> f56a = new FastSafeIterableMap<>();

    /* renamed from: d */
    private int f59d = 0;

    /* renamed from: e */
    private boolean f60e = false;

    /* renamed from: f */
    private boolean f61f = false;

    /* renamed from: g */
    private ArrayList<Lifecycle.State> f62g = new ArrayList<>();

    /* renamed from: b */
    private Lifecycle.State f57b = Lifecycle.State.INITIALIZED;

    public LifecycleRegistry(@NonNull LifecycleOwner lifecycleOwner) {
        this.f58c = new WeakReference<>(lifecycleOwner);
    }

    @MainThread
    /* renamed from: a */
    public void m12884a(@NonNull Lifecycle.State state) {
        m12878b(state);
    }

    /* renamed from: a */
    public void m12885a(@NonNull Lifecycle.Event event) {
        m12878b(m12879b(event));
    }

    /* renamed from: b */
    private void m12878b(Lifecycle.State state) {
        if (this.f57b == state) {
            return;
        }
        this.f57b = state;
        if (this.f60e || this.f59d != 0) {
            this.f61f = true;
            return;
        }
        this.f60e = true;
        m12872d();
        this.f60e = false;
    }

    /* renamed from: b */
    private boolean m12880b() {
        if (this.f56a.m12923a() == 0) {
            return true;
        }
        Lifecycle.State state = this.f56a.m12915d().getValue().f65a;
        Lifecycle.State state2 = this.f56a.m12914e().getValue().f65a;
        return state == state2 && this.f57b == state2;
    }

    /* renamed from: c */
    private Lifecycle.State m12873c(LifecycleObserver lifecycleObserver) {
        Map.Entry<LifecycleObserver, C0016a> m12924d = this.f56a.m12924d(lifecycleObserver);
        Lifecycle.State state = null;
        Lifecycle.State state2 = m12924d != null ? m12924d.getValue().f65a : null;
        if (!this.f62g.isEmpty()) {
            ArrayList<Lifecycle.State> arrayList = this.f62g;
            state = arrayList.get(arrayList.size() - 1);
        }
        return m12883a(m12883a(this.f57b, state2), state);
    }

    @Override // android.arch.lifecycle.Lifecycle
    /* renamed from: a */
    public void mo12882a(@NonNull LifecycleObserver lifecycleObserver) {
        LifecycleOwner lifecycleOwner;
        C0016a c0016a = new C0016a(lifecycleObserver, this.f57b == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED);
        if (this.f56a.mo12920a(lifecycleObserver, c0016a) == null && (lifecycleOwner = this.f58c.get()) != null) {
            boolean z = this.f59d != 0 || this.f60e;
            Lifecycle.State m12873c = m12873c(lifecycleObserver);
            this.f59d++;
            while (c0016a.f65a.compareTo(m12873c) < 0 && this.f56a.m12925c(lifecycleObserver)) {
                m12874c(c0016a.f65a);
                c0016a.m12869a(lifecycleOwner, m12870e(c0016a.f65a));
                m12875c();
                m12873c = m12873c(lifecycleObserver);
            }
            if (!z) {
                m12872d();
            }
            this.f59d--;
        }
    }

    /* renamed from: c */
    private void m12875c() {
        ArrayList<Lifecycle.State> arrayList = this.f62g;
        arrayList.remove(arrayList.size() - 1);
    }

    /* renamed from: c */
    private void m12874c(Lifecycle.State state) {
        this.f62g.add(state);
    }

    @Override // android.arch.lifecycle.Lifecycle
    /* renamed from: b */
    public void mo12877b(@NonNull LifecycleObserver lifecycleObserver) {
        this.f56a.mo12918b(lifecycleObserver);
    }

    @Override // android.arch.lifecycle.Lifecycle
    @NonNull
    /* renamed from: a */
    public Lifecycle.State mo12886a() {
        return this.f57b;
    }

    /* renamed from: b */
    static Lifecycle.State m12879b(Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
            case ON_STOP:
                return Lifecycle.State.CREATED;
            case ON_START:
            case ON_PAUSE:
                return Lifecycle.State.STARTED;
            case ON_RESUME:
                return Lifecycle.State.RESUMED;
            case ON_DESTROY:
                return Lifecycle.State.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + event);
        }
    }

    /* renamed from: d */
    private static Lifecycle.Event m12871d(Lifecycle.State state) {
        switch (state) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return Lifecycle.Event.ON_DESTROY;
            case STARTED:
                return Lifecycle.Event.ON_STOP;
            case RESUMED:
                return Lifecycle.Event.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + state);
        }
    }

    /* renamed from: e */
    private static Lifecycle.Event m12870e(Lifecycle.State state) {
        switch (state) {
            case INITIALIZED:
            case DESTROYED:
                return Lifecycle.Event.ON_CREATE;
            case CREATED:
                return Lifecycle.Event.ON_START;
            case STARTED:
                return Lifecycle.Event.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + state);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private void m12881a(LifecycleOwner lifecycleOwner) {
        SafeIterableMap<LifecycleObserver, C0016a>.C0006d c = this.f56a.m12916c();
        while (c.hasNext() && !this.f61f) {
            Map.Entry next = c.next();
            C0016a c0016a = (C0016a) next.getValue();
            while (c0016a.f65a.compareTo(this.f57b) < 0 && !this.f61f && this.f56a.m12925c(next.getKey())) {
                m12874c(c0016a.f65a);
                c0016a.m12869a(lifecycleOwner, m12870e(c0016a.f65a));
                m12875c();
            }
        }
    }

    /* renamed from: b */
    private void m12876b(LifecycleOwner lifecycleOwner) {
        Iterator<Map.Entry<LifecycleObserver, C0016a>> b = this.f56a.m12919b();
        while (b.hasNext() && !this.f61f) {
            Map.Entry<LifecycleObserver, C0016a> next = b.next();
            C0016a value = next.getValue();
            while (value.f65a.compareTo(this.f57b) > 0 && !this.f61f && this.f56a.m12925c(next.getKey())) {
                Lifecycle.Event m12871d = m12871d(value.f65a);
                m12874c(m12879b(m12871d));
                value.m12869a(lifecycleOwner, m12871d);
                m12875c();
            }
        }
    }

    /* renamed from: d */
    private void m12872d() {
        LifecycleOwner lifecycleOwner = this.f58c.get();
        if (lifecycleOwner == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!m12880b()) {
            this.f61f = false;
            if (this.f57b.compareTo(this.f56a.m12915d().getValue().f65a) < 0) {
                m12876b(lifecycleOwner);
            }
            Map.Entry<LifecycleObserver, C0016a> e = this.f56a.m12914e();
            if (!this.f61f && e != null && this.f57b.compareTo(e.getValue().f65a) > 0) {
                m12881a(lifecycleOwner);
            }
        }
        this.f61f = false;
    }

    /* renamed from: a */
    static Lifecycle.State m12883a(@NonNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LifecycleRegistry.java */
    /* renamed from: android.arch.lifecycle.e$a */
    /* loaded from: classes.dex */
    public static class C0016a {

        /* renamed from: a */
        Lifecycle.State f65a;

        /* renamed from: b */
        GenericLifecycleObserver f66b;

        C0016a(LifecycleObserver lifecycleObserver, Lifecycle.State state) {
            this.f66b = Lifecycling.m12866a(lifecycleObserver);
            this.f65a = state;
        }

        /* renamed from: a */
        void m12869a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State m12879b = LifecycleRegistry.m12879b(event);
            this.f65a = LifecycleRegistry.m12883a(this.f65a, m12879b);
            this.f66b.mo12896a(lifecycleOwner, event);
            this.f65a = m12879b;
        }
    }
}
