package com.facebook.share.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.content.LocalBroadcastManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.FacebookException;
import com.facebook.common.R;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.internal.LikeActionController;
import com.facebook.share.internal.LikeBoxCountView;
import com.facebook.share.internal.LikeButton;

@Deprecated
/* loaded from: classes.dex */
public class LikeView extends FrameLayout {

    /* renamed from: a */
    private String f2510a;

    /* renamed from: b */
    private ObjectType f2511b;

    /* renamed from: c */
    private LinearLayout f2512c;

    /* renamed from: d */
    private LikeButton f2513d;

    /* renamed from: e */
    private LikeBoxCountView f2514e;

    /* renamed from: f */
    private TextView f2515f;

    /* renamed from: g */
    private LikeActionController f2516g;

    /* renamed from: h */
    private InterfaceC1131c f2517h;

    /* renamed from: i */
    private BroadcastReceiver f2518i;

    /* renamed from: j */
    private C1129a f2519j;

    /* renamed from: k */
    private Style f2520k;

    /* renamed from: l */
    private HorizontalAlignment f2521l;

    /* renamed from: m */
    private AuxiliaryViewPosition f2522m;

    /* renamed from: n */
    private int f2523n;

    /* renamed from: o */
    private int f2524o;

    /* renamed from: p */
    private int f2525p;

    /* renamed from: q */
    private FragmentWrapper f2526q;

    /* renamed from: r */
    private boolean f2527r;

    /* renamed from: com.facebook.share.widget.LikeView$c */
    /* loaded from: classes.dex */
    public interface InterfaceC1131c {
        /* renamed from: a */
        void m9718a(FacebookException facebookException);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public enum ObjectType {
        UNKNOWN("unknown", 0),
        OPEN_GRAPH("open_graph", 1),
        PAGE("page", 2);
        
        private int intValue;
        private String stringValue;
        public static ObjectType DEFAULT = UNKNOWN;

        public static ObjectType fromInt(int i) {
            ObjectType[] values;
            for (ObjectType objectType : values()) {
                if (objectType.getValue() == i) {
                    return objectType;
                }
            }
            return null;
        }

        ObjectType(String str, int i) {
            this.stringValue = str;
            this.intValue = i;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.stringValue;
        }

        public int getValue() {
            return this.intValue;
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public enum Style {
        STANDARD("standard", 0),
        BUTTON("button", 1),
        BOX_COUNT("box_count", 2);
        
        private int intValue;
        private String stringValue;
        static Style DEFAULT = STANDARD;

        static Style fromInt(int i) {
            Style[] values;
            for (Style style : values()) {
                if (style.m9721a() == i) {
                    return style;
                }
            }
            return null;
        }

        Style(String str, int i) {
            this.stringValue = str;
            this.intValue = i;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.stringValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public int m9721a() {
            return this.intValue;
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public enum HorizontalAlignment {
        CENTER("center", 0),
        LEFT("left", 1),
        RIGHT("right", 2);
        
        static HorizontalAlignment DEFAULT = CENTER;
        private int intValue;
        private String stringValue;

        static HorizontalAlignment fromInt(int i) {
            HorizontalAlignment[] values;
            for (HorizontalAlignment horizontalAlignment : values()) {
                if (horizontalAlignment.m9722a() == i) {
                    return horizontalAlignment;
                }
            }
            return null;
        }

        HorizontalAlignment(String str, int i) {
            this.stringValue = str;
            this.intValue = i;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.stringValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public int m9722a() {
            return this.intValue;
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public enum AuxiliaryViewPosition {
        BOTTOM("bottom", 0),
        INLINE("inline", 1),
        TOP("top", 2);
        
        static AuxiliaryViewPosition DEFAULT = BOTTOM;
        private int intValue;
        private String stringValue;

        static AuxiliaryViewPosition fromInt(int i) {
            AuxiliaryViewPosition[] values;
            for (AuxiliaryViewPosition auxiliaryViewPosition : values()) {
                if (auxiliaryViewPosition.m9723a() == i) {
                    return auxiliaryViewPosition;
                }
            }
            return null;
        }

        AuxiliaryViewPosition(String str, int i) {
            this.stringValue = str;
            this.intValue = i;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.stringValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public int m9723a() {
            return this.intValue;
        }
    }

    @Deprecated
    public LikeView(Context context) {
        super(context);
        this.f2520k = Style.DEFAULT;
        this.f2521l = HorizontalAlignment.DEFAULT;
        this.f2522m = AuxiliaryViewPosition.DEFAULT;
        this.f2523n = -1;
        this.f2527r = true;
        m9743a(context);
    }

    @Deprecated
    public LikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2520k = Style.DEFAULT;
        this.f2521l = HorizontalAlignment.DEFAULT;
        this.f2522m = AuxiliaryViewPosition.DEFAULT;
        this.f2523n = -1;
        this.f2527r = true;
        m9742a(attributeSet);
        m9743a(context);
    }

    @Deprecated
    /* renamed from: a */
    public void m9736a(String str, ObjectType objectType) {
        String m10527a = Utility.m10527a(str, (String) null);
        if (objectType == null) {
            objectType = ObjectType.DEFAULT;
        }
        if (Utility.m10533a(m10527a, this.f2510a) && objectType == this.f2511b) {
            return;
        }
        m9732b(m10527a, objectType);
        m9731c();
    }

    @Deprecated
    public void setLikeViewStyle(Style style) {
        if (style == null) {
            style = Style.DEFAULT;
        }
        if (this.f2520k != style) {
            this.f2520k = style;
            m9728d();
        }
    }

    @Deprecated
    public void setAuxiliaryViewPosition(AuxiliaryViewPosition auxiliaryViewPosition) {
        if (auxiliaryViewPosition == null) {
            auxiliaryViewPosition = AuxiliaryViewPosition.DEFAULT;
        }
        if (this.f2522m != auxiliaryViewPosition) {
            this.f2522m = auxiliaryViewPosition;
            m9728d();
        }
    }

    @Deprecated
    public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
        if (horizontalAlignment == null) {
            horizontalAlignment = HorizontalAlignment.DEFAULT;
        }
        if (this.f2521l != horizontalAlignment) {
            this.f2521l = horizontalAlignment;
            m9728d();
        }
    }

    @Deprecated
    public void setForegroundColor(int i) {
        if (this.f2523n != i) {
            this.f2515f.setTextColor(i);
        }
    }

    @Deprecated
    public void setOnErrorListener(InterfaceC1131c interfaceC1131c) {
        this.f2517h = interfaceC1131c;
    }

    @Deprecated
    public InterfaceC1131c getOnErrorListener() {
        return this.f2517h;
    }

    @Deprecated
    public void setFragment(Fragment fragment) {
        this.f2526q = new FragmentWrapper(fragment);
    }

    @Deprecated
    public void setFragment(android.app.Fragment fragment) {
        this.f2526q = new FragmentWrapper(fragment);
    }

    @Override // android.view.View
    @Deprecated
    public void setEnabled(boolean z) {
        this.f2527r = true;
        m9731c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        m9736a((String) null, ObjectType.UNKNOWN);
        super.onDetachedFromWindow();
    }

    /* renamed from: a */
    private void m9742a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        if (attributeSet == null || getContext() == null || (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.com_facebook_like_view)) == null) {
            return;
        }
        this.f2510a = Utility.m10527a(obtainStyledAttributes.getString(R.styleable.com_facebook_like_view_com_facebook_object_id), (String) null);
        this.f2511b = ObjectType.fromInt(obtainStyledAttributes.getInt(R.styleable.com_facebook_like_view_com_facebook_object_type, ObjectType.DEFAULT.getValue()));
        this.f2520k = Style.fromInt(obtainStyledAttributes.getInt(R.styleable.com_facebook_like_view_com_facebook_style, Style.DEFAULT.m9721a()));
        if (this.f2520k == null) {
            throw new IllegalArgumentException("Unsupported value for LikeView 'style'");
        }
        this.f2522m = AuxiliaryViewPosition.fromInt(obtainStyledAttributes.getInt(R.styleable.com_facebook_like_view_com_facebook_auxiliary_view_position, AuxiliaryViewPosition.DEFAULT.m9723a()));
        if (this.f2522m == null) {
            throw new IllegalArgumentException("Unsupported value for LikeView 'auxiliary_view_position'");
        }
        this.f2521l = HorizontalAlignment.fromInt(obtainStyledAttributes.getInt(R.styleable.com_facebook_like_view_com_facebook_horizontal_alignment, HorizontalAlignment.DEFAULT.m9722a()));
        if (this.f2521l == null) {
            throw new IllegalArgumentException("Unsupported value for LikeView 'horizontal_alignment'");
        }
        this.f2523n = obtainStyledAttributes.getColor(R.styleable.com_facebook_like_view_com_facebook_foreground_color, -1);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m9743a(Context context) {
        this.f2524o = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeview_edge_padding);
        this.f2525p = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeview_internal_padding);
        if (this.f2523n == -1) {
            this.f2523n = getResources().getColor(R.color.com_facebook_likeview_text_color);
        }
        setBackgroundColor(0);
        this.f2512c = new LinearLayout(context);
        this.f2512c.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        m9734b(context);
        m9730c(context);
        m9727d(context);
        this.f2512c.addView(this.f2513d);
        this.f2512c.addView(this.f2515f);
        this.f2512c.addView(this.f2514e);
        addView(this.f2512c);
        m9732b(this.f2510a, this.f2511b);
        m9731c();
    }

    /* renamed from: b */
    private void m9734b(Context context) {
        LikeActionController likeActionController = this.f2516g;
        this.f2513d = new LikeButton(context, likeActionController != null && likeActionController.m10111d());
        this.f2513d.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.share.widget.LikeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LikeView.this.m9744a();
            }
        });
        this.f2513d.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    /* renamed from: c */
    private void m9730c(Context context) {
        this.f2515f = new TextView(context);
        this.f2515f.setTextSize(0, getResources().getDimension(R.dimen.com_facebook_likeview_text_size));
        this.f2515f.setMaxLines(2);
        this.f2515f.setTextColor(this.f2523n);
        this.f2515f.setGravity(17);
        this.f2515f.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    }

    /* renamed from: d */
    private void m9727d(Context context) {
        this.f2514e = new LikeBoxCountView(context);
        this.f2514e.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9744a() {
        if (this.f2516g != null) {
            this.f2516g.m10150a(this.f2526q == null ? getActivity() : null, this.f2526q, getAnalyticsParameters());
        }
    }

    private Activity getActivity() {
        boolean z;
        Context context = getContext();
        while (true) {
            z = context instanceof Activity;
            if (z || !(context instanceof ContextWrapper)) {
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (z) {
            return (Activity) context;
        }
        throw new FacebookException("Unable to get Activity.");
    }

    private Bundle getAnalyticsParameters() {
        Bundle bundle = new Bundle();
        bundle.putString("style", this.f2520k.toString());
        bundle.putString("auxiliary_position", this.f2522m.toString());
        bundle.putString("horizontal_alignment", this.f2521l.toString());
        bundle.putString("object_id", Utility.m10527a(this.f2510a, ""));
        bundle.putString("object_type", this.f2511b.toString());
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m9732b(String str, ObjectType objectType) {
        m9735b();
        this.f2510a = str;
        this.f2511b = objectType;
        if (Utility.m10530a(str)) {
            return;
        }
        this.f2519j = new C1129a();
        if (isInEditMode()) {
            return;
        }
        LikeActionController.m10134a(str, objectType, this.f2519j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9741a(LikeActionController likeActionController) {
        this.f2516g = likeActionController;
        this.f2518i = new C1130b();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.sdk.LikeActionController.UPDATED");
        intentFilter.addAction("com.facebook.sdk.LikeActionController.DID_ERROR");
        intentFilter.addAction("com.facebook.sdk.LikeActionController.DID_RESET");
        localBroadcastManager.registerReceiver(this.f2518i, intentFilter);
    }

    /* renamed from: b */
    private void m9735b() {
        if (this.f2518i != null) {
            LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.f2518i);
            this.f2518i = null;
        }
        C1129a c1129a = this.f2519j;
        if (c1129a != null) {
            c1129a.m9720a();
            this.f2519j = null;
        }
        this.f2516g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m9731c() {
        boolean z = !this.f2527r;
        LikeActionController likeActionController = this.f2516g;
        if (likeActionController == null) {
            this.f2513d.setSelected(false);
            this.f2515f.setText((CharSequence) null);
            this.f2514e.setText(null);
        } else {
            this.f2513d.setSelected(likeActionController.m10111d());
            this.f2515f.setText(this.f2516g.m10118c());
            this.f2514e.setText(this.f2516g.m10129b());
            z &= this.f2516g.m10105e();
        }
        super.setEnabled(z);
        this.f2513d.setEnabled(z);
        m9728d();
    }

    /* renamed from: d */
    private void m9728d() {
        LikeActionController likeActionController;
        View view;
        LikeActionController likeActionController2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2512c.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f2513d.getLayoutParams();
        int i = this.f2521l == HorizontalAlignment.LEFT ? 3 : this.f2521l == HorizontalAlignment.CENTER ? 1 : 5;
        layoutParams.gravity = i | 48;
        layoutParams2.gravity = i;
        this.f2515f.setVisibility(8);
        this.f2514e.setVisibility(8);
        if (this.f2520k == Style.STANDARD && (likeActionController2 = this.f2516g) != null && !Utility.m10530a(likeActionController2.m10118c())) {
            view = this.f2515f;
        } else if (this.f2520k != Style.BOX_COUNT || (likeActionController = this.f2516g) == null || Utility.m10530a(likeActionController.m10129b())) {
            return;
        } else {
            m9725e();
            view = this.f2514e;
        }
        view.setVisibility(0);
        ((LinearLayout.LayoutParams) view.getLayoutParams()).gravity = i;
        this.f2512c.setOrientation(this.f2522m != AuxiliaryViewPosition.INLINE ? 1 : 0);
        if (this.f2522m == AuxiliaryViewPosition.TOP || (this.f2522m == AuxiliaryViewPosition.INLINE && this.f2521l == HorizontalAlignment.RIGHT)) {
            this.f2512c.removeView(this.f2513d);
            this.f2512c.addView(this.f2513d);
        } else {
            this.f2512c.removeView(view);
            this.f2512c.addView(view);
        }
        switch (this.f2522m) {
            case TOP:
                int i2 = this.f2524o;
                view.setPadding(i2, i2, i2, this.f2525p);
                return;
            case BOTTOM:
                int i3 = this.f2524o;
                view.setPadding(i3, this.f2525p, i3, i3);
                return;
            case INLINE:
                if (this.f2521l == HorizontalAlignment.RIGHT) {
                    int i4 = this.f2524o;
                    view.setPadding(i4, i4, this.f2525p, i4);
                    return;
                }
                int i5 = this.f2525p;
                int i6 = this.f2524o;
                view.setPadding(i5, i6, i6, i6);
                return;
            default:
                return;
        }
    }

    /* renamed from: e */
    private void m9725e() {
        switch (this.f2522m) {
            case TOP:
                this.f2514e.setCaretPosition(LikeBoxCountView.LikeBoxCountViewCaretPosition.BOTTOM);
                return;
            case BOTTOM:
                this.f2514e.setCaretPosition(LikeBoxCountView.LikeBoxCountViewCaretPosition.TOP);
                return;
            case INLINE:
                this.f2514e.setCaretPosition(this.f2521l == HorizontalAlignment.RIGHT ? LikeBoxCountView.LikeBoxCountViewCaretPosition.RIGHT : LikeBoxCountView.LikeBoxCountViewCaretPosition.LEFT);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.share.widget.LikeView$b */
    /* loaded from: classes.dex */
    public class C1130b extends BroadcastReceiver {
        private C1130b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Bundle extras = intent.getExtras();
            boolean z = true;
            if (extras != null) {
                String string = extras.getString("com.facebook.sdk.LikeActionController.OBJECT_ID");
                if (!Utility.m10530a(string) && !Utility.m10533a(LikeView.this.f2510a, string)) {
                    z = false;
                }
            }
            if (z) {
                if ("com.facebook.sdk.LikeActionController.UPDATED".equals(action)) {
                    LikeView.this.m9731c();
                } else if ("com.facebook.sdk.LikeActionController.DID_ERROR".equals(action)) {
                    if (LikeView.this.f2517h != null) {
                        LikeView.this.f2517h.m9718a(NativeProtocol.m10596a(extras));
                    }
                } else if ("com.facebook.sdk.LikeActionController.DID_RESET".equals(action)) {
                    LikeView likeView = LikeView.this;
                    likeView.m9732b(likeView.f2510a, LikeView.this.f2511b);
                    LikeView.this.m9731c();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.share.widget.LikeView$a */
    /* loaded from: classes.dex */
    public class C1129a implements LikeActionController.InterfaceC1059c {

        /* renamed from: b */
        private boolean f2535b;

        private C1129a() {
        }

        /* renamed from: a */
        public void m9720a() {
            this.f2535b = true;
        }

        @Override // com.facebook.share.internal.LikeActionController.InterfaceC1059c
        /* renamed from: a */
        public void mo9719a(LikeActionController likeActionController, FacebookException facebookException) {
            if (this.f2535b) {
                return;
            }
            if (likeActionController != null) {
                if (!likeActionController.m10105e()) {
                    facebookException = new FacebookException("Cannot use LikeView. The device may not be supported.");
                }
                LikeView.this.m9741a(likeActionController);
                LikeView.this.m9731c();
            }
            if (facebookException != null && LikeView.this.f2517h != null) {
                LikeView.this.f2517h.m9718a(facebookException);
            }
            LikeView.this.f2519j = null;
        }
    }
}
