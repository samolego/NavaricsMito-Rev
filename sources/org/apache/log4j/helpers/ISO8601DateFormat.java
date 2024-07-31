package org.apache.log4j.helpers;

import java.text.ParsePosition;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class ISO8601DateFormat extends AbsoluteTimeDateFormat {

    /* renamed from: a */
    private static long f11190a = 0;

    /* renamed from: b */
    private static char[] f11191b = new char[20];
    private static final long serialVersionUID = -759840745298755296L;

    @Override // org.apache.log4j.helpers.AbsoluteTimeDateFormat, java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        return null;
    }

    public ISO8601DateFormat() {
    }

    public ISO8601DateFormat(TimeZone timeZone) {
        super(timeZone);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cd  */
    @Override // org.apache.log4j.helpers.AbsoluteTimeDateFormat, java.text.DateFormat
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
            long r2 = org.apache.log4j.helpers.ISO8601DateFormat.f11190a
            r4 = 0
            r5 = 10
            r6 = 48
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 != 0) goto L22
            char[] r2 = org.apache.log4j.helpers.ISO8601DateFormat.f11191b
            char r3 = r2[r4]
            if (r3 != 0) goto L1d
            goto L22
        L1d:
            r10.append(r2)
            goto Lc4
        L22:
            java.util.Calendar r2 = r8.calendar
            r2.setTime(r9)
            int r9 = r10.length()
            java.util.Calendar r2 = r8.calendar
            r3 = 1
            int r2 = r2.get(r3)
            r10.append(r2)
            java.util.Calendar r2 = r8.calendar
            r3 = 2
            int r2 = r2.get(r3)
            switch(r2) {
                case 0: goto L63;
                case 1: goto L60;
                case 2: goto L5d;
                case 3: goto L5a;
                case 4: goto L57;
                case 5: goto L54;
                case 6: goto L51;
                case 7: goto L4e;
                case 8: goto L4b;
                case 9: goto L48;
                case 10: goto L45;
                case 11: goto L42;
                default: goto L3f;
            }
        L3f:
            java.lang.String r2 = "-NA-"
            goto L65
        L42:
            java.lang.String r2 = "-12-"
            goto L65
        L45:
            java.lang.String r2 = "-11-"
            goto L65
        L48:
            java.lang.String r2 = "-10-"
            goto L65
        L4b:
            java.lang.String r2 = "-09-"
            goto L65
        L4e:
            java.lang.String r2 = "-08-"
            goto L65
        L51:
            java.lang.String r2 = "-07-"
            goto L65
        L54:
            java.lang.String r2 = "-06-"
            goto L65
        L57:
            java.lang.String r2 = "-05-"
            goto L65
        L5a:
            java.lang.String r2 = "-04-"
            goto L65
        L5d:
            java.lang.String r2 = "-03-"
            goto L65
        L60:
            java.lang.String r2 = "-02-"
            goto L65
        L63:
            java.lang.String r2 = "-01-"
        L65:
            r10.append(r2)
            java.util.Calendar r2 = r8.calendar
            r3 = 5
            int r2 = r2.get(r3)
            if (r2 >= r5) goto L74
            r10.append(r6)
        L74:
            r10.append(r2)
            r2 = 32
            r10.append(r2)
            java.util.Calendar r2 = r8.calendar
            r3 = 11
            int r2 = r2.get(r3)
            if (r2 >= r5) goto L89
            r10.append(r6)
        L89:
            r10.append(r2)
            r2 = 58
            r10.append(r2)
            java.util.Calendar r3 = r8.calendar
            r7 = 12
            int r3 = r3.get(r7)
            if (r3 >= r5) goto L9e
            r10.append(r6)
        L9e:
            r10.append(r3)
            r10.append(r2)
            java.util.Calendar r2 = r8.calendar
            r3 = 13
            int r2 = r2.get(r3)
            if (r2 >= r5) goto Lb1
            r10.append(r6)
        Lb1:
            r10.append(r2)
            r2 = 44
            r10.append(r2)
            int r2 = r10.length()
            char[] r3 = org.apache.log4j.helpers.ISO8601DateFormat.f11191b
            r10.getChars(r9, r2, r3, r4)
            org.apache.log4j.helpers.ISO8601DateFormat.f11190a = r0
        Lc4:
            r9 = 100
            if (r11 >= r9) goto Lcb
            r10.append(r6)
        Lcb:
            if (r11 >= r5) goto Ld0
            r10.append(r6)
        Ld0:
            r10.append(r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.log4j.helpers.ISO8601DateFormat.format(java.util.Date, java.lang.StringBuffer, java.text.FieldPosition):java.lang.StringBuffer");
    }
}
