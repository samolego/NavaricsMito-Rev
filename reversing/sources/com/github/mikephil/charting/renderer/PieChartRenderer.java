package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.p008v4.view.ViewCompat;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class PieChartRenderer extends DataRenderer {
    protected Canvas mBitmapCanvas;
    private RectF mCenterTextLastBounds;
    private CharSequence mCenterTextLastValue;
    private StaticLayout mCenterTextLayout;
    private TextPaint mCenterTextPaint;
    protected PieChart mChart;
    protected WeakReference<Bitmap> mDrawBitmap;
    protected Path mDrawCenterTextPathBuffer;
    protected RectF mDrawHighlightedRectF;
    private Paint mEntryLabelsPaint;
    private Path mHoleCirclePath;
    protected Paint mHolePaint;
    private RectF mInnerRectBuffer;
    private Path mPathBuffer;
    private RectF[] mRectBuffer;
    protected Paint mTransparentCirclePaint;
    protected Paint mValueLinePaint;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    public PieChartRenderer(PieChart pieChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mCenterTextLastBounds = new RectF();
        this.mRectBuffer = new RectF[]{new RectF(), new RectF(), new RectF()};
        this.mPathBuffer = new Path();
        this.mInnerRectBuffer = new RectF();
        this.mHoleCirclePath = new Path();
        this.mDrawCenterTextPathBuffer = new Path();
        this.mDrawHighlightedRectF = new RectF();
        this.mChart = pieChart;
        this.mHolePaint = new Paint(1);
        this.mHolePaint.setColor(-1);
        this.mHolePaint.setStyle(Paint.Style.FILL);
        this.mTransparentCirclePaint = new Paint(1);
        this.mTransparentCirclePaint.setColor(-1);
        this.mTransparentCirclePaint.setStyle(Paint.Style.FILL);
        this.mTransparentCirclePaint.setAlpha(105);
        this.mCenterTextPaint = new TextPaint(1);
        this.mCenterTextPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mCenterTextPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        this.mValuePaint.setTextSize(Utils.convertDpToPixel(13.0f));
        this.mValuePaint.setColor(-1);
        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
        this.mEntryLabelsPaint = new Paint(1);
        this.mEntryLabelsPaint.setColor(-1);
        this.mEntryLabelsPaint.setTextAlign(Paint.Align.CENTER);
        this.mEntryLabelsPaint.setTextSize(Utils.convertDpToPixel(13.0f));
        this.mValueLinePaint = new Paint(1);
        this.mValueLinePaint.setStyle(Paint.Style.STROKE);
    }

    public Paint getPaintHole() {
        return this.mHolePaint;
    }

    public Paint getPaintTransparentCircle() {
        return this.mTransparentCirclePaint;
    }

    public TextPaint getPaintCenterText() {
        return this.mCenterTextPaint;
    }

    public Paint getPaintEntryLabels() {
        return this.mEntryLabelsPaint;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        int chartWidth = (int) this.mViewPortHandler.getChartWidth();
        int chartHeight = (int) this.mViewPortHandler.getChartHeight();
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        if (weakReference == null || weakReference.get().getWidth() != chartWidth || this.mDrawBitmap.get().getHeight() != chartHeight) {
            if (chartWidth <= 0 || chartHeight <= 0) {
                return;
            }
            this.mDrawBitmap = new WeakReference<>(Bitmap.createBitmap(chartWidth, chartHeight, Bitmap.Config.ARGB_4444));
            this.mBitmapCanvas = new Canvas(this.mDrawBitmap.get());
        }
        this.mDrawBitmap.get().eraseColor(0);
        for (IPieDataSet iPieDataSet : ((PieData) this.mChart.getData()).getDataSets()) {
            if (iPieDataSet.isVisible() && iPieDataSet.getEntryCount() > 0) {
                drawDataSet(canvas, iPieDataSet);
            }
        }
    }

    protected float calculateMinimumRadiusForSpacedSlice(MPPointF mPPointF, float f, float f2, float f3, float f4, float f5, float f6) {
        double d = (f5 + f6) * 0.017453292f;
        float cos = mPPointF.f2600x + (((float) Math.cos(d)) * f);
        float sin = mPPointF.f2601y + (((float) Math.sin(d)) * f);
        double d2 = (f5 + (f6 / 2.0f)) * 0.017453292f;
        return (float) ((f - ((float) ((Math.sqrt(Math.pow(cos - f3, 2.0d) + Math.pow(sin - f4, 2.0d)) / 2.0d) * Math.tan(((180.0d - f2) / 2.0d) * 0.017453292519943295d)))) - Math.sqrt(Math.pow((mPPointF.f2600x + (((float) Math.cos(d2)) * f)) - ((cos + f3) / 2.0f), 2.0d) + Math.pow((mPPointF.f2601y + (((float) Math.sin(d2)) * f)) - ((sin + f4) / 2.0f), 2.0d)));
    }

    protected float getSliceSpace(IPieDataSet iPieDataSet) {
        if (!iPieDataSet.isAutomaticallyDisableSliceSpacingEnabled()) {
            return iPieDataSet.getSliceSpace();
        }
        if (iPieDataSet.getSliceSpace() / this.mViewPortHandler.getSmallestContentExtension() > (iPieDataSet.getYMin() / ((PieData) this.mChart.getData()).getYValueSum()) * 2.0f) {
            return 0.0f;
        }
        return iPieDataSet.getSliceSpace();
    }

    protected void drawDataSet(Canvas canvas, IPieDataSet iPieDataSet) {
        int i;
        float f;
        float f2;
        float f3;
        RectF rectF;
        int i2;
        float[] fArr;
        int i3;
        float f4;
        MPPointF mPPointF;
        float f5;
        float f6;
        MPPointF mPPointF2;
        float f7;
        int i4;
        PieChartRenderer pieChartRenderer = this;
        IPieDataSet iPieDataSet2 = iPieDataSet;
        float rotationAngle = pieChartRenderer.mChart.getRotationAngle();
        float phaseX = pieChartRenderer.mAnimator.getPhaseX();
        float phaseY = pieChartRenderer.mAnimator.getPhaseY();
        RectF circleBox = pieChartRenderer.mChart.getCircleBox();
        int entryCount = iPieDataSet.getEntryCount();
        float[] drawAngles = pieChartRenderer.mChart.getDrawAngles();
        MPPointF centerCircleBox = pieChartRenderer.mChart.getCenterCircleBox();
        float radius = pieChartRenderer.mChart.getRadius();
        boolean z = pieChartRenderer.mChart.isDrawHoleEnabled() && !pieChartRenderer.mChart.isDrawSlicesUnderHoleEnabled();
        float holeRadius = z ? (pieChartRenderer.mChart.getHoleRadius() / 100.0f) * radius : 0.0f;
        int i5 = 0;
        for (int i6 = 0; i6 < entryCount; i6++) {
            if (Math.abs(iPieDataSet2.getEntryForIndex(i6).getY()) > Utils.FLOAT_EPSILON) {
                i5++;
            }
        }
        float sliceSpace = i5 <= 1 ? 0.0f : pieChartRenderer.getSliceSpace(iPieDataSet2);
        int i7 = 0;
        float f8 = 0.0f;
        while (i7 < entryCount) {
            float f9 = drawAngles[i7];
            if (Math.abs(iPieDataSet2.getEntryForIndex(i7).getY()) <= Utils.FLOAT_EPSILON) {
                i = i7;
                f = radius;
                f2 = rotationAngle;
                f3 = phaseX;
                rectF = circleBox;
                i2 = entryCount;
                fArr = drawAngles;
                i3 = i5;
                f4 = holeRadius;
                mPPointF = centerCircleBox;
            } else if (pieChartRenderer.mChart.needsHighlight(i7)) {
                i = i7;
                f = radius;
                f2 = rotationAngle;
                f3 = phaseX;
                rectF = circleBox;
                i2 = entryCount;
                fArr = drawAngles;
                i3 = i5;
                f4 = holeRadius;
                mPPointF = centerCircleBox;
            } else {
                boolean z2 = sliceSpace > 0.0f && f9 <= 180.0f;
                pieChartRenderer.mRenderPaint.setColor(iPieDataSet2.getColor(i7));
                float f10 = i5 == 1 ? 0.0f : sliceSpace / (radius * 0.017453292f);
                float f11 = rotationAngle + ((f8 + (f10 / 2.0f)) * phaseY);
                float f12 = (f9 - f10) * phaseY;
                if (f12 < 0.0f) {
                    f12 = 0.0f;
                }
                pieChartRenderer.mPathBuffer.reset();
                int i8 = i7;
                int i9 = i5;
                double d = f11 * 0.017453292f;
                i2 = entryCount;
                fArr = drawAngles;
                float cos = centerCircleBox.f2600x + (((float) Math.cos(d)) * radius);
                float sin = centerCircleBox.f2601y + (((float) Math.sin(d)) * radius);
                int i10 = (f12 > 360.0f ? 1 : (f12 == 360.0f ? 0 : -1));
                if (i10 >= 0 && f12 % 360.0f <= Utils.FLOAT_EPSILON) {
                    f3 = phaseX;
                    pieChartRenderer.mPathBuffer.addCircle(centerCircleBox.f2600x, centerCircleBox.f2601y, radius, Path.Direction.CW);
                } else {
                    f3 = phaseX;
                    pieChartRenderer.mPathBuffer.moveTo(cos, sin);
                    pieChartRenderer.mPathBuffer.arcTo(circleBox, f11, f12);
                }
                float f13 = f12;
                pieChartRenderer.mInnerRectBuffer.set(centerCircleBox.f2600x - holeRadius, centerCircleBox.f2601y - holeRadius, centerCircleBox.f2600x + holeRadius, centerCircleBox.f2601y + holeRadius);
                if (!z) {
                    f4 = holeRadius;
                    f2 = rotationAngle;
                    f5 = f13;
                    f = radius;
                    mPPointF = centerCircleBox;
                    rectF = circleBox;
                    i3 = i9;
                    i = i8;
                    f6 = 360.0f;
                } else if (holeRadius > 0.0f || z2) {
                    if (z2) {
                        f7 = f13;
                        rectF = circleBox;
                        i3 = i9;
                        i = i8;
                        f4 = holeRadius;
                        i4 = 1;
                        f = radius;
                        mPPointF2 = centerCircleBox;
                        float calculateMinimumRadiusForSpacedSlice = calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f9 * phaseY, cos, sin, f11, f7);
                        if (calculateMinimumRadiusForSpacedSlice < 0.0f) {
                            calculateMinimumRadiusForSpacedSlice = -calculateMinimumRadiusForSpacedSlice;
                        }
                        holeRadius = Math.max(f4, calculateMinimumRadiusForSpacedSlice);
                    } else {
                        f4 = holeRadius;
                        mPPointF2 = centerCircleBox;
                        f7 = f13;
                        i4 = 1;
                        f = radius;
                        rectF = circleBox;
                        i3 = i9;
                        i = i8;
                    }
                    float f14 = (i3 == i4 || holeRadius == 0.0f) ? 0.0f : sliceSpace / (holeRadius * 0.017453292f);
                    float f15 = ((f8 + (f14 / 2.0f)) * phaseY) + rotationAngle;
                    float f16 = (f9 - f14) * phaseY;
                    if (f16 < 0.0f) {
                        f16 = 0.0f;
                    }
                    float f17 = f15 + f16;
                    if (i10 >= 0 && f7 % 360.0f <= Utils.FLOAT_EPSILON) {
                        pieChartRenderer = this;
                        pieChartRenderer.mPathBuffer.addCircle(mPPointF2.f2600x, mPPointF2.f2601y, holeRadius, Path.Direction.CCW);
                        f2 = rotationAngle;
                    } else {
                        pieChartRenderer = this;
                        double d2 = f17 * 0.017453292f;
                        f2 = rotationAngle;
                        pieChartRenderer.mPathBuffer.lineTo(mPPointF2.f2600x + (((float) Math.cos(d2)) * holeRadius), mPPointF2.f2601y + (holeRadius * ((float) Math.sin(d2))));
                        pieChartRenderer.mPathBuffer.arcTo(pieChartRenderer.mInnerRectBuffer, f17, -f16);
                    }
                    mPPointF = mPPointF2;
                    pieChartRenderer.mPathBuffer.close();
                    pieChartRenderer.mBitmapCanvas.drawPath(pieChartRenderer.mPathBuffer, pieChartRenderer.mRenderPaint);
                } else {
                    f4 = holeRadius;
                    f2 = rotationAngle;
                    f5 = f13;
                    f6 = 360.0f;
                    f = radius;
                    mPPointF = centerCircleBox;
                    rectF = circleBox;
                    i3 = i9;
                    i = i8;
                }
                if (f5 % f6 > Utils.FLOAT_EPSILON) {
                    if (z2) {
                        float calculateMinimumRadiusForSpacedSlice2 = calculateMinimumRadiusForSpacedSlice(mPPointF, f, f9 * phaseY, cos, sin, f11, f5);
                        double d3 = (f11 + (f5 / 2.0f)) * 0.017453292f;
                        pieChartRenderer.mPathBuffer.lineTo(mPPointF.f2600x + (((float) Math.cos(d3)) * calculateMinimumRadiusForSpacedSlice2), mPPointF.f2601y + (calculateMinimumRadiusForSpacedSlice2 * ((float) Math.sin(d3))));
                    } else {
                        pieChartRenderer.mPathBuffer.lineTo(mPPointF.f2600x, mPPointF.f2601y);
                    }
                }
                pieChartRenderer.mPathBuffer.close();
                pieChartRenderer.mBitmapCanvas.drawPath(pieChartRenderer.mPathBuffer, pieChartRenderer.mRenderPaint);
            }
            f8 += f9 * f3;
            i7 = i + 1;
            centerCircleBox = mPPointF;
            i5 = i3;
            holeRadius = f4;
            circleBox = rectF;
            entryCount = i2;
            drawAngles = fArr;
            phaseX = f3;
            radius = f;
            iPieDataSet2 = iPieDataSet;
            rotationAngle = f2;
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02d3  */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void drawValues(android.graphics.Canvas r53) {
        /*
            Method dump skipped, instructions count: 1006
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.PieChartRenderer.drawValues(android.graphics.Canvas):void");
    }

    protected void drawEntryLabel(Canvas canvas, String str, float f, float f2) {
        canvas.drawText(str, f, f2, this.mEntryLabelsPaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
        drawHole(canvas);
        canvas.drawBitmap(this.mDrawBitmap.get(), 0.0f, 0.0f, (Paint) null);
        drawCenterText(canvas);
    }

    protected void drawHole(Canvas canvas) {
        if (!this.mChart.isDrawHoleEnabled() || this.mBitmapCanvas == null) {
            return;
        }
        float radius = this.mChart.getRadius();
        float holeRadius = (this.mChart.getHoleRadius() / 100.0f) * radius;
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        if (Color.alpha(this.mHolePaint.getColor()) > 0) {
            this.mBitmapCanvas.drawCircle(centerCircleBox.f2600x, centerCircleBox.f2601y, holeRadius, this.mHolePaint);
        }
        if (Color.alpha(this.mTransparentCirclePaint.getColor()) > 0 && this.mChart.getTransparentCircleRadius() > this.mChart.getHoleRadius()) {
            int alpha = this.mTransparentCirclePaint.getAlpha();
            float transparentCircleRadius = radius * (this.mChart.getTransparentCircleRadius() / 100.0f);
            this.mTransparentCirclePaint.setAlpha((int) (alpha * this.mAnimator.getPhaseX() * this.mAnimator.getPhaseY()));
            this.mHoleCirclePath.reset();
            this.mHoleCirclePath.addCircle(centerCircleBox.f2600x, centerCircleBox.f2601y, transparentCircleRadius, Path.Direction.CW);
            this.mHoleCirclePath.addCircle(centerCircleBox.f2600x, centerCircleBox.f2601y, holeRadius, Path.Direction.CCW);
            this.mBitmapCanvas.drawPath(this.mHoleCirclePath, this.mTransparentCirclePaint);
            this.mTransparentCirclePaint.setAlpha(alpha);
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    protected void drawCenterText(Canvas canvas) {
        float radius;
        MPPointF mPPointF;
        CharSequence centerText = this.mChart.getCenterText();
        if (!this.mChart.isDrawCenterTextEnabled() || centerText == null) {
            return;
        }
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        MPPointF centerTextOffset = this.mChart.getCenterTextOffset();
        float f = centerCircleBox.f2600x + centerTextOffset.f2600x;
        float f2 = centerCircleBox.f2601y + centerTextOffset.f2601y;
        if (this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled()) {
            radius = this.mChart.getRadius() * (this.mChart.getHoleRadius() / 100.0f);
        } else {
            radius = this.mChart.getRadius();
        }
        RectF[] rectFArr = this.mRectBuffer;
        RectF rectF = rectFArr[0];
        rectF.left = f - radius;
        rectF.top = f2 - radius;
        rectF.right = f + radius;
        rectF.bottom = f2 + radius;
        RectF rectF2 = rectFArr[1];
        rectF2.set(rectF);
        float centerTextRadiusPercent = this.mChart.getCenterTextRadiusPercent() / 100.0f;
        if (centerTextRadiusPercent > Utils.DOUBLE_EPSILON) {
            rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (rectF2.height() * centerTextRadiusPercent)) / 2.0f);
        }
        if (centerText.equals(this.mCenterTextLastValue) && rectF2.equals(this.mCenterTextLastBounds)) {
            mPPointF = centerTextOffset;
        } else {
            this.mCenterTextLastBounds.set(rectF2);
            this.mCenterTextLastValue = centerText;
            mPPointF = centerTextOffset;
            this.mCenterTextLayout = new StaticLayout(centerText, 0, centerText.length(), this.mCenterTextPaint, (int) Math.max(Math.ceil(this.mCenterTextLastBounds.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        }
        float height = this.mCenterTextLayout.getHeight();
        canvas.save();
        if (Build.VERSION.SDK_INT >= 18) {
            Path path = this.mDrawCenterTextPathBuffer;
            path.reset();
            path.addOval(rectF, Path.Direction.CW);
            canvas.clipPath(path);
        }
        canvas.translate(rectF2.left, rectF2.top + ((rectF2.height() - height) / 2.0f));
        this.mCenterTextLayout.draw(canvas);
        canvas.restore();
        MPPointF.recycleInstance(centerCircleBox);
        MPPointF.recycleInstance(mPPointF);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        int i;
        RectF rectF;
        float f;
        float f2;
        float[] fArr;
        float[] fArr2;
        float f3;
        int i2;
        float f4;
        float f5;
        int i3;
        int i4;
        float f6;
        float f7;
        float f8;
        Highlight[] highlightArr2 = highlightArr;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float rotationAngle = this.mChart.getRotationAngle();
        float[] drawAngles = this.mChart.getDrawAngles();
        float[] absoluteAngles = this.mChart.getAbsoluteAngles();
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        boolean z = this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled();
        float holeRadius = z ? (this.mChart.getHoleRadius() / 100.0f) * radius : 0.0f;
        RectF rectF2 = this.mDrawHighlightedRectF;
        rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i5 = 0;
        while (i5 < highlightArr2.length) {
            int x = (int) highlightArr2[i5].getX();
            if (x >= drawAngles.length) {
                i = i5;
                rectF = rectF2;
                f = holeRadius;
                f2 = phaseX;
                fArr = drawAngles;
                fArr2 = absoluteAngles;
            } else {
                IPieDataSet dataSetByIndex = ((PieData) this.mChart.getData()).getDataSetByIndex(highlightArr2[i5].getDataSetIndex());
                if (dataSetByIndex == null) {
                    i = i5;
                    rectF = rectF2;
                    f = holeRadius;
                    f2 = phaseX;
                    fArr = drawAngles;
                    fArr2 = absoluteAngles;
                } else if (dataSetByIndex.isHighlightEnabled()) {
                    int entryCount = dataSetByIndex.getEntryCount();
                    int i6 = 0;
                    for (int i7 = 0; i7 < entryCount; i7++) {
                        if (Math.abs(dataSetByIndex.getEntryForIndex(i7).getY()) > Utils.FLOAT_EPSILON) {
                            i6++;
                        }
                    }
                    if (x == 0) {
                        i2 = 1;
                        f3 = 0.0f;
                    } else {
                        f3 = absoluteAngles[x - 1] * phaseX;
                        i2 = 1;
                    }
                    float sliceSpace = i6 <= i2 ? 0.0f : dataSetByIndex.getSliceSpace();
                    float f9 = drawAngles[x];
                    float selectionShift = dataSetByIndex.getSelectionShift();
                    float f10 = radius + selectionShift;
                    int i8 = i5;
                    rectF2.set(this.mChart.getCircleBox());
                    float f11 = -selectionShift;
                    rectF2.inset(f11, f11);
                    boolean z2 = sliceSpace > 0.0f && f9 <= 180.0f;
                    this.mRenderPaint.setColor(dataSetByIndex.getColor(x));
                    float f12 = i6 == 1 ? 0.0f : sliceSpace / (radius * 0.017453292f);
                    float f13 = i6 == 1 ? 0.0f : sliceSpace / (f10 * 0.017453292f);
                    float f14 = rotationAngle + ((f3 + (f12 / 2.0f)) * phaseY);
                    float f15 = (f9 - f12) * phaseY;
                    float f16 = f15 < 0.0f ? 0.0f : f15;
                    float f17 = ((f3 + (f13 / 2.0f)) * phaseY) + rotationAngle;
                    float f18 = (f9 - f13) * phaseY;
                    if (f18 < 0.0f) {
                        f18 = 0.0f;
                    }
                    this.mPathBuffer.reset();
                    int i9 = (f16 > 360.0f ? 1 : (f16 == 360.0f ? 0 : -1));
                    if (i9 >= 0 && f16 % 360.0f <= Utils.FLOAT_EPSILON) {
                        this.mPathBuffer.addCircle(centerCircleBox.f2600x, centerCircleBox.f2601y, f10, Path.Direction.CW);
                        f4 = holeRadius;
                        f2 = phaseX;
                        fArr = drawAngles;
                        fArr2 = absoluteAngles;
                    } else {
                        f4 = holeRadius;
                        f2 = phaseX;
                        double d = f17 * 0.017453292f;
                        fArr = drawAngles;
                        fArr2 = absoluteAngles;
                        this.mPathBuffer.moveTo(centerCircleBox.f2600x + (((float) Math.cos(d)) * f10), centerCircleBox.f2601y + (f10 * ((float) Math.sin(d))));
                        this.mPathBuffer.arcTo(rectF2, f17, f18);
                    }
                    if (z2) {
                        double d2 = f14 * 0.017453292f;
                        i = i8;
                        f5 = f4;
                        f6 = 0.0f;
                        i3 = i6;
                        rectF = rectF2;
                        i4 = 1;
                        f7 = calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f9 * phaseY, (((float) Math.cos(d2)) * radius) + centerCircleBox.f2600x, centerCircleBox.f2601y + (((float) Math.sin(d2)) * radius), f14, f16);
                    } else {
                        f5 = f4;
                        rectF = rectF2;
                        i3 = i6;
                        i = i8;
                        i4 = 1;
                        f6 = 0.0f;
                        f7 = 0.0f;
                    }
                    this.mInnerRectBuffer.set(centerCircleBox.f2600x - f5, centerCircleBox.f2601y - f5, centerCircleBox.f2600x + f5, centerCircleBox.f2601y + f5);
                    if (z && (f5 > f6 || z2)) {
                        if (z2) {
                            if (f7 < f6) {
                                f7 = -f7;
                            }
                            f8 = Math.max(f5, f7);
                        } else {
                            f8 = f5;
                        }
                        float f19 = (i3 == i4 || f8 == f6) ? 0.0f : sliceSpace / (f8 * 0.017453292f);
                        float f20 = rotationAngle + ((f3 + (f19 / 2.0f)) * phaseY);
                        float f21 = (f9 - f19) * phaseY;
                        if (f21 < f6) {
                            f21 = 0.0f;
                        }
                        float f22 = f20 + f21;
                        if (i9 >= 0 && f16 % 360.0f <= Utils.FLOAT_EPSILON) {
                            this.mPathBuffer.addCircle(centerCircleBox.f2600x, centerCircleBox.f2601y, f8, Path.Direction.CCW);
                            f = f5;
                        } else {
                            double d3 = f22 * 0.017453292f;
                            f = f5;
                            this.mPathBuffer.lineTo(centerCircleBox.f2600x + (((float) Math.cos(d3)) * f8), centerCircleBox.f2601y + (f8 * ((float) Math.sin(d3))));
                            this.mPathBuffer.arcTo(this.mInnerRectBuffer, f22, -f21);
                        }
                    } else {
                        f = f5;
                        if (f16 % 360.0f > Utils.FLOAT_EPSILON) {
                            if (z2) {
                                double d4 = (f14 + (f16 / 2.0f)) * 0.017453292f;
                                this.mPathBuffer.lineTo(centerCircleBox.f2600x + (((float) Math.cos(d4)) * f7), centerCircleBox.f2601y + (f7 * ((float) Math.sin(d4))));
                            } else {
                                this.mPathBuffer.lineTo(centerCircleBox.f2600x, centerCircleBox.f2601y);
                            }
                        }
                    }
                    this.mPathBuffer.close();
                    this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
                } else {
                    i = i5;
                    rectF = rectF2;
                    f = holeRadius;
                    f2 = phaseX;
                    fArr = drawAngles;
                    fArr2 = absoluteAngles;
                }
            }
            i5 = i + 1;
            rectF2 = rectF;
            holeRadius = f;
            phaseX = f2;
            drawAngles = fArr;
            absoluteAngles = fArr2;
            highlightArr2 = highlightArr;
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    protected void drawRoundedSlices(Canvas canvas) {
        float f;
        float[] fArr;
        float f2;
        if (this.mChart.isDrawRoundedSlicesEnabled()) {
            IPieDataSet dataSet = ((PieData) this.mChart.getData()).getDataSet();
            if (dataSet.isVisible()) {
                float phaseX = this.mAnimator.getPhaseX();
                float phaseY = this.mAnimator.getPhaseY();
                MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
                float radius = this.mChart.getRadius();
                float holeRadius = (radius - ((this.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
                float[] drawAngles = this.mChart.getDrawAngles();
                float rotationAngle = this.mChart.getRotationAngle();
                int i = 0;
                while (i < dataSet.getEntryCount()) {
                    float f3 = drawAngles[i];
                    if (Math.abs(dataSet.getEntryForIndex(i).getY()) > Utils.FLOAT_EPSILON) {
                        double d = radius - holeRadius;
                        double d2 = (rotationAngle + f3) * phaseY;
                        f = phaseY;
                        fArr = drawAngles;
                        f2 = rotationAngle;
                        float cos = (float) (centerCircleBox.f2600x + (Math.cos(Math.toRadians(d2)) * d));
                        float sin = (float) ((d * Math.sin(Math.toRadians(d2))) + centerCircleBox.f2601y);
                        this.mRenderPaint.setColor(dataSet.getColor(i));
                        this.mBitmapCanvas.drawCircle(cos, sin, holeRadius, this.mRenderPaint);
                    } else {
                        f = phaseY;
                        fArr = drawAngles;
                        f2 = rotationAngle;
                    }
                    rotationAngle = f2 + (f3 * phaseX);
                    i++;
                    phaseY = f;
                    drawAngles = fArr;
                }
                MPPointF.recycleInstance(centerCircleBox);
            }
        }
    }

    public void releaseBitmap() {
        Canvas canvas = this.mBitmapCanvas;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.mBitmapCanvas = null;
        }
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        if (weakReference != null) {
            weakReference.get().recycle();
            this.mDrawBitmap.clear();
            this.mDrawBitmap = null;
        }
    }
}
