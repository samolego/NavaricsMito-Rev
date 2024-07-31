package com.bumptech.glide.load.p018a.p019a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.p018a.DataFetcher;
import com.bumptech.glide.load.p018a.ExifOrientationStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.a.a.c */
/* loaded from: classes.dex */
public class ThumbFetcher implements DataFetcher<InputStream> {

    /* renamed from: a */
    private final Uri f552a;

    /* renamed from: b */
    private final ThumbnailStreamOpener f553b;

    /* renamed from: c */
    private InputStream f554c;

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    /* renamed from: c */
    public void mo7363c() {
    }

    /* renamed from: a */
    public static ThumbFetcher m12418a(Context context, Uri uri) {
        return m12417a(context, uri, new C0613a(context.getContentResolver()));
    }

    /* renamed from: b */
    public static ThumbFetcher m12416b(Context context, Uri uri) {
        return m12417a(context, uri, new C0614b(context.getContentResolver()));
    }

    /* renamed from: a */
    private static ThumbFetcher m12417a(Context context, Uri uri, ThumbnailQuery thumbnailQuery) {
        return new ThumbFetcher(uri, new ThumbnailStreamOpener(Glide.m12523a(context).m12506h().m12628a(), thumbnailQuery, Glide.m12523a(context).m12517b(), context.getContentResolver()));
    }

    @VisibleForTesting
    ThumbFetcher(Uri uri, ThumbnailStreamOpener thumbnailStreamOpener) {
        this.f552a = uri;
        this.f553b = thumbnailStreamOpener;
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    /* renamed from: a */
    public void mo7365a(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC0615a<? super InputStream> interfaceC0615a) {
        try {
            this.f554c = m12415e();
            interfaceC0615a.mo12019a((DataFetcher.InterfaceC0615a<? super InputStream>) this.f554c);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e);
            }
            interfaceC0615a.mo12020a((Exception) e);
        }
    }

    /* renamed from: e */
    private InputStream m12415e() throws FileNotFoundException {
        InputStream m12411b = this.f553b.m12411b(this.f552a);
        int m12413a = m12411b != null ? this.f553b.m12413a(this.f552a) : -1;
        return m12413a != -1 ? new ExifOrientationStream(m12411b, m12413a) : m12411b;
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    /* renamed from: b */
    public void mo7364b() {
        InputStream inputStream = this.f554c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    @NonNull
    /* renamed from: a */
    public Class<InputStream> mo7366a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    @NonNull
    /* renamed from: d */
    public DataSource mo7362d() {
        return DataSource.LOCAL;
    }

    /* compiled from: ThumbFetcher.java */
    /* renamed from: com.bumptech.glide.load.a.a.c$b */
    /* loaded from: classes.dex */
    static class C0614b implements ThumbnailQuery {

        /* renamed from: b */
        private static final String[] f557b = {"_data"};

        /* renamed from: a */
        private final ContentResolver f558a;

        C0614b(ContentResolver contentResolver) {
            this.f558a = contentResolver;
        }

        @Override // com.bumptech.glide.load.p018a.p019a.ThumbnailQuery
        /* renamed from: a */
        public Cursor mo12414a(Uri uri) {
            return this.f558a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f557b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* compiled from: ThumbFetcher.java */
    /* renamed from: com.bumptech.glide.load.a.a.c$a */
    /* loaded from: classes.dex */
    static class C0613a implements ThumbnailQuery {

        /* renamed from: b */
        private static final String[] f555b = {"_data"};

        /* renamed from: a */
        private final ContentResolver f556a;

        C0613a(ContentResolver contentResolver) {
            this.f556a = contentResolver;
        }

        @Override // com.bumptech.glide.load.p018a.p019a.ThumbnailQuery
        /* renamed from: a */
        public Cursor mo12414a(Uri uri) {
            return this.f556a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f555b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }
}
