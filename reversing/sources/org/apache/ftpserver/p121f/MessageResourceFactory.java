package org.apache.ftpserver.p121f;

import java.io.File;
import java.util.List;
import org.apache.ftpserver.p121f.p122a.DefaultMessageResource;

/* renamed from: org.apache.ftpserver.f.b */
/* loaded from: classes2.dex */
public class MessageResourceFactory {

    /* renamed from: a */
    private List<String> f11095a;

    /* renamed from: b */
    private File f11096b;

    /* renamed from: a */
    public MessageResource m1785a() {
        return new DefaultMessageResource(this.f11095a, this.f11096b);
    }
}
