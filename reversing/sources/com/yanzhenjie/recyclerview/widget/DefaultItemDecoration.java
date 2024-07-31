package com.yanzhenjie.recyclerview.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.p011v7.widget.GridLayoutManager;
import android.support.p011v7.widget.LinearLayoutManager;
import android.support.p011v7.widget.RecyclerView;
import android.support.p011v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/* loaded from: classes2.dex */
public class DefaultItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    static final /* synthetic */ boolean f9266a = !DefaultItemDecoration.class.desiredAssertionStatus();

    /* renamed from: b */
    private final int f9267b;

    /* renamed from: c */
    private final int f9268c;

    /* renamed from: d */
    private final Drawer f9269d;

    public DefaultItemDecoration(@ColorInt int i, int i2, int i3) {
        this.f9267b = Math.round(i2 / 2.0f);
        this.f9268c = Math.round(i3 / 2.0f);
        this.f9269d = new ColorDrawer(i, this.f9267b, this.f9268c);
    }

    @Override // android.support.p011v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            int m3769a = m3769a(layoutManager);
            int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
            int m3765b = m3765b(layoutManager);
            int itemCount = layoutManager.getItemCount();
            if (m3769a == 1) {
                m3766b(rect, childLayoutPosition, m3765b, itemCount);
            } else {
                m3770a(rect, childLayoutPosition, m3765b, itemCount);
            }
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            int i = this.f9267b;
            int i2 = this.f9268c;
            rect.set(i, i2, i, i2);
        }
    }

    /* renamed from: a */
    private void m3770a(Rect rect, int i, int i2, int i3) {
        boolean m3772a = m3772a(0, i, i2, i3);
        boolean m3768b = m3768b(0, i, i2, i3);
        boolean m3764c = m3764c(0, i, i2, i3);
        boolean m3763d = m3763d(0, i, i2, i3);
        if (i2 == 1) {
            if (m3764c && m3763d) {
                rect.set(0, 0, 0, 0);
            } else if (m3764c) {
                rect.set(0, 0, this.f9267b, 0);
            } else if (m3763d) {
                rect.set(this.f9267b, 0, 0, 0);
            } else {
                int i4 = this.f9267b;
                rect.set(i4, 0, i4, 0);
            }
        } else if (m3764c && m3772a) {
            rect.set(0, 0, this.f9267b, this.f9268c);
        } else if (m3764c && m3768b) {
            rect.set(0, this.f9268c, this.f9267b, 0);
        } else if (m3763d && m3772a) {
            rect.set(this.f9267b, 0, 0, this.f9268c);
        } else if (m3763d && m3768b) {
            rect.set(this.f9267b, this.f9268c, 0, 0);
        } else if (m3764c) {
            int i5 = this.f9268c;
            rect.set(0, i5, this.f9267b, i5);
        } else if (m3763d) {
            int i6 = this.f9267b;
            int i7 = this.f9268c;
            rect.set(i6, i7, 0, i7);
        } else if (m3772a) {
            int i8 = this.f9267b;
            rect.set(i8, 0, i8, this.f9268c);
        } else if (m3768b) {
            int i9 = this.f9267b;
            rect.set(i9, this.f9268c, i9, 0);
        } else {
            int i10 = this.f9267b;
            int i11 = this.f9268c;
            rect.set(i10, i11, i10, i11);
        }
    }

    /* renamed from: b */
    private void m3766b(Rect rect, int i, int i2, int i3) {
        boolean m3772a = m3772a(1, i, i2, i3);
        boolean m3768b = m3768b(1, i, i2, i3);
        boolean m3764c = m3764c(1, i, i2, i3);
        boolean m3763d = m3763d(1, i, i2, i3);
        if (i2 == 1) {
            if (m3772a && m3768b) {
                rect.set(0, 0, 0, 0);
            } else if (m3772a) {
                rect.set(0, 0, 0, this.f9268c);
            } else if (m3768b) {
                rect.set(0, this.f9268c, 0, 0);
            } else {
                int i4 = this.f9268c;
                rect.set(0, i4, 0, i4);
            }
        } else if (m3772a && m3764c) {
            rect.set(0, 0, this.f9267b, this.f9268c);
        } else if (m3772a && m3763d) {
            rect.set(this.f9267b, 0, 0, this.f9268c);
        } else if (m3768b && m3764c) {
            rect.set(0, this.f9268c, this.f9267b, 0);
        } else if (m3768b && m3763d) {
            rect.set(this.f9267b, this.f9268c, 0, 0);
        } else if (m3772a) {
            int i5 = this.f9267b;
            rect.set(i5, 0, i5, this.f9268c);
        } else if (m3768b) {
            int i6 = this.f9267b;
            rect.set(i6, this.f9268c, i6, 0);
        } else if (m3764c) {
            int i7 = this.f9268c;
            rect.set(0, i7, this.f9267b, i7);
        } else if (m3763d) {
            int i8 = this.f9267b;
            int i9 = this.f9268c;
            rect.set(i8, i9, 0, i9);
        } else {
            int i10 = this.f9267b;
            int i11 = this.f9268c;
            rect.set(i10, i11, i10, i11);
        }
    }

    /* renamed from: a */
    private int m3769a(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).getOrientation();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getOrientation();
        }
        return 1;
    }

    /* renamed from: b */
    private int m3765b(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        }
        return 1;
    }

    /* renamed from: a */
    private boolean m3772a(int i, int i2, int i3, int i4) {
        return i == 1 ? i2 < i3 : i3 == 1 || i2 % i3 == 0;
    }

    /* renamed from: b */
    private boolean m3768b(int i, int i2, int i3, int i4) {
        if (i != 1) {
            return i3 == 1 || (i2 + 1) % i3 == 0;
        } else if (i3 == 1) {
            return i2 + 1 == i4;
        } else {
            int i5 = i4 % i3;
            int i6 = ((i4 - i5) / i3) + (i5 > 0 ? 1 : 0);
            int i7 = i2 + 1;
            int i8 = i7 % i3;
            return i8 == 0 ? i6 == i7 / i3 : i6 == ((i7 - i8) / i3) + 1;
        }
    }

    /* renamed from: c */
    private boolean m3764c(int i, int i2, int i3, int i4) {
        return i == 1 ? i3 == 1 || i2 % i3 == 0 : i2 < i3;
    }

    /* renamed from: d */
    private boolean m3763d(int i, int i2, int i3, int i4) {
        if (i == 1) {
            return i3 == 1 || (i2 + 1) % i3 == 0;
        } else if (i3 == 1) {
            return i2 + 1 == i4;
        } else {
            int i5 = i4 % i3;
            int i6 = ((i4 - i5) / i3) + (i5 > 0 ? 1 : 0);
            int i7 = i2 + 1;
            int i8 = i7 % i3;
            return i8 == 0 ? i6 == i7 / i3 : i6 == ((i7 - i8) / i3) + 1;
        }
    }

    @Override // android.support.p011v7.widget.RecyclerView.ItemDecoration
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!f9266a && layoutManager == null) {
            throw new AssertionError();
        }
        int m3769a = m3769a(layoutManager);
        int m3765b = m3765b(layoutManager);
        int childCount = layoutManager.getChildCount();
        if (layoutManager instanceof LinearLayoutManager) {
            canvas.save();
            for (int i = 0; i < childCount; i++) {
                View childAt = layoutManager.getChildAt(i);
                if (!f9266a && childAt == null) {
                    throw new AssertionError();
                }
                int childLayoutPosition = recyclerView.getChildLayoutPosition(childAt);
                if (m3769a == 1) {
                    m3767b(canvas, childAt, childLayoutPosition, m3765b, childCount);
                } else {
                    m3771a(canvas, childAt, childLayoutPosition, m3765b, childCount);
                }
            }
            canvas.restore();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            canvas.save();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt2 = layoutManager.getChildAt(i2);
                this.f9269d.m3738a(childAt2, canvas);
                this.f9269d.m3737b(childAt2, canvas);
                this.f9269d.m3736c(childAt2, canvas);
                this.f9269d.m3735d(childAt2, canvas);
            }
            canvas.restore();
        }
    }

    /* renamed from: a */
    private void m3771a(Canvas canvas, View view, int i, int i2, int i3) {
        boolean m3772a = m3772a(0, i, i2, i3);
        boolean m3768b = m3768b(0, i, i2, i3);
        boolean m3764c = m3764c(0, i, i2, i3);
        boolean m3763d = m3763d(0, i, i2, i3);
        if (i2 == 1) {
            if (m3772a && m3763d) {
                return;
            }
            if (m3764c) {
                this.f9269d.m3736c(view, canvas);
            } else if (m3763d) {
                this.f9269d.m3738a(view, canvas);
            } else {
                this.f9269d.m3738a(view, canvas);
                this.f9269d.m3736c(view, canvas);
            }
        } else if (m3764c && m3772a) {
            this.f9269d.m3736c(view, canvas);
            this.f9269d.m3735d(view, canvas);
        } else if (m3764c && m3768b) {
            this.f9269d.m3737b(view, canvas);
            this.f9269d.m3736c(view, canvas);
        } else if (m3763d && m3772a) {
            this.f9269d.m3738a(view, canvas);
            this.f9269d.m3735d(view, canvas);
        } else if (m3763d && m3768b) {
            this.f9269d.m3738a(view, canvas);
            this.f9269d.m3737b(view, canvas);
        } else if (m3764c) {
            this.f9269d.m3737b(view, canvas);
            this.f9269d.m3736c(view, canvas);
            this.f9269d.m3735d(view, canvas);
        } else if (m3763d) {
            this.f9269d.m3738a(view, canvas);
            this.f9269d.m3737b(view, canvas);
            this.f9269d.m3735d(view, canvas);
        } else if (m3772a) {
            this.f9269d.m3738a(view, canvas);
            this.f9269d.m3736c(view, canvas);
            this.f9269d.m3735d(view, canvas);
        } else if (m3768b) {
            this.f9269d.m3738a(view, canvas);
            this.f9269d.m3737b(view, canvas);
            this.f9269d.m3736c(view, canvas);
        } else {
            this.f9269d.m3738a(view, canvas);
            this.f9269d.m3737b(view, canvas);
            this.f9269d.m3736c(view, canvas);
            this.f9269d.m3735d(view, canvas);
        }
    }

    /* renamed from: b */
    private void m3767b(Canvas canvas, View view, int i, int i2, int i3) {
        boolean m3772a = m3772a(1, i, i2, i3);
        boolean m3768b = m3768b(1, i, i2, i3);
        boolean m3764c = m3764c(1, i, i2, i3);
        boolean m3763d = m3763d(1, i, i2, i3);
        if (i2 == 1) {
            if (m3772a && m3768b) {
                return;
            }
            if (m3772a) {
                this.f9269d.m3735d(view, canvas);
            } else if (m3768b) {
                this.f9269d.m3737b(view, canvas);
            } else {
                this.f9269d.m3737b(view, canvas);
                this.f9269d.m3735d(view, canvas);
            }
        } else if (m3772a && m3764c) {
            this.f9269d.m3736c(view, canvas);
            this.f9269d.m3735d(view, canvas);
        } else if (m3772a && m3763d) {
            this.f9269d.m3738a(view, canvas);
            this.f9269d.m3735d(view, canvas);
        } else if (m3768b && m3764c) {
            this.f9269d.m3737b(view, canvas);
            this.f9269d.m3736c(view, canvas);
        } else if (m3768b && m3763d) {
            this.f9269d.m3738a(view, canvas);
            this.f9269d.m3737b(view, canvas);
        } else if (m3772a) {
            this.f9269d.m3738a(view, canvas);
            this.f9269d.m3736c(view, canvas);
            this.f9269d.m3735d(view, canvas);
        } else if (m3768b) {
            this.f9269d.m3738a(view, canvas);
            this.f9269d.m3737b(view, canvas);
            this.f9269d.m3736c(view, canvas);
        } else if (m3764c) {
            this.f9269d.m3737b(view, canvas);
            this.f9269d.m3736c(view, canvas);
            this.f9269d.m3735d(view, canvas);
        } else if (m3763d) {
            this.f9269d.m3738a(view, canvas);
            this.f9269d.m3737b(view, canvas);
            this.f9269d.m3735d(view, canvas);
        } else {
            this.f9269d.m3738a(view, canvas);
            this.f9269d.m3737b(view, canvas);
            this.f9269d.m3736c(view, canvas);
            this.f9269d.m3735d(view, canvas);
        }
    }
}
