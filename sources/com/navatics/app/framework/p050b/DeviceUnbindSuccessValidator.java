package com.navatics.app.framework.p050b;

import com.navatics.app.framework.NvConnection;
import com.navatics.app.framework.p050b.EventPipeline;
import java.lang.reflect.Method;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.framework.b.j */
/* loaded from: classes.dex */
public class DeviceUnbindSuccessValidator implements EventHandlerValidator {

    /* renamed from: a */
    private final C3044k f4263a = C3044k.m1564a(DeviceUnbindSuccessValidator.class);

    @Override // com.navatics.app.framework.p050b.EventHandlerValidator
    /* renamed from: a */
    public EventPipeline.C1751a mo8569a(Object obj, Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length != 1) {
            C3044k c3044k = this.f4263a;
            c3044k.mo1504b((Object) ("Event DEVICE_UNBIND_SUCCESS need 1 parameter, but we got " + parameterTypes.length));
            return null;
        }
        Class<?> cls = parameterTypes[0];
        if (cls != NvConnection.class) {
            C3044k c3044k2 = this.f4263a;
            c3044k2.mo1504b((Object) ("Event DEVICE_UNBIND_SUCCESS first parameter expect NvConnection, but we got " + cls.getCanonicalName()));
            return null;
        }
        return new EventPipeline.C1751a(obj, method, 65567, 0);
    }
}
