package org.apache.ftpserver.p110a.p111a.p112a;

import org.apache.ftpserver.ftplet.FtpFile;
import org.apache.ftpserver.util.DateUtils;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: org.apache.ftpserver.a.a.a.g */
/* loaded from: classes2.dex */
public class MLSTFileFormater implements FileFormater {

    /* renamed from: a */
    private static final String[] f10869a = {"Size", "Modify", "Type"};

    /* renamed from: b */
    private static final char[] f10870b = {'\r', '\n'};

    /* renamed from: c */
    private String[] f10871c;

    public MLSTFileFormater(String[] strArr) {
        this.f10871c = f10869a;
        if (strArr != null) {
            this.f10871c = (String[]) strArr.clone();
        }
    }

    @Override // org.apache.ftpserver.p110a.p111a.p112a.FileFormater
    /* renamed from: a */
    public String mo1983a(FtpFile ftpFile) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            String[] strArr = this.f10871c;
            if (i < strArr.length) {
                String str = strArr[i];
                if (str.equalsIgnoreCase("size")) {
                    sb.append("Size=");
                    sb.append(String.valueOf(ftpFile.mo1761g()));
                    sb.append(';');
                } else if (str.equalsIgnoreCase("modify")) {
                    String m1670c = DateUtils.m1670c(ftpFile.mo1757k());
                    sb.append("Modify=");
                    sb.append(m1670c);
                    sb.append(';');
                } else if (str.equalsIgnoreCase(IjkMediaMeta.IJKM_KEY_TYPE)) {
                    if (ftpFile.mo1763e()) {
                        sb.append("Type=file;");
                    } else if (ftpFile.mo1764d()) {
                        sb.append("Type=dir;");
                    }
                } else if (str.equalsIgnoreCase("perm")) {
                    sb.append("Perm=");
                    if (ftpFile.mo1756l()) {
                        if (ftpFile.mo1763e()) {
                            sb.append('r');
                        } else if (ftpFile.mo1764d()) {
                            sb.append('e');
                            sb.append('l');
                        }
                    }
                    if (ftpFile.mo1755m()) {
                        if (ftpFile.mo1763e()) {
                            sb.append('a');
                            sb.append('d');
                            sb.append('f');
                            sb.append('w');
                        } else if (ftpFile.mo1764d()) {
                            sb.append('f');
                            sb.append('p');
                            sb.append('c');
                            sb.append('m');
                        }
                    }
                    sb.append(';');
                }
                i++;
            } else {
                sb.append(' ');
                sb.append(ftpFile.mo1768b());
                sb.append(f10870b);
                return sb.toString();
            }
        }
    }
}
