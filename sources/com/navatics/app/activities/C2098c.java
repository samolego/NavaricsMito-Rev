package com.navatics.app.activities;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.navatics.app.NavaticsApplication;
import com.navatics.robot.utils.DpiUtils;

/* renamed from: com.navatics.app.activities.c */
/* loaded from: classes.dex */
public class MyYAxisRenderer extends YAxisRenderer {

    /* renamed from: a */
    protected Paint f3979a;

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas canvas) {
    }

    public MyYAxisRenderer(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer transformer) {
        super(viewPortHandler, yAxis, transformer);
        this.f3979a = new Paint();
        this.f3979a.setColor(-1);
        this.f3979a.setStyle(Paint.Style.FILL);
        this.f3979a.setAntiAlias(true);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderGridLines(Canvas canvas) {
        super.renderGridLines(canvas);
        super.renderAxisLabels(canvas);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected void drawYLabels(Canvas canvas, float f, float[] fArr, float f2) {
        int i = this.mYAxis.isDrawTopYLabelEntryEnabled() ? this.mYAxis.mEntryCount : this.mYAxis.mEntryCount - 1;
        int m5887a = DpiUtils.m5887a(NavaticsApplication.m9567b(), 3.0f);
        Paint.FontMetrics fontMetrics = this.mAxisLabelPaint.getFontMetrics();
        for (int i2 = !this.mYAxis.isDrawBottomYLabelEntryEnabled(); i2 < i; i2++) {
            String formattedLabel = this.mYAxis.getFormattedLabel(i2);
            float f3 = fArr[(i2 * 2) + 1] + f2;
            float f4 = f - m5887a;
            canvas.drawRect(f4, f3 + fontMetrics.ascent, Utils.calcTextWidth(this.mAxisLabelPaint, formattedLabel) + f4 + (m5887a * 2), f3 + fontMetrics.descent, this.f3979a);
            canvas.drawText(formattedLabel, f, f3, this.mAxisLabelPaint);
        }
    }
}
