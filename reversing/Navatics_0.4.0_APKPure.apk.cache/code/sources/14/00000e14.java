package com.facebook.share.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.common.R;

@Deprecated
/* loaded from: classes.dex */
public class LikeBoxCountView extends FrameLayout {

    /* renamed from: a */
    private TextView f2279a;

    /* renamed from: b */
    private LikeBoxCountViewCaretPosition f2280b;

    /* renamed from: c */
    private float f2281c;

    /* renamed from: d */
    private float f2282d;

    /* renamed from: e */
    private float f2283e;

    /* renamed from: f */
    private Paint f2284f;

    /* renamed from: g */
    private int f2285g;

    /* renamed from: h */
    private int f2286h;

    /* loaded from: classes.dex */
    public enum LikeBoxCountViewCaretPosition {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    @Deprecated
    public LikeBoxCountView(Context context) {
        super(context);
        this.f2280b = LikeBoxCountViewCaretPosition.LEFT;
        m2791a(context);
    }

    @Deprecated
    public void setText(String str) {
        this.f2279a.setText(str);
    }

    @Deprecated
    public void setCaretPosition(LikeBoxCountViewCaretPosition likeBoxCountViewCaretPosition) {
        this.f2280b = likeBoxCountViewCaretPosition;
        switch (likeBoxCountViewCaretPosition) {
            case LEFT:
                m2790a(this.f2286h, 0, 0, 0);
                return;
            case TOP:
                m2790a(0, this.f2286h, 0, 0);
                return;
            case RIGHT:
                m2790a(0, 0, this.f2286h, 0);
                return;
            case BOTTOM:
                m2790a(0, 0, 0, this.f2286h);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        switch (this.f2280b) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.f2281c);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.f2281c);
                break;
            case RIGHT:
                width = (int) (width - this.f2281c);
                break;
            case BOTTOM:
                height = (int) (height - this.f2281c);
                break;
        }
        m2792a(canvas, paddingLeft, paddingTop, width, height);
    }

    /* renamed from: a */
    private void m2791a(Context context) {
        setWillNotDraw(false);
        this.f2281c = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_caret_height);
        this.f2282d = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_caret_width);
        this.f2283e = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_border_radius);
        this.f2284f = new Paint();
        this.f2284f.setColor(getResources().getColor(R.color.com_facebook_likeboxcountview_border_color));
        this.f2284f.setStrokeWidth(getResources().getDimension(R.dimen.com_facebook_likeboxcountview_border_width));
        this.f2284f.setStyle(Paint.Style.STROKE);
        m2793b(context);
        addView(this.f2279a);
        setCaretPosition(this.f2280b);
    }

    /* renamed from: b */
    private void m2793b(Context context) {
        this.f2279a = new TextView(context);
        this.f2279a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f2279a.setGravity(17);
        this.f2279a.setTextSize(0, getResources().getDimension(R.dimen.com_facebook_likeboxcountview_text_size));
        this.f2279a.setTextColor(getResources().getColor(R.color.com_facebook_likeboxcountview_text_color));
        this.f2285g = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeboxcountview_text_padding);
        this.f2286h = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeboxcountview_caret_height);
    }

    /* renamed from: a */
    private void m2790a(int i, int i2, int i3, int i4) {
        TextView textView = this.f2279a;
        int i5 = this.f2285g;
        textView.setPadding(i + i5, i2 + i5, i3 + i5, i5 + i4);
    }

    /* renamed from: a */
    private void m2792a(Canvas canvas, float f, float f2, float f3, float f4) {
        Path path = new Path();
        float f5 = this.f2283e * 2.0f;
        float f6 = f + f5;
        float f7 = f2 + f5;
        path.addArc(new RectF(f, f2, f6, f7), -180.0f, 90.0f);
        if (this.f2280b == LikeBoxCountViewCaretPosition.TOP) {
            float f8 = f3 - f;
            path.lineTo(((f8 - this.f2282d) / 2.0f) + f, f2);
            path.lineTo((f8 / 2.0f) + f, f2 - this.f2281c);
            path.lineTo(((f8 + this.f2282d) / 2.0f) + f, f2);
        }
        path.lineTo(f3 - this.f2283e, f2);
        float f9 = f3 - f5;
        path.addArc(new RectF(f9, f2, f3, f7), -90.0f, 90.0f);
        if (this.f2280b == LikeBoxCountViewCaretPosition.RIGHT) {
            float f10 = f4 - f2;
            path.lineTo(f3, ((f10 - this.f2282d) / 2.0f) + f2);
            path.lineTo(this.f2281c + f3, (f10 / 2.0f) + f2);
            path.lineTo(f3, ((f10 + this.f2282d) / 2.0f) + f2);
        }
        path.lineTo(f3, f4 - this.f2283e);
        float f11 = f4 - f5;
        path.addArc(new RectF(f9, f11, f3, f4), 0.0f, 90.0f);
        if (this.f2280b == LikeBoxCountViewCaretPosition.BOTTOM) {
            float f12 = f3 - f;
            path.lineTo(((this.f2282d + f12) / 2.0f) + f, f4);
            path.lineTo((f12 / 2.0f) + f, this.f2281c + f4);
            path.lineTo(((f12 - this.f2282d) / 2.0f) + f, f4);
        }
        path.lineTo(this.f2283e + f, f4);
        path.addArc(new RectF(f, f11, f6, f4), 90.0f, 90.0f);
        if (this.f2280b == LikeBoxCountViewCaretPosition.LEFT) {
            float f13 = f4 - f2;
            path.lineTo(f, ((this.f2282d + f13) / 2.0f) + f2);
            path.lineTo(f - this.f2281c, (f13 / 2.0f) + f2);
            path.lineTo(f, ((f13 - this.f2282d) / 2.0f) + f2);
        }
        path.lineTo(f, f2 + this.f2283e);
        canvas.drawPath(path, this.f2284f);
    }
}