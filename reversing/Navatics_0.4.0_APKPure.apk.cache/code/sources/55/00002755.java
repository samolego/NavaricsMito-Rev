package org.mp4parser.p133a;

import java.util.Date;

/* compiled from: DateHelper.java */
/* renamed from: org.mp4parser.a.b, reason: use source file name */
/* loaded from: classes2.dex */
public class DateHelper {
    /* renamed from: a */
    public static Date m12072a(long j) {
        return new Date((j - 2082844800) * 1000);
    }

    /* renamed from: a */
    public static long m12071a(Date date) {
        return (date.getTime() / 1000) + 2082844800;
    }
}