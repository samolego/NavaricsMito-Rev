package org.apache.ftpserver.ipfilter;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.p135b.Subnet;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* loaded from: classes2.dex */
public class RemoteIpFilter extends CopyOnWriteArraySet<Subnet> implements SessionFilter {
    private static final long serialVersionUID = 4887092372700628783L;
    InterfaceC3153b LOGGER;
    private IpFilterType type;

    public RemoteIpFilter(IpFilterType ipFilterType) {
        this(ipFilterType, new HashSet(0));
    }

    public RemoteIpFilter(IpFilterType ipFilterType, Collection<? extends Subnet> collection) {
        super(collection);
        this.LOGGER = C3154c.m262a(RemoteIpFilter.class);
        this.type = null;
        this.type = ipFilterType;
    }

    public RemoteIpFilter(IpFilterType ipFilterType, String str) throws NumberFormatException, UnknownHostException {
        String[] split;
        this.LOGGER = C3154c.m262a(RemoteIpFilter.class);
        this.type = null;
        this.type = ipFilterType;
        if (str != null) {
            for (String str2 : str.split("[\\s,]+")) {
                if (str2.trim().length() > 0) {
                    add(str2);
                }
            }
        }
        if (this.LOGGER.isDebugEnabled()) {
            this.LOGGER.debug("Created DefaultIpFilter of type {} with the subnets {}", ipFilterType, this);
        }
    }

    public IpFilterType getType() {
        return this.type;
    }

    public void setType(IpFilterType ipFilterType) {
        this.type = ipFilterType;
    }

    public boolean add(String str) throws NumberFormatException, UnknownHostException {
        if (str.trim().length() < 1) {
            throw new IllegalArgumentException("Invalid IP Address or Subnet: " + str);
        }
        String[] split = str.split("/");
        if (split.length == 2) {
            return add((RemoteIpFilter) new Subnet(InetAddress.getByName(split[0]), Integer.parseInt(split[1])));
        }
        return add((RemoteIpFilter) new Subnet(InetAddress.getByName(split[0]), 32));
    }

    @Override // org.apache.ftpserver.ipfilter.SessionFilter
    public boolean accept(IoSession ioSession) {
        InetAddress address = ((InetSocketAddress) ioSession.mo994l()).getAddress();
        switch (this.type) {
            case ALLOW:
                Iterator<Subnet> it = iterator();
                while (it.hasNext()) {
                    Subnet next = it.next();
                    if (next.m918a(address)) {
                        if (this.LOGGER.isDebugEnabled()) {
                            this.LOGGER.debug("Allowing connection from {} because it matches with the whitelist subnet {}", address, next);
                        }
                        return true;
                    }
                }
                if (this.LOGGER.isDebugEnabled()) {
                    this.LOGGER.debug("Denying connection from {} because it does not match any of the whitelist subnets", address);
                }
                return false;
            case DENY:
                if (isEmpty()) {
                    if (this.LOGGER.isDebugEnabled()) {
                        this.LOGGER.debug("Allowing connection from {} because blacklist is empty", address);
                    }
                    return true;
                }
                Iterator<Subnet> it2 = iterator();
                while (it2.hasNext()) {
                    Subnet next2 = it2.next();
                    if (next2.m918a(address)) {
                        if (this.LOGGER.isDebugEnabled()) {
                            this.LOGGER.debug("Denying connection from {} because it matches with the blacklist subnet {}", address, next2);
                        }
                        return false;
                    }
                }
                if (this.LOGGER.isDebugEnabled()) {
                    this.LOGGER.debug("Allowing connection from {} because it does not match any of the blacklist subnets", address);
                }
                return true;
            default:
                throw new RuntimeException("Unknown or unimplemented filter type: " + this.type);
        }
    }
}
