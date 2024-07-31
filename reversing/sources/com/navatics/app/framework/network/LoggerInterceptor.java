package com.navatics.app.framework.network;

import com.navatics.robot.utils.p065a.LoggerUtil;
import java.io.IOException;
import okhttp3.C2993z;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Response;

/* loaded from: classes.dex */
public class LoggerInterceptor implements Interceptor {

    /* renamed from: a */
    private Level f4717a;

    /* loaded from: classes.dex */
    public enum Level {
        DEBUG,
        RELEASE
    }

    public LoggerInterceptor(Level level) {
        this.f4717a = level;
    }

    @Override // okhttp3.Interceptor
    /* renamed from: a */
    public Response mo2429a(Interceptor.InterfaceC2987a interfaceC2987a) throws IOException {
        C2993z mo2428a = interfaceC2987a.mo2428a();
        if (this.f4717a != Level.DEBUG) {
            return interfaceC2987a.mo2427a(mo2428a);
        }
        System.currentTimeMillis();
        Response mo2427a = interfaceC2987a.mo2427a(interfaceC2987a.mo2428a());
        System.currentTimeMillis();
        mo2427a.m3026g().mo129a();
        String m3000f = mo2427a.m3026g().m3000f();
        LoggerUtil.m5929a("okHttp", "| " + mo2428a.toString());
        if ("POST".equals(mo2428a.m2348b())) {
            StringBuilder sb = new StringBuilder();
            if (mo2428a.m2346d() instanceof FormBody) {
                FormBody formBody = (FormBody) mo2428a.m2346d();
                for (int i = 0; i < formBody.m2513a(); i++) {
                    sb.append(formBody.m2512a(i) + "=" + formBody.m2510b(i) + ",");
                }
                sb.delete(sb.length() - 1, sb.length());
                LoggerUtil.m5929a("okHttp", "| RequestParams:{" + sb.toString() + "}");
            }
        }
        LoggerUtil.m5929a("okHttp", "| Response:" + m3000f);
        return interfaceC2987a.mo2427a(mo2428a);
    }
}
