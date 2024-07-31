package org.mp4parser.streaming.input.h264.spspps;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* renamed from: org.mp4parser.streaming.input.h264.spspps.e */
/* loaded from: classes2.dex */
public class PictureParameterSet {

    /* renamed from: a */
    public boolean f12268a;

    /* renamed from: b */
    public int f12269b;

    /* renamed from: c */
    public int f12270c;

    /* renamed from: d */
    public int f12271d;

    /* renamed from: e */
    public int f12272e;

    /* renamed from: f */
    public int f12273f;

    /* renamed from: g */
    public boolean f12274g;

    /* renamed from: h */
    public int f12275h;

    /* renamed from: i */
    public int f12276i;

    /* renamed from: j */
    public boolean f12277j;

    /* renamed from: k */
    public int f12278k;

    /* renamed from: l */
    public int f12279l;

    /* renamed from: m */
    public int f12280m;

    /* renamed from: n */
    public int f12281n;

    /* renamed from: o */
    public boolean f12282o;

    /* renamed from: p */
    public boolean f12283p;

    /* renamed from: q */
    public boolean f12284q;

    /* renamed from: r */
    public int[] f12285r;

    /* renamed from: s */
    public int[] f12286s;

    /* renamed from: t */
    public int[] f12287t;

    /* renamed from: u */
    public boolean f12288u;

    /* renamed from: v */
    public int[] f12289v;

    /* renamed from: w */
    public C3135a f12290w;

    /* renamed from: a */
    public static PictureParameterSet m417a(ByteBuffer byteBuffer) throws IOException {
        ByteBufferBitreader byteBufferBitreader = new ByteBufferBitreader(byteBuffer);
        PictureParameterSet pictureParameterSet = new PictureParameterSet();
        pictureParameterSet.f12272e = byteBufferBitreader.m426c();
        pictureParameterSet.f12273f = byteBufferBitreader.m426c();
        pictureParameterSet.f12268a = byteBufferBitreader.m425d();
        pictureParameterSet.f12274g = byteBufferBitreader.m425d();
        pictureParameterSet.f12275h = byteBufferBitreader.m426c();
        if (pictureParameterSet.f12275h > 0) {
            pictureParameterSet.f12276i = byteBufferBitreader.m426c();
            int i = pictureParameterSet.f12275h;
            pictureParameterSet.f12285r = new int[i + 1];
            pictureParameterSet.f12286s = new int[i + 1];
            pictureParameterSet.f12287t = new int[i + 1];
            int i2 = pictureParameterSet.f12276i;
            if (i2 == 0) {
                for (int i3 = 0; i3 <= pictureParameterSet.f12275h; i3++) {
                    pictureParameterSet.f12287t[i3] = byteBufferBitreader.m426c();
                }
            } else if (i2 == 2) {
                for (int i4 = 0; i4 < pictureParameterSet.f12275h; i4++) {
                    pictureParameterSet.f12285r[i4] = byteBufferBitreader.m426c();
                    pictureParameterSet.f12286s[i4] = byteBufferBitreader.m426c();
                }
            } else if (i2 == 3 || i2 == 4 || i2 == 5) {
                pictureParameterSet.f12288u = byteBufferBitreader.m425d();
                pictureParameterSet.f12271d = byteBufferBitreader.m426c();
            } else if (i2 == 6) {
                int i5 = i + 1 <= 4 ? i + 1 > 2 ? 2 : 1 : 3;
                int m426c = byteBufferBitreader.m426c();
                pictureParameterSet.f12289v = new int[m426c + 1];
                for (int i6 = 0; i6 <= m426c; i6++) {
                    pictureParameterSet.f12289v[i6] = (int) byteBufferBitreader.m428a(i5);
                }
            }
        }
        pictureParameterSet.f12269b = byteBufferBitreader.m426c();
        pictureParameterSet.f12270c = byteBufferBitreader.m426c();
        pictureParameterSet.f12277j = byteBufferBitreader.m425d();
        pictureParameterSet.f12278k = (int) byteBufferBitreader.m428a(2);
        pictureParameterSet.f12279l = byteBufferBitreader.m424e();
        pictureParameterSet.f12280m = byteBufferBitreader.m424e();
        pictureParameterSet.f12281n = byteBufferBitreader.m424e();
        pictureParameterSet.f12282o = byteBufferBitreader.m425d();
        pictureParameterSet.f12283p = byteBufferBitreader.m425d();
        pictureParameterSet.f12284q = byteBufferBitreader.m425d();
        if (byteBufferBitreader.m423f()) {
            pictureParameterSet.f12290w = new C3135a();
            pictureParameterSet.f12290w.f12291a = byteBufferBitreader.m425d();
            if (byteBufferBitreader.m425d()) {
                for (int i7 = 0; i7 < ((pictureParameterSet.f12290w.f12291a ? 1 : 0) * 2) + 6; i7++) {
                    if (byteBufferBitreader.m425d()) {
                        pictureParameterSet.f12290w.f12292b.f12297a = new ScalingList[8];
                        pictureParameterSet.f12290w.f12292b.f12298b = new ScalingList[8];
                        if (i7 < 6) {
                            pictureParameterSet.f12290w.f12292b.f12297a[i7] = ScalingList.m416a(byteBufferBitreader, 16);
                        } else {
                            pictureParameterSet.f12290w.f12292b.f12298b[i7 - 6] = ScalingList.m416a(byteBufferBitreader, 64);
                        }
                    }
                }
            }
            pictureParameterSet.f12290w.f12293c = byteBufferBitreader.m424e();
        }
        return pictureParameterSet;
    }

    public int hashCode() {
        int hashCode = (((((((((Arrays.hashCode(this.f12286s) + 31) * 31) + this.f12281n) * 31) + (this.f12283p ? 1231 : 1237)) * 31) + (this.f12282o ? 1231 : 1237)) * 31) + (this.f12268a ? 1231 : 1237)) * 31;
        C3135a c3135a = this.f12290w;
        return ((((((((((((((((((((((((((((((((((hashCode + (c3135a == null ? 0 : c3135a.hashCode())) * 31) + this.f12269b) * 31) + this.f12270c) * 31) + this.f12275h) * 31) + this.f12279l) * 31) + this.f12280m) * 31) + (this.f12274g ? 1231 : 1237)) * 31) + this.f12272e) * 31) + (this.f12284q ? 1231 : 1237)) * 31) + Arrays.hashCode(this.f12287t)) * 31) + this.f12273f) * 31) + (this.f12288u ? 1231 : 1237)) * 31) + this.f12271d) * 31) + Arrays.hashCode(this.f12289v)) * 31) + this.f12276i) * 31) + Arrays.hashCode(this.f12285r)) * 31) + this.f12278k) * 31) + (this.f12277j ? 1231 : 1237);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PictureParameterSet pictureParameterSet = (PictureParameterSet) obj;
            if (Arrays.equals(this.f12286s, pictureParameterSet.f12286s) && this.f12281n == pictureParameterSet.f12281n && this.f12283p == pictureParameterSet.f12283p && this.f12282o == pictureParameterSet.f12282o && this.f12268a == pictureParameterSet.f12268a) {
                C3135a c3135a = this.f12290w;
                if (c3135a == null) {
                    if (pictureParameterSet.f12290w != null) {
                        return false;
                    }
                } else if (!c3135a.equals(pictureParameterSet.f12290w)) {
                    return false;
                }
                return this.f12269b == pictureParameterSet.f12269b && this.f12270c == pictureParameterSet.f12270c && this.f12275h == pictureParameterSet.f12275h && this.f12279l == pictureParameterSet.f12279l && this.f12280m == pictureParameterSet.f12280m && this.f12274g == pictureParameterSet.f12274g && this.f12272e == pictureParameterSet.f12272e && this.f12284q == pictureParameterSet.f12284q && Arrays.equals(this.f12287t, pictureParameterSet.f12287t) && this.f12273f == pictureParameterSet.f12273f && this.f12288u == pictureParameterSet.f12288u && this.f12271d == pictureParameterSet.f12271d && Arrays.equals(this.f12289v, pictureParameterSet.f12289v) && this.f12276i == pictureParameterSet.f12276i && Arrays.equals(this.f12285r, pictureParameterSet.f12285r) && this.f12278k == pictureParameterSet.f12278k && this.f12277j == pictureParameterSet.f12277j;
            }
            return false;
        }
        return false;
    }

    public String toString() {
        return "PictureParameterSet{\n       entropy_coding_mode_flag=" + this.f12268a + ",\n       num_ref_idx_l0_active_minus1=" + this.f12269b + ",\n       num_ref_idx_l1_active_minus1=" + this.f12270c + ",\n       slice_group_change_rate_minus1=" + this.f12271d + ",\n       pic_parameter_set_id=" + this.f12272e + ",\n       seq_parameter_set_id=" + this.f12273f + ",\n       pic_order_present_flag=" + this.f12274g + ",\n       num_slice_groups_minus1=" + this.f12275h + ",\n       slice_group_map_type=" + this.f12276i + ",\n       weighted_pred_flag=" + this.f12277j + ",\n       weighted_bipred_idc=" + this.f12278k + ",\n       pic_init_qp_minus26=" + this.f12279l + ",\n       pic_init_qs_minus26=" + this.f12280m + ",\n       chroma_qp_index_offset=" + this.f12281n + ",\n       deblocking_filter_control_present_flag=" + this.f12282o + ",\n       constrained_intra_pred_flag=" + this.f12283p + ",\n       redundant_pic_cnt_present_flag=" + this.f12284q + ",\n       top_left=" + this.f12285r + ",\n       bottom_right=" + this.f12286s + ",\n       run_length_minus1=" + this.f12287t + ",\n       slice_group_change_direction_flag=" + this.f12288u + ",\n       slice_group_id=" + this.f12289v + ",\n       extended=" + this.f12290w + '}';
    }

    /* compiled from: PictureParameterSet.java */
    /* renamed from: org.mp4parser.streaming.input.h264.spspps.e$a */
    /* loaded from: classes2.dex */
    public static class C3135a {

        /* renamed from: a */
        public boolean f12291a;

        /* renamed from: b */
        public ScalingMatrix f12292b = new ScalingMatrix();

        /* renamed from: c */
        public int f12293c;

        /* renamed from: d */
        public boolean[] f12294d;

        public String toString() {
            return "PPSExt{transform_8x8_mode_flag=" + this.f12291a + ", scalindMatrix=" + this.f12292b + ", second_chroma_qp_index_offset=" + this.f12293c + ", pic_scaling_list_present_flag=" + this.f12294d + '}';
        }
    }
}
