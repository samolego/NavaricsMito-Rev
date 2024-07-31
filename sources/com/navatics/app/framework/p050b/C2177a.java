package com.navatics.app.framework.p050b;

import com.navatics.app.framework.NvConnection;
import com.navatics.app.framework.p050b.EventPipeline;
import java.lang.reflect.Method;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.framework.b.a */
/* loaded from: classes.dex */
public class CurConnectionChangedEventValidator implements EventHandlerValidator {

    /* renamed from: a */
    private final C3044k f4254a = C3044k.m1564a(CurConnectionChangedEventValidator.class);

    @Override // com.navatics.app.framework.p050b.EventHandlerValidator
    /* renamed from: a */
    public EventPipeline.C1751a mo8569a(Object obj, Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length != 2) {
            C3044k c3044k = this.f4254a;
            c3044k.mo1504b((Object) ("Event CUR_CONNECTION_CHANGED need 2 parameter, but we got " + parameterTypes.length));
            return null;
        }
        Class<?> cls = parameterTypes[0];
        if (cls != NvConnection.class) {
            C3044k c3044k2 = this.f4254a;
            c3044k2.mo1504b((Object) ("Event CUR_CONNECTION_CHANGED handler first parameter expect NvConnection, but we got " + cls.getCanonicalName()));
            return null;
        }
        Class<?> cls2 = parameterTypes[1];
        if (cls2 != NvConnection.class) {
            C3044k c3044k3 = this.f4254a;
            c3044k3.mo1504b((Object) ("Event CUR_CONNECTION_CHANGED handler second parameter expect NvConnection, but we got " + cls2.getCanonicalName()));
            return null;
        }
        return new EventPipeline.C1751a(obj, method, 196610, 0);
    }
}
