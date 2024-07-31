package org.apache.mina.filter.codec.p137a;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import org.apache.mina.core.p129a.AbstractC3054b;
import org.apache.mina.core.session.AttributeKey;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderException;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.RecoverableProtocolDecoderException;

/* renamed from: org.apache.mina.filter.codec.a.b */
/* loaded from: classes2.dex */
public class TextLineDecoder implements ProtocolDecoder {

    /* renamed from: a */
    private final AttributeKey f11623a;

    /* renamed from: b */
    private final Charset f11624b;

    /* renamed from: c */
    private final LineDelimiter f11625c;

    /* renamed from: d */
    private AbstractC3054b f11626d;

    /* renamed from: e */
    private int f11627e;

    /* renamed from: f */
    private int f11628f;

    @Override // org.apache.mina.filter.codec.ProtocolDecoder
    /* renamed from: a */
    public void mo833a(IoSession ioSession, ProtocolDecoderOutput protocolDecoderOutput) throws Exception {
    }

    public TextLineDecoder() {
        this(LineDelimiter.f11616b);
    }

    public TextLineDecoder(LineDelimiter lineDelimiter) {
        this(Charset.defaultCharset(), lineDelimiter);
    }

    public TextLineDecoder(Charset charset) {
        this(charset, LineDelimiter.f11616b);
    }

    public TextLineDecoder(Charset charset, LineDelimiter lineDelimiter) {
        this.f11623a = new AttributeKey(getClass(), "context");
        this.f11627e = 1024;
        this.f11628f = 128;
        if (charset == null) {
            throw new IllegalArgumentException("charset parameter shuld not be null");
        }
        if (lineDelimiter == null) {
            throw new IllegalArgumentException("delimiter parameter should not be null");
        }
        this.f11624b = charset;
        this.f11625c = lineDelimiter;
        if (this.f11626d == null) {
            AbstractC3054b mo1378a = AbstractC3054b.m1362h(2).mo1378a(true);
            try {
                mo1378a.mo1381a(lineDelimiter.m864a(), charset.newEncoder());
            } catch (CharacterCodingException unused) {
            }
            mo1378a.mo1358k();
            this.f11626d = mo1378a;
        }
    }

    @Override // org.apache.mina.filter.codec.ProtocolDecoder
    /* renamed from: a */
    public void mo834a(IoSession ioSession, AbstractC3054b abstractC3054b, ProtocolDecoderOutput protocolDecoderOutput) throws Exception {
        C3098a m860b = m860b(ioSession);
        if (LineDelimiter.f11616b.equals(this.f11625c)) {
            m862a(m860b, ioSession, abstractC3054b, protocolDecoderOutput);
        } else {
            m859b(m860b, ioSession, abstractC3054b, protocolDecoderOutput);
        }
    }

    /* renamed from: b */
    private C3098a m860b(IoSession ioSession) {
        C3098a c3098a = (C3098a) ioSession.mo1009b(this.f11623a);
        if (c3098a == null) {
            C3098a c3098a2 = new C3098a(this.f11628f);
            ioSession.mo1008b(this.f11623a, c3098a2);
            return c3098a2;
        }
        return c3098a;
    }

    @Override // org.apache.mina.filter.codec.ProtocolDecoder
    /* renamed from: a */
    public void mo835a(IoSession ioSession) throws Exception {
        if (((C3098a) ioSession.mo1009b(this.f11623a)) != null) {
            ioSession.mo1006c(this.f11623a);
        }
    }

    /* renamed from: a */
    private void m862a(C3098a c3098a, IoSession ioSession, AbstractC3054b abstractC3054b, ProtocolDecoderOutput protocolDecoderOutput) throws CharacterCodingException, ProtocolDecoderException {
        boolean z;
        int m851d = c3098a.m851d();
        int mo1366f = abstractC3054b.mo1366f();
        int mo1364g = abstractC3054b.mo1364g();
        while (abstractC3054b.mo1356m()) {
            byte mo1355n = abstractC3054b.mo1355n();
            if (mo1355n == 10) {
                m851d++;
                z = true;
            } else if (mo1355n != 13) {
                m851d = 0;
                z = false;
            } else {
                m851d++;
                z = false;
            }
            if (z) {
                int mo1366f2 = abstractC3054b.mo1366f();
                abstractC3054b.mo1367e(mo1366f2);
                abstractC3054b.mo1369d(mo1366f);
                c3098a.m855a(abstractC3054b);
                abstractC3054b.mo1367e(mo1364g);
                abstractC3054b.mo1369d(mo1366f2);
                if (c3098a.m852c() == 0) {
                    AbstractC3054b m854b = c3098a.m854b();
                    m854b.mo1358k();
                    m854b.mo1367e(m854b.mo1364g() - m851d);
                    try {
                        byte[] bArr = new byte[m854b.mo1364g()];
                        m854b.mo1377a(bArr);
                        m863a(ioSession, c3098a.m857a().decode(ByteBuffer.wrap(bArr)).toString(), protocolDecoderOutput);
                        m854b.mo1359j();
                        mo1366f = mo1366f2;
                        m851d = 0;
                    } catch (Throwable th) {
                        m854b.mo1359j();
                        throw th;
                    }
                } else {
                    int m852c = c3098a.m852c();
                    c3098a.m850e();
                    throw new RecoverableProtocolDecoderException("Line is too long: " + m852c);
                }
            }
        }
        abstractC3054b.mo1369d(mo1366f);
        c3098a.m855a(abstractC3054b);
        c3098a.m856a(m851d);
    }

    /* renamed from: b */
    private void m859b(C3098a c3098a, IoSession ioSession, AbstractC3054b abstractC3054b, ProtocolDecoderOutput protocolDecoderOutput) throws CharacterCodingException, ProtocolDecoderException {
        int m851d = c3098a.m851d();
        int mo1366f = abstractC3054b.mo1366f();
        int mo1364g = abstractC3054b.mo1364g();
        while (abstractC3054b.mo1356m()) {
            if (this.f11626d.mo1365f(m851d) == abstractC3054b.mo1355n()) {
                m851d++;
                if (m851d == this.f11626d.mo1364g()) {
                    int mo1366f2 = abstractC3054b.mo1366f();
                    abstractC3054b.mo1367e(mo1366f2);
                    abstractC3054b.mo1369d(mo1366f);
                    c3098a.m855a(abstractC3054b);
                    abstractC3054b.mo1367e(mo1364g);
                    abstractC3054b.mo1369d(mo1366f2);
                    if (c3098a.m852c() == 0) {
                        AbstractC3054b m854b = c3098a.m854b();
                        m854b.mo1358k();
                        m854b.mo1367e(m854b.mo1364g() - m851d);
                        try {
                            m863a(ioSession, m854b.mo1380a(c3098a.m857a()), protocolDecoderOutput);
                            m854b.mo1359j();
                            mo1366f = mo1366f2;
                            m851d = 0;
                        } catch (Throwable th) {
                            m854b.mo1359j();
                            throw th;
                        }
                    } else {
                        int m852c = c3098a.m852c();
                        c3098a.m850e();
                        throw new RecoverableProtocolDecoderException("Line is too long: " + m852c);
                    }
                } else {
                    continue;
                }
            } else {
                abstractC3054b.mo1369d(Math.max(0, abstractC3054b.mo1366f() - m851d));
                m851d = 0;
            }
        }
        abstractC3054b.mo1369d(mo1366f);
        c3098a.m855a(abstractC3054b);
        c3098a.m856a(m851d);
    }

    /* renamed from: a */
    protected void m863a(IoSession ioSession, String str, ProtocolDecoderOutput protocolDecoderOutput) {
        protocolDecoderOutput.mo832a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TextLineDecoder.java */
    /* renamed from: org.apache.mina.filter.codec.a.b$a */
    /* loaded from: classes2.dex */
    public class C3098a {

        /* renamed from: b */
        private final CharsetDecoder f11630b;

        /* renamed from: c */
        private final AbstractC3054b f11631c;

        /* renamed from: d */
        private int f11632d;

        /* renamed from: e */
        private int f11633e;

        private C3098a(int i) {
            this.f11632d = 0;
            this.f11633e = 0;
            this.f11630b = TextLineDecoder.this.f11624b.newDecoder();
            this.f11631c = AbstractC3054b.m1362h(i).mo1378a(true);
        }

        /* renamed from: a */
        public CharsetDecoder m857a() {
            return this.f11630b;
        }

        /* renamed from: b */
        public AbstractC3054b m854b() {
            return this.f11631c;
        }

        /* renamed from: c */
        public int m852c() {
            return this.f11633e;
        }

        /* renamed from: d */
        public int m851d() {
            return this.f11632d;
        }

        /* renamed from: a */
        public void m856a(int i) {
            this.f11632d = i;
        }

        /* renamed from: e */
        public void m850e() {
            this.f11633e = 0;
            this.f11632d = 0;
            this.f11630b.reset();
        }

        /* renamed from: a */
        public void m855a(AbstractC3054b abstractC3054b) {
            if (this.f11633e == 0) {
                if (this.f11631c.mo1366f() > TextLineDecoder.this.f11627e - abstractC3054b.mo1357l()) {
                    this.f11633e = this.f11631c.mo1366f();
                    this.f11631c.mo1359j();
                    m853b(abstractC3054b);
                    return;
                }
                m854b().mo1373b(abstractC3054b);
                return;
            }
            m853b(abstractC3054b);
        }

        /* renamed from: b */
        private void m853b(AbstractC3054b abstractC3054b) {
            int mo1357l = Integer.MAX_VALUE - abstractC3054b.mo1357l();
            int i = this.f11633e;
            if (mo1357l < i) {
                this.f11633e = Integer.MAX_VALUE;
            } else {
                this.f11633e = i + abstractC3054b.mo1357l();
            }
            abstractC3054b.mo1369d(abstractC3054b.mo1364g());
        }
    }
}
