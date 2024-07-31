package com.p081xw.repo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.p008v4.app.NotificationCompat;
import android.support.p008v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import com.p081xw.repo.bubbleseekbar.C2782R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.math.BigDecimal;

/* renamed from: com.xw.repo.BubbleSeekBar */
/* loaded from: classes2.dex */
public class BubbleSeekBar extends View {
    static final int NONE = -1;

    /* renamed from: dx */
    float f9157dx;
    private boolean isAlwaysShowBubble;
    private boolean isAutoAdjustSectionMark;
    private boolean isFloatType;
    private boolean isHideBubble;
    private boolean isRtl;
    private boolean isSeekBySection;
    private boolean isShowProgressInFloat;
    private boolean isShowSectionMark;
    private boolean isShowSectionText;
    private boolean isShowThumbText;
    private boolean isThumbOnDragging;
    private boolean isTouchToSeek;
    private boolean isTouchToSeekAnimEnd;
    private long mAlwaysShowBubbleDelay;
    private long mAnimDuration;
    private float mBubbleCenterRawSolidX;
    private float mBubbleCenterRawSolidY;
    private float mBubbleCenterRawX;
    private int mBubbleColor;
    private int mBubbleRadius;
    private int mBubbleTextColor;
    private int mBubbleTextSize;
    private BubbleView mBubbleView;
    private float mDelta;
    private WindowManager.LayoutParams mLayoutParams;
    private float mLeft;
    private float mMax;
    private float mMin;
    private Paint mPaint;
    private int[] mPoint;
    private float mPreSecValue;
    private float mProgress;
    private OnProgressChangedListener mProgressListener;
    private Rect mRectText;
    private float mRight;
    private int mSecondTrackColor;
    private int mSecondTrackSize;
    private int mSectionCount;
    private float mSectionOffset;
    private SparseArray<String> mSectionTextArray;
    private int mSectionTextColor;
    private int mSectionTextInterval;
    private int mSectionTextPosition;
    private int mSectionTextSize;
    private float mSectionValue;
    private int mTextSpace;
    private float mThumbCenterX;
    private int mThumbColor;
    private int mThumbRadius;
    private int mThumbRadiusOnDragging;
    private int mThumbTextColor;
    private int mThumbTextSize;
    private int mTrackColor;
    private float mTrackLength;
    private int mTrackSize;
    private WindowManager mWindowManager;
    private boolean triggerBubbleShowing;
    private boolean triggerSeekBySection;

    /* renamed from: com.xw.repo.BubbleSeekBar$CustomSectionTextArray */
    /* loaded from: classes2.dex */
    public interface CustomSectionTextArray {
        @NonNull
        SparseArray<String> onCustomize(int i, @NonNull SparseArray<String> sparseArray);
    }

    /* renamed from: com.xw.repo.BubbleSeekBar$OnProgressChangedListener */
    /* loaded from: classes2.dex */
    public interface OnProgressChangedListener {
        void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int i, float f);

        void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int i, float f);

        void onProgressChanged(BubbleSeekBar bubbleSeekBar, int i, float f);
    }

    /* renamed from: com.xw.repo.BubbleSeekBar$OnProgressChangedListenerAdapter */
    /* loaded from: classes2.dex */
    public static abstract class OnProgressChangedListenerAdapter implements OnProgressChangedListener {
        @Override // com.p081xw.repo.BubbleSeekBar.OnProgressChangedListener
        public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int i, float f) {
        }

        @Override // com.p081xw.repo.BubbleSeekBar.OnProgressChangedListener
        public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int i, float f) {
        }

        @Override // com.p081xw.repo.BubbleSeekBar.OnProgressChangedListener
        public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int i, float f) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.xw.repo.BubbleSeekBar$TextPosition */
    /* loaded from: classes2.dex */
    public @interface TextPosition {
        public static final int BELOW_SECTION_MARK = 2;
        public static final int BOTTOM_SIDES = 1;
        public static final int SIDES = 0;
    }

    public BubbleSeekBar(Context context) {
        this(context, null);
    }

    public BubbleSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSectionTextPosition = -1;
        this.mSectionTextArray = new SparseArray<>();
        this.mPoint = new int[2];
        this.isTouchToSeekAnimEnd = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2782R.styleable.BubbleSeekBar, i, 0);
        this.mMin = obtainStyledAttributes.getFloat(C2782R.styleable.BubbleSeekBar_bsb_min, 0.0f);
        this.mMax = obtainStyledAttributes.getFloat(C2782R.styleable.BubbleSeekBar_bsb_max, 100.0f);
        this.mProgress = obtainStyledAttributes.getFloat(C2782R.styleable.BubbleSeekBar_bsb_progress, this.mMin);
        this.isFloatType = obtainStyledAttributes.getBoolean(C2782R.styleable.BubbleSeekBar_bsb_is_float_type, false);
        this.mTrackSize = obtainStyledAttributes.getDimensionPixelSize(C2782R.styleable.BubbleSeekBar_bsb_track_size, BubbleUtils.dp2px(2));
        this.mSecondTrackSize = obtainStyledAttributes.getDimensionPixelSize(C2782R.styleable.BubbleSeekBar_bsb_second_track_size, this.mTrackSize + BubbleUtils.dp2px(2));
        this.mThumbRadius = obtainStyledAttributes.getDimensionPixelSize(C2782R.styleable.BubbleSeekBar_bsb_thumb_radius, this.mSecondTrackSize + BubbleUtils.dp2px(2));
        this.mThumbRadiusOnDragging = obtainStyledAttributes.getDimensionPixelSize(C2782R.styleable.BubbleSeekBar_bsb_thumb_radius, this.mSecondTrackSize * 2);
        this.mSectionCount = obtainStyledAttributes.getInteger(C2782R.styleable.BubbleSeekBar_bsb_section_count, 10);
        this.mTrackColor = obtainStyledAttributes.getColor(C2782R.styleable.BubbleSeekBar_bsb_track_color, ContextCompat.getColor(context, C2782R.color.colorPrimary));
        this.mSecondTrackColor = obtainStyledAttributes.getColor(C2782R.styleable.BubbleSeekBar_bsb_second_track_color, ContextCompat.getColor(context, C2782R.color.colorAccent));
        this.mThumbColor = obtainStyledAttributes.getColor(C2782R.styleable.BubbleSeekBar_bsb_thumb_color, this.mSecondTrackColor);
        this.isShowSectionText = obtainStyledAttributes.getBoolean(C2782R.styleable.BubbleSeekBar_bsb_show_section_text, false);
        this.mSectionTextSize = obtainStyledAttributes.getDimensionPixelSize(C2782R.styleable.BubbleSeekBar_bsb_section_text_size, BubbleUtils.sp2px(14));
        this.mSectionTextColor = obtainStyledAttributes.getColor(C2782R.styleable.BubbleSeekBar_bsb_section_text_color, this.mTrackColor);
        this.isSeekBySection = obtainStyledAttributes.getBoolean(C2782R.styleable.BubbleSeekBar_bsb_seek_by_section, false);
        int integer = obtainStyledAttributes.getInteger(C2782R.styleable.BubbleSeekBar_bsb_section_text_position, -1);
        if (integer == 0) {
            this.mSectionTextPosition = 0;
        } else if (integer == 1) {
            this.mSectionTextPosition = 1;
        } else if (integer == 2) {
            this.mSectionTextPosition = 2;
        } else {
            this.mSectionTextPosition = -1;
        }
        this.mSectionTextInterval = obtainStyledAttributes.getInteger(C2782R.styleable.BubbleSeekBar_bsb_section_text_interval, 1);
        this.isShowThumbText = obtainStyledAttributes.getBoolean(C2782R.styleable.BubbleSeekBar_bsb_show_thumb_text, false);
        this.mThumbTextSize = obtainStyledAttributes.getDimensionPixelSize(C2782R.styleable.BubbleSeekBar_bsb_thumb_text_size, BubbleUtils.sp2px(14));
        this.mThumbTextColor = obtainStyledAttributes.getColor(C2782R.styleable.BubbleSeekBar_bsb_thumb_text_color, this.mSecondTrackColor);
        this.mBubbleColor = obtainStyledAttributes.getColor(C2782R.styleable.BubbleSeekBar_bsb_bubble_color, this.mSecondTrackColor);
        this.mBubbleTextSize = obtainStyledAttributes.getDimensionPixelSize(C2782R.styleable.BubbleSeekBar_bsb_bubble_text_size, BubbleUtils.sp2px(14));
        this.mBubbleTextColor = obtainStyledAttributes.getColor(C2782R.styleable.BubbleSeekBar_bsb_bubble_text_color, -1);
        this.isShowSectionMark = obtainStyledAttributes.getBoolean(C2782R.styleable.BubbleSeekBar_bsb_show_section_mark, false);
        this.isAutoAdjustSectionMark = obtainStyledAttributes.getBoolean(C2782R.styleable.BubbleSeekBar_bsb_auto_adjust_section_mark, false);
        this.isShowProgressInFloat = obtainStyledAttributes.getBoolean(C2782R.styleable.BubbleSeekBar_bsb_show_progress_in_float, false);
        int integer2 = obtainStyledAttributes.getInteger(C2782R.styleable.BubbleSeekBar_bsb_anim_duration, -1);
        this.mAnimDuration = integer2 < 0 ? 200L : integer2;
        this.isTouchToSeek = obtainStyledAttributes.getBoolean(C2782R.styleable.BubbleSeekBar_bsb_touch_to_seek, false);
        this.isAlwaysShowBubble = obtainStyledAttributes.getBoolean(C2782R.styleable.BubbleSeekBar_bsb_always_show_bubble, false);
        int integer3 = obtainStyledAttributes.getInteger(C2782R.styleable.BubbleSeekBar_bsb_always_show_bubble_delay, 0);
        this.mAlwaysShowBubbleDelay = integer3 > 0 ? integer3 : 200L;
        this.isHideBubble = obtainStyledAttributes.getBoolean(C2782R.styleable.BubbleSeekBar_bsb_hide_bubble, false);
        this.isRtl = obtainStyledAttributes.getBoolean(C2782R.styleable.BubbleSeekBar_bsb_rtl, false);
        obtainStyledAttributes.recycle();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mRectText = new Rect();
        this.mTextSpace = BubbleUtils.dp2px(2);
        initConfigByPriority();
        if (this.isHideBubble) {
            return;
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mBubbleView = new BubbleView(this, context);
        this.mBubbleView.setProgressText(this.isShowProgressInFloat ? String.valueOf(getProgressFloat()) : String.valueOf(getProgress()));
        this.mLayoutParams = new WindowManager.LayoutParams();
        WindowManager.LayoutParams layoutParams = this.mLayoutParams;
        layoutParams.gravity = 8388659;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.flags = 524328;
        if (BubbleUtils.isMIUI() || Build.VERSION.SDK_INT >= 25) {
            this.mLayoutParams.type = 2;
        } else {
            this.mLayoutParams.type = 2005;
        }
        calculateRadiusOfBubble();
    }

    private void initConfigByPriority() {
        if (this.mMin == this.mMax) {
            this.mMin = 0.0f;
            this.mMax = 100.0f;
        }
        float f = this.mMin;
        float f2 = this.mMax;
        if (f > f2) {
            this.mMax = f;
            this.mMin = f2;
        }
        float f3 = this.mProgress;
        float f4 = this.mMin;
        if (f3 < f4) {
            this.mProgress = f4;
        }
        float f5 = this.mProgress;
        float f6 = this.mMax;
        if (f5 > f6) {
            this.mProgress = f6;
        }
        int i = this.mSecondTrackSize;
        int i2 = this.mTrackSize;
        if (i < i2) {
            this.mSecondTrackSize = i2 + BubbleUtils.dp2px(2);
        }
        int i3 = this.mThumbRadius;
        int i4 = this.mSecondTrackSize;
        if (i3 <= i4) {
            this.mThumbRadius = i4 + BubbleUtils.dp2px(2);
        }
        int i5 = this.mThumbRadiusOnDragging;
        int i6 = this.mSecondTrackSize;
        if (i5 <= i6) {
            this.mThumbRadiusOnDragging = i6 * 2;
        }
        if (this.mSectionCount <= 0) {
            this.mSectionCount = 10;
        }
        this.mDelta = this.mMax - this.mMin;
        this.mSectionValue = this.mDelta / this.mSectionCount;
        if (this.mSectionValue < 1.0f) {
            this.isFloatType = true;
        }
        if (this.isFloatType) {
            this.isShowProgressInFloat = true;
        }
        if (this.mSectionTextPosition != -1) {
            this.isShowSectionText = true;
        }
        if (this.isShowSectionText) {
            if (this.mSectionTextPosition == -1) {
                this.mSectionTextPosition = 0;
            }
            if (this.mSectionTextPosition == 2) {
                this.isShowSectionMark = true;
            }
        }
        if (this.mSectionTextInterval < 1) {
            this.mSectionTextInterval = 1;
        }
        initSectionTextArray();
        if (this.isAutoAdjustSectionMark && !this.isShowSectionMark) {
            this.isAutoAdjustSectionMark = false;
        }
        if (this.isSeekBySection) {
            float f7 = this.mMin;
            this.mPreSecValue = f7;
            if (this.mProgress != f7) {
                this.mPreSecValue = this.mSectionValue;
            }
            this.isShowSectionMark = true;
            this.isAutoAdjustSectionMark = true;
            this.isTouchToSeek = false;
        }
        if (this.isHideBubble) {
            this.isAlwaysShowBubble = false;
        }
        if (this.isAlwaysShowBubble) {
            setProgress(this.mProgress);
        }
        this.mThumbTextSize = (this.isFloatType || this.isSeekBySection || (this.isShowSectionText && this.mSectionTextPosition == 2)) ? this.mSectionTextSize : this.mThumbTextSize;
    }

    private void calculateRadiusOfBubble() {
        String float2String;
        String float2String2;
        this.mPaint.setTextSize(this.mBubbleTextSize);
        if (this.isShowProgressInFloat) {
            float2String = float2String(this.isRtl ? this.mMax : this.mMin);
        } else if (this.isRtl) {
            float2String = this.isFloatType ? float2String(this.mMax) : String.valueOf((int) this.mMax);
        } else {
            float2String = this.isFloatType ? float2String(this.mMin) : String.valueOf((int) this.mMin);
        }
        this.mPaint.getTextBounds(float2String, 0, float2String.length(), this.mRectText);
        int width = (this.mRectText.width() + (this.mTextSpace * 2)) >> 1;
        if (this.isShowProgressInFloat) {
            float2String2 = float2String(this.isRtl ? this.mMin : this.mMax);
        } else if (this.isRtl) {
            float2String2 = this.isFloatType ? float2String(this.mMin) : String.valueOf((int) this.mMin);
        } else {
            float2String2 = this.isFloatType ? float2String(this.mMax) : String.valueOf((int) this.mMax);
        }
        this.mPaint.getTextBounds(float2String2, 0, float2String2.length(), this.mRectText);
        this.mBubbleRadius = BubbleUtils.dp2px(14);
        this.mBubbleRadius = Math.max(this.mBubbleRadius, Math.max(width, (this.mRectText.width() + (this.mTextSpace * 2)) >> 1)) + this.mTextSpace;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void initSectionTextArray() {
        /*
            r6 = this;
            int r0 = r6.mSectionTextPosition
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 != r1) goto L9
            r0 = 1
            goto La
        L9:
            r0 = 0
        La:
            int r4 = r6.mSectionTextInterval
            if (r4 <= r3) goto L14
            int r4 = r6.mSectionCount
            int r4 = r4 % r1
            if (r4 != 0) goto L14
            goto L15
        L14:
            r3 = 0
        L15:
            int r1 = r6.mSectionCount
            if (r2 > r1) goto L78
            boolean r1 = r6.isRtl
            if (r1 == 0) goto L26
            float r1 = r6.mMax
            float r4 = r6.mSectionValue
            float r5 = (float) r2
            float r4 = r4 * r5
            float r1 = r1 - r4
            goto L2e
        L26:
            float r1 = r6.mMin
            float r4 = r6.mSectionValue
            float r5 = (float) r2
            float r4 = r4 * r5
            float r1 = r1 + r4
        L2e:
            if (r0 == 0) goto L4e
            if (r3 == 0) goto L55
            int r1 = r6.mSectionTextInterval
            int r1 = r2 % r1
            if (r1 != 0) goto L75
            boolean r1 = r6.isRtl
            if (r1 == 0) goto L45
            float r1 = r6.mMax
            float r4 = r6.mSectionValue
            float r5 = (float) r2
            float r4 = r4 * r5
            float r1 = r1 - r4
            goto L55
        L45:
            float r1 = r6.mMin
            float r4 = r6.mSectionValue
            float r5 = (float) r2
            float r4 = r4 * r5
            float r1 = r1 + r4
            goto L55
        L4e:
            if (r2 == 0) goto L55
            int r4 = r6.mSectionCount
            if (r2 == r4) goto L55
            goto L75
        L55:
            android.util.SparseArray<java.lang.String> r4 = r6.mSectionTextArray
            boolean r5 = r6.isFloatType
            if (r5 == 0) goto L60
            java.lang.String r1 = r6.float2String(r1)
            goto L72
        L60:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r1 = (int) r1
            r5.append(r1)
            java.lang.String r1 = ""
            r5.append(r1)
            java.lang.String r1 = r5.toString()
        L72:
            r4.put(r2, r1)
        L75:
            int r2 = r2 + 1
            goto L15
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p081xw.repo.BubbleSeekBar.initSectionTextArray():void");
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.mThumbRadiusOnDragging * 2;
        if (this.isShowThumbText) {
            this.mPaint.setTextSize(this.mThumbTextSize);
            this.mPaint.getTextBounds("j", 0, 1, this.mRectText);
            i3 += this.mRectText.height();
        }
        if (this.isShowSectionText && this.mSectionTextPosition >= 1) {
            this.mPaint.setTextSize(this.mSectionTextSize);
            this.mPaint.getTextBounds("j", 0, 1, this.mRectText);
            i3 = Math.max(i3, (this.mThumbRadiusOnDragging * 2) + this.mRectText.height());
        }
        setMeasuredDimension(resolveSize(BubbleUtils.dp2px(180), i), i3 + (this.mTextSpace * 2));
        this.mLeft = getPaddingLeft() + this.mThumbRadiusOnDragging;
        this.mRight = (getMeasuredWidth() - getPaddingRight()) - this.mThumbRadiusOnDragging;
        if (this.isShowSectionText) {
            this.mPaint.setTextSize(this.mSectionTextSize);
            int i4 = this.mSectionTextPosition;
            if (i4 == 0) {
                String str = this.mSectionTextArray.get(0);
                this.mPaint.getTextBounds(str, 0, str.length(), this.mRectText);
                this.mLeft += this.mRectText.width() + this.mTextSpace;
                String str2 = this.mSectionTextArray.get(this.mSectionCount);
                this.mPaint.getTextBounds(str2, 0, str2.length(), this.mRectText);
                this.mRight -= this.mRectText.width() + this.mTextSpace;
            } else if (i4 >= 1) {
                String str3 = this.mSectionTextArray.get(0);
                this.mPaint.getTextBounds(str3, 0, str3.length(), this.mRectText);
                this.mLeft = getPaddingLeft() + Math.max(this.mThumbRadiusOnDragging, this.mRectText.width() / 2.0f) + this.mTextSpace;
                String str4 = this.mSectionTextArray.get(this.mSectionCount);
                this.mPaint.getTextBounds(str4, 0, str4.length(), this.mRectText);
                this.mRight = ((getMeasuredWidth() - getPaddingRight()) - Math.max(this.mThumbRadiusOnDragging, this.mRectText.width() / 2.0f)) - this.mTextSpace;
            }
        } else if (this.isShowThumbText && this.mSectionTextPosition == -1) {
            this.mPaint.setTextSize(this.mThumbTextSize);
            String str5 = this.mSectionTextArray.get(0);
            this.mPaint.getTextBounds(str5, 0, str5.length(), this.mRectText);
            this.mLeft = getPaddingLeft() + Math.max(this.mThumbRadiusOnDragging, this.mRectText.width() / 2.0f) + this.mTextSpace;
            String str6 = this.mSectionTextArray.get(this.mSectionCount);
            this.mPaint.getTextBounds(str6, 0, str6.length(), this.mRectText);
            this.mRight = ((getMeasuredWidth() - getPaddingRight()) - Math.max(this.mThumbRadiusOnDragging, this.mRectText.width() / 2.0f)) - this.mTextSpace;
        }
        this.mTrackLength = this.mRight - this.mLeft;
        this.mSectionOffset = (this.mTrackLength * 1.0f) / this.mSectionCount;
        if (this.isHideBubble) {
            return;
        }
        this.mBubbleView.measure(i, i2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.isHideBubble) {
            return;
        }
        locatePositionOnScreen();
    }

    private void locatePositionOnScreen() {
        Window window;
        getLocationOnScreen(this.mPoint);
        if (this.isRtl) {
            this.mBubbleCenterRawSolidX = (this.mPoint[0] + this.mRight) - (this.mBubbleView.getMeasuredWidth() / 2.0f);
        } else {
            this.mBubbleCenterRawSolidX = (this.mPoint[0] + this.mLeft) - (this.mBubbleView.getMeasuredWidth() / 2.0f);
        }
        this.mBubbleCenterRawX = calculateCenterRawXofBubbleView();
        this.mBubbleCenterRawSolidY = this.mPoint[1] - this.mBubbleView.getMeasuredHeight();
        this.mBubbleCenterRawSolidY -= BubbleUtils.dp2px(24);
        if (BubbleUtils.isMIUI()) {
            this.mBubbleCenterRawSolidY += BubbleUtils.dp2px(4);
        }
        Context context = getContext();
        if (!(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null || (window.getAttributes().flags & 1024) == 0) {
            return;
        }
        Resources system = Resources.getSystem();
        this.mBubbleCenterRawSolidY += system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", "android"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x0252, code lost:
        if (r4 != r14.mMax) goto L40;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onDraw(android.graphics.Canvas r15) {
        /*
            Method dump skipped, instructions count: 737
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p081xw.repo.BubbleSeekBar.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new Runnable() { // from class: com.xw.repo.BubbleSeekBar.1
            @Override // java.lang.Runnable
            public void run() {
                BubbleSeekBar.this.requestLayout();
            }
        });
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        if (this.isHideBubble || !this.isAlwaysShowBubble) {
            return;
        }
        if (i != 0) {
            hideBubble();
        } else if (this.triggerBubbleShowing) {
            showBubble();
        }
        super.onVisibilityChanged(view, i);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        hideBubble();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                performClick();
                getParent().requestDisallowInterceptTouchEvent(true);
                this.isThumbOnDragging = isThumbTouched(motionEvent);
                if (this.isThumbOnDragging) {
                    if (this.isSeekBySection && !this.triggerSeekBySection) {
                        this.triggerSeekBySection = true;
                    }
                    if (this.isAlwaysShowBubble && !this.triggerBubbleShowing) {
                        this.triggerBubbleShowing = true;
                    }
                    if (!this.isHideBubble) {
                        showBubble();
                    }
                    invalidate();
                } else if (this.isTouchToSeek && isTrackTouched(motionEvent)) {
                    this.isThumbOnDragging = true;
                    if (this.isAlwaysShowBubble) {
                        hideBubble();
                        this.triggerBubbleShowing = true;
                    }
                    this.mThumbCenterX = motionEvent.getX();
                    float f = this.mThumbCenterX;
                    float f2 = this.mLeft;
                    if (f < f2) {
                        this.mThumbCenterX = f2;
                    }
                    float f3 = this.mThumbCenterX;
                    float f4 = this.mRight;
                    if (f3 > f4) {
                        this.mThumbCenterX = f4;
                    }
                    this.mProgress = calculateProgress();
                    if (!this.isHideBubble) {
                        this.mBubbleCenterRawX = calculateCenterRawXofBubbleView();
                        showBubble();
                    }
                    invalidate();
                }
                this.f9157dx = this.mThumbCenterX - motionEvent.getX();
                break;
            case 1:
            case 3:
                getParent().requestDisallowInterceptTouchEvent(false);
                if (this.isAutoAdjustSectionMark) {
                    if (this.isTouchToSeek) {
                        postDelayed(new Runnable() { // from class: com.xw.repo.BubbleSeekBar.2
                            @Override // java.lang.Runnable
                            public void run() {
                                BubbleSeekBar.this.isTouchToSeekAnimEnd = false;
                                BubbleSeekBar.this.autoAdjustSection();
                            }
                        }, this.isThumbOnDragging ? 0L : 300L);
                    } else {
                        autoAdjustSection();
                    }
                } else if (this.isThumbOnDragging || this.isTouchToSeek) {
                    if (this.isHideBubble) {
                        ViewPropertyAnimator duration = animate().setDuration(this.mAnimDuration);
                        if (!this.isThumbOnDragging && this.isTouchToSeek) {
                            r3 = 300;
                        }
                        duration.setStartDelay(r3).setListener(new AnimatorListenerAdapter() { // from class: com.xw.repo.BubbleSeekBar.3
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                BubbleSeekBar.this.isThumbOnDragging = false;
                                BubbleSeekBar.this.invalidate();
                                if (BubbleSeekBar.this.mProgressListener != null) {
                                    OnProgressChangedListener onProgressChangedListener = BubbleSeekBar.this.mProgressListener;
                                    BubbleSeekBar bubbleSeekBar = BubbleSeekBar.this;
                                    onProgressChangedListener.onProgressChanged(bubbleSeekBar, bubbleSeekBar.getProgress(), BubbleSeekBar.this.getProgressFloat());
                                }
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator) {
                                BubbleSeekBar.this.isThumbOnDragging = false;
                                BubbleSeekBar.this.invalidate();
                            }
                        }).start();
                    } else {
                        ViewPropertyAnimator duration2 = this.mBubbleView.animate().alpha(this.isAlwaysShowBubble ? 1.0f : 0.0f).setDuration(this.mAnimDuration);
                        if (!this.isThumbOnDragging && this.isTouchToSeek) {
                            r3 = 300;
                        }
                        duration2.setStartDelay(r3).setListener(new AnimatorListenerAdapter() { // from class: com.xw.repo.BubbleSeekBar.4
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (!BubbleSeekBar.this.isAlwaysShowBubble) {
                                    BubbleSeekBar.this.hideBubble();
                                }
                                BubbleSeekBar.this.isThumbOnDragging = false;
                                BubbleSeekBar.this.invalidate();
                                if (BubbleSeekBar.this.mProgressListener != null) {
                                    OnProgressChangedListener onProgressChangedListener = BubbleSeekBar.this.mProgressListener;
                                    BubbleSeekBar bubbleSeekBar = BubbleSeekBar.this;
                                    onProgressChangedListener.onProgressChanged(bubbleSeekBar, bubbleSeekBar.getProgress(), BubbleSeekBar.this.getProgressFloat());
                                }
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator) {
                                if (!BubbleSeekBar.this.isAlwaysShowBubble) {
                                    BubbleSeekBar.this.hideBubble();
                                }
                                BubbleSeekBar.this.isThumbOnDragging = false;
                                BubbleSeekBar.this.invalidate();
                            }
                        }).start();
                    }
                }
                OnProgressChangedListener onProgressChangedListener = this.mProgressListener;
                if (onProgressChangedListener != null) {
                    onProgressChangedListener.getProgressOnActionUp(this, getProgress(), getProgressFloat());
                    break;
                }
                break;
            case 2:
                if (this.isThumbOnDragging) {
                    this.mThumbCenterX = motionEvent.getX() + this.f9157dx;
                    float f5 = this.mThumbCenterX;
                    float f6 = this.mLeft;
                    if (f5 < f6) {
                        this.mThumbCenterX = f6;
                    }
                    float f7 = this.mThumbCenterX;
                    float f8 = this.mRight;
                    if (f7 > f8) {
                        this.mThumbCenterX = f8;
                    }
                    this.mProgress = calculateProgress();
                    if (!this.isHideBubble) {
                        this.mBubbleCenterRawX = calculateCenterRawXofBubbleView();
                        WindowManager.LayoutParams layoutParams = this.mLayoutParams;
                        layoutParams.x = (int) (this.mBubbleCenterRawX + 0.5f);
                        this.mWindowManager.updateViewLayout(this.mBubbleView, layoutParams);
                        this.mBubbleView.setProgressText(this.isShowProgressInFloat ? String.valueOf(getProgressFloat()) : String.valueOf(getProgress()));
                    }
                    invalidate();
                    OnProgressChangedListener onProgressChangedListener2 = this.mProgressListener;
                    if (onProgressChangedListener2 != null) {
                        onProgressChangedListener2.onProgressChanged(this, getProgress(), getProgressFloat());
                        break;
                    }
                }
                break;
        }
        return this.isThumbOnDragging || this.isTouchToSeek || super.onTouchEvent(motionEvent);
    }

    private boolean isThumbTouched(MotionEvent motionEvent) {
        if (isEnabled()) {
            float f = (this.mTrackLength / this.mDelta) * (this.mProgress - this.mMin);
            float f2 = this.isRtl ? this.mRight - f : this.mLeft + f;
            float measuredHeight = getMeasuredHeight() / 2.0f;
            return ((motionEvent.getX() - f2) * (motionEvent.getX() - f2)) + ((motionEvent.getY() - measuredHeight) * (motionEvent.getY() - measuredHeight)) <= (this.mLeft + ((float) BubbleUtils.dp2px(8))) * (this.mLeft + ((float) BubbleUtils.dp2px(8)));
        }
        return false;
    }

    private boolean isTrackTouched(MotionEvent motionEvent) {
        return isEnabled() && motionEvent.getX() >= ((float) getPaddingLeft()) && motionEvent.getX() <= ((float) (getMeasuredWidth() - getPaddingRight())) && motionEvent.getY() >= ((float) getPaddingTop()) && motionEvent.getY() <= ((float) (getMeasuredHeight() - getPaddingBottom()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBubble() {
        BubbleView bubbleView = this.mBubbleView;
        if (bubbleView == null || bubbleView.getParent() != null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = this.mLayoutParams;
        layoutParams.x = (int) (this.mBubbleCenterRawX + 0.5f);
        layoutParams.y = (int) (this.mBubbleCenterRawSolidY + 0.5f);
        this.mBubbleView.setAlpha(0.0f);
        this.mBubbleView.setVisibility(0);
        this.mBubbleView.animate().alpha(1.0f).setDuration(this.mAnimDuration).setListener(new AnimatorListenerAdapter() { // from class: com.xw.repo.BubbleSeekBar.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BubbleSeekBar.this.mWindowManager.addView(BubbleSeekBar.this.mBubbleView, BubbleSeekBar.this.mLayoutParams);
            }
        }).start();
        this.mBubbleView.setProgressText(this.isShowProgressInFloat ? String.valueOf(getProgressFloat()) : String.valueOf(getProgress()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autoAdjustSection() {
        int i = 0;
        float f = 0.0f;
        while (i <= this.mSectionCount) {
            float f2 = this.mSectionOffset;
            f = (i * f2) + this.mLeft;
            float f3 = this.mThumbCenterX;
            if (f <= f3 && f3 - f <= f2) {
                break;
            }
            i++;
        }
        boolean z = BigDecimal.valueOf((double) this.mThumbCenterX).setScale(1, 4).floatValue() == f;
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator valueAnimator = null;
        if (!z) {
            float f4 = this.mThumbCenterX;
            float f5 = this.mSectionOffset;
            valueAnimator = f4 - f <= f5 / 2.0f ? ValueAnimator.ofFloat(f4, f) : ValueAnimator.ofFloat(f4, ((i + 1) * f5) + this.mLeft);
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xw.repo.BubbleSeekBar.6
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    BubbleSeekBar.this.mThumbCenterX = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    BubbleSeekBar bubbleSeekBar = BubbleSeekBar.this;
                    bubbleSeekBar.mProgress = bubbleSeekBar.calculateProgress();
                    if (!BubbleSeekBar.this.isHideBubble) {
                        BubbleSeekBar bubbleSeekBar2 = BubbleSeekBar.this;
                        bubbleSeekBar2.mBubbleCenterRawX = bubbleSeekBar2.calculateCenterRawXofBubbleView();
                        BubbleSeekBar.this.mLayoutParams.x = (int) (BubbleSeekBar.this.mBubbleCenterRawX + 0.5f);
                        if (BubbleSeekBar.this.mBubbleView.getParent() != null) {
                            BubbleSeekBar.this.mWindowManager.updateViewLayout(BubbleSeekBar.this.mBubbleView, BubbleSeekBar.this.mLayoutParams);
                        }
                        BubbleSeekBar.this.mBubbleView.setProgressText(BubbleSeekBar.this.isShowProgressInFloat ? String.valueOf(BubbleSeekBar.this.getProgressFloat()) : String.valueOf(BubbleSeekBar.this.getProgress()));
                    }
                    BubbleSeekBar.this.invalidate();
                    if (BubbleSeekBar.this.mProgressListener != null) {
                        OnProgressChangedListener onProgressChangedListener = BubbleSeekBar.this.mProgressListener;
                        BubbleSeekBar bubbleSeekBar3 = BubbleSeekBar.this;
                        onProgressChangedListener.onProgressChanged(bubbleSeekBar3, bubbleSeekBar3.getProgress(), BubbleSeekBar.this.getProgressFloat());
                    }
                }
            });
        }
        if (!this.isHideBubble) {
            BubbleView bubbleView = this.mBubbleView;
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = this.isAlwaysShowBubble ? 1.0f : 0.0f;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bubbleView, property, fArr);
            if (z) {
                animatorSet.setDuration(this.mAnimDuration).play(ofFloat);
            } else {
                animatorSet.setDuration(this.mAnimDuration).playTogether(valueAnimator, ofFloat);
            }
        } else if (!z) {
            animatorSet.setDuration(this.mAnimDuration).playTogether(valueAnimator);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.xw.repo.BubbleSeekBar.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!BubbleSeekBar.this.isHideBubble && !BubbleSeekBar.this.isAlwaysShowBubble) {
                    BubbleSeekBar.this.hideBubble();
                }
                BubbleSeekBar bubbleSeekBar = BubbleSeekBar.this;
                bubbleSeekBar.mProgress = bubbleSeekBar.calculateProgress();
                BubbleSeekBar.this.isThumbOnDragging = false;
                BubbleSeekBar.this.isTouchToSeekAnimEnd = true;
                BubbleSeekBar.this.invalidate();
                if (BubbleSeekBar.this.mProgressListener != null) {
                    OnProgressChangedListener onProgressChangedListener = BubbleSeekBar.this.mProgressListener;
                    BubbleSeekBar bubbleSeekBar2 = BubbleSeekBar.this;
                    onProgressChangedListener.getProgressOnFinally(bubbleSeekBar2, bubbleSeekBar2.getProgress(), BubbleSeekBar.this.getProgressFloat());
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (!BubbleSeekBar.this.isHideBubble && !BubbleSeekBar.this.isAlwaysShowBubble) {
                    BubbleSeekBar.this.hideBubble();
                }
                BubbleSeekBar bubbleSeekBar = BubbleSeekBar.this;
                bubbleSeekBar.mProgress = bubbleSeekBar.calculateProgress();
                BubbleSeekBar.this.isThumbOnDragging = false;
                BubbleSeekBar.this.isTouchToSeekAnimEnd = true;
                BubbleSeekBar.this.invalidate();
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideBubble() {
        BubbleView bubbleView = this.mBubbleView;
        if (bubbleView == null) {
            return;
        }
        bubbleView.setVisibility(8);
        if (this.mBubbleView.getParent() != null) {
            this.mWindowManager.removeViewImmediate(this.mBubbleView);
        }
    }

    private String float2String(float f) {
        return String.valueOf(formatFloat(f));
    }

    private float formatFloat(float f) {
        return BigDecimal.valueOf(f).setScale(1, 4).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float calculateCenterRawXofBubbleView() {
        if (this.isRtl) {
            return this.mBubbleCenterRawSolidX - ((this.mTrackLength * (this.mProgress - this.mMin)) / this.mDelta);
        }
        return this.mBubbleCenterRawSolidX + ((this.mTrackLength * (this.mProgress - this.mMin)) / this.mDelta);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float calculateProgress() {
        if (this.isRtl) {
            return (((this.mRight - this.mThumbCenterX) * this.mDelta) / this.mTrackLength) + this.mMin;
        }
        return (((this.mThumbCenterX - this.mLeft) * this.mDelta) / this.mTrackLength) + this.mMin;
    }

    public void correctOffsetWhenContainerOnScrolling() {
        if (this.isHideBubble) {
            return;
        }
        locatePositionOnScreen();
        if (this.mBubbleView.getParent() != null) {
            postInvalidate();
        }
    }

    public float getMin() {
        return this.mMin;
    }

    public float getMax() {
        return this.mMax;
    }

    public void setProgress(float f) {
        this.mProgress = f;
        OnProgressChangedListener onProgressChangedListener = this.mProgressListener;
        if (onProgressChangedListener != null) {
            onProgressChangedListener.onProgressChanged(this, getProgress(), getProgressFloat());
            this.mProgressListener.getProgressOnFinally(this, getProgress(), getProgressFloat());
        }
        if (!this.isHideBubble) {
            this.mBubbleCenterRawX = calculateCenterRawXofBubbleView();
        }
        if (this.isAlwaysShowBubble) {
            hideBubble();
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            postDelayed(new Runnable() { // from class: com.xw.repo.BubbleSeekBar.8
                @Override // java.lang.Runnable
                public void run() {
                    BubbleSeekBar.this.showBubble();
                    BubbleSeekBar.this.triggerBubbleShowing = true;
                }
            }, (iArr[0] == 0 && iArr[1] == 0) ? this.mAlwaysShowBubbleDelay : 0L);
        }
        postInvalidate();
    }

    public int getProgress() {
        if (this.isSeekBySection && this.triggerSeekBySection) {
            float f = this.mSectionValue;
            float f2 = f / 2.0f;
            float f3 = this.mProgress;
            float f4 = this.mPreSecValue;
            if (f3 >= f4) {
                if (f3 >= f2 + f4) {
                    this.mPreSecValue = f4 + f;
                    return Math.round(this.mPreSecValue);
                }
                return Math.round(f4);
            } else if (f3 >= f4 - f2) {
                return Math.round(f4);
            } else {
                this.mPreSecValue = f4 - f;
                return Math.round(this.mPreSecValue);
            }
        }
        return Math.round(this.mProgress);
    }

    public float getProgressFloat() {
        return formatFloat(this.mProgress);
    }

    public OnProgressChangedListener getOnProgressChangedListener() {
        return this.mProgressListener;
    }

    public void setOnProgressChangedListener(OnProgressChangedListener onProgressChangedListener) {
        this.mProgressListener = onProgressChangedListener;
    }

    public void setTrackColor(@ColorInt int i) {
        if (this.mTrackColor != i) {
            this.mTrackColor = i;
            invalidate();
        }
    }

    public void setSecondTrackColor(@ColorInt int i) {
        if (this.mSecondTrackColor != i) {
            this.mSecondTrackColor = i;
            invalidate();
        }
    }

    public void setThumbColor(@ColorInt int i) {
        if (this.mThumbColor != i) {
            this.mThumbColor = i;
            invalidate();
        }
    }

    public void setBubbleColor(@ColorInt int i) {
        if (this.mBubbleColor != i) {
            this.mBubbleColor = i;
            BubbleView bubbleView = this.mBubbleView;
            if (bubbleView != null) {
                bubbleView.invalidate();
            }
        }
    }

    public void setCustomSectionTextArray(@NonNull CustomSectionTextArray customSectionTextArray) {
        this.mSectionTextArray = customSectionTextArray.onCustomize(this.mSectionCount, this.mSectionTextArray);
        for (int i = 0; i <= this.mSectionCount; i++) {
            if (this.mSectionTextArray.get(i) == null) {
                this.mSectionTextArray.put(i, "");
            }
        }
        this.isShowThumbText = false;
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("save_instance", super.onSaveInstanceState());
        bundle.putFloat(NotificationCompat.CATEGORY_PROGRESS, this.mProgress);
        return bundle;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mProgress = bundle.getFloat(NotificationCompat.CATEGORY_PROGRESS);
            super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
            BubbleView bubbleView = this.mBubbleView;
            if (bubbleView != null) {
                bubbleView.setProgressText(this.isShowProgressInFloat ? String.valueOf(getProgressFloat()) : String.valueOf(getProgress()));
            }
            setProgress(this.mProgress);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xw.repo.BubbleSeekBar$BubbleView */
    /* loaded from: classes2.dex */
    public class BubbleView extends View {
        private Paint mBubblePaint;
        private Path mBubblePath;
        private RectF mBubbleRectF;
        private String mProgressText;
        private Rect mRect;

        BubbleView(BubbleSeekBar bubbleSeekBar, Context context) {
            this(bubbleSeekBar, context, null);
        }

        BubbleView(BubbleSeekBar bubbleSeekBar, Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        BubbleView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.mProgressText = "";
            this.mBubblePaint = new Paint();
            this.mBubblePaint.setAntiAlias(true);
            this.mBubblePaint.setTextAlign(Paint.Align.CENTER);
            this.mBubblePath = new Path();
            this.mBubbleRectF = new RectF();
            this.mRect = new Rect();
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            setMeasuredDimension(BubbleSeekBar.this.mBubbleRadius * 3, BubbleSeekBar.this.mBubbleRadius * 3);
            this.mBubbleRectF.set((getMeasuredWidth() / 2.0f) - BubbleSeekBar.this.mBubbleRadius, 0.0f, (getMeasuredWidth() / 2.0f) + BubbleSeekBar.this.mBubbleRadius, BubbleSeekBar.this.mBubbleRadius * 2);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            this.mBubblePath.reset();
            float measuredWidth = getMeasuredWidth() / 2.0f;
            float measuredHeight = getMeasuredHeight() - (BubbleSeekBar.this.mBubbleRadius / 3.0f);
            this.mBubblePath.moveTo(measuredWidth, measuredHeight);
            float measuredWidth2 = (float) ((getMeasuredWidth() / 2.0f) - ((Math.sqrt(3.0d) / 2.0d) * BubbleSeekBar.this.mBubbleRadius));
            float f = BubbleSeekBar.this.mBubbleRadius * 1.5f;
            this.mBubblePath.quadTo(measuredWidth2 - BubbleUtils.dp2px(2), f - BubbleUtils.dp2px(2), measuredWidth2, f);
            this.mBubblePath.arcTo(this.mBubbleRectF, 150.0f, 240.0f);
            this.mBubblePath.quadTo(((float) ((getMeasuredWidth() / 2.0f) + ((Math.sqrt(3.0d) / 2.0d) * BubbleSeekBar.this.mBubbleRadius))) + BubbleUtils.dp2px(2), f - BubbleUtils.dp2px(2), measuredWidth, measuredHeight);
            this.mBubblePath.close();
            this.mBubblePaint.setColor(BubbleSeekBar.this.mBubbleColor);
            canvas.drawPath(this.mBubblePath, this.mBubblePaint);
            this.mBubblePaint.setTextSize(BubbleSeekBar.this.mBubbleTextSize);
            this.mBubblePaint.setColor(BubbleSeekBar.this.mBubbleTextColor);
            Paint paint = this.mBubblePaint;
            String str = this.mProgressText;
            paint.getTextBounds(str, 0, str.length(), this.mRect);
            Paint.FontMetrics fontMetrics = this.mBubblePaint.getFontMetrics();
            canvas.drawText(this.mProgressText, getMeasuredWidth() / 2.0f, (BubbleSeekBar.this.mBubbleRadius + ((fontMetrics.descent - fontMetrics.ascent) / 2.0f)) - fontMetrics.descent, this.mBubblePaint);
        }

        void setProgressText(String str) {
            if (str == null || this.mProgressText.equals(str)) {
                return;
            }
            this.mProgressText = str;
            invalidate();
        }
    }
}
