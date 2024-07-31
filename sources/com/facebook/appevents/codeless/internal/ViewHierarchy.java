package com.facebook.appevents.codeless.internal;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.p008v4.view.NestedScrollingChild;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import com.facebook.internal.Utility;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.appevents.codeless.internal.d */
/* loaded from: classes.dex */
public class ViewHierarchy {

    /* renamed from: a */
    private static final String f1693a = ViewHierarchy.class.getCanonicalName();

    /* renamed from: b */
    private static WeakReference<View> f1694b = new WeakReference<>(null);
    @Nullable

    /* renamed from: c */
    private static Method f1695c = null;

    @Nullable
    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    /* renamed from: a */
    public static ViewGroup m11107a(View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            return (ViewGroup) parent;
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    /* renamed from: b */
    public static List<View> m11102b(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                arrayList.add(viewGroup.getChildAt(i));
            }
        }
        return arrayList;
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    /* renamed from: a */
    public static void m11104a(View view, JSONObject jSONObject) {
        try {
            String m11099e = m11099e(view);
            String m11098f = m11098f(view);
            Object tag = view.getTag();
            CharSequence contentDescription = view.getContentDescription();
            jSONObject.put("classname", view.getClass().getCanonicalName());
            jSONObject.put("classtypebitmask", m11100d(view));
            jSONObject.put("id", view.getId());
            if (!SensitiveUserDataUtils.m11118a(view)) {
                jSONObject.put("text", Utility.m10527a(Utility.m10497c(m11099e), ""));
            } else {
                jSONObject.put("text", "");
                jSONObject.put("is_user_input", true);
            }
            jSONObject.put("hint", Utility.m10527a(Utility.m10497c(m11098f), ""));
            if (tag != null) {
                jSONObject.put("tag", Utility.m10527a(Utility.m10497c(tag.toString()), ""));
            }
            if (contentDescription != null) {
                jSONObject.put("description", Utility.m10527a(Utility.m10497c(contentDescription.toString()), ""));
            }
            jSONObject.put("dimension", m11092l(view));
        } catch (JSONException e) {
            Utility.m10528a(f1693a, (Exception) e);
        }
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    /* renamed from: c */
    public static JSONObject m11101c(View view) {
        if (view.getClass().getName().equals("com.facebook.react.ReactRootView")) {
            f1694b = new WeakReference<>(view);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            m11104a(view, jSONObject);
            JSONArray jSONArray = new JSONArray();
            List<View> m11102b = m11102b(view);
            for (int i = 0; i < m11102b.size(); i++) {
                jSONArray.put(m11101c(m11102b.get(i)));
            }
            jSONObject.put("childviews", jSONArray);
        } catch (JSONException e) {
            Log.e(f1693a, "Failed to create JSONObject for view.", e);
        }
        return jSONObject;
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    /* renamed from: d */
    public static int m11100d(View view) {
        int i = view instanceof ImageView ? 2 : 0;
        if (view.isClickable()) {
            i |= 32;
        }
        if (m11093k(view)) {
            i |= 512;
        }
        if (!(view instanceof TextView)) {
            return ((view instanceof Spinner) || (view instanceof DatePicker)) ? i | 4096 : view instanceof RatingBar ? i | 65536 : view instanceof RadioGroup ? i | 16384 : ((view instanceof ViewGroup) && m11105a(view, f1694b.get())) ? i | 64 : i;
        }
        int i2 = i | 1024 | 1;
        if (view instanceof Button) {
            i2 |= 4;
            if (view instanceof Switch) {
                i2 |= 8192;
            } else if (view instanceof CheckBox) {
                i2 |= 32768;
            }
        }
        return view instanceof EditText ? i2 | 2048 : i2;
    }

    /* renamed from: k */
    private static boolean m11093k(View view) {
        ViewParent parent = view.getParent();
        return (parent instanceof AdapterView) || (parent instanceof NestedScrollingChild);
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    /* renamed from: e */
    public static String m11099e(View view) {
        Object selectedItem;
        CharSequence charSequence = null;
        if (view instanceof TextView) {
            charSequence = ((TextView) view).getText();
            if (view instanceof Switch) {
                charSequence = ((Switch) view).isChecked() ? "1" : "0";
            }
        } else if (view instanceof Spinner) {
            Spinner spinner = (Spinner) view;
            if (spinner.getCount() > 0 && (selectedItem = spinner.getSelectedItem()) != null) {
                charSequence = selectedItem.toString();
            }
        } else {
            int i = 0;
            if (view instanceof DatePicker) {
                DatePicker datePicker = (DatePicker) view;
                charSequence = String.format("%04d-%02d-%02d", Integer.valueOf(datePicker.getYear()), Integer.valueOf(datePicker.getMonth()), Integer.valueOf(datePicker.getDayOfMonth()));
            } else if (view instanceof TimePicker) {
                TimePicker timePicker = (TimePicker) view;
                charSequence = String.format("%02d:%02d", Integer.valueOf(timePicker.getCurrentHour().intValue()), Integer.valueOf(timePicker.getCurrentMinute().intValue()));
            } else if (view instanceof RadioGroup) {
                RadioGroup radioGroup = (RadioGroup) view;
                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                int childCount = radioGroup.getChildCount();
                while (true) {
                    if (i >= childCount) {
                        break;
                    }
                    View childAt = radioGroup.getChildAt(i);
                    if (childAt.getId() == checkedRadioButtonId && (childAt instanceof RadioButton)) {
                        charSequence = ((RadioButton) childAt).getText();
                        break;
                    }
                    i++;
                }
            } else if (view instanceof RatingBar) {
                charSequence = String.valueOf(((RatingBar) view).getRating());
            }
        }
        return charSequence == null ? "" : charSequence.toString();
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    /* renamed from: f */
    public static String m11098f(View view) {
        CharSequence hint;
        if (view instanceof EditText) {
            hint = ((EditText) view).getHint();
        } else {
            hint = view instanceof TextView ? ((TextView) view).getHint() : null;
        }
        return hint == null ? "" : hint.toString();
    }

    /* renamed from: l */
    private static JSONObject m11092l(View view) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("top", view.getTop());
            jSONObject.put("left", view.getLeft());
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put("scrollx", view.getScrollX());
            jSONObject.put("scrolly", view.getScrollY());
            jSONObject.put("visibility", view.getVisibility());
        } catch (JSONException e) {
            Log.e(f1693a, "Failed to create JSONObject for dimension.", e);
        }
        return jSONObject;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    /* renamed from: g */
    public static View.OnClickListener m11097g(View view) {
        Field declaredField;
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj != null && (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener")) != null) {
                declaredField.setAccessible(true);
                return (View.OnClickListener) declaredField.get(obj);
            }
            return null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021 A[ADDED_TO_REGION] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m11106a(android.view.View r4, android.view.View.OnClickListener r5) {
        /*
            r0 = 0
            java.lang.String r1 = "android.view.View"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.NoSuchFieldException -> L1a java.lang.ClassNotFoundException -> L1d java.lang.Exception -> L40
            java.lang.String r2 = "mListenerInfo"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch: java.lang.NoSuchFieldException -> L1a java.lang.ClassNotFoundException -> L1d java.lang.Exception -> L40
            java.lang.String r2 = "android.view.View$ListenerInfo"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.NoSuchFieldException -> L1b java.lang.ClassNotFoundException -> L1e java.lang.Exception -> L40
            java.lang.String r3 = "mOnClickListener"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch: java.lang.NoSuchFieldException -> L1b java.lang.ClassNotFoundException -> L1e java.lang.Exception -> L40
            goto L1f
        L1a:
            r1 = r0
        L1b:
            r2 = r0
            goto L1f
        L1d:
            r1 = r0
        L1e:
            r2 = r0
        L1f:
            if (r1 == 0) goto L3c
            if (r2 != 0) goto L24
            goto L3c
        L24:
            r3 = 1
            r1.setAccessible(r3)     // Catch: java.lang.Exception -> L40
            r2.setAccessible(r3)     // Catch: java.lang.Exception -> L40
            r1.setAccessible(r3)     // Catch: java.lang.IllegalAccessException -> L32 java.lang.Exception -> L40
            java.lang.Object r0 = r1.get(r4)     // Catch: java.lang.IllegalAccessException -> L32 java.lang.Exception -> L40
        L32:
            if (r0 != 0) goto L38
            r4.setOnClickListener(r5)     // Catch: java.lang.Exception -> L40
            return
        L38:
            r2.set(r0, r5)     // Catch: java.lang.Exception -> L40
            goto L40
        L3c:
            r4.setOnClickListener(r5)     // Catch: java.lang.Exception -> L40
            return
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.ViewHierarchy.m11106a(android.view.View, android.view.View$OnClickListener):void");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    /* renamed from: h */
    public static View.OnTouchListener m11096h(View view) {
        Field declaredField;
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj != null && (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener")) != null) {
                declaredField.setAccessible(true);
                return (View.OnTouchListener) declaredField.get(obj);
            }
            return null;
        } catch (ClassNotFoundException e) {
            Utility.m10528a(f1693a, (Exception) e);
            return null;
        } catch (IllegalAccessException e2) {
            Utility.m10528a(f1693a, (Exception) e2);
            return null;
        } catch (NoSuchFieldException e3) {
            Utility.m10528a(f1693a, (Exception) e3);
            return null;
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    /* renamed from: a */
    public static View m11103a(float[] fArr, @Nullable View view) {
        m11108a();
        Method method = f1695c;
        if (method == null || view == null) {
            return null;
        }
        try {
            View view2 = (View) method.invoke(null, fArr, view);
            if (view2 != null && view2.getId() > 0) {
                View view3 = (View) view2.getParent();
                if (view3 != null) {
                    return view3;
                }
                return null;
            }
        } catch (IllegalAccessException e) {
            Utility.m10528a(f1693a, (Exception) e);
        } catch (InvocationTargetException e2) {
            Utility.m10528a(f1693a, (Exception) e2);
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    /* renamed from: a */
    public static boolean m11105a(View view, @Nullable View view2) {
        View m11103a;
        return view.getClass().getName().equals("com.facebook.react.views.view.ReactViewGroup") && (m11103a = m11103a(m11091m(view), view2)) != null && m11103a.getId() == view.getId();
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    /* renamed from: i */
    public static boolean m11095i(View view) {
        return view.getClass().getName().equals("com.facebook.react.ReactRootView");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    /* renamed from: j */
    public static View m11094j(View view) {
        while (view != null) {
            if (m11095i(view)) {
                return view;
            }
            ViewParent parent = view.getParent();
            if (!(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
        return null;
    }

    /* renamed from: m */
    private static float[] m11091m(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new float[]{iArr[0], iArr[1]};
    }

    /* renamed from: a */
    private static void m11108a() {
        if (f1695c != null) {
            return;
        }
        try {
            f1695c = Class.forName("com.facebook.react.uimanager.TouchTargetHelper").getDeclaredMethod("findTouchTargetView", float[].class, ViewGroup.class);
            f1695c.setAccessible(true);
        } catch (ClassNotFoundException e) {
            Utility.m10528a(f1693a, (Exception) e);
        } catch (NoSuchMethodException e2) {
            Utility.m10528a(f1693a, (Exception) e2);
        }
    }
}
