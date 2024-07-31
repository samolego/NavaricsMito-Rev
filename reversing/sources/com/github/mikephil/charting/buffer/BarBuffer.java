package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

/* loaded from: classes.dex */
public class BarBuffer extends AbstractBuffer<IBarDataSet> {
    protected float mBarWidth;
    protected boolean mContainsStacks;
    protected int mDataSetCount;
    protected int mDataSetIndex;
    protected boolean mInverted;

    public BarBuffer(int i, int i2, boolean z) {
        super(i);
        this.mDataSetIndex = 0;
        this.mDataSetCount = 1;
        this.mContainsStacks = false;
        this.mInverted = false;
        this.mBarWidth = 1.0f;
        this.mDataSetCount = i2;
        this.mContainsStacks = z;
    }

    public void setBarWidth(float f) {
        this.mBarWidth = f;
    }

    public void setDataSet(int i) {
        this.mDataSetIndex = i;
    }

    public void setInverted(boolean z) {
        this.mInverted = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addBar(float f, float f2, float f3, float f4) {
        float[] fArr = this.buffer;
        int i = this.index;
        this.index = i + 1;
        fArr[i] = f;
        float[] fArr2 = this.buffer;
        int i2 = this.index;
        this.index = i2 + 1;
        fArr2[i2] = f2;
        float[] fArr3 = this.buffer;
        int i3 = this.index;
        this.index = i3 + 1;
        fArr3[i3] = f3;
        float[] fArr4 = this.buffer;
        int i4 = this.index;
        this.index = i4 + 1;
        fArr4[i4] = f4;
    }

    @Override // com.github.mikephil.charting.buffer.AbstractBuffer
    public void feed(IBarDataSet iBarDataSet) {
        float f;
        float f2;
        float f3;
        float f4;
        float entryCount = iBarDataSet.getEntryCount() * this.phaseX;
        float f5 = this.mBarWidth / 2.0f;
        for (int i = 0; i < entryCount; i++) {
            BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForIndex(i);
            if (barEntry != null) {
                float x = barEntry.getX();
                float y = barEntry.getY();
                float[] yVals = barEntry.getYVals();
                if (!this.mContainsStacks || yVals == null) {
                    float f6 = x - f5;
                    float f7 = x + f5;
                    if (this.mInverted) {
                        float f8 = y >= 0.0f ? y : 0.0f;
                        if (y > 0.0f) {
                            y = 0.0f;
                        }
                        float f9 = y;
                        y = f8;
                        f = f9;
                    } else {
                        f = y >= 0.0f ? y : 0.0f;
                        if (y > 0.0f) {
                            y = 0.0f;
                        }
                    }
                    if (f > 0.0f) {
                        f *= this.phaseY;
                    } else {
                        y *= this.phaseY;
                    }
                    addBar(f6, f, f7, y);
                } else {
                    float f10 = -barEntry.getNegativeSum();
                    int i2 = 0;
                    float f11 = 0.0f;
                    while (i2 < yVals.length) {
                        float f12 = yVals[i2];
                        int i3 = (f12 > 0.0f ? 1 : (f12 == 0.0f ? 0 : -1));
                        if (i3 == 0 && (f11 == 0.0f || f10 == 0.0f)) {
                            f3 = f10;
                            f2 = f11;
                            f11 = f12;
                        } else if (i3 >= 0) {
                            f12 += f11;
                            f3 = f10;
                            f2 = f12;
                        } else {
                            float abs = Math.abs(f12) + f10;
                            float abs2 = Math.abs(f12) + f10;
                            float f13 = f10;
                            f2 = f11;
                            f11 = f13;
                            f3 = abs2;
                            f12 = abs;
                        }
                        float f14 = x - f5;
                        float f15 = x + f5;
                        if (this.mInverted) {
                            float f16 = f11 >= f12 ? f11 : f12;
                            if (f11 > f12) {
                                f11 = f12;
                            }
                            float f17 = f11;
                            f11 = f16;
                            f4 = f17;
                        } else {
                            f4 = f11 >= f12 ? f11 : f12;
                            if (f11 > f12) {
                                f11 = f12;
                            }
                        }
                        addBar(f14, f4 * this.phaseY, f15, f11 * this.phaseY);
                        i2++;
                        f11 = f2;
                        f10 = f3;
                    }
                }
            }
        }
        reset();
    }
}
