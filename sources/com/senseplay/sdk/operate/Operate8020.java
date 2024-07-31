package com.senseplay.sdk.operate;

import android.content.Context;
import android.support.media.ExifInterface;
import android.util.Log;
import android.widget.Toast;
import com.senseplay.sdk.SPDevice;
import com.senseplay.sdk.tool.PropertyTool;
import com.senseplay.sdk.tool.SPSysTool;

/* loaded from: classes2.dex */
public class Operate8020 {
    private static Operate8020 operate8020;
    private Context mContext;
    private final String path_8020 = "/sys/devices/soc/soc:ar8020/enable";
    private final String usb_switch = "/sys/bus/i2c/drivers/rtp5903/4-0060/switch";

    public static Operate8020 getInstance(Context context) {
        if (operate8020 == null) {
            synchronized (SPDevice.class) {
                if (operate8020 == null) {
                    operate8020 = new Operate8020(context);
                }
            }
        }
        return operate8020;
    }

    private Operate8020(Context context) {
        this.mContext = context;
    }

    public boolean isOpen() {
        String readFile = SPSysTool.readFile("/sys/devices/soc/soc:ar8020/enable");
        Log.w("8020", "" + readFile);
        return "1".equals(readFile);
    }

    public void open8020() {
        SPSysTool.writeFile("/sys/devices/soc/soc:ar8020/enable", "1");
        Toast.makeText(this.mContext, "open 8020", 0).show();
    }

    public void close8020() {
        SPSysTool.writeFile("/sys/devices/soc/soc:ar8020/enable", "0");
        Toast.makeText(this.mContext, "close 8020", 0).show();
    }

    public void switch3288() {
        SPSysTool.writeFile("/sys/bus/i2c/drivers/rtp5903/4-0060/switch", ExifInterface.GPS_MEASUREMENT_2D);
        Toast.makeText(this.mContext, "switch 3288", 0).show();
    }

    public void switch8020() {
        SPSysTool.writeFile("/sys/bus/i2c/drivers/rtp5903/4-0060/switch", "0");
        Toast.makeText(this.mContext, "switch 8020", 0).show();
    }

    public void powerOn() {
        PropertyTool.setProperty("sys.display.artosynpower", "on");
        Toast.makeText(this.mContext, "power on", 0).show();
    }

    public void powerOff() {
        PropertyTool.setProperty("sys.display.artosynpower", "off");
        Toast.makeText(this.mContext, "power off", 0).show();
    }
}
