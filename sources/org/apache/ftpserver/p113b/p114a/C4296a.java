package org.apache.ftpserver.p113b.p114a;

import java.io.File;
import org.apache.ftpserver.ftplet.FileSystemFactory;
import org.apache.ftpserver.ftplet.FileSystemView;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.User;
import org.apache.ftpserver.p113b.p114a.p115a.NativeFileSystemView;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.b.a.a */
/* loaded from: classes2.dex */
public class NativeFileSystemFactory implements FileSystemFactory {

    /* renamed from: a */
    private final InterfaceC3153b f10931a = C3154c.m262a(NativeFileSystemFactory.class);

    /* renamed from: b */
    private boolean f10932b;

    /* renamed from: c */
    private boolean f10933c;

    @Override // org.apache.ftpserver.ftplet.FileSystemFactory
    /* renamed from: a */
    public FileSystemView mo1776a(User user) throws FtpException {
        NativeFileSystemView nativeFileSystemView;
        synchronized (user) {
            if (this.f10932b) {
                String mo1706e = user.mo1706e();
                File file = new File(mo1706e);
                if (file.isFile()) {
                    InterfaceC3153b interfaceC3153b = this.f10931a;
                    interfaceC3153b.warn("Not a directory :: " + mo1706e);
                    throw new FtpException("Not a directory :: " + mo1706e);
                } else if (!file.exists() && !file.mkdirs()) {
                    InterfaceC3153b interfaceC3153b2 = this.f10931a;
                    interfaceC3153b2.warn("Cannot create user home :: " + mo1706e);
                    throw new FtpException("Cannot create user home :: " + mo1706e);
                }
            }
            nativeFileSystemView = new NativeFileSystemView(user, this.f10933c);
        }
        return nativeFileSystemView;
    }
}
