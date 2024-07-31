package org.apache.mina.core.p119b;

import java.io.File;
import java.nio.channels.FileChannel;

/* compiled from: FilenameFileRegion.java */
/* renamed from: org.apache.mina.core.b.c, reason: use source file name */
/* loaded from: classes2.dex */
public class FilenameFileRegion extends DefaultFileRegion {

    /* renamed from: a */
    private final File f11371a;

    public FilenameFileRegion(File file, FileChannel fileChannel, long j, long j2) {
        super(fileChannel, j, j2);
        if (file == null) {
            throw new IllegalArgumentException("file can not be null");
        }
        this.f11371a = file;
    }
}