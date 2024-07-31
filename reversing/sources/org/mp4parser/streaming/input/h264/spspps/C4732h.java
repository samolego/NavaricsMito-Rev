package org.mp4parser.streaming.input.h264.spspps;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.mp4parser.streaming.input.h264.spspps.VUIParameters;

/* renamed from: org.mp4parser.streaming.input.h264.spspps.h */
/* loaded from: classes2.dex */
public class SeqParameterSet {

    /* renamed from: A */
    public boolean f12299A;

    /* renamed from: B */
    public int f12300B;

    /* renamed from: C */
    public int f12301C;

    /* renamed from: D */
    public int f12302D;

    /* renamed from: E */
    public boolean f12303E;

    /* renamed from: F */
    public boolean f12304F;

    /* renamed from: G */
    public boolean f12305G;

    /* renamed from: H */
    public int f12306H;

    /* renamed from: I */
    public int f12307I;

    /* renamed from: J */
    public int f12308J;

    /* renamed from: K */
    public int f12309K;

    /* renamed from: L */
    public int[] f12310L;

    /* renamed from: M */
    public VUIParameters f12311M;

    /* renamed from: N */
    public ScalingMatrix f12312N;

    /* renamed from: O */
    public int f12313O;

    /* renamed from: a */
    public int f12314a;

    /* renamed from: b */
    public boolean f12315b;

    /* renamed from: c */
    public boolean f12316c;

    /* renamed from: d */
    public boolean f12317d;

    /* renamed from: e */
    public int f12318e;

    /* renamed from: f */
    public boolean f12319f;

    /* renamed from: g */
    public boolean f12320g;

    /* renamed from: h */
    public boolean f12321h;

    /* renamed from: i */
    public ChromaFormat f12322i;

    /* renamed from: j */
    public int f12323j;

    /* renamed from: k */
    public int f12324k;

    /* renamed from: l */
    public int f12325l;

    /* renamed from: m */
    public int f12326m;

    /* renamed from: n */
    public int f12327n;

    /* renamed from: o */
    public int f12328o;

    /* renamed from: p */
    public boolean f12329p;

    /* renamed from: q */
    public int f12330q;

    /* renamed from: r */
    public long f12331r;

    /* renamed from: s */
    public boolean f12332s;

    /* renamed from: t */
    public boolean f12333t;

    /* renamed from: u */
    public boolean f12334u;

    /* renamed from: v */
    public boolean f12335v;

    /* renamed from: w */
    public boolean f12336w;

    /* renamed from: x */
    public boolean f12337x;

    /* renamed from: y */
    public int f12338y;

    /* renamed from: z */
    public int f12339z;

    /* renamed from: a */
    public static SeqParameterSet m415a(ByteBuffer byteBuffer) throws IOException {
        ByteBufferBitreader byteBufferBitreader = new ByteBufferBitreader(byteBuffer);
        SeqParameterSet seqParameterSet = new SeqParameterSet();
        seqParameterSet.f12330q = (int) byteBufferBitreader.m428a(8);
        seqParameterSet.f12332s = byteBufferBitreader.m425d();
        seqParameterSet.f12333t = byteBufferBitreader.m425d();
        seqParameterSet.f12334u = byteBufferBitreader.m425d();
        seqParameterSet.f12335v = byteBufferBitreader.m425d();
        seqParameterSet.f12336w = byteBufferBitreader.m425d();
        seqParameterSet.f12337x = byteBufferBitreader.m425d();
        seqParameterSet.f12331r = byteBufferBitreader.m428a(2);
        seqParameterSet.f12338y = (int) byteBufferBitreader.m428a(8);
        seqParameterSet.f12339z = byteBufferBitreader.m426c();
        int i = seqParameterSet.f12330q;
        if (i == 100 || i == 110 || i == 122 || i == 144) {
            seqParameterSet.f12322i = ChromaFormat.m420a(byteBufferBitreader.m426c());
            if (seqParameterSet.f12322i == ChromaFormat.f12254d) {
                seqParameterSet.f12299A = byteBufferBitreader.m425d();
            }
            seqParameterSet.f12327n = byteBufferBitreader.m426c();
            seqParameterSet.f12328o = byteBufferBitreader.m426c();
            seqParameterSet.f12329p = byteBufferBitreader.m425d();
            if (byteBufferBitreader.m425d()) {
                m413a(byteBufferBitreader, seqParameterSet);
            }
        } else {
            seqParameterSet.f12322i = ChromaFormat.f12252b;
        }
        seqParameterSet.f12323j = byteBufferBitreader.m426c();
        seqParameterSet.f12314a = byteBufferBitreader.m426c();
        int i2 = seqParameterSet.f12314a;
        if (i2 == 0) {
            seqParameterSet.f12324k = byteBufferBitreader.m426c();
        } else if (i2 == 1) {
            seqParameterSet.f12316c = byteBufferBitreader.m425d();
            seqParameterSet.f12300B = byteBufferBitreader.m424e();
            seqParameterSet.f12301C = byteBufferBitreader.m424e();
            seqParameterSet.f12313O = byteBufferBitreader.m426c();
            seqParameterSet.f12310L = new int[seqParameterSet.f12313O];
            for (int i3 = 0; i3 < seqParameterSet.f12313O; i3++) {
                seqParameterSet.f12310L[i3] = byteBufferBitreader.m424e();
            }
        }
        seqParameterSet.f12302D = byteBufferBitreader.m426c();
        seqParameterSet.f12303E = byteBufferBitreader.m425d();
        seqParameterSet.f12326m = byteBufferBitreader.m426c();
        seqParameterSet.f12325l = byteBufferBitreader.m426c();
        seqParameterSet.f12304F = byteBufferBitreader.m425d();
        if (!seqParameterSet.f12304F) {
            seqParameterSet.f12320g = byteBufferBitreader.m425d();
        }
        seqParameterSet.f12321h = byteBufferBitreader.m425d();
        seqParameterSet.f12305G = byteBufferBitreader.m425d();
        if (seqParameterSet.f12305G) {
            seqParameterSet.f12306H = byteBufferBitreader.m426c();
            seqParameterSet.f12307I = byteBufferBitreader.m426c();
            seqParameterSet.f12308J = byteBufferBitreader.m426c();
            seqParameterSet.f12309K = byteBufferBitreader.m426c();
        }
        if (byteBufferBitreader.m425d()) {
            seqParameterSet.f12311M = m414a(byteBufferBitreader);
        }
        return seqParameterSet;
    }

    /* renamed from: a */
    private static void m413a(ByteBufferBitreader byteBufferBitreader, SeqParameterSet seqParameterSet) throws IOException {
        seqParameterSet.f12312N = new ScalingMatrix();
        for (int i = 0; i < 8; i++) {
            if (byteBufferBitreader.m425d()) {
                ScalingMatrix scalingMatrix = seqParameterSet.f12312N;
                scalingMatrix.f12297a = new ScalingList[8];
                scalingMatrix.f12298b = new ScalingList[8];
                if (i < 6) {
                    scalingMatrix.f12297a[i] = ScalingList.m416a(byteBufferBitreader, 16);
                } else {
                    scalingMatrix.f12298b[i - 6] = ScalingList.m416a(byteBufferBitreader, 64);
                }
            }
        }
    }

    /* renamed from: a */
    private static VUIParameters m414a(ByteBufferBitreader byteBufferBitreader) throws IOException {
        VUIParameters vUIParameters = new VUIParameters();
        vUIParameters.f12340a = byteBufferBitreader.m425d();
        if (vUIParameters.f12340a) {
            vUIParameters.f12364y = AspectRatio.m430a((int) byteBufferBitreader.m428a(8));
            if (vUIParameters.f12364y == AspectRatio.f12245a) {
                vUIParameters.f12341b = (int) byteBufferBitreader.m428a(16);
                vUIParameters.f12342c = (int) byteBufferBitreader.m428a(16);
            }
        }
        vUIParameters.f12343d = byteBufferBitreader.m425d();
        if (vUIParameters.f12343d) {
            vUIParameters.f12344e = byteBufferBitreader.m425d();
        }
        vUIParameters.f12345f = byteBufferBitreader.m425d();
        if (vUIParameters.f12345f) {
            vUIParameters.f12346g = (int) byteBufferBitreader.m428a(3);
            vUIParameters.f12347h = byteBufferBitreader.m425d();
            vUIParameters.f12348i = byteBufferBitreader.m425d();
            if (vUIParameters.f12348i) {
                vUIParameters.f12349j = (int) byteBufferBitreader.m428a(8);
                vUIParameters.f12350k = (int) byteBufferBitreader.m428a(8);
                vUIParameters.f12351l = (int) byteBufferBitreader.m428a(8);
            }
        }
        vUIParameters.f12352m = byteBufferBitreader.m425d();
        if (vUIParameters.f12352m) {
            vUIParameters.f12353n = byteBufferBitreader.m426c();
            vUIParameters.f12354o = byteBufferBitreader.m426c();
        }
        vUIParameters.f12355p = byteBufferBitreader.m425d();
        if (vUIParameters.f12355p) {
            vUIParameters.f12356q = (int) byteBufferBitreader.m428a(32);
            vUIParameters.f12357r = (int) byteBufferBitreader.m428a(32);
            vUIParameters.f12358s = byteBufferBitreader.m425d();
        }
        boolean m425d = byteBufferBitreader.m425d();
        if (m425d) {
            vUIParameters.f12361v = m412b(byteBufferBitreader);
        }
        boolean m425d2 = byteBufferBitreader.m425d();
        if (m425d2) {
            vUIParameters.f12362w = m412b(byteBufferBitreader);
        }
        if (m425d || m425d2) {
            vUIParameters.f12359t = byteBufferBitreader.m425d();
        }
        vUIParameters.f12360u = byteBufferBitreader.m425d();
        if (byteBufferBitreader.m425d()) {
            vUIParameters.f12363x = new VUIParameters.C3136a();
            vUIParameters.f12363x.f12365a = byteBufferBitreader.m425d();
            vUIParameters.f12363x.f12366b = byteBufferBitreader.m426c();
            vUIParameters.f12363x.f12367c = byteBufferBitreader.m426c();
            vUIParameters.f12363x.f12368d = byteBufferBitreader.m426c();
            vUIParameters.f12363x.f12369e = byteBufferBitreader.m426c();
            vUIParameters.f12363x.f12370f = byteBufferBitreader.m426c();
            vUIParameters.f12363x.f12371g = byteBufferBitreader.m426c();
        }
        return vUIParameters;
    }

    /* renamed from: b */
    private static HRDParameters m412b(ByteBufferBitreader byteBufferBitreader) throws IOException {
        HRDParameters hRDParameters = new HRDParameters();
        hRDParameters.f12258a = byteBufferBitreader.m426c();
        hRDParameters.f12259b = (int) byteBufferBitreader.m428a(4);
        hRDParameters.f12260c = (int) byteBufferBitreader.m428a(4);
        hRDParameters.f12261d = new int[hRDParameters.f12258a + 1];
        hRDParameters.f12262e = new int[hRDParameters.f12258a + 1];
        hRDParameters.f12263f = new boolean[hRDParameters.f12258a + 1];
        for (int i = 0; i <= hRDParameters.f12258a; i++) {
            hRDParameters.f12261d[i] = byteBufferBitreader.m426c();
            hRDParameters.f12262e[i] = byteBufferBitreader.m426c();
            hRDParameters.f12263f[i] = byteBufferBitreader.m425d();
        }
        hRDParameters.f12264g = (int) byteBufferBitreader.m428a(5);
        hRDParameters.f12265h = (int) byteBufferBitreader.m428a(5);
        hRDParameters.f12266i = (int) byteBufferBitreader.m428a(5);
        hRDParameters.f12267j = (int) byteBufferBitreader.m428a(5);
        return hRDParameters;
    }

    public String toString() {
        return "SeqParameterSet{ \n        pic_order_cnt_type=" + this.f12314a + ", \n        field_pic_flag=" + this.f12315b + ", \n        delta_pic_order_always_zero_flag=" + this.f12316c + ", \n        weighted_pred_flag=" + this.f12317d + ", \n        weighted_bipred_idc=" + this.f12318e + ", \n        entropy_coding_mode_flag=" + this.f12319f + ", \n        mb_adaptive_frame_field_flag=" + this.f12320g + ", \n        direct_8x8_inference_flag=" + this.f12321h + ", \n        chroma_format_idc=" + this.f12322i + ", \n        log2_max_frame_num_minus4=" + this.f12323j + ", \n        log2_max_pic_order_cnt_lsb_minus4=" + this.f12324k + ", \n        pic_height_in_map_units_minus1=" + this.f12325l + ", \n        pic_width_in_mbs_minus1=" + this.f12326m + ", \n        bit_depth_luma_minus8=" + this.f12327n + ", \n        bit_depth_chroma_minus8=" + this.f12328o + ", \n        qpprime_y_zero_transform_bypass_flag=" + this.f12329p + ", \n        profile_idc=" + this.f12330q + ", \n        constraint_set_0_flag=" + this.f12332s + ", \n        constraint_set_1_flag=" + this.f12333t + ", \n        constraint_set_2_flag=" + this.f12334u + ", \n        constraint_set_3_flag=" + this.f12335v + ", \n        constraint_set_4_flag=" + this.f12336w + ", \n        constraint_set_5_flag=" + this.f12337x + ", \n        level_idc=" + this.f12338y + ", \n        seq_parameter_set_id=" + this.f12339z + ", \n        residual_color_transform_flag=" + this.f12299A + ", \n        offset_for_non_ref_pic=" + this.f12300B + ", \n        offset_for_top_to_bottom_field=" + this.f12301C + ", \n        num_ref_frames=" + this.f12302D + ", \n        gaps_in_frame_num_value_allowed_flag=" + this.f12303E + ", \n        frame_mbs_only_flag=" + this.f12304F + ", \n        frame_cropping_flag=" + this.f12305G + ", \n        frame_crop_left_offset=" + this.f12306H + ", \n        frame_crop_right_offset=" + this.f12307I + ", \n        frame_crop_top_offset=" + this.f12308J + ", \n        frame_crop_bottom_offset=" + this.f12309K + ", \n        offsetForRefFrame=" + this.f12310L + ", \n        vuiParams=" + this.f12311M + ", \n        scalingMatrix=" + this.f12312N + ", \n        num_ref_frames_in_pic_order_cnt_cycle=" + this.f12313O + '}';
    }
}
