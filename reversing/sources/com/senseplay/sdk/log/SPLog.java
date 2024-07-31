package com.senseplay.sdk.log;

import android.content.Context;
import android.os.Environment;
import com.common.LOG_OUTPUT_LEVEL;
import com.common.LOG_OUTPUT_PORT;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public class SPLog {
    private static SPLog spLog;
    private FileOutputStream devOut;
    private FileOutputStream rcOut;
    private final String tag = SPLog.class.getSimpleName();
    private String logPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/senseplay/log/";
    private boolean isRcLog = false;
    private boolean isDevLog = false;

    public static SPLog getInstance(Context context) {
        if (spLog == null) {
            synchronized (SPLog.class) {
                if (spLog == null) {
                    spLog = new SPLog(context);
                }
            }
        }
        return spLog;
    }

    private SPLog(Context context) {
    }

    public void startRcLog(LOG_OUTPUT_PORT log_output_port, LOG_OUTPUT_LEVEL log_output_level) {
        saveRcLog(log_output_port, log_output_level);
        new RcLogThread().start();
    }

    public void startDevLog(LOG_OUTPUT_PORT log_output_port, LOG_OUTPUT_LEVEL log_output_level) {
        try {
            saveDevLog(log_output_port, log_output_level);
            new DevLogThread().start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void stopRcLog() {
        this.isRcLog = false;
        try {
            if (this.rcOut != null) {
                this.rcOut.flush();
                this.rcOut.close();
                this.rcOut = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopDevLog() {
        this.isDevLog = false;
        try {
            if (this.devOut != null) {
                this.devOut.flush();
                this.devOut.close();
                this.devOut = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveRcLog(LOG_OUTPUT_PORT log_output_port, LOG_OUTPUT_LEVEL log_output_level) {
        this.isRcLog = true;
        try {
            String str = this.logPath + "rc" + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".txt";
            File file = new File(this.logPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str);
            if (file2.isFile() && file2.exists()) {
                file2.delete();
            }
            this.rcOut = new FileOutputStream(file2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void saveDevLog(LOG_OUTPUT_PORT log_output_port, LOG_OUTPUT_LEVEL log_output_level) throws FileNotFoundException {
        this.isDevLog = true;
        try {
            String str = this.logPath + "dev" + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".txt";
            File file = new File(this.logPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str);
            if (file2.isFile() && file2.exists()) {
                file2.delete();
            }
            this.devOut = new FileOutputStream(file2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* loaded from: classes2.dex */
    class RcLogThread extends Thread {
        RcLogThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (SPLog.this.isRcLog) {
                try {
                    byte[] bArr = new byte[512];
                    String str = SPLog.this.tag;
                    SPDebug.m5807w(str, "rclog:0");
                    try {
                        Thread.sleep(30L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class DevLogThread extends Thread {
        DevLogThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (SPLog.this.isDevLog) {
                try {
                    byte[] bArr = new byte[512];
                    String str = SPLog.this.tag;
                    SPDebug.m5807w(str, "devlog:0");
                    try {
                        Thread.sleep(30L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void release() {
        spLog = null;
    }
}
