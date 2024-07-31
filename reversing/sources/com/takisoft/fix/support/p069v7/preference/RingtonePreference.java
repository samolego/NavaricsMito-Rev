package com.takisoft.fix.support.p069v7.preference;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.p008v4.content.res.TypedArrayUtils;
import android.support.p011v7.preference.DialogPreference;
import android.support.p011v7.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.takisoft.fix.support.p069v7.preference.ringtone.C2387R;

/* renamed from: com.takisoft.fix.support.v7.preference.RingtonePreference */
/* loaded from: classes2.dex */
public class RingtonePreference extends DialogPreference {
    private static final int CUSTOM_RINGTONE_REQUEST_CODE = 36864;
    private static final int WRITE_FILES_PERMISSION_REQUEST_CODE = 36865;
    private int miscCustomRingtoneRequestCode;
    private int miscPermissionRequestCode;
    private int ringtoneType;
    private Uri ringtoneUri;
    private boolean showAdd;
    private boolean showDefault;
    private boolean showSilent;
    private CharSequence summary;
    private CharSequence summaryHasRingtone;

    static {
        PreferenceFragmentCompat.registerPreferenceFragment(RingtonePreference.class, RingtonePreferenceDialogFragmentCompat.class);
    }

    public RingtonePreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        android.preference.RingtonePreference ringtonePreference;
        this.miscCustomRingtoneRequestCode = CUSTOM_RINGTONE_REQUEST_CODE;
        this.miscPermissionRequestCode = WRITE_FILES_PERMISSION_REQUEST_CODE;
        if (Build.VERSION.SDK_INT >= 21) {
            ringtonePreference = new android.preference.RingtonePreference(context, attributeSet, i, i2);
        } else {
            ringtonePreference = new android.preference.RingtonePreference(context, attributeSet, i);
        }
        this.ringtoneType = ringtonePreference.getRingtoneType();
        this.showDefault = ringtonePreference.getShowDefault();
        this.showSilent = ringtonePreference.getShowSilent();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2387R.styleable.RingtonePreference, i, 0);
        this.showAdd = obtainStyledAttributes.getBoolean(C2387R.styleable.RingtonePreference_pref_showAdd, true);
        this.summaryHasRingtone = obtainStyledAttributes.getText(C2387R.styleable.RingtonePreference_pref_summaryHasRingtone);
        obtainStyledAttributes.recycle();
        this.summary = super.getSummary();
    }

    public RingtonePreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    @SuppressLint({"RestrictedApi"})
    public RingtonePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, C2387R.attr.dialogPreferenceStyle, 16842897));
    }

    public RingtonePreference(Context context) {
        this(context, null);
    }

    public int getRingtoneType() {
        return this.ringtoneType;
    }

    public void setRingtoneType(int i) {
        this.ringtoneType = i;
    }

    public boolean getShowDefault() {
        return this.showDefault;
    }

    public void setShowDefault(boolean z) {
        this.showDefault = z;
    }

    public boolean getShowSilent() {
        return this.showSilent;
    }

    public void setShowSilent(boolean z) {
        this.showSilent = z;
    }

    public boolean getShowAdd() {
        return this.showAdd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean shouldShowAdd() {
        if (this.showAdd) {
            try {
                for (String str : getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 4096).requestedPermissions) {
                    if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
                        return true;
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void setShowAdd(boolean z) {
        this.showAdd = z;
    }

    public int getCustomRingtoneRequestCode() {
        return this.miscCustomRingtoneRequestCode;
    }

    public void setCustomRingtoneRequestCode(int i) {
        this.miscCustomRingtoneRequestCode = i;
    }

    public int getPermissionRequestCode() {
        return this.miscPermissionRequestCode;
    }

    public void setPermissionRequestCode(int i) {
        this.miscPermissionRequestCode = i;
    }

    public Uri getRingtone() {
        return onRestoreRingtone();
    }

    public void setRingtone(Uri uri) {
        setInternalRingtone(uri, false);
    }

    private void setInternalRingtone(Uri uri, boolean z) {
        Uri onRestoreRingtone = onRestoreRingtone();
        if ((((onRestoreRingtone == null || onRestoreRingtone.equals(uri)) && (uri == null || uri.equals(onRestoreRingtone))) ? false : true) || z) {
            boolean shouldDisableDependents = shouldDisableDependents();
            this.ringtoneUri = uri;
            onSaveRingtone(uri);
            boolean shouldDisableDependents2 = shouldDisableDependents();
            notifyChanged();
            if (shouldDisableDependents2 != shouldDisableDependents) {
                notifyDependencyChange(shouldDisableDependents2);
            }
        }
    }

    protected void onSaveRingtone(Uri uri) {
        persistString(uri != null ? uri.toString() : "");
    }

    protected Uri onRestoreRingtone() {
        Uri uri = this.ringtoneUri;
        String persistedString = getPersistedString(uri == null ? null : uri.toString());
        if (TextUtils.isEmpty(persistedString)) {
            return null;
        }
        return Uri.parse(persistedString);
    }

    @Override // android.support.p011v7.preference.Preference
    protected Object onGetDefaultValue(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // android.support.p011v7.preference.Preference
    protected void onSetInitialValue(@Nullable Object obj) {
        String persistedString = getPersistedString((String) obj);
        setInternalRingtone(!TextUtils.isEmpty(persistedString) ? Uri.parse(persistedString) : null, true);
    }

    @Override // android.support.p011v7.preference.Preference
    public boolean shouldDisableDependents() {
        return super.shouldDisableDependents() || onRestoreRingtone() == null;
    }

    @Override // android.support.p011v7.preference.Preference
    public CharSequence getSummary() {
        if (this.ringtoneUri == null) {
            return this.summary;
        }
        String ringtoneTitle = getRingtoneTitle();
        CharSequence charSequence = this.summaryHasRingtone;
        return (charSequence == null || ringtoneTitle == null) ? ringtoneTitle != null ? ringtoneTitle : this.summary : String.format(charSequence.toString(), ringtoneTitle);
    }

    @Override // android.support.p011v7.preference.Preference
    public void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (charSequence == null && this.summary != null) {
            this.summary = null;
        } else if (charSequence == null || charSequence.equals(this.summary)) {
        } else {
            this.summary = charSequence.toString();
        }
    }

    @Nullable
    public CharSequence getSummaryHasRingtone() {
        return this.summaryHasRingtone;
    }

    public void setSummaryHasRingtone(@StringRes int i) {
        setSummaryHasRingtone(getContext().getString(i));
    }

    public void setSummaryHasRingtone(@Nullable CharSequence charSequence) {
        if (charSequence == null && this.summaryHasRingtone != null) {
            this.summaryHasRingtone = null;
        } else if (charSequence != null && !charSequence.equals(this.summaryHasRingtone)) {
            this.summaryHasRingtone = charSequence.toString();
        }
        notifyChanged();
    }

    public String getRingtoneTitle() {
        Context context = getContext();
        ContentResolver contentResolver = context.getContentResolver();
        String[] strArr = {"title"};
        Uri uri = this.ringtoneUri;
        if (uri != null) {
            int defaultType = RingtoneManager.getDefaultType(uri);
            if (defaultType != 4) {
                if (defaultType != 7) {
                    switch (defaultType) {
                        case 1:
                            break;
                        case 2:
                            return context.getString(C2387R.string.notification_sound_default);
                        default:
                            try {
                                Cursor query = contentResolver.query(this.ringtoneUri, strArr, null, null, null);
                                if (query != null) {
                                    r7 = query.moveToFirst() ? query.getString(0) : null;
                                    query.close();
                                    return r7;
                                }
                                return null;
                            } catch (Exception unused) {
                                return r7;
                            }
                    }
                }
                return context.getString(C2387R.string.ringtone_default);
            }
            return context.getString(C2387R.string.alarm_sound_default);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.preference.Preference
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.ringtoneUri = getRingtone();
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.preference.Preference
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRingtone(savedState.ringtoneUri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.takisoft.fix.support.v7.preference.RingtonePreference$SavedState */
    /* loaded from: classes2.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.takisoft.fix.support.v7.preference.RingtonePreference.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private Uri ringtoneUri;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.ringtoneUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.ringtoneUri, i);
        }
    }
}
