package android.arch.lifecycle;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

/* renamed from: android.arch.lifecycle.m */
/* loaded from: classes.dex */
public class ViewModelProvider {

    /* renamed from: a */
    private final InterfaceC0018a f71a;

    /* renamed from: b */
    private final ViewModelStore f72b;

    /* compiled from: ViewModelProvider.java */
    /* renamed from: android.arch.lifecycle.m$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0018a {
        @NonNull
        <T extends ViewModel> T create(@NonNull Class<T> cls);
    }

    public ViewModelProvider(@NonNull ViewModelStore viewModelStore, @NonNull InterfaceC0018a interfaceC0018a) {
        this.f71a = interfaceC0018a;
        this.f72b = viewModelStore;
    }

    @NonNull
    @MainThread
    /* renamed from: a */
    public <T extends ViewModel> T m12852a(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) m12851a("android.arch.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    @NonNull
    @MainThread
    /* renamed from: a */
    public <T extends ViewModel> T m12851a(@NonNull String str, @NonNull Class<T> cls) {
        T t = (T) this.f72b.m12849a(str);
        if (cls.isInstance(t)) {
            return t;
        }
        T t2 = (T) this.f71a.create(cls);
        this.f72b.m12848a(str, t2);
        return t2;
    }
}
