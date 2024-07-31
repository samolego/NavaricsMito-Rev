package android.support.p011v7.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.p008v4.content.SharedPreferencesCompat;
import java.lang.reflect.Field;

/* renamed from: android.support.v7.preference.PreferenceManagerFix */
/* loaded from: classes.dex */
public class PreferenceManagerFix extends PreferenceManager {
    private static Field editorField;
    private boolean inflateInProgress;
    private boolean noCommit;

    public static int getDefaultSharedPreferencesMode() {
        return 0;
    }

    static {
        Field[] declaredFields;
        for (Field field : PreferenceManager.class.getDeclaredFields()) {
            if (field.getType() == SharedPreferences.Editor.class) {
                editorField = field;
                editorField.setAccessible(true);
                return;
            }
        }
    }

    public PreferenceManagerFix(Context context) {
        super(context);
    }

    @Override // android.support.p011v7.preference.PreferenceManager
    public PreferenceScreen inflateFromResource(Context context, int i, PreferenceScreen preferenceScreen) {
        PreferenceScreen preferenceScreen2;
        try {
            this.inflateInProgress = true;
            setNoCommitFix(true);
            PreferenceInflater preferenceInflater = new PreferenceInflater(context, this);
            String[] defaultPackages = preferenceInflater.getDefaultPackages();
            String[] strArr = new String[defaultPackages.length + 1];
            strArr[0] = "com.takisoft.fix.support.v7.preference.";
            System.arraycopy(defaultPackages, 0, strArr, 1, defaultPackages.length);
            preferenceInflater.setDefaultPackages(strArr);
            preferenceScreen2 = (PreferenceScreen) preferenceInflater.inflate(i, preferenceScreen);
        } catch (Throwable th) {
            th = th;
        }
        try {
            preferenceScreen2.onAttachedToHierarchy(this);
            setNoCommitFix(false);
            this.inflateInProgress = false;
            return preferenceScreen2;
        } catch (Throwable th2) {
            th = th2;
            preferenceScreen = preferenceScreen2;
            try {
                th.printStackTrace();
                this.inflateInProgress = false;
                return super.inflateFromResource(context, i, preferenceScreen);
            } finally {
                this.inflateInProgress = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.p011v7.preference.PreferenceManager
    public SharedPreferences.Editor getEditor() {
        Field field;
        if (!this.inflateInProgress || (field = editorField) == null) {
            return super.getEditor();
        }
        if (this.noCommit) {
            try {
                SharedPreferences.Editor editor = (SharedPreferences.Editor) field.get(this);
                if (editor == null) {
                    try {
                        SharedPreferences.Editor edit = getSharedPreferences().edit();
                        editorField.set(this, edit);
                        return edit;
                    } catch (IllegalAccessException unused) {
                        return editor;
                    }
                }
                return editor;
            } catch (IllegalAccessException unused2) {
                return null;
            }
        }
        return getSharedPreferences().edit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.p011v7.preference.PreferenceManager
    public boolean shouldCommit() {
        if (!this.inflateInProgress) {
            return super.shouldCommit();
        }
        return this.noCommit;
    }

    private void setNoCommitFix(boolean z) throws IllegalAccessException {
        SharedPreferences.Editor editor = (SharedPreferences.Editor) editorField.get(this);
        if (!z && editor != null) {
            SharedPreferencesCompat.EditorCompat.getInstance().apply(editor);
        }
        this.noCommit = z;
    }

    public static String getDefaultSharedPreferencesName(Context context) {
        return context.getPackageName() + "_preferences";
    }

    public static void setDefaultValues(Context context, int i, boolean z) {
        setDefaultValues(context, getDefaultSharedPreferencesName(context), getDefaultSharedPreferencesMode(), i, z);
    }

    public static void setDefaultValues(Context context, String str, int i, int i2, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PreferenceManager.KEY_HAS_SET_DEFAULT_VALUES, 0);
        if (z || !sharedPreferences.getBoolean(PreferenceManager.KEY_HAS_SET_DEFAULT_VALUES, false)) {
            PreferenceManagerFix preferenceManagerFix = new PreferenceManagerFix(context);
            preferenceManagerFix.setSharedPreferencesName(str);
            preferenceManagerFix.setSharedPreferencesMode(i);
            preferenceManagerFix.inflateFromResource(context, i2, null);
            sharedPreferences.edit().putBoolean(PreferenceManager.KEY_HAS_SET_DEFAULT_VALUES, true).apply();
        }
    }
}
