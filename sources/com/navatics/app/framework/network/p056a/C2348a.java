package com.navatics.app.framework.network.p056a;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import com.navatics.app.framework.network.service.ConnectionsService;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.navatics.app.framework.network.a.a */
/* loaded from: classes.dex */
public class ConnectionUtils {

    /* renamed from: a */
    public static final String f4730a = "a";

    /* renamed from: b */
    public static int f4731b = 2211;

    /* renamed from: a */
    public static byte m7983a(int i, int i2) {
        return (byte) (i >> (i2 * 8));
    }

    /* renamed from: a */
    public static boolean m7982a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean z = (activeNetworkInfo == null || !activeNetworkInfo.isConnected() || (activeNetworkInfo.getType() & 9) == 0) ? false : true;
        if (!z) {
            Log.d(f4730a, "isConnectedToLocalNetwork: see if it is an WIFI AP");
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            try {
                z = ((Boolean) wifiManager.getClass().getDeclaredMethod("isWifiApEnabled", new Class[0]).invoke(wifiManager, new Object[0])).booleanValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!z) {
            Log.d(f4730a, "isConnectedToLocalNetwork: see if it is an USB AP");
            try {
                Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                while (it.hasNext()) {
                    if (((NetworkInterface) it.next()).getDisplayName().startsWith("rndis")) {
                        z = true;
                    }
                }
            } catch (SocketException e2) {
                e2.printStackTrace();
            }
        }
        return z;
    }

    /* renamed from: b */
    public static boolean m7980b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
    }

    /* renamed from: c */
    public static InetAddress m7979c(Context context) {
        if (!m7982a(context)) {
            Log.e(f4730a, "getLocalInetAddress called and no connection");
            return null;
        } else if (m7980b(context)) {
            int ipAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress();
            if (ipAddress == 0) {
                return null;
            }
            return m7984a(ipAddress);
        } else {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && !nextElement.isLinkLocalAddress()) {
                            return nextElement;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public static InetAddress m7984a(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = m7983a(i, i2);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m7981b(int i) {
        ServerSocket serverSocket;
        DatagramSocket datagramSocket;
        DatagramSocket datagramSocket2 = null;
        try {
            serverSocket = new ServerSocket(i);
            try {
                serverSocket.setReuseAddress(true);
                datagramSocket = new DatagramSocket(i);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                datagramSocket.setReuseAddress(true);
                datagramSocket.close();
                try {
                    serverSocket.close();
                } catch (IOException unused2) {
                }
                return true;
            } catch (IOException unused3) {
                datagramSocket2 = datagramSocket;
                if (datagramSocket2 != null) {
                    datagramSocket2.close();
                }
                if (serverSocket != null) {
                    try {
                        serverSocket.close();
                        return false;
                    } catch (IOException unused4) {
                        return false;
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                datagramSocket2 = datagramSocket;
                if (datagramSocket2 != null) {
                    datagramSocket2.close();
                }
                if (serverSocket != null) {
                    try {
                        serverSocket.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        } catch (IOException unused6) {
            serverSocket = null;
        } catch (Throwable th3) {
            th = th3;
            serverSocket = null;
        }
    }

    /* renamed from: d */
    public static String m7978d(Context context) {
        InetAddress m7979c = m7979c(context);
        if (m7979c != null) {
            return "ftp://" + m7979c.getHostAddress() + ":" + f4731b;
        }
        return "";
    }

    /* renamed from: a */
    public static int m7985a() {
        for (int i = f4731b; i < 65000; i++) {
            if (m7981b(i)) {
                return i;
            }
        }
        return 0;
    }

    /* renamed from: e */
    public static boolean m7977e(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        String name = ConnectionsService.class.getName();
        for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
            if (name.equals(runningServiceInfo.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
