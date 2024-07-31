package com.facebook.login;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LoginManager.java */
/* renamed from: com.facebook.login.c, reason: use source file name */
/* loaded from: classes.dex */
public class LoginManager {

    /* renamed from: a */
    private static final Set<String> f2224a = m2740a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m2741a(String str) {
        return str != null && (str.startsWith("publish") || str.startsWith("manage") || f2224a.contains(str));
    }

    /* renamed from: a */
    private static Set<String> m2740a() {
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