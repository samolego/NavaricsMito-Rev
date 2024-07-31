package com.navatics.app.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface EventHandler {
    @EventType
    /* renamed from: a */
    int m8586a() default 0;

    /* renamed from: b */
    int m8585b();

    @EventExecutorType
    /* renamed from: c */
    int m8584c() default 0;
}
