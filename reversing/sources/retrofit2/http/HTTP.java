package retrofit2.http;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface HTTP {
    /* renamed from: a */
    String m120a();

    /* renamed from: b */
    String m119b() default "";

    /* renamed from: c */
    boolean m118c() default false;
}
