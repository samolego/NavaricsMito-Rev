package com.navatics.app.framework.user;

import com.example.divelog.dao.entity.BaseDiveLogInfo;
import com.example.divelog.dao.entity.CommandCard;
import com.example.divelog.dao.entity.DiveLogItem;
import com.navatics.app.framework.divelog.DiveLog;
import com.navatics.app.framework.divelog.StartTimes;
import com.navatics.app.framework.firmware.FirmwareInfo;
import io.reactivex.Observable;
import java.util.List;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.InterfaceC3169b;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.Header;
import retrofit2.http.Part;
import retrofit2.http.Query;

/* loaded from: classes.dex */
public interface IUserManager {
    /* renamed from: a */
    Observable<Result<List<DiveLogList>>> mo7772a(String str, StartTimes startTimes);

    /* renamed from: a */
    InterfaceC3169b<Result<Integer>> mo7775a(BaseDiveLogInfo baseDiveLogInfo);

    /* renamed from: a */
    InterfaceC3169b<Result<Integer>> mo7774a(DiveLogItem diveLogItem, int i);

    /* renamed from: a */
    InterfaceC3169b<Result<Integer>> mo7773a(String str, int i);

    /* renamed from: a */
    InterfaceC3169b<Result<Integer>> mo7771a(String str, String str2, int i);

    /* renamed from: a */
    InterfaceC3169b<Result<Integer>> mo7770a(String str, String str2, BaseDiveLogInfo baseDiveLogInfo, int i);

    /* renamed from: a */
    InterfaceC3169b<Result<Integer>> mo7769a(String str, String str2, DiveLogItem diveLogItem, int i);

    /* renamed from: b */
    InterfaceC3169b<Result<List<CommandCard>>> mo7768b(String str, int i);

    Observable<ResponseBody> getFullDiveLogByStartTime(@Query(m106a = "token") String str, @Query(m106a = "email") String str2, @Query(m106a = "startTime") long j);

    InterfaceC3169b<Result<Integer>> getLatestVersion(@Field(m125a = "startTime") String str);

    InterfaceC3169b<Result<FirmwareInfo>> getOnlineFileInfo(@Query(m106a = "productName") String str, @Query(m106a = "firmwareType") String str2);

    Observable<Result<String>> getSpVerificationCode(@Query(m106a = "email") String str);

    Observable<Result<String>> getStartTimeByEmail(@Query(m106a = "token") String str, @Query(m106a = "email") String str2);

    Observable<Result<DiveLogList>> getStartTimesByEmail(@Query(m106a = "token") String str, @Query(m106a = "email") String str2, @Query(m106a = "startTime") String str3);

    Observable<Result<UserInfo>> getUserById(@Query(m106a = "token") String str, @Query(m106a = "email") String str2, @Query(m106a = "id") String str3);

    Observable<Result<String>> getVerificationCode(@Query(m106a = "type") String str, @Query(m106a = "email") String str2);

    Observable<Result<UserInfo>> login(@Query(m106a = "pwd") String str, @Query(m106a = "email") String str2);

    Observable<Result<String>> logout(@Query(m106a = "token") String str, @Query(m106a = "email") String str2);

    Observable<Result<Object>> modifyAvatar(@Part(m111a = "token") RequestBody requestBody, @Part(m111a = "email") RequestBody requestBody2, @Part MultipartBody.C2989b c2989b);

    Observable<Result<String>> modifyUserInfo(@Field(m125a = "token") String str, @Field(m125a = "email") String str2, @Field(m125a = "id") int i, @Field(m125a = "nickName") String str3, @Field(m125a = "gender") int i2, @Field(m125a = "age") int i3);

    Observable<Result<UserInfo>> register(@Field(m125a = "pwd") String str, @Field(m125a = "email") String str2, @Field(m125a = "verificationCode") String str3);

    Observable<Result<String>> resetPwd(@Query(m106a = "email") String str, @Query(m106a = "verificationCode") String str2, @Query(m106a = "newPwd") String str3);

    Observable<Result<String>> sendDiveLog(@Header(m117a = "token") String str, @Body DiveLog diveLog);

    Observable<Result<String>> sendDiveLogBinary(@Header(m117a = "token") String str, @Header(m117a = "email") String str2, @Header(m117a = "startTime") String str3, @Body RequestBody requestBody);

    Observable<Result<String>> verifyCodeBeforeReset(@Query(m106a = "email") String str, @Query(m106a = "verificationCode") String str2);

    Observable<Result<String>> verifyRegister(@Query(m106a = "email") String str);
}
