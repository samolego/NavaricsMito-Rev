package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.p100a.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.OpenHashSet;
import java.util.ArrayList;

/* renamed from: io.reactivex.disposables.a */
/* loaded from: classes2.dex */
public final class CompositeDisposable implements Disposable, DisposableContainer {

    /* renamed from: a */
    OpenHashSet<Disposable> f9634a;

    /* renamed from: b */
    volatile boolean f9635b;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.f9635b) {
            return;
        }
        synchronized (this) {
            if (this.f9635b) {
                return;
            }
            this.f9635b = true;
            OpenHashSet<Disposable> openHashSet = this.f9634a;
            this.f9634a = null;
            m3223a(openHashSet);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.f9635b;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    /* renamed from: a */
    public boolean mo3187a(@NonNull Disposable disposable) {
        ObjectHelper.m3188a(disposable, "d is null");
        if (!this.f9635b) {
            synchronized (this) {
                if (!this.f9635b) {
                    OpenHashSet<Disposable> openHashSet = this.f9634a;
                    if (openHashSet == null) {
                        openHashSet = new OpenHashSet<>();
                        this.f9634a = openHashSet;
                    }
                    openHashSet.m3122a((OpenHashSet<Disposable>) disposable);
                    return true;
                }
            }
        }
        disposable.dispose();
        return false;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    /* renamed from: b */
    public boolean mo3185b(@NonNull Disposable disposable) {
        if (mo3184c(disposable)) {
            disposable.dispose();
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    /* renamed from: c */
    public boolean mo3184c(@NonNull Disposable disposable) {
        ObjectHelper.m3188a(disposable, "Disposable item is null");
        if (this.f9635b) {
            return false;
        }
        synchronized (this) {
            if (this.f9635b) {
                return false;
            }
            OpenHashSet<Disposable> openHashSet = this.f9634a;
            if (openHashSet != null && openHashSet.m3120b(disposable)) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: a */
    public void m3224a() {
        if (this.f9635b) {
            return;
        }
        synchronized (this) {
            if (this.f9635b) {
                return;
            }
            OpenHashSet<Disposable> openHashSet = this.f9634a;
            this.f9634a = null;
            m3223a(openHashSet);
        }
    }

    /* renamed from: a */
    void m3223a(OpenHashSet<Disposable> openHashSet) {
        Object[] m3121b;
        if (openHashSet == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : openHashSet.m3121b()) {
            if (obj instanceof Disposable) {
                try {
                    ((Disposable) obj).dispose();
                } catch (Throwable th) {
                    Exceptions.m3207b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw ExceptionHelper.m3131a((Throwable) arrayList.get(0));
            }
            throw new CompositeException(arrayList);
        }
    }
}
