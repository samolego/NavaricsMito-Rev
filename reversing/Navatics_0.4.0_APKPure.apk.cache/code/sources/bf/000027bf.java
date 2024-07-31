package org.mp4parser.streaming.input.h264.spspps;

import java.util.Arrays;

/* compiled from: HRDParameters.java */
/* renamed from: org.mp4parser.streaming.input.h264.spspps.d, reason: use source file name */
/* loaded from: classes2.dex */
public class HRDParameters {

    /* renamed from: a */
    public int f12299a;

    /* renamed from: b */
    public int f12300b;

    /* renamed from: c */
    public int f12301c;

    /* renamed from: d */
    public int[] f12302d;

    /* renamed from: e */
    public int[] f12303e;

    /* renamed from: f */
    public boolean[] f12304f;

    /* renamed from: g */
    public int f12305g;

    /* renamed from: h */
    public int f12306h;

    /* renamed from: i */
    public int f12307i;

    /* renamed from: j */
    public int f12308j;

    public String toString() {
        return "HRDParameters{cpb_cnt_minus1=" + this.f12299a + ", bit_rate_scale=" + this.f12300b + ", cpb_size_scale=" + this.f12301c + ", bit_rate_value_minus1=" + Arrays.toString(this.f12302d) + ", cpb_size_value_minus1=" + Arrays.toString(this.f12303e) + ", cbr_flag=" + Arrays.toString(this.f12304f) + ", initial_cpb_removal_delay_length_minus1=" + this.f12305g + ", cpb_removal_delay_length_minus1=" + this.f12306h + ", dpb_output_delay_length_minus1=" + this.f12307i + ", time_offset_length=" + this.f12308j + '}';
    }
}