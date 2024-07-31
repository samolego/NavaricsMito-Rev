package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.p100a.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: io.reactivex.internal.disposables.b */
/* loaded from: classes2.dex */
public final class ListCompositeDisposable implements Disposable, DisposableContainer {

    /* renamed from: a */
    List<Disposable> f9665a;

    /* renamed from: b */
    volatile boolean f9666b;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.f9666b) {
            return;
        }
        synchronized (this) {
            if (this.f9666b) {
                return;
            }
            this.f9666b = true;
            List<Disposable> list = this.f9665a;
            this.f9665a = null;
            m3186a(list);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.f9666b;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    /* renamed from: a */
    public boolean mo3187a(Disposable disposable) {
        ObjectHelper.m3188a(disposable, "d is null");
        if (!this.f9666b) {
            synchronized (this) {
                if (!this.f9666b) {
                    List list = this.f9665a;
                    if (list == null) {
                        list = new LinkedList();
                        this.f9665a = list;
                    }
                    list.add(disposable);
                    return true;
                }
            }
        }
        disposable.dispose();
        return false;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    /* renamed from: b */
    public boolean mo3185b(Disposable disposable) {
        if (mo3184c(disposable)) {
            disposable.dispose();
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    /* renamed from: c */
    public boolean mo3184c(Disposable disposable) {
        ObjectHelper.m3188a(disposable, "Disposable item is null");
        if (this.f9666b) {
            return false;
        }
        synchronized (this) {
            if (this.f9666b) {
                return false;
            }
            List<Disposable> list = this.f9665a;
            if (list != null && list.remove(disposable)) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: a */
    void m3186a(List<Disposable> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Disposable disposable : list) {
            try {
                disposable.dispose();
            } catch (Throwable th) {
                Exceptions.m3207b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
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
