package com.senseplay.sdk.tool;

import java.util.Locale;

/* loaded from: classes2.dex */
public class LanguageTool {
    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getCountry() {
        return Locale.getDefault().getCountry();
    }
}
