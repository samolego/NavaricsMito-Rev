package com.navatics.app.framework.user;

import com.example.divelog.dao.entity.BaseDiveLogInfo;
import com.example.divelog.dao.entity.CommandCard;
import com.example.divelog.dao.entity.DiveLogItem;
import com.navatics.app.framework.divelog.DiveLog;
import com.navatics.app.framework.divelog.DiveLogEntry;
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
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/* loaded from: classes.dex */
public interface SDK0188UserService {
    @POST(m113a = "activemqserver/sendMsg/diveLogByte")
    Observable<Result> addDiveLogItem(@Field(m125a = "startTime") long j, @Body DiveLogEntry diveLogEntry);

    @POST(m113a = "divelogserver/v1.1/divelog/addCommand")
    InterfaceC3169b<Result<Integer>> addDiveLogItem(@Body DiveLogItem diveLogItem, @Query(m106a = "clientVersion") int i);

    @POST(m113a = "divelogserver/v1.1/divelog/createCommand")
    InterfaceC3169b<Result<Integer>> createDiveLog(@Body BaseDiveLogInfo baseDiveLogInfo);

    @POST(m113a = "divelogserver/v1.1/divelog/deleteDiveLog")
    InterfaceC3169b<Result<Integer>> deleteDiveLog(@Query(m106a = "startTime") String str, @Query(m106a = "clientVersion") int i);

    @POST(m113a = "divelogserver/v1.1/divelog/deleteItemCommand")
    InterfaceC3169b<Result<Integer>> deleteDiveLogItem(@Query(m106a = "startTime") String str, @Query(m106a = "index") String str2, @Query(m106a = "clientVersion") int i);

    @GET(m122a = "divelogserver/divelog/getFullDiveLogByStartTime")
    Observable<ResponseBody> getFullDiveLogByStartTime(@Query(m106a = "token") String str, @Query(m106a = "email") String str2, @Query(m106a = "startTime") long j);

    @POST(m113a = "divelogserver/v1.1/divelog/getLatestVersion")
    InterfaceC3169b<Result<Integer>> getLatestVersion(@Query(m106a = "startTime") String str);

    @POST(m113a = "firmwareupgrade/ossfile/getOnlineFileInfo")
    InterfaceC3169b<Result<FirmwareInfo>> getOnlineFileInfo(@Query(m106a = "productName") String str, @Query(m106a = "firmwareType") String str2);

    @GET(m122a = "appserver/user/spSendCode")
    Observable<Result<String>> getSpVerificationCode(@Query(m106a = "email") String str);

    @POST(m113a = "divelogserver/v1.1/divelog/getStartTimeAndLatestVersionMap")
    Observable<Result<List<DiveLogList>>> getStartTimeAndLatestVersionMap(@Query(m106a = "email") String str, @Body StartTimes startTimes);

    @GET(m122a = "activemqserver/getStartTimeByEmail")
    Observable<Result<String>> getStartTimeByEmail(@Query(m106a = "token") String str, @Query(m106a = "email") String str2);

    @GET(m122a = "divelogserver/divelog/getStartTimesByEmail")
    Observable<Result<DiveLogList>> getStartTimesByEmail(@Query(m106a = "token") String str, @Query(m106a = "email") String str2, @Query(m106a = "startTime") String str3);

    @GET(m122a = "appserver/user/getUserById")
    Observable<Result<UserInfo>> getUserById(@Query(m106a = "token") String str, @Query(m106a = "email") String str2, @Query(m106a = "id") String str3);

    @GET(m122a = "appserver/user/getCode")
    Observable<Result<String>> getVerificationCode(@Query(m106a = "type") String str, @Query(m106a = "email") String str2);

    @GET(m122a = "appserver/login")
    Observable<Result<UserInfo>> login(@Query(m106a = "pwd") String str, @Query(m106a = "email") String str2);

    @GET(m122a = "appserver/logout")
    Observable<Result<String>> logout(@Query(m106a = "token") String str, @Query(m106a = "email") String str2);

    @POST(m113a = "appserver/userimage/modifyAvatar")
    @Multipart
    Observable<Result<Object>> modifyAvatar(@Part(m111a = "token") RequestBody requestBody, @Part(m111a = "email") RequestBody requestBody2, @Part MultipartBody.C2989b c2989b);

    @FormUrlEncoded
    @POST(m113a = "appserver/user/alterUserInfo")
    Observable<Result<String>> modifyUserInfo(@Field(m125a = "token") String str, @Field(m125a = "email") String str2, @Field(m125a = "id") int i, @Field(m125a = "nickName") String str3, @Field(m125a = "gender") int i2, @Field(m125a = "age") int i3);

    @GET(m122a = "divelogserver/v1.1/divelog/queryDiveLogItems")
    InterfaceC3169b<Result<List<CommandCard>>> queryDiveLogItems(@Query(m106a = "startTime") String str, @Query(m106a = "version") int i);

    @FormUrlEncoded
    @POST(m113a = "appserver/user/register")
    Observable<Result<UserInfo>> register(@Field(m125a = "pwd") String str, @Field(m125a = "email") String str2, @Field(m125a = "verificationCode") String str3);

    @GET(m122a = "appserver/user/resetPwd")
    Observable<Result<String>> resetPwd(@Query(m106a = "email") String str, @Query(m106a = "verificationCode") String str2, @Query(m106a = "newPwd") String str3);

    @POST(m113a = "activemqserver/sendMsg/diveLogMsg")
    Observable<Result<String>> sendDiveLog(@Header(m117a = "token") String str, @Body DiveLog diveLog);

    @POST(m113a = "activemqserver/sendMsg/diveLogByte")
    Observable<Result<String>> sendDiveLogBinary(@Header(m117a = "token") String str, @Header(m117a = "email") String str2, @Header(m117a = "startTime") String str3, @Body RequestBody requestBody);

    @POST(m113a = "divelogserver/v1.1/divelog/updateBaseDiveLogInfo")
    InterfaceC3169b<Result<Integer>> updateDiveLog(@Query(m106a = "startTime") String str, @Query(m106a = "fieldName") String str2, @Body BaseDiveLogInfo baseDiveLogInfo, @Query(m106a = "clientVersion") int i);

    @POST(m113a = "divelogserver/v1.1/divelog/updateDiveLogItemCommand")
    InterfaceC3169b<Result<Integer>> updateDiveLogItem(@Query(m106a = "startTime") String str, @Query(m106a = "fieldName") String str2, @Body DiveLogItem diveLogItem, @Query(m106a = "clientVersion") int i);

    @GET(m122a = "appserver/user/verifyCodeBeforeReset")
    Observable<Result<String>> verifyCodeBeforeReset(@Query(m106a = "email") String str, @Query(m106a = "verificationCode") String str2);

    @GET(m122a = "appserver/user/verifyRegister")
    Observable<Result<String>> verifyRegister(@Query(m106a = "email") String str);
}
