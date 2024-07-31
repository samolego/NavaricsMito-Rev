package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* loaded from: classes.dex */
public final class zzaom {
    public zzaoh zza(Reader reader) throws zzaoi, zzaoq {
        try {
            zzapy zzapyVar = new zzapy(reader);
            zzaoh zzh = zzh(zzapyVar);
            if (!zzh.m9665aV() && zzapyVar.mo9627bn() != zzapz.END_DOCUMENT) {
                throw new zzaoq("Did not consume the entire document.");
            }
            return zzh;
        } catch (zzaqb e) {
            throw new zzaoq(e);
        } catch (IOException e2) {
            throw new zzaoi(e2);
        } catch (NumberFormatException e3) {
            throw new zzaoq(e3);
        }
    }

    public zzaoh zzh(zzapy zzapyVar) throws zzaoi, zzaoq {
        boolean isLenient = zzapyVar.isLenient();
        zzapyVar.setLenient(true);
        try {
            try {
                try {
                    return zzapi.zzh(zzapyVar);
                } catch (OutOfMemoryError e) {
                    String valueOf = String.valueOf(zzapyVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
                    sb.append("Failed parsing JSON source: ");
                    sb.append(valueOf);
                    sb.append(" to Json");
                    throw new zzaol(sb.toString(), e);
                }
            } catch (StackOverflowError e2) {
                String valueOf2 = String.valueOf(zzapyVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 36);
                sb2.append("Failed parsing JSON source: ");
                sb2.append(valueOf2);
                sb2.append(" to Json");
                throw new zzaol(sb2.toString(), e2);
            }
        } finally {
            zzapyVar.setLenient(isLenient);
        }
    }

    public zzaoh zzuq(String str) throws zzaoq {
        return zza(new StringReader(str));
    }
}
