package org.mp4parser.streaming.input.h264.spspps;

import java.util.Arrays;

/* renamed from: org.mp4parser.streaming.input.h264.spspps.d */
/* loaded from: classes2.dex */
public class HRDParameters {

    /* renamed from: a */
    public int f12258a;

    /* renamed from: b */
    public int f12259b;

    /* renamed from: c */
    public int f12260c;

    /* renamed from: d */
    public int[] f12261d;

    /* renamed from: e */
    public int[] f12262e;

    /* renamed from: f */
    public boolean[] f12263f;

    /* renamed from: g */
    public int f12264g;

    /* renamed from: h */
    public int f12265h;

    /* renamed from: i */
    public int f12266i;

    /* renamed from: j */
    public int f12267j;

    public String toString() {
        return "HRDParameters{cpb_cnt_minus1=" + this.f12258a + ", bit_rate_scale=" + this.f12259b + ", cpb_size_scale=" + this.f12260c + ", bit_rate_value_minus1=" + Arrays.toString(this.f12261d) + ", cpb_size_value_minus1=" + Arrays.toString(this.f12262e) + ", cbr_flag=" + Arrays.toString(this.f12263f) + ", initial_cpb_removal_delay_length_minus1=" + this.f12264g + ", cpb_removal_delay_length_minus1=" + this.f12265h + ", dpb_output_delay_length_minus1=" + this.f12266i + ", time_offset_length=" + this.f12267j + '}';
    }
}
