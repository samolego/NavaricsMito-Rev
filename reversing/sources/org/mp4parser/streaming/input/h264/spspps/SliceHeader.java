package org.mp4parser.streaming.input.h264.spspps;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class SliceHeader {

    /* renamed from: a */
    public int f12225a;

    /* renamed from: b */
    public SliceType f12226b;

    /* renamed from: c */
    public int f12227c;

    /* renamed from: d */
    public int f12228d;

    /* renamed from: e */
    public int f12229e;

    /* renamed from: f */
    public boolean f12230f;

    /* renamed from: g */
    public boolean f12231g;

    /* renamed from: h */
    public int f12232h;

    /* renamed from: i */
    public int f12233i;

    /* renamed from: j */
    public int f12234j;

    /* renamed from: k */
    public int f12235k;

    /* renamed from: l */
    public int f12236l;

    /* renamed from: m */
    public PictureParameterSet f12237m;

    /* renamed from: n */
    public SeqParameterSet f12238n;

    /* loaded from: classes2.dex */
    public enum SliceType {
        P,
        B,
        I,
        SP,
        SI
    }

    public SliceHeader(ByteBuffer byteBuffer, Map<Integer, SeqParameterSet> map, Map<Integer, PictureParameterSet> map2, boolean z) {
        Iterator<Integer> it;
        Iterator<Integer> it2;
        this.f12230f = false;
        this.f12231g = false;
        this.f12232h = -1;
        try {
            byteBuffer.position(1);
            ByteBufferBitreader byteBufferBitreader = new ByteBufferBitreader(byteBuffer);
            this.f12225a = byteBufferBitreader.m426c();
            switch (byteBufferBitreader.m426c()) {
                case 0:
                case 5:
                    this.f12226b = SliceType.P;
                    break;
                case 1:
                case 6:
                    this.f12226b = SliceType.B;
                    break;
                case 2:
                case 7:
                    this.f12226b = SliceType.I;
                    break;
                case 3:
                case 8:
                    this.f12226b = SliceType.SP;
                    break;
                case 4:
                case 9:
                    this.f12226b = SliceType.SI;
                    break;
            }
            this.f12227c = byteBufferBitreader.m426c();
            this.f12237m = map2.get(Integer.valueOf(this.f12227c));
            if (this.f12237m == null) {
                String str = "";
                while (map2.keySet().iterator().hasNext()) {
                    str = str + it2.next() + ", ";
                }
                throw new RuntimeException("PPS with ids " + str + " available but not " + this.f12227c);
            }
            this.f12238n = map.get(Integer.valueOf(this.f12237m.f12273f));
            if (this.f12238n == null) {
                String str2 = "";
                while (map.keySet().iterator().hasNext()) {
                    str2 = str2 + it.next() + ", ";
                }
                throw new RuntimeException("SPS with ids " + str2 + " available but not " + this.f12237m.f12273f);
            }
            if (this.f12238n.f12299A) {
                this.f12228d = (int) byteBufferBitreader.m428a(2);
            }
            this.f12229e = (int) byteBufferBitreader.m428a(this.f12238n.f12323j + 4);
            if (!this.f12238n.f12304F) {
                this.f12230f = byteBufferBitreader.m425d();
                if (this.f12230f) {
                    this.f12231g = byteBufferBitreader.m425d();
                }
            }
            if (z) {
                this.f12232h = byteBufferBitreader.m426c();
            }
            if (this.f12238n.f12314a == 0) {
                this.f12233i = (int) byteBufferBitreader.m428a(this.f12238n.f12324k + 4);
                if (this.f12237m.f12274g && !this.f12230f) {
                    this.f12234j = byteBufferBitreader.m424e();
                }
            }
            if (this.f12238n.f12314a != 1 || this.f12238n.f12316c) {
                return;
            }
            this.f12235k = byteBufferBitreader.m424e();
            if (!this.f12237m.f12274g || this.f12230f) {
                return;
            }
            this.f12236l = byteBufferBitreader.m424e();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return "SliceHeader{first_mb_in_slice=" + this.f12225a + ", slice_type=" + this.f12226b + ", pic_parameter_set_id=" + this.f12227c + ", colour_plane_id=" + this.f12228d + ", frame_num=" + this.f12229e + ", field_pic_flag=" + this.f12230f + ", bottom_field_flag=" + this.f12231g + ", idr_pic_id=" + this.f12232h + ", pic_order_cnt_lsb=" + this.f12233i + ", delta_pic_order_cnt_bottom=" + this.f12234j + '}';
    }
}
