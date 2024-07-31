package org.mp4parser;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.List;

/* renamed from: org.mp4parser.a */
/* loaded from: classes2.dex */
public class BasicContainer implements Container {

    /* renamed from: a */
    private List<InterfaceC3117b> f11726a = new ArrayList();

    @Override // org.mp4parser.Container
    /* renamed from: a */
    public List<InterfaceC3117b> mo526a() {
        return this.f11726a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public long m744b() {
        long j = 0;
        for (int i = 0; i < mo526a().size(); i++) {
            j += this.f11726a.get(i).mo400m_();
        }
        return j;
    }

    @Override // org.mp4parser.Container
    /* renamed from: a */
    public <T extends InterfaceC3117b> List<T> mo525a(Class<T> cls, boolean z) {
        ArrayList arrayList = new ArrayList(2);
        List<InterfaceC3117b> mo526a = mo526a();
        for (int i = 0; i < mo526a.size(); i++) {
            InterfaceC3117b interfaceC3117b = mo526a.get(i);
            if (cls.isInstance(interfaceC3117b)) {
                arrayList.add(interfaceC3117b);
            }
            if (z && (interfaceC3117b instanceof Container)) {
                arrayList.addAll(((Container) interfaceC3117b).mo525a(cls, z));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void m746a(InterfaceC3117b interfaceC3117b) {
        if (interfaceC3117b != null) {
            this.f11726a = new ArrayList(mo526a());
            this.f11726a.add(interfaceC3117b);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.f11726a.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.f11726a.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: a_ */
    public final void m745a_(WritableByteChannel writableByteChannel) throws IOException {
        for (InterfaceC3117b interfaceC3117b : mo526a()) {
            interfaceC3117b.mo402a(writableByteChannel);
        }
    }
}
