package org.apache.commons.pool2.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements Serializable, Deque<E> {
    private static final long serialVersionUID = -387911632671998426L;

    /* renamed from: a */
    private transient C3011d<E> f10718a;

    /* renamed from: b */
    private transient C3011d<E> f10719b;

    /* renamed from: c */
    private transient int f10720c;
    private final int capacity;
    private final InterruptibleReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: org.apache.commons.pool2.impl.LinkedBlockingDeque$d */
    /* loaded from: classes2.dex */
    public static final class C3011d<E> {

        /* renamed from: a */
        E f10727a;

        /* renamed from: b */
        C3011d<E> f10728b;

        /* renamed from: c */
        C3011d<E> f10729c;

        C3011d(E e, C3011d<E> c3011d, C3011d<E> c3011d2) {
            this.f10727a = e;
            this.f10728b = c3011d;
            this.f10729c = c3011d2;
        }
    }

    public LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
    }

    public LinkedBlockingDeque(boolean z) {
        this(Integer.MAX_VALUE, z);
    }

    public LinkedBlockingDeque(int i) {
        this(i, false);
    }

    public LinkedBlockingDeque(int i, boolean z) {
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = i;
        this.lock = new InterruptibleReentrantLock(z);
        this.notEmpty = this.lock.newCondition();
        this.notFull = this.lock.newCondition();
    }

    public LinkedBlockingDeque(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        this.lock.lock();
        try {
            for (E e : collection) {
                if (e == null) {
                    throw new NullPointerException();
                }
                if (!m2175b(e)) {
                    throw new IllegalStateException("Deque full");
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    /* renamed from: a */
    private boolean m2178a(E e) {
        if (this.f10720c >= this.capacity) {
            return false;
        }
        C3011d<E> c3011d = this.f10718a;
        C3011d<E> c3011d2 = new C3011d<>(e, null, c3011d);
        this.f10718a = c3011d2;
        if (this.f10719b == null) {
            this.f10719b = c3011d2;
        } else {
            c3011d.f10728b = c3011d2;
        }
        this.f10720c++;
        this.notEmpty.signal();
        return true;
    }

    /* renamed from: b */
    private boolean m2175b(E e) {
        if (this.f10720c >= this.capacity) {
            return false;
        }
        C3011d<E> c3011d = this.f10719b;
        C3011d<E> c3011d2 = new C3011d<>(e, c3011d, null);
        this.f10719b = c3011d2;
        if (this.f10718a == null) {
            this.f10718a = c3011d2;
        } else {
            c3011d.f10729c = c3011d2;
        }
        this.f10720c++;
        this.notEmpty.signal();
        return true;
    }

    /* renamed from: a */
    private E m2179a() {
        C3011d<E> c3011d = this.f10718a;
        if (c3011d == null) {
            return null;
        }
        C3011d<E> c3011d2 = c3011d.f10729c;
        E e = c3011d.f10727a;
        c3011d.f10727a = null;
        c3011d.f10729c = c3011d;
        this.f10718a = c3011d2;
        if (c3011d2 == null) {
            this.f10719b = null;
        } else {
            c3011d2.f10728b = null;
        }
        this.f10720c--;
        this.notFull.signal();
        return e;
    }

    /* renamed from: b */
    private E m2176b() {
        C3011d<E> c3011d = this.f10719b;
        if (c3011d == null) {
            return null;
        }
        C3011d<E> c3011d2 = c3011d.f10728b;
        E e = c3011d.f10727a;
        c3011d.f10727a = null;
        c3011d.f10728b = c3011d;
        this.f10719b = c3011d2;
        if (c3011d2 == null) {
            this.f10718a = null;
        } else {
            c3011d2.f10729c = null;
        }
        this.f10720c--;
        this.notFull.signal();
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2177a(C3011d<E> c3011d) {
        C3011d<E> c3011d2 = c3011d.f10728b;
        C3011d<E> c3011d3 = c3011d.f10729c;
        if (c3011d2 == null) {
            m2179a();
        } else if (c3011d3 == null) {
            m2176b();
        } else {
            c3011d2.f10729c = c3011d3;
            c3011d3.f10728b = c3011d2;
            c3011d.f10727a = null;
            this.f10720c--;
            this.notFull.signal();
        }
    }

    @Override // java.util.Deque
    public void addFirst(E e) {
        if (!offerFirst(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // java.util.Deque
    public void addLast(E e) {
        if (!offerLast(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // java.util.Deque
    public boolean offerFirst(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        this.lock.lock();
        try {
            return m2178a((LinkedBlockingDeque<E>) e);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.Deque
    public boolean offerLast(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        this.lock.lock();
        try {
            return m2175b(e);
        } finally {
            this.lock.unlock();
        }
    }

    public void putFirst(E e) throws InterruptedException {
        if (e == null) {
            throw new NullPointerException();
        }
        this.lock.lock();
        while (!m2178a((LinkedBlockingDeque<E>) e)) {
            try {
                this.notFull.await();
            } finally {
                this.lock.unlock();
            }
        }
    }

    public void putLast(E e) throws InterruptedException {
        if (e == null) {
            throw new NullPointerException();
        }
        this.lock.lock();
        while (!m2175b(e)) {
            try {
                this.notFull.await();
            } finally {
                this.lock.unlock();
            }
        }
    }

    public boolean offerFirst(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        InterruptibleReentrantLock interruptibleReentrantLock;
        if (e == null) {
            throw new NullPointerException();
        }
        long nanos = timeUnit.toNanos(j);
        this.lock.lockInterruptibly();
        while (!m2178a((LinkedBlockingDeque<E>) e)) {
            try {
                if (nanos > 0) {
                    nanos = this.notFull.awaitNanos(nanos);
                } else {
                    return false;
                }
            } finally {
                this.lock.unlock();
            }
        }
        return true;
    }

    public boolean offerLast(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        InterruptibleReentrantLock interruptibleReentrantLock;
        if (e == null) {
            throw new NullPointerException();
        }
        long nanos = timeUnit.toNanos(j);
        this.lock.lockInterruptibly();
        while (!m2175b(e)) {
            try {
                if (nanos > 0) {
                    nanos = this.notFull.awaitNanos(nanos);
                } else {
                    return false;
                }
            } finally {
                this.lock.unlock();
            }
        }
        return true;
    }

    @Override // java.util.Deque
    public E removeFirst() {
        E pollFirst = pollFirst();
        if (pollFirst != null) {
            return pollFirst;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Deque
    public E removeLast() {
        E pollLast = pollLast();
        if (pollLast != null) {
            return pollLast;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Deque
    public E pollFirst() {
        this.lock.lock();
        try {
            return m2179a();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.Deque
    public E pollLast() {
        this.lock.lock();
        try {
            return m2176b();
        } finally {
            this.lock.unlock();
        }
    }

    public E takeFirst() throws InterruptedException {
        this.lock.lock();
        while (true) {
            try {
                E m2179a = m2179a();
                if (m2179a != null) {
                    return m2179a;
                }
                this.notEmpty.await();
            } finally {
                this.lock.unlock();
            }
        }
    }

    public E takeLast() throws InterruptedException {
        this.lock.lock();
        while (true) {
            try {
                E m2176b = m2176b();
                if (m2176b != null) {
                    return m2176b;
                }
                this.notEmpty.await();
            } finally {
                this.lock.unlock();
            }
        }
    }

    public E pollFirst(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        this.lock.lockInterruptibly();
        while (true) {
            try {
                E m2179a = m2179a();
                if (m2179a != null) {
                    return m2179a;
                }
                if (nanos > 0) {
                    nanos = this.notEmpty.awaitNanos(nanos);
                } else {
                    return null;
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    public E pollLast(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        this.lock.lockInterruptibly();
        while (true) {
            try {
                E m2176b = m2176b();
                if (m2176b != null) {
                    return m2176b;
                }
                if (nanos > 0) {
                    nanos = this.notEmpty.awaitNanos(nanos);
                } else {
                    return null;
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @Override // java.util.Deque
    public E getFirst() {
        E peekFirst = peekFirst();
        if (peekFirst != null) {
            return peekFirst;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Deque
    public E getLast() {
        E peekLast = peekLast();
        if (peekLast != null) {
            return peekLast;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Deque
    public E peekFirst() {
        this.lock.lock();
        try {
            return this.f10718a == null ? null : this.f10718a.f10727a;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.Deque
    public E peekLast() {
        this.lock.lock();
        try {
            return this.f10719b == null ? null : this.f10719b.f10727a;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.Deque
    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        this.lock.lock();
        try {
            for (C3011d<E> c3011d = this.f10718a; c3011d != null; c3011d = c3011d.f10729c) {
                if (obj.equals(c3011d.f10727a)) {
                    m2177a((C3011d) c3011d);
                    return true;
                }
            }
            return false;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.Deque
    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        this.lock.lock();
        try {
            for (C3011d<E> c3011d = this.f10719b; c3011d != null; c3011d = c3011d.f10728b) {
                if (obj.equals(c3011d.f10727a)) {
                    m2177a((C3011d) c3011d);
                    return true;
                }
            }
            return false;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, java.util.Deque
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override // java.util.Queue, java.util.Deque
    public boolean offer(E e) {
        return offerLast(e);
    }

    public void put(E e) throws InterruptedException {
        putLast(e);
    }

    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        return offerLast(e, j, timeUnit);
    }

    @Override // java.util.AbstractQueue, java.util.Queue, java.util.Deque
    public E remove() {
        return removeFirst();
    }

    @Override // java.util.Queue, java.util.Deque
    public E poll() {
        return pollFirst();
    }

    public E take() throws InterruptedException {
        return takeFirst();
    }

    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        return pollFirst(j, timeUnit);
    }

    @Override // java.util.AbstractQueue, java.util.Queue, java.util.Deque
    public E element() {
        return getFirst();
    }

    @Override // java.util.Queue, java.util.Deque
    public E peek() {
        return peekFirst();
    }

    public int remainingCapacity() {
        this.lock.lock();
        try {
            return this.capacity - this.f10720c;
        } finally {
            this.lock.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    public int drainTo(Collection<? super E> collection, int i) {
        if (collection != null) {
            if (collection == this) {
                throw new IllegalArgumentException();
            }
            this.lock.lock();
            try {
                int min = Math.min(i, this.f10720c);
                for (int i2 = 0; i2 < min; i2++) {
                    collection.add((E) this.f10718a.f10727a);
                    m2179a();
                }
                return min;
            } finally {
                this.lock.unlock();
            }
        }
        throw new NullPointerException();
    }

    @Override // java.util.Deque
    public void push(E e) {
        addFirst(e);
    }

    @Override // java.util.Deque
    public E pop() {
        return removeFirst();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public int size() {
        this.lock.lock();
        try {
            return this.f10720c;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        this.lock.lock();
        try {
            for (C3011d<E> c3011d = this.f10718a; c3011d != null; c3011d = c3011d.f10729c) {
                if (obj.equals(c3011d.f10727a)) {
                    return true;
                }
            }
            return false;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        this.lock.lock();
        try {
            Object[] objArr = new Object[this.f10720c];
            int i = 0;
            C3011d<E> c3011d = this.f10718a;
            while (c3011d != null) {
                int i2 = i + 1;
                objArr[i] = c3011d.f10727a;
                c3011d = c3011d.f10729c;
                i = i2;
            }
            return objArr;
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        this.lock.lock();
        try {
            if (tArr.length < this.f10720c) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f10720c));
            }
            int i = 0;
            C3011d<E> c3011d = this.f10718a;
            while (c3011d != null) {
                tArr[i] = c3011d.f10727a;
                c3011d = c3011d.f10729c;
                i++;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        this.lock.lock();
        try {
            return super.toString();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.lock.lock();
        try {
            C3011d<E> c3011d = this.f10718a;
            while (c3011d != null) {
                c3011d.f10727a = null;
                C3011d<E> c3011d2 = c3011d.f10729c;
                c3011d.f10728b = null;
                c3011d.f10729c = null;
                c3011d = c3011d2;
            }
            this.f10719b = null;
            this.f10718a = null;
            this.f10720c = 0;
            this.notFull.signalAll();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Deque
    public Iterator<E> iterator() {
        return new C3010c();
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return new C3009b();
    }

    /* renamed from: org.apache.commons.pool2.impl.LinkedBlockingDeque$a */
    /* loaded from: classes2.dex */
    private abstract class AbstractC3008a implements Iterator<E> {

        /* renamed from: a */
        C3011d<E> f10721a;

        /* renamed from: b */
        E f10722b;

        /* renamed from: d */
        private C3011d<E> f10724d;

        /* renamed from: a */
        abstract C3011d<E> mo2172a();

        /* renamed from: a */
        abstract C3011d<E> mo2171a(C3011d<E> c3011d);

        AbstractC3008a() {
            LinkedBlockingDeque.this.lock.lock();
            try {
                this.f10721a = mo2172a();
                this.f10722b = this.f10721a == null ? null : this.f10721a.f10727a;
            } finally {
                LinkedBlockingDeque.this.lock.unlock();
            }
        }

        /* renamed from: b */
        private C3011d<E> m2173b(C3011d<E> c3011d) {
            while (true) {
                C3011d<E> mo2171a = mo2171a(c3011d);
                if (mo2171a == null) {
                    return null;
                }
                if (mo2171a.f10727a != null) {
                    return mo2171a;
                }
                if (mo2171a == c3011d) {
                    return mo2172a();
                }
                c3011d = mo2171a;
            }
        }

        /* renamed from: b */
        void m2174b() {
            LinkedBlockingDeque.this.lock.lock();
            try {
                this.f10721a = m2173b(this.f10721a);
                this.f10722b = this.f10721a == null ? null : this.f10721a.f10727a;
            } finally {
                LinkedBlockingDeque.this.lock.unlock();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10721a != null;
        }

        @Override // java.util.Iterator
        public E next() {
            C3011d<E> c3011d = this.f10721a;
            if (c3011d == null) {
                throw new NoSuchElementException();
            }
            this.f10724d = c3011d;
            E e = this.f10722b;
            m2174b();
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            C3011d<E> c3011d = this.f10724d;
            if (c3011d == null) {
                throw new IllegalStateException();
            }
            this.f10724d = null;
            LinkedBlockingDeque.this.lock.lock();
            try {
                if (c3011d.f10727a != null) {
                    LinkedBlockingDeque.this.m2177a((C3011d) c3011d);
                }
            } finally {
                LinkedBlockingDeque.this.lock.unlock();
            }
        }
    }

    /* renamed from: org.apache.commons.pool2.impl.LinkedBlockingDeque$c */
    /* loaded from: classes2.dex */
    private class C3010c extends LinkedBlockingDeque<E>.AbstractC3008a {
        private C3010c() {
            super();
        }

        @Override // org.apache.commons.pool2.impl.LinkedBlockingDeque.AbstractC3008a
        /* renamed from: a */
        C3011d<E> mo2172a() {
            return LinkedBlockingDeque.this.f10718a;
        }

        @Override // org.apache.commons.pool2.impl.LinkedBlockingDeque.AbstractC3008a
        /* renamed from: a */
        C3011d<E> mo2171a(C3011d<E> c3011d) {
            return c3011d.f10729c;
        }
    }

    /* renamed from: org.apache.commons.pool2.impl.LinkedBlockingDeque$b */
    /* loaded from: classes2.dex */
    private class C3009b extends LinkedBlockingDeque<E>.AbstractC3008a {
        private C3009b() {
            super();
        }

        @Override // org.apache.commons.pool2.impl.LinkedBlockingDeque.AbstractC3008a
        /* renamed from: a */
        C3011d<E> mo2172a() {
            return LinkedBlockingDeque.this.f10719b;
        }

        @Override // org.apache.commons.pool2.impl.LinkedBlockingDeque.AbstractC3008a
        /* renamed from: a */
        C3011d<E> mo2171a(C3011d<E> c3011d) {
            return c3011d.f10728b;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        this.lock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (C3011d<E> c3011d = this.f10718a; c3011d != null; c3011d = c3011d.f10729c) {
                objectOutputStream.writeObject(c3011d.f10727a);
            }
            objectOutputStream.writeObject(null);
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f10720c = 0;
        this.f10718a = null;
        this.f10719b = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                return;
            }
            add(readObject);
        }
    }

    public boolean hasTakeWaiters() {
        this.lock.lock();
        try {
            return this.lock.hasWaiters(this.notEmpty);
        } finally {
            this.lock.unlock();
        }
    }

    public int getTakeQueueLength() {
        this.lock.lock();
        try {
            return this.lock.getWaitQueueLength(this.notEmpty);
        } finally {
            this.lock.unlock();
        }
    }

    public void interuptTakeWaiters() {
        this.lock.lock();
        try {
            this.lock.interruptWaiters(this.notEmpty);
        } finally {
            this.lock.unlock();
        }
    }
}
