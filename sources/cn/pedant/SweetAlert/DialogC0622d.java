package cn.pedant.SweetAlert;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.pnikosis.materialishprogress.ProgressWheel;
import java.util.List;

/* renamed from: cn.pedant.SweetAlert.d */
/* loaded from: classes.dex */
public class SweetAlertDialog extends Dialog implements View.OnClickListener {

    /* renamed from: A */
    private Button f301A;

    /* renamed from: B */
    private Button f302B;

    /* renamed from: C */
    private ProgressHelper f303C;

    /* renamed from: D */
    private FrameLayout f304D;

    /* renamed from: E */
    private InterfaceC0590a f305E;

    /* renamed from: F */
    private InterfaceC0590a f306F;

    /* renamed from: G */
    private boolean f307G;

    /* renamed from: a */
    private View f308a;

    /* renamed from: b */
    private AnimationSet f309b;

    /* renamed from: c */
    private AnimationSet f310c;

    /* renamed from: d */
    private Animation f311d;

    /* renamed from: e */
    private Animation f312e;

    /* renamed from: f */
    private AnimationSet f313f;

    /* renamed from: g */
    private AnimationSet f314g;

    /* renamed from: h */
    private Animation f315h;

    /* renamed from: i */
    private TextView f316i;

    /* renamed from: j */
    private TextView f317j;

    /* renamed from: k */
    private String f318k;

    /* renamed from: l */
    private String f319l;

    /* renamed from: m */
    private boolean f320m;

    /* renamed from: n */
    private boolean f321n;

    /* renamed from: o */
    private String f322o;

    /* renamed from: p */
    private String f323p;

    /* renamed from: q */
    private int f324q;

    /* renamed from: r */
    private FrameLayout f325r;

    /* renamed from: s */
    private FrameLayout f326s;

    /* renamed from: t */
    private FrameLayout f327t;

    /* renamed from: u */
    private SuccessTickView f328u;

    /* renamed from: v */
    private ImageView f329v;

    /* renamed from: w */
    private View f330w;

    /* renamed from: x */
    private View f331x;

    /* renamed from: y */
    private Drawable f332y;

    /* renamed from: z */
    private ImageView f333z;

    /* compiled from: SweetAlertDialog.java */
    /* renamed from: cn.pedant.SweetAlert.d$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0590a {
        /* renamed from: a */
        void m12653a(SweetAlertDialog sweetAlertDialog);
    }

    public SweetAlertDialog(Context context, int i) {
        super(context, R.style.alert_dialog);
        setCancelable(true);
        int i2 = 0;
        setCanceledOnTouchOutside(false);
        this.f303C = new ProgressHelper(context);
        this.f324q = i;
        this.f312e = OptAnimationLoader.m12678a(getContext(), R.anim.error_frame_in);
        this.f313f = (AnimationSet) OptAnimationLoader.m12678a(getContext(), R.anim.error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.f313f.getAnimations();
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.f315h = OptAnimationLoader.m12678a(getContext(), R.anim.success_bow_roate);
        this.f314g = (AnimationSet) OptAnimationLoader.m12678a(getContext(), R.anim.success_mask_layout);
        this.f309b = (AnimationSet) OptAnimationLoader.m12678a(getContext(), R.anim.modal_in);
        this.f310c = (AnimationSet) OptAnimationLoader.m12678a(getContext(), R.anim.modal_out);
        this.f310c.setAnimationListener(new Animation.AnimationListener() { // from class: cn.pedant.SweetAlert.d.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SweetAlertDialog.this.f308a.setVisibility(8);
                SweetAlertDialog.this.f308a.post(new Runnable() { // from class: cn.pedant.SweetAlert.d.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SweetAlertDialog.this.f307G) {
                            SweetAlertDialog.super.cancel();
                        } else {
                            SweetAlertDialog.super.dismiss();
                        }
                    }
                });
            }
        });
        this.f311d = new Animation() { // from class: cn.pedant.SweetAlert.d.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = SweetAlertDialog.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                SweetAlertDialog.this.getWindow().setAttributes(attributes);
            }
        };
        this.f311d.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.alert_dialog);
        this.f308a = getWindow().getDecorView().findViewById(16908290);
        this.f316i = (TextView) findViewById(R.id.title_text);
        this.f317j = (TextView) findViewById(R.id.content_text);
        this.f325r = (FrameLayout) findViewById(R.id.error_frame);
        this.f329v = (ImageView) this.f325r.findViewById(R.id.error_x);
        this.f326s = (FrameLayout) findViewById(R.id.success_frame);
        this.f327t = (FrameLayout) findViewById(R.id.progress_dialog);
        this.f328u = (SuccessTickView) this.f326s.findViewById(R.id.success_tick);
        this.f330w = this.f326s.findViewById(R.id.mask_left);
        this.f331x = this.f326s.findViewById(R.id.mask_right);
        this.f333z = (ImageView) findViewById(R.id.custom_image);
        this.f304D = (FrameLayout) findViewById(R.id.warning_frame);
        this.f301A = (Button) findViewById(R.id.confirm_button);
        this.f302B = (Button) findViewById(R.id.cancel_button);
        this.f303C.m12673a((ProgressWheel) findViewById(R.id.progressWheel));
        this.f301A.setOnClickListener(this);
        this.f302B.setOnClickListener(this);
        m12666a(this.f318k);
        m12662b(this.f319l);
        m12658c(this.f322o);
        m12654d(this.f323p);
        m12669a(this.f324q, true);
    }

    /* renamed from: c */
    private void m12660c() {
        this.f333z.setVisibility(8);
        this.f325r.setVisibility(8);
        this.f326s.setVisibility(8);
        this.f304D.setVisibility(8);
        this.f327t.setVisibility(8);
        this.f301A.setVisibility(0);
        this.f301A.setBackgroundResource(R.drawable.blue_button_background);
        this.f325r.clearAnimation();
        this.f329v.clearAnimation();
        this.f328u.clearAnimation();
        this.f330w.clearAnimation();
        this.f331x.clearAnimation();
    }

    /* renamed from: d */
    private void m12656d() {
        int i = this.f324q;
        if (i == 1) {
            this.f325r.startAnimation(this.f312e);
            this.f329v.startAnimation(this.f313f);
        } else if (i == 2) {
            this.f328u.m12690a();
            this.f331x.startAnimation(this.f315h);
        }
    }

    /* renamed from: a */
    private void m12669a(int i, boolean z) {
        this.f324q = i;
        if (this.f308a != null) {
            if (!z) {
                m12660c();
            }
            switch (this.f324q) {
                case 1:
                    this.f325r.setVisibility(0);
                    break;
                case 2:
                    this.f326s.setVisibility(0);
                    this.f330w.startAnimation(this.f314g.getAnimations().get(0));
                    this.f331x.startAnimation(this.f314g.getAnimations().get(1));
                    break;
                case 3:
                    this.f301A.setBackgroundResource(R.drawable.red_button_background);
                    this.f304D.setVisibility(0);
                    break;
                case 4:
                    m12668a(this.f332y);
                    break;
                case 5:
                    this.f327t.setVisibility(0);
                    this.f301A.setVisibility(8);
                    break;
            }
            if (z) {
                return;
            }
            m12656d();
        }
    }

    /* renamed from: a */
    public SweetAlertDialog m12666a(String str) {
        String str2;
        this.f318k = str;
        TextView textView = this.f316i;
        if (textView != null && (str2 = this.f318k) != null) {
            textView.setText(str2);
        }
        return this;
    }

    /* renamed from: a */
    public SweetAlertDialog m12668a(Drawable drawable) {
        this.f332y = drawable;
        ImageView imageView = this.f333z;
        if (imageView != null && this.f332y != null) {
            imageView.setVisibility(0);
            this.f333z.setImageDrawable(this.f332y);
        }
        return this;
    }

    /* renamed from: b */
    public SweetAlertDialog m12662b(String str) {
        this.f319l = str;
        if (this.f317j != null && this.f319l != null) {
            m12661b(true);
            this.f317j.setText(this.f319l);
        }
        return this;
    }

    /* renamed from: a */
    public SweetAlertDialog m12665a(boolean z) {
        this.f320m = z;
        Button button = this.f302B;
        if (button != null) {
            button.setVisibility(this.f320m ? 0 : 8);
        }
        return this;
    }

    /* renamed from: b */
    public SweetAlertDialog m12661b(boolean z) {
        this.f321n = z;
        TextView textView = this.f317j;
        if (textView != null) {
            textView.setVisibility(this.f321n ? 0 : 8);
        }
        return this;
    }

    /* renamed from: c */
    public SweetAlertDialog m12658c(String str) {
        this.f322o = str;
        if (this.f302B != null && this.f322o != null) {
            m12665a(true);
            this.f302B.setText(this.f322o);
        }
        return this;
    }

    /* renamed from: d */
    public SweetAlertDialog m12654d(String str) {
        String str2;
        this.f323p = str;
        Button button = this.f301A;
        if (button != null && (str2 = this.f323p) != null) {
            button.setText(str2);
        }
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.f308a.startAnimation(this.f309b);
        m12656d();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        m12657c(true);
    }

    /* renamed from: a */
    public void m12670a() {
        m12657c(false);
    }

    /* renamed from: c */
    private void m12657c(boolean z) {
        this.f307G = z;
        this.f301A.startAnimation(this.f311d);
        this.f308a.startAnimation(this.f310c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_button) {
            InterfaceC0590a interfaceC0590a = this.f305E;
            if (interfaceC0590a != null) {
                interfaceC0590a.m12653a(this);
            } else {
                m12670a();
            }
        } else if (view.getId() == R.id.confirm_button) {
            InterfaceC0590a interfaceC0590a2 = this.f306F;
            if (interfaceC0590a2 != null) {
                interfaceC0590a2.m12653a(this);
            } else {
                m12670a();
            }
        }
    }

    /* renamed from: b */
    public ProgressHelper m12664b() {
        return this.f303C;
    }
}
