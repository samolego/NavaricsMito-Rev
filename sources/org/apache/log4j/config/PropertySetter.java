package org.apache.log4j.config;

import com.tencent.bugly.BUGLY;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Properties;
import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.OptionHandler;

/* renamed from: org.apache.log4j.config.a */
/* loaded from: classes2.dex */
public class PropertySetter {

    /* renamed from: c */
    static Class f11165c;

    /* renamed from: d */
    static Class f11166d;

    /* renamed from: e */
    static Class f11167e;

    /* renamed from: f */
    static Class f11168f;

    /* renamed from: a */
    protected Object f11169a;

    /* renamed from: b */
    protected PropertyDescriptor[] f11170b;

    public PropertySetter(Object obj) {
        this.f11169a = obj;
    }

    /* renamed from: a */
    protected void m1629a() {
        try {
            this.f11170b = Introspector.getBeanInfo(this.f11169a.getClass()).getPropertyDescriptors();
        } catch (IntrospectionException e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Failed to introspect ");
            stringBuffer.append(this.f11169a);
            stringBuffer.append(": ");
            stringBuffer.append(e.getMessage());
            LogLog.m1597b(stringBuffer.toString());
            this.f11170b = new PropertyDescriptor[0];
        }
    }

    /* renamed from: a */
    public static void m1627a(Object obj, Properties properties, String str) {
        new PropertySetter(obj).m1623a(properties, str);
    }

    /* renamed from: a */
    public void m1623a(Properties properties, String str) {
        int length = str.length();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str2 = (String) propertyNames.nextElement();
            if (str2.startsWith(str) && str2.indexOf(46, length + 1) <= 0) {
                String m1588a = OptionConverter.m1588a(str2, properties);
                String substring = str2.substring(length);
                if ((!"layout".equals(substring) && !"errorhandler".equals(substring)) || !(this.f11169a instanceof Appender)) {
                    PropertyDescriptor m1626a = m1626a(Introspector.decapitalize(substring));
                    if (m1626a != null) {
                        Class cls = f11165c;
                        if (cls == null) {
                            cls = m1621b("org.apache.log4j.spi.k");
                            f11165c = cls;
                        }
                        if (cls.isAssignableFrom(m1626a.getPropertyType()) && m1626a.getWriteMethod() != null) {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(str);
                            stringBuffer.append(substring);
                            OptionHandler optionHandler = (OptionHandler) OptionConverter.m1584a(properties, stringBuffer.toString(), m1626a.getPropertyType(), null);
                            PropertySetter propertySetter = new PropertySetter(optionHandler);
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append(str);
                            stringBuffer2.append(substring);
                            stringBuffer2.append(".");
                            propertySetter.m1623a(properties, stringBuffer2.toString());
                            try {
                                m1626a.getWriteMethod().invoke(this.f11169a, optionHandler);
                            } catch (IllegalAccessException e) {
                                StringBuffer stringBuffer3 = new StringBuffer();
                                stringBuffer3.append("Failed to set property [");
                                stringBuffer3.append(substring);
                                stringBuffer3.append("] to value \"");
                                stringBuffer3.append(m1588a);
                                stringBuffer3.append("\". ");
                                LogLog.m1594c(stringBuffer3.toString(), e);
                            } catch (RuntimeException e2) {
                                StringBuffer stringBuffer4 = new StringBuffer();
                                stringBuffer4.append("Failed to set property [");
                                stringBuffer4.append(substring);
                                stringBuffer4.append("] to value \"");
                                stringBuffer4.append(m1588a);
                                stringBuffer4.append("\". ");
                                LogLog.m1594c(stringBuffer4.toString(), e2);
                            } catch (InvocationTargetException e3) {
                                if ((e3.getTargetException() instanceof InterruptedException) || (e3.getTargetException() instanceof InterruptedIOException)) {
                                    Thread.currentThread().interrupt();
                                }
                                StringBuffer stringBuffer5 = new StringBuffer();
                                stringBuffer5.append("Failed to set property [");
                                stringBuffer5.append(substring);
                                stringBuffer5.append("] to value \"");
                                stringBuffer5.append(m1588a);
                                stringBuffer5.append("\". ");
                                LogLog.m1594c(stringBuffer5.toString(), e3);
                            }
                        }
                    }
                    m1624a(substring, m1588a);
                }
            }
        }
        m1622b();
    }

    /* renamed from: b */
    static Class m1621b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    /* renamed from: a */
    public void m1624a(String str, String str2) {
        if (str2 == null) {
            return;
        }
        String decapitalize = Introspector.decapitalize(str);
        PropertyDescriptor m1626a = m1626a(decapitalize);
        if (m1626a == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No such property [");
            stringBuffer.append(decapitalize);
            stringBuffer.append("] in ");
            stringBuffer.append(this.f11169a.getClass().getName());
            stringBuffer.append(".");
            LogLog.m1595c(stringBuffer.toString());
            return;
        }
        try {
            m1628a(m1626a, decapitalize, str2);
        } catch (PropertySetterException e) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Failed to set property [");
            stringBuffer2.append(decapitalize);
            stringBuffer2.append("] to value \"");
            stringBuffer2.append(str2);
            stringBuffer2.append("\". ");
            LogLog.m1594c(stringBuffer2.toString(), e.rootCause);
        }
    }

    /* renamed from: a */
    public void m1628a(PropertyDescriptor propertyDescriptor, String str, String str2) throws PropertySetterException {
        Method writeMethod = propertyDescriptor.getWriteMethod();
        if (writeMethod == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No setter for property [");
            stringBuffer.append(str);
            stringBuffer.append("].");
            throw new PropertySetterException(stringBuffer.toString());
        }
        Class<?>[] parameterTypes = writeMethod.getParameterTypes();
        if (parameterTypes.length != 1) {
            throw new PropertySetterException("#params for setter != 1");
        }
        try {
            Object m1625a = m1625a(str2, parameterTypes[0]);
            if (m1625a == null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Conversion to type [");
                stringBuffer2.append(parameterTypes[0]);
                stringBuffer2.append("] failed.");
                throw new PropertySetterException(stringBuffer2.toString());
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Setting property [");
            stringBuffer3.append(str);
            stringBuffer3.append("] to [");
            stringBuffer3.append(m1625a);
            stringBuffer3.append("].");
            LogLog.m1600a(stringBuffer3.toString());
            try {
                writeMethod.invoke(this.f11169a, m1625a);
            } catch (IllegalAccessException e) {
                throw new PropertySetterException(e);
            } catch (RuntimeException e2) {
                throw new PropertySetterException(e2);
            } catch (InvocationTargetException e3) {
                if ((e3.getTargetException() instanceof InterruptedException) || (e3.getTargetException() instanceof InterruptedIOException)) {
                    Thread.currentThread().interrupt();
                }
                throw new PropertySetterException(e3);
            }
        } catch (Throwable th) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Conversion to type [");
            stringBuffer4.append(parameterTypes[0]);
            stringBuffer4.append("] failed. Reason: ");
            stringBuffer4.append(th);
            throw new PropertySetterException(stringBuffer4.toString());
        }
    }

    /* renamed from: a */
    protected Object m1625a(String str, Class cls) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        Class cls2 = f11166d;
        if (cls2 == null) {
            cls2 = m1621b("java.lang.String");
            f11166d = cls2;
        }
        if (cls2.isAssignableFrom(cls)) {
            return str;
        }
        if (Integer.TYPE.isAssignableFrom(cls)) {
            return new Integer(trim);
        }
        if (Long.TYPE.isAssignableFrom(cls)) {
            return new Long(trim);
        }
        if (Boolean.TYPE.isAssignableFrom(cls)) {
            if ("true".equalsIgnoreCase(trim)) {
                return Boolean.TRUE;
            }
            if (BUGLY.SDK_IS_DEV.equalsIgnoreCase(trim)) {
                return Boolean.FALSE;
            }
        } else {
            Class cls3 = f11167e;
            if (cls3 == null) {
                cls3 = m1621b("org.apache.log4j.q");
                f11167e = cls3;
            }
            if (cls3.isAssignableFrom(cls)) {
                return OptionConverter.m1587a(trim, Level.DEBUG);
            }
            Class cls4 = f11168f;
            if (cls4 == null) {
                cls4 = m1621b("org.apache.log4j.spi.d");
                f11168f = cls4;
            }
            if (cls4.isAssignableFrom(cls)) {
                Class cls5 = f11168f;
                if (cls5 == null) {
                    cls5 = m1621b("org.apache.log4j.spi.d");
                    f11168f = cls5;
                }
                return OptionConverter.m1590a(trim, cls5, (Object) null);
            }
        }
        return null;
    }

    /* renamed from: a */
    protected PropertyDescriptor m1626a(String str) {
        if (this.f11170b == null) {
            m1629a();
        }
        int i = 0;
        while (true) {
            PropertyDescriptor[] propertyDescriptorArr = this.f11170b;
            if (i >= propertyDescriptorArr.length) {
                return null;
            }
            if (str.equals(propertyDescriptorArr[i].getName())) {
                return this.f11170b[i];
            }
            i++;
        }
    }

    /* renamed from: b */
    public void m1622b() {
        Object obj = this.f11169a;
        if (obj instanceof OptionHandler) {
            ((OptionHandler) obj).mo1470e();
        }
    }
}
