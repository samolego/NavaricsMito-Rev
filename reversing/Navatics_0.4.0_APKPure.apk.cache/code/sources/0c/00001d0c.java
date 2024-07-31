package com.senseplay.mframe.ota;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public class MD5Tool {
    public static String getFileMD5(File file) {
        if (!file.isFile()) {
            return "";
        }
        FileInputStream fileInputStream = null;
        byte[] bArr = new byte[1024];
        try {
            try {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    while (true) {
                        try {
                            int read = fileInputStream2.read(bArr, 0, 1024);
                            if (read == -1) {
                                break;
                            }
                            messageDigest.update(bArr, 0, read);
                        } catch (FileNotFoundException e) {
                            e = e;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream == null) {
                                return "";
                            }
                            fileInputStream.close();
                            return "";
                        } catch (IOException e2) {
                            e = e2;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream == null) {
                                return "";
                            }
                            fileInputStream.close();
                            return "";
                        } catch (NoSuchAlgorithmException e3) {
                            e = e3;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream == null) {
                                return "";
                            }
                            fileInputStream.close();
                            return "";
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    return bigInteger;
                } catch (FileNotFoundException e6) {
                    e = e6;
                } catch (IOException e7) {
                    e = e7;
                } catch (NoSuchAlgorithmException e8) {
                    e = e8;
                }
            } catch (IOException e9) {
                e9.printStackTrace();
                return "";
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}