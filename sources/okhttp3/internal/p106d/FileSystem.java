package okhttp3.internal.p106d;

import java.io.File;
import java.io.IOException;

/* renamed from: okhttp3.internal.d.a */
/* loaded from: classes2.dex */
public interface FileSystem {

    /* renamed from: a */
    public static final FileSystem f10271a = new FileSystem() { // from class: okhttp3.internal.d.a.1
        @Override // okhttp3.internal.p106d.FileSystem
        /* renamed from: a */
        public void mo2799a(File file) throws IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }

        @Override // okhttp3.internal.p106d.FileSystem
        /* renamed from: b */
        public boolean mo2797b(File file) {
            return file.exists();
        }

        @Override // okhttp3.internal.p106d.FileSystem
        /* renamed from: c */
        public long mo2796c(File file) {
            return file.length();
        }

        @Override // okhttp3.internal.p106d.FileSystem
        /* renamed from: a */
        public void mo2798a(File file, File file2) throws IOException {
            mo2799a(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }
    };

    /* renamed from: a */
    void mo2799a(File file) throws IOException;

    /* renamed from: a */
    void mo2798a(File file, File file2) throws IOException;

    /* renamed from: b */
    boolean mo2797b(File file);

    /* renamed from: c */
    long mo2796c(File file);
}
