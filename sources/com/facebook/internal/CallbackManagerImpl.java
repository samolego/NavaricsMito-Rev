package com.facebook.internal;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class CallbackManagerImpl implements CallbackManager {

    /* renamed from: a */
    private static final String f1882a = "CallbackManagerImpl";

    /* renamed from: b */
    private static Map<Integer, InterfaceC0921a> f1883b = new HashMap();

    /* renamed from: c */
    private Map<Integer, InterfaceC0921a> f1884c = new HashMap();

    /* renamed from: com.facebook.internal.CallbackManagerImpl$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0921a {
    }

    /* renamed from: a */
    public static synchronized void m10820a(int i, InterfaceC0921a interfaceC0921a) {
        synchronized (CallbackManagerImpl.class) {
            Validate.m10469a(interfaceC0921a, "callback");
            if (f1883b.containsKey(Integer.valueOf(i))) {
                return;
            }
            f1883b.put(Integer.valueOf(i), interfaceC0921a);
        }
    }

    /* renamed from: b */
    public void m10819b(int i, InterfaceC0921a interfaceC0921a) {
        Validate.m10469a(interfaceC0921a, "callback");
        this.f1884c.put(Integer.valueOf(i), interfaceC0921a);
    }

    /* loaded from: classes.dex */
    public enum RequestCodeOffset {
        Login(0),
        Share(1),
        Message(2),
        Like(3),
        GameRequest(4),
        AppGroupCreate(5),
        AppGroupJoin(6),
        AppInvite(7),
        DeviceShare(8);
        
        private final int offset;

        RequestCodeOffset(int i) {
            this.offset = i;
        }

        public int toRequestCode() {
            return FacebookSdk.m10857t() + this.offset;
        }
    }
}
