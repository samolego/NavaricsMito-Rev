package com.navatics.app.framework.p050b;

import com.navatics.app.framework.annotation.EventType;
import com.navatics.app.framework.p050b.EventPipeline;
import com.navatics.robot.transport.NvError;
import java.lang.reflect.Method;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.framework.b.n */
/* loaded from: classes.dex */
public class EventTypeHandlerValidatorImpl implements EventTypeHandlerValidator {

    /* renamed from: a */
    private final C3044k f4279a = C3044k.m1564a(EventTypeHandlerValidatorImpl.class);

    @Override // com.navatics.app.framework.p050b.EventTypeHandlerValidator
    /* renamed from: a */
    public EventPipeline.C1751a mo8570a(Object obj, Method method, @EventType int i) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length != 3) {
            C3044k c3044k = this.f4279a;
            c3044k.mo1504b((Object) ("Event Type Handler must be 3 parameters, but we got " + parameterTypes.length));
            return null;
        }
        Class<?> cls = parameterTypes[0];
        if (cls != Integer.TYPE) {
            C3044k c3044k2 = this.f4279a;
            c3044k2.mo1504b((Object) ("Event Type Handler parameter 1 must be an Integer, but we got " + cls.toString()));
            return null;
        }
        Class<?> cls2 = parameterTypes[2];
        if (cls2 != NvError.class) {
            C3044k c3044k3 = this.f4279a;
            c3044k3.mo1504b((Object) ("Event Type Handler parameter 3 must be NvError, but we got " + cls2.toString()));
            return null;
        }
        return new EventPipeline.C1751a(obj, method, 0, i);
    }
}
