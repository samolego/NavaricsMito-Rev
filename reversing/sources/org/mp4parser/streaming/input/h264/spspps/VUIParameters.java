package org.mp4parser.streaming.input.h264.spspps;

/* renamed from: org.mp4parser.streaming.input.h264.spspps.i */
/* loaded from: classes2.dex */
public class VUIParameters {

    /* renamed from: a */
    public boolean f12340a;

    /* renamed from: b */
    public int f12341b;

    /* renamed from: c */
    public int f12342c;

    /* renamed from: d */
    public boolean f12343d;

    /* renamed from: e */
    public boolean f12344e;

    /* renamed from: f */
    public boolean f12345f;

    /* renamed from: g */
    public int f12346g;

    /* renamed from: h */
    public boolean f12347h;

    /* renamed from: i */
    public boolean f12348i;

    /* renamed from: j */
    public int f12349j;

    /* renamed from: k */
    public int f12350k;

    /* renamed from: l */
    public int f12351l;

    /* renamed from: m */
    public boolean f12352m;

    /* renamed from: n */
    public int f12353n;

    /* renamed from: o */
    public int f12354o;

    /* renamed from: p */
    public boolean f12355p;

    /* renamed from: q */
    public int f12356q;

    /* renamed from: r */
    public int f12357r;

    /* renamed from: s */
    public boolean f12358s;

    /* renamed from: t */
    public boolean f12359t;

    /* renamed from: u */
    public boolean f12360u;

    /* renamed from: v */
    public HRDParameters f12361v;

    /* renamed from: w */
    public HRDParameters f12362w;

    /* renamed from: x */
    public C3136a f12363x;

    /* renamed from: y */
    public AspectRatio f12364y;

    public String toString() {
        return "VUIParameters{\naspect_ratio_info_present_flag=" + this.f12340a + "\n, sar_width=" + this.f12341b + "\n, sar_height=" + this.f12342c + "\n, overscan_info_present_flag=" + this.f12343d + "\n, overscan_appropriate_flag=" + this.f12344e + "\n, video_signal_type_present_flag=" + this.f12345f + "\n, video_format=" + this.f12346g + "\n, video_full_range_flag=" + this.f12347h + "\n, colour_description_present_flag=" + this.f12348i + "\n, colour_primaries=" + this.f12349j + "\n, transfer_characteristics=" + this.f12350k + "\n, matrix_coefficients=" + this.f12351l + "\n, chroma_loc_info_present_flag=" + this.f12352m + "\n, chroma_sample_loc_type_top_field=" + this.f12353n + "\n, chroma_sample_loc_type_bottom_field=" + this.f12354o + "\n, timing_info_present_flag=" + this.f12355p + "\n, num_units_in_tick=" + this.f12356q + "\n, time_scale=" + this.f12357r + "\n, fixed_frame_rate_flag=" + this.f12358s + "\n, low_delay_hrd_flag=" + this.f12359t + "\n, pic_struct_present_flag=" + this.f12360u + "\n, nalHRDParams=" + this.f12361v + "\n, vclHRDParams=" + this.f12362w + "\n, bitstreamRestriction=" + this.f12363x + "\n, aspect_ratio=" + this.f12364y + "\n}";
    }

    /* compiled from: VUIParameters.java */
    /* renamed from: org.mp4parser.streaming.input.h264.spspps.i$a */
    /* loaded from: classes2.dex */
    public static class C3136a {

        /* renamed from: a */
        public boolean f12365a;

        /* renamed from: b */
        public int f12366b;

        /* renamed from: c */
        public int f12367c;

        /* renamed from: d */
        public int f12368d;

        /* renamed from: e */
        public int f12369e;

        /* renamed from: f */
        public int f12370f;

        /* renamed from: g */
        public int f12371g;

        public String toString() {
            return "BitstreamRestriction{motion_vectors_over_pic_boundaries_flag=" + this.f12365a + ", max_bytes_per_pic_denom=" + this.f12366b + ", max_bits_per_mb_denom=" + this.f12367c + ", log2_max_mv_length_horizontal=" + this.f12368d + ", log2_max_mv_length_vertical=" + this.f12369e + ", num_reorder_frames=" + this.f12370f + ", max_dec_frame_buffering=" + this.f12371g + '}';
        }
    }
}
