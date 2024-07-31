package com.navatics.robot.transport;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: VideoInputStream.java */
/* renamed from: com.navatics.robot.transport.ab, reason: use source file name */
/* loaded from: classes.dex */
public abstract class VideoInputStream extends InputStream {

    /* renamed from: a */
    private List<a> f6531a = new ArrayList();

    /* compiled from: VideoInputStream.java */
    /* renamed from: com.navatics.robot.transport.ab$a */
    /* loaded from: classes.dex */
    public interface a {
        /* renamed from: a */
        void mo6544a(VideoInputStream videoInputStream);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        Iterator<a> it = this.f6531a.iterator();
        while (it.hasNext()) {
            it.next().mo6544a(this);
        }
        this.f6531a.clear();
    }

    public void addOnClosedListener(a aVar) {
        this.f6531a.add(aVar);
    }

    public void removeOnClosedListener(a aVar) {
        this.f6531a.remove(aVar);
    }
}