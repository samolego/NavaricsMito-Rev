package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.p005a.p006a.ArchTaskExecutor;
import android.arch.p005a.p007b.SafeIterableMap;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class LiveData<T> {
    private static final Object NOT_SET = new Object();
    static final int START_VERSION = -1;
    private volatile Object mData;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private volatile Object mPendingData;
    private final Runnable mPostValueRunnable;
    private int mVersion;
    private final Object mDataLock = new Object();
    private SafeIterableMap<Observer<T>, LiveData<T>.AbstractC0012b> mObservers = new SafeIterableMap<>();
    private int mActiveCount = 0;

    protected void onActive() {
    }

    protected void onInactive() {
    }

    public LiveData() {
        Object obj = NOT_SET;
        this.mData = obj;
        this.mPendingData = obj;
        this.mVersion = -1;
        this.mPostValueRunnable = new Runnable() { // from class: android.arch.lifecycle.LiveData.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Object obj2;
                synchronized (LiveData.this.mDataLock) {
                    obj2 = LiveData.this.mPendingData;
                    LiveData.this.mPendingData = LiveData.NOT_SET;
                }
                LiveData.this.setValue(obj2);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void considerNotify(LiveData<T>.AbstractC0012b abstractC0012b) {
        if (abstractC0012b.f43d) {
            if (!abstractC0012b.mo12901a()) {
                abstractC0012b.m12899a(false);
                return;
            }
            int i = abstractC0012b.f44e;
            int i2 = this.mVersion;
            if (i >= i2) {
                return;
            }
            abstractC0012b.f44e = i2;
            abstractC0012b.f42c.onChanged(this.mData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchingValue(@Nullable LiveData<T>.AbstractC0012b abstractC0012b) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if (abstractC0012b != null) {
                considerNotify(abstractC0012b);
                abstractC0012b = null;
            } else {
                SafeIterableMap<Observer<T>, LiveData<T>.AbstractC0012b>.C0006d m12916c = this.mObservers.m12916c();
                while (m12916c.hasNext()) {
                    considerNotify((AbstractC0012b) m12916c.next().getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            }
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    @MainThread
    public void observe(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<T> observer) {
        if (lifecycleOwner.getLifecycle().mo12886a() == Lifecycle.State.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
        LiveData<T>.AbstractC0012b mo12920a = this.mObservers.mo12920a(observer, lifecycleBoundObserver);
        if (mo12920a != null && !mo12920a.mo12900a(lifecycleOwner)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (mo12920a != null) {
            return;
        }
        lifecycleOwner.getLifecycle().mo12882a(lifecycleBoundObserver);
    }

    @MainThread
    public void observeForever(@NonNull Observer<T> observer) {
        C0011a c0011a = new C0011a(observer);
        LiveData<T>.AbstractC0012b mo12920a = this.mObservers.mo12920a(observer, c0011a);
        if (mo12920a != null && (mo12920a instanceof LifecycleBoundObserver)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (mo12920a != null) {
            return;
        }
        c0011a.m12899a(true);
    }

    @MainThread
    public void removeObserver(@NonNull Observer<T> observer) {
        assertMainThread("removeObserver");
        LiveData<T>.AbstractC0012b mo12918b = this.mObservers.mo12918b(observer);
        if (mo12918b == null) {
            return;
        }
        mo12918b.mo12898b();
        mo12918b.m12899a(false);
    }

    @MainThread
    public void removeObservers(@NonNull LifecycleOwner lifecycleOwner) {
        assertMainThread("removeObservers");
        Iterator<Map.Entry<Observer<T>, LiveData<T>.AbstractC0012b>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            Map.Entry<Observer<T>, LiveData<T>.AbstractC0012b> next = it.next();
            if (next.getValue().mo12900a(lifecycleOwner)) {
                removeObserver(next.getKey());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postValue(T t) {
        boolean z;
        synchronized (this.mDataLock) {
            z = this.mPendingData == NOT_SET;
            this.mPendingData = t;
        }
        if (z) {
            ArchTaskExecutor.m12929a().mo12926b(this.mPostValueRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @MainThread
    public void setValue(T t) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = t;
        dispatchingValue(null);
    }

    @Nullable
    public T getValue() {
        T t = (T) this.mData;
        if (t != NOT_SET) {
            return t;
        }
        return null;
    }

    int getVersion() {
        return this.mVersion;
    }

    public boolean hasObservers() {
        return this.mObservers.m12923a() > 0;
    }

    public boolean hasActiveObservers() {
        return this.mActiveCount > 0;
    }

    /* loaded from: classes.dex */
    class LifecycleBoundObserver extends LiveData<T>.AbstractC0012b implements GenericLifecycleObserver {
        @NonNull

        /* renamed from: a */
        final LifecycleOwner f39a;

        LifecycleBoundObserver(LifecycleOwner lifecycleOwner, @NonNull Observer<T> observer) {
            super(observer);
            this.f39a = lifecycleOwner;
        }

        @Override // android.arch.lifecycle.LiveData.AbstractC0012b
        /* renamed from: a */
        boolean mo12901a() {
            return this.f39a.getLifecycle().mo12886a().isAtLeast(Lifecycle.State.STARTED);
        }

        @Override // android.arch.lifecycle.GenericLifecycleObserver
        /* renamed from: a */
        public void mo12896a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (this.f39a.getLifecycle().mo12886a() == Lifecycle.State.DESTROYED) {
                LiveData.this.removeObserver(this.f42c);
            } else {
                m12899a(mo12901a());
            }
        }

        @Override // android.arch.lifecycle.LiveData.AbstractC0012b
        /* renamed from: a */
        boolean mo12900a(LifecycleOwner lifecycleOwner) {
            return this.f39a == lifecycleOwner;
        }

        @Override // android.arch.lifecycle.LiveData.AbstractC0012b
        /* renamed from: b */
        void mo12898b() {
            this.f39a.getLifecycle().mo12877b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: android.arch.lifecycle.LiveData$b */
    /* loaded from: classes.dex */
    public abstract class AbstractC0012b {

        /* renamed from: c */
        final Observer<T> f42c;

        /* renamed from: d */
        boolean f43d;

        /* renamed from: e */
        int f44e = -1;

        /* renamed from: a */
        abstract boolean mo12901a();

        /* renamed from: a */
        boolean mo12900a(LifecycleOwner lifecycleOwner) {
            return false;
        }

        /* renamed from: b */
        void mo12898b() {
        }

        AbstractC0012b(Observer<T> observer) {
            this.f42c = observer;
        }

        /* renamed from: a */
        void m12899a(boolean z) {
            if (z == this.f43d) {
                return;
            }
            this.f43d = z;
            boolean z2 = LiveData.this.mActiveCount == 0;
            LiveData.this.mActiveCount += this.f43d ? 1 : -1;
            if (z2 && this.f43d) {
                LiveData.this.onActive();
            }
            if (LiveData.this.mActiveCount == 0 && !this.f43d) {
                LiveData.this.onInactive();
            }
            if (this.f43d) {
                LiveData.this.dispatchingValue(this);
            }
        }
    }

    /* renamed from: android.arch.lifecycle.LiveData$a */
    /* loaded from: classes.dex */
    private class C0011a extends LiveData<T>.AbstractC0012b {
        @Override // android.arch.lifecycle.LiveData.AbstractC0012b
        /* renamed from: a */
        boolean mo12901a() {
            return true;
        }

        C0011a(Observer<T> observer) {
            super(observer);
        }
    }

    private static void assertMainThread(String str) {
        if (ArchTaskExecutor.m12929a().mo12927b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }
}
