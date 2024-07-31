package com.navatics.app.framework.p054f;

import com.navatics.robot.utils.HexUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.framework.f.g */
/* loaded from: classes.dex */
public class NalStreamExtractor {

    /* renamed from: a */
    private static final C3044k f4483a = C3044k.m1564a(NalStreamExtractor.class);

    /* renamed from: b */
    private C1798a f4484b = new C1798a();

    /* renamed from: c */
    private int f4485c = 0;

    /* renamed from: d */
    private int f4486d = 0;

    /* renamed from: e */
    private boolean f4487e = false;

    /* renamed from: f */
    private boolean f4488f;

    /* renamed from: g */
    private InputStream f4489g;

    public NalStreamExtractor(InputStream inputStream, boolean z) {
        this.f4489g = inputStream;
        this.f4488f = z;
    }

    /* renamed from: a */
    public NalUnit m8399a() throws IOException {
        while (true) {
            int read = this.f4489g.read();
            NalUnit nalUnit = null;
            if (read != -1) {
                if (this.f4488f && this.f4485c == 2 && read == 3) {
                    this.f4485c = 0;
                } else {
                    if (this.f4487e) {
                        this.f4484b.write(read);
                    } else if (read == 0 || read == 1) {
                        this.f4484b.write(read);
                    }
                    if (this.f4485c == 0 && read == 0) {
                        this.f4485c = 1;
                    } else if (this.f4485c == 1 && read == 0) {
                        this.f4485c = 2;
                    } else if (this.f4485c == 2 && read == 0) {
                        this.f4485c = 3;
                        if (this.f4487e) {
                            byte[] m8395a = this.f4484b.m8395a();
                            this.f4484b.reset();
                            this.f4484b.write(0);
                            this.f4484b.write(0);
                            this.f4484b.write(0);
                            this.f4487e = false;
                            int i = this.f4486d;
                            if (i != 3 && i != 4) {
                                throw new AssertionError("startCodeLenInBytes " + this.f4486d);
                            } else if (m8397a(m8395a)) {
                                return NalUnit.m8391a(m8395a, this.f4486d);
                            }
                        } else {
                            continue;
                        }
                    } else if (this.f4485c == 2 && read == 1) {
                        if (this.f4487e) {
                            byte[] m8395a2 = this.f4484b.m8395a();
                            this.f4484b.reset();
                            this.f4484b.write(0);
                            this.f4484b.write(0);
                            this.f4484b.write(1);
                            int i2 = this.f4486d;
                            if (i2 != 3 && i2 != 4) {
                                throw new AssertionError("startCodeLenInBytes " + this.f4486d);
                            } else if (m8397a(m8395a2)) {
                                nalUnit = NalUnit.m8391a(m8395a2, this.f4486d);
                            }
                        }
                        this.f4485c = 0;
                        this.f4487e = true;
                        this.f4486d = 3;
                        if (nalUnit != null) {
                            return nalUnit;
                        }
                    } else if (this.f4485c == 3 && read == 1) {
                        this.f4487e = true;
                        this.f4485c = 0;
                        this.f4486d = 4;
                    } else if (this.f4485c != 0) {
                        this.f4485c = 0;
                    }
                }
            } else {
                byte[] byteArray = this.f4484b.toByteArray();
                this.f4484b.reset();
                if (byteArray.length > 0) {
                    if (byteArray.length < 4) {
                        throw new IOException("s len " + byteArray.length + " : " + String.valueOf(HexUtil.m5885a(byteArray)));
                    }
                    return NalUnit.m8391a(byteArray, this.f4486d);
                }
                return null;
            }
        }
    }

    /* renamed from: a */
    public byte[] m8398a(boolean z) {
        if (z) {
            try {
                this.f4489g.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this.f4484b.toByteArray();
    }

    /* renamed from: b */
    public void m8396b() {
        m8398a(true);
    }

    /* renamed from: a */
    private boolean m8397a(byte[] bArr) {
        if (bArr[0] == 0 && bArr[1] == 0) {
            return (bArr[2] == 0 && bArr[3] == 1) || bArr[2] == 1;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NalStreamExtractor.java */
    /* renamed from: com.navatics.app.framework.f.g$a */
    /* loaded from: classes.dex */
    public static class C1798a extends ByteArrayOutputStream {
        C1798a() {
        }

        /* renamed from: a */
        public byte[] m8395a() {
            if (this.count > 3) {
                return Arrays.copyOf(this.buf, this.count - 3);
            }
            return null;
        }
    }
}
