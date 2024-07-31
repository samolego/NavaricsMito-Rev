package okhttp3.internal.p095d;

import java.io.File;
import java.io.IOException;

/* compiled from: FileSystem.java */
/* renamed from: okhttp3.internal.d.a */
/* loaded from: classes2.dex */
public interface InterfaceC2947a {

    /* renamed from: a */
    public static final InterfaceC2947a f10312a = new InterfaceC2947a() { // from class: okhttp3.internal.d.a.1
        @Override // okhttp3.internal.p095d.InterfaceC2947a
        /* renamed from: a */
        public void mo10071a(File file) throws IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }

        @Override // okhttp3.internal.p095d.InterfaceC2947a
        /* renamed from: b */
        public boolean mo10073b(File file) {
            return file.exists();
        }

        @Override // okhttp3.internal.p095d.InterfaceC2947a
        /* renamed from: c */
        public long mo10074c(File file) {
            return file.length();
        }

        @Override // okhttp3.internal.p095d.InterfaceC2947a
        /* renamed from: a */
        public void mo10072a(File file, File file2) throws IOException {
            mo10071a(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }
    };

    /* renamed from: a */
    void mo10071a(File file) throws IOException;

    /* renamed from: a */
    void mo10072a(File file, File file2) throws IOException;

    /* renamed from: b */
    boolean mo10073b(File file);

    /* renamed from: c */
    long mo10074c(File file);
}