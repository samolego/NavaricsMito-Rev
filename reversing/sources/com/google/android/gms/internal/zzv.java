package com.google.android.gms.internal;

import android.os.SystemClock;
import com.google.android.gms.internal.zzb;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class zzv implements com.google.android.gms.internal.zzb {
    private final Map<String, zza> zzbw;
    private long zzbx;
    private final File zzby;
    private final int zzbz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class zza {
        public String zza;
        public long zzb;
        public long zzc;
        public long zzca;
        public String zzcb;
        public long zzd;
        public long zze;
        public Map<String, String> zzf;

        private zza() {
        }

        public zza(String str, zzb.zza zzaVar) {
            this.zzcb = str;
            this.zzca = zzaVar.data.length;
            this.zza = zzaVar.zza;
            this.zzb = zzaVar.zzb;
            this.zzc = zzaVar.zzc;
            this.zzd = zzaVar.zzd;
            this.zze = zzaVar.zze;
            this.zzf = zzaVar.zzf;
        }

        public static zza zzf(InputStream inputStream) throws IOException {
            zza zzaVar = new zza();
            if (zzv.zzb(inputStream) == 538247942) {
                zzaVar.zzcb = zzv.zzd(inputStream);
                zzaVar.zza = zzv.zzd(inputStream);
                if (zzaVar.zza.equals("")) {
                    zzaVar.zza = null;
                }
                zzaVar.zzb = zzv.zzc(inputStream);
                zzaVar.zzc = zzv.zzc(inputStream);
                zzaVar.zzd = zzv.zzc(inputStream);
                zzaVar.zze = zzv.zzc(inputStream);
                zzaVar.zzf = zzv.zze(inputStream);
                return zzaVar;
            }
            throw new IOException();
        }

        public boolean zza(OutputStream outputStream) {
            try {
                zzv.zza(outputStream, 538247942);
                zzv.zza(outputStream, this.zzcb);
                zzv.zza(outputStream, this.zza == null ? "" : this.zza);
                zzv.zza(outputStream, this.zzb);
                zzv.zza(outputStream, this.zzc);
                zzv.zza(outputStream, this.zzd);
                zzv.zza(outputStream, this.zze);
                zzv.zza(this.zzf, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                zzs.zzb("%s", e.toString());
                return false;
            }
        }

        public zzb.zza zzb(byte[] bArr) {
            zzb.zza zzaVar = new zzb.zza();
            zzaVar.data = bArr;
            zzaVar.zza = this.zza;
            zzaVar.zzb = this.zzb;
            zzaVar.zzc = this.zzc;
            zzaVar.zzd = this.zzd;
            zzaVar.zze = this.zze;
            zzaVar.zzf = this.zzf;
            return zzaVar;
        }
    }

    /* loaded from: classes.dex */
    private static class zzb extends FilterInputStream {
        private int zzcc;

        private zzb(InputStream inputStream) {
            super(inputStream);
            this.zzcc = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.zzcc++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.zzcc += read;
            }
            return read;
        }
    }

    public zzv(File file) {
        this(file, 5242880);
    }

    public zzv(File file, int i) {
        this.zzbw = new LinkedHashMap(16, 0.75f, true);
        this.zzbx = 0L;
        this.zzby = file;
        this.zzbz = i;
    }

    private void removeEntry(String str) {
        zza zzaVar = this.zzbw.get(str);
        if (zzaVar != null) {
            this.zzbx -= zzaVar.zzca;
            this.zzbw.remove(str);
        }
    }

    private static int zza(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static void zza(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void zza(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        zza(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void zza(String str, zza zzaVar) {
        if (this.zzbw.containsKey(str)) {
            this.zzbx += zzaVar.zzca - this.zzbw.get(str).zzca;
        } else {
            this.zzbx += zzaVar.zzca;
        }
        this.zzbw.put(str, zzaVar);
    }

    static void zza(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map == null) {
            zza(outputStream, 0);
            return;
        }
        zza(outputStream, map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            zza(outputStream, entry.getKey());
            zza(outputStream, entry.getValue());
        }
    }

    private static byte[] zza(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        StringBuilder sb = new StringBuilder(50);
        sb.append("Expected ");
        sb.append(i);
        sb.append(" bytes, read ");
        sb.append(i2);
        sb.append(" bytes");
        throw new IOException(sb.toString());
    }

    static int zzb(InputStream inputStream) throws IOException {
        return (zza(inputStream) << 24) | (zza(inputStream) << 0) | 0 | (zza(inputStream) << 8) | (zza(inputStream) << 16);
    }

    static long zzc(InputStream inputStream) throws IOException {
        return ((zza(inputStream) & 255) << 0) | 0 | ((zza(inputStream) & 255) << 8) | ((zza(inputStream) & 255) << 16) | ((zza(inputStream) & 255) << 24) | ((zza(inputStream) & 255) << 32) | ((zza(inputStream) & 255) << 40) | ((zza(inputStream) & 255) << 48) | ((255 & zza(inputStream)) << 56);
    }

    private void zzc(int i) {
        long j;
        long j2 = i;
        if (this.zzbx + j2 < this.zzbz) {
            return;
        }
        if (zzs.DEBUG) {
            zzs.zza("Pruning old cache entries.", new Object[0]);
        }
        long j3 = this.zzbx;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, zza>> it = this.zzbw.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            zza value = it.next().getValue();
            if (zzf(value.zzcb).delete()) {
                j = j2;
                this.zzbx -= value.zzca;
            } else {
                j = j2;
                zzs.zzb("Could not delete cache entry for key=%s, filename=%s", value.zzcb, zze(value.zzcb));
            }
            it.remove();
            i2++;
            if (((float) (this.zzbx + j)) < this.zzbz * 0.9f) {
                break;
            }
            j2 = j;
        }
        if (zzs.DEBUG) {
            zzs.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.zzbx - j3), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    static String zzd(InputStream inputStream) throws IOException {
        return new String(zza(inputStream, (int) zzc(inputStream)), "UTF-8");
    }

    private String zze(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    static Map<String, String> zze(InputStream inputStream) throws IOException {
        int zzb2 = zzb(inputStream);
        Map<String, String> emptyMap = zzb2 == 0 ? Collections.emptyMap() : new HashMap<>(zzb2);
        for (int i = 0; i < zzb2; i++) {
            emptyMap.put(zzd(inputStream).intern(), zzd(inputStream).intern());
        }
        return emptyMap;
    }

    @Override // com.google.android.gms.internal.zzb
    public synchronized void initialize() {
        if (!this.zzby.exists()) {
            if (!this.zzby.mkdirs()) {
                zzs.zzc("Unable to create cache dir %s", this.zzby.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.zzby.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            BufferedInputStream bufferedInputStream = null;
            try {
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        zza zzf = zza.zzf(bufferedInputStream2);
                        zzf.zzca = file.length();
                        zza(zzf.zzcb, zzf);
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException unused) {
                        }
                    } catch (IOException unused2) {
                        bufferedInputStream = bufferedInputStream2;
                        if (file != null) {
                            file.delete();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException unused4) {
            }
        }
    }

    public synchronized void remove(String str) {
        boolean delete = zzf(str).delete();
        removeEntry(str);
        if (!delete) {
            zzs.zzb("Could not delete cache entry for key=%s, filename=%s", str, zze(str));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.zzb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized com.google.android.gms.internal.zzb.zza zza(java.lang.String r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.Map<java.lang.String, com.google.android.gms.internal.zzv$zza> r0 = r8.zzbw     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r0 = r0.get(r9)     // Catch: java.lang.Throwable -> L6d
            com.google.android.gms.internal.zzv$zza r0 = (com.google.android.gms.internal.zzv.zza) r0     // Catch: java.lang.Throwable -> L6d
            r1 = 0
            if (r0 != 0) goto Le
            monitor-exit(r8)
            return r1
        Le:
            java.io.File r2 = r8.zzf(r9)     // Catch: java.lang.Throwable -> L6d
            com.google.android.gms.internal.zzv$zzb r3 = new com.google.android.gms.internal.zzv$zzb     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            com.google.android.gms.internal.zzv.zza.zzf(r3)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L63
            long r4 = r2.length()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L63
            int r6 = com.google.android.gms.internal.zzv.zzb.zza(r3)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L63
            long r6 = (long) r6     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L63
            long r4 = r4 - r6
            int r5 = (int) r4     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L63
            byte[] r4 = zza(r3, r5)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L63
            com.google.android.gms.internal.zzb$zza r9 = r0.zzb(r4)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L63
            r3.close()     // Catch: java.io.IOException -> L37 java.lang.Throwable -> L6d
            monitor-exit(r8)
            return r9
        L37:
            monitor-exit(r8)
            return r1
        L39:
            r0 = move-exception
            goto L40
        L3b:
            r9 = move-exception
            r3 = r1
            goto L64
        L3e:
            r0 = move-exception
            r3 = r1
        L40:
            java.lang.String r4 = "%s: %s"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L63
            r6 = 0
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L63
            r5[r6] = r2     // Catch: java.lang.Throwable -> L63
            r2 = 1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L63
            r5[r2] = r0     // Catch: java.lang.Throwable -> L63
            com.google.android.gms.internal.zzs.zzb(r4, r5)     // Catch: java.lang.Throwable -> L63
            r8.remove(r9)     // Catch: java.lang.Throwable -> L63
            if (r3 == 0) goto L61
            r3.close()     // Catch: java.io.IOException -> L5f java.lang.Throwable -> L6d
            goto L61
        L5f:
            monitor-exit(r8)
            return r1
        L61:
            monitor-exit(r8)
            return r1
        L63:
            r9 = move-exception
        L64:
            if (r3 == 0) goto L6c
            r3.close()     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L6d
            goto L6c
        L6a:
            monitor-exit(r8)
            return r1
        L6c:
            throw r9     // Catch: java.lang.Throwable -> L6d
        L6d:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzv.zza(java.lang.String):com.google.android.gms.internal.zzb$zza");
    }

    @Override // com.google.android.gms.internal.zzb
    public synchronized void zza(String str, zzb.zza zzaVar) {
        zzc(zzaVar.data.length);
        File zzf = zzf(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zzf);
            zza zzaVar2 = new zza(str, zzaVar);
            if (!zzaVar2.zza(fileOutputStream)) {
                fileOutputStream.close();
                zzs.zzb("Failed to write header for %s", zzf.getAbsolutePath());
                throw new IOException();
            }
            fileOutputStream.write(zzaVar.data);
            fileOutputStream.close();
            zza(str, zzaVar2);
        } catch (IOException unused) {
            if (zzf.delete()) {
                return;
            }
            zzs.zzb("Could not clean up file %s", zzf.getAbsolutePath());
        }
    }

    public File zzf(String str) {
        return new File(this.zzby, zze(str));
    }
}
