package com.facebook.appevents.p039a;

import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.appevents.a.b */
/* loaded from: classes.dex */
final class MetadataMatcher {

    /* renamed from: a */
    private static final String f1537a = MetadataMatcher.class.getCanonicalName();

    MetadataMatcher() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static List<String> m11273a(View view) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add(ViewHierarchy.m11098f(view));
        Object tag = view.getTag();
        if (tag != null) {
            arrayList.add(tag.toString());
        }
        CharSequence contentDescription = view.getContentDescription();
        if (contentDescription != null) {
            arrayList.add(contentDescription.toString());
        }
        try {
            if (view.getId() != -1) {
                String[] split = view.getResources().getResourceName(view.getId()).split("/");
                if (split.length == 2) {
                    arrayList.add(split[1]);
                }
            }
        } catch (Resources.NotFoundException unused) {
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            if (!str.isEmpty() && str.length() <= 100) {
                arrayList2.add(str.toLowerCase());
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m11270a(List<String> list, List<String> list2) {
        for (String str : list) {
            if (m11271a(str, list2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static boolean m11271a(String str, List<String> list) {
        for (String str2 : list) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m11272a(String str, String str2) {
        return str.matches(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static List<String> m11269b(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof EditText) {
            return arrayList;
        }
        if (view instanceof TextView) {
            String charSequence = ((TextView) view).getText().toString();
            if (!charSequence.isEmpty() && charSequence.length() < 100) {
                arrayList.add(charSequence.toLowerCase());
            }
            return arrayList;
        }
        for (View view2 : ViewHierarchy.m11102b(view)) {
            arrayList.addAll(m11269b(view2));
        }
        return arrayList;
    }
}
