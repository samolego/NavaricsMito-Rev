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
    private int f3328AD;

    /* renamed from: AE */
    private int f3329AE;

    /* renamed from: AF */
    private int f3330AF;

    /* renamed from: AG */
    private int f3331AG;

    /* renamed from: AH */
    private int f3332AH;

    /* renamed from: AI */
    private boolean f3333AI;

    /* renamed from: AJ */
    private zzb f3334AJ;

    /* renamed from: AK */
    private Drawable f3335AK;

    /* renamed from: AL */
    private Drawable f3336AL;

    /* renamed from: AM */
    private boolean f3337AM;

    /* renamed from: AN */
    private boolean f3338AN;

    /* renamed from: AO */
    private boolean f3339AO;

    /* renamed from: AP */
    private int f3340AP;

    /* renamed from: Ax */
    private boolean f3341Ax;

    /* renamed from: bZ */
    private long f3342bZ;
    private int mFrom;

    /* loaded from: classes.dex */
    private static final class zza extends Drawable {

        /* renamed from: AQ */
        private static final zza f3343AQ = new zza();

        /* renamed from: AR */
        private static final C3254zza f3344AR = new C3254zza();

        /* renamed from: com.google.android.gms.internal.zzrt$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static final class C3254zza extends Drawable.ConstantState {
            private C3254zza() {
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            public int getChangingConfigurations() {
                return 0;
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            public Drawable newDrawable() {
                return zza.f3343AQ;
            }
        }

        private zza() {
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
        }

        @Override // android.graphics.drawable.Drawable
        public Drawable.ConstantState getConstantState() {
            return f3344AR;
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
        int f3345AS;
        int mChangingConfigurations;

        zzb(zzb zzbVar) {
            if (zzbVar != null) {
                this.mChangingConfigurations = zzbVar.mChangingConfigurations;
                this.f3345AS = zzbVar.f3345AS;
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
        drawable = drawable == null ? zza.f3343AQ : drawable;
        this.f3335AK = drawable;
        drawable.setCallback(this);
        zzb zzbVar = this.f3334AJ;
        zzbVar.f3345AS = drawable.getChangingConfigurations() | zzbVar.f3345AS;
        drawable2 = drawable2 == null ? zza.f3343AQ : drawable2;
        this.f3336AL = drawable2;
        drawable2.setCallback(this);
        zzb zzbVar2 = this.f3334AJ;
        zzbVar2.f3345AS = drawable2.getChangingConfigurations() | zzbVar2.f3345AS;
    }

    zzrt(zzb zzbVar) {
        this.f3328AD = 0;
        this.f3330AF = 255;
        this.f3332AH = 0;
        this.f3341Ax = true;
        this.f3334AJ = new zzb(zzbVar);
    }

    public boolean canConstantState() {
        if (!this.f3337AM) {
            this.f3338AN = (this.f3335AK.getConstantState() == null || this.f3336AL.getConstantState() == null) ? false : true;
            this.f3337AM = true;
        }
        return this.f3338AN;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        switch (this.f3328AD) {
            case 1:
                this.f3342bZ = SystemClock.uptimeMillis();
                this.f3328AD = 2;
                r1 = false;
                break;
            case 2:
                if (this.f3342bZ >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f3342bZ)) / this.f3331AG;
                    r1 = uptimeMillis >= 1.0f;
                    if (r1) {
                        this.f3328AD = 0;
                    }
                    this.f3332AH = (int) (((this.f3329AE - 0) * Math.min(uptimeMillis, 1.0f)) + 0.0f);
                    break;
                }
                break;
        }
        int i = this.f3332AH;
        boolean z = this.f3341Ax;
        Drawable drawable = this.f3335AK;
        Drawable drawable2 = this.f3336AL;
        if (r1) {
            if (!z || i == 0) {
                drawable.draw(canvas);
            }
            int i2 = this.f3330AF;
            if (i == i2) {
                drawable2.setAlpha(i2);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z) {
            drawable.setAlpha(this.f3330AF - i);
        }
        drawable.draw(canvas);
        if (z) {
            drawable.setAlpha(this.f3330AF);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.f3330AF);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f3334AJ.mChangingConfigurations | this.f3334AJ.f3345AS;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (canConstantState()) {
            this.f3334AJ.mChangingConfigurations = getChangingConfigurations();
            return this.f3334AJ;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.f3335AK.getIntrinsicHeight(), this.f3336AL.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.f3335AK.getIntrinsicWidth(), this.f3336AL.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (!this.f3339AO) {
            this.f3340AP = Drawable.resolveOpacity(this.f3335AK.getOpacity(), this.f3336AL.getOpacity());
            this.f3339AO = true;
        }
        return this.f3340AP;
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
        if (!this.f3333AI && super.mutate() == this) {
            if (!canConstantState()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.f3335AK.mutate();
            this.f3336AL.mutate();
            this.f3333AI = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f3335AK.setBounds(rect);
        this.f3336AL.setBounds(rect);
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
        if (this.f3332AH == this.f3330AF) {
            this.f3332AH = i;
        }
        this.f3330AF = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3335AK.setColorFilter(colorFilter);
        this.f3336AL.setColorFilter(colorFilter);
    }

    public void startTransition(int i) {
        this.mFrom = 0;
        this.f3329AE = this.f3330AF;
        this.f3332AH = 0;
        this.f3331AG = i;
        this.f3328AD = 1;
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
        return this.f3336AL;
    }
}
