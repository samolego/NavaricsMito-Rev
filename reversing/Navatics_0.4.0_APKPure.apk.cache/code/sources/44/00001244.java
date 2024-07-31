package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

/* loaded from: classes.dex */
public final class zzrt extends Drawable implements Drawable.Callback {

    /* renamed from: AD */
    private int f3336AD;

    /* renamed from: AE */
    private int f3337AE;

    /* renamed from: AF */
    private int f3338AF;

    /* renamed from: AG */
    private int f3339AG;

    /* renamed from: AH */
    private int f3340AH;

    /* renamed from: AI */
    private boolean f3341AI;

    /* renamed from: AJ */
    private zzb f3342AJ;

    /* renamed from: AK */
    private Drawable f3343AK;

    /* renamed from: AL */
    private Drawable f3344AL;

    /* renamed from: AM */
    private boolean f3345AM;

    /* renamed from: AN */
    private boolean f3346AN;

    /* renamed from: AO */
    private boolean f3347AO;

    /* renamed from: AP */
    private int f3348AP;

    /* renamed from: Ax */
    private boolean f3349Ax;

    /* renamed from: bZ */
    private long f3350bZ;
    private int mFrom;

    /* loaded from: classes.dex */
    private static final class zza extends Drawable {

        /* renamed from: AQ */
        private static final zza f3351AQ = new zza();

        /* renamed from: AR */
        private static final C3574zza f3352AR = new C3574zza();

        /* renamed from: com.google.android.gms.internal.zzrt$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static final class C3574zza extends Drawable.ConstantState {
            private C3574zza() {
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            public int getChangingConfigurations() {
                return 0;
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            public Drawable newDrawable() {
                return zza.f3351AQ;
            }
        }

        private zza() {
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
        }

        @Override // android.graphics.drawable.Drawable
        public Drawable.ConstantState getConstantState() {
            return f3352AR;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class zzb extends Drawable.ConstantState {

        /* renamed from: AS */
        int f3353AS;
        int mChangingConfigurations;

        zzb(zzb zzbVar) {
            if (zzbVar != null) {
                this.mChangingConfigurations = zzbVar.mChangingConfigurations;
                this.f3353AS = zzbVar.f3353AS;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new zzrt(this);
        }
    }

    public zzrt(Drawable drawable, Drawable drawable2) {
        this(null);
        drawable = drawable == null ? zza.f3351AQ : drawable;
        this.f3343AK = drawable;
        drawable.setCallback(this);
        zzb zzbVar = this.f3342AJ;
        zzbVar.f3353AS = drawable.getChangingConfigurations() | zzbVar.f3353AS;
        drawable2 = drawable2 == null ? zza.f3351AQ : drawable2;
        this.f3344AL = drawable2;
        drawable2.setCallback(this);
        zzb zzbVar2 = this.f3342AJ;
        zzbVar2.f3353AS = drawable2.getChangingConfigurations() | zzbVar2.f3353AS;
    }

    zzrt(zzb zzbVar) {
        this.f3336AD = 0;
        this.f3338AF = 255;
        this.f3340AH = 0;
        this.f3349Ax = true;
        this.f3342AJ = new zzb(zzbVar);
    }

    public boolean canConstantState() {
        if (!this.f3345AM) {
            this.f3346AN = (this.f3343AK.getConstantState() == null || this.f3344AL.getConstantState() == null) ? false : true;
            this.f3345AM = true;
        }
        return this.f3346AN;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        switch (this.f3336AD) {
            case 1:
                this.f3350bZ = SystemClock.uptimeMillis();
                this.f3336AD = 2;
                r1 = false;
                break;
            case 2:
                if (this.f3350bZ >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f3350bZ)) / this.f3339AG;
                    r1 = uptimeMillis >= 1.0f;
                    if (r1) {
                        this.f3336AD = 0;
                    }
                    this.f3340AH = (int) (((this.f3337AE - 0) * Math.min(uptimeMillis, 1.0f)) + 0.0f);
                    break;
                }
                break;
        }
        int i = this.f3340AH;
        boolean z = this.f3349Ax;
        Drawable drawable = this.f3343AK;
        Drawable drawable2 = this.f3344AL;
        if (r1) {
            if (!z || i == 0) {
                drawable.draw(canvas);
            }
            int i2 = this.f3338AF;
            if (i == i2) {
                drawable2.setAlpha(i2);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z) {
            drawable.setAlpha(this.f3338AF - i);
        }
        drawable.draw(canvas);
        if (z) {
            drawable.setAlpha(this.f3338AF);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.f3338AF);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f3342AJ.mChangingConfigurations | this.f3342AJ.f3353AS;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.f3342AJ.mChangingConfigurations = getChangingConfigurations();
        return this.f3342AJ;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.f3343AK.getIntrinsicHeight(), this.f3344AL.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.f3343AK.getIntrinsicWidth(), this.f3344AL.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (!this.f3347AO) {
            this.f3348AP = Drawable.resolveOpacity(this.f3343AK.getOpacity(), this.f3344AL.getOpacity());
            this.f3347AO = true;
        }
        return this.f3348AP;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    @TargetApi(11)
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback;
        if (!com.google.android.gms.common.util.zzs.zzaxk() || (callback = getCallback()) == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f3341AI && super.mutate() == this) {
            if (!canConstantState()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.f3343AK.mutate();
            this.f3344AL.mutate();
            this.f3341AI = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f3343AK.setBounds(rect);
        this.f3344AL.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    @TargetApi(11)
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback;
        if (!com.google.android.gms.common.util.zzs.zzaxk() || (callback = getCallback()) == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f3340AH == this.f3338AF) {
            this.f3340AH = i;
        }
        this.f3338AF = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3343AK.setColorFilter(colorFilter);
        this.f3344AL.setColorFilter(colorFilter);
    }

    public void startTransition(int i) {
        this.mFrom = 0;
        this.f3337AE = this.f3338AF;
        this.f3340AH = 0;
        this.f3339AG = i;
        this.f3336AD = 1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    @TargetApi(11)
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback;
        if (!com.google.android.gms.common.util.zzs.zzaxk() || (callback = getCallback()) == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public Drawable zzatn() {
        return this.f3344AL;
    }
}