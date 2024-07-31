package com.navatics.app.framework.firmware;

import android.support.annotation.NonNull;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Executors;
import okhttp3.ResponseBody;
import retrofit2.C3204l;
import retrofit2.InterfaceC3169b;
import retrofit2.InterfaceC3171d;
import retrofit2.Retrofit;

/* renamed from: com.navatics.app.framework.firmware.b */
/* loaded from: classes.dex */
public class DownloadUtil {

    /* renamed from: a */
    private static int f4537a = 8192;

    /* renamed from: a */
    public static void m8324a(String str, String str2, final String str3, final DownloadListener downloadListener) {
        ((DownloadService) new Retrofit.C3206a().m52a(str).m51a(Executors.newSingleThreadExecutor()).m53a().m64a(DownloadService.class)).download(str2).mo140a(new InterfaceC3171d<ResponseBody>() { // from class: com.navatics.app.framework.firmware.b.1
            @Override // retrofit2.InterfaceC3171d
            /* renamed from: a */
            public void mo143a(@NonNull InterfaceC3169b<ResponseBody> interfaceC3169b, @NonNull C3204l<ResponseBody> c3204l) {
                DownloadUtil.m8322b(str3, c3204l, downloadListener);
            }

            @Override // retrofit2.InterfaceC3171d
            /* renamed from: a */
            public void mo144a(@NonNull InterfaceC3169b<ResponseBody> interfaceC3169b, @NonNull Throwable th) {
                downloadListener.mo8186b("网络错误～");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m8322b(String str, C3204l<ResponseBody> c3204l, DownloadListener downloadListener) {
        m8325a(new File(str), c3204l.m67e().m3002c(), c3204l.m67e().mo128b(), downloadListener);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0084 -> B:56:0x0087). Please submit an issue!!! */
    /* renamed from: a */
    private static void m8325a(File file, InputStream inputStream, long j, DownloadListener downloadListener) {
        OutputStream outputStream;
        downloadListener.mo8189a();
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdir();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                downloadListener.mo8186b("createNewFile IOException");
            }
        }
        OutputStream outputStream2 = null;
        OutputStream outputStream3 = null;
        outputStream2 = null;
        long j2 = 0;
        try {
            try {
                try {
                    outputStream = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        byte[] bArr = new byte[f4537a];
                        while (true) {
                            int read = inputStream.read(bArr, 0, f4537a);
                            if (read == -1) {
                                break;
                            }
                            outputStream.write(bArr, 0, read);
                            j2 += read;
                            downloadListener.mo8188a((int) ((100 * j2) / j));
                        }
                        downloadListener.mo8187a(file.getAbsolutePath());
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        outputStream.close();
                        outputStream2 = bArr;
                    } catch (IOException e3) {
                        e = e3;
                        outputStream3 = outputStream;
                        e.printStackTrace();
                        downloadListener.mo8186b("IOException");
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        if (outputStream3 != null) {
                            outputStream3.close();
                            outputStream2 = outputStream3;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e7) {
                    e = e7;
                }
            } catch (IOException e8) {
                e8.printStackTrace();
                outputStream2 = outputStream2;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = outputStream2;
        }
    }
}
