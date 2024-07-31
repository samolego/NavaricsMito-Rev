package org.apache.ftpserver.p110a.p111a;

import java.util.HashMap;
import java.util.Map;
import org.apache.ftpserver.p110a.Command;
import org.apache.ftpserver.p110a.CommandFactory;

/* renamed from: org.apache.ftpserver.a.a.h */
/* loaded from: classes2.dex */
public class DefaultCommandFactory implements CommandFactory {

    /* renamed from: a */
    private final Map<String, Command> f10902a;

    public DefaultCommandFactory() {
        this(new HashMap());
    }

    public DefaultCommandFactory(Map<String, Command> map) {
        this.f10902a = map;
    }

    @Override // org.apache.ftpserver.p110a.CommandFactory
    /* renamed from: a */
    public Command mo1970a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        return this.f10902a.get(str.toUpperCase());
    }
}
