package org.apache.ftpserver.util;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;
import org.apache.ftpserver.ftplet.FtpException;

/* loaded from: classes2.dex */
public class BaseProperties extends Properties {
    private static final long serialVersionUID = 5572645129592131953L;

    public BaseProperties() {
    }

    public BaseProperties(Properties properties) {
        super(properties);
    }

    public boolean getBoolean(String str) throws FtpException {
        String property = getProperty(str);
        if (property == null) {
            throw new FtpException(str + " not found");
        }
        return property.toLowerCase().equals("true");
    }

    public boolean getBoolean(String str, boolean z) {
        try {
            return getBoolean(str);
        } catch (FtpException unused) {
            return z;
        }
    }

    public int getInteger(String str) throws FtpException {
        String property = getProperty(str);
        if (property == null) {
            throw new FtpException(str + " not found");
        }
        try {
            return Integer.parseInt(property);
        } catch (NumberFormatException e) {
            throw new FtpException("BaseProperties.getInteger()", e);
        }
    }

    public int getInteger(String str, int i) {
        try {
            return getInteger(str);
        } catch (FtpException unused) {
            return i;
        }
    }

    public long getLong(String str) throws FtpException {
        String property = getProperty(str);
        if (property == null) {
            throw new FtpException(str + " not found");
        }
        try {
            return Long.parseLong(property);
        } catch (NumberFormatException e) {
            throw new FtpException("BaseProperties.getLong()", e);
        }
    }

    public long getLong(String str, long j) {
        try {
            return getLong(str);
        } catch (FtpException unused) {
            return j;
        }
    }

    public double getDouble(String str) throws FtpException {
        String property = getProperty(str);
        if (property == null) {
            throw new FtpException(str + " not found");
        }
        try {
            return Double.parseDouble(property);
        } catch (NumberFormatException e) {
            throw new FtpException("BaseProperties.getDouble()", e);
        }
    }

    public double getDouble(String str, double d) {
        try {
            return getDouble(str);
        } catch (FtpException unused) {
            return d;
        }
    }

    public InetAddress getInetAddress(String str) throws FtpException {
        String property = getProperty(str);
        if (property == null) {
            throw new FtpException(str + " not found");
        }
        try {
            return InetAddress.getByName(property);
        } catch (UnknownHostException unused) {
            throw new FtpException("Host " + property + " not found");
        }
    }

    public InetAddress getInetAddress(String str, InetAddress inetAddress) {
        try {
            return getInetAddress(str);
        } catch (FtpException unused) {
            return inetAddress;
        }
    }

    public String getString(String str) throws FtpException {
        String property = getProperty(str);
        if (property != null) {
            return property;
        }
        throw new FtpException(str + " not found");
    }

    public String getString(String str, String str2) {
        try {
            return getString(str);
        } catch (FtpException unused) {
            return str2;
        }
    }

    public File getFile(String str) throws FtpException {
        String property = getProperty(str);
        if (property == null) {
            throw new FtpException(str + " not found");
        }
        return new File(property);
    }

    public File getFile(String str, File file) {
        try {
            return getFile(str);
        } catch (FtpException unused) {
            return file;
        }
    }

    public Class<?> getClass(String str) throws FtpException {
        String property = getProperty(str);
        if (property == null) {
            throw new FtpException(str + " not found");
        }
        try {
            return Class.forName(property);
        } catch (ClassNotFoundException e) {
            throw new FtpException("BaseProperties.getClass()", e);
        }
    }

    public Class<?> getClass(String str, Class<?> cls) {
        try {
            return getClass(str);
        } catch (FtpException unused) {
            return cls;
        }
    }

    public TimeZone getTimeZone(String str) throws FtpException {
        String property = getProperty(str);
        if (property == null) {
            throw new FtpException(str + " not found");
        }
        return TimeZone.getTimeZone(property);
    }

    public TimeZone getTimeZone(String str, TimeZone timeZone) {
        try {
            return getTimeZone(str);
        } catch (FtpException unused) {
            return timeZone;
        }
    }

    public SimpleDateFormat getDateFormat(String str) throws FtpException {
        String property = getProperty(str);
        if (property == null) {
            throw new FtpException(str + " not found");
        }
        try {
            return new SimpleDateFormat(property);
        } catch (IllegalArgumentException e) {
            throw new FtpException("Date format was incorrect: " + property, e);
        }
    }

    public SimpleDateFormat getDateFormat(String str, SimpleDateFormat simpleDateFormat) {
        try {
            return getDateFormat(str);
        } catch (FtpException unused) {
            return simpleDateFormat;
        }
    }

    public Date getDate(String str, DateFormat dateFormat) throws FtpException {
        String property = getProperty(str);
        if (property == null) {
            throw new FtpException(str + " not found");
        }
        try {
            return dateFormat.parse(property);
        } catch (ParseException e) {
            throw new FtpException("BaseProperties.getdate()", e);
        }
    }

    public Date getDate(String str, DateFormat dateFormat, Date date) {
        try {
            return getDate(str, dateFormat);
        } catch (FtpException unused) {
            return date;
        }
    }

    public void setProperty(String str, boolean z) {
        setProperty(str, String.valueOf(z));
    }

    public void setProperty(String str, int i) {
        setProperty(str, String.valueOf(i));
    }

    public void setProperty(String str, double d) {
        setProperty(str, String.valueOf(d));
    }

    public void setProperty(String str, float f) {
        setProperty(str, String.valueOf(f));
    }

    public void setProperty(String str, long j) {
        setProperty(str, String.valueOf(j));
    }

    public void setInetAddress(String str, InetAddress inetAddress) {
        setProperty(str, inetAddress.getHostAddress());
    }

    public void setProperty(String str, File file) {
        setProperty(str, file.getAbsolutePath());
    }

    public void setProperty(String str, SimpleDateFormat simpleDateFormat) {
        setProperty(str, simpleDateFormat.toPattern());
    }

    public void setProperty(String str, TimeZone timeZone) {
        setProperty(str, timeZone.getID());
    }

    public void setProperty(String str, Date date, DateFormat dateFormat) {
        setProperty(str, dateFormat.format(date));
    }

    public void setProperty(String str, Class<?> cls) {
        setProperty(str, cls.getName());
    }
}
