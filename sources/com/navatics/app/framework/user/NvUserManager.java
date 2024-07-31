package com.navatics.app.framework.user;

import android.accounts.NetworkErrorException;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.example.divelog.dao.entity.BaseDiveLogInfo;
import com.example.divelog.dao.entity.CommandCard;
import com.example.divelog.dao.entity.DiveLogItem;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.divelog.DiveLog;
import com.navatics.app.framework.divelog.StartTimes;
import com.navatics.app.framework.firmware.FirmwareInfo;
import com.navatics.robot.utils.p065a.C2880i;
import hu.akarnokd.rxjava2.consumers.C3795b;
import io.objectbox.relation.ToOne;
import io.reactivex.AbstractC3976j;
import io.reactivex.InterfaceC3978k;
import io.reactivex.InterfaceC3979l;
import io.reactivex.InterfaceC3980m;
import io.reactivex.disposables.C3873a;
import io.reactivex.p093a.p095b.C3854a;
import io.reactivex.p096b.InterfaceC3861a;
import io.reactivex.p096b.InterfaceC3864d;
import io.reactivex.p096b.InterfaceC3865e;
import io.reactivex.p096b.InterfaceC3866f;
import io.reactivex.p099e.C3877a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import okhttp3.AbstractC3995aa;
import okhttp3.AbstractC4001ac;
import okhttp3.C4141v;
import okhttp3.C4142w;
import org.apache.log4j.Logger;
import retrofit2.InterfaceC4806b;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Query;

/* loaded from: classes.dex */
public class NvUserManager {

    /* renamed from: a */
    private static final Logger f4809a = Logger.m1561a(NvUserManager.class);

    /* renamed from: b */
    private static NvUserManager f4810b;

    /* renamed from: c */
    private NvUser f4811c;

    /* renamed from: d */
    private long f4812d;

    /* renamed from: e */
    private IUserManager iUserManager;

    /* renamed from: f */
    private C2378e f4814f;

    /* renamed from: g */
    private boolean f4815g;

    /* renamed from: h */
    private boolean f4816h;

    /* renamed from: i */
    private boolean f4817i;

    /* renamed from: j */
    private String f4818j;

    /* renamed from: k */
    private List<InterfaceC2366a> f4819k = new ArrayList();

    /* renamed from: l */
    private C3873a f4820l = new C3873a();

    /* renamed from: com.navatics.app.framework.user.NvUserManager$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2366a {
        void onStatusUpdate(C2371a c2371a);
    }

    /* renamed from: a */
    public static synchronized void m7852a() {
        synchronized (NvUserManager.class) {
            if (f4810b == null) {
                synchronized (NvUserManager.class) {
                    if (f4810b == null) {
                        f4810b = new NvUserManager();
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public static NvUserManager m7829b() {
        return f4810b;
    }

    private NvUserManager() {
        Navatics.m7936e().getSharedPreferences("app_settings", 0);
        this.iUserManager = new C2372b();
        Logger logger = f4809a;
        logger.mo1508a((Object) ("testingServer : false"));
        C2378e.m7766a(Navatics.m7936e());
        this.f4814f = C2378e.m7767a();
        C3795b.m3488a(m7788k().m3072b(C3877a.m3214b()), this.f4820l, new InterfaceC3865e() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$RjX5siqHRyR86VwOV4zg8xPtlhw
            @Override // io.reactivex.p096b.InterfaceC3865e
            /* renamed from: accept */
            public final void mo9501a(Object obj) {
                NvUserManager.lambda$RjX5siqHRyR86VwOV4zg8xPtlhw(NvUserManager.this, (NvUser) obj);
            }
        }, new InterfaceC3865e() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$xSHjTf4SRNJBBj_n85CBD4jNqh8
            @Override // io.reactivex.p096b.InterfaceC3865e
            /* renamed from: accept */
            public final void mo9501a(Object obj) {
                NvUserManager.lambda$xSHjTf4SRNJBBj_n85CBD4jNqh8(NvUserManager.this, (Throwable) obj);
            }
        }, new InterfaceC3861a() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$xKyvsZx0tTfUbbHnwDBF-u7uzWo
            @Override // io.reactivex.p096b.InterfaceC3861a
            public final void run() {
                NvUserManager.m13082lambda$xKyvsZx0tTfUbbHnwDBFu7uzWo(NvUserManager.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m7808c(Throwable th) throws Exception {
        m7842a(new C2371a(-1, (UserServiceException) th));
        this.f4817i = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m7787l() throws Exception {
        this.f4817i = false;
    }

    /* renamed from: c */
    public void m7816c() {
        this.f4820l.m3221a();
    }

    /* renamed from: d */
    public NvUser getUser() {
        return this.f4811c;
    }

    /* renamed from: e */
    public void m7803e() {
        if (this.f4811c == null) {
            f4809a.log((Object) "requestUpdate usr info but doesn't login yet..");
        } else if (!m7790j()) {
            f4809a.log((Object) "requestUpdate usr info but network not available.");
        } else {
            this.f4820l.mo3184a(this.iUserManager.getUserById(this.f4811c.getToken(), this.f4811c.getEmail(), this.f4811c.getUsrId()).m3072b(C3877a.m3214b()).m3088a(C3854a.m3247a()).m3104a(new InterfaceC3865e<Result<UserInfo>>() { // from class: com.navatics.app.framework.user.NvUserManager.1
                @Override // io.reactivex.p096b.InterfaceC3865e
                /* renamed from: a */
                public void mo9501a(Result<UserInfo> result) throws Exception {
                    if (result.getCode() == 0) {
                        result.getData().token = NvUserManager.this.f4811c.getToken();
                        NvUserManager nvUserManager = NvUserManager.this;
                        nvUserManager.f4811c = nvUserManager.f4814f.m7764a(result.getData());
                        NvUserManager nvUserManager2 = NvUserManager.this;
                        nvUserManager2.m7806d(nvUserManager2.f4811c);
                        return;
                    }
                    throw new UserServiceException(result.getCode(), result.getMsg());
                }
            }, new InterfaceC3865e() { // from class: com.navatics.app.framework.user.-$$Lambda$e27-Kr4VJxN1zC_AGmQwWE7CADQ
                @Override // io.reactivex.p096b.InterfaceC3865e
                /* renamed from: accept */
                public final void mo9501a(Object obj) {
                    ((Throwable) obj).printStackTrace();
                }
            }));
        }
    }

    /* renamed from: f */
    public long m7800f() {
        return this.f4812d;
    }

    /* renamed from: j */
    private boolean m7790j() {
        ConnectivityManager connectivityManager = (ConnectivityManager) Navatics.m7936e().getSystemService("connectivity");
        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT < 23) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    return false;
                }
                return activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 0;
            }
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                return networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(4);
            }
        }
        return false;
    }

    /* renamed from: k */
    private AbstractC3976j<NvUser> m7788k() {
        this.f4817i = true;
        if (this.f4811c != null) {
            return AbstractC3976j.m3094a(new InterfaceC3979l() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$EMnHq3uXiYzpAWvXUzW6E_N0BqU
                @Override // io.reactivex.InterfaceC3979l
                public final void subscribe(InterfaceC3978k interfaceC3981k) {
                    NvUserManager.lambda$EMnHq3uXiYzpAWvXUzW6E_N0BqU(NvUserManager.this, interfaceC3981k);
                }
            });
        }
        String m7761b = this.f4814f.m7761b();
        final NvUser m7763a = this.f4814f.m7763a(m7761b);
        Logger logger = f4809a;
        StringBuilder sb = new StringBuilder();
        sb.append("lastLoginUsrId : ");
        sb.append(m7761b);
        sb.append(", cachedLastLoginUsr ");
        sb.append(m7763a == null ? "null" : m7763a.toString());
        logger.mo1508a((Object) sb.toString());
        if (m7763a == null) {
            return AbstractC3976j.m3094a((InterfaceC3979l) new InterfaceC3979l() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$Cc_OGTsKwCyFAyPary7YlOaX8Vw
                @Override // io.reactivex.InterfaceC3979l
                public final void subscribe(InterfaceC3978k interfaceC3981k) {
                    NvUserManager.lambda$Cc_OGTsKwCyFAyPary7YlOaX8Vw(interfaceC3981k);
                }
            });
        }
        if (!m7790j()) {
            this.f4811c = m7763a;
            return AbstractC3976j.m3094a(new InterfaceC3979l() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$co9h7DLmSM3yw_v1uogxbTro8XY
                @Override // io.reactivex.InterfaceC3979l
                public final void subscribe(InterfaceC3978k interfaceC3981k) {
                    NvUserManager.lambda$co9h7DLmSM3yw_v1uogxbTro8XY(NvUserManager.this, interfaceC3981k);
                }
            });
        }
        m7849a(m7763a);
        return this.iUserManager.getUserById(m7763a.getToken(), m7763a.getEmail(), m7763a.getUsrId()).m3067c(new InterfaceC3866f() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$m6sBwCaMeX7exPP_3wgjojA1dok
            @Override // io.reactivex.p096b.InterfaceC3866f
            /* renamed from: apply */
            public final Object mo12613a(Object obj) {
                return NvUserManager.lambda$m6sBwCaMeX7exPP_3wgjojA1dok(NvUserManager.this, m7763a, (Result) obj);
            }
        }).m3063d(new InterfaceC3866f() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$74OlcfXMWc0W1kUFRIVeZER7kCc
            @Override // io.reactivex.p096b.InterfaceC3866f
            /* renamed from: apply */
            public final Object mo12613a(Object obj) {
                return NvUserManager.lambda$74OlcfXMWc0W1kUFRIVeZER7kCc(NvUserManager.this, m7763a, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m7796g(InterfaceC3978k interfaceC3978k) throws Exception {
        interfaceC3978k.onNext(this.f4811c);
        interfaceC3978k.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static /* synthetic */ void m7799f(InterfaceC3978k interfaceC3978k) throws Exception {
        interfaceC3978k.onError(new UserServiceException(-1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m7802e(InterfaceC3978k interfaceC3978k) throws Exception {
        interfaceC3978k.onNext(this.f4811c);
        interfaceC3978k.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ NvUser m7848a(NvUser nvUser, Result result) throws Exception {
        if (result.getCode() != 0) {
            throw new UserServiceException(result.getCode(), result.getMsg());
        }
        ((UserInfo) result.getData()).token = nvUser.getToken();
        this.f4811c = this.f4814f.m7764a((UserInfo) result.getData());
        return this.f4811c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ InterfaceC3980m m7847a(NvUser nvUser, Throwable th) throws Exception {
        this.f4811c = nvUser;
        return AbstractC3976j.m3094a(new InterfaceC3979l() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$UPGj-Dh8wYJtDFUrQc4f3ZWwsVI
            @Override // io.reactivex.InterfaceC3979l
            public final void subscribe(InterfaceC3978k interfaceC3981k) {
                NvUserManager.m13077lambda$UPGjDh8wYJtDFUrQc4f3ZWwsVI(NvUserManager.this, interfaceC3981k);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m7805d(InterfaceC3978k interfaceC3978k) throws Exception {
        f4809a.mo1497c((Object) "use cached user.");
        interfaceC3978k.onNext(this.f4811c);
        interfaceC3978k.onComplete();
    }

    /* renamed from: a */
    public AbstractC3976j<Result<String>> m7840a(String str) {
        return this.iUserManager.verifyRegister(str);
    }

    /* renamed from: b */
    public AbstractC3976j<Result<String>> m7822b(String str) {
        return this.iUserManager.getSpVerificationCode(str);
    }

    /* renamed from: a */
    public AbstractC3976j<Result<UserInfo>> m7831a(final String str, final String str2, final String str3) {
        if (!m7790j()) {
            return AbstractC3976j.m3084a((Throwable) new NetworkErrorException("Network unavailable"));
        }
        return AbstractC3976j.m3085a(str).m3067c(new InterfaceC3866f() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$VGj9ygszGqAHRam9QsKFBl59NYc
            @Override // io.reactivex.p096b.InterfaceC3866f
            /* renamed from: apply */
            public final Object mo12613a(Object obj) {
                return NvUserManager.lambda$VGj9ygszGqAHRam9QsKFBl59NYc((String) obj);
            }
        }).m3075b(new InterfaceC3866f<String, InterfaceC3980m<Result<UserInfo>>>() { // from class: com.navatics.app.framework.user.NvUserManager.2
            @Override // io.reactivex.p096b.InterfaceC3866f
            /* renamed from: a */
            public InterfaceC3980m<Result<UserInfo>> mo12613a(String str4) throws Exception {
                return NvUserManager.this.iUserManager.register(str4, str2, str3);
            }
        }).m3076b(new InterfaceC3865e() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$1kE7bPuvUT0EC4XKofzdkWWtqrU
            @Override // io.reactivex.p096b.InterfaceC3865e
            /* renamed from: accept */
            public final void mo9501a(Object obj) {
                NvUserManager.lambda$1kE7bPuvUT0EC4XKofzdkWWtqrU(NvUserManager.this, str2, str, (Result) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m7819b(String str, String str2, Result result) throws Exception {
        if (result.getCode() == 0) {
            this.f4814f.m7762a(str, str2);
            this.f4811c = this.f4814f.m7764a((UserInfo) result.getData());
            m7815c(this.f4811c);
        }
    }

    /* renamed from: b */
    public AbstractC3976j<Result<String>> m7818b(final String str, final String str2, String str3) {
        return AbstractC3976j.m3085a(str3).m3067c(new InterfaceC3866f() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$Fkcx7YuKNwDdmcf-3qRS2psbQiM
            @Override // io.reactivex.p096b.InterfaceC3866f
            /* renamed from: apply */
            public final Object mo12613a(Object obj) {
                return NvUserManager.m13076lambda$Fkcx7YuKNwDdmcf3qRS2psbQiM((String) obj);
            }
        }).m3075b(new InterfaceC3866f() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$h02EbBlallFQcvwwc5ag0xpAS-M
            @Override // io.reactivex.p096b.InterfaceC3866f
            /* renamed from: apply */
            public final Object mo12613a(Object obj) {
                return NvUserManager.m13080lambda$h02EbBlallFQcvwwc5ag0xpASM(NvUserManager.this, str, str2, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ InterfaceC3980m m7809c(String str, String str2, String str3) throws Exception {
        return this.iUserManager.resetPwd(str, str2, str3);
    }

    /* renamed from: a */
    public AbstractC3976j<Result<UserInfo>> m7836a(final String str, final String str2) {
        if (!m7790j()) {
            return AbstractC3976j.m3084a((Throwable) new NetworkErrorException("Network unavailable"));
        }
        this.f4815g = true;
        this.f4818j = str;
        m7798f(str);
        return AbstractC3976j.m3085a(str2).m3067c(new InterfaceC3866f() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$PT8vSbQu_j_du4gRPbd9jm6_6ac
            @Override // io.reactivex.p096b.InterfaceC3866f
            /* renamed from: apply */
            public final Object mo12613a(Object obj) {
                return NvUserManager.lambda$PT8vSbQu_j_du4gRPbd9jm6_6ac((String) obj);
            }
        }).m3075b(new InterfaceC3866f<String, InterfaceC3980m<Result<UserInfo>>>() { // from class: com.navatics.app.framework.user.NvUserManager.3
            @Override // io.reactivex.p096b.InterfaceC3866f
            /* renamed from: a */
            public InterfaceC3980m<Result<UserInfo>> mo12613a(String str3) throws Exception {
                return NvUserManager.this.iUserManager.login(str3, str);
            }
        }).m3076b(new InterfaceC3865e() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$fza3N1l7J7-hdGwIYiIvsvsv3fo
            @Override // io.reactivex.p096b.InterfaceC3865e
            /* renamed from: accept */
            public final void mo9501a(Object obj) {
                NvUserManager.m13079lambda$fza3N1l7J7hdGwIYiIvsvsv3fo(NvUserManager.this, str, str2, (Result) obj);
            }
        }).m3063d(new InterfaceC3866f() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$CN7hiPLpJEhnekgnhsWj86Q9-40
            @Override // io.reactivex.p096b.InterfaceC3866f
            /* renamed from: apply */
            public final Object mo12613a(Object obj) {
                return NvUserManager.m13075lambda$CN7hiPLpJEhnekgnhsWj86Q940(NvUserManager.this, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m7832a(String str, String str2, Result result) throws Exception {
        if (result.getCode() == 0) {
            this.f4814f.m7762a(str, str2);
            this.f4811c = this.f4814f.m7764a((UserInfo) result.getData());
            if (this.f4811c == null) {
                Logger logger = f4809a;
                logger.log((Object) ("userInfoResult = " + result.toString()));
            }
            m7815c(this.f4811c);
        }
        this.f4815g = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ InterfaceC3980m m7817b(Throwable th) throws Exception {
        C2880i.m5926a((Object) "eroor");
        this.f4815g = false;
        NvUser m7763a = this.f4814f.m7763a(this.f4814f.m7761b());
        if (m7763a == null) {
            return AbstractC3976j.m3094a((InterfaceC3979l) new InterfaceC3979l() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$fb0oKbHXVHh5I3lsjBwtEPI_2-k
                @Override // io.reactivex.InterfaceC3979l
                public final void subscribe(InterfaceC3978k interfaceC3981k) {
                    NvUserManager.m13078lambda$fb0oKbHXVHh5I3lsjBwtEPI_2k(interfaceC3981k);
                }
            });
        }
        this.f4811c = m7763a;
        return AbstractC3976j.m3094a(new InterfaceC3979l() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$7TKvQderNXmsjhCljkwhkZ6KdPE
            @Override // io.reactivex.InterfaceC3979l
            public final void subscribe(InterfaceC3978k interfaceC3981k) {
                NvUserManager.lambda$7TKvQderNXmsjhCljkwhkZ6KdPE(NvUserManager.this, interfaceC3981k);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m7812c(InterfaceC3978k interfaceC3978k) throws Exception {
        interfaceC3978k.onError(new UserServiceException(-1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.navatics.app.framework.user.UserInfo] */
    /* renamed from: b */
    public /* synthetic */ void m7823b(InterfaceC3978k interfaceC3978k) throws Exception {
        f4809a.mo1497c((Object) "use cached user.");
        ?? userInfo = new UserInfo();
        userInfo.age = this.f4811c.getAge();
        userInfo.email = this.f4811c.getEmail();
        userInfo.gender = this.f4811c.getGender();
        userInfo.f4838id = this.f4811c.getUsrId();
        userInfo.nickName = this.f4811c.getNickName();
        ToOne<SSUsrInfo> ssUsrInfo = this.f4811c.getSsUsrInfo();
        userInfo.spResp = ssUsrInfo != null ? ssUsrInfo.getTarget() : null;
        userInfo.token = this.f4811c.token;
        userInfo.usrImgHighres = this.f4811c.getUsrImgHighres();
        userInfo.usrImgLowres = this.f4811c.getUsrImgLowres();
        Result result = new Result();
        result.code = 0;
        result.msg = "using cached user";
        result.data = userInfo;
        interfaceC3978k.onNext(result);
        interfaceC3978k.onComplete();
    }

    /* renamed from: g */
    public AbstractC3976j<Result<String>> m7797g() {
        this.f4816h = true;
        if (!m7790j()) {
            this.f4816h = false;
            return AbstractC3976j.m3084a((Throwable) new NetworkErrorException("Network unavailable"));
        }
        NvUser nvUser = this.f4811c;
        if (nvUser == null) {
            this.f4816h = false;
            return AbstractC3976j.m3084a((Throwable) new NetworkErrorException("No active user"));
        }
        m7828b(nvUser);
        return this.iUserManager.logout(this.f4811c.getToken(), this.f4811c.getEmail()).m3076b(new InterfaceC3865e() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$bACm081nZxGQ4HmZfY9z_3bqMaA
            @Override // io.reactivex.p096b.InterfaceC3865e
            /* renamed from: accept */
            public final void mo9501a(Object obj) {
                NvUserManager.lambda$bACm081nZxGQ4HmZfY9z_3bqMaA(NvUserManager.this, (Result) obj);
            }
        }).m3105a(new InterfaceC3865e() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$beespE6dbOasXkJnqnw0wDXICy0
            @Override // io.reactivex.p096b.InterfaceC3865e
            /* renamed from: accept */
            public final void mo9501a(Object obj) {
                NvUserManager.lambda$beespE6dbOasXkJnqnw0wDXICy0(NvUserManager.this, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m7824b(Result result) throws Exception {
        Logger logger = f4809a;
        logger.mo1508a((Object) ("mUserService.logout doOnNext, result " + result.getCode()));
        if (result.getCode() == 0) {
            this.f4814f.m7765a(this.f4811c);
            m7795g(this.f4811c.getEmail());
            this.f4811c = null;
        }
        this.f4816h = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m7830a(Throwable th) throws Exception {
        this.f4816h = false;
    }

    /* renamed from: h */
    public void m7794h() {
        NvUser nvUser = this.f4811c;
        if (nvUser == null) {
            return;
        }
        this.f4814f.m7765a(nvUser);
        m7795g(this.f4811c.getEmail());
        this.f4811c = null;
    }

    /* renamed from: c */
    public AbstractC3976j<Result<String>> m7811c(String str) {
        return this.iUserManager.getVerificationCode("resetpwd", str);
    }

    /* renamed from: b */
    public AbstractC3976j<Result<String>> m7820b(String str, String str2) {
        return this.iUserManager.verifyCodeBeforeReset(str, str2);
    }

    public AbstractC3976j<Result<String>> sendDiveLog(String str, @Body DiveLog diveLog) {
        return this.iUserManager.sendDiveLog(str, diveLog);
    }

    /* renamed from: a */
    public void m7846a(InterfaceC2366a interfaceC2366a) {
        if (interfaceC2366a != null) {
            this.f4819k.add(interfaceC2366a);
        }
    }

    /* renamed from: b */
    public void m7814c(InterfaceC2366a interfaceC2366a) {
        if (interfaceC2366a != null) {
            this.f4819k.remove(interfaceC2366a);
        }
    }

    /* renamed from: a */
    private void m7842a(C2371a c2371a) {
        for (InterfaceC2366a interfaceC2366a : this.f4819k) {
            interfaceC2366a.onStatusUpdate(c2371a);
        }
    }

    /* renamed from: a */
    private void m7849a(NvUser nvUser) {
        m7842a(new C2371a(5, nvUser));
    }

    /* renamed from: f */
    private void m7798f(String str) {
        m7842a(new C2371a(3, str));
    }

    /* renamed from: b */
    private void m7828b(NvUser nvUser) {
        m7842a(new C2371a(4, nvUser));
    }

    /* renamed from: c */
    private void m7815c(NvUser nvUser) {
        m7842a(new C2371a(1, nvUser));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m7806d(NvUser nvUser) {
        m7842a(new C2371a(2, nvUser));
    }

    /* renamed from: g */
    private void m7795g(String str) {
        m7842a(new C2371a(0, str));
    }

    /* renamed from: i */
    public AbstractC3976j<C2371a> m7792i() {
        return AbstractC3976j.m3094a(new InterfaceC3979l() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$4Gms0CI2DEe9cjdAHRYio35Cu24
            @Override // io.reactivex.InterfaceC3979l
            public final void subscribe(InterfaceC3978k interfaceC3981k) {
                NvUserManager.lambda$4Gms0CI2DEe9cjdAHRYio35Cu24(NvUserManager.this, interfaceC3981k);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m7841a(final InterfaceC3978k interfaceC3978k) throws Exception {
        NvUser nvUser = this.f4811c;
        if (nvUser != null) {
            C2371a c2371a = new C2371a(2, nvUser);
            if (!interfaceC3978k.isDisposed()) {
                interfaceC3978k.onNext(c2371a);
            }
        }
        if (this.f4817i) {
            C2371a c2371a2 = new C2371a(5, this.f4811c);
            if (!interfaceC3978k.isDisposed()) {
                interfaceC3978k.onNext(c2371a2);
            }
        }
        if (this.f4815g) {
            C2371a c2371a3 = new C2371a(3, this.f4811c);
            if (!interfaceC3978k.isDisposed()) {
                interfaceC3978k.onNext(c2371a3);
            }
        }
        if (this.f4816h) {
            C2371a c2371a4 = new C2371a(4, this.f4811c);
            if (!interfaceC3978k.isDisposed()) {
                interfaceC3978k.onNext(c2371a4);
            }
        }
        interfaceC3978k.getClass();
        final InterfaceC2366a interfaceC2366a = new InterfaceC2366a() { // from class: com.navatics.app.framework.user.-$$Lambda$xhUYiTrUBO8hxID_7eeVmyiesvk
            @Override // com.navatics.app.framework.user.NvUserManager.InterfaceC2366a
            public final void onStatusUpdate(C2371a c2374a5) {
                interfaceC3978k.onNext(c2374a5);
            }
        };
        m7846a(interfaceC2366a);
        interfaceC3978k.setCancellable(new InterfaceC3864d() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$k3fOAQpNUgB867RcTF-mZdYgiDI
            @Override // io.reactivex.p096b.InterfaceC3864d
            public final void cancel() {
                NvUserManager.m13081lambda$k3fOAQpNUgB867RcTFmZdYgiDI(NvUserManager.this, interfaceC2366a);
            }
        });
    }

    /* renamed from: d */
    public AbstractC3976j<Result<Object>> m7804d(String str) {
        if (!m7790j()) {
            return AbstractC3976j.m3084a((Throwable) new NetworkErrorException("Network unavailable"));
        }
        File file = new File(str);
        C4142w.C4144b m2408a = C4142w.C4144b.m2408a("imgBinary", file.getName(), AbstractC3995aa.m3036a(C4141v.m2415b("multipart/form-data"), file));
        return this.iUserManager.modifyAvatar(AbstractC3995aa.m3035a(C4141v.m2415b("text/plain"), this.f4811c.getToken()), AbstractC3995aa.m3035a(C4141v.m2415b("text/plain"), this.f4811c.getEmail()), m2408a).m3076b(new InterfaceC3865e() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$PiPtjFKgLhc7SH5UatvAFUjPkT8
            @Override // io.reactivex.p096b.InterfaceC3865e
            /* renamed from: accept */
            public final void mo9501a(Object obj) {
                NvUserManager.lambda$PiPtjFKgLhc7SH5UatvAFUjPkT8(NvUserManager.this, (Result) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m7843a(Result result) throws Exception {
        if (result.getCode() == 0) {
            this.f4812d = System.currentTimeMillis();
        }
    }

    /* renamed from: a */
    public AbstractC3976j<Result<String>> m7838a(String str, int i, int i2) {
        return this.iUserManager.modifyUserInfo(this.f4811c.getToken(), this.f4811c.getEmail(), Integer.valueOf(this.f4811c.getUsrId()).intValue(), str, i2, i);
    }

    public AbstractC3976j<Result<DiveLogList>> getDiveLogList(@Header(m117a = "token") String str, @Header(m117a = "email") String str2, @Header(m117a = "startTime") String str3) {
        return this.iUserManager.getStartTimesByEmail(str, str2, str3);
    }

    /* renamed from: a */
    public AbstractC3976j<Result<List<DiveLogList>>> m7837a(String str, StartTimes startTimes) {
        return this.iUserManager.mo7773a(str, startTimes);
    }

    public AbstractC3976j<AbstractC4001ac> getDiveLog(@Query(m106a = "token") String str, @Query(m106a = "email") String str2, @Query(m106a = "id") long j) {
        return this.iUserManager.getFullDiveLogByStartTime(str, str2, j);
    }

    /* renamed from: a */
    public InterfaceC4806b<Result<Integer>> m7850a(DiveLogItem diveLogItem, int i) {
        return this.iUserManager.mo7775a(diveLogItem, i);
    }

    /* renamed from: e */
    public InterfaceC4806b<Result<Integer>> m7801e(String str) {
        return this.iUserManager.getLatestVersion(str);
    }

    /* renamed from: a */
    public InterfaceC4806b<Result<List<CommandCard>>> m7839a(String str, int i) {
        return this.iUserManager.mo7769b(str, i);
    }

    /* renamed from: a */
    public InterfaceC4806b<Result<Integer>> m7834a(String str, String str2, BaseDiveLogInfo baseDiveLogInfo, int i) {
        return this.iUserManager.mo7771a(str, str2, baseDiveLogInfo, i);
    }

    /* renamed from: a */
    public InterfaceC4806b<Result<Integer>> m7833a(String str, String str2, DiveLogItem diveLogItem, int i) {
        return this.iUserManager.mo7770a(str, str2, diveLogItem, i);
    }

    /* renamed from: b */
    public InterfaceC4806b<Result<Integer>> m7821b(String str, int i) {
        return this.iUserManager.mo7774a(str, i);
    }

    /* renamed from: a */
    public InterfaceC4806b<Result<Integer>> m7835a(String str, String str2, int i) {
        return this.iUserManager.mo7772a(str, str2, i);
    }

    /* renamed from: a */
    public InterfaceC4806b<Result<Integer>> m7851a(BaseDiveLogInfo baseDiveLogInfo) {
        return this.iUserManager.mo7776a(baseDiveLogInfo);
    }

    /* renamed from: c */
    public InterfaceC4806b<Result<FirmwareInfo>> m7810c(String str, String str2) {
        return this.iUserManager.getOnlineFileInfo(str, str2);
    }
}
