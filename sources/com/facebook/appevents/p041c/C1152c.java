package com.facebook.appevents.p041c;

import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TimePicker;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.appevents.c.c */
/* loaded from: classes.dex */
class SuggestedEventViewHierarchy {

    /* renamed from: a */
    static final String f1583a = SuggestedEventViewHierarchy.class.getCanonicalName();

    /* renamed from: b */
    private static final List<Class<? extends View>> f1584b = new ArrayList(Arrays.asList(Switch.class, Spinner.class, DatePicker.class, TimePicker.class, RadioGroup.class, RatingBar.class, EditText.class, AdapterView.class));

    SuggestedEventViewHierarchy() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static JSONObject m11205a(View view, View view2) {
        JSONObject jSONObject = new JSONObject();
        if (view == view2) {
            try {
                jSONObject.put("is_interacted", true);
            } catch (JSONException unused) {
            }
        }
        m11204a(view, jSONObject);
        JSONArray jSONArray = new JSONArray();
        List<View> m11102b = ViewHierarchy.m11102b(view);
        for (int i = 0; i < m11102b.size(); i++) {
            jSONArray.put(m11205a(m11102b.get(i), view2));
        }
        jSONObject.put("childviews", jSONArray);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m11204a(View view, JSONObject jSONObject) {
        try {
            String m11099e = ViewHierarchy.m11099e(view);
            String m11098f = ViewHierarchy.m11098f(view);
            jSONObject.put("classname", view.getClass().getSimpleName());
            jSONObject.put("classtypebitmask", ViewHierarchy.m11100d(view));
            if (!m11099e.isEmpty()) {
                jSONObject.put("text", m11099e);
            }
            if (!m11098f.isEmpty()) {
                jSONObject.put("hint", m11098f);
            }
            if (view instanceof EditText) {
                jSONObject.put("inputtype", ((EditText) view).getInputType());
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static List<View> m11206a(View view) {
        ArrayList arrayList = new ArrayList();
        for (Class<? extends View> cls : f1584b) {
            if (cls.isInstance(view)) {
                return arrayList;
            }
        }
        if (view.isClickable()) {
            arrayList.add(view);
        }
        for (View view2 : ViewHierarchy.m11102b(view)) {
            arrayList.addAll(m11206a(view2));
        }
        return arrayList;
    }
}
