package org.apache.ftpserver.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* renamed from: org.apache.ftpserver.util.a */
/* loaded from: classes2.dex */
public class DateUtils {

    /* renamed from: a */
    private static final TimeZone f11141a = TimeZone.getTimeZone("UTC");

    /* renamed from: b */
    private static final String[] f11142b = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    /* renamed from: c */
    private static final ThreadLocal<DateFormat> f11143c = new ThreadLocal<DateFormat>() { // from class: org.apache.ftpserver.util.a.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat;
        }
    };

    /* renamed from: a */
    public static final String m1673a(long j) {
        if (j < 0) {
            return "------------";
        }
        StringBuilder sb = new StringBuilder(16);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(j);
        sb.append(f11142b[gregorianCalendar.get(2)]);
        sb.append(' ');
        int i = gregorianCalendar.get(5);
        if (i < 10) {
            sb.append(' ');
        }
        sb.append(i);
        sb.append(' ');
        if (Math.abs(System.currentTimeMillis() - j) > 15811200000L) {
            int i2 = gregorianCalendar.get(1);
            sb.append(' ');
            sb.append(i2);
        } else {
            int i3 = gregorianCalendar.get(11);
            if (i3 < 10) {
                sb.append('0');
            }
            sb.append(i3);
            sb.append(':');
            int i4 = gregorianCalendar.get(12);
            if (i4 < 10) {
                sb.append('0');
            }
            sb.append(i4);
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static final String m1671b(long j) {
        StringBuilder sb = new StringBuilder(19);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(j);
        sb.append(gregorianCalendar.get(1));
        sb.append('-');
        int i = gregorianCalendar.get(2) + 1;
        if (i < 10) {
            sb.append('0');
        }
        sb.append(i);
        sb.append('-');
        int i2 = gregorianCalendar.get(5);
        if (i2 < 10) {
            sb.append('0');
        }
        sb.append(i2);
        sb.append('T');
        int i3 = gregorianCalendar.get(11);
        if (i3 < 10) {
            sb.append('0');
        }
        sb.append(i3);
        sb.append(':');
        int i4 = gregorianCalendar.get(12);
        if (i4 < 10) {
            sb.append('0');
        }
        sb.append(i4);
        sb.append(':');
        int i5 = gregorianCalendar.get(13);
        if (i5 < 10) {
            sb.append('0');
        }
        sb.append(i5);
        return sb.toString();
    }

    /* renamed from: c */
    public static final String m1670c(long j) {
        StringBuilder sb = new StringBuilder(20);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(f11141a);
        gregorianCalendar.setTimeInMillis(j);
        sb.append(gregorianCalendar.get(1));
        int i = gregorianCalendar.get(2) + 1;
        if (i < 10) {
            sb.append('0');
        }
        sb.append(i);
        int i2 = gregorianCalendar.get(5);
        if (i2 < 10) {
            sb.append('0');
        }
        sb.append(i2);
        int i3 = gregorianCalendar.get(11);
        if (i3 < 10) {
            sb.append('0');
        }
        sb.append(i3);
        int i4 = gregorianCalendar.get(12);
        if (i4 < 10) {
            sb.append('0');
        }
        sb.append(i4);
        int i5 = gregorianCalendar.get(13);
        if (i5 < 10) {
            sb.append('0');
        }
        sb.append(i5);
        sb.append('.');
        int i6 = gregorianCalendar.get(14);
        if (i6 < 100) {
            sb.append('0');
        }
        if (i6 < 10) {
            sb.append('0');
        }
        sb.append(i6);
        return sb.toString();
    }

    /* renamed from: a */
    public static final Date m1672a(String str) throws ParseException {
        return f11143c.get().parse(str);
    }
}
