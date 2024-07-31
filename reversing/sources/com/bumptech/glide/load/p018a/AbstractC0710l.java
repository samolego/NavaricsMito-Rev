package com.bumptech.glide.load.p018a;

import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.p018a.DataFetcher;
import java.io.FileNotFoundException;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.a.l */
/* loaded from: classes.dex */
public abstract class LocalUriFetcher<T> implements DataFetcher<T> {

    /* renamed from: a */
    private final Uri f589a;

    /* renamed from: b */
    private final ContentResolver f590b;

    /* renamed from: c */
    private T f591c;

    /* renamed from: a */
    protected abstract void mo12386a(T t) throws IOException;

    /* renamed from: b */
    protected abstract T mo12385b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    /* renamed from: c */
    public void mo7363c() {
    }

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this.f590b = contentResolver;
        this.f589a = uri;
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    /* renamed from: a */
    public final void mo7365a(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC0615a<? super T> interfaceC0615a) {
        try {
            this.f591c = mo12385b(this.f589a, this.f590b);
            interfaceC0615a.mo12019a((DataFetcher.InterfaceC0615a<? super T>) ((T) this.f591c));
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e);
            }
            interfaceC0615a.mo12020a((Exception) e);
        }
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    /* renamed from: b */
    public void mo7364b() {
        T t = this.f591c;
        if (t != null) {
            try {
                mo12386a(t);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    @NonNull
    /* renamed from: d */
    public DataSource mo7362d() {
        return DataSource.LOCAL;
    }
}
