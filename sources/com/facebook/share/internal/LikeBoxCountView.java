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
    private TextView f2271a;

    /* renamed from: b */
    private LikeBoxCountViewCaretPosition f2272b;

    /* renamed from: c */
    private float f2273c;

    /* renamed from: d */
    private float f2274d;

    /* renamed from: e */
    private float f2275e;

    /* renamed from: f */
    private Paint f2276f;

    /* renamed from: g */
    private int f2277g;

    /* renamed from: h */
    private int f2278h;

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
        this.f2272b = LikeBoxCountViewCaretPosition.LEFT;
        m10182a(context);
    }

    @Deprecated
    public void setText(String str) {
        this.f2271a.setText(str);
    }

    @Deprecated
    public void setCaretPosition(LikeBoxCountViewCaretPosition likeBoxCountViewCaretPosition) {
        this.f2272b = likeBoxCountViewCaretPosition;
        switch (likeBoxCountViewCaretPosition) {
            case LEFT:
                m10183a(this.f2278h, 0, 0, 0);
                return;
            case TOP:
                m10183a(0, this.f2278h, 0, 0);
                return;
            case RIGHT:
                m10183a(0, 0, this.f2278h, 0);
                return;
            case BOTTOM:
                m10183a(0, 0, 0, this.f2278h);
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
        switch (this.f2272b) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.f2273c);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.f2273c);
                break;
            case RIGHT:
                width = (int) (width - this.f2273c);
                break;
            case BOTTOM:
                height = (int) (height - this.f2273c);
                break;
        }
        m10181a(canvas, paddingLeft, paddingTop, width, height);
    }

    /* renamed from: a */
    private void m10182a(Context context) {
        setWillNotDraw(false);
        this.f2273c = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_caret_height);
        this.f2274d = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_caret_width);
        this.f2275e = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_border_radius);
        this.f2276f = new Paint();
        this.f2276f.setColor(getResources().getColor(R.color.com_facebook_likeboxcountview_border_color));
        this.f2276f.setStrokeWidth(getResources().getDimension(R.dimen.com_facebook_likeboxcountview_border_width));
        this.f2276f.setStyle(Paint.Style.STROKE);
        m10180b(context);
        addView(this.f2271a);
        setCaretPosition(this.f2272b);
    }

    /* renamed from: b */
    private void m10180b(Context context) {
        this.f2271a = new TextView(context);
        this.f2271a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f2271a.setGravity(17);
        this.f2271a.setTextSize(0, getResources().getDimension(R.dimen.com_facebook_likeboxcountview_text_size));
        this.f2271a.setTextColor(getResources().getColor(R.color.com_facebook_likeboxcountview_text_color));
        this.f2277g = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeboxcountview_text_padding);
        this.f2278h = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeboxcountview_caret_height);
    }

    /* renamed from: a */
    private void m10183a(int i, int i2, int i3, int i4) {
        TextView textView = this.f2271a;
        int i5 = this.f2277g;
        textView.setPadding(i + i5, i2 + i5, i3 + i5, i5 + i4);
    }

    /* renamed from: a */
    private void m10181a(Canvas canvas, float f, float f2, float f3, float f4) {
        Path path = new Path();
        float f5 = this.f2275e * 2.0f;
        float f6 = f + f5;
        float f7 = f2 + f5;
        path.addArc(new RectF(f, f2, f6, f7), -180.0f, 90.0f);
        if (this.f2272b == LikeBoxCountViewCaretPosition.TOP) {
            float f8 = f3 - f;
            path.lineTo(((f8 - this.f2274d) / 2.0f) + f, f2);
            path.lineTo((f8 / 2.0f) + f, f2 - this.f2273c);
            path.lineTo(((f8 + this.f2274d) / 2.0f) + f, f2);
        }
        path.lineTo(f3 - this.f2275e, f2);
        float f9 = f3 - f5;
        path.addArc(new RectF(f9, f2, f3, f7), -90.0f, 90.0f);
        if (this.f2272b == LikeBoxCountViewCaretPosition.RIGHT) {
            float f10 = f4 - f2;
            path.lineTo(f3, ((f10 - this.f2274d) / 2.0f) + f2);
            path.lineTo(this.f2273c + f3, (f10 / 2.0f) + f2);
            path.lineTo(f3, ((f10 + this.f2274d) / 2.0f) + f2);
        }
        path.lineTo(f3, f4 - this.f2275e);
        float f11 = f4 - f5;
        path.addArc(new RectF(f9, f11, f3, f4), 0.0f, 90.0f);
        if (this.f2272b == LikeBoxCountViewCaretPosition.BOTTOM) {
            float f12 = f3 - f;
            path.lineTo(((this.f2274d + f12) / 2.0f) + f, f4);
            path.lineTo((f12 / 2.0f) + f, this.f2273c + f4);
            path.lineTo(((f12 - this.f2274d) / 2.0f) + f, f4);
        }
        path.lineTo(this.f2275e + f, f4);
        path.addArc(new RectF(f, f11, f6, f4), 90.0f, 90.0f);
        if (this.f2272b == LikeBoxCountViewCaretPosition.LEFT) {
            float f13 = f4 - f2;
            path.lineTo(f, ((this.f2274d + f13) / 2.0f) + f2);
            path.lineTo(f - this.f2273c, (f13 / 2.0f) + f2);
            path.lineTo(f, ((f13 - this.f2274d) / 2.0f) + f2);
        }
        path.lineTo(f, f2 + this.f2275e);
        canvas.drawPath(path, this.f2276f);
    }
}
