package org.apache.log4j.spi;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.MDC;
import org.apache.log4j.NDC;
import org.apache.log4j.Priority;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.helpers.LogLog;

/* loaded from: classes2.dex */
public class LoggingEvent implements Serializable {
    static final String TO_LEVEL = "toLevel";
    static Class class$org$apache$log4j$Level = null;
    static final long serialVersionUID = -868428216207166145L;

    /* renamed from: b */
    private transient Category f11281b;

    /* renamed from: c */
    private transient Object f11282c;
    public final String categoryName;
    public final transient String fqnOfCategoryClass;
    public transient Priority level;
    private LocationInfo locationInfo;
    private Hashtable mdcCopy;
    private boolean mdcCopyLookupRequired;
    private String ndc;
    private boolean ndcLookupRequired;
    private String renderedMessage;
    private String threadName;
    private ThrowableInformation throwableInfo;
    public final long timeStamp;

    /* renamed from: a */
    private static long f11280a = System.currentTimeMillis();
    static final Integer[] PARAM_ARRAY = new Integer[1];
    static final Class[] TO_LEVEL_PARAMS = {Integer.TYPE};
    static final Hashtable methodCache = new Hashtable(3);

    public LoggingEvent(String str, Category category, Priority priority, Object obj, Throwable th) {
        this.ndcLookupRequired = true;
        this.mdcCopyLookupRequired = true;
        this.fqnOfCategoryClass = str;
        this.f11281b = category;
        this.categoryName = category.m1631e();
        this.level = priority;
        this.f11282c = obj;
        if (th != null) {
            this.throwableInfo = new ThrowableInformation(th, category);
        }
        this.timeStamp = System.currentTimeMillis();
    }

    public LoggingEvent(String str, Category category, long j, Priority priority, Object obj, Throwable th) {
        this.ndcLookupRequired = true;
        this.mdcCopyLookupRequired = true;
        this.fqnOfCategoryClass = str;
        this.f11281b = category;
        this.categoryName = category.m1631e();
        this.level = priority;
        this.f11282c = obj;
        if (th != null) {
            this.throwableInfo = new ThrowableInformation(th, category);
        }
        this.timeStamp = j;
    }

    public LoggingEvent(String str, Category category, long j, Level level, Object obj, String str2, ThrowableInformation throwableInformation, String str3, LocationInfo locationInfo, Map map) {
        this.ndcLookupRequired = true;
        this.mdcCopyLookupRequired = true;
        this.fqnOfCategoryClass = str;
        this.f11281b = category;
        if (category != null) {
            this.categoryName = category.m1631e();
        } else {
            this.categoryName = null;
        }
        this.level = level;
        this.f11282c = obj;
        if (throwableInformation != null) {
            this.throwableInfo = throwableInformation;
        }
        this.timeStamp = j;
        this.threadName = str2;
        this.ndcLookupRequired = false;
        this.ndc = str3;
        this.locationInfo = locationInfo;
        this.mdcCopyLookupRequired = false;
        if (map != null) {
            this.mdcCopy = new Hashtable(map);
        }
    }

    public LocationInfo getLocationInformation() {
        if (this.locationInfo == null) {
            this.locationInfo = new LocationInfo(new Throwable(), this.fqnOfCategoryClass);
        }
        return this.locationInfo;
    }

    public Level getLevel() {
        return (Level) this.level;
    }

    public String getLoggerName() {
        return this.categoryName;
    }

    public Category getLogger() {
        return this.f11281b;
    }

    public Object getMessage() {
        Object obj = this.f11282c;
        return obj != null ? obj : getRenderedMessage();
    }

    public String getNDC() {
        if (this.ndcLookupRequired) {
            this.ndcLookupRequired = false;
            this.ndc = NDC.m1548a();
        }
        return this.ndc;
    }

    public Object getMDC(String str) {
        Object obj;
        Hashtable hashtable = this.mdcCopy;
        return (hashtable == null || (obj = hashtable.get(str)) == null) ? MDC.m1559a(str) : obj;
    }

    public void getMDCCopy() {
        if (this.mdcCopyLookupRequired) {
            this.mdcCopyLookupRequired = false;
            Hashtable m1560a = MDC.m1560a();
            if (m1560a != null) {
                this.mdcCopy = (Hashtable) m1560a.clone();
            }
        }
    }

    public String getRenderedMessage() {
        Object obj;
        if (this.renderedMessage == null && (obj = this.f11282c) != null) {
            if (obj instanceof String) {
                this.renderedMessage = (String) obj;
            } else {
                LoggerRepository m1632d = this.f11281b.m1632d();
                if (m1632d instanceof RendererSupport) {
                    this.renderedMessage = ((RendererSupport) m1632d).mo1484c().m1649a(this.f11282c);
                } else {
                    this.renderedMessage = this.f11282c.toString();
                }
            }
        }
        return this.renderedMessage;
    }

    public static long getStartTime() {
        return f11280a;
    }

    public String getThreadName() {
        if (this.threadName == null) {
            this.threadName = Thread.currentThread().getName();
        }
        return this.threadName;
    }

    public ThrowableInformation getThrowableInformation() {
        return this.throwableInfo;
    }

    public String[] getThrowableStrRep() {
        ThrowableInformation throwableInformation = this.throwableInfo;
        if (throwableInformation == null) {
            return null;
        }
        return throwableInformation.getThrowableStrRep();
    }

    /* renamed from: a */
    private void m1525a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int readInt = objectInputStream.readInt();
        try {
            String str = (String) objectInputStream.readObject();
            if (str == null) {
                this.level = Level.toLevel(readInt);
                return;
            }
            Method method = (Method) methodCache.get(str);
            if (method == null) {
                method = Loader.m1602b(str).getDeclaredMethod(TO_LEVEL, TO_LEVEL_PARAMS);
                methodCache.put(str, method);
            }
            this.level = (Level) method.invoke(null, new Integer(readInt));
        } catch (IllegalAccessException e) {
            LogLog.m1594c("Level deserialization failed, reverting to default.", e);
            this.level = Level.toLevel(readInt);
        } catch (NoSuchMethodException e2) {
            LogLog.m1594c("Level deserialization failed, reverting to default.", e2);
            this.level = Level.toLevel(readInt);
        } catch (RuntimeException e3) {
            LogLog.m1594c("Level deserialization failed, reverting to default.", e3);
            this.level = Level.toLevel(readInt);
        } catch (InvocationTargetException e4) {
            if ((e4.getTargetException() instanceof InterruptedException) || (e4.getTargetException() instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            LogLog.m1594c("Level deserialization failed, reverting to default.", e4);
            this.level = Level.toLevel(readInt);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        m1525a(objectInputStream);
        if (this.locationInfo == null) {
            this.locationInfo = new LocationInfo(null, null);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        getThreadName();
        getRenderedMessage();
        getNDC();
        getMDCCopy();
        getThrowableStrRep();
        objectOutputStream.defaultWriteObject();
        m1524a(objectOutputStream);
    }

    /* renamed from: a */
    private void m1524a(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.level.toInt());
        Class<?> cls = this.level.getClass();
        Class<?> cls2 = class$org$apache$log4j$Level;
        if (cls2 == null) {
            cls2 = class$("org.apache.log4j.Level");
            class$org$apache$log4j$Level = cls2;
        }
        if (cls == cls2) {
            objectOutputStream.writeObject(null);
        } else {
            objectOutputStream.writeObject(cls.getName());
        }
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public final void setProperty(String str, String str2) {
        if (this.mdcCopy == null) {
            getMDCCopy();
        }
        if (this.mdcCopy == null) {
            this.mdcCopy = new Hashtable();
        }
        this.mdcCopy.put(str, str2);
    }

    public final String getProperty(String str) {
        Object mdc = getMDC(str);
        if (mdc != null) {
            return mdc.toString();
        }
        return null;
    }

    public final boolean locationInformationExists() {
        return this.locationInfo != null;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public Set getPropertyKeySet() {
        return getProperties().keySet();
    }

    public Map getProperties() {
        getMDCCopy();
        Map map = this.mdcCopy;
        if (map == null) {
            map = new HashMap();
        }
        return Collections.unmodifiableMap(map);
    }

    public String getFQNOfLoggerClass() {
        return this.fqnOfCategoryClass;
    }

    public Object removeProperty(String str) {
        if (this.mdcCopy == null) {
            getMDCCopy();
        }
        if (this.mdcCopy == null) {
            this.mdcCopy = new Hashtable();
        }
        return this.mdcCopy.remove(str);
    }
}
