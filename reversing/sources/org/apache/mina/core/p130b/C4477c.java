package org.apache.mina.core.p130b;

import java.io.File;
import java.nio.channels.FileChannel;

/* renamed from: org.apache.mina.core.b.c */
/* loaded from: classes2.dex */
public class FilenameFileRegion extends DefaultFileRegion {

    /* renamed from: a */
    private final File f11330a;

    public FilenameFileRegion(File file, FileChannel fileChannel, long j, long j2) {
        super(fileChannel, j, j2);
        if (file == null) {
            throw new IllegalArgumentException("file can not be null");
        }
        this.f11330a = file;
    }
}
