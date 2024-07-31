package com.facebook.appevents.p037c;

import android.support.annotation.Nullable;
import android.support.media.ExifInterface;
import android.util.Patterns;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FeatureExtractor.java */
/* renamed from: com.facebook.appevents.c.a, reason: use source file name */
/* loaded from: classes.dex */
final class FeatureExtractor {

    /* renamed from: a */
    private static Map<String, String> f1581a = null;

    /* renamed from: b */
    private static Map<String, String> f1582b = null;

    /* renamed from: c */
    private static Map<String, String> f1583c = null;

    /* renamed from: d */
    private static JSONObject f1584d = null;

    /* renamed from: e */
    private static boolean f1585e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m1741a(File file) {
        try {
            f1584d = new JSONObject();
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            f1584d = new JSONObject(new String(bArr, "UTF-8"));
            f1581a = new HashMap();
            f1581a.put("ENGLISH", "1");
            f1581a.put("GERMAN", ExifInterface.GPS_MEASUREMENT_2D);
            f1581a.put("SPANISH", ExifInterface.GPS_MEASUREMENT_3D);
            f1581a.put("JAPANESE", "4");
            f1582b = new HashMap();
            f1582b.put("VIEW_CONTENT", "0");
            f1582b.put("SEARCH", "1");
            f1582b.put("ADD_TO_CART", ExifInterface.GPS_MEASUREMENT_2D);
            f1582b.put("ADD_TO_WISHLIST", ExifInterface.GPS_MEASUREMENT_3D);
            f1582b.put("INITIATE_CHECKOUT", "4");
            f1582b.put("ADD_PAYMENT_INFO", "5");
            f1582b.put("PURCHASE", "6");
            f1582b.put("LEAD", "7");
            f1582b.put("COMPLETE_REGISTRATION", "8");
            f1583c = new HashMap();
            f1583c.put("BUTTON_TEXT", "1");
            f1583c.put("PAGE_TITLE", ExifInterface.GPS_MEASUREMENT_2D);
            f1583c.put("RESOLVED_DOCUMENT_LINK", ExifInterface.GPS_MEASUREMENT_3D);
            f1583c.put("BUTTON_ID", "4");
            f1585e = true;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m1744a() {
        return f1585e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m1740a(String str, String str2, String str3) {
        return (str3 + " | " + str2 + ", " + str).toLowerCase();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public static float[] m1750a(JSONObject jSONObject, String str) {
        if (!f1585e) {
            return null;
        }
        float[] fArr = new float[30];
        Arrays.fill(fArr, 0.0f);
        try {
            String lowerCase = str.toLowerCase();
            JSONObject jSONObject2 = new JSONObject(jSONObject.optJSONObject("view").toString());
            String optString = jSONObject.optString("screenname");
            JSONArray jSONArray = new JSONArray();
            m1747a(jSONObject2, jSONArray);
            m1743a(fArr, m1749a(jSONObject2));
            JSONObject m1753c = m1753c(jSONObject2);
            if (m1753c == null) {
                return null;
            }
            m1743a(fArr, m1751a(m1753c, jSONArray, optString, jSONObject2.toString(), lowerCase));
            return fArr;
        } catch (JSONException unused) {
            return fArr;
        }
    }

    /* renamed from: a */
    private static float[] m1749a(JSONObject jSONObject) {
        float[] fArr = new float[30];
        Arrays.fill(fArr, 0.0f);
        String lowerCase = jSONObject.optString("text").toLowerCase();
        String lowerCase2 = jSONObject.optString("hint").toLowerCase();
        String lowerCase3 = jSONObject.optString("classname").toLowerCase();
        int optInt = jSONObject.optInt("inputtype", -1);
        String[] strArr = {lowerCase, lowerCase2};
        if (m1748a(new String[]{"$", "amount", "price", "total"}, strArr)) {
            fArr[0] = (float) (fArr[0] + 1.0d);
        }
        if (m1748a(new String[]{"password", "pwd"}, strArr)) {
            fArr[1] = (float) (fArr[1] + 1.0d);
        }
        if (m1748a(new String[]{"tel", "phone"}, strArr)) {
            fArr[2] = (float) (fArr[2] + 1.0d);
        }
        if (m1748a(new String[]{"search"}, strArr)) {
            fArr[4] = (float) (fArr[4] + 1.0d);
        }
        if (optInt >= 0) {
            fArr[5] = (float) (fArr[5] + 1.0d);
        }
        if (optInt == 3 || optInt == 2) {
            fArr[6] = (float) (fArr[6] + 1.0d);
        }
        if (optInt == 32 || Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
            fArr[7] = (float) (fArr[7] + 1.0d);
        }
        if (lowerCase3.contains("checkbox")) {
            fArr[8] = (float) (fArr[8] + 1.0d);
        }
        if (m1748a(new String[]{"complete", "confirm", "done", "submit"}, new String[]{lowerCase})) {
            fArr[10] = (float) (fArr[10] + 1.0d);
        }
        if (lowerCase3.contains("radio") && lowerCase3.contains("button")) {
            fArr[12] = (float) (fArr[12] + 1.0d);
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childviews");
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                m1743a(fArr, m1749a(optJSONArray.getJSONObject(i)));
            }
        } catch (JSONException unused) {
        }
        return fArr;
    }

    /* renamed from: a */
    private static float[] m1751a(JSONObject jSONObject, JSONArray jSONArray, String str, String str2, String str3) {
        float[] fArr = new float[30];
        Arrays.fill(fArr, 0.0f);
        fArr[3] = jSONArray.length() > 1 ? r2 - 1 : 0;
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                if (m1752b(jSONArray.getJSONObject(i))) {
                    fArr[9] = fArr[9] + 1.0f;
                }
            } catch (JSONException unused) {
            }
        }
        fArr[13] = -1.0f;
        fArr[14] = -1.0f;
        String str4 = str + '|' + str3;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        m1742a(jSONObject, sb, sb2);
        String sb3 = sb.toString();
        String sb4 = sb2.toString();
        fArr[15] = m1746a("ENGLISH", "COMPLETE_REGISTRATION", "BUTTON_TEXT", sb4) ? 1.0f : 0.0f;
        fArr[16] = m1746a("ENGLISH", "COMPLETE_REGISTRATION", "PAGE_TITLE", str4) ? 1.0f : 0.0f;
        fArr[17] = m1746a("ENGLISH", "COMPLETE_REGISTRATION", "BUTTON_ID", sb3) ? 1.0f : 0.0f;
        fArr[18] = str2.contains("password") ? 1.0f : 0.0f;
        fArr[19] = m1745a("(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)", str2) ? 1.0f : 0.0f;
        fArr[20] = m1745a("(?i)(sign in)|login|signIn", str2) ? 1.0f : 0.0f;
        fArr[21] = m1745a("(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)", str2) ? 1.0f : 0.0f;
        fArr[22] = m1746a("ENGLISH", "PURCHASE", "BUTTON_TEXT", sb4) ? 1.0f : 0.0f;
        fArr[24] = m1746a("ENGLISH", "PURCHASE", "PAGE_TITLE", str4) ? 1.0f : 0.0f;
        fArr[25] = m1745a("(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart", sb4) ? 1.0f : 0.0f;
        fArr[27] = m1745a("(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy", str4) ? 1.0f : 0.0f;
        fArr[28] = m1746a("ENGLISH", "LEAD", "BUTTON_TEXT", sb4) ? 1.0f : 0.0f;
        fArr[29] = m1746a("ENGLISH", "LEAD", "PAGE_TITLE", str4) ? 1.0f : 0.0f;
        return fArr;
    }

    /* renamed from: a */
    private static boolean m1746a(String str, String str2, String str3, String str4) {
        return m1745a(f1584d.optJSONObject("rulesForLanguage").optJSONObject(f1581a.get(str)).optJSONObject("rulesForEvent").optJSONObject(f1582b.get(str2)).optJSONObject("positiveRules").optString(f1583c.get(str3)), str4);
    }

    /* renamed from: a */
    private static boolean m1745a(String str, String str2) {
        return Pattern.compile(str).matcher(str2).find();
    }

    /* renamed from: a */
    private static boolean m1748a(String[] strArr, String[] strArr2) {
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (str2.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m1747a(JSONObject jSONObject, JSONArray jSONArray) {
        boolean z;
        boolean z2;
        try {
            if (jSONObject.optBoolean("is_interacted")) {
                return true;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("childviews");
            int i = 0;
            while (true) {
                if (i >= optJSONArray.length()) {
                    z = false;
                    z2 = false;
                    break;
                }
                if (optJSONArray.getJSONObject(i).optBoolean("is_interacted")) {
                    z = true;
                    z2 = true;
                    break;
                }
                i++;
            }
            JSONArray jSONArray2 = new JSONArray();
            if (z) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    jSONArray.put(optJSONArray.getJSONObject(i2));
                }
            } else {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    if (m1747a(jSONObject2, jSONArray)) {
                        jSONArray2.put(jSONObject2);
                        z2 = true;
                    }
                }
                jSONObject.put("childviews", jSONArray2);
            }
            return z2;
        } catch (JSONException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static void m1743a(float[] fArr, float[] fArr2) {
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = fArr[i] + fArr2[i];
        }
    }

    /* renamed from: b */
    private static boolean m1752b(JSONObject jSONObject) {
        return (jSONObject.optInt("classtypebitmask") & 32) > 0;
    }

    /* renamed from: a */
    private static void m1742a(JSONObject jSONObject, StringBuilder sb, StringBuilder sb2) {
        String lowerCase = jSONObject.optString("text", "").toLowerCase();
        String lowerCase2 = jSONObject.optString("hint", "").toLowerCase();
        if (!lowerCase.isEmpty()) {
            sb.append(lowerCase);
            sb.append(" ");
        }
        if (!lowerCase2.isEmpty()) {
            sb2.append(lowerCase2);
            sb2.append(" ");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("childviews");
        if (optJSONArray == null) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            m1742a(jSONObject, sb, sb2);
        }
    }

    @Nullable
    /* renamed from: c */
    private static JSONObject m1753c(JSONObject jSONObject) {
        if (jSONObject.optBoolean("is_interacted")) {
            return jSONObject;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("childviews");
        if (optJSONArray == null) {
            return null;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject m1753c = m1753c(optJSONArray.getJSONObject(i));
            if (m1753c != null) {
                return m1753c;
            }
        }
        return null;
    }
}