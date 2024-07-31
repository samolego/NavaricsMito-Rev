package com.navatics.app.framework.user;

import com.example.divelog.dao.entity.BaseDiveLogInfo;
import com.example.divelog.dao.entity.CommandCard;
import com.example.divelog.dao.entity.DiveLogItem;
import com.google.gson.GsonBuilder;
import com.navatics.app.framework.divelog.DiveLog;
import com.navatics.app.framework.divelog.StartTimes;
import com.navatics.app.framework.firmware.FirmwareInfo;
import io.reactivex.Observable;
import java.util.List;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.InterfaceC3169b;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.p153a.p154a.GsonConverterFactory;

/* renamed from: com.navatics.app.framework.user.b */
/* loaded from: classes.dex */
public class ProductionUserManager implements IUserManager {

    /* renamed from: a */
    private UserService f4843a = (UserService) new Retrofit.C3206a().m52a("https://app1.navatics.com/").m48a(UnsafeOkHttpClient.m7767a()).m46a(GsonConverterFactory.m168a(new GsonBuilder().serializeNulls().create())).m47a(RxJava2CallAdapterFactory.m156a()).m53a().m64a(UserService.class);

    @Override // com.navatics.app.framework.user.IUserManager
    public Observable<Result<String>> getVerificationCode(String str, String str2) {
        return this.f4843a.getVerificationCode(str, str2);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    public Observable<Result<String>> verifyCodeBeforeReset(String str, String str2) {
        return this.f4843a.verifyCodeBeforeReset(str, str2);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    public Observable<Result<String>> resetPwd(String str, String str2, String str3) {
        return this.f4843a.resetPwd(str, str2, str3);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    public Observable<Result<String>> getSpVerificationCode(String str) {
        return this.f4843a.getSpVerificationCode(str);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    public Observable<Result<UserInfo>> register(String str, String str2, String str3) {
        return this.f4843a.register(str, str2, str3);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    public Observable<Result<UserInfo>> getUserById(String str, String str2, String str3) {
        return this.f4843a.getUserById(str, str2, str3);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    public Observable<Result<String>> verifyRegister(String str) {
        return this.f4843a.verifyRegister(str);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    public Observable<Result<UserInfo>> login(String str, String str2) {
        return this.f4843a.login(str, str2);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    public Observable<Result<String>> logout(String str, String str2) {
        return this.f4843a.logout(str, str2);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    public Observable<Result<Object>> modifyAvatar(RequestBody requestBody, RequestBody requestBody2, MultipartBody.C2989b c2989b) {
        return this.f4843a.modifyAvatar(requestBody, requestBody2, c2989b);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    public Observable<Result<String>> modifyUserInfo(String str, String str2, int i, String str3, int i2, int i3) {
        return this.f4843a.modifyUserInfo(str, str2, i, str3, i2, i3);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    public Observable<Result<String>> sendDiveLog(String str, DiveLog diveLog) {
        return this.f4843a.sendDiveLog(str, diveLog);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    public Observable<Result<String>> getStartTimeByEmail(String str, String str2) {
        return this.f4843a.getStartTimeByEmail(str, str2);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    public Observable<Result<String>> sendDiveLogBinary(String str, String str2, String str3, RequestBody requestBody) {
        return this.f4843a.sendDiveLogBinary(str, str2, str3, requestBody);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    public Observable<Result<DiveLogList>> getStartTimesByEmail(String str, String str2, String str3) {
        return this.f4843a.getStartTimesByEmail(str, str2, str3);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    public Observable<ResponseBody> getFullDiveLogByStartTime(String str, String str2, long j) {
        return this.f4843a.getFullDiveLogByStartTime(str, str2, j);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    public InterfaceC3169b<Result<Integer>> getLatestVersion(String str) {
        return this.f4843a.getLatestVersion(str);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    /* renamed from: a */
    public InterfaceC3169b<Result<Integer>> mo7775a(BaseDiveLogInfo baseDiveLogInfo) {
        return this.f4843a.createDiveLog(baseDiveLogInfo);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    /* renamed from: a */
    public InterfaceC3169b<Result<Integer>> mo7774a(DiveLogItem diveLogItem, int i) {
        return this.f4843a.addDiveLogItem(diveLogItem, i);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    /* renamed from: a */
    public InterfaceC3169b<Result<Integer>> mo7770a(String str, String str2, BaseDiveLogInfo baseDiveLogInfo, int i) {
        return this.f4843a.updateDiveLog(str, str2, baseDiveLogInfo, i);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    /* renamed from: a */
    public InterfaceC3169b<Result<Integer>> mo7769a(String str, String str2, DiveLogItem diveLogItem, int i) {
        return this.f4843a.updateDiveLogItem(str, str2, diveLogItem, i);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    /* renamed from: a */
    public InterfaceC3169b<Result<Integer>> mo7773a(String str, int i) {
        return this.f4843a.deleteDiveLog(str, i);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    /* renamed from: a */
    public InterfaceC3169b<Result<Integer>> mo7771a(String str, String str2, int i) {
        return this.f4843a.deleteDiveLogItem(str, str2, i);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    /* renamed from: b */
    public InterfaceC3169b<Result<List<CommandCard>>> mo7768b(String str, int i) {
        return this.f4843a.queryDiveLogItems(str, i);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    /* renamed from: a */
    public Observable<Result<List<DiveLogList>>> mo7772a(String str, StartTimes startTimes) {
        return this.f4843a.getStartTimeAndLatestVersionMap(str, startTimes);
    }

    @Override // com.navatics.app.framework.user.IUserManager
    public InterfaceC3169b<Result<FirmwareInfo>> getOnlineFileInfo(String str, String str2) {
        return this.f4843a.getOnlineFileInfo(str, str2);
    }
}
