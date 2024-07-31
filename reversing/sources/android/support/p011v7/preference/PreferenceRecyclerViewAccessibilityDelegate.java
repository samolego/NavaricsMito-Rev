package android.support.p011v7.preference;

import android.os.Bundle;
import android.support.annotation.RestrictTo;
import android.support.p008v4.view.AccessibilityDelegateCompat;
import android.support.p008v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p011v7.widget.RecyclerView;
import android.support.p011v7.widget.RecyclerViewAccessibilityDelegate;
import android.view.View;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: android.support.v7.preference.PreferenceRecyclerViewAccessibilityDelegate */
/* loaded from: classes.dex */
public class PreferenceRecyclerViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {
    final AccessibilityDelegateCompat mDefaultItemDelegate;
    final AccessibilityDelegateCompat mItemDelegate;
    final RecyclerView mRecyclerView;

    public PreferenceRecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        super(recyclerView);
        this.mDefaultItemDelegate = super.getItemDelegate();
        this.mItemDelegate = new AccessibilityDelegateCompat() { // from class: android.support.v7.preference.PreferenceRecyclerViewAccessibilityDelegate.1
            @Override // android.support.p008v4.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                Preference item;
                PreferenceRecyclerViewAccessibilityDelegate.this.mDefaultItemDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                int childAdapterPosition = PreferenceRecyclerViewAccessibilityDelegate.this.mRecyclerView.getChildAdapterPosition(view);
                RecyclerView.Adapter adapter = PreferenceRecyclerViewAccessibilityDelegate.this.mRecyclerView.getAdapter();
                if ((adapter instanceof PreferenceGroupAdapter) && (item = ((PreferenceGroupAdapter) adapter).getItem(childAdapterPosition)) != null) {
                    item.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
                }
            }

            @Override // android.support.p008v4.view.AccessibilityDelegateCompat
            public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                return PreferenceRecyclerViewAccessibilityDelegate.this.mDefaultItemDelegate.performAccessibilityAction(view, i, bundle);
            }
        };
        this.mRecyclerView = recyclerView;
    }

    @Override // android.support.p011v7.widget.RecyclerViewAccessibilityDelegate
    public AccessibilityDelegateCompat getItemDelegate() {
        return this.mItemDelegate;
    }
}
