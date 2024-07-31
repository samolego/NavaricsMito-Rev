package org.apache.ftpserver.p118d;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.d.t */
/* loaded from: classes2.dex */
public class PassivePorts {

    /* renamed from: b */
    private static final Integer f11051b = 65535;

    /* renamed from: c */
    private List<Integer> f11053c;

    /* renamed from: d */
    private Set<Integer> f11054d;

    /* renamed from: f */
    private String f11056f;

    /* renamed from: g */
    private boolean f11057g;

    /* renamed from: a */
    private InterfaceC3153b f11052a = C3154c.m262a(PassivePorts.class);

    /* renamed from: e */
    private Random f11055e = new Random();

    public PassivePorts(Set<Integer> set, boolean z) {
        if (set == null) {
            throw new NullPointerException("passivePorts can not be null");
        }
        if (set.isEmpty()) {
            set = new HashSet<>();
            set.add(0);
        }
        this.f11053c = new ArrayList(set);
        this.f11054d = new HashSet(set.size());
        this.f11057g = z;
    }

    /* renamed from: b */
    private boolean m1835b(int i) {
        if (!this.f11057g || i == 0) {
            return true;
        }
        ServerSocket serverSocket = null;
        try {
            ServerSocket serverSocket2 = new ServerSocket(i);
            try {
                serverSocket2.setReuseAddress(true);
                try {
                    serverSocket2.close();
                    return true;
                } catch (IOException unused) {
                    return false;
                }
            } catch (IOException unused2) {
                serverSocket = serverSocket2;
                if (serverSocket != null) {
                    try {
                        serverSocket.close();
                    } catch (IOException unused3) {
                        return false;
                    }
                }
                return false;
            } catch (Throwable th) {
                th = th;
                serverSocket = serverSocket2;
                if (serverSocket != null) {
                    try {
                        serverSocket.close();
                    } catch (IOException unused4) {
                        return false;
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public synchronized int m1837a() {
        ArrayList arrayList = new ArrayList(this.f11053c);
        while (arrayList.size() > 0) {
            int nextInt = this.f11055e.nextInt(arrayList.size());
            Integer num = (Integer) arrayList.get(nextInt);
            if (num.intValue() == 0) {
                return 0;
            }
            if (m1835b(num.intValue())) {
                this.f11053c.remove(num);
                this.f11054d.add(num);
                return num.intValue();
            }
            arrayList.remove(nextInt);
            InterfaceC3153b interfaceC3153b = this.f11052a;
            interfaceC3153b.warn("Passive port in use by another process: " + num);
        }
        return -1;
    }

    /* renamed from: a */
    public synchronized void m1836a(int i) {
        if (i != 0) {
            if (this.f11054d.remove(Integer.valueOf(i))) {
                this.f11053c.add(Integer.valueOf(i));
            } else {
                InterfaceC3153b interfaceC3153b = this.f11052a;
                interfaceC3153b.warn("Releasing unreserved passive port: " + i);
            }
        }
    }

    public String toString() {
        String str = this.f11056f;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer num : this.f11053c) {
            sb.append(num);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
