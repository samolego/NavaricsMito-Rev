package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: classes.dex */
public class BarChartRenderer extends BarLineScatterCandleBubbleRenderer {
    protected Paint mBarBorderPaint;
    protected BarBuffer[] mBarBuffers;
    protected RectF mBarRect;
    private RectF mBarShadowRectBuffer;
    protected BarDataProvider mChart;
    protected Paint mShadowPaint;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }

    public BarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mBarRect = new RectF();
        this.mBarShadowRectBuffer = new RectF();
        this.mChart = barDataProvider;
        this.mHighlightPaint = new Paint(1);
        this.mHighlightPaint.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setColor(Color.rgb(0, 0, 0));
        this.mHighlightPaint.setAlpha(120);
        this.mShadowPaint = new Paint(1);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mBarBorderPaint = new Paint(1);
        this.mBarBorderPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new BarBuffer[barData.getDataSetCount()];
        for (int i = 0; i < this.mBarBuffers.length; i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            this.mBarBuffers[i] = new BarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        BarData barData = this.mChart.getBarData();
        for (int i = 0; i < barData.getDataSetCount(); i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            if (iBarDataSet.isVisible()) {
                drawDataSet(canvas, iBarDataSet, i);
            }
        }
    }

    protected void drawDataSet(Canvas canvas, IBarDataSet iBarDataSet, int i) {
        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
        this.mBarBorderPaint.setColor(iBarDataSet.getBarBorderColor());
        this.mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(iBarDataSet.getBarBorderWidth()));
        boolean z = iBarDataSet.getBarBorderWidth() > 0.0f;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        if (this.mChart.isDrawBarShadowEnabled()) {
            this.mShadowPaint.setColor(iBarDataSet.getBarShadowColor());
            float barWidth = this.mChart.getBarData().getBarWidth() / 2.0f;
            int min = Math.min((int) Math.ceil(iBarDataSet.getEntryCount() * phaseX), iBarDataSet.getEntryCount());
            for (int i2 = 0; i2 < min; i2++) {
                float x = ((BarEntry) iBarDataSet.getEntryForIndex(i2)).getX();
                RectF rectF = this.mBarShadowRectBuffer;
                rectF.left = x - barWidth;
                rectF.right = x + barWidth;
                transformer.rectValueToPixel(rectF);
                if (this.mViewPortHandler.isInBoundsLeft(this.mBarShadowRectBuffer.right)) {
                    if (!this.mViewPortHandler.isInBoundsRight(this.mBarShadowRectBuffer.left)) {
                        break;
                    }
                    this.mBarShadowRectBuffer.top = this.mViewPortHandler.contentTop();
                    this.mBarShadowRectBuffer.bottom = this.mViewPortHandler.contentBottom();
                    canvas.drawRect(this.mBarShadowRectBuffer, this.mShadowPaint);
                }
            }
        }
        BarBuffer barBuffer = this.mBarBuffers[i];
        barBuffer.setPhases(phaseX, phaseY);
        barBuffer.setDataSet(i);
        barBuffer.setInverted(this.mChart.isInverted(iBarDataSet.getAxisDependency()));
        barBuffer.setBarWidth(this.mChart.getBarData().getBarWidth());
        barBuffer.feed(iBarDataSet);
        transformer.pointValuesToPixel(barBuffer.buffer);
        boolean z2 = iBarDataSet.getColors().size() == 1;
        if (z2) {
            this.mRenderPaint.setColor(iBarDataSet.getColor());
        }
        for (int i3 = 0; i3 < barBuffer.size(); i3 += 4) {
            int i4 = i3 + 2;
            if (this.mViewPortHandler.isInBoundsLeft(barBuffer.buffer[i4])) {
                if (!this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[i3])) {
                    return;
                }
                if (!z2) {
                    this.mRenderPaint.setColor(iBarDataSet.getColor(i3 / 4));
                }
                int i5 = i3 + 1;
                int i6 = i3 + 3;
                canvas.drawRect(barBuffer.buffer[i3], barBuffer.buffer[i5], barBuffer.buffer[i4], barBuffer.buffer[i6], this.mRenderPaint);
                if (z) {
                    canvas.drawRect(barBuffer.buffer[i3], barBuffer.buffer[i5], barBuffer.buffer[i4], barBuffer.buffer[i6], this.mBarBorderPaint);
                }
            }
        }
    }

    protected void prepareBarHighlight(float f, float f2, float f3, float f4, Transformer transformer) {
        this.mBarRect.set(f - f4, f2, f + f4, f3);
        transformer.rectToPixelPhase(this.mBarRect, this.mAnimator.getPhaseY());
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        float f;
        float f2;
        MPPointF mPPointF;
        List list;
        float f3;
        boolean z;
        int i;
        float f4;
        boolean z2;
        float[] fArr;
        Transformer transformer;
        int i2;
        float[] fArr2;
        float f5;
        float f6;
        float f7;
        int i3;
        MPPointF mPPointF2;
        List list2;
        BarBuffer barBuffer;
        float f8;
        if (isDrawingValuesAllowed(this.mChart)) {
            List dataSets = this.mChart.getBarData().getDataSets();
            float convertDpToPixel = Utils.convertDpToPixel(4.5f);
            boolean isDrawValueAboveBarEnabled = this.mChart.isDrawValueAboveBarEnabled();
            int i4 = 0;
            while (i4 < this.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i4);
                if (shouldDrawValues(iBarDataSet)) {
                    applyValueTextStyle(iBarDataSet);
                    boolean isInverted = this.mChart.isInverted(iBarDataSet.getAxisDependency());
                    float calcTextHeight = Utils.calcTextHeight(this.mValuePaint, "8");
                    float f9 = isDrawValueAboveBarEnabled ? -convertDpToPixel : calcTextHeight + convertDpToPixel;
                    float f10 = isDrawValueAboveBarEnabled ? calcTextHeight + convertDpToPixel : -convertDpToPixel;
                    if (isInverted) {
                        f = (-f9) - calcTextHeight;
                        f2 = (-f10) - calcTextHeight;
                    } else {
                        f = f9;
                        f2 = f10;
                    }
                    BarBuffer barBuffer2 = this.mBarBuffers[i4];
                    float phaseY = this.mAnimator.getPhaseY();
                    MPPointF mPPointF3 = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    mPPointF3.f2600x = Utils.convertDpToPixel(mPPointF3.f2600x);
                    mPPointF3.f2601y = Utils.convertDpToPixel(mPPointF3.f2601y);
                    if (iBarDataSet.isStacked()) {
                        mPPointF = mPPointF3;
                        list = dataSets;
                        Transformer transformer2 = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            if (i5 >= iBarDataSet.getEntryCount() * this.mAnimator.getPhaseX()) {
                                f3 = convertDpToPixel;
                                z = isDrawValueAboveBarEnabled;
                                break;
                            }
                            BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForIndex(i5);
                            float[] yVals = barEntry.getYVals();
                            float f11 = (barBuffer2.buffer[i6] + barBuffer2.buffer[i6 + 2]) / 2.0f;
                            int valueTextColor = iBarDataSet.getValueTextColor(i5);
                            if (yVals == null) {
                                if (!this.mViewPortHandler.isInBoundsRight(f11)) {
                                    f3 = convertDpToPixel;
                                    z = isDrawValueAboveBarEnabled;
                                    break;
                                }
                                int i7 = i6 + 1;
                                if (this.mViewPortHandler.isInBoundsY(barBuffer2.buffer[i7]) && this.mViewPortHandler.isInBoundsLeft(f11)) {
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        f7 = f11;
                                        f4 = convertDpToPixel;
                                        fArr = yVals;
                                        i = i5;
                                        z2 = isDrawValueAboveBarEnabled;
                                        transformer = transformer2;
                                        drawValue(canvas, iBarDataSet.getValueFormatter(), barEntry.getY(), barEntry, i4, f7, barBuffer2.buffer[i7] + (barEntry.getY() >= 0.0f ? f : f2), valueTextColor);
                                    } else {
                                        f7 = f11;
                                        i = i5;
                                        f4 = convertDpToPixel;
                                        z2 = isDrawValueAboveBarEnabled;
                                        fArr = yVals;
                                        transformer = transformer2;
                                    }
                                    if (barEntry.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                        Drawable icon = barEntry.getIcon();
                                        Utils.drawImage(canvas, icon, (int) (f7 + mPPointF.f2600x), (int) (barBuffer2.buffer[i7] + (barEntry.getY() >= 0.0f ? f : f2) + mPPointF.f2601y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                    }
                                } else {
                                    transformer2 = transformer2;
                                    isDrawValueAboveBarEnabled = isDrawValueAboveBarEnabled;
                                    convertDpToPixel = convertDpToPixel;
                                    i5 = i5;
                                }
                            } else {
                                i = i5;
                                f4 = convertDpToPixel;
                                z2 = isDrawValueAboveBarEnabled;
                                fArr = yVals;
                                transformer = transformer2;
                                float f12 = f11;
                                float[] fArr3 = new float[fArr.length * 2];
                                float f13 = -barEntry.getNegativeSum();
                                int i8 = 0;
                                int i9 = 0;
                                float f14 = 0.0f;
                                while (i8 < fArr3.length) {
                                    float f15 = fArr[i9];
                                    int i10 = (f15 > 0.0f ? 1 : (f15 == 0.0f ? 0 : -1));
                                    if (i10 != 0 || (f14 != 0.0f && f13 != 0.0f)) {
                                        if (i10 >= 0) {
                                            f15 = f14 + f15;
                                            f14 = f15;
                                        } else {
                                            float f16 = f13;
                                            f13 -= f15;
                                            f15 = f16;
                                        }
                                    }
                                    fArr3[i8 + 1] = f15 * phaseY;
                                    i8 += 2;
                                    i9++;
                                }
                                transformer.pointValuesToPixel(fArr3);
                                int i11 = 0;
                                while (i11 < fArr3.length) {
                                    int i12 = i11 / 2;
                                    float f17 = fArr[i12];
                                    float f18 = fArr3[i11 + 1] + (((f17 > 0.0f ? 1 : (f17 == 0.0f ? 0 : -1)) == 0 && (f13 > 0.0f ? 1 : (f13 == 0.0f ? 0 : -1)) == 0 && (f14 > 0.0f ? 1 : (f14 == 0.0f ? 0 : -1)) > 0) || (f17 > 0.0f ? 1 : (f17 == 0.0f ? 0 : -1)) < 0 ? f2 : f);
                                    if (!this.mViewPortHandler.isInBoundsRight(f12)) {
                                        break;
                                    }
                                    if (!this.mViewPortHandler.isInBoundsY(f18)) {
                                        i2 = i11;
                                        fArr2 = fArr3;
                                        f5 = f12;
                                    } else if (this.mViewPortHandler.isInBoundsLeft(f12)) {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            f6 = f18;
                                            i2 = i11;
                                            fArr2 = fArr3;
                                            f5 = f12;
                                            drawValue(canvas, iBarDataSet.getValueFormatter(), fArr[i12], barEntry, i4, f12, f6, valueTextColor);
                                        } else {
                                            f6 = f18;
                                            i2 = i11;
                                            fArr2 = fArr3;
                                            f5 = f12;
                                        }
                                        if (barEntry.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon2 = barEntry.getIcon();
                                            Utils.drawImage(canvas, icon2, (int) (f5 + mPPointF.f2600x), (int) (f6 + mPPointF.f2601y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                        }
                                    } else {
                                        i2 = i11;
                                        fArr2 = fArr3;
                                        f5 = f12;
                                    }
                                    i11 = i2 + 2;
                                    fArr3 = fArr2;
                                    f12 = f5;
                                }
                            }
                            i6 = fArr == null ? i6 + 4 : i6 + (fArr.length * 4);
                            i5 = i + 1;
                            transformer2 = transformer;
                            isDrawValueAboveBarEnabled = z2;
                            convertDpToPixel = f4;
                        }
                    } else {
                        int i13 = 0;
                        while (true) {
                            if (i13 >= barBuffer2.buffer.length * this.mAnimator.getPhaseX()) {
                                mPPointF = mPPointF3;
                                list = dataSets;
                                break;
                            }
                            float f19 = (barBuffer2.buffer[i13] + barBuffer2.buffer[i13 + 2]) / 2.0f;
                            if (!this.mViewPortHandler.isInBoundsRight(f19)) {
                                mPPointF = mPPointF3;
                                list = dataSets;
                                break;
                            }
                            int i14 = i13 + 1;
                            if (!this.mViewPortHandler.isInBoundsY(barBuffer2.buffer[i14])) {
                                i3 = i13;
                                mPPointF2 = mPPointF3;
                                list2 = dataSets;
                                barBuffer = barBuffer2;
                            } else if (this.mViewPortHandler.isInBoundsLeft(f19)) {
                                int i15 = i13 / 4;
                                Entry entry = (BarEntry) iBarDataSet.getEntryForIndex(i15);
                                float y = entry.getY();
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    f8 = f19;
                                    i3 = i13;
                                    mPPointF2 = mPPointF3;
                                    list2 = dataSets;
                                    barBuffer = barBuffer2;
                                    drawValue(canvas, iBarDataSet.getValueFormatter(), y, entry, i4, f8, y >= 0.0f ? barBuffer2.buffer[i14] + f : barBuffer2.buffer[i13 + 3] + f2, iBarDataSet.getValueTextColor(i15));
                                } else {
                                    f8 = f19;
                                    i3 = i13;
                                    mPPointF2 = mPPointF3;
                                    list2 = dataSets;
                                    barBuffer = barBuffer2;
                                }
                                if (entry.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon3 = entry.getIcon();
                                    Utils.drawImage(canvas, icon3, (int) (f8 + mPPointF2.f2600x), (int) ((y >= 0.0f ? barBuffer.buffer[i14] + f : barBuffer.buffer[i3 + 3] + f2) + mPPointF2.f2601y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                }
                            } else {
                                i3 = i13;
                                mPPointF2 = mPPointF3;
                                list2 = dataSets;
                                barBuffer = barBuffer2;
                            }
                            i13 = i3 + 4;
                            barBuffer2 = barBuffer;
                            mPPointF3 = mPPointF2;
                            dataSets = list2;
                        }
                        f3 = convertDpToPixel;
                        z = isDrawValueAboveBarEnabled;
                    }
                    MPPointF.recycleInstance(mPPointF);
                } else {
                    list = dataSets;
                    f3 = convertDpToPixel;
                    z = isDrawValueAboveBarEnabled;
                }
                i4++;
                dataSets = list;
                isDrawValueAboveBarEnabled = z;
                convertDpToPixel = f3;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        float y;
        float f;
        BarData barData = this.mChart.getBarData();
        for (Highlight highlight : highlightArr) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iBarDataSet != null && iBarDataSet.isHighlightEnabled()) {
                BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(barEntry, iBarDataSet)) {
                    Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                    this.mHighlightPaint.setColor(iBarDataSet.getHighLightColor());
                    this.mHighlightPaint.setAlpha(iBarDataSet.getHighLightAlpha());
                    if (highlight.getStackIndex() >= 0 && barEntry.isStacked()) {
                        if (this.mChart.isHighlightFullBarEnabled()) {
                            float positiveSum = barEntry.getPositiveSum();
                            f = -barEntry.getNegativeSum();
                            y = positiveSum;
                        } else {
                            Range range = barEntry.getRanges()[highlight.getStackIndex()];
                            y = range.from;
                            f = range.f2589to;
                        }
                    } else {
                        y = barEntry.getY();
                        f = 0.0f;
                    }
                    prepareBarHighlight(barEntry.getX(), y, f, barData.getBarWidth() / 2.0f, transformer);
                    setHighlightDrawPos(highlight, this.mBarRect);
                    canvas.drawRect(this.mBarRect, this.mHighlightPaint);
                }
            }
        }
    }

    protected void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        highlight.setDraw(rectF.centerX(), rectF.top);
    }
}
