package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.support.annotation.RestrictTo;
import android.support.p008v4.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.mType = versionedParcel.m12825b(iconCompat.mType, 1);
        iconCompat.mData = versionedParcel.m12821b(iconCompat.mData, 2);
        iconCompat.mParcelable = versionedParcel.m12824b((VersionedParcel) iconCompat.mParcelable, 3);
        iconCompat.mInt1 = versionedParcel.m12825b(iconCompat.mInt1, 4);
        iconCompat.mInt2 = versionedParcel.m12825b(iconCompat.mInt2, 5);
        iconCompat.mTintList = (ColorStateList) versionedParcel.m12824b((VersionedParcel) iconCompat.mTintList, 6);
        iconCompat.mTintModeStr = versionedParcel.m12822b(iconCompat.mTintModeStr, 7);
        iconCompat.onPostParceling();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.m12827a(true, true);
        iconCompat.onPreParceling(versionedParcel.m12835a());
        versionedParcel.m12834a(iconCompat.mType, 1);
        versionedParcel.m12826a(iconCompat.mData, 2);
        versionedParcel.m12833a(iconCompat.mParcelable, 3);
        versionedParcel.m12834a(iconCompat.mInt1, 4);
        versionedParcel.m12834a(iconCompat.mInt2, 5);
        versionedParcel.m12833a(iconCompat.mTintList, 6);
        versionedParcel.m12829a(iconCompat.mTintModeStr, 7);
    }
}
