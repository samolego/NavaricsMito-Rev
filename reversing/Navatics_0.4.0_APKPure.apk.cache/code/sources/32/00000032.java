package android.arch.lifecycle;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

/* compiled from: ViewModelProvider.java */
/* renamed from: android.arch.lifecycle.m, reason: use source file name */
/* loaded from: classes.dex */
public class ViewModelProvider {

    /* renamed from: a */
    private final a f71a;

    /* renamed from: b */
    private final ViewModelStore f72b;

    /* compiled from: ViewModelProvider.java */
    /* renamed from: android.arch.lifecycle.m$a */
    /* loaded from: classes.dex */
    public interface a {
        @NonNull
        <T extends AbstractC0022l> T create(@NonNull Class<T> cls);
    }

    public ViewModelProvider(@NonNull ViewModelStore viewModelStore, @NonNull a aVar) {
        this.f71a = aVar;
        this.f72b = viewModelStore;
    }

    @NonNull
    @MainThread
    /* renamed from: a */
    public <T extends AbstractC0022l> T m104a(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) m105a("android.arch.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    @NonNull
    @MainThread
    /* renamed from: a */
    public <T extends AbstractC0022l> T m105a(@NonNull String str, @NonNull Class<T> cls) {
        T t = (T) this.f72b.m106a(str);
        if (cls.isInstance(t)) {
            return t;
        }
        T t2 = (T) this.f71a.create(cls);
        this.f72b.m108a(str, t2);
        return t2;
    }
}