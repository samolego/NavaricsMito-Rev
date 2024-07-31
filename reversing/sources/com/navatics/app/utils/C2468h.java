package com.navatics.app.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.navatics.app.R;
import com.navatics.app.activities.BindRobotActivity;
import com.navatics.app.activities.HomepageActivity;
import com.navatics.app.activities.UserInfoActivity;
import com.navatics.app.settings.Settings;

/* renamed from: com.navatics.app.utils.h */
/* loaded from: classes.dex */
public class IntentUtils {
    /* renamed from: a */
    public static void m7388a(Activity activity) {
        activity.startActivity(new Intent(activity, UserInfoActivity.class));
        activity.overridePendingTransition(R.anim.slide_enter_from_left, R.anim.slide_exit_to_right);
    }

    /* renamed from: a */
    public static void m7386a(Context context) {
        context.startActivity(new Intent(context, HomepageActivity.class));
    }

    /* renamed from: a */
    public static void m7387a(Activity activity, int i) {
        Intent intent = new Intent(activity, Settings.class);
        intent.putExtra("TYPE", i);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_enter_from_right, R.anim.slide_exit_to_left);
    }

    /* renamed from: b */
    public static void m7385b(Activity activity) {
        activity.startActivity(new Intent(activity, Settings.class));
        activity.overridePendingTransition(R.anim.slide_enter_from_right, R.anim.slide_exit_to_left);
    }

    /* renamed from: b */
    public static void m7384b(Context context) {
        context.startActivity(new Intent(context, BindRobotActivity.class));
    }
}
