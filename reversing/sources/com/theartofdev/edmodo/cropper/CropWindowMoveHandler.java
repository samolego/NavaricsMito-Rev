package com.theartofdev.edmodo.cropper;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;

/* loaded from: classes2.dex */
final class CropWindowMoveHandler {

    /* renamed from: a */
    private static final Matrix f8325a = new Matrix();

    /* renamed from: b */
    private final float f8326b;

    /* renamed from: c */
    private final float f8327c;

    /* renamed from: d */
    private final float f8328d;

    /* renamed from: e */
    private final float f8329e;

    /* renamed from: f */
    private final Type f8330f;

    /* renamed from: g */
    private final PointF f8331g = new PointF();

    /* loaded from: classes2.dex */
    public enum Type {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        CENTER
    }

    /* renamed from: a */
    private static float m4660a(float f, float f2, float f3, float f4) {
        return (f3 - f) / (f4 - f2);
    }

    public CropWindowMoveHandler(Type type, CropWindowHandler cropWindowHandler, float f, float f2) {
        this.f8330f = type;
        this.f8326b = cropWindowHandler.m4597b();
        this.f8327c = cropWindowHandler.m4595c();
        this.f8328d = cropWindowHandler.m4593d();
        this.f8329e = cropWindowHandler.m4592e();
        m4658a(cropWindowHandler.m4606a(), f, f2);
    }

    /* renamed from: a */
    public void m4655a(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3, boolean z, float f4) {
        float f5 = f + this.f8331g.x;
        float f6 = f2 + this.f8331g.y;
        if (this.f8330f == Type.CENTER) {
            m4657a(rectF, f5, f6, rectF2, i, i2, f3);
        } else if (z) {
            m4656a(rectF, f5, f6, rectF2, i, i2, f3, f4);
        } else {
            m4650b(rectF, f5, f6, rectF2, i, i2, f3);
        }
    }

    /* renamed from: a */
    private void m4658a(RectF rectF, float f, float f2) {
        float f3;
        float f4 = 0.0f;
        switch (this.f8330f) {
            case TOP_LEFT:
                f4 = rectF.left - f;
                f3 = rectF.top - f2;
                break;
            case TOP_RIGHT:
                f4 = rectF.right - f;
                f3 = rectF.top - f2;
                break;
            case BOTTOM_LEFT:
                f4 = rectF.left - f;
                f3 = rectF.bottom - f2;
                break;
            case BOTTOM_RIGHT:
                f4 = rectF.right - f;
                f3 = rectF.bottom - f2;
                break;
            case LEFT:
                f4 = rectF.left - f;
                f3 = 0.0f;
                break;
            case TOP:
                f3 = rectF.top - f2;
                break;
            case RIGHT:
                f4 = rectF.right - f;
                f3 = 0.0f;
                break;
            case BOTTOM:
                f3 = rectF.bottom - f2;
                break;
            case CENTER:
                f4 = rectF.centerX() - f;
                f3 = rectF.centerY() - f2;
                break;
            default:
                f3 = 0.0f;
                break;
        }
        PointF pointF = this.f8331g;
        pointF.x = f4;
        pointF.y = f3;
    }

    /* renamed from: a */
    private void m4657a(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3) {
        float centerX = f - rectF.centerX();
        float centerY = f2 - rectF.centerY();
        if (rectF.left + centerX < 0.0f || rectF.right + centerX > i || rectF.left + centerX < rectF2.left || rectF.right + centerX > rectF2.right) {
            centerX /= 1.05f;
            this.f8331g.x -= centerX / 2.0f;
        }
        if (rectF.top + centerY < 0.0f || rectF.bottom + centerY > i2 || rectF.top + centerY < rectF2.top || rectF.bottom + centerY > rectF2.bottom) {
            centerY /= 1.05f;
            this.f8331g.y -= centerY / 2.0f;
        }
        rectF.offset(centerX, centerY);
        m4652a(rectF, rectF2, f3);
    }

    /* renamed from: b */
    private void m4650b(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3) {
        switch (this.f8330f) {
            case TOP_LEFT:
                m4649b(rectF, f2, rectF2, f3, 0.0f, false, false);
                m4654a(rectF, f, rectF2, f3, 0.0f, false, false);
                return;
            case TOP_RIGHT:
                m4649b(rectF, f2, rectF2, f3, 0.0f, false, false);
                m4653a(rectF, f, rectF2, i, f3, 0.0f, false, false);
                return;
            case BOTTOM_LEFT:
                m4648b(rectF, f2, rectF2, i2, f3, 0.0f, false, false);
                m4654a(rectF, f, rectF2, f3, 0.0f, false, false);
                return;
            case BOTTOM_RIGHT:
                m4648b(rectF, f2, rectF2, i2, f3, 0.0f, false, false);
                m4653a(rectF, f, rectF2, i, f3, 0.0f, false, false);
                return;
            case LEFT:
                m4654a(rectF, f, rectF2, f3, 0.0f, false, false);
                return;
            case TOP:
                m4649b(rectF, f2, rectF2, f3, 0.0f, false, false);
                return;
            case RIGHT:
                m4653a(rectF, f, rectF2, i, f3, 0.0f, false, false);
                return;
            case BOTTOM:
                m4648b(rectF, f2, rectF2, i2, f3, 0.0f, false, false);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m4656a(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3, float f4) {
        switch (this.f8330f) {
            case TOP_LEFT:
                if (m4660a(f, f2, rectF.right, rectF.bottom) < f4) {
                    m4649b(rectF, f2, rectF2, f3, f4, true, false);
                    m4659a(rectF, f4);
                    return;
                }
                m4654a(rectF, f, rectF2, f3, f4, true, false);
                m4651b(rectF, f4);
                return;
            case TOP_RIGHT:
                if (m4660a(rectF.left, f2, f, rectF.bottom) < f4) {
                    m4649b(rectF, f2, rectF2, f3, f4, false, true);
                    m4646c(rectF, f4);
                    return;
                }
                m4653a(rectF, f, rectF2, i, f3, f4, true, false);
                m4651b(rectF, f4);
                return;
            case BOTTOM_LEFT:
                if (m4660a(f, rectF.top, rectF.right, f2) < f4) {
                    m4648b(rectF, f2, rectF2, i2, f3, f4, true, false);
                    m4659a(rectF, f4);
                    return;
                }
                m4654a(rectF, f, rectF2, f3, f4, false, true);
                m4644d(rectF, f4);
                return;
            case BOTTOM_RIGHT:
                if (m4660a(rectF.left, rectF.top, f, f2) < f4) {
                    m4648b(rectF, f2, rectF2, i2, f3, f4, false, true);
                    m4646c(rectF, f4);
                    return;
                }
                m4653a(rectF, f, rectF2, i, f3, f4, false, true);
                m4644d(rectF, f4);
                return;
            case LEFT:
                m4654a(rectF, f, rectF2, f3, f4, true, true);
                m4645c(rectF, rectF2, f4);
                return;
            case TOP:
                m4649b(rectF, f2, rectF2, f3, f4, true, true);
                m4647b(rectF, rectF2, f4);
                return;
            case RIGHT:
                m4653a(rectF, f, rectF2, i, f3, f4, true, true);
                m4645c(rectF, rectF2, f4);
                return;
            case BOTTOM:
                m4648b(rectF, f2, rectF2, i2, f3, f4, true, true);
                m4647b(rectF, rectF2, f4);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m4652a(RectF rectF, RectF rectF2, float f) {
        if (rectF.left < rectF2.left + f) {
            rectF.offset(rectF2.left - rectF.left, 0.0f);
        }
        if (rectF.top < rectF2.top + f) {
            rectF.offset(0.0f, rectF2.top - rectF.top);
        }
        if (rectF.right > rectF2.right - f) {
            rectF.offset(rectF2.right - rectF.right, 0.0f);
        }
        if (rectF.bottom > rectF2.bottom - f) {
            rectF.offset(0.0f, rectF2.bottom - rectF.bottom);
        }
    }

    /* renamed from: a */
    private void m4654a(RectF rectF, float f, RectF rectF2, float f2, float f3, boolean z, boolean z2) {
        if (f < 0.0f) {
            f /= 1.05f;
            this.f8331g.x -= f / 1.1f;
        }
        if (f < rectF2.left) {
            this.f8331g.x -= (f - rectF2.left) / 2.0f;
        }
        if (f - rectF2.left < f2) {
            f = rectF2.left;
        }
        if (rectF.right - f < this.f8326b) {
            f = rectF.right - this.f8326b;
        }
        if (rectF.right - f > this.f8328d) {
            f = rectF.right - this.f8328d;
        }
        if (f - rectF2.left < f2) {
            f = rectF2.left;
        }
        if (f3 > 0.0f) {
            float f4 = (rectF.right - f) / f3;
            if (f4 < this.f8327c) {
                f = Math.max(rectF2.left, rectF.right - (this.f8327c * f3));
                f4 = (rectF.right - f) / f3;
            }
            if (f4 > this.f8329e) {
                f = Math.max(rectF2.left, rectF.right - (this.f8329e * f3));
                f4 = (rectF.right - f) / f3;
            }
            if (z && z2) {
                f = Math.max(f, Math.max(rectF2.left, rectF.right - (rectF2.height() * f3)));
            } else {
                if (z && rectF.bottom - f4 < rectF2.top) {
                    f = Math.max(rectF2.left, rectF.right - ((rectF.bottom - rectF2.top) * f3));
                    f4 = (rectF.right - f) / f3;
                }
                if (z2 && rectF.top + f4 > rectF2.bottom) {
                    f = Math.max(f, Math.max(rectF2.left, rectF.right - ((rectF2.bottom - rectF.top) * f3)));
                }
            }
        }
        rectF.left = f;
    }

    /* renamed from: a */
    private void m4653a(RectF rectF, float f, RectF rectF2, int i, float f2, float f3, boolean z, boolean z2) {
        float f4 = i;
        if (f > f4) {
            f = ((f - f4) / 1.05f) + f4;
            this.f8331g.x -= (f - f4) / 1.1f;
        }
        if (f > rectF2.right) {
            this.f8331g.x -= (f - rectF2.right) / 2.0f;
        }
        if (rectF2.right - f < f2) {
            f = rectF2.right;
        }
        if (f - rectF.left < this.f8326b) {
            f = rectF.left + this.f8326b;
        }
        if (f - rectF.left > this.f8328d) {
            f = rectF.left + this.f8328d;
        }
        if (rectF2.right - f < f2) {
            f = rectF2.right;
        }
        if (f3 > 0.0f) {
            float f5 = (f - rectF.left) / f3;
            if (f5 < this.f8327c) {
                f = Math.min(rectF2.right, rectF.left + (this.f8327c * f3));
                f5 = (f - rectF.left) / f3;
            }
            if (f5 > this.f8329e) {
                f = Math.min(rectF2.right, rectF.left + (this.f8329e * f3));
                f5 = (f - rectF.left) / f3;
            }
            if (z && z2) {
                f = Math.min(f, Math.min(rectF2.right, rectF.left + (rectF2.height() * f3)));
            } else {
                if (z && rectF.bottom - f5 < rectF2.top) {
                    f = Math.min(rectF2.right, rectF.left + ((rectF.bottom - rectF2.top) * f3));
                    f5 = (f - rectF.left) / f3;
                }
                if (z2 && rectF.top + f5 > rectF2.bottom) {
                    f = Math.min(f, Math.min(rectF2.right, rectF.left + ((rectF2.bottom - rectF.top) * f3)));
                }
            }
        }
        rectF.right = f;
    }

    /* renamed from: b */
    private void m4649b(RectF rectF, float f, RectF rectF2, float f2, float f3, boolean z, boolean z2) {
        if (f < 0.0f) {
            f /= 1.05f;
            this.f8331g.y -= f / 1.1f;
        }
        if (f < rectF2.top) {
            this.f8331g.y -= (f - rectF2.top) / 2.0f;
        }
        if (f - rectF2.top < f2) {
            f = rectF2.top;
        }
        if (rectF.bottom - f < this.f8327c) {
            f = rectF.bottom - this.f8327c;
        }
        if (rectF.bottom - f > this.f8329e) {
            f = rectF.bottom - this.f8329e;
        }
        if (f - rectF2.top < f2) {
            f = rectF2.top;
        }
        if (f3 > 0.0f) {
            float f4 = (rectF.bottom - f) * f3;
            if (f4 < this.f8326b) {
                f = Math.max(rectF2.top, rectF.bottom - (this.f8326b / f3));
                f4 = (rectF.bottom - f) * f3;
            }
            if (f4 > this.f8328d) {
                f = Math.max(rectF2.top, rectF.bottom - (this.f8328d / f3));
                f4 = (rectF.bottom - f) * f3;
            }
            if (z && z2) {
                f = Math.max(f, Math.max(rectF2.top, rectF.bottom - (rectF2.width() / f3)));
            } else {
                if (z && rectF.right - f4 < rectF2.left) {
                    f = Math.max(rectF2.top, rectF.bottom - ((rectF.right - rectF2.left) / f3));
                    f4 = (rectF.bottom - f) * f3;
                }
                if (z2 && rectF.left + f4 > rectF2.right) {
                    f = Math.max(f, Math.max(rectF2.top, rectF.bottom - ((rectF2.right - rectF.left) / f3)));
                }
            }
        }
        rectF.top = f;
    }

    /* renamed from: b */
    private void m4648b(RectF rectF, float f, RectF rectF2, int i, float f2, float f3, boolean z, boolean z2) {
        float f4 = i;
        if (f > f4) {
            f = ((f - f4) / 1.05f) + f4;
            this.f8331g.y -= (f - f4) / 1.1f;
        }
        if (f > rectF2.bottom) {
            this.f8331g.y -= (f - rectF2.bottom) / 2.0f;
        }
        if (rectF2.bottom - f < f2) {
            f = rectF2.bottom;
        }
        if (f - rectF.top < this.f8327c) {
            f = rectF.top + this.f8327c;
        }
        if (f - rectF.top > this.f8329e) {
            f = rectF.top + this.f8329e;
        }
        if (rectF2.bottom - f < f2) {
            f = rectF2.bottom;
        }
        if (f3 > 0.0f) {
            float f5 = (f - rectF.top) * f3;
            if (f5 < this.f8326b) {
                f = Math.min(rectF2.bottom, rectF.top + (this.f8326b / f3));
                f5 = (f - rectF.top) * f3;
            }
            if (f5 > this.f8328d) {
                f = Math.min(rectF2.bottom, rectF.top + (this.f8328d / f3));
                f5 = (f - rectF.top) * f3;
            }
            if (z && z2) {
                f = Math.min(f, Math.min(rectF2.bottom, rectF.top + (rectF2.width() / f3)));
            } else {
                if (z && rectF.right - f5 < rectF2.left) {
                    f = Math.min(rectF2.bottom, rectF.top + ((rectF.right - rectF2.left) / f3));
                    f5 = (f - rectF.top) * f3;
                }
                if (z2 && rectF.left + f5 > rectF2.right) {
                    f = Math.min(f, Math.min(rectF2.bottom, rectF.top + ((rectF2.right - rectF.left) / f3)));
                }
            }
        }
        rectF.bottom = f;
    }

    /* renamed from: a */
    private void m4659a(RectF rectF, float f) {
        rectF.left = rectF.right - (rectF.height() * f);
    }

    /* renamed from: b */
    private void m4651b(RectF rectF, float f) {
        rectF.top = rectF.bottom - (rectF.width() / f);
    }

    /* renamed from: c */
    private void m4646c(RectF rectF, float f) {
        rectF.right = rectF.left + (rectF.height() * f);
    }

    /* renamed from: d */
    private void m4644d(RectF rectF, float f) {
        rectF.bottom = rectF.top + (rectF.width() / f);
    }

    /* renamed from: b */
    private void m4647b(RectF rectF, RectF rectF2, float f) {
        rectF.inset((rectF.width() - (rectF.height() * f)) / 2.0f, 0.0f);
        if (rectF.left < rectF2.left) {
            rectF.offset(rectF2.left - rectF.left, 0.0f);
        }
        if (rectF.right > rectF2.right) {
            rectF.offset(rectF2.right - rectF.right, 0.0f);
        }
    }

    /* renamed from: c */
    private void m4645c(RectF rectF, RectF rectF2, float f) {
        rectF.inset(0.0f, (rectF.height() - (rectF.width() / f)) / 2.0f);
        if (rectF.top < rectF2.top) {
            rectF.offset(0.0f, rectF2.top - rectF.top);
        }
        if (rectF.bottom > rectF2.bottom) {
            rectF.offset(0.0f, rectF2.bottom - rectF.bottom);
        }
    }
}
