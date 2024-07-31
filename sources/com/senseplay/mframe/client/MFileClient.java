package com.senseplay.mframe.client;

import com.senseplay.mframe.tool.MDebug;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/* loaded from: classes2.dex */
class MFileClient {
    private final String TAG = "MFileClient";

    MFileClient() {
    }

    private void downloadFile(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setUseCaches(true);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.addRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(""));
                byte[] bArr = new byte[1024];
                InputStream inputStream = httpURLConnection.getInputStream();
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } else {
                MDebug.m5825e("MFileClient", "文件下载失败");
            }
            httpURLConnection.disconnect();
        } catch (Error e) {
            MDebug.m5825e("MFileClient", e.toString());
        } catch (Exception e2) {
            MDebug.m5825e("MFileClient", e2.toString());
        }
    }

    private void upLoadFile(String str, String str2, HashMap<String, String> hashMap) {
        try {
            File file = new File(str2);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=*****");
            String name = file.getName();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.writeBytes("--*****\r\n");
            StringBuilder sb = new StringBuilder();
            sb.append("Content-Disposition: form-data; name=\"" + name + "\"; filename=\"" + name + "\"; ");
            int size = hashMap.size();
            int i = 0;
            for (String str3 : hashMap.keySet()) {
                sb.append(String.format("%s=\"%s\"", str3, hashMap.get(str3), "utf-8"));
                if (i < size - 1) {
                    sb.append("; ");
                }
                i++;
            }
            sb.append("\r\n");
            sb.append("Content-Type: application/octet-stream\r\n");
            sb.append("\r\n");
            dataOutputStream.writeBytes(sb.toString());
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[1024];
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            while (true) {
                int read = dataInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                dataOutputStream.write(bArr, 0, read);
            }
            dataOutputStream.writeBytes("\r\n");
            dataOutputStream.flush();
            dataOutputStream.writeBytes("--*****--\r\n");
            dataOutputStream.flush();
            fileInputStream.close();
            if (httpURLConnection.getResponseCode() == 200) {
                String streamToString = streamToString(httpURLConnection.getInputStream());
                MDebug.m5825e("MFileClient", "上传成功，result--->" + streamToString);
                return;
            }
            MDebug.m5825e("MFileClient", "上传失败");
        } catch (IOException e) {
            MDebug.m5825e("MFileClient", e.toString());
        } catch (Error e2) {
            MDebug.m5825e("MFileClient", e2.toString());
        }
    }

    public String streamToString(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.close();
                    inputStream.close();
                    return new String(byteArrayOutputStream.toByteArray());
                }
            }
        } catch (Exception e) {
            MDebug.m5825e("MFileClient", e.toString());
            return null;
        }
    }
}
