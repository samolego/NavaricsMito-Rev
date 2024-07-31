package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.text.DecimalFormat;

/* loaded from: classes.dex */
public class StackedValueFormatter implements IValueFormatter {
    private String mAppendix;
    private boolean mDrawWholeStack;
    private DecimalFormat mFormat;

    public StackedValueFormatter(boolean z, String str, int i) {
        this.mDrawWholeStack = z;
        this.mAppendix = str;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.mFormat = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    @Override // com.github.mikephil.charting.formatter.IValueFormatter
    public String getFormattedValue(float f, Entry entry, int i, ViewPortHandler viewPortHandler) {
        BarEntry barEntry;
        float[] yVals;
        if (!this.mDrawWholeStack && (entry instanceof BarEntry) && (yVals = (barEntry = (BarEntry) entry).getYVals()) != null) {
            if (yVals[yVals.length - 1] == f) {
                return this.mFormat.format(barEntry.getY()) + this.mAppendix;
            }
            return "";
        }
        return this.mFormat.format(f) + this.mAppendix;
    }
}
