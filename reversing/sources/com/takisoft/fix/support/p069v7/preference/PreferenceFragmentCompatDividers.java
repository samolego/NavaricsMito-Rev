package com.takisoft.fix.support.p069v7.preference;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p011v7.widget.LinearLayoutManager;
import android.support.p011v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

@Deprecated
/* renamed from: com.takisoft.fix.support.v7.preference.PreferenceFragmentCompatDividers */
/* loaded from: classes2.dex */
public abstract class PreferenceFragmentCompatDividers extends PreferenceFragmentCompat {
    public static final int DIVIDER_CATEGORY_AFTER_LAST = 4;
    public static final int DIVIDER_CATEGORY_BEFORE_FIRST = 2;
    public static final int DIVIDER_CATEGORY_BETWEEN = 1;
    public static final int DIVIDER_DEFAULT = 65539;
    public static final int DIVIDER_NONE = 0;
    public static final int DIVIDER_NO_AFTER_LAST = 131072;
    public static final int DIVIDER_NO_BEFORE_FIRST = 65536;
    public static final int DIVIDER_OFFICIAL = -1;
    public static final int DIVIDER_PADDING_CHILD = 256;
    public static final int DIVIDER_PADDING_PARENT = 512;
    public static final int DIVIDER_PREFERENCE_AFTER_LAST = 64;
    public static final int DIVIDER_PREFERENCE_BEFORE_FIRST = 32;
    public static final int DIVIDER_PREFERENCE_BETWEEN = 16;
    private DividerItemDecoration divItemDecoration;
    private boolean divPrefInvalid = false;
    private int divPrefFlags = -1;

    protected void setDividerPreferences(int i) {
        RecyclerView listView = getListView();
        if (listView == null) {
            Log.w("PreferenceFragmentFix", "Warning: setDividerPreferences(flags) was called before the list was constructed. Please, move the method to onCreateView(...) after the super.onCreateView(...) call!");
            this.divPrefFlags = i;
            this.divPrefInvalid = true;
        } else if (this.divPrefFlags != i || this.divPrefInvalid) {
            applyDividerPreference(listView, i);
        }
    }

    void applyDividerPreference(RecyclerView recyclerView, int i) {
        boolean z = i != this.divPrefFlags || this.divPrefInvalid;
        this.divPrefFlags = i;
        this.divPrefInvalid = false;
        if (i == 0) {
            setDivider(null);
            DividerItemDecoration dividerItemDecoration = this.divItemDecoration;
            if (dividerItemDecoration != null) {
                recyclerView.removeItemDecoration(dividerItemDecoration);
                this.divItemDecoration = null;
            }
        } else if (i == -1) {
            setDivider(getDividerDrawable());
            DividerItemDecoration dividerItemDecoration2 = this.divItemDecoration;
            if (dividerItemDecoration2 != null) {
                recyclerView.removeItemDecoration(dividerItemDecoration2);
                this.divItemDecoration = null;
            }
        } else {
            super.setDivider(null);
            DividerItemDecoration dividerItemDecoration3 = this.divItemDecoration;
            if (dividerItemDecoration3 != null && z) {
                recyclerView.removeItemDecoration(dividerItemDecoration3);
                this.divItemDecoration = null;
            }
            if (this.divItemDecoration == null) {
                this.divItemDecoration = new DividerItemDecoration(getDividerDrawable());
                recyclerView.addItemDecoration(this.divItemDecoration);
            }
        }
        recyclerView.invalidateItemDecorations();
    }

    Drawable getDividerDrawable() {
        TypedArray obtainStyledAttributes = getPreferenceManager().getContext().obtainStyledAttributes(null, C2380R.styleable.PreferenceFragmentCompat, C2380R.attr.preferenceFragmentCompatStyle, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(C2380R.styleable.PreferenceFragmentCompat_android_divider);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    @Override // android.support.p011v7.preference.PreferenceFragmentCompat, android.support.p008v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.divPrefInvalid = true;
        setDividerPreferences(this.divPrefFlags);
    }

    @Override // android.support.p011v7.preference.PreferenceFragmentCompat, android.support.p008v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.divPrefInvalid = true;
    }

    @Override // android.support.p011v7.preference.PreferenceFragmentCompat
    public void setDivider(@Nullable Drawable drawable) {
        super.setDivider(drawable);
        DividerItemDecoration dividerItemDecoration = this.divItemDecoration;
        if (dividerItemDecoration != null) {
            dividerItemDecoration.setDivider(drawable);
        }
    }

    @Override // android.support.p011v7.preference.PreferenceFragmentCompat
    public void setDividerHeight(int i) {
        super.setDividerHeight(i);
        DividerItemDecoration dividerItemDecoration = this.divItemDecoration;
        if (dividerItemDecoration != null) {
            dividerItemDecoration.setDividerHeight(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.takisoft.fix.support.v7.preference.PreferenceFragmentCompatDividers$DividerItemDecoration */
    /* loaded from: classes2.dex */
    public class DividerItemDecoration extends RecyclerView.ItemDecoration {
        private static final byte TYPE_CATEGORY = 0;
        private static final byte TYPE_PREFERENCE = 1;
        private static final byte TYPE_UNKNOWN = -1;
        private Drawable divider;
        private int dividerHeight;

        private DividerItemDecoration(Drawable drawable) {
            this.divider = drawable;
            if (drawable != null) {
                this.dividerHeight = drawable.getIntrinsicHeight();
            }
        }

        @Override // android.support.p011v7.widget.RecyclerView.ItemDecoration
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            int width;
            int i;
            int i2;
            int i3;
            LinearLayoutManager linearLayoutManager;
            if (this.divider != null) {
                LinearLayoutManager linearLayoutManager2 = (LinearLayoutManager) recyclerView.getLayoutManager();
                int findFirstVisibleItemPosition = linearLayoutManager2.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = linearLayoutManager2.findLastVisibleItemPosition();
                int itemCount = linearLayoutManager2.getItemCount() - 1;
                if (findFirstVisibleItemPosition == -1 || findLastVisibleItemPosition == -1) {
                    return;
                }
                if ((PreferenceFragmentCompatDividers.this.divPrefFlags & 512) == 512) {
                    i = recyclerView.getPaddingLeft();
                    width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                } else {
                    width = recyclerView.getWidth();
                    i = 0;
                }
                int i4 = 2;
                byte[] bArr = {TYPE_UNKNOWN, TYPE_UNKNOWN};
                int i5 = findFirstVisibleItemPosition;
                int i6 = 0;
                while (i5 <= findLastVisibleItemPosition) {
                    View findViewByPosition = linearLayoutManager2.findViewByPosition(i5);
                    if (findViewByPosition == null) {
                        return;
                    }
                    if ((PreferenceFragmentCompatDividers.this.divPrefFlags & 256) == 256) {
                        i2 = findViewByPosition.getPaddingLeft() + i;
                        i3 = width - findViewByPosition.getPaddingRight();
                    } else {
                        i2 = i;
                        i3 = width;
                    }
                    if (i5 == findFirstVisibleItemPosition) {
                        bArr[i6] = getViewType(findViewByPosition);
                    }
                    if (i5 < findLastVisibleItemPosition) {
                        bArr[(i6 + 1) % 2] = getViewType(linearLayoutManager2.findViewByPosition(i5 + 1));
                    } else {
                        bArr[(i6 + 1) % i4] = TYPE_UNKNOWN;
                    }
                    int y = (int) findViewByPosition.getY();
                    if (i5 == 0 && hasDividerAbove(bArr[i6])) {
                        linearLayoutManager = linearLayoutManager2;
                        if ((PreferenceFragmentCompatDividers.this.divPrefFlags & 65536) != 65536) {
                            this.divider.setBounds(i2, y, i3, this.dividerHeight + y);
                            this.divider.draw(canvas);
                        }
                    } else {
                        linearLayoutManager = linearLayoutManager2;
                    }
                    byte b = bArr[i6];
                    i6 = (i6 + 1) % 2;
                    if (hasDividerBelow(b, bArr[i6]) && (i5 != itemCount || (PreferenceFragmentCompatDividers.this.divPrefFlags & 131072) != 131072)) {
                        int height = y + findViewByPosition.getHeight() + findViewByPosition.getPaddingBottom() + findViewByPosition.getPaddingTop();
                        this.divider.setBounds(i2, height, i3, this.dividerHeight + height);
                        this.divider.draw(canvas);
                    }
                    i5++;
                    linearLayoutManager2 = linearLayoutManager;
                    i4 = 2;
                }
            }
        }

        @Override // android.support.p011v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            byte viewType = getViewType(view);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int indexOfChild = recyclerView.indexOfChild(view);
            byte viewType2 = indexOfChild < recyclerView.getChildCount() + (-1) ? getViewType(recyclerView.getChildAt(indexOfChild + 1)) : TYPE_UNKNOWN;
            if (recyclerView.getChildAdapterPosition(view) == 0 && hasDividerAbove(viewType) && (PreferenceFragmentCompatDividers.this.divPrefFlags & 65536) != 65536) {
                rect.top = this.dividerHeight;
            }
            if (hasDividerBelow(viewType, viewType2)) {
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1 && (PreferenceFragmentCompatDividers.this.divPrefFlags & 131072) == 131072) {
                    return;
                }
                rect.bottom = this.dividerHeight;
            }
        }

        private boolean hasDividerAbove(byte b) {
            switch (b) {
                case 0:
                    return (PreferenceFragmentCompatDividers.this.divPrefFlags & 2) == 2;
                case 1:
                    return (PreferenceFragmentCompatDividers.this.divPrefFlags & 32) == 32;
                default:
                    return false;
            }
        }

        private boolean hasDividerBelow(byte b, byte b2) {
            switch (b) {
                case 0:
                    switch (b2) {
                        case 0:
                            return (PreferenceFragmentCompatDividers.this.divPrefFlags & 1) == 1;
                        case 1:
                            return (PreferenceFragmentCompatDividers.this.divPrefFlags & 4) == 4 || (PreferenceFragmentCompatDividers.this.divPrefFlags & 32) == 32;
                        default:
                            return (PreferenceFragmentCompatDividers.this.divPrefFlags & 4) == 4;
                    }
                case 1:
                    switch (b2) {
                        case 0:
                            return (PreferenceFragmentCompatDividers.this.divPrefFlags & 64) == 64 || (PreferenceFragmentCompatDividers.this.divPrefFlags & 2) == 2;
                        case 1:
                            return (PreferenceFragmentCompatDividers.this.divPrefFlags & 16) == 16;
                        default:
                            return (PreferenceFragmentCompatDividers.this.divPrefFlags & 64) == 64;
                    }
                default:
                    return false;
            }
        }

        private byte getViewType(View view) {
            return view instanceof ViewGroup ? (byte) 1 : (byte) 0;
        }

        public void setDivider(@Nullable Drawable drawable) {
            if (drawable != null) {
                this.dividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.dividerHeight = 0;
            }
            this.divider = drawable;
            PreferenceFragmentCompatDividers.this.getListView().invalidateItemDecorations();
        }

        public void setDividerHeight(int i) {
            this.dividerHeight = i;
            PreferenceFragmentCompatDividers.this.getListView().invalidateItemDecorations();
        }
    }
}
