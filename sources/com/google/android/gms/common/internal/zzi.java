package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.C1188R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzsi;

/* loaded from: classes.dex */
public final class zzi {

    /* renamed from: Cc */
    private static final SimpleArrayMap<String, String> f2875Cc = new SimpleArrayMap<>();

    public static String zzce(Context context) {
        String str = context.getApplicationInfo().name;
        if (TextUtils.isEmpty(str)) {
            String packageName = context.getPackageName();
            context.getApplicationContext().getPackageManager();
            try {
                return zzsi.zzcr(context).zzik(context.getPackageName()).toString();
            } catch (PackageManager.NameNotFoundException unused) {
                return packageName;
            }
        }
        return str;
    }

    @Nullable
    public static String zzg(Context context, int i) {
        String str;
        String str2;
        Resources resources = context.getResources();
        if (i == 20) {
            Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
            return zzu(context, "common_google_play_services_restricted_profile_title");
        }
        if (i != 42) {
            switch (i) {
                case 1:
                    return resources.getString(C1188R.string.common_google_play_services_install_title);
                case 2:
                    break;
                case 3:
                    return resources.getString(C1188R.string.common_google_play_services_enable_title);
                case 4:
                case 6:
                    return null;
                case 5:
                    Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                    return zzu(context, "common_google_play_services_invalid_account_title");
                case 7:
                    Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                    return zzu(context, "common_google_play_services_network_error_title");
                case 8:
                    str = "GoogleApiAvailability";
                    str2 = "Internal error occurred. Please see logs for detailed information";
                    Log.e(str, str2);
                    return null;
                case 9:
                    Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                    return resources.getString(C1188R.string.common_google_play_services_unsupported_title);
                case 10:
                    str = "GoogleApiAvailability";
                    str2 = "Developer error occurred. Please see logs for detailed information";
                    Log.e(str, str2);
                    return null;
                case 11:
                    str = "GoogleApiAvailability";
                    str2 = "The application is not licensed to the user.";
                    Log.e(str, str2);
                    return null;
                default:
                    switch (i) {
                        case 16:
                            str = "GoogleApiAvailability";
                            str2 = "One of the API components you attempted to connect to is not available.";
                            break;
                        case 17:
                            Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                            return zzu(context, "common_google_play_services_sign_in_failed_title");
                        case 18:
                            return resources.getString(C1188R.string.common_google_play_services_updating_title);
                        default:
                            str = "GoogleApiAvailability";
                            StringBuilder sb = new StringBuilder(33);
                            sb.append("Unexpected error code ");
                            sb.append(i);
                            str2 = sb.toString();
                            break;
                    }
                    Log.e(str, str2);
                    return null;
            }
        }
        return resources.getString(C1188R.string.common_google_play_services_update_title);
    }

    private static String zzg(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String zzu = zzu(context, str);
        if (zzu == null) {
            zzu = resources.getString(C1188R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, zzu, str2);
    }

    @NonNull
    public static String zzh(Context context, int i) {
        String zzu = i == 6 ? zzu(context, "common_google_play_services_resolution_required_title") : zzg(context, i);
        return zzu == null ? context.getResources().getString(C1188R.string.common_google_play_services_notification_ticker) : zzu;
    }

    @NonNull
    public static String zzi(Context context, int i) {
        Resources resources = context.getResources();
        String zzce = zzce(context);
        if (i != 5) {
            if (i != 7) {
                if (i != 9) {
                    if (i != 20) {
                        if (i != 42) {
                            switch (i) {
                                case 1:
                                    return com.google.android.gms.common.util.zzi.zzb(resources) ? resources.getString(C1188R.string.common_google_play_services_install_text_tablet, zzce) : resources.getString(C1188R.string.common_google_play_services_install_text_phone, zzce);
                                case 2:
                                    return resources.getString(C1188R.string.common_google_play_services_update_text, zzce);
                                case 3:
                                    return resources.getString(C1188R.string.common_google_play_services_enable_text, zzce);
                                default:
                                    switch (i) {
                                        case 16:
                                            return zzg(context, "common_google_play_services_api_unavailable_text", zzce);
                                        case 17:
                                            return zzg(context, "common_google_play_services_sign_in_failed_text", zzce);
                                        case 18:
                                            return resources.getString(C1188R.string.common_google_play_services_updating_text, zzce);
                                        default:
                                            return resources.getString(C1188R.string.common_google_play_services_unknown_issue, zzce);
                                    }
                            }
                        }
                        return resources.getString(C1188R.string.common_google_play_services_wear_update_text);
                    }
                    return zzg(context, "common_google_play_services_restricted_profile_text", zzce);
                }
                return resources.getString(C1188R.string.common_google_play_services_unsupported_text, zzce);
            }
            return zzg(context, "common_google_play_services_network_error_text", zzce);
        }
        return zzg(context, "common_google_play_services_invalid_account_text", zzce);
    }

    @NonNull
    public static String zzj(Context context, int i) {
        return i == 6 ? zzg(context, "common_google_play_services_resolution_required_text", zzce(context)) : zzi(context, i);
    }

    @NonNull
    public static String zzk(Context context, int i) {
        int i2;
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                i2 = C1188R.string.common_google_play_services_install_button;
                break;
            case 2:
                i2 = C1188R.string.common_google_play_services_update_button;
                break;
            case 3:
                i2 = C1188R.string.common_google_play_services_enable_button;
                break;
            default:
                i2 = 17039370;
                break;
        }
        return resources.getString(i2);
    }

    @Nullable
    private static String zzu(Context context, String str) {
        synchronized (f2875Cc) {
            String str2 = f2875Cc.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String valueOf = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf.length() != 0 ? "Missing resource: ".concat(valueOf) : new String("Missing resource: "));
                return null;
            }
            String string = remoteResource.getString(identifier);
            if (!TextUtils.isEmpty(string)) {
                f2875Cc.put(str, string);
                return string;
            }
            String valueOf2 = String.valueOf(str);
            Log.w("GoogleApiAvailability", valueOf2.length() != 0 ? "Got empty resource: ".concat(valueOf2) : new String("Got empty resource: "));
            return null;
        }
    }
}
