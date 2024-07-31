package com.senseplay.control;

import android.os.RemoteException;

/* loaded from: classes2.dex */
public class SPControlServer {
    private static SPControlServer spControl;
    private JoystickListener joystickListener;
    private KeyListener keyListener;

    public static SPControlServer getInstance() {
        if (spControl == null) {
            synchronized (SPControlServer.class) {
                if (spControl == null) {
                    spControl = new SPControlServer();
                }
            }
        }
        return spControl;
    }

    private SPControlServer() {
    }

    public JoystickListener getJoystickListener() {
        return this.joystickListener;
    }

    public void setJoystickListener(JoystickListener joystickListener) {
        this.joystickListener = joystickListener;
    }

    public KeyListener getKeyListener() {
        return this.keyListener;
    }

    public void setKeyListener(KeyListener keyListener) {
        this.keyListener = keyListener;
    }

    public void setLinKInfo(boolean z, int i, int i2) {
        try {
            if (MBinder.iSendAidl != null) {
                MBinder.iSendAidl.setLinKInfo(z, i, i2);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setVechileInfo(String str, int i, int i2, float f, int i3, int i4, int i5) {
        try {
            if (MBinder.iSendAidl != null) {
                MBinder.iSendAidl.setVechileInfo(str, i, i2, f, i3, i4, i5);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
