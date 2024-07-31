package com.bumptech.glide.load;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.p022a.ArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface ImageHeaderParser {
    /* renamed from: a */
    int mo11969a(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException;

    @NonNull
    /* renamed from: a */
    ImageType mo11970a(@NonNull InputStream inputStream) throws IOException;

    @NonNull
    /* renamed from: a */
    ImageType mo11968a(@NonNull ByteBuffer byteBuffer) throws IOException;

    /* loaded from: classes.dex */
    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        
        private final boolean hasAlpha;

        ImageType(boolean z) {
            this.hasAlpha = z;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }
}
