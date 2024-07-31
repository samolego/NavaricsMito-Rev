package com.navatics.app.framework.p050b;

import android.support.p008v4.view.InputDeviceCompat;
import com.navatics.app.framework.NvConnection;
import com.navatics.app.framework.p050b.EventPipeline;
import java.lang.reflect.Method;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.framework.b.e */
/* loaded from: classes.dex */
public class DeviceConnectedEventValidator implements EventHandlerValidator {

    /* renamed from: a */
    private final C3044k f4258a = C3044k.m1564a(DeviceConnectedEventValidator.class);

    @Override // com.navatics.app.framework.p050b.EventHandlerValidator
    /* renamed from: a */
    public EventPipeline.C1751a mo8569a(Object obj, Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length != 1) {
            C3044k c3044k = this.f4258a;
            c3044k.mo1504b((Object) ("Event DEVICE_CONNECTED need 1 parameter, but we got " + parameterTypes.length));
            return null;
        }
        Class<?> cls = parameterTypes[0];
        if (cls != NvConnection.class) {
            C3044k c3044k2 = this.f4258a;
            c3044k2.mo1504b((Object) ("Event DEVICE_CONNECTED first parameter expect NvConnection, but we got " + cls.getCanonicalName()));
            return null;
        }
        return new EventPipeline.C1751a(obj, method, InputDeviceCompat.SOURCE_TRACKBALL, 0);
    }
}
