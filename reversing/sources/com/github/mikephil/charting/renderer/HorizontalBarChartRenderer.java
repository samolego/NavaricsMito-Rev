package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.buffer.HorizontalBarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: classes.dex */
public class HorizontalBarChartRenderer extends BarChartRenderer {
    private RectF mBarShadowRectBuffer;

    public HorizontalBarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(barDataProvider, chartAnimator, viewPortHandler);
        this.mBarShadowRectBuffer = new RectF();
        this.mValuePaint.setTextAlign(Paint.Align.LEFT);
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new HorizontalBarBuffer[barData.getDataSetCount()];
        for (int i = 0; i < this.mBarBuffers.length; i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            this.mBarBuffers[i] = new HorizontalBarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
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
                rectF.top = x - barWidth;
                rectF.bottom = x + barWidth;
                transformer.rectValueToPixel(rectF);
                if (this.mViewPortHandler.isInBoundsTop(this.mBarShadowRectBuffer.bottom)) {
                    if (!this.mViewPortHandler.isInBoundsBottom(this.mBarShadowRectBuffer.top)) {
                        break;
                    }
                    this.mBarShadowRectBuffer.left = this.mViewPortHandler.contentLeft();
                    this.mBarShadowRectBuffer.right = this.mViewPortHandler.contentRight();
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
            int i4 = i3 + 3;
            if (!this.mViewPortHandler.isInBoundsTop(barBuffer.buffer[i4])) {
                return;
            }
            int i5 = i3 + 1;
            if (this.mViewPortHandler.isInBoundsBottom(barBuffer.buffer[i5])) {
                if (!z2) {
                    this.mRenderPaint.setColor(iBarDataSet.getColor(i3 / 4));
                }
                int i6 = i3 + 2;
                canvas.drawRect(barBuffer.buffer[i3], barBuffer.buffer[i5], barBuffer.buffer[i6], barBuffer.buffer[i4], this.mRenderPaint);
                if (z) {
                    canvas.drawRect(barBuffer.buffer[i3], barBuffer.buffer[i5], barBuffer.buffer[i6], barBuffer.buffer[i4], this.mBarBorderPaint);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        List list;
        MPPointF mPPointF;
        boolean z;
        int i;
        float[] fArr;
        boolean z2;
        float f;
        float f2;
        float f3;
        int i2;
        float[] fArr2;
        float f4;
        float f5;
        BarEntry barEntry;
        String str;
        float f6;
        IValueFormatter iValueFormatter;
        float f7;
        float f8;
        float f9;
        float f10;
        int i3;
        List list2;
        boolean z3;
        MPPointF mPPointF2;
        IValueFormatter iValueFormatter2;
        float f11;
        BarBuffer barBuffer;
        if (isDrawingValuesAllowed(this.mChart)) {
            List dataSets = this.mChart.getBarData().getDataSets();
            float convertDpToPixel = Utils.convertDpToPixel(5.0f);
            boolean isDrawValueAboveBarEnabled = this.mChart.isDrawValueAboveBarEnabled();
            int i4 = 0;
            while (i4 < this.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i4);
                if (shouldDrawValues(iBarDataSet)) {
                    boolean isInverted = this.mChart.isInverted(iBarDataSet.getAxisDependency());
                    applyValueTextStyle(iBarDataSet);
                    float f12 = 2.0f;
                    float calcTextHeight = Utils.calcTextHeight(this.mValuePaint, "10") / 2.0f;
                    IValueFormatter valueFormatter = iBarDataSet.getValueFormatter();
                    BarBuffer barBuffer2 = this.mBarBuffers[i4];
                    float phaseY = this.mAnimator.getPhaseY();
                    MPPointF mPPointF3 = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    mPPointF3.f2600x = Utils.convertDpToPixel(mPPointF3.f2600x);
                    mPPointF3.f2601y = Utils.convertDpToPixel(mPPointF3.f2601y);
                    if (iBarDataSet.isStacked()) {
                        list = dataSets;
                        mPPointF = mPPointF3;
                        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            if (i5 >= iBarDataSet.getEntryCount() * this.mAnimator.getPhaseX()) {
                                z = isDrawValueAboveBarEnabled;
                                break;
                            }
                            BarEntry barEntry2 = (BarEntry) iBarDataSet.getEntryForIndex(i5);
                            int valueTextColor = iBarDataSet.getValueTextColor(i5);
                            float[] yVals = barEntry2.getYVals();
                            if (yVals == null) {
                                int i7 = i6 + 1;
                                if (!this.mViewPortHandler.isInBoundsTop(barBuffer2.buffer[i7])) {
                                    z = isDrawValueAboveBarEnabled;
                                    break;
                                } else if (this.mViewPortHandler.isInBoundsX(barBuffer2.buffer[i6]) && this.mViewPortHandler.isInBoundsBottom(barBuffer2.buffer[i7])) {
                                    String formattedValue = valueFormatter.getFormattedValue(barEntry2.getY(), barEntry2, i4, this.mViewPortHandler);
                                    float calcTextWidth = Utils.calcTextWidth(this.mValuePaint, formattedValue);
                                    float f13 = isDrawValueAboveBarEnabled ? convertDpToPixel : -(calcTextWidth + convertDpToPixel);
                                    float f14 = isDrawValueAboveBarEnabled ? -(calcTextWidth + convertDpToPixel) : convertDpToPixel;
                                    if (isInverted) {
                                        f4 = (-f13) - calcTextWidth;
                                        f5 = (-f14) - calcTextWidth;
                                    } else {
                                        f4 = f13;
                                        f5 = f14;
                                    }
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        i = i5;
                                        fArr = yVals;
                                        barEntry = barEntry2;
                                        drawValue(canvas, formattedValue, barBuffer2.buffer[i6 + 2] + (barEntry2.getY() >= 0.0f ? f4 : f5), barBuffer2.buffer[i7] + calcTextHeight, valueTextColor);
                                    } else {
                                        barEntry = barEntry2;
                                        i = i5;
                                        fArr = yVals;
                                    }
                                    if (barEntry.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                        Drawable icon = barEntry.getIcon();
                                        float f15 = barBuffer2.buffer[i6 + 2];
                                        if (barEntry.getY() >= 0.0f) {
                                            f5 = f4;
                                        }
                                        Utils.drawImage(canvas, icon, (int) (f15 + f5 + mPPointF.f2600x), (int) (barBuffer2.buffer[i7] + mPPointF.f2601y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                    }
                                    z2 = isDrawValueAboveBarEnabled;
                                }
                            } else {
                                BarEntry barEntry3 = barEntry2;
                                i = i5;
                                fArr = yVals;
                                float[] fArr3 = new float[fArr.length * 2];
                                float f16 = -barEntry3.getNegativeSum();
                                int i8 = 0;
                                int i9 = 0;
                                float f17 = 0.0f;
                                while (i8 < fArr3.length) {
                                    float f18 = fArr[i9];
                                    int i10 = (f18 > 0.0f ? 1 : (f18 == 0.0f ? 0 : -1));
                                    if (i10 != 0 || (f17 != 0.0f && f16 != 0.0f)) {
                                        if (i10 >= 0) {
                                            f18 = f17 + f18;
                                            f17 = f18;
                                        } else {
                                            float f19 = f16;
                                            f16 -= f18;
                                            f18 = f19;
                                        }
                                    }
                                    fArr3[i8] = f18 * phaseY;
                                    i8 += 2;
                                    i9++;
                                }
                                transformer.pointValuesToPixel(fArr3);
                                int i11 = 0;
                                while (true) {
                                    if (i11 >= fArr3.length) {
                                        z2 = isDrawValueAboveBarEnabled;
                                        break;
                                    }
                                    float f20 = fArr[i11 / 2];
                                    BarEntry barEntry4 = barEntry3;
                                    String formattedValue2 = valueFormatter.getFormattedValue(f20, barEntry4, i4, this.mViewPortHandler);
                                    float calcTextWidth2 = Utils.calcTextWidth(this.mValuePaint, formattedValue2);
                                    if (isDrawValueAboveBarEnabled) {
                                        barEntry3 = barEntry4;
                                        f = convertDpToPixel;
                                    } else {
                                        barEntry3 = barEntry4;
                                        f = -(calcTextWidth2 + convertDpToPixel);
                                    }
                                    if (isDrawValueAboveBarEnabled) {
                                        z2 = isDrawValueAboveBarEnabled;
                                        f2 = -(calcTextWidth2 + convertDpToPixel);
                                    } else {
                                        z2 = isDrawValueAboveBarEnabled;
                                        f2 = convertDpToPixel;
                                    }
                                    if (isInverted) {
                                        f = (-f) - calcTextWidth2;
                                        f2 = (-f2) - calcTextWidth2;
                                    }
                                    boolean z4 = (f20 == 0.0f && f16 == 0.0f && f17 > 0.0f) || f20 < 0.0f;
                                    float f21 = fArr3[i11];
                                    if (z4) {
                                        f = f2;
                                    }
                                    float f22 = f21 + f;
                                    float f23 = (barBuffer2.buffer[i6 + 1] + barBuffer2.buffer[i6 + 3]) / 2.0f;
                                    if (!this.mViewPortHandler.isInBoundsTop(f23)) {
                                        break;
                                    }
                                    if (!this.mViewPortHandler.isInBoundsX(f22)) {
                                        i2 = i11;
                                        fArr2 = fArr3;
                                    } else if (this.mViewPortHandler.isInBoundsBottom(f23)) {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            f3 = f23;
                                            i2 = i11;
                                            fArr2 = fArr3;
                                            drawValue(canvas, formattedValue2, f22, f23 + calcTextHeight, valueTextColor);
                                        } else {
                                            f3 = f23;
                                            i2 = i11;
                                            fArr2 = fArr3;
                                        }
                                        if (barEntry3.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon2 = barEntry3.getIcon();
                                            Utils.drawImage(canvas, icon2, (int) (f22 + mPPointF.f2600x), (int) (f3 + mPPointF.f2601y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                        }
                                    } else {
                                        i2 = i11;
                                        fArr2 = fArr3;
                                    }
                                    i11 = i2 + 2;
                                    isDrawValueAboveBarEnabled = z2;
                                    fArr3 = fArr2;
                                }
                            }
                            i6 = fArr == null ? i6 + 4 : i6 + (fArr.length * 4);
                            i5 = i + 1;
                            isDrawValueAboveBarEnabled = z2;
                        }
                    } else {
                        int i12 = 0;
                        while (true) {
                            if (i12 >= barBuffer2.buffer.length * this.mAnimator.getPhaseX()) {
                                list = dataSets;
                                mPPointF = mPPointF3;
                                break;
                            }
                            int i13 = i12 + 1;
                            float f24 = (barBuffer2.buffer[i13] + barBuffer2.buffer[i12 + 3]) / f12;
                            if (!this.mViewPortHandler.isInBoundsTop(barBuffer2.buffer[i13])) {
                                list = dataSets;
                                mPPointF = mPPointF3;
                                break;
                            }
                            if (!this.mViewPortHandler.isInBoundsX(barBuffer2.buffer[i12])) {
                                i3 = i12;
                                list2 = dataSets;
                                z3 = isInverted;
                                f11 = calcTextHeight;
                                mPPointF2 = mPPointF3;
                                barBuffer = barBuffer2;
                                iValueFormatter2 = valueFormatter;
                            } else if (this.mViewPortHandler.isInBoundsBottom(barBuffer2.buffer[i13])) {
                                BarEntry barEntry5 = (BarEntry) iBarDataSet.getEntryForIndex(i12 / 4);
                                float y = barEntry5.getY();
                                String formattedValue3 = valueFormatter.getFormattedValue(y, barEntry5, i4, this.mViewPortHandler);
                                MPPointF mPPointF4 = mPPointF3;
                                float calcTextWidth3 = Utils.calcTextWidth(this.mValuePaint, formattedValue3);
                                if (isDrawValueAboveBarEnabled) {
                                    str = formattedValue3;
                                    f6 = convertDpToPixel;
                                } else {
                                    str = formattedValue3;
                                    f6 = -(calcTextWidth3 + convertDpToPixel);
                                }
                                if (isDrawValueAboveBarEnabled) {
                                    iValueFormatter = valueFormatter;
                                    f7 = -(calcTextWidth3 + convertDpToPixel);
                                } else {
                                    iValueFormatter = valueFormatter;
                                    f7 = convertDpToPixel;
                                }
                                if (isInverted) {
                                    f8 = (-f6) - calcTextWidth3;
                                    f9 = (-f7) - calcTextWidth3;
                                } else {
                                    f8 = f6;
                                    f9 = f7;
                                }
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    f10 = y;
                                    i3 = i12;
                                    list2 = dataSets;
                                    mPPointF2 = mPPointF4;
                                    f11 = calcTextHeight;
                                    barBuffer = barBuffer2;
                                    z3 = isInverted;
                                    iValueFormatter2 = iValueFormatter;
                                    drawValue(canvas, str, (y >= 0.0f ? f8 : f9) + barBuffer2.buffer[i12 + 2], f24 + calcTextHeight, iBarDataSet.getValueTextColor(i12 / 2));
                                } else {
                                    f10 = y;
                                    i3 = i12;
                                    list2 = dataSets;
                                    z3 = isInverted;
                                    mPPointF2 = mPPointF4;
                                    iValueFormatter2 = iValueFormatter;
                                    f11 = calcTextHeight;
                                    barBuffer = barBuffer2;
                                }
                                if (barEntry5.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon3 = barEntry5.getIcon();
                                    float f25 = barBuffer.buffer[i3 + 2];
                                    if (f10 >= 0.0f) {
                                        f9 = f8;
                                    }
                                    Utils.drawImage(canvas, icon3, (int) (f25 + f9 + mPPointF2.f2600x), (int) (f24 + mPPointF2.f2601y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                }
                            } else {
                                i3 = i12;
                                list2 = dataSets;
                                z3 = isInverted;
                                f11 = calcTextHeight;
                                mPPointF2 = mPPointF3;
                                barBuffer = barBuffer2;
                                iValueFormatter2 = valueFormatter;
                            }
                            i12 = i3 + 4;
                            mPPointF3 = mPPointF2;
                            valueFormatter = iValueFormatter2;
                            barBuffer2 = barBuffer;
                            calcTextHeight = f11;
                            dataSets = list2;
                            isInverted = z3;
                            f12 = 2.0f;
                        }
                        z = isDrawValueAboveBarEnabled;
                    }
                    MPPointF.recycleInstance(mPPointF);
                } else {
                    list = dataSets;
                    z = isDrawValueAboveBarEnabled;
                }
                i4++;
                isDrawValueAboveBarEnabled = z;
                dataSets = list;
            }
        }
    }

    protected void drawValue(Canvas canvas, String str, float f, float f2, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f, f2, this.mValuePaint);
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void prepareBarHighlight(float f, float f2, float f3, float f4, Transformer transformer) {
        this.mBarRect.set(f2, f - f4, f3, f + f4);
        transformer.rectToPixelPhaseHorizontal(this.mBarRect, this.mAnimator.getPhaseY());
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        highlight.setDraw(rectF.centerY(), rectF.right);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public boolean isDrawingValuesAllowed(ChartInterface chartInterface) {
        return ((float) chartInterface.getData().getEntryCount()) < ((float) chartInterface.getMaxVisibleCount()) * this.mViewPortHandler.getScaleY();
    }
}
