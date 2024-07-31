package cn.bingoogolapple.qrcode.core;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.view.WindowManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraConfigurationManager.java */
/* renamed from: cn.bingoogolapple.qrcode.core.b */
/* loaded from: classes.dex */
public final class C0517b {

    /* renamed from: a */
    private static final Pattern f245a = Pattern.compile(",");

    /* renamed from: b */
    private final Context f246b;

    /* renamed from: c */
    private Point f247c;

    /* renamed from: d */
    private Point f248d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0517b(Context context) {
        this.f246b = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m259a(Camera camera) {
        Point m246b = BGAQRCodeUtil.m246b(this.f246b);
        Point point = new Point();
        point.x = m246b.x;
        point.y = m246b.y;
        if (BGAQRCodeUtil.m243a(this.f246b)) {
            point.x = m246b.y;
            point.y = m246b.x;
        }
        this.f248d = m251a(camera.getParameters(), point);
        if (BGAQRCodeUtil.m243a(this.f246b)) {
            this.f247c = new Point(this.f248d.y, this.f248d.x);
        } else {
            this.f247c = this.f248d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Point m258a() {
        return this.f247c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m260b(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        parameters.setPreviewSize(this.f248d.x, this.f248d.y);
        m254a(parameters);
        int[] m256a = m256a(camera, 15.0f);
        if (m256a != null) {
            parameters.setPreviewFpsRange(m256a[0], m256a[1]);
        }
        camera.setDisplayOrientation(m257b());
        camera.setParameters(parameters);
    }

    /* renamed from: a */
    private int[] m256a(Camera camera, float f) {
        int i = (int) (f * 1000.0f);
        int[] iArr = null;
        int i2 = Integer.MAX_VALUE;
        for (int[] iArr2 : camera.getParameters().getSupportedPreviewFpsRange()) {
            int abs = Math.abs(i - iArr2[0]) + Math.abs(i - iArr2[1]);
            if (abs < i2) {
                iArr = iArr2;
                i2 = abs;
            }
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m261c(Camera camera) {
        m255a(camera, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public void m262d(Camera camera) {
        m255a(camera, false);
    }

    /* renamed from: a */
    private void m255a(Camera camera, boolean z) {
        String m253a;
        Camera.Parameters parameters = camera.getParameters();
        if (z) {
            m253a = m253a(parameters.getSupportedFlashModes(), "torch", "on");
        } else {
            m253a = m253a(parameters.getSupportedFlashModes(), "off");
        }
        if (m253a != null) {
            parameters.setFlashMode(m253a);
        }
        camera.setParameters(parameters);
    }

    /* renamed from: a */
    private static String m253a(Collection<String> collection, String... strArr) {
        if (collection != null) {
            for (String str : strArr) {
                if (collection.contains(str)) {
                    return str;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    private int m257b() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i = 0;
        Camera.getCameraInfo(0, cameraInfo);
        WindowManager windowManager = (WindowManager) this.f246b.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        switch (windowManager.getDefaultDisplay().getRotation()) {
            case 1:
                i = 90;
                break;
            case 2:
                i = 180;
                break;
            case 3:
                i = 270;
                break;
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i) + 360) % 360;
    }

    /* renamed from: a */
    private static Point m251a(Camera.Parameters parameters, Point point) {
        Point m252a = m252a(parameters.getSupportedPreviewSizes(), point);
        return m252a == null ? new Point((point.x >> 3) << 3, (point.y >> 3) << 3) : m252a;
    }

    /* renamed from: a */
    private static Point m252a(List<Camera.Size> list, Point point) {
        Iterator<Camera.Size> it = list.iterator();
        int i = 0;
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Camera.Size next = it.next();
            int i4 = next.width;
            int i5 = next.height;
            int abs = Math.abs(i4 - point.x) + Math.abs(i5 - point.y);
            if (abs == 0) {
                i3 = i5;
                i = i4;
                break;
            }
            if (abs < i2) {
                i3 = i5;
                i = i4;
                i2 = abs;
            }
        }
        if (i <= 0 || i3 <= 0) {
            return null;
        }
        return new Point(i, i3);
    }

    /* renamed from: a */
    private static int m250a(CharSequence charSequence, int i) {
        int i2 = 0;
        for (String str : f245a.split(charSequence)) {
            try {
                double parseDouble = Double.parseDouble(str.trim());
                int i3 = (int) (10.0d * parseDouble);
                if (Math.abs(i - parseDouble) < Math.abs(i - i2)) {
                    i2 = i3;
                }
            } catch (NumberFormatException unused) {
                return i;
            }
        }
        return i2;
    }

    /* renamed from: a */
    private void m254a(Camera.Parameters parameters) {
        String str = parameters.get("zoom-supported");
        if (str == null || Boolean.parseBoolean(str)) {
            int i = 27;
            String str2 = parameters.get("max-zoom");
            if (str2 != null) {
                try {
                    int parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                    if (27 > parseDouble) {
                        i = parseDouble;
                    }
                } catch (NumberFormatException unused) {
                }
            }
            String str3 = parameters.get("taking-picture-zoom-max");
            if (str3 != null) {
                try {
                    int parseInt = Integer.parseInt(str3);
                    if (i > parseInt) {
                        i = parseInt;
                    }
                } catch (NumberFormatException unused2) {
                }
            }
            String str4 = parameters.get("mot-zoom-values");
            if (str4 != null) {
                i = m250a(str4, i);
            }
            String str5 = parameters.get("mot-zoom-step");
            if (str5 != null) {
                try {
                    int parseDouble2 = (int) (Double.parseDouble(str5.trim()) * 10.0d);
                    if (parseDouble2 > 1) {
                        i -= i % parseDouble2;
                    }
                } catch (NumberFormatException unused3) {
                }
            }
            if (str2 != null || str4 != null) {
                parameters.set("zoom", String.valueOf(i / 10.0d));
            }
            if (str3 != null) {
                parameters.set("taking-picture-zoom", i);
            }
        }
    }
}