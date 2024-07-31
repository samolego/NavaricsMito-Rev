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
import com.navatics.robot.utils.Des3;
import com.navatics.robot.utils.logging.LoggerUtil;
import hu.akarnokd.rxjava2.consumers.ObservableConsumers;
import io.objectbox.relation.ToOne;
import io.reactivex.InterfaceC2899m;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.p082a.p084b.AndroidSchedulers;
import io.reactivex.p085b.Consumer;
import io.reactivex.p085b.InterfaceC2824a;
import io.reactivex.p085b.InterfaceC2827d;
import io.reactivex.p085b.InterfaceC2829f;
import io.reactivex.p088e.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.AbstractC2907aa;
import okhttp3.AbstractC2909ac;
import okhttp3.C2983v;
import okhttp3.MultipartBody;
import org.apache.log4j.Logger;
import retrofit2.InterfaceC3515b;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Query;

/* loaded from: classes.dex */
public class NvUserManager {

    /* renamed from: a */
    private static final Logger f4831a = Logger.getLogger(NvUserManager.class);

    /* renamed from: b */
    private static NvUserManager INSTANCE;

    /* renamed from: c */
    private NvUser currentUser;

    /* renamed from: d */
    private long f4834d;

    /* renamed from: e */
    private IUserManager iUserManager;

    /* renamed from: f */
    private UserSetting f4836f;

    /* renamed from: g */
    private boolean f4837g;

    /* renamed from: h */
    private boolean f4838h;

    /* renamed from: i */
    private boolean f4839i;

    /* renamed from: j */
    private String f4840j;

    /* renamed from: k */
    private List<InterfaceC1740a> f4841k = new ArrayList();

    /* renamed from: l */
    private CompositeDisposable f4842l = new CompositeDisposable();

    /* renamed from: com.navatics.app.framework.user.NvUserManager$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1740a {
        void onStatusUpdate(NvUserEvent nvUserEvent);
    }

    /* renamed from: a */
    public static synchronized void setupInstance() {
        synchronized (NvUserManager.class) {
            if (INSTANCE == null) {
                synchronized (NvUserManager.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new NvUserManager();
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public static NvUserManager getInstance() {
        return INSTANCE;
    }

    private NvUserManager() {
        Navatics.getContext().getSharedPreferences("app_settings", 0);
        this.iUserManager = new ProductionUserManager();
        f4831a.conditionalLog3((Object) ("testingServer : false"));
        UserSetting.m5157a(Navatics.getContext());
        this.f4836f = UserSetting.getUserSettings();
        ObservableConsumers.m9343a(m5119k().m9762b(Schedulers.m9619b()), this.f4842l, new Consumer() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$RjX5siqHRyR86VwOV4zg8xPtlhw
            @Override // io.reactivex.p085b.Consumer
            public final void accept(Object obj) {
                NvUserManager.this.m5108d((NvUser) obj);
            }
        }, new Consumer() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$xSHjTf4SRNJBBj_n85CBD4jNqh8
            @Override // io.reactivex.p085b.Consumer
            public final void accept(Object obj) {
                NvUserManager.this.m5107c((Throwable) obj);
            }
        }, new InterfaceC2824a() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$xKyvsZx0tTfUbbHnwDBF-u7uzWo
            @Override // io.reactivex.p085b.InterfaceC2824a
            public final void run() {
                NvUserManager.this.m5120l();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m5107c(Throwable th) throws Exception {
        m5090a(new NvUserEvent(-1, (UserServiceException) th));
        this.f4839i = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m5120l() throws Exception {
        this.f4839i = false;
    }

    /* renamed from: c */
    public void m5140c() {
        this.f4842l.m9610a();
    }

    /* renamed from: d */
    public NvUser getUser() {
        return this.currentUser;
    }

    /* renamed from: e */
    public void m5144e() {
        if (this.currentUser == null) {
            f4831a.log((Object) "requestUpdate usr info but doesn't login yet..");
        } else if (!m5118j()) {
            f4831a.log((Object) "requestUpdate usr info but network not available.");
        } else {
            this.f4842l.mo9612a(this.iUserManager.getUserById(this.currentUser.getToken(), this.currentUser.getEmail(), this.currentUser.getUsrId()).m9762b(Schedulers.m9619b()).m9757a(AndroidSchedulers.m9582a()).m9742a(new Consumer<Result<UserInfo>>() { // from class: com.navatics.app.framework.user.NvUserManager.1
                @Override // io.reactivex.p085b.Consumer
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void accept(Result<UserInfo> result) throws Exception {
                    if (result.getCode() != 0) {
                        throw new UserServiceException(result.getCode(), result.getMsg());
                    }
                    result.getData().token = NvUserManager.this.currentUser.getToken();
                    NvUserManager nvUserManager = NvUserManager.this;
                    nvUserManager.currentUser = nvUserManager.f4836f.m5158a(result.getData());
                    NvUserManager nvUserManager2 = NvUserManager.this;
                    nvUserManager2.m5108d(nvUserManager2.currentUser);
                }
            }, new Consumer() { // from class: com.navatics.app.framework.user.-$$Lambda$e27-Kr4VJxN1zC_AGmQwWE7CADQ
                @Override // io.reactivex.p085b.Consumer
                public final void accept(Object obj) {
                    ((Throwable) obj).printStackTrace();
                }
            }));
        }
    }

    /* renamed from: f */
    public long m5145f() {
        return this.f4834d;
    }

    /* renamed from: j */
    private boolean m5118j() {
        ConnectivityManager connectivityManager = (ConnectivityManager) Navatics.getContext().getSystemService("connectivity");
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
    private Observable<NvUser> m5119k() {
        this.f4839i = true;
        if (this.currentUser != null) {
            return Observable.create(new ObservableOnSubscribe() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$EMnHq3uXiYzpAWvXUzW6E_N0BqU
                @Override // io.reactivex.ObservableOnSubscribe
                public final void subscribe(ObservableEmitter observableEmitter) {
                    NvUserManager.this.m5113g(observableEmitter);
                }
            });
        }
        String lastLoginUid = this.f4836f.getLastLoginUid();
        final NvUser m5159a = this.f4836f.m5159a(lastLoginUid);
        Logger logger = f4831a;
        StringBuilder sb = new StringBuilder();
        sb.append("lastLoginUsrId : ");
        sb.append(lastLoginUid);
        sb.append(", cachedLastLoginUsr ");
        sb.append(m5159a == null ? "null" : m5159a.toString());
        logger.conditionalLog3((Object) sb.toString());
        if (m5159a == null) {
            return Observable.create((ObservableOnSubscribe) new ObservableOnSubscribe() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$Cc_OGTsKwCyFAyPary7YlOaX8Vw
                @Override // io.reactivex.ObservableOnSubscribe
                public final void subscribe(ObservableEmitter observableEmitter) {
                    NvUserManager.m5111f(observableEmitter);
                }
            });
        }
        if (!m5118j()) {
            this.currentUser = m5159a;
            return Observable.create(new ObservableOnSubscribe() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$co9h7DLmSM3yw_v1uogxbTro8XY
                @Override // io.reactivex.ObservableOnSubscribe
                public final void subscribe(ObservableEmitter observableEmitter) {
                    NvUserManager.this.m5110e(observableEmitter);
                }
            });
        }
        m5088a(m5159a);
        return this.iUserManager.getUserById(m5159a.getToken(), m5159a.getEmail(), m5159a.getUsrId()).m9767c(new InterfaceC2829f() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$m6sBwCaMeX7exPP_3wgjojA1dok
            @Override // io.reactivex.p085b.InterfaceC2829f
            public final Object apply(Object obj) {
                NvUser m5083a;
                m5083a = NvUserManager.this.m5083a(m5159a, (Result) obj);
                return m5083a;
            }
        }).m9771d(new InterfaceC2829f() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$74OlcfXMWc0W1kUFRIVeZER7kCc
            @Override // io.reactivex.p085b.InterfaceC2829f
            public final Object apply(Object obj) {
                InterfaceC2899m m5086a;
                m5086a = NvUserManager.this.m5086a(m5159a, (Throwable) obj);
                return m5086a;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m5113g(ObservableEmitter observableEmitter) throws Exception {
        observableEmitter.onNext(this.currentUser);
        observableEmitter.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static /* synthetic */ void m5111f(ObservableEmitter observableEmitter) throws Exception {
        observableEmitter.onError(new UserServiceException(-1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m5110e(ObservableEmitter observableEmitter) throws Exception {
        observableEmitter.onNext(this.currentUser);
        observableEmitter.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ NvUser m5083a(NvUser nvUser, Result result) throws Exception {
        if (result.getCode() != 0) {
            throw new UserServiceException(result.getCode(), result.getMsg());
        }
        ((UserInfo) result.getData()).token = nvUser.getToken();
        this.currentUser = this.f4836f.m5158a((UserInfo) result.getData());
        return this.currentUser;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ InterfaceC2899m m5086a(NvUser nvUser, Throwable th) throws Exception {
        this.currentUser = nvUser;
        return Observable.create(new ObservableOnSubscribe() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$UPGj-Dh8wYJtDFUrQc4f3ZWwsVI
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                NvUserManager.this.m5109d(observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m5109d(ObservableEmitter observableEmitter) throws Exception {
        f4831a.conditionalLog((Object) "use cached user.");
        observableEmitter.onNext(this.currentUser);
        observableEmitter.onComplete();
    }

    /* renamed from: a */
    public Observable<Result<String>> m5121a(String str) {
        return this.iUserManager.verifyRegister(str);
    }

    /* renamed from: b */
    public Observable<Result<String>> m5133b(String str) {
        return this.iUserManager.getSpVerificationCode(str);
    }

    /* renamed from: a */
    public Observable<Result<UserInfo>> m5125a(final String str, final String str2, final String str3) {
        if (!m5118j()) {
            return Observable.m9733a((Throwable) new NetworkErrorException("Network unavailable"));
        }
        return Observable.m9732a(str).m9767c(new InterfaceC2829f() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$VGj9ygszGqAHRam9QsKFBl59NYc
            @Override // io.reactivex.p085b.InterfaceC2829f
            public final Object apply(Object obj) {
                String m6961a;
                m6961a = Des3.m6961a((String) obj);
                return m6961a;
            }
        }).m9761b(new InterfaceC2829f<String, InterfaceC2899m<Result<UserInfo>>>() { // from class: com.navatics.app.framework.user.NvUserManager.2
            @Override // io.reactivex.p085b.InterfaceC2829f
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public InterfaceC2899m<Result<UserInfo>> apply(String str4) throws Exception {
                return NvUserManager.this.iUserManager.register(str4, str2, str3);
            }
        }).m9760b(new Consumer() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$1kE7bPuvUT0EC4XKofzdkWWtqrU
            @Override // io.reactivex.p085b.Consumer
            public final void accept(Object obj) {
                NvUserManager.this.m5101b(str2, str, (Result) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m5101b(String str, String str2, Result result) throws Exception {
        if (result.getCode() == 0) {
            this.f4836f.m5161a(str, str2);
            this.currentUser = this.f4836f.m5158a((UserInfo) result.getData());
            m5104c(this.currentUser);
        }
    }

    /* renamed from: b */
    public Observable<Result<String>> m5135b(final String str, final String str2, String str3) {
        return Observable.m9732a(str3).m9767c(new InterfaceC2829f() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$Fkcx7YuKNwDdmcf-3qRS2psbQiM
            @Override // io.reactivex.p085b.InterfaceC2829f
            public final Object apply(Object obj) {
                String m6961a;
                m6961a = Des3.m6961a((String) obj);
                return m6961a;
            }
        }).m9761b(new InterfaceC2829f() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$h02EbBlallFQcvwwc5ag0xpAS-M
            @Override // io.reactivex.p085b.InterfaceC2829f
            public final Object apply(Object obj) {
                InterfaceC2899m m5103c;
                m5103c = NvUserManager.this.m5103c(str, str2, (String) obj);
                return m5103c;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ InterfaceC2899m m5103c(String str, String str2, String str3) throws Exception {
        return this.iUserManager.resetPwd(str, str2, str3);
    }

    /* renamed from: a */
    public Observable<Result<UserInfo>> m5124a(final String str, final String str2) {
        if (!m5118j()) {
            return Observable.m9733a((Throwable) new NetworkErrorException("Network unavailable"));
        }
        this.f4837g = true;
        this.f4840j = str;
        m5112f(str);
        return Observable.m9732a(str2).m9767c(new InterfaceC2829f() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$PT8vSbQu_j_du4gRPbd9jm6_6ac
            @Override // io.reactivex.p085b.InterfaceC2829f
            public final Object apply(Object obj) {
                String m6961a;
                m6961a = Des3.m6961a((String) obj);
                return m6961a;
            }
        }).m9761b(new InterfaceC2829f<String, InterfaceC2899m<Result<UserInfo>>>() { // from class: com.navatics.app.framework.user.NvUserManager.3
            @Override // io.reactivex.p085b.InterfaceC2829f
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public InterfaceC2899m<Result<UserInfo>> apply(String str3) throws Exception {
                return NvUserManager.this.iUserManager.login(str3, str);
            }
        }).m9760b(new Consumer() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$fza3N1l7J7-hdGwIYiIvsvsv3fo
            @Override // io.reactivex.p085b.Consumer
            public final void accept(Object obj) {
                NvUserManager.this.m5092a(str, str2, (Result) obj);
            }
        }).m9771d(new InterfaceC2829f() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$CN7hiPLpJEhnekgnhsWj86Q9-40
            @Override // io.reactivex.p085b.InterfaceC2829f
            public final Object apply(Object obj) {
                InterfaceC2899m m5096b;
                m5096b = NvUserManager.this.m5096b((Throwable) obj);
                return m5096b;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m5092a(String str, String str2, Result result) throws Exception {
        if (result.getCode() == 0) {
            this.f4836f.m5161a(str, str2);
            this.currentUser = this.f4836f.m5158a((UserInfo) result.getData());
            if (this.currentUser == null) {
                f4831a.log((Object) ("userInfoResult = " + result.toString()));
            }
            m5104c(this.currentUser);
        }
        this.f4837g = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ InterfaceC2899m m5096b(Throwable th) throws Exception {
        LoggerUtil.m6925a((Object) "eroor");
        this.f4837g = false;
        NvUser m5159a = this.f4836f.m5159a(this.f4836f.getLastLoginUid());
        if (m5159a == null) {
            return Observable.create((ObservableOnSubscribe) new ObservableOnSubscribe() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$fb0oKbHXVHh5I3lsjBwtEPI_2-k
                @Override // io.reactivex.ObservableOnSubscribe
                public final void subscribe(ObservableEmitter observableEmitter) {
                    NvUserManager.m5106c(observableEmitter);
                }
            });
        }
        this.currentUser = m5159a;
        return Observable.create(new ObservableOnSubscribe() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$7TKvQderNXmsjhCljkwhkZ6KdPE
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                NvUserManager.this.m5100b(observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m5106c(ObservableEmitter observableEmitter) throws Exception {
        observableEmitter.onError(new UserServiceException(-1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.navatics.app.framework.user.UserInfo] */
    /* renamed from: b */
    public /* synthetic */ void m5100b(ObservableEmitter observableEmitter) throws Exception {
        f4831a.conditionalLog((Object) "use cached user.");
        ?? userInfo = new UserInfo();
        userInfo.age = this.currentUser.getAge();
        userInfo.email = this.currentUser.getEmail();
        userInfo.gender = this.currentUser.getGender();
        userInfo.f4860id = this.currentUser.getUsrId();
        userInfo.nickName = this.currentUser.getNickName();
        ToOne<SSUsrInfo> ssUsrInfo = this.currentUser.getSsUsrInfo();
        userInfo.spResp = ssUsrInfo != null ? ssUsrInfo.getTarget() : null;
        userInfo.token = this.currentUser.token;
        userInfo.usrImgHighres = this.currentUser.getUsrImgHighres();
        userInfo.usrImgLowres = this.currentUser.getUsrImgLowres();
        Result result = new Result();
        result.code = 0;
        result.msg = "using cached user";
        result.data = userInfo;
        observableEmitter.onNext(result);
        observableEmitter.onComplete();
    }

    /* renamed from: g */
    public Observable<Result<String>> m5146g() {
        this.f4838h = true;
        if (!m5118j()) {
            this.f4838h = false;
            return Observable.m9733a((Throwable) new NetworkErrorException("Network unavailable"));
        }
        NvUser nvUser = this.currentUser;
        if (nvUser == null) {
            this.f4838h = false;
            return Observable.m9733a((Throwable) new NetworkErrorException("No active user"));
        }
        m5097b(nvUser);
        return this.iUserManager.logout(this.currentUser.getToken(), this.currentUser.getEmail()).m9760b(new Consumer() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$bACm081nZxGQ4HmZfY9z_3bqMaA
            @Override // io.reactivex.p085b.Consumer
            public final void accept(Object obj) {
                NvUserManager.this.m5099b((Result) obj);
            }
        }).m9750a(new Consumer() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$beespE6dbOasXkJnqnw0wDXICy0
            @Override // io.reactivex.p085b.Consumer
            public final void accept(Object obj) {
                NvUserManager.this.m5093a((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m5099b(Result result) throws Exception {
        f4831a.conditionalLog3((Object) ("mUserService.logout doOnNext, result " + result.getCode()));
        if (result.getCode() == 0) {
            this.f4836f.m5160a(this.currentUser);
            m5114g(this.currentUser.getEmail());
            this.currentUser = null;
        }
        this.f4838h = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m5093a(Throwable th) throws Exception {
        this.f4838h = false;
    }

    /* renamed from: h */
    public void m5147h() {
        NvUser nvUser = this.currentUser;
        if (nvUser == null) {
            return;
        }
        this.f4836f.m5160a(nvUser);
        m5114g(this.currentUser.getEmail());
        this.currentUser = null;
    }

    /* renamed from: c */
    public Observable<Result<String>> m5138c(String str) {
        return this.iUserManager.getVerificationCode("resetpwd", str);
    }

    /* renamed from: b */
    public Observable<Result<String>> m5134b(String str, String str2) {
        return this.iUserManager.verifyCodeBeforeReset(str, str2);
    }

    public Observable<Result<String>> sendDiveLog(String str, @Body DiveLog diveLog) {
        return this.iUserManager.sendDiveLog(str, diveLog);
    }

    /* renamed from: a */
    public void m5132a(InterfaceC1740a interfaceC1740a) {
        if (interfaceC1740a != null) {
            this.f4841k.add(interfaceC1740a);
        }
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void m5105c(InterfaceC1740a interfaceC1740a) {
        if (interfaceC1740a != null) {
            this.f4841k.remove(interfaceC1740a);
        }
    }

    /* renamed from: a */
    private void m5090a(NvUserEvent nvUserEvent) {
        Iterator<InterfaceC1740a> it = this.f4841k.iterator();
        while (it.hasNext()) {
            it.next().onStatusUpdate(nvUserEvent);
        }
    }

    /* renamed from: a */
    private void m5088a(NvUser nvUser) {
        m5090a(new NvUserEvent(5, nvUser));
    }

    /* renamed from: f */
    private void m5112f(String str) {
        m5090a(new NvUserEvent(3, str));
    }

    /* renamed from: b */
    private void m5097b(NvUser nvUser) {
        m5090a(new NvUserEvent(4, nvUser));
    }

    /* renamed from: c */
    private void m5104c(NvUser nvUser) {
        m5090a(new NvUserEvent(1, nvUser));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m5108d(NvUser nvUser) {
        m5090a(new NvUserEvent(2, nvUser));
    }

    /* renamed from: g */
    private void m5114g(String str) {
        m5090a(new NvUserEvent(0, str));
    }

    /* renamed from: i */
    public Observable<NvUserEvent> m5148i() {
        return Observable.create(new ObservableOnSubscribe() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$4Gms0CI2DEe9cjdAHRYio35Cu24
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                NvUserManager.this.m5091a(observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m5091a(final ObservableEmitter observableEmitter) throws Exception {
        NvUser nvUser = this.currentUser;
        if (nvUser != null) {
            NvUserEvent nvUserEvent = new NvUserEvent(2, nvUser);
            if (!observableEmitter.isDisposed()) {
                observableEmitter.onNext(nvUserEvent);
            }
        }
        if (this.f4839i) {
            NvUserEvent nvUserEvent2 = new NvUserEvent(5, this.currentUser);
            if (!observableEmitter.isDisposed()) {
                observableEmitter.onNext(nvUserEvent2);
            }
        }
        if (this.f4837g) {
            NvUserEvent nvUserEvent3 = new NvUserEvent(3, this.currentUser);
            if (!observableEmitter.isDisposed()) {
                observableEmitter.onNext(nvUserEvent3);
            }
        }
        if (this.f4838h) {
            NvUserEvent nvUserEvent4 = new NvUserEvent(4, this.currentUser);
            if (!observableEmitter.isDisposed()) {
                observableEmitter.onNext(nvUserEvent4);
            }
        }
        observableEmitter.getClass();
        final InterfaceC1740a interfaceC1740a = new InterfaceC1740a() { // from class: com.navatics.app.framework.user.-$$Lambda$xhUYiTrUBO8hxID_7eeVmyiesvk
            @Override // com.navatics.app.framework.user.NvUserManager.InterfaceC1740a
            public final void onStatusUpdate(NvUserEvent nvUserEvent5) {
                ObservableEmitter.this.onNext(nvUserEvent5);
            }
        };
        m5132a(interfaceC1740a);
        observableEmitter.setCancellable(new InterfaceC2827d() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$k3fOAQpNUgB867RcTF-mZdYgiDI
            @Override // io.reactivex.p085b.InterfaceC2827d
            public final void cancel() {
                NvUserManager.this.m5105c(interfaceC1740a);
            }
        });
    }

    /* renamed from: d */
    public Observable<Result<Object>> m5142d(String str) {
        if (!m5118j()) {
            return Observable.m9733a((Throwable) new NetworkErrorException("Network unavailable"));
        }
        File file = new File(str);
        MultipartBody.b m10445a = MultipartBody.b.m10445a("imgBinary", file.getName(), AbstractC2907aa.m9791a(C2983v.m10435b("multipart/form-data"), file));
        return this.iUserManager.modifyAvatar(AbstractC2907aa.m9792a(C2983v.m10435b("text/plain"), this.currentUser.getToken()), AbstractC2907aa.m9792a(C2983v.m10435b("text/plain"), this.currentUser.getEmail()), m10445a).m9760b(new Consumer() { // from class: com.navatics.app.framework.user.-$$Lambda$NvUserManager$PiPtjFKgLhc7SH5UatvAFUjPkT8
            @Override // io.reactivex.p085b.Consumer
            public final void accept(Object obj) {
                NvUserManager.this.m5089a((Result) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m5089a(Result result) throws Exception {
        if (result.getCode() == 0) {
            this.f4834d = System.currentTimeMillis();
        }
    }

    /* renamed from: a */
    public Observable<Result<String>> m5122a(String str, int i, int i2) {
        return this.iUserManager.modifyUserInfo(this.currentUser.getToken(), this.currentUser.getEmail(), Integer.valueOf(this.currentUser.getUsrId()).intValue(), str, i2, i);
    }

    public Observable<Result<DiveLogList>> getDiveLogList(@Header(m12680a = "token") String str, @Header(m12680a = "email") String str2, @Header(m12680a = "startTime") String str3) {
        return this.iUserManager.getStartTimesByEmail(str, str2, str3);
    }

    /* renamed from: a */
    public Observable<Result<List<DiveLogList>>> m5123a(String str, StartTimes startTimes) {
        return this.iUserManager.mo5074a(str, startTimes);
    }

    public Observable<AbstractC2909ac> getDiveLog(@Query(m12691a = "token") String str, @Query(m12691a = "email") String str2, @Query(m12691a = "id") long j) {
        return this.iUserManager.getFullDiveLogByStartTime(str, str2, j);
    }

    /* renamed from: a */
    public InterfaceC3515b<Result<Integer>> m5127a(DiveLogItem diveLogItem, int i) {
        return this.iUserManager.mo5076a(diveLogItem, i);
    }

    /* renamed from: e */
    public InterfaceC3515b<Result<Integer>> m5143e(String str) {
        return this.iUserManager.getLatestVersion(str);
    }

    /* renamed from: a */
    public InterfaceC3515b<Result<List<CommandCard>>> m5128a(String str, int i) {
        return this.iUserManager.mo5081b(str, i);
    }

    /* renamed from: a */
    public InterfaceC3515b<Result<Integer>> m5130a(String str, String str2, BaseDiveLogInfo baseDiveLogInfo, int i) {
        return this.iUserManager.mo5079a(str, str2, baseDiveLogInfo, i);
    }

    /* renamed from: a */
    public InterfaceC3515b<Result<Integer>> m5131a(String str, String str2, DiveLogItem diveLogItem, int i) {
        return this.iUserManager.mo5080a(str, str2, diveLogItem, i);
    }

    /* renamed from: b */
    public InterfaceC3515b<Result<Integer>> m5136b(String str, int i) {
        return this.iUserManager.mo5077a(str, i);
    }

    /* renamed from: a */
    public InterfaceC3515b<Result<Integer>> m5129a(String str, String str2, int i) {
        return this.iUserManager.mo5078a(str, str2, i);
    }

    /* renamed from: a */
    public InterfaceC3515b<Result<Integer>> m5126a(BaseDiveLogInfo baseDiveLogInfo) {
        return this.iUserManager.mo5075a(baseDiveLogInfo);
    }

    /* renamed from: c */
    public InterfaceC3515b<Result<FirmwareInfo>> m5139c(String str, String str2) {
        return this.iUserManager.getOnlineFileInfo(str, str2);
    }
}