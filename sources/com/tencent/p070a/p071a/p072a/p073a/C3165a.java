package com.tencent.p070a.p071a.p072a.p073a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.a.a.a.a.a */
/* loaded from: classes2.dex */
final class C2394a {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static File m5575a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        if (!file.getParentFile().exists()) {
            m5575a(file.getParentFile().getAbsolutePath());
        }
        file.mkdir();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static List<String> m5576a(File file) {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                fileReader.close();
                bufferedReader.close();
                return arrayList;
            }
            arrayList.add(readLine.trim());
        }
    }
}