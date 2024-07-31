package com.bumptech.glide.load.resource.p029d;

import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p022a.ArrayPool;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: com.bumptech.glide.load.resource.d.j */
/* loaded from: classes.dex */
public class StreamGifDecoder implements ResourceDecoder<InputStream, GifDrawable> {

    /* renamed from: a */
    private final List<ImageHeaderParser> f1136a;

    /* renamed from: b */
    private final ResourceDecoder<ByteBuffer, GifDrawable> f1137b;

    /* renamed from: c */
    private final ArrayPool f1138c;

    public StreamGifDecoder(List<ImageHeaderParser> list, ResourceDecoder<ByteBuffer, GifDrawable> resourceDecoder, ArrayPool arrayPool) {
        this.f1136a = list;
        this.f1137b = resourceDecoder;
        this.f1138c = arrayPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo11819a(@NonNull InputStream inputStream, @NonNull Options options) throws IOException {
        return !((Boolean) options.m12014a(GifOptions.f1135b)).booleanValue() && ImageHeaderParserUtils.m12383a(this.f1136a, inputStream, this.f1138c) == ImageHeaderParser.ImageType.GIF;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public Resource<GifDrawable> mo11820a(@NonNull InputStream inputStream, int i, int i2, @NonNull Options options) throws IOException {
        byte[] m11823a = m11823a(inputStream);
        if (m11823a == null) {
            return null;
        }
        return this.f1137b.mo11820a(ByteBuffer.wrap(m11823a), i, i2, options);
    }

    /* renamed from: a */
    private static byte[] m11823a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e);
                return null;
            }
            return null;
        }
    }
}
