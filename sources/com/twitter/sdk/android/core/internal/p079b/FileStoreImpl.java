package com.twitter.sdk.android.core.internal.p079b;

import android.content.Context;
import com.twitter.sdk.android.core.Twitter;
import java.io.File;

/* renamed from: com.twitter.sdk.android.core.internal.b.a */
/* loaded from: classes2.dex */
public class FileStoreImpl {

    /* renamed from: a */
    private final Context f8495a;

    public FileStoreImpl(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        this.f8495a = context;
    }

    /* renamed from: a */
    public File m4483a() {
        return m4482a(this.f8495a.getFilesDir());
    }

    /* renamed from: a */
    File m4482a(File file) {
        if (file != null) {
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            Twitter.m4253h().mo4559b("Twitter", "Couldn't create file");
            return null;
        }
        Twitter.m4253h().mo4561a("Twitter", "Null File");
        return null;
    }
}
