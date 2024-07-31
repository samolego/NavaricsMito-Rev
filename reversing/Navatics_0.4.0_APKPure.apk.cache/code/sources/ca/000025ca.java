package org.apache.ftpserver.p102b.p103a.p104a;

import java.io.File;
import java.io.FileFilter;

/* compiled from: NameEqualsFileFilter.java */
/* renamed from: org.apache.ftpserver.b.a.a.a, reason: use source file name */
/* loaded from: classes2.dex */
public class NameEqualsFileFilter implements FileFilter {

    /* renamed from: a */
    private final String f10975a;

    /* renamed from: b */
    private final boolean f10976b;

    public NameEqualsFileFilter(String str, boolean z) {
        this.f10975a = str;
        this.f10976b = z;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        if (this.f10976b) {
            return file.getName().equalsIgnoreCase(this.f10975a);
        }
        return file.getName().equals(this.f10975a);
    }
}