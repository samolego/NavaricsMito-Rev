package okhttp3.internal.p104b;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import okhttp3.internal.C2930c;

/* renamed from: okhttp3.internal.b.d */
/* loaded from: classes2.dex */
public final class HttpDate {

    /* renamed from: a */
    private static final ThreadLocal<DateFormat> f10152a = new ThreadLocal<DateFormat>() { // from class: okhttp3.internal.b.d.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(C2930c.f10185g);
            return simpleDateFormat;
        }
    };

    /* renamed from: b */
    private static final String[] f10153b = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};

    /* renamed from: c */
    private static final DateFormat[] f10154c = new DateFormat[f10153b.length];

    /* renamed from: a */
    public static Date m2934a(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = f10152a.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        synchronized (f10153b) {
            int length = f10153b.length;
            for (int i = 0; i < length; i++) {
                DateFormat dateFormat = f10154c[i];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(f10153b[i], Locale.US);
                    dateFormat.setTimeZone(C2930c.f10185g);
                    f10154c[i] = dateFormat;
                }
                parsePosition.setIndex(0);
                Date parse2 = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    public static String m2933a(Date date) {
        return f10152a.get().format(date);
    }
}
