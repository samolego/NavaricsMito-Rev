package com.navatics.app.framework.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.gson.Gson;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.Settings;
import com.navatics.robot.utils.C2160n;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.framework.user.e */
/* loaded from: classes.dex */
public class UserSetting {

    /* renamed from: a */
    private static final C3044k f4845a = C3044k.m1564a(UserSetting.class);

    /* renamed from: b */
    private static UserSetting f4846b;

    /* renamed from: c */
    private Context f4847c;

    /* renamed from: d */
    private SharedPreferences f4848d;

    /* renamed from: e */
    private Map<String, String> f4849e = new HashMap();

    private UserSetting(Context context) {
        this.f4847c = context.getApplicationContext();
        this.f4848d = PreferenceManager.getDefaultSharedPreferences(this.f4847c);
        f4846b = this;
    }

    /* renamed from: a */
    public static synchronized void m7765a(Context context) {
        synchronized (UserSetting.class) {
            if (f4846b == null) {
                f4846b = new UserSetting(context);
            }
        }
    }

    /* renamed from: a */
    public static UserSetting m7766a() {
        return f4846b;
    }

    /* renamed from: b */
    public String m7760b() {
        return this.f4848d.getString("key_last_login_uid", null);
    }

    /* renamed from: c */
    public void m7759c() {
        SharedPreferences.Editor edit = this.f4848d.edit();
        edit.putString("key_last_login_uid", null);
        edit.apply();
    }

    /* renamed from: d */
    public LastUserInfo m7758d() {
        String m8612b = Settings.m8618a().m8612b("user.last_login_user_info");
        if (C2160n.m5855a((CharSequence) m8612b)) {
            return null;
        }
        return (LastUserInfo) new Gson().fromJson(m8612b, (Class<Object>) LastUserInfo.class);
    }

    /* renamed from: a */
    public NvUser m7762a(String str) {
        if (str == null) {
            return null;
        }
        return (NvUser) Navatics.m7933f().m3474d(NvUser.class).m3416e().m3290a(NvUser_.usrId, str).m3288b().m3302c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m7761a(String str, String str2) {
        new LastUserInfo(str, str2, System.currentTimeMillis()).save();
    }

    /* renamed from: a */
    public NvUser m7763a(UserInfo userInfo) {
        C3044k c3044k = f4845a;
        c3044k.mo1511a((Object) ("updateCachedUser : " + userInfo));
        if (userInfo == null) {
            return null;
        }
        NvUser m7762a = m7762a(userInfo.f4838id);
        if (m7762a == null) {
            m7762a = new NvUser(userInfo.f4838id, userInfo.email, userInfo.nickName, userInfo.gender, userInfo.age, userInfo.usrImgLowres, userInfo.usrImgHighres, userInfo.token, userInfo.spResp);
        } else {
            m7762a.setUsrId(userInfo.f4838id);
            m7762a.setEmail(userInfo.email);
            m7762a.setNickName(userInfo.nickName);
            m7762a.setGender(userInfo.gender);
            m7762a.setAge(userInfo.age);
            m7762a.setUsrImgLowres(userInfo.usrImgLowres);
            m7762a.setUsrImgHighres(userInfo.usrImgHighres);
            m7762a.setToken(userInfo.token);
            m7762a.setSsUsrInfo(userInfo.spResp);
        }
        m7762a.save();
        SharedPreferences.Editor edit = this.f4848d.edit();
        edit.putString("key_last_login_uid", m7762a.getUsrId());
        edit.apply();
        return m7762a;
    }

    /* renamed from: a */
    public void m7764a(NvUser nvUser) {
        if (nvUser.getSsUsrInfo() != null && nvUser.getSsUsrInfo().isResolvedAndNotNull()) {
            f4845a.mo1511a((Object) "delete current usr ss info from db");
            SSUsrInfo.deleteFromDb(nvUser.getSsUsrInfo().getTargetId());
        }
        f4845a.mo1511a((Object) "delete current usr from db");
        nvUser.deleteFromDb();
        m7759c();
    }
}
