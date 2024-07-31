package com.navatics.app.framework.firmware;

import com.navatics.app.framework.user.Result;
import okhttp3.ResponseBody;
import retrofit2.InterfaceC3169b;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/* loaded from: classes.dex */
public interface DownloadService {
    @Streaming
    @GET
    InterfaceC3169b<ResponseBody> download(@Url String str);

    @GET(m122a = "file/getOnlineFileInfo")
    InterfaceC3169b<Result<FirmwareInfo>> getOnlineFileInfoSync(@Query(m106a = "productName") String str, @Query(m106a = "versionValue") String str2);
}
