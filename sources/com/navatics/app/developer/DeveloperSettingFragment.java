package com.navatics.app.developer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p011v7.preference.Preference;
import android.widget.Toast;
import com.navatics.app.R;
import com.navatics.app.activities.test.UnbindActivity;
import com.navatics.app.framework.NvRobot;
import com.navatics.app.framework.RobotVersionInfo;
import com.navatics.robot.transport.p063b.AndroidMainThreadExecutor;
import com.navatics.robot.transport.p063b.NvExceptionHandler;
import com.navatics.robot.transport.p063b.NvObserver;
import com.takisoft.fix.support.p069v7.preference.PreferenceFragmentCompat;

/* loaded from: classes.dex */
public class DeveloperSettingFragment extends PreferenceFragmentCompat {
    public static /* synthetic */ void lambda$Arx8RNQ73Fv2GLE_ENsiwEx8HNM(DeveloperSettingFragment developerSettingFragment, Throwable th) {
        developerSettingFragment.m8804a(th);
    }

    public static /* synthetic */ void lambda$XywyPyK22VZwSJNXS6EdjCuZqtM(DeveloperSettingFragment developerSettingFragment, RobotVersionInfo robotVersionInfo) {
        developerSettingFragment.m8805a(robotVersionInfo);
    }

    @Override // com.takisoft.fix.support.p069v7.preference.PreferenceFragmentCompat
    public void onCreatePreferencesFix(@Nullable Bundle bundle, String str) {
        getPreferenceManager().setSharedPreferencesName("developer_setting");
        setPreferencesFromResource(R.xml.developer_setting, str);
        Preference findPreference = findPreference("simulateSenseThinkApiCategory");
        Preference findPreference2 = findPreference("enableSimulateSenseThinkApi");
        Preference findPreference3 = findPreference("enableAutoConn");
        findPreference.setDependency("enableSimulateSenseThinkApi");
        findPreference2.setDependency("enableAuth");
        findPreference3.setDependency("enableAuth");
    }

    @Override // com.takisoft.fix.support.p069v7.preference.PreferenceFragmentCompat, android.support.p011v7.preference.PreferenceFragmentCompat, android.support.p011v7.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference preference) {
        NvRobot m7714a;
        if ("enableSimulateSenseThinkApi".equals(preference.getKey())) {
            boolean z = preference.getSharedPreferences().getBoolean("enableSimulateSenseThinkApi", getResources().getBoolean(R.bool.enable_simulate_sensethink_api));
            Preference findPreference = findPreference("simulateSenseThinkApiCategory");
            if (findPreference != null) {
                findPreference.setEnabled(z);
            }
        } else if ("unbindFunction".equals(preference.getKey())) {
            startActivity(new Intent(getContext(), UnbindActivity.class));
        } else if ("getRobotVersion".equals(preference.getKey()) && (m7714a = NvRobot.m7714a()) != null) {
            m7714a.m7678p().mo6311a(AndroidMainThreadExecutor.m6303b()).mo6312a(new NvObserver() { // from class: com.navatics.app.developer.-$$Lambda$DeveloperSettingFragment$XywyPyK22VZwSJNXS6EdjCuZqtM
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    DeveloperSettingFragment.lambda$XywyPyK22VZwSJNXS6EdjCuZqtM(DeveloperSettingFragment.this, (RobotVersionInfo) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.developer.-$$Lambda$DeveloperSettingFragment$Arx8RNQ73Fv2GLE_ENsiwEx8HNM
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    DeveloperSettingFragment.lambda$Arx8RNQ73Fv2GLE_ENsiwEx8HNM(DeveloperSettingFragment.this, th);
                }
            });
        }
        return super.onPreferenceTreeClick(preference);
    }

    /* renamed from: a */
    public /* synthetic */ void m8805a(RobotVersionInfo robotVersionInfo) throws Exception {
        Context context = getContext();
        Toast.makeText(context, "Version : " + robotVersionInfo, 1).show();
    }

    /* renamed from: a */
    public /* synthetic */ void m8804a(Throwable th) {
        Toast.makeText(getContext(), "Timeout", 1).show();
    }
}
