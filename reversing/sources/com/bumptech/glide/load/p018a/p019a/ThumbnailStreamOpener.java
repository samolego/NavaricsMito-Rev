package com.bumptech.glide.load.p018a.p019a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.engine.p022a.ArrayPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* renamed from: com.bumptech.glide.load.a.a.e */
/* loaded from: classes.dex */
class ThumbnailStreamOpener {

    /* renamed from: a */
    private static final FileService f559a = new FileService();

    /* renamed from: b */
    private final FileService f560b;

    /* renamed from: c */
    private final ThumbnailQuery f561c;

    /* renamed from: d */
    private final ArrayPool f562d;

    /* renamed from: e */
    private final ContentResolver f563e;

    /* renamed from: f */
    private final List<ImageHeaderParser> f564f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThumbnailStreamOpener(List<ImageHeaderParser> list, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this(list, f559a, thumbnailQuery, arrayPool, contentResolver);
    }

    ThumbnailStreamOpener(List<ImageHeaderParser> list, FileService fileService, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this.f560b = fileService;
        this.f561c = thumbnailQuery;
        this.f562d = arrayPool;
        this.f563e = contentResolver;
        this.f564f = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m12413a(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.f563e.openInputStream(uri);
                int m12381b = ImageHeaderParserUtils.m12381b(this.f564f, inputStream, this.f562d);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return m12381b;
            } catch (IOException | NullPointerException e) {
                if (Log.isLoggable("ThumbStreamOpener", 3)) {
                    Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return -1;
                    } catch (IOException unused2) {
                        return -1;
                    }
                }
                return -1;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    /* renamed from: b */
    public InputStream m12411b(Uri uri) throws FileNotFoundException {
        String m12410c = m12410c(uri);
        if (TextUtils.isEmpty(m12410c)) {
            return null;
        }
        File m12425a = this.f560b.m12425a(m12410c);
        if (m12412a(m12425a)) {
            Uri fromFile = Uri.fromFile(m12425a);
            try {
                return this.f563e.openInputStream(fromFile);
            } catch (NullPointerException e) {
                throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e));
            }
        }
        return null;
    }

    @Nullable
    /* renamed from: c */
    private String m12410c(@NonNull Uri uri) {
        Cursor mo12414a = this.f561c.mo12414a(uri);
        if (mo12414a != null) {
            try {
                if (mo12414a.moveToFirst()) {
                    return mo12414a.getString(0);
                }
            } finally {
                if (mo12414a != null) {
                    mo12414a.close();
                }
            }
        }
        if (mo12414a != null) {
            mo12414a.close();
        }
        return null;
    }

    /* renamed from: a */
    private boolean m12412a(File file) {
        return this.f560b.m12426a(file) && 0 < this.f560b.m12424b(file);
    }
}
