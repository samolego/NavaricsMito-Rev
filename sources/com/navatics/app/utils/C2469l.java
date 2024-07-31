package com.navatics.app.utils;

import android.graphics.RectF;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointD;
import com.navatics.app.framework.divelog.EntryWrapper;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.navatics.app.utils.l */
/* loaded from: classes.dex */
public class MyChartHighlighter extends ChartHighlighter<LineChart> {

    /* renamed from: a */
    private List<EntryWrapper> f5129a;

    /* renamed from: b */
    private RectF f5130b;

    /* renamed from: c */
    private float f5131c;

    /* renamed from: d */
    private float f5132d;

    public MyChartHighlighter(LineChart lineChart) {
        super(lineChart);
        this.f5130b = new RectF();
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    @Override // com.github.mikephil.charting.highlight.ChartHighlighter, com.github.mikephil.charting.highlight.IHighlighter
    public Highlight getHighlight(float f, float f2) {
        List<EntryWrapper> list = this.f5129a;
        if (list == null || list.isEmpty()) {
            return null;
        }
        BarLineScatterCandleBubbleData data = getData();
        if (data == null) {
            return null;
        }
        ?? dataSetByIndex = data.getDataSetByIndex(0);
        if (dataSetByIndex.isHighlightEnabled()) {
            float f3 = this.f5131c / 2.0f;
            float f4 = this.f5132d / 2.0f;
            Iterator<EntryWrapper> it = this.f5129a.iterator();
            while (it.hasNext()) {
                Entry entryForIndex = dataSetByIndex.getEntryForIndex(it.next().f4443a);
                MPPointD pixelForValues = ((LineChart) this.mChart).getTransformer(YAxis.AxisDependency.LEFT).getPixelForValues(entryForIndex.getX(), entryForIndex.getY());
                double d = f4;
                Iterator<EntryWrapper> it2 = it;
                float f5 = f4;
                double d2 = f3;
                float f6 = f3;
                this.f5130b.set((float) (pixelForValues.f2598x - d), (float) (pixelForValues.f2599y - d2), (float) (pixelForValues.f2598x + d), (float) (pixelForValues.f2599y + d2));
                if (this.f5130b.contains(f, f2)) {
                    return new Highlight(entryForIndex.getX(), entryForIndex.getY(), (float) pixelForValues.f2598x, (float) pixelForValues.f2599y, 0, dataSetByIndex.getAxisDependency());
                }
                f4 = f5;
                it = it2;
                f3 = f6;
            }
            return null;
        }
        return null;
    }

    /* renamed from: a */
    public void m7369a(List<EntryWrapper> list) {
        this.f5129a = list;
    }

    /* renamed from: a */
    public void m7370a(float f) {
        this.f5131c = f;
    }

    /* renamed from: b */
    public void m7368b(float f) {
        this.f5132d = f;
    }
}
