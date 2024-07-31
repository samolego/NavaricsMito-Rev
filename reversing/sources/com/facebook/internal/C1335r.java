package com.facebook.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookContentProvider;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

/* renamed from: com.facebook.internal.r */
/* loaded from: classes.dex */
public final class NativeAppCallAttachmentStore {

    /* renamed from: a */
    private static final String f2025a = "com.facebook.internal.r";

    /* renamed from: b */
    private static File f2026b;

    private NativeAppCallAttachmentStore() {
    }

    /* renamed from: a */
    public static C0971a m10620a(UUID uuid, Bitmap bitmap) {
        Validate.m10469a(uuid, "callId");
        Validate.m10469a(bitmap, "attachmentBitmap");
        return new C0971a(uuid, bitmap, null);
    }

    /* renamed from: a */
    public static C0971a m10619a(UUID uuid, Uri uri) {
        Validate.m10469a(uuid, "callId");
        Validate.m10469a(uri, "attachmentUri");
        return new C0971a(uuid, null, uri);
    }

    /* renamed from: a */
    private static void m10623a(Bitmap bitmap, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        } finally {
            Utility.m10538a(fileOutputStream);
        }
    }

    /* renamed from: a */
    private static void m10622a(Uri uri, boolean z, File file) throws IOException {
        InputStream openInputStream;
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            if (!z) {
                openInputStream = new FileInputStream(uri.getPath());
            } else {
                openInputStream = FacebookSdk.m10869h().getContentResolver().openInputStream(uri);
            }
            Utility.m10535a(openInputStream, (OutputStream) fileOutputStream);
        } finally {
            Utility.m10538a(fileOutputStream);
        }
    }

    /* renamed from: a */
    public static void m10621a(Collection<C0971a> collection) {
        if (collection == null || collection.size() == 0) {
            return;
        }
        if (f2026b == null) {
            m10614c();
        }
        m10615b();
        ArrayList<File> arrayList = new ArrayList();
        try {
            for (C0971a c0971a : collection) {
                if (c0971a.f2033g) {
                    File m10617a = m10617a(c0971a.f2027a, c0971a.f2029c, true);
                    arrayList.add(m10617a);
                    if (c0971a.f2030d != null) {
                        m10623a(c0971a.f2030d, m10617a);
                    } else if (c0971a.f2031e != null) {
                        m10622a(c0971a.f2031e, c0971a.f2032f, m10617a);
                    }
                }
            }
        } catch (IOException e) {
            String str = f2025a;
            Log.e(str, "Got unexpected exception:" + e);
            for (File file : arrayList) {
                try {
                    file.delete();
                } catch (Exception unused) {
                }
            }
            throw new FacebookException(e);
        }
    }

    /* renamed from: a */
    public static File m10618a(UUID uuid, String str) throws FileNotFoundException {
        if (Utility.m10530a(str) || uuid == null) {
            throw new FileNotFoundException();
        }
        try {
            return m10617a(uuid, str, false);
        } catch (IOException unused) {
            throw new FileNotFoundException();
        }
    }

    /* renamed from: a */
    static synchronized File m10624a() {
        File file;
        synchronized (NativeAppCallAttachmentStore.class) {
            if (f2026b == null) {
                f2026b = new File(FacebookSdk.m10869h().getCacheDir(), "com.facebook.NativeAppCallAttachmentStore.files");
            }
            file = f2026b;
        }
        return file;
    }

    /* renamed from: b */
    static File m10615b() {
        File m10624a = m10624a();
        m10624a.mkdirs();
        return m10624a;
    }

    /* renamed from: a */
    static File m10616a(UUID uuid, boolean z) {
        File file = f2026b;
        if (file == null) {
            return null;
        }
        File file2 = new File(file, uuid.toString());
        if (z && !file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    /* renamed from: a */
    static File m10617a(UUID uuid, String str, boolean z) throws IOException {
        File m10616a = m10616a(uuid, z);
        if (m10616a == null) {
            return null;
        }
        try {
            return new File(m10616a, URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    /* renamed from: c */
    public static void m10614c() {
        Utility.m10537a(m10624a());
    }

    /* compiled from: NativeAppCallAttachmentStore.java */
    /* renamed from: com.facebook.internal.r$a */
    /* loaded from: classes.dex */
    public static final class C0971a {

        /* renamed from: a */
        private final UUID f2027a;

        /* renamed from: b */
        private final String f2028b;

        /* renamed from: c */
        private final String f2029c;

        /* renamed from: d */
        private Bitmap f2030d;

        /* renamed from: e */
        private Uri f2031e;

        /* renamed from: f */
        private boolean f2032f;

        /* renamed from: g */
        private boolean f2033g;

        private C0971a(UUID uuid, Bitmap bitmap, Uri uri) {
            String m11411a;
            this.f2027a = uuid;
            this.f2030d = bitmap;
            this.f2031e = uri;
            boolean z = true;
            if (uri != null) {
                String scheme = uri.getScheme();
                if ("content".equalsIgnoreCase(scheme)) {
                    this.f2032f = true;
                    this.f2033g = (uri.getAuthority() == null || uri.getAuthority().startsWith("media")) ? false : false;
                } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                    this.f2033g = true;
                } else if (!Utility.m10507b(uri)) {
                    throw new FacebookException("Unsupported scheme for media Uri : " + scheme);
                }
            } else if (bitmap != null) {
                this.f2033g = true;
            } else {
                throw new FacebookException("Cannot share media without a bitmap or Uri set");
            }
            this.f2029c = !this.f2033g ? null : UUID.randomUUID().toString();
            if (!this.f2033g) {
                m11411a = this.f2031e.toString();
            } else {
                m11411a = FacebookContentProvider.m11411a(FacebookSdk.m10865l(), uuid, this.f2029c);
            }
            this.f2028b = m11411a;
        }

        /* renamed from: a */
        public String m10613a() {
            return this.f2028b;
        }

        /* renamed from: b */
        public Uri m10611b() {
            return this.f2031e;
        }
    }
}
