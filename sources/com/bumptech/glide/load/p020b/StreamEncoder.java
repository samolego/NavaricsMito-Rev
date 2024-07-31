package com.bumptech.glide.load.p020b;

import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.p022a.ArrayPool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.t */
/* loaded from: classes.dex */
public class StreamEncoder implements Encoder<InputStream> {

    /* renamed from: a */
    private final ArrayPool f683a;

    public StreamEncoder(ArrayPool arrayPool) {
        this.f683a = arrayPool;
    }

    @Override // com.bumptech.glide.load.Encoder
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo11855a(@NonNull InputStream inputStream, @NonNull File file, @NonNull Options options) {
        byte[] bArr = (byte[]) this.f683a.mo12200a(65536, byte[].class);
        boolean z = false;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        } catch (IOException e) {
                            e = e;
                            fileOutputStream = fileOutputStream2;
                            if (Log.isLoggable("StreamEncoder", 3)) {
                                Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            this.f683a.mo12195a((ArrayPool) bArr);
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            this.f683a.mo12195a((ArrayPool) bArr);
                            throw th;
                        }
                    }
                    fileOutputStream2.close();
                    z = true;
                    fileOutputStream2.close();
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (IOException unused2) {
            }
            this.f683a.mo12195a((ArrayPool) bArr);
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
