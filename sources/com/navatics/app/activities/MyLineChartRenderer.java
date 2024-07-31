package com.navatics.app.activities;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.renderer.LineChartRenderer;
import com.github.mikephil.charting.utils.ViewPortHandler;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.activities.b */
/* loaded from: classes.dex */
public class MyLineChartRenderer extends LineChartRenderer {

    /* renamed from: b */
    private static final C3044k f3972b = C3044k.m1564a(MyLineChartRenderer.class);

    /* renamed from: a */
    boolean f3973a;

    public MyLineChartRenderer(LineDataProvider lineDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(lineDataProvider, chartAnimator, viewPortHandler);
        this.f3973a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public boolean isDrawingValuesAllowed(ChartInterface chartInterface) {
        return super.isDrawingValuesAllowed(chartInterface) || this.f3973a;
    }
}
