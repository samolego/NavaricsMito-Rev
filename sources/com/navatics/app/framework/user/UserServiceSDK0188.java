package com.navatics.app.framework.user;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/* loaded from: classes.dex */
public interface UserServiceSDK0188 {
    @GET(m122a = "user/spSendCode")
    Observable<Result<String>> getSpVerificationCode(@Query(m106a = "email") String str);

    @GET(m122a = "user/getUserById")
    Observable<Result<UserInfo>> getUserById(@Query(m106a = "token") String str, @Query(m106a = "email") String str2, @Query(m106a = "id") String str3);

    @GET(m122a = "user/getCode")
    Observable<Result<String>> getVerificationCode(@Query(m106a = "type") String str, @Query(m106a = "email") String str2);

    @GET(m122a = "login")
    Observable<Result<UserInfo>> login(@Query(m106a = "pwd") String str, @Query(m106a = "email") String str2);

    @GET(m122a = "logout")
    Observable<Result<String>> logout(@Query(m106a = "token") String str, @Query(m106a = "email") String str2);

    @POST(m113a = "userimage/modifyAvatar")
    @Multipart
    Observable<Result<Object>> modifyAvatar(@Part(m111a = "token") RequestBody requestBody, @Part(m111a = "email") RequestBody requestBody2, @Part MultipartBody.C2989b c2989b);

    @FormUrlEncoded
    @POST(m113a = "user/alterUserInfo")
    Observable<Result<String>> modifyUserInfo(@Field(m125a = "token") String str, @Field(m125a = "email") String str2, @Field(m125a = "id") int i, @Field(m125a = "nickName") String str3, @Field(m125a = "gender") int i2, @Field(m125a = "age") int i3);

    @FormUrlEncoded
    @POST(m113a = "user/register")
    Observable<Result<UserInfo>> register(@Field(m125a = "pwd") String str, @Field(m125a = "email") String str2, @Field(m125a = "verificationCode") String str3);

    @GET(m122a = "user/resetPwd")
    Observable<Result<String>> resetPwd(@Query(m106a = "email") String str, @Query(m106a = "verificationCode") String str2, @Query(m106a = "newPwd") String str3);

    @GET(m122a = "user/verifyCodeBeforeReset")
    Observable<Result<String>> verifyCodeBeforeReset(@Query(m106a = "email") String str, @Query(m106a = "verificationCode") String str2);

    @GET(m122a = "user/verifyRegister")
    Observable<Result<String>> verifyRegister(@Query(m106a = "email") String str);
}
