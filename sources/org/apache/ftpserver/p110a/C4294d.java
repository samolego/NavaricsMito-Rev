package org.apache.ftpserver.p110a;

import java.util.HashMap;
import java.util.Map;
import org.apache.ftpserver.p110a.p111a.ABOR;
import org.apache.ftpserver.p110a.p111a.ACCT;
import org.apache.ftpserver.p110a.p111a.APPE;
import org.apache.ftpserver.p110a.p111a.AUTH;
import org.apache.ftpserver.p110a.p111a.CDUP;
import org.apache.ftpserver.p110a.p111a.CWD;
import org.apache.ftpserver.p110a.p111a.DELE;
import org.apache.ftpserver.p110a.p111a.DefaultCommandFactory;
import org.apache.ftpserver.p110a.p111a.EPRT;
import org.apache.ftpserver.p110a.p111a.EPSV;
import org.apache.ftpserver.p110a.p111a.FEAT;
import org.apache.ftpserver.p110a.p111a.HELP;
import org.apache.ftpserver.p110a.p111a.LANG;
import org.apache.ftpserver.p110a.p111a.LIST;
import org.apache.ftpserver.p110a.p111a.MD5;
import org.apache.ftpserver.p110a.p111a.MDTM;
import org.apache.ftpserver.p110a.p111a.MFMT;
import org.apache.ftpserver.p110a.p111a.MKD;
import org.apache.ftpserver.p110a.p111a.MLSD;
import org.apache.ftpserver.p110a.p111a.MLST;
import org.apache.ftpserver.p110a.p111a.MODE;
import org.apache.ftpserver.p110a.p111a.NLST;
import org.apache.ftpserver.p110a.p111a.NOOP;
import org.apache.ftpserver.p110a.p111a.OPTS;
import org.apache.ftpserver.p110a.p111a.PASS;
import org.apache.ftpserver.p110a.p111a.PASV;
import org.apache.ftpserver.p110a.p111a.PBSZ;
import org.apache.ftpserver.p110a.p111a.PORT;
import org.apache.ftpserver.p110a.p111a.PROT;
import org.apache.ftpserver.p110a.p111a.PWD;
import org.apache.ftpserver.p110a.p111a.QUIT;
import org.apache.ftpserver.p110a.p111a.REIN;
import org.apache.ftpserver.p110a.p111a.REST;
import org.apache.ftpserver.p110a.p111a.RETR;
import org.apache.ftpserver.p110a.p111a.RMD;
import org.apache.ftpserver.p110a.p111a.RNFR;
import org.apache.ftpserver.p110a.p111a.RNTO;
import org.apache.ftpserver.p110a.p111a.SITE;
import org.apache.ftpserver.p110a.p111a.SITE_DESCUSER;
import org.apache.ftpserver.p110a.p111a.SITE_HELP;
import org.apache.ftpserver.p110a.p111a.SITE_STAT;
import org.apache.ftpserver.p110a.p111a.SITE_WHO;
import org.apache.ftpserver.p110a.p111a.SITE_ZONE;
import org.apache.ftpserver.p110a.p111a.SIZE;
import org.apache.ftpserver.p110a.p111a.STAT;
import org.apache.ftpserver.p110a.p111a.STOR;
import org.apache.ftpserver.p110a.p111a.STOU;
import org.apache.ftpserver.p110a.p111a.STRU;
import org.apache.ftpserver.p110a.p111a.SYST;
import org.apache.ftpserver.p110a.p111a.TYPE;
import org.apache.ftpserver.p110a.p111a.USER;

/* renamed from: org.apache.ftpserver.a.d */
/* loaded from: classes2.dex */
public class CommandFactoryFactory {

    /* renamed from: a */
    private static final HashMap<String, Command> f10922a = new HashMap<>();

    /* renamed from: b */
    private Map<String, Command> f10923b = new HashMap();

    /* renamed from: c */
    private boolean f10924c = true;

    static {
        f10922a.put("ABOR", new ABOR());
        f10922a.put("ACCT", new ACCT());
        f10922a.put("APPE", new APPE());
        f10922a.put("AUTH", new AUTH());
        f10922a.put("CDUP", new CDUP());
        f10922a.put("CWD", new CWD());
        f10922a.put("DELE", new DELE());
        f10922a.put("EPRT", new EPRT());
        f10922a.put("EPSV", new EPSV());
        f10922a.put("FEAT", new FEAT());
        f10922a.put("HELP", new HELP());
        f10922a.put("LANG", new LANG());
        f10922a.put("LIST", new LIST());
        f10922a.put("MD5", new MD5());
        f10922a.put("MFMT", new MFMT());
        f10922a.put("MMD5", new MD5());
        f10922a.put("MDTM", new MDTM());
        f10922a.put("MLST", new MLST());
        f10922a.put("MKD", new MKD());
        f10922a.put("MLSD", new MLSD());
        f10922a.put("MODE", new MODE());
        f10922a.put("NLST", new NLST());
        f10922a.put("NOOP", new NOOP());
        f10922a.put("OPTS", new OPTS());
        f10922a.put("PASS", new PASS());
        f10922a.put("PASV", new PASV());
        f10922a.put("PBSZ", new PBSZ());
        f10922a.put("PORT", new PORT());
        f10922a.put("PROT", new PROT());
        f10922a.put("PWD", new PWD());
        f10922a.put("QUIT", new QUIT());
        f10922a.put("REIN", new REIN());
        f10922a.put("REST", new REST());
        f10922a.put("RETR", new RETR());
        f10922a.put("RMD", new RMD());
        f10922a.put("RNFR", new RNFR());
        f10922a.put("RNTO", new RNTO());
        f10922a.put("SITE", new SITE());
        f10922a.put("SIZE", new SIZE());
        f10922a.put("SITE_DESCUSER", new SITE_DESCUSER());
        f10922a.put("SITE_HELP", new SITE_HELP());
        f10922a.put("SITE_STAT", new SITE_STAT());
        f10922a.put("SITE_WHO", new SITE_WHO());
        f10922a.put("SITE_ZONE", new SITE_ZONE());
        f10922a.put("STAT", new STAT());
        f10922a.put("STOR", new STOR());
        f10922a.put("STOU", new STOU());
        f10922a.put("STRU", new STRU());
        f10922a.put("SYST", new SYST());
        f10922a.put("TYPE", new TYPE());
        f10922a.put("USER", new USER());
    }

    /* renamed from: a */
    public CommandFactory m1969a() {
        HashMap hashMap = new HashMap();
        if (this.f10924c) {
            hashMap.putAll(f10922a);
        }
        hashMap.putAll(this.f10923b);
        return new DefaultCommandFactory(hashMap);
    }
}
