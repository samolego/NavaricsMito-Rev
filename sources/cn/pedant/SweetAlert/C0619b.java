package cn.pedant.SweetAlert;

import android.content.Context;
import com.pnikosis.materialishprogress.ProgressWheel;

/* renamed from: cn.pedant.SweetAlert.b */
/* loaded from: classes.dex */
public class ProgressHelper {

    /* renamed from: a */
    private ProgressWheel f279a;

    /* renamed from: d */
    private int f282d;

    /* renamed from: e */
    private int f283e;

    /* renamed from: j */
    private int f288j;

    /* renamed from: b */
    private boolean f280b = true;

    /* renamed from: c */
    private float f281c = 0.75f;

    /* renamed from: f */
    private int f284f = 0;

    /* renamed from: g */
    private int f285g = 0;

    /* renamed from: h */
    private boolean f286h = false;

    /* renamed from: i */
    private float f287i = -1.0f;

    public ProgressHelper(Context context) {
        this.f282d = context.getResources().getDimensionPixelSize(R.dimen.common_circle_width) + 1;
        this.f283e = context.getResources().getColor(R.color.success_stroke_color);
        this.f288j = context.getResources().getDimensionPixelOffset(R.dimen.progress_circle_radius);
    }

    /* renamed from: a */
    public void m12673a(ProgressWheel progressWheel) {
        this.f279a = progressWheel;
        m12675a();
    }

    /* renamed from: a */
    private void m12675a() {
        ProgressWheel progressWheel = this.f279a;
        if (progressWheel != null) {
            if (!this.f280b && progressWheel.m5838a()) {
                this.f279a.m5834b();
            } else if (this.f280b && !this.f279a.m5838a()) {
                this.f279a.m5833c();
            }
            if (this.f281c != this.f279a.getSpinSpeed()) {
                this.f279a.setSpinSpeed(this.f281c);
            }
            if (this.f282d != this.f279a.getBarWidth()) {
                this.f279a.setBarWidth(this.f282d);
            }
            if (this.f283e != this.f279a.getBarColor()) {
                this.f279a.setBarColor(this.f283e);
            }
            if (this.f284f != this.f279a.getRimWidth()) {
                this.f279a.setRimWidth(this.f284f);
            }
            if (this.f285g != this.f279a.getRimColor()) {
                this.f279a.setRimColor(this.f285g);
            }
            if (this.f287i != this.f279a.getProgress()) {
                if (this.f286h) {
                    this.f279a.setInstantProgress(this.f287i);
                } else {
                    this.f279a.setProgress(this.f287i);
                }
            }
            if (this.f288j != this.f279a.getCircleRadius()) {
                this.f279a.setCircleRadius(this.f288j);
            }
        }
    }

    /* renamed from: a */
    public void m12674a(int i) {
        this.f283e = i;
        m12675a();
    }
}
