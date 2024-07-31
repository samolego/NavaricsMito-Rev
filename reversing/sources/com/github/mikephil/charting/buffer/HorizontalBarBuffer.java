package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

/* loaded from: classes.dex */
public class HorizontalBarBuffer extends BarBuffer {
    public HorizontalBarBuffer(int i, int i2, boolean z) {
        super(i, i2, z);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.github.mikephil.charting.buffer.BarBuffer, com.github.mikephil.charting.buffer.AbstractBuffer
    public void feed(IBarDataSet iBarDataSet) {
        float f;
        float abs;
        float f2;
        float f3;
        float entryCount = iBarDataSet.getEntryCount() * this.phaseX;
        float f4 = this.mBarWidth / 2.0f;
        for (int i = 0; i < entryCount; i++) {
            BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForIndex(i);
            if (barEntry != null) {
                float x = barEntry.getX();
                float y = barEntry.getY();
                float[] yVals = barEntry.getYVals();
                if (!this.mContainsStacks || yVals == null) {
                    float f5 = x - f4;
                    float f6 = x + f4;
                    if (this.mInverted) {
                        float f7 = y >= 0.0f ? y : 0.0f;
                        if (y > 0.0f) {
                            y = 0.0f;
                        }
                        float f8 = y;
                        y = f7;
                        f = f8;
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
                    addBar(y, f6, f, f5);
                } else {
                    float f9 = -barEntry.getNegativeSum();
                    int i2 = 0;
                    float f10 = 0.0f;
                    while (i2 < yVals.length) {
                        float f11 = yVals[i2];
                        if (f11 >= 0.0f) {
                            f2 = f11 + f10;
                            abs = f9;
                            f9 = f10;
                            f10 = f2;
                        } else {
                            float abs2 = Math.abs(f11) + f9;
                            abs = Math.abs(f11) + f9;
                            f2 = abs2;
                        }
                        float f12 = x - f4;
                        float f13 = x + f4;
                        if (this.mInverted) {
                            float f14 = f9 >= f2 ? f9 : f2;
                            if (f9 > f2) {
                                f9 = f2;
                            }
                            float f15 = f9;
                            f9 = f14;
                            f3 = f15;
                        } else {
                            f3 = f9 >= f2 ? f9 : f2;
                            if (f9 > f2) {
                                f9 = f2;
                            }
                        }
                        addBar(f9 * this.phaseY, f13, f3 * this.phaseY, f12);
                        i2++;
                        f9 = abs;
                    }
                }
            }
        }
        reset();
    }
}
