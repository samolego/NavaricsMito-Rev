package com.navatics.app.framework.network;

import android.content.Context;
import com.navatics.app.framework.Settings;

/* renamed from: com.navatics.app.framework.network.a */
/* loaded from: classes.dex */
public class NetworkConnection {

    /* renamed from: j */
    private static final String f4719j = "a";

    /* renamed from: k */
    private static NetworkConnection f4720k;

    /* renamed from: a */
    public String f4721a;

    /* renamed from: b */
    public String f4722b;

    /* renamed from: c */
    public String f4723c;

    /* renamed from: d */
    public String f4724d;

    /* renamed from: e */
    public int f4725e;

    /* renamed from: f */
    public String f4726f;

    /* renamed from: g */
    public String f4727g;

    /* renamed from: h */
    public String f4728h;

    /* renamed from: i */
    public boolean f4729i = false;

    static {
        NetworkConnection networkConnection = new NetworkConnection();
        networkConnection.f4721a = "Transfer to PC";
        networkConnection.f4724d = "";
        networkConnection.f4725e = 2211;
        networkConnection.f4722b = "ftp";
        networkConnection.f4723c = "server";
        networkConnection.f4728h = Settings.m8618a().m8611c();
        networkConnection.m7989a(true);
        f4720k = networkConnection;
    }

    /* renamed from: a */
    public void m7989a(boolean z) {
        this.f4729i = z;
        if (z) {
            this.f4726f = "anonymous";
            this.f4727g = "";
        }
    }

    /* renamed from: a */
    public String m7991a() {
        return this.f4726f;
    }

    /* renamed from: b */
    public String m7988b() {
        return this.f4727g;
    }

    /* renamed from: c */
    public boolean m7987c() {
        return this.f4729i;
    }

    /* renamed from: d */
    public String m7986d() {
        return this.f4728h;
    }

    /* renamed from: a */
    public static NetworkConnection m7990a(Context context) {
        return f4720k;
    }

    public String toString() {
        return "NetworkConnection{userName='" + this.f4726f + "', password='" + this.f4727g + "', host='" + this.f4724d + "', port=" + this.f4725e + '}';
    }
}
