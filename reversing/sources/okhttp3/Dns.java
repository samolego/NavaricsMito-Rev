package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* renamed from: okhttp3.o */
/* loaded from: classes2.dex */
public interface Dns {

    /* renamed from: a */
    public static final Dns f10529a = new Dns() { // from class: okhttp3.o.1
        @Override // okhttp3.Dns
        /* renamed from: a */
        public List<InetAddress> mo2536a(String str) throws UnknownHostException {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (NullPointerException e) {
                UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                unknownHostException.initCause(e);
                throw unknownHostException;
            }
        }
    };

    /* renamed from: a */
    List<InetAddress> mo2536a(String str) throws UnknownHostException;
}
