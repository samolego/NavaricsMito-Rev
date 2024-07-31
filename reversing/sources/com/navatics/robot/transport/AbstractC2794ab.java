package com.navatics.robot.transport;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.navatics.robot.transport.ab */
/* loaded from: classes.dex */
public abstract class VideoInputStream extends InputStream {

    /* renamed from: a */
    private List<InterfaceC2114a> f6502a = new ArrayList();

    /* compiled from: VideoInputStream.java */
    /* renamed from: com.navatics.robot.transport.ab$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2114a {
        /* renamed from: a */
        void mo6056a(VideoInputStream videoInputStream);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        for (InterfaceC2114a interfaceC2114a : this.f6502a) {
            interfaceC2114a.mo6056a(this);
        }
        this.f6502a.clear();
    }

    public void addOnClosedListener(InterfaceC2114a interfaceC2114a) {
        this.f6502a.add(interfaceC2114a);
    }

    public void removeOnClosedListener(InterfaceC2114a interfaceC2114a) {
        this.f6502a.remove(interfaceC2114a);
    }
}
