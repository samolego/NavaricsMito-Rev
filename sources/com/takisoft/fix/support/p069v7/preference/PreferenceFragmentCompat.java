package com.takisoft.fix.support.p069v7.preference;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.app.DialogFragment;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.app.FragmentManager;
import android.support.p011v7.preference.Preference;
import android.support.p011v7.preference.PreferenceGroup;
import android.support.p011v7.preference.PreferenceManager;
import android.support.p011v7.preference.PreferenceManagerFix;
import android.support.p011v7.preference.PreferenceScreen;
import android.support.p011v7.widget.RecyclerView;
import java.lang.reflect.Field;
import java.util.HashMap;

/* renamed from: com.takisoft.fix.support.v7.preference.PreferenceFragmentCompat */
/* loaded from: classes2.dex */
public abstract class PreferenceFragmentCompat extends android.support.p011v7.preference.PreferenceFragmentCompat {
    private static final String FRAGMENT_DIALOG_TAG = "android.support.v7.preference.PreferenceFragment.DIALOG";
    protected static HashMap<Class<? extends Preference>, Class<? extends Fragment>> dialogPreferences;
    private static Field preferenceManagerField;

    @Override // android.support.p011v7.preference.PreferenceFragmentCompat
    @Deprecated
    public void onCreatePreferences(@Nullable Bundle bundle, @Nullable String str) {
    }

    public abstract void onCreatePreferencesFix(@Nullable Bundle bundle, String str);

    static {
        Field[] declaredFields = android.support.p011v7.preference.PreferenceFragmentCompat.class.getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Field field = declaredFields[i];
            if (field.getType() == PreferenceManager.class) {
                preferenceManagerField = field;
                preferenceManagerField.setAccessible(true);
                break;
            }
            i++;
        }
        dialogPreferences = new HashMap<>();
    }

    @Override // android.support.p011v7.preference.PreferenceFragmentCompat, android.support.p008v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        PreferenceManagerFix preferenceManagerFix = new PreferenceManagerFix(getPreferenceManager().getContext());
        preferenceManagerFix.setOnNavigateToScreenListener(this);
        try {
            preferenceManagerField.set(this, preferenceManagerFix);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        onCreatePreferencesFix(bundle, getArguments() != null ? getArguments().getString("android.support.v7.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null);
    }

    @Override // android.support.p011v7.preference.PreferenceFragmentCompat
    protected RecyclerView.Adapter onCreateAdapter(PreferenceScreen preferenceScreen) {
        return new PreferenceGroupAdapter(preferenceScreen);
    }

    @Override // android.support.p011v7.preference.PreferenceFragmentCompat, android.support.p011v7.preference.PreferenceManager.OnDisplayPreferenceDialogListener
    public void onDisplayPreferenceDialog(Preference preference) {
        if (getFragmentManager().findFragmentByTag(FRAGMENT_DIALOG_TAG) == null) {
            if (preference instanceof EditTextPreference) {
                displayPreferenceDialog(new EditTextPreferenceDialogFragmentCompat(), preference.getKey());
            } else if (dialogPreferences.containsKey(preference.getClass())) {
                try {
                    displayPreferenceDialog(dialogPreferences.get(preference.getClass()).newInstance(), preference.getKey());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e2) {
                    e2.printStackTrace();
                }
            } else {
                super.onDisplayPreferenceDialog(preference);
            }
        }
    }

    protected void displayPreferenceDialog(@NonNull Fragment fragment, @NonNull String str) {
        displayPreferenceDialog(fragment, str, null);
    }

    protected void displayPreferenceDialog(@NonNull Fragment fragment, @NonNull String str, @Nullable Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        if (bundle == null) {
            bundle = new Bundle(1);
        }
        bundle.putString("key", str);
        fragment.setArguments(bundle);
        fragment.setTargetFragment(this, 0);
        if (fragment instanceof DialogFragment) {
            ((DialogFragment) fragment).show(fragmentManager, FRAGMENT_DIALOG_TAG);
        } else {
            fragmentManager.beginTransaction().add(fragment, FRAGMENT_DIALOG_TAG).commit();
        }
    }

    @Override // android.support.p011v7.preference.PreferenceFragmentCompat, android.support.p011v7.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference preference) {
        boolean onPreferenceTreeClick = super.onPreferenceTreeClick(preference);
        if (!onPreferenceTreeClick && (preference instanceof PreferenceActivityResultListener)) {
            ((PreferenceActivityResultListener) preference).onPreferenceClick(this, preference);
        }
        return onPreferenceTreeClick;
    }

    @Override // android.support.p008v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        onActivityResult(getPreferenceScreen(), i, i2, intent);
        super.onActivityResult(i, i2, intent);
    }

    protected void onActivityResult(PreferenceGroup preferenceGroup, int i, int i2, Intent intent) {
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i3 = 0; i3 < preferenceCount; i3++) {
            Preference preference = preferenceGroup.getPreference(i3);
            if (preference instanceof PreferenceActivityResultListener) {
                ((PreferenceActivityResultListener) preference).onActivityResult(i, i2, intent);
            }
            if (preference instanceof PreferenceGroup) {
                onActivityResult((PreferenceGroup) preference, i, i2, intent);
            }
        }
    }

    public static void registerPreferenceFragment(Class<? extends Preference> cls, Class<? extends Fragment> cls2) {
        dialogPreferences.put(cls, cls2);
    }
}
