package com.usbsearch;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class ExecTerminal {

    /* renamed from: is */
    private DataInputStream f9155is;
    private BufferedReader mBufferedReader;
    private String mLine;
    private Process mProcess;
    private UsbDevInfo mUsbDevInfo = new UsbDevInfo();

    /* renamed from: os */
    private DataOutputStream f9156os;

    public boolean findUsb() {
        return this.mUsbDevInfo.findArtosynUsb();
    }

    public void exec(String str) {
        try {
            try {
                this.mProcess = Runtime.getRuntime().exec("sh");
                this.f9155is = new DataInputStream(this.mProcess.getInputStream());
                this.f9156os = new DataOutputStream(this.mProcess.getOutputStream());
                DataOutputStream dataOutputStream = this.f9156os;
                dataOutputStream.writeBytes(str + "\n");
                this.f9156os.writeBytes("exit\n");
                this.f9156os.flush();
                this.f9156os.close();
                this.mBufferedReader = new BufferedReader(new InputStreamReader(this.f9155is));
                while (true) {
                    try {
                        String readLine = this.mBufferedReader.readLine();
                        this.mLine = readLine;
                        if (readLine == null) {
                            return;
                        }
                        this.mUsbDevInfo.addLine(this.mLine);
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.mProcess.waitFor();
                        return;
                    }
                }
            } catch (InterruptedException e2) {
                System.err.println("exec, IOException 4");
                e2.printStackTrace();
            }
        } catch (IOException e3) {
            System.err.println("exec, IOException 2");
            e3.printStackTrace();
        }
    }
}
