package org.mp4parser.p144a;

import java.util.Date;

/* renamed from: org.mp4parser.a.b */
/* loaded from: classes2.dex */
public class DateHelper {
    /* renamed from: a */
    public static Date m742a(long j) {
        return new Date((j - 2082844800) * 1000);
    }

    /* renamed from: a */
    public static long m741a(Date date) {
        return (date.getTime() / 1000) + 2082844800;
    }
}
