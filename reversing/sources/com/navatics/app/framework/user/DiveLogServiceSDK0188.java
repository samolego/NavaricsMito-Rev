package com.navatics.app.framework.user;

import com.navatics.app.framework.divelog.DiveLog;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* loaded from: classes.dex */
public interface DiveLogServiceSDK0188 {
    @GET(m122a = "divelogserver/divelog/getFullDiveLogByStartTime")
    Observable<ResponseBody> getFullDiveLogByStartTime(@Query(m106a = "token") String str, @Query(m106a = "email") String str2, @Query(m106a = "startTime") long j);

    @GET(m122a = "activemqserver/getStartTimeByEmail")
    Observable<Result<String>> getStartTimeByEmail(@Query(m106a = "token") String str, @Query(m106a = "email") String str2);

    @GET(m122a = "divelogserver/divelog/getStartTimesByEmail")
    Observable<Result<DiveLogList>> getStartTimesByEmail(@Query(m106a = "token") String str, @Query(m106a = "email") String str2, @Query(m106a = "startTime") String str3);

    @POST(m113a = "activemqserver/sendMsg/diveLogMsg")
    Observable<Result<String>> sendDiveLog(@Header(m117a = "token") String str, @Body DiveLog diveLog);

    @POST(m113a = "activemqserver/sendMsg/diveLogByte")
    Observable<Result<String>> sendDiveLogBinary(@Header(m117a = "token") String str, @Header(m117a = "email") String str2, @Header(m117a = "startTime") String str3, @Body RequestBody requestBody);
}
