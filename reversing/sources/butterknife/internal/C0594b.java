package butterknife.internal;

import android.support.annotation.IdRes;
import android.util.TypedValue;
import android.view.View;

/* renamed from: butterknife.internal.b */
/* loaded from: classes.dex */
public final class Utils {

    /* renamed from: a */
    private static final TypedValue f141a = new TypedValue();

    /* renamed from: a */
    public static View m12800a(View view, @IdRes int i, String str) {
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            return findViewById;
        }
        String m12801a = m12801a(view, i);
        throw new IllegalStateException("Required view '" + m12801a + "' with ID " + i + " for " + str + " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
    }

    /* renamed from: a */
    public static <T> T m12799a(View view, @IdRes int i, String str, Class<T> cls) {
        return (T) m12798b(m12800a(view, i, str), i, str, cls);
    }

    /* renamed from: b */
    public static <T> T m12798b(View view, @IdRes int i, String str, Class<T> cls) {
        try {
            return cls.cast(view);
        } catch (ClassCastException e) {
            String m12801a = m12801a(view, i);
            throw new IllegalStateException("View '" + m12801a + "' with ID " + i + " for " + str + " was of the wrong type. See cause for more info.", e);
        }
    }

    /* renamed from: a */
    private static String m12801a(View view, @IdRes int i) {
        return view.isInEditMode() ? "<unavailable while editing>" : view.getContext().getResources().getResourceEntryName(i);
    }
}
