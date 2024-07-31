package com.github.mikephil.charting.interfaces.dataprovider;

import com.github.mikephil.charting.data.CombinedData;

/* loaded from: classes.dex */
public interface CombinedDataProvider extends BarDataProvider, BubbleDataProvider, CandleDataProvider, LineDataProvider, ScatterDataProvider {
    CombinedData getCombinedData();
}
