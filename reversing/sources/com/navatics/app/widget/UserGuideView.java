package com.navatics.app.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.navatics.app.R;
import com.navatics.app.utils.MeasureUtil;
import com.navatics.robot.utils.DpiUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class UserGuideView extends View {

    /* renamed from: a */
    public int f5512a;

    /* renamed from: b */
    private Bitmap f5513b;

    /* renamed from: c */
    private Canvas f5514c;

    /* renamed from: d */
    private Paint f5515d;

    /* renamed from: e */
    private Paint f5516e;

    /* renamed from: f */
    private int f5517f;

    /* renamed from: g */
    private int f5518g;

    /* renamed from: h */
    private boolean f5519h;

    /* renamed from: i */
    private float f5520i;

    /* renamed from: j */
    private float f5521j;

    /* renamed from: k */
    private int f5522k;

    /* renamed from: l */
    private int f5523l;

    /* renamed from: m */
    private float f5524m;

    /* renamed from: n */
    private int f5525n;

    /* renamed from: o */
    private InterfaceC1955a f5526o;

    /* renamed from: p */
    private int f5527p;

    /* renamed from: q */
    private ArrayList<LinkedHashMap<View, Bitmap>> f5528q;

    /* renamed from: r */
    private LinkedHashMap<View, Bitmap> f5529r;

    /* renamed from: s */
    private Rect f5530s;

    /* renamed from: t */
    private int f5531t;

    /* renamed from: u */
    private int f5532u;

    /* renamed from: v */
    private Direction f5533v;

    /* renamed from: w */
    private LinkedHashMap<View, Integer> f5534w;

    /* renamed from: x */
    private LinkedHashMap<View, Integer> f5535x;

    /* renamed from: y */
    private LinkedHashMap<View, Direction> f5536y;

    /* renamed from: z */
    private LinkedHashMap<Bitmap, Rect> f5537z;

    /* loaded from: classes.dex */
    public enum Direction {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        DEFAULT
    }

    /* renamed from: com.navatics.app.widget.UserGuideView$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1955a {
        /* renamed from: a */
        void mo7071a(UserGuideView userGuideView);

        /* renamed from: b */
        void mo7070b(UserGuideView userGuideView);
    }

    public UserGuideView(Context context) {
        this(context, null);
    }

    public UserGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public UserGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5519h = false;
        this.f5520i = 10.0f;
        this.f5521j = 10.0f;
        this.f5522k = 10;
        this.f5523l = 0;
        this.f5512a = 0;
        this.f5525n = -1728053248;
        this.f5527p = 0;
        this.f5528q = new ArrayList<>();
        this.f5534w = new LinkedHashMap<>();
        this.f5535x = new LinkedHashMap<>();
        this.f5536y = new LinkedHashMap<>();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UserGuideView);
            this.f5523l = obtainStyledAttributes.getInt(0, 0);
            this.f5512a = obtainStyledAttributes.getInt(1, 0);
            this.f5525n = obtainStyledAttributes.getColor(2, this.f5525n);
            this.f5521j = obtainStyledAttributes.getDimension(3, this.f5521j);
            obtainStyledAttributes.recycle();
        }
        m7095a(context);
        m7079b(context);
    }

    /* renamed from: a */
    private void m7095a(Context context) {
        int[] m7373a = MeasureUtil.m7373a(context);
        this.f5517f = m7373a[0];
        this.f5518g = m7373a[1];
    }

    /* renamed from: b */
    private void m7079b(Context context) {
        BlurMaskFilter.Blur blur = null;
        setLayerType(1, null);
        this.f5515d = new Paint(5);
        this.f5515d.setARGB(0, 255, 0, 0);
        this.f5516e = new Paint();
        switch (this.f5512a) {
            case 0:
                blur = BlurMaskFilter.Blur.SOLID;
                break;
            case 1:
                blur = BlurMaskFilter.Blur.NORMAL;
                break;
        }
        this.f5515d.setMaskFilter(new BlurMaskFilter(15.0f, blur));
        this.f5513b = MeasureUtil.m7374a(this.f5517f, this.f5518g, Bitmap.Config.ARGB_8888, 2);
        Bitmap bitmap = this.f5513b;
        if (bitmap == null) {
            throw new RuntimeException("out of memory when maskBitmap create ");
        }
        this.f5514c = new Canvas(bitmap);
        this.f5514c.drawColor(this.f5525n);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        InterfaceC1955a interfaceC1955a;
        if (this.f5529r == null) {
            canvas.drawBitmap(this.f5513b, 0.0f, 0.0f, (Paint) null);
            return;
        }
        if (this.f5528q.size() == 0 && (interfaceC1955a = this.f5526o) != null) {
            interfaceC1955a.mo7070b(this);
        }
        if (this.f5523l == 3) {
            this.f5521j = 0.0f;
            this.f5520i = 0.0f;
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        canvas.drawBitmap(this.f5513b, 0.0f, 0.0f, (Paint) null);
        m7083a(this.f5529r, canvas, saveLayer);
        LinkedHashMap<Bitmap, Rect> linkedHashMap = this.f5537z;
        if (linkedHashMap != null) {
            for (Map.Entry<Bitmap, Rect> entry : linkedHashMap.entrySet()) {
                canvas.drawBitmap(entry.getKey(), entry.getValue().left, entry.getValue().top, (Paint) null);
            }
        }
    }

    /* renamed from: a */
    private void m7083a(LinkedHashMap<View, Bitmap> linkedHashMap, Canvas canvas, int i) {
        if (linkedHashMap == null || linkedHashMap.size() < 1) {
            return;
        }
        for (Map.Entry<View, Bitmap> entry : linkedHashMap.entrySet()) {
            m7091a(entry.getKey(), i, canvas);
            m7089a(entry.getKey(), entry.getValue(), canvas);
        }
    }

    /* renamed from: a */
    private void m7091a(View view, int i, Canvas canvas) {
        if (view == null) {
            return;
        }
        float width = view.getWidth();
        float height = view.getHeight();
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        rect.offset(0, -this.f5527p);
        float f = rect.left - this.f5521j;
        float f2 = rect.top - this.f5521j;
        float f3 = rect.right + this.f5521j;
        float f4 = rect.bottom + this.f5521j;
        if (f == 0.0f) {
            f += this.f5520i;
        } else if (f2 == 0.0f) {
            f2 += this.f5520i;
        } else if (f3 == this.f5517f) {
            f3 -= this.f5520i;
        } else if (f4 == this.f5518g) {
            f4 -= this.f5520i;
        }
        switch (this.f5523l) {
            case 0:
                this.f5515d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                canvas.drawRoundRect(new RectF(f, f2, f3, f4), 20.0f, 20.0f, this.f5515d);
                this.f5515d.setXfermode(null);
                break;
            case 1:
                this.f5515d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                this.f5524m = (width < height ? width / 2.0f : height / 2.0f) + (this.f5521j * 2.0f);
                if (this.f5524m < 50.0f) {
                    this.f5524m = 100.0f;
                }
                float f5 = this.f5521j;
                canvas.drawCircle(f + f5 + (width / 2.0f), f2 + f5 + (height / 2.0f), this.f5524m, this.f5515d);
                this.f5515d.setXfermode(null);
                break;
            case 2:
                this.f5515d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                canvas.drawOval(new RectF(f, f2, f3, f4), this.f5515d);
                this.f5515d.setXfermode(null);
                break;
            case 3:
                this.f5516e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
                Bitmap m7371b = MeasureUtil.m7371b(view, view.getWidth(), view.getHeight());
                if (m7371b != null) {
                    canvas.drawBitmap(m7371b, f, f2, this.f5516e);
                    this.f5516e.setXfermode(null);
                    break;
                } else {
                    return;
                }
        }
        canvas.restoreToCount(i);
    }

    /* renamed from: a */
    private void m7089a(View view, Bitmap bitmap, Canvas canvas) {
        if (bitmap == null) {
            return;
        }
        float width = view.getWidth();
        float height = view.getHeight();
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        rect.offset(0, -this.f5527p);
        float f = rect.left - this.f5521j;
        float f2 = rect.top - this.f5521j;
        float f3 = this.f5521j + rect.right;
        float f4 = rect.bottom + this.f5521j;
        this.f5531t = m7094a(view);
        this.f5532u = m7078b(view);
        this.f5533v = m7074c(view);
        float m7097a = m7097a(f4, f2, height, bitmap, this.f5533v);
        float m7080b = m7080b(f, f3, width, bitmap, this.f5533v);
        if (m7080b < 0.0f) {
            m7080b = 0.0f;
        }
        if (m7097a < 0.0f) {
            m7097a = 0.0f;
        }
        canvas.drawBitmap(bitmap, this.f5531t + m7080b, this.f5532u + m7097a, (Paint) null);
        int i = this.f5531t;
        int i2 = (int) m7097a;
        this.f5530s = new Rect((int) (i + m7080b), this.f5532u + i2, ((int) m7080b) + i + bitmap.getWidth(), i2 + this.f5532u + bitmap.getHeight());
    }

    /* renamed from: c */
    private Direction m7074c(View view) {
        if (this.f5536y.containsKey(view)) {
            return this.f5536y.get(view);
        }
        return Direction.DEFAULT;
    }

    /* renamed from: a */
    private float m7097a(float f, float f2, float f3, Bitmap bitmap, Direction direction) {
        if (direction == Direction.LEFT || direction == Direction.RIGHT) {
            return (((f - f2) / 2.0f) + f2) - (bitmap.getHeight() / 2);
        }
        if (direction == Direction.TOP) {
            return f;
        }
        if (direction == Direction.BOTTOM) {
            return f2 - bitmap.getHeight();
        }
        return (((f - f2) / 2.0f) + f2) - (bitmap.getHeight() / 2);
    }

    /* renamed from: b */
    private float m7080b(float f, float f2, float f3, Bitmap bitmap, Direction direction) {
        if (direction == Direction.TOP || direction == Direction.BOTTOM) {
            return f - ((bitmap.getWidth() - f3) / 2.0f);
        }
        if (direction == Direction.LEFT) {
            return f2;
        }
        if (direction == Direction.RIGHT) {
            return f - bitmap.getWidth();
        }
        if (direction == Direction.DEFAULT) {
            return f - ((bitmap.getWidth() - f3) / 2.0f);
        }
        return 0.0f;
    }

    public void setTouchOutsideDismiss(boolean z) {
        this.f5519h = z;
    }

    public void setBorderWidth(int i) {
        this.f5520i = i;
    }

    /* renamed from: a */
    private Bitmap m7096a(int i) {
        return BitmapFactory.decodeResource(getResources(), i);
    }

    public void setMaskColor(int i) {
        this.f5525n = i;
    }

    public void setStatusBarHeight(int i) {
        this.f5527p = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f5519h) {
                m7075c();
                return true;
            }
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            Rect rect = this.f5530s;
            if (rect != null && rect.contains(x, y)) {
                m7075c();
                return true;
            }
        }
        return true;
    }

    public int getMargin() {
        return this.f5522k;
    }

    public void setMargin(int i) {
        this.f5522k = i;
    }

    public float getOffestMargin() {
        return this.f5521j;
    }

    public void setOffestMargin(float f) {
        this.f5521j = f;
    }

    public void setOnUserGuideListener(InterfaceC1955a interfaceC1955a) {
        this.f5526o = interfaceC1955a;
    }

    /* renamed from: a */
    public void m7093a(View view, int i) {
        this.f5534w.put(view, Integer.valueOf(i));
    }

    /* renamed from: b */
    public void m7077b(View view, int i) {
        this.f5535x.put(view, Integer.valueOf(i));
    }

    /* renamed from: a */
    public void m7088a(View view, Direction direction) {
        this.f5536y.put(view, direction);
    }

    /* renamed from: a */
    public int m7094a(View view) {
        Integer num = this.f5534w.get(view);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* renamed from: b */
    public int m7078b(View view) {
        Integer num = this.f5535x.get(view);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* renamed from: a */
    public void m7098a() {
        m7075c();
    }

    /* renamed from: a */
    public void m7092a(View view, int i, int i2, Bitmap bitmap) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, i, i2);
        m7090a(view, bitmap);
    }

    /* renamed from: a */
    public void m7087a(View view, String str, int i, int i2, Direction direction) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, DpiUtils.m5886b(getContext(), 18.0f));
        textView.setText(str);
        textView.setTextColor(getContext().getResources().getColor(R.color.white));
        TextPaint paint = textView.getPaint();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f = fontMetrics.bottom - fontMetrics.top;
        m7090a(view, MeasureUtil.m7372a(textView, (int) paint.measureText(m7076b(textView.getText().toString())), ((int) f) * m7085a(str)));
        m7093a(view, i);
        m7077b(view, i2);
        m7088a(view, direction);
    }

    /* renamed from: a */
    public void m7086a(View view, String str, String str2, int i, int i2, Direction direction, int i3) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            indexOf = 0;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(DpiUtils.m5886b(getContext(), 14.0f)), 0, spannableString.length(), 18);
        spannableString.setSpan(new AbsoluteSizeSpan(DpiUtils.m5886b(getContext(), 20.0f)), indexOf, str2.length() + indexOf, 18);
        TextView textView = new TextView(getContext());
        textView.setText(spannableString);
        textView.setTextColor(getContext().getResources().getColor(R.color.white));
        textView.setGravity(i3);
        TextPaint paint = textView.getPaint();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f = fontMetrics.bottom - fontMetrics.top;
        m7090a(view, MeasureUtil.m7372a(textView, (int) paint.measureText(m7076b(textView.getText().toString())), (((int) f) * m7085a(str)) + 12));
        m7093a(view, i);
        m7077b(view, i2);
        m7088a(view, direction);
    }

    /* renamed from: a */
    private int m7085a(String str) {
        int i = 1;
        while (str.indexOf("\n") != -1) {
            i++;
            str = str.substring(str.indexOf("\n") + 1, str.length());
        }
        return i;
    }

    /* renamed from: b */
    private String m7076b(String str) {
        String str2 = str;
        int i = 0;
        while (true) {
            int indexOf = str.indexOf("\n");
            if (indexOf == -1) {
                break;
            }
            if (str.substring(0, indexOf).length() > i) {
                i = str.substring(0, indexOf).length();
                str2 = str.substring(0, indexOf);
            }
            str = str.substring(indexOf + 1);
        }
        return str.length() > str2.length() ? str : str2;
    }

    /* renamed from: c */
    public void m7073c(View view, int i) {
        m7090a(view, m7096a(i));
    }

    /* renamed from: a */
    private void m7090a(View view, Bitmap bitmap) {
        if (view != null) {
            LinkedHashMap<View, Bitmap> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put(view, bitmap);
            this.f5528q.add(linkedHashMap);
        }
    }

    /* renamed from: a */
    private void m7084a(LinkedHashMap<View, Bitmap> linkedHashMap) {
        this.f5528q.add(linkedHashMap);
    }

    /* renamed from: a */
    public void m7082a(LinkedHashMap<View, String> linkedHashMap, LinkedHashMap<View, Direction> linkedHashMap2) {
        if (linkedHashMap != null) {
            LinkedHashMap<View, Bitmap> linkedHashMap3 = new LinkedHashMap<>();
            for (Map.Entry<View, String> entry : linkedHashMap.entrySet()) {
                TextView textView = new TextView(getContext());
                textView.setTextSize(0, DpiUtils.m5886b(getContext(), 18.0f));
                textView.setText(entry.getValue());
                textView.setTextColor(getContext().getResources().getColor(R.color.white));
                TextPaint paint = textView.getPaint();
                Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                linkedHashMap3.put(entry.getKey(), MeasureUtil.m7372a(textView, (int) paint.measureText(m7076b(entry.getValue())), (int) (fontMetrics.bottom - fontMetrics.top)));
                if (linkedHashMap2.containsKey(entry.getKey())) {
                    this.f5536y.put(entry.getKey(), linkedHashMap2.get(entry.getKey()));
                }
            }
            m7084a(linkedHashMap3);
        }
    }

    /* renamed from: b */
    public void m7081b() {
        this.f5536y = null;
        this.f5529r = null;
        this.f5534w = null;
        this.f5535x = null;
        setVisibility(8);
    }

    /* renamed from: c */
    public void m7075c() {
        ArrayList<LinkedHashMap<View, Bitmap>> arrayList = this.f5528q;
        if (arrayList == null || arrayList.size() < 1) {
            InterfaceC1955a interfaceC1955a = this.f5526o;
            if (interfaceC1955a != null) {
                interfaceC1955a.mo7071a(this);
                return;
            }
            return;
        }
        this.f5529r = this.f5528q.get(0);
        this.f5528q.remove(0);
        invalidate();
    }

    /* renamed from: d */
    public void m7072d() {
        invalidate();
        setVisibility(0);
    }
}
