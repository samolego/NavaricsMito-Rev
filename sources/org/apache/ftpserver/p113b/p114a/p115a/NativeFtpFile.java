package org.apache.ftpserver.p113b.p114a.p115a;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.ftpserver.ftplet.FtpFile;
import org.apache.ftpserver.ftplet.User;
import org.apache.ftpserver.p123g.p124a.WriteRequest;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.b.a.a.c */
/* loaded from: classes2.dex */
public class NativeFtpFile implements FtpFile {

    /* renamed from: a */
    private final InterfaceC3153b f10941a = C3154c.m262a(NativeFtpFile.class);

    /* renamed from: b */
    private final String f10942b;

    /* renamed from: c */
    private final File f10943c;

    /* renamed from: d */
    private final User f10944d;

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: h */
    public String mo1760h() {
        return "user";
    }

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: i */
    public String mo1759i() {
        return "group";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public NativeFtpFile(String str, File file, User user) {
        if (str == null) {
            throw new IllegalArgumentException("fileName can not be null");
        }
        if (file == null) {
            throw new IllegalArgumentException("file can not be null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("fileName can not be empty");
        }
        if (str.charAt(0) != '/') {
            throw new IllegalArgumentException("fileName must be an absolut path");
        }
        this.f10942b = str;
        this.f10943c = file;
        this.f10944d = user;
    }

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: a */
    public String mo1771a() {
        String str = this.f10942b;
        int length = str.length();
        if (length != 1) {
            int i = length - 1;
            return str.charAt(i) == '/' ? str.substring(0, i) : str;
        }
        return str;
    }

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: b */
    public String mo1768b() {
        if (this.f10942b.equals("/")) {
            return "/";
        }
        String str = this.f10942b;
        int length = str.length() - 1;
        if (str.charAt(length) == '/') {
            str = str.substring(0, length);
        }
        int lastIndexOf = str.lastIndexOf(47);
        return lastIndexOf != -1 ? str.substring(lastIndexOf + 1) : str;
    }

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: c */
    public boolean mo1766c() {
        return this.f10943c.isHidden();
    }

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: d */
    public boolean mo1764d() {
        return this.f10943c.isDirectory();
    }

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: e */
    public boolean mo1763e() {
        return this.f10943c.isFile();
    }

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: f */
    public boolean mo1762f() {
        return this.f10943c.exists();
    }

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: g */
    public long mo1761g() {
        return this.f10943c.length();
    }

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: j */
    public int mo1758j() {
        return this.f10943c.isDirectory() ? 3 : 1;
    }

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: k */
    public long mo1757k() {
        return this.f10943c.lastModified();
    }

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: a */
    public boolean mo1770a(long j) {
        return this.f10943c.setLastModified(j);
    }

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: l */
    public boolean mo1756l() {
        return this.f10943c.canRead();
    }

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: m */
    public boolean mo1755m() {
        InterfaceC3153b interfaceC3153b = this.f10941a;
        interfaceC3153b.debug("Checking authorization for " + mo1771a());
        if (this.f10944d.mo1713a(new WriteRequest(mo1771a())) == null) {
            this.f10941a.debug("Not authorized");
            return false;
        }
        this.f10941a.debug("Checking if file exists");
        if (this.f10943c.exists()) {
            InterfaceC3153b interfaceC3153b2 = this.f10941a;
            interfaceC3153b2.debug("Checking can write: " + this.f10943c.canWrite());
            return this.f10943c.canWrite();
        }
        this.f10941a.debug("Authorized");
        return true;
    }

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: n */
    public boolean mo1754n() {
        if ("/".equals(this.f10942b)) {
            return false;
        }
        String mo1771a = mo1771a();
        if (this.f10944d.mo1713a(new WriteRequest(mo1771a)) == null) {
            return false;
        }
        int lastIndexOf = mo1771a.lastIndexOf(47);
        return new NativeFtpFile(lastIndexOf == 0 ? "/" : mo1771a.substring(0, lastIndexOf), this.f10943c.getAbsoluteFile().getParentFile(), this.f10944d).mo1755m();
    }

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: o */
    public boolean mo1753o() {
        if (mo1754n()) {
            return this.f10943c.delete();
        }
        return false;
    }

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: a */
    public boolean mo1769a(FtpFile ftpFile) {
        if (ftpFile.mo1755m() && mo1756l()) {
            File file = ((NativeFtpFile) ftpFile).f10943c;
            if (file.exists()) {
                return false;
            }
            return this.f10943c.renameTo(file);
        }
        return false;
    }

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: p */
    public boolean mo1752p() {
        if (mo1755m()) {
            return this.f10943c.mkdir();
        }
        return false;
    }

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: q */
    public List<FtpFile> mo1751q() {
        File[] listFiles;
        File file;
        if (this.f10943c.isDirectory() && (listFiles = this.f10943c.listFiles()) != null) {
            Arrays.sort(listFiles, new Comparator<File>() { // from class: org.apache.ftpserver.b.a.a.c.1
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(File file2, File file3) {
                    return file2.getName().compareTo(file3.getName());
                }
            });
            String mo1771a = mo1771a();
            if (mo1771a.charAt(mo1771a.length() - 1) != '/') {
                mo1771a = mo1771a + '/';
            }
            FtpFile[] ftpFileArr = new FtpFile[listFiles.length];
            for (int i = 0; i < listFiles.length; i++) {
                ftpFileArr[i] = new NativeFtpFile(mo1771a + file.getName(), listFiles[i], this.f10944d);
            }
            return Collections.unmodifiableList(Arrays.asList(ftpFileArr));
        }
        return null;
    }

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: b */
    public OutputStream mo1767b(long j) throws IOException {
        if (!mo1755m()) {
            throw new IOException("No write permission : " + this.f10943c.getName());
        }
        final RandomAccessFile randomAccessFile = new RandomAccessFile(this.f10943c, "rw");
        randomAccessFile.setLength(j);
        randomAccessFile.seek(j);
        return new FileOutputStream(randomAccessFile.getFD()) { // from class: org.apache.ftpserver.b.a.a.c.2
            @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                super.close();
                randomAccessFile.close();
            }
        };
    }

    @Override // org.apache.ftpserver.ftplet.FtpFile
    /* renamed from: c */
    public InputStream mo1765c(long j) throws IOException {
        if (!mo1756l()) {
            throw new IOException("No read permission : " + this.f10943c.getName());
        }
        final RandomAccessFile randomAccessFile = new RandomAccessFile(this.f10943c, "r");
        randomAccessFile.seek(j);
        return new FileInputStream(randomAccessFile.getFD()) { // from class: org.apache.ftpserver.b.a.a.c.3
            @Override // java.io.FileInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                super.close();
                randomAccessFile.close();
            }
        };
    }

    public boolean equals(Object obj) {
        if (obj instanceof NativeFtpFile) {
            try {
                return this.f10943c.getCanonicalPath().equals(((NativeFtpFile) obj).f10943c.getCanonicalPath());
            } catch (IOException e) {
                throw new RuntimeException("Failed to get the canonical path", e);
            }
        }
        return false;
    }

    public int hashCode() {
        try {
            return this.f10943c.getCanonicalPath().hashCode();
        } catch (IOException unused) {
            return 0;
        }
    }
}
