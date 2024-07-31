package android.support.design.internal;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.p011v7.view.menu.MenuBuilder;
import android.support.p011v7.view.menu.MenuView;
import android.support.p011v7.widget.LinearLayoutManager;
import android.support.p011v7.widget.RecyclerView;
import android.util.AttributeSet;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class NavigationMenuView extends RecyclerView implements MenuView {
    @Override // android.support.p011v7.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.support.p011v7.view.menu.MenuView
    public void initialize(MenuBuilder menuBuilder) {
    }

    public NavigationMenuView(Context context) {
        this(context, null);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutManager(new LinearLayoutManager(context, 1, false));
    }
}
