package com.navatics.robot.protocol;

import android.content.Context;
import com.navatics.robot.utils.C2160n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.ae */
/* loaded from: classes.dex */
public class NvProtocol {

    /* renamed from: a */
    private static final C3044k f6240a = C3044k.m1564a(NvProtocol.class);

    /* renamed from: b */
    private static HashMap<String, IProtocolFactory> f6241b = new HashMap<>();

    /* renamed from: c */
    private static Context f6242c;

    /* renamed from: a */
    public static void m6532a(Context context) {
        f6242c = context.getApplicationContext();
        m6529c();
    }

    /* renamed from: a */
    public static Context m6533a() {
        return f6242c;
    }

    /* renamed from: c */
    private static void m6529c() {
        DawnProtoFactory dawnProtoFactory = new DawnProtoFactory();
        f6241b.put(dawnProtoFactory.mo6379a(), dawnProtoFactory);
    }

    /* renamed from: a */
    public static INvProtocol m6531a(String str, int i) {
        if (C2160n.m5855a((CharSequence) str)) {
            C3044k c3044k = f6240a;
            c3044k.mo1504b((Object) ("invalid proto name : " + str));
            return null;
        }
        IProtocolFactory iProtocolFactory = f6241b.get(str);
        if (iProtocolFactory == null) {
            C3044k c3044k2 = f6240a;
            c3044k2.mo1504b((Object) ("invalid proto name : " + str));
            return null;
        }
        return iProtocolFactory.mo6378a(i);
    }

    /* renamed from: b */
    public static List<IProtocolFactory> m6530b() {
        return new ArrayList(f6241b.values());
    }
}
