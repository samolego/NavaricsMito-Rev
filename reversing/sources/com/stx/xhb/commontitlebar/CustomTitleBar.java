package com.stx.xhb.commontitlebar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.p008v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.stx.xhb.commontitlebar.p068a.ScreenHelper;
import com.stx.xhb.commontitlebar.p068a.StringHelper;
import com.stx.xhb.commontitlebar.p068a.UIDrawableHelper;
import com.stx.xhb.commontitlebar.p068a.UIResHelper;
import com.stx.xhb.commontitlebar.p068a.UIViewHelper;
import com.stx.xhb.commontitlebar.widget.UIAlphaImageButton;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CustomTitleBar extends RelativeLayout {

    /* renamed from: A */
    private int f7063A;

    /* renamed from: B */
    private int f7064B;

    /* renamed from: C */
    private int f7065C;

    /* renamed from: D */
    private int f7066D;

    /* renamed from: E */
    private Rect f7067E;

    /* renamed from: a */
    private int f7068a;

    /* renamed from: b */
    private int f7069b;

    /* renamed from: c */
    private View f7070c;

    /* renamed from: d */
    private LinearLayout f7071d;

    /* renamed from: e */
    private TextView f7072e;

    /* renamed from: f */
    private TextView f7073f;

    /* renamed from: g */
    private List<View> f7074g;

    /* renamed from: h */
    private List<View> f7075h;

    /* renamed from: i */
    private int f7076i;

    /* renamed from: j */
    private int f7077j;

    /* renamed from: k */
    private int f7078k;

    /* renamed from: l */
    private Drawable f7079l;

    /* renamed from: m */
    private int f7080m;

    /* renamed from: n */
    private int f7081n;

    /* renamed from: o */
    private int f7082o;

    /* renamed from: p */
    private int f7083p;

    /* renamed from: q */
    private int f7084q;

    /* renamed from: r */
    private int f7085r;

    /* renamed from: s */
    private int f7086s;

    /* renamed from: t */
    private int f7087t;

    /* renamed from: u */
    private int f7088u;

    /* renamed from: v */
    private int f7089v;

    /* renamed from: w */
    private int f7090w;

    /* renamed from: x */
    private int f7091x;

    /* renamed from: y */
    private int f7092y;

    /* renamed from: z */
    private ColorStateList f7093z;

    public CustomTitleBar(Context context) {
        this(context, null);
    }

    public CustomTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.CustomTitleBarStyle);
    }

    public CustomTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7082o = -1;
        this.f7064B = -1;
        this.f7065C = -1;
        this.f7066D = -1;
        m5600c();
        m5606a(context, attributeSet, i);
    }

    /* renamed from: c */
    private void m5600c() {
        this.f7068a = -1;
        this.f7069b = -1;
        this.f7074g = new ArrayList();
        this.f7075h = new ArrayList();
    }

    /* renamed from: a */
    private void m5606a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CustomTitleBar, i, 0);
        if (obtainStyledAttributes != null) {
            this.f7076i = obtainStyledAttributes.getColor(R.styleable.CustomTitleBar_titlebar_divider_color, ContextCompat.getColor(context, R.color.divider));
            this.f7078k = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CustomTitleBar_titlebar_divider_height, 1);
            this.f7077j = obtainStyledAttributes.getColor(R.styleable.CustomTitleBar_titlebar_bg_color, -1);
            boolean z = obtainStyledAttributes.getBoolean(R.styleable.CustomTitleBar_titlebar_show_divider, true);
            m5607a(context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
            setBackgroundDividerEnabled(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (ViewParent parent = getParent(); parent != null && (parent instanceof View); parent = parent.getParent()) {
        }
    }

    /* renamed from: a */
    private void m5607a(Context context, TypedArray typedArray) {
        this.f7081n = typedArray.getResourceId(R.styleable.CustomTitleBar_titlebar_left_back_drawable_id, R.id.titlebar_item_left_back);
        this.f7080m = typedArray.getInt(R.styleable.CustomTitleBar_titlebar_title_gravity, 17);
        this.f7083p = typedArray.getDimensionPixelSize(R.styleable.CustomTitleBar_titlebar_title_text_size, ScreenHelper.m5592b(context, 17));
        this.f7084q = typedArray.getDimensionPixelSize(R.styleable.CustomTitleBar_titlebar_title_text_size, ScreenHelper.m5592b(context, 16));
        this.f7085r = typedArray.getDimensionPixelSize(R.styleable.CustomTitleBar_titlebar_subtitle_text_size, ScreenHelper.m5592b(context, 11));
        this.f7086s = typedArray.getColor(R.styleable.CustomTitleBar_titlebar_title_color, UIResHelper.m5587b(context, R.attr.config_color_gray_1));
        this.f7087t = typedArray.getColor(R.styleable.CustomTitleBar_titlebar_subtitle_color, UIResHelper.m5587b(context, R.attr.config_color_gray_4));
        this.f7088u = typedArray.getDimensionPixelSize(R.styleable.CustomTitleBar_titlebar_title_margin_horizontal_when_no_btn_aside, 0);
        this.f7089v = typedArray.getDimensionPixelSize(R.styleable.CustomTitleBar_titlebar_title_container_padding_horizontal, 0);
        this.f7090w = typedArray.getDimensionPixelSize(R.styleable.CustomTitleBar_titlebar_image_btn_width, ScreenHelper.m5594a(context, 48));
        this.f7091x = typedArray.getDimensionPixelSize(R.styleable.CustomTitleBar_titlebar_image_btn_height, ScreenHelper.m5594a(context, 48));
        this.f7092y = typedArray.getDimensionPixelSize(R.styleable.CustomTitleBar_titlebar_text_btn_padding_horizontal, ScreenHelper.m5594a(context, 12));
        this.f7093z = typedArray.getColorStateList(R.styleable.CustomTitleBar_titlebar_text_btn_color_state_list);
        this.f7063A = typedArray.getDimensionPixelSize(R.styleable.CustomTitleBar_titlebar_text_btn_text_size, ScreenHelper.m5592b(context, 16));
    }

    public void setBackgroundDividerEnabled(boolean z) {
        if (z) {
            if (this.f7079l == null) {
                this.f7079l = UIDrawableHelper.m5589a(this.f7076i, this.f7077j, this.f7078k, false);
            }
            UIViewHelper.m5584a(this, this.f7079l);
            return;
        }
        UIViewHelper.m5585a(this, this.f7077j);
    }

    public void setCenterView(View view) {
        View view2 = this.f7070c;
        if (view2 == view) {
            return;
        }
        if (view2 != null) {
            removeView(view2);
        }
        this.f7070c = view;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f7070c.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.addRule(13);
        addView(view, layoutParams);
    }

    /* renamed from: a */
    public TextView m5604a(String str) {
        TextView titleView = getTitleView();
        titleView.setText(str);
        if (StringHelper.m5590a(str)) {
            titleView.setVisibility(8);
        } else {
            titleView.setVisibility(0);
        }
        return titleView;
    }

    public CharSequence getTitle() {
        TextView textView = this.f7072e;
        if (textView == null) {
            return null;
        }
        return textView.getText();
    }

    private TextView getTitleView() {
        if (this.f7072e == null) {
            this.f7072e = new TextView(getContext());
            this.f7072e.setGravity(17);
            this.f7072e.setSingleLine(true);
            this.f7072e.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            this.f7072e.setTextColor(this.f7086s);
            m5599d();
            m5598e().addView(this.f7072e, m5596g());
        }
        return this.f7072e;
    }

    /* renamed from: d */
    private void m5599d() {
        if (this.f7072e != null) {
            TextView textView = this.f7073f;
            if (textView == null || StringHelper.m5590a(textView.getText())) {
                this.f7072e.setTextSize(0, this.f7083p);
            } else {
                this.f7072e.setTextSize(0, this.f7084q);
            }
        }
    }

    public void setSubTitle(String str) {
        TextView subTitleView = getSubTitleView();
        subTitleView.setText(str);
        if (StringHelper.m5590a(str)) {
            subTitleView.setVisibility(8);
        } else {
            subTitleView.setVisibility(0);
        }
        m5599d();
    }

    public void setSubTitle(int i) {
        setSubTitle(getResources().getString(i));
    }

    private TextView getSubTitleView() {
        if (this.f7073f == null) {
            this.f7073f = new TextView(getContext());
            this.f7073f.setGravity(17);
            this.f7073f.setSingleLine(true);
            this.f7073f.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            this.f7073f.setTextSize(0, this.f7085r);
            this.f7073f.setTextColor(this.f7087t);
            LinearLayout.LayoutParams m5596g = m5596g();
            m5596g.topMargin = ScreenHelper.m5594a(getContext(), 1);
            m5598e().addView(this.f7073f, m5596g);
        }
        return this.f7073f;
    }

    public void setTitleGravity(int i) {
        this.f7080m = i;
        TextView textView = this.f7072e;
        if (textView != null) {
            ((LinearLayout.LayoutParams) textView.getLayoutParams()).gravity = i;
            if (i == 17 || i == 1) {
                this.f7072e.setPadding(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingBottom());
            }
        }
        TextView textView2 = this.f7073f;
        if (textView2 != null) {
            ((LinearLayout.LayoutParams) textView2.getLayoutParams()).gravity = i;
        }
        requestLayout();
    }

    public Rect getTitleContainerRect() {
        if (this.f7067E == null) {
            this.f7067E = new Rect();
        }
        LinearLayout linearLayout = this.f7071d;
        if (linearLayout == null) {
            this.f7067E.set(0, 0, 0, 0);
        } else {
            UIViewHelper.m5583a(this, linearLayout, this.f7067E);
        }
        return this.f7067E;
    }

    /* renamed from: e */
    private LinearLayout m5598e() {
        if (this.f7071d == null) {
            this.f7071d = new LinearLayout(getContext());
            this.f7071d.setOrientation(1);
            this.f7071d.setGravity(17);
            LinearLayout linearLayout = this.f7071d;
            int i = this.f7089v;
            linearLayout.setPadding(i, 0, i, 0);
            addView(this.f7071d, m5597f());
        }
        return this.f7071d;
    }

    /* renamed from: f */
    private RelativeLayout.LayoutParams m5597f() {
        return new RelativeLayout.LayoutParams(-1, this.f7082o);
    }

    /* renamed from: g */
    private LinearLayout.LayoutParams m5596g() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = this.f7080m;
        return layoutParams;
    }

    /* renamed from: a */
    public void m5605a(View view, int i, RelativeLayout.LayoutParams layoutParams) {
        int i2 = this.f7068a;
        if (i2 == -1) {
            layoutParams.addRule(9);
        } else {
            layoutParams.addRule(1, i2);
        }
        layoutParams.alignWithParent = true;
        this.f7068a = i;
        view.setId(i);
        this.f7074g.add(view);
        addView(view, layoutParams);
    }

    /* renamed from: b */
    public void m5601b(View view, int i, RelativeLayout.LayoutParams layoutParams) {
        int i2 = this.f7069b;
        if (i2 == -1) {
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(0, i2);
        }
        layoutParams.alignWithParent = true;
        this.f7069b = i;
        view.setId(i);
        this.f7075h.add(view);
        addView(view, layoutParams);
    }

    /* renamed from: a */
    public RelativeLayout.LayoutParams m5610a() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(getTopBarImageBtnWidth(), getTopBarImageBtnHeight());
        layoutParams.topMargin = Math.max(0, (getTopBarHeight() - getTopBarImageBtnHeight()) / 2);
        return layoutParams;
    }

    /* renamed from: a */
    public UIAlphaImageButton m5608a(int i, int i2) {
        UIAlphaImageButton m5609a = m5609a(i);
        m5601b(m5609a, i2, m5610a());
        return m5609a;
    }

    /* renamed from: b */
    public UIAlphaImageButton m5602b(int i, int i2) {
        UIAlphaImageButton m5609a = m5609a(i);
        m5605a(m5609a, i2, m5610a());
        return m5609a;
    }

    /* renamed from: a */
    private UIAlphaImageButton m5609a(int i) {
        UIAlphaImageButton uIAlphaImageButton = new UIAlphaImageButton(getContext());
        uIAlphaImageButton.setBackgroundColor(0);
        uIAlphaImageButton.setImageResource(i);
        return uIAlphaImageButton;
    }

    /* renamed from: b */
    public UIAlphaImageButton m5603b() {
        return m5602b(this.f7081n, R.id.titlebar_item_left_back);
    }

    private int getTopBarHeight() {
        if (this.f7082o == -1) {
            this.f7082o = UIResHelper.m5586c(getContext(), R.attr.titlebar_height);
        }
        return this.f7082o;
    }

    protected int getTopBarImageBtnWidth() {
        if (this.f7064B == -1) {
            this.f7064B = this.f7090w;
        }
        return this.f7064B;
    }

    protected int getTopBarImageBtnHeight() {
        if (this.f7065C == -1) {
            this.f7065C = this.f7091x;
        }
        return this.f7065C;
    }

    private int getTopBarTextBtnPaddingHorizontal() {
        if (this.f7066D == -1) {
            this.f7066D = this.f7092y;
        }
        return this.f7066D;
    }

    public void setBackgroundAlpha(int i) {
        getBackground().setAlpha(i);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size;
        super.onMeasure(i, i2);
        if (this.f7071d != null) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.f7074g.size(); i4++) {
                View view = this.f7074g.get(i4);
                if (view.getVisibility() != 8) {
                    i3 += view.getMeasuredWidth();
                }
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.f7075h.size(); i6++) {
                View view2 = this.f7075h.get(i6);
                if (view2.getVisibility() != 8) {
                    i5 += view2.getMeasuredWidth();
                }
            }
            if ((this.f7080m & 7) == 1) {
                if (i3 == 0 && i5 == 0) {
                    int i7 = this.f7088u;
                    i3 += i7;
                    i5 += i7;
                }
                size = ((View.MeasureSpec.getSize(i) - (Math.max(i3, i5) * 2)) - getPaddingLeft()) - getPaddingRight();
            } else {
                if (i3 == 0) {
                    i3 += this.f7088u;
                }
                if (i5 == 0) {
                    i5 += this.f7088u;
                }
                size = (((View.MeasureSpec.getSize(i) - i3) - i5) - getPaddingLeft()) - getPaddingRight();
            }
            this.f7071d.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        LinearLayout linearLayout = this.f7071d;
        if (linearLayout != null) {
            int measuredWidth = linearLayout.getMeasuredWidth();
            int measuredHeight = this.f7071d.getMeasuredHeight();
            int measuredHeight2 = ((i4 - i2) - this.f7071d.getMeasuredHeight()) / 2;
            int paddingLeft = getPaddingLeft();
            if ((this.f7080m & 7) == 1) {
                i5 = ((i3 - i) - this.f7071d.getMeasuredWidth()) / 2;
            } else {
                i5 = paddingLeft;
                for (int i6 = 0; i6 < this.f7074g.size(); i6++) {
                    View view = this.f7074g.get(i6);
                    if (view.getVisibility() != 8) {
                        i5 += view.getMeasuredWidth();
                    }
                }
                if (this.f7074g.isEmpty()) {
                    i5 += this.f7088u;
                }
            }
            this.f7071d.layout(i5, measuredHeight2, measuredWidth + i5, measuredHeight + measuredHeight2);
        }
    }
}
