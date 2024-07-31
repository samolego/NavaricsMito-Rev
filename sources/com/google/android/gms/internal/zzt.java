package com.google.android.gms.internal;

import android.support.graphics.drawable.PathInterpolatorCompat;
import com.google.android.gms.internal.zzb;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

/* loaded from: classes.dex */
public class zzt implements zzf {
    protected static final boolean DEBUG = zzs.DEBUG;
    private static int zzbn = PathInterpolatorCompat.MAX_NUM_POINTS;
    private static int zzbo = 4096;
    protected final zzy zzbp;
    protected final zzu zzbq;

    public zzt(zzy zzyVar) {
        this(zzyVar, new zzu(zzbo));
    }

    public zzt(zzy zzyVar, zzu zzuVar) {
        this.zzbp = zzyVar;
        this.zzbq = zzuVar;
    }

    protected static Map<String, String> zza(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    private void zza(long j, zzk<?> zzkVar, byte[] bArr, StatusLine statusLine) {
        if (DEBUG || j > zzbn) {
            Object[] objArr = new Object[5];
            objArr[0] = zzkVar;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(zzkVar.zzt().zzd());
            zzs.zzb("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void zza(String str, zzk<?> zzkVar, zzr zzrVar) throws zzr {
        zzo zzt = zzkVar.zzt();
        int zzs = zzkVar.zzs();
        try {
            zzt.zza(zzrVar);
            zzkVar.zzc(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(zzs)));
        } catch (zzr e) {
            zzkVar.zzc(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(zzs)));
            throw e;
        }
    }

    private void zza(Map<String, String> map, zzb.zza zzaVar) {
        if (zzaVar == null) {
            return;
        }
        if (zzaVar.zza != null) {
            map.put("If-None-Match", zzaVar.zza);
        }
        if (zzaVar.zzc > 0) {
            map.put("If-Modified-Since", DateUtils.formatDate(new Date(zzaVar.zzc)));
        }
    }

    private byte[] zza(HttpEntity httpEntity) throws IOException, zzp {
        zzaa zzaaVar = new zzaa(this.zzbq, (int) httpEntity.getContentLength());
        try {
            InputStream content = httpEntity.getContent();
            if (content != null) {
                byte[] zzb = this.zzbq.zzb(1024);
                while (true) {
                    int read = content.read(zzb);
                    if (read == -1) {
                        break;
                    }
                    zzaaVar.write(zzb, 0, read);
                }
                byte[] byteArray = zzaaVar.toByteArray();
                try {
                    httpEntity.consumeContent();
                } catch (IOException unused) {
                    zzs.zza("Error occured when calling consumingContent", new Object[0]);
                }
                this.zzbq.zza(zzb);
                zzaaVar.close();
                return byteArray;
            }
            throw new zzp();
        } catch (Throwable th) {
            try {
                httpEntity.consumeContent();
            } catch (IOException unused2) {
                zzs.zza("Error occured when calling consumingContent", new Object[0]);
            }
            this.zzbq.zza(null);
            zzaaVar.close();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b9, code lost:
        throw new java.io.IOException();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0123 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r17v6 */
    @Override // com.google.android.gms.internal.zzf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.gms.internal.zzi zza(com.google.android.gms.internal.zzk<?> r24) throws com.google.android.gms.internal.zzr {
        /*
            Method dump skipped, instructions count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzt.zza(com.google.android.gms.internal.zzk):com.google.android.gms.internal.zzi");
    }
}
