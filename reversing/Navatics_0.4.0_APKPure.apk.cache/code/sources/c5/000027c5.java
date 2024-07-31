package org.mp4parser.streaming.input.h264.spspps;

/* compiled from: VUIParameters.java */
/* renamed from: org.mp4parser.streaming.input.h264.spspps.i, reason: use source file name */
/* loaded from: classes2.dex */
public class VUIParameters {

    /* renamed from: a */
    public boolean f12381a;

    /* renamed from: b */
    public int f12382b;

    /* renamed from: c */
    public int f12383c;

    /* renamed from: d */
    public boolean f12384d;

    /* renamed from: e */
    public boolean f12385e;

    /* renamed from: f */
    public boolean f12386f;

    /* renamed from: g */
    public int f12387g;

    /* renamed from: h */
    public boolean f12388h;

    /* renamed from: i */
    public boolean f12389i;

    /* renamed from: j */
    public int f12390j;

    /* renamed from: k */
    public int f12391k;

    /* renamed from: l */
    public int f12392l;

    /* renamed from: m */
    public boolean f12393m;

    /* renamed from: n */
    public int f12394n;

    /* renamed from: o */
    public int f12395o;

    /* renamed from: p */
    public boolean f12396p;

    /* renamed from: q */
    public int f12397q;

    /* renamed from: r */
    public int f12398r;

    /* renamed from: s */
    public boolean f12399s;

    /* renamed from: t */
    public boolean f12400t;

    /* renamed from: u */
    public boolean f12401u;

    /* renamed from: v */
    public HRDParameters f12402v;

    /* renamed from: w */
    public HRDParameters f12403w;

    /* renamed from: x */
    public a f12404x;

    /* renamed from: y */
    public AspectRatio f12405y;

    public String toString() {
        return "VUIParameters{\naspect_ratio_info_present_flag=" + this.f12381a + "\n, sar_width=" + this.f12382b + "\n, sar_height=" + this.f12383c + "\n, overscan_info_present_flag=" + this.f12384d + "\n, overscan_appropriate_flag=" + this.f12385e + "\n, video_signal_type_present_flag=" + this.f12386f + "\n, video_format=" + this.f12387g + "\n, video_full_range_flag=" + this.f12388h + "\n, colour_description_present_flag=" + this.f12389i + "\n, colour_primaries=" + this.f12390j + "\n, transfer_characteristics=" + this.f12391k + "\n, matrix_coefficients=" + this.f12392l + "\n, chroma_loc_info_present_flag=" + this.f12393m + "\n, chroma_sample_loc_type_top_field=" + this.f12394n + "\n, chroma_sample_loc_type_bottom_field=" + this.f12395o + "\n, timing_info_present_flag=" + this.f12396p + "\n, num_units_in_tick=" + this.f12397q + "\n, time_scale=" + this.f12398r + "\n, fixed_frame_rate_flag=" + this.f12399s + "\n, low_delay_hrd_flag=" + this.f12400t + "\n, pic_struct_present_flag=" + this.f12401u + "\n, nalHRDParams=" + this.f12402v + "\n, vclHRDParams=" + this.f12403w + "\n, bitstreamRestriction=" + this.f12404x + "\n, aspect_ratio=" + this.f12405y + "\n}";
    }

    /* compiled from: VUIParameters.java */
    /* renamed from: org.mp4parser.streaming.input.h264.spspps.i$a */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        public boolean f12406a;

        /* renamed from: b */
        public int f12407b;

        /* renamed from: c */
        public int f12408c;

        /* renamed from: d */
        public int f12409d;

        /* renamed from: e */
        public int f12410e;

        /* renamed from: f */
        public int f12411f;

        /* renamed from: g */
        public int f12412g;

        public String toString() {
            return "BitstreamRestriction{motion_vectors_over_pic_boundaries_flag=" + this.f12406a + ", max_bytes_per_pic_denom=" + this.f12407b + ", max_bits_per_mb_denom=" + this.f12408c + ", log2_max_mv_length_horizontal=" + this.f12409d + ", log2_max_mv_length_vertical=" + this.f12410e + ", num_reorder_frames=" + this.f12411f + ", max_dec_frame_buffering=" + this.f12412g + '}';
        }
    }
}