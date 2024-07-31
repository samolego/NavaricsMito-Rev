package com.bumptech.glide.load.p020b;

import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.p018a.DataFetcher;
import com.bumptech.glide.load.p020b.ModelLoader;
import com.bumptech.glide.p017d.ObjectKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.f */
/* loaded from: classes.dex */
public class FileLoader<Data> implements ModelLoader<File, Data> {

    /* renamed from: a */
    private final InterfaceC0646d<Data> f620a;

    /* compiled from: FileLoader.java */
    /* renamed from: com.bumptech.glide.load.b.f$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0646d<Data> {
        /* renamed from: a */
        Class<Data> mo12348a();

        /* renamed from: a */
        void mo12345a(Data data) throws IOException;

        /* renamed from: b */
        Data mo12344b(File file) throws FileNotFoundException;
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo7359a(@NonNull File file) {
        return true;
    }

    public FileLoader(InterfaceC0646d<Data> interfaceC0646d) {
        this.f620a = interfaceC0646d;
    }

    @Override // com.bumptech.glide.load.p020b.ModelLoader
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public ModelLoader.C0656a<Data> mo7358a(@NonNull File file, int i, int i2, @NonNull Options options) {
        return new ModelLoader.C0656a<>(new ObjectKey(file), new C0645c(file, this.f620a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileLoader.java */
    /* renamed from: com.bumptech.glide.load.b.f$c */
    /* loaded from: classes.dex */
    public static final class C0645c<Data> implements DataFetcher<Data> {

        /* renamed from: a */
        private final File f622a;

        /* renamed from: b */
        private final InterfaceC0646d<Data> f623b;

        /* renamed from: c */
        private Data f624c;

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: c */
        public void mo7363c() {
        }

        C0645c(File file, InterfaceC0646d<Data> interfaceC0646d) {
            this.f622a = file;
            this.f623b = interfaceC0646d;
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: a */
        public void mo7365a(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC0615a<? super Data> interfaceC0615a) {
            try {
                this.f624c = this.f623b.mo12344b(this.f622a);
                interfaceC0615a.mo12019a((DataFetcher.InterfaceC0615a<? super Data>) ((Data) this.f624c));
            } catch (FileNotFoundException e) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e);
                }
                interfaceC0615a.mo12020a((Exception) e);
            }
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        /* renamed from: b */
        public void mo7364b() {
            Data data = this.f624c;
            if (data != null) {
                try {
                    this.f623b.mo12345a(data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        @NonNull
        /* renamed from: a */
        public Class<Data> mo7366a() {
            return this.f623b.mo12348a();
        }

        @Override // com.bumptech.glide.load.p018a.DataFetcher
        @NonNull
        /* renamed from: d */
        public DataSource mo7362d() {
            return DataSource.LOCAL;
        }
    }

    /* compiled from: FileLoader.java */
    /* renamed from: com.bumptech.glide.load.b.f$a */
    /* loaded from: classes.dex */
    public static class C0642a<Data> implements ModelLoaderFactory<File, Data> {

        /* renamed from: a */
        private final InterfaceC0646d<Data> f621a;

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        /* renamed from: a */
        public final void mo7357a() {
        }

        public C0642a(InterfaceC0646d<Data> interfaceC0646d) {
            this.f621a = interfaceC0646d;
        }

        @Override // com.bumptech.glide.load.p020b.ModelLoaderFactory
        @NonNull
        /* renamed from: a */
        public final ModelLoader<File, Data> mo7356a(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new FileLoader(this.f621a);
        }
    }

    /* compiled from: FileLoader.java */
    /* renamed from: com.bumptech.glide.load.b.f$e */
    /* loaded from: classes.dex */
    public static class C0647e extends C0642a<InputStream> {
        public C0647e() {
            super(new InterfaceC0646d<InputStream>() { // from class: com.bumptech.glide.load.b.f.e.1
                @Override // com.bumptech.glide.load.p020b.FileLoader.InterfaceC0646d
                /* renamed from: a */
                public InputStream mo12344b(File file) throws FileNotFoundException {
                    return new FileInputStream(file);
                }

                @Override // com.bumptech.glide.load.p020b.FileLoader.InterfaceC0646d
                /* renamed from: a  reason: avoid collision after fix types in other method */
                public void mo12345a(InputStream inputStream) throws IOException {
                    inputStream.close();
                }

                @Override // com.bumptech.glide.load.p020b.FileLoader.InterfaceC0646d
                /* renamed from: a */
                public Class<InputStream> mo12348a() {
                    return InputStream.class;
                }
            });
        }
    }

    /* compiled from: FileLoader.java */
    /* renamed from: com.bumptech.glide.load.b.f$b */
    /* loaded from: classes.dex */
    public static class C0643b extends C0642a<ParcelFileDescriptor> {
        public C0643b() {
            super(new InterfaceC0646d<ParcelFileDescriptor>() { // from class: com.bumptech.glide.load.b.f.b.1
                @Override // com.bumptech.glide.load.p020b.FileLoader.InterfaceC0646d
                /* renamed from: a */
                public ParcelFileDescriptor mo12344b(File file) throws FileNotFoundException {
                    return ParcelFileDescriptor.open(file, 268435456);
                }

                @Override // com.bumptech.glide.load.p020b.FileLoader.InterfaceC0646d
                /* renamed from: a  reason: avoid collision after fix types in other method */
                public void mo12345a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                    parcelFileDescriptor.close();
                }

                @Override // com.bumptech.glide.load.p020b.FileLoader.InterfaceC0646d
                /* renamed from: a */
                public Class<ParcelFileDescriptor> mo12348a() {
                    return ParcelFileDescriptor.class;
                }
            });
        }
    }
}
