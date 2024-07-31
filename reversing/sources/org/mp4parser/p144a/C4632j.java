package org.mp4parser.p144a;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.mp4parser.Container;
import org.mp4parser.InterfaceC3117b;
import org.mp4parser.ParsableBox;
import org.mp4parser.support.AbstractContainerBox;

/* renamed from: org.mp4parser.a.j */
/* loaded from: classes2.dex */
public class Path {

    /* renamed from: a */
    static Pattern f11729a = Pattern.compile("(....|\\.\\.)(\\[(.*)\\])?");

    /* renamed from: a */
    public static <T extends InterfaceC3117b> T m711a(AbstractContainerBox abstractContainerBox, String str) {
        List m710a = m710a(abstractContainerBox, str, true);
        if (m710a.isEmpty()) {
            return null;
        }
        return (T) m710a.get(0);
    }

    /* renamed from: a */
    private static <T extends InterfaceC3117b> List<T> m710a(AbstractContainerBox abstractContainerBox, String str, boolean z) {
        return m712a((Object) abstractContainerBox, str, z);
    }

    /* renamed from: a */
    private static <T extends InterfaceC3117b> List<T> m712a(Object obj, String str, boolean z) {
        String str2;
        if (str.startsWith("/")) {
            throw new RuntimeException("Cannot start at / - only relative path expression into the structure are allowed");
        }
        if (str.length() == 0) {
            if (obj instanceof ParsableBox) {
                return Collections.singletonList((InterfaceC3117b) obj);
            }
            throw new RuntimeException("Result of path expression seems to be the root container. This is not allowed!");
        }
        int i = 0;
        if (str.contains("/")) {
            str2 = str.substring(str.indexOf(47) + 1);
            str = str.substring(0, str.indexOf(47));
        } else {
            str2 = "";
        }
        Matcher matcher = f11729a.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            if ("..".equals(group)) {
                throw new RuntimeException(".. notation no longer allowed");
            }
            if (obj instanceof Container) {
                int parseInt = matcher.group(2) != null ? Integer.parseInt(matcher.group(3)) : -1;
                LinkedList linkedList = new LinkedList();
                for (InterfaceC3117b interfaceC3117b : ((Container) obj).mo526a()) {
                    if (interfaceC3117b.mo399n_().matches(group)) {
                        if (parseInt == -1 || parseInt == i) {
                            linkedList.addAll(m712a(interfaceC3117b, str2, z));
                        }
                        i++;
                    }
                    if (z || parseInt >= 0) {
                        if (!linkedList.isEmpty()) {
                            return linkedList;
                        }
                    }
                }
                return linkedList;
            }
            return Collections.emptyList();
        }
        throw new RuntimeException(str + " is invalid path.");
    }
}
