package org.apache.ftpserver.p113b.p114a.p115a;

import java.io.File;
import java.io.FileFilter;

/* renamed from: org.apache.ftpserver.b.a.a.a */
/* loaded from: classes2.dex */
public class NameEqualsFileFilter implements FileFilter {

    /* renamed from: a */
    private final String f10934a;

    /* renamed from: b */
    private final boolean f10935b;

    public NameEqualsFileFilter(String str, boolean z) {
        this.f10934a = str;
        this.f10935b = z;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        if (this.f10935b) {
            return file.getName().equalsIgnoreCase(this.f10934a);
        }
        return file.getName().equals(this.f10934a);
    }
}
