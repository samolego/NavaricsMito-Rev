package butterknife.internal;

import android.support.annotation.IdRes;
import android.util.TypedValue;
import android.view.View;

/* compiled from: Utils.java */
/* renamed from: butterknife.internal.b */
/* loaded from: classes.dex */
public final class C0506b {

    /* renamed from: a */
    private static final TypedValue f141a = new TypedValue();

    /* renamed from: a */
    public static View m157a(View view, @IdRes int i, String str) {
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            return findViewById;
        }
        throw new IllegalStateException("Required view '" + m159a(view, i) + "' with ID " + i + " for " + str + " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
    }

    /* renamed from: a */
    public static <T> T m158a(View view, @IdRes int i, String str, Class<T> cls) {
        return (T) m160b(m157a(view, i, str), i, str, cls);
    }

    /* renamed from: b */
    public static <T> T m160b(View view, @IdRes int i, String str, Class<T> cls) {
        try {
            return cls.cast(view);
        } catch (ClassCastException e) {
            throw new IllegalStateException("View '" + m159a(view, i) + "' with ID " + i + " for " + str + " was of the wrong type. See cause for more info.", e);
        }
    }

    /* renamed from: a */
    private static String m159a(View view, @IdRes int i) {
        return view.isInEditMode() ? "<unavailable while editing>" : view.getContext().getResources().getResourceEntryName(i);
    }
}