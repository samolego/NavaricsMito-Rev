package com.bumptech.glide.load.p014a.p015a;

import java.io.File;

/* compiled from: FileService.java */
/* renamed from: com.bumptech.glide.load.a.a.a, reason: use source file name */
/* loaded from: classes.dex */
class FileService {
    /* renamed from: a */
    public boolean m568a(File file) {
        return file.exists();
    }

    /* renamed from: b */
    public long m569b(File file) {
        return file.length();
    }

    /* renamed from: a */
    public File m567a(String str) {
        return new File(str);
    }
}