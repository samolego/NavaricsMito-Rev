package com.facebook.login;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.facebook.login.c */
/* loaded from: classes.dex */
public class LoginManager {

    /* renamed from: a */
    private static final Set<String> f2217a = m10237a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m10236a(String str) {
        return str != null && (str.startsWith("publish") || str.startsWith("manage") || f2217a.contains(str));
    }

    /* renamed from: a */
    private static Set<String> m10237a() {
        return Collections.unmodifiableSet(new HashSet<String>() { // from class: com.facebook.login.LoginManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                add("ads_management");
                add("create_event");
                add("rsvp_event");
            }
        });
    }
}
