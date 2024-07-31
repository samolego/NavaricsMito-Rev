package org.apache.log4j.helpers;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class AbsoluteTimeDateFormat extends DateFormat {
    public static final String ABS_TIME_DATE_FORMAT = "ABSOLUTE";
    public static final String DATE_AND_TIME_DATE_FORMAT = "DATE";
    public static final String ISO8601_DATE_FORMAT = "ISO8601";

    /* renamed from: a */
    private static long f11229a = 0;

    /* renamed from: b */
    private static char[] f11230b = new char[9];
    private static final long serialVersionUID = -388856345976723342L;

    @Override // java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        return null;
    }

    public AbsoluteTimeDateFormat() {
        setCalendar(Calendar.getInstance());
    }

    public AbsoluteTimeDateFormat(TimeZone timeZone) {
        setCalendar(Calendar.getInstance(timeZone));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0076  */
    @Override // java.text.DateFormat
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.StringBuffer format(java.util.Date r9, java.lang.StringBuffer r10, java.text.FieldPosition r11) {
        /*
            r8 = this;
            long r0 = r9.getTime()
            r2 = 1000(0x3e8, double:4.94E-321)
            long r2 = r0 % r2
            int r11 = (int) r2
            long r2 = (long) r11
            long r0 = r0 - r2
            long r2 = org.apache.log4j.helpers.AbsoluteTimeDateFormat.f11229a
            r4 = 0
            r5 = 10
            r6 = 48
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 != 0) goto L21
            char[] r2 = org.apache.log4j.helpers.AbsoluteTimeDateFormat.f11230b
            char r3 = r2[r4]
            if (r3 != 0) goto L1d
            goto L21
        L1d:
            r10.append(r2)
            goto L72
        L21:
            java.util.Calendar r2 = r8.calendar
            r2.setTime(r9)
            int r9 = r10.length()
            java.util.Calendar r2 = r8.calendar
            r3 = 11
            int r2 = r2.get(r3)
            if (r2 >= r5) goto L37
            r10.append(r6)
        L37:
            r10.append(r2)
            r2 = 58
            r10.append(r2)
            java.util.Calendar r3 = r8.calendar
            r7 = 12
            int r3 = r3.get(r7)
            if (r3 >= r5) goto L4c
            r10.append(r6)
        L4c:
            r10.append(r3)
            r10.append(r2)
            java.util.Calendar r2 = r8.calendar
            r3 = 13
            int r2 = r2.get(r3)
            if (r2 >= r5) goto L5f
            r10.append(r6)
        L5f:
            r10.append(r2)
            r2 = 44
            r10.append(r2)
            int r2 = r10.length()
            char[] r3 = org.apache.log4j.helpers.AbsoluteTimeDateFormat.f11230b
            r10.getChars(r9, r2, r3, r4)
            org.apache.log4j.helpers.AbsoluteTimeDateFormat.f11229a = r0
        L72:
            r9 = 100
            if (r11 >= r9) goto L79
            r10.append(r6)
        L79:
            if (r11 >= r5) goto L7e
            r10.append(r6)
        L7e:
            r10.append(r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.log4j.helpers.AbsoluteTimeDateFormat.format(java.util.Date, java.lang.StringBuffer, java.text.FieldPosition):java.lang.StringBuffer");
    }
}