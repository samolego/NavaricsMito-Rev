package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.app.NotificationCompat;
import android.support.p008v4.app.NotificationCompatExtras;
import android.util.Log;
import com.google.android.gms.C1188R;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.common.util.zzs;

/* loaded from: classes.dex */
public final class GooglePlayServicesUtil extends zze {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class zza extends Handler {
        private final Context zzask;

        zza(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.zzask = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzask);
                if (GooglePlayServicesUtil.isUserRecoverableError(isGooglePlayServicesAvailable)) {
                    GooglePlayServicesUtil.zza(isGooglePlayServicesAvailable, this.zzask);
                    return;
                }
                return;
            }
            int i = message.what;
            StringBuilder sb = new StringBuilder(50);
            sb.append("Don't know how to handle this message: ");
            sb.append(i);
            Log.w("GooglePlayServicesUtil", sb.toString());
        }
    }

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2) {
        return getErrorDialog(i, activity, i2, null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        if (zzd(activity, i)) {
            i = 18;
        }
        return GoogleApiAvailability.getInstance().getErrorDialog(activity, i, i2, onCancelListener);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return zze.getErrorPendingIntent(i, context, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return zze.getErrorString(i);
    }

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        return zze.getOpenSourceSoftwareLicenseInfo(context);
    }

    public static Context getRemoteContext(Context context) {
        return zze.getRemoteContext(context);
    }

    public static Resources getRemoteResource(Context context) {
        return zze.getRemoteResource(context);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return zze.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        return zze.isUserRecoverableError(i);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2) {
        return showErrorDialogFragment(i, activity, i2, null);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i, activity, null, i2, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, Fragment fragment, int i2, DialogInterface.OnCancelListener onCancelListener) {
        if (zzd(activity, i)) {
            i = 18;
        }
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (fragment == null) {
            return googleApiAvailability.showErrorDialogFragment(activity, i, i2, onCancelListener);
        }
        Dialog zza2 = googleApiAvailability.zza(activity, i, zzj.zza(fragment, GoogleApiAvailability.getInstance().zza(activity, i, "d"), i2), onCancelListener);
        if (zza2 == null) {
            return false;
        }
        googleApiAvailability.zza(activity, zza2, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int i, Context context) {
        if (zzi.zzcl(context) && i == 2) {
            i = 42;
        }
        if (zzd(context, i) || zze(context, i)) {
            zzbs(context);
        } else {
            zza(i, context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(int i, Context context) {
        zza(i, context, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(int i, Context context, PendingIntent pendingIntent) {
        zza(i, context, null, pendingIntent);
    }

    private static void zza(int i, Context context, String str) {
        zza(i, context, str, GoogleApiAvailability.getInstance().zza(context, i, 0, "n"));
    }

    @TargetApi(20)
    private static void zza(int i, Context context, String str, PendingIntent pendingIntent) {
        Notification build;
        int i2;
        Resources resources = context.getResources();
        String zzh = com.google.android.gms.common.internal.zzi.zzh(context, i);
        String zzj = com.google.android.gms.common.internal.zzi.zzj(context, i);
        if (zzi.zzcl(context)) {
            zzac.zzbr(zzs.zzaxo());
            Notification.Builder autoCancel = new Notification.Builder(context).setSmallIcon(C1188R.C1189drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true);
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
            StringBuilder sb = new StringBuilder(String.valueOf(zzh).length() + 1 + String.valueOf(zzj).length());
            sb.append(zzh);
            sb.append(" ");
            sb.append(zzj);
            build = autoCancel.setStyle(bigTextStyle.bigText(sb.toString())).addAction(C1188R.C1189drawable.common_full_open_on_phone, resources.getString(C1188R.string.common_open_on_phone), pendingIntent).build();
        } else {
            String string = resources.getString(C1188R.string.common_google_play_services_notification_ticker);
            if (zzs.zzaxk()) {
                Notification.Builder autoCancel2 = new Notification.Builder(context).setSmallIcon(17301642).setContentTitle(zzh).setContentText(zzj).setContentIntent(pendingIntent).setTicker(string).setAutoCancel(true);
                if (zzs.zzaxs()) {
                    autoCancel2.setLocalOnly(true);
                }
                if (zzs.zzaxo()) {
                    autoCancel2.setStyle(new Notification.BigTextStyle().bigText(zzj));
                    build = autoCancel2.build();
                } else {
                    build = autoCancel2.getNotification();
                }
                if (Build.VERSION.SDK_INT == 19) {
                    build.extras.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
                }
            } else {
                build = new NotificationCompat.Builder(context).setSmallIcon(17301642).setTicker(string).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentIntent(pendingIntent).setContentTitle(zzh).setContentText(zzj).build();
            }
        }
        if (zzfn(i)) {
            i2 = 10436;
            f3035vd.set(false);
        } else {
            i2 = 39789;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (str != null) {
            notificationManager.notify(str, i2, build);
        } else {
            notificationManager.notify(i2, build);
        }
    }

    private static void zzbs(Context context) {
        zza zzaVar = new zza(context);
        zzaVar.sendMessageDelayed(zzaVar.obtainMessage(1), 120000L);
    }

    @Deprecated
    public static boolean zzd(Context context, int i) {
        return zze.zzd(context, i);
    }

    @Deprecated
    public static boolean zze(Context context, int i) {
        return zze.zze(context, i);
    }

    @Deprecated
    public static Intent zzfm(int i) {
        return zze.zzfm(i);
    }
}
