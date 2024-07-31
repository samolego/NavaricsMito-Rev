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
    private transient C3022d<E> f10759a;

    /* renamed from: b */
    private transient C3022d<E> f10760b;

    /* renamed from: c */
    private transient int f10761c;
    private final int capacity;
    private final InterruptibleReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: org.apache.commons.pool2.impl.LinkedBlockingDeque$d */
    /* loaded from: classes2.dex */
    public static final class C3022d<E> {

        /* renamed from: a */
        E f10768a;

        /* renamed from: b */
        C3022d<E> f10769b;

        /* renamed from: c */
        C3022d<E> f10770c;

        C3022d(E e, C3022d<E> c3022d, C3022d<E> c3022d2) {
            this.f10768a = e;
            this.f10769b = c3022d;
            this.f10770c = c3022d2;
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
                if (!m10674b(e)) {
                    throw new IllegalStateException("Deque full");
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    /* renamed from: a */
    private boolean m10672a(E e) {
        if (this.f10761c >= this.capacity) {
            return false;
        }
        C3022d<E> c3022d = this.f10759a;
        C3022d<E> c3022d2 = new C3022d<>(e, null, c3022d);
        this.f10759a = c3022d2;
        if (this.f10760b == null) {
            this.f10760b = c3022d2;
        } else {
            c3022d.f10769b = c3022d2;
        }
        this.f10761c++;
        this.notEmpty.signal();
        return true;
    }

    /* renamed from: b */
    private boolean m10674b(E e) {
        if (this.f10761c >= this.capacity) {
            return false;
        }
        C3022d<E> c3022d = this.f10760b;
        C3022d<E> c3022d2 = new C3022d<>(e, c3022d, null);
        this.f10760b = c3022d2;
        if (this.f10759a == null) {
            this.f10759a = c3022d2;
        } else {
            c3022d.f10770c = c3022d2;
        }
        this.f10761c++;
        this.notEmpty.signal();
        return true;
    }

    /* renamed from: a */
    private E m10670a() {
        C3022d<E> c3022d = this.f10759a;
        if (c3022d == null) {
            return null;
        }
        C3022d<E> c3022d2 = c3022d.f10770c;
        E e = c3022d.f10768a;
        c3022d.f10768a = null;
        c3022d.f10770c = c3022d;
        this.f10759a = c3022d2;
        if (c3022d2 == null) {
            this.f10760b = null;
        } else {
            c3022d2.f10769b = null;
        }
        this.f10761c--;
        this.notFull.signal();
        return e;
    }

    /* renamed from: b */
    private E m10673b() {
        C3022d<E> c3022d = this.f10760b;
        if (c3022d == null) {
            return null;
        }
        C3022d<E> c3022d2 = c3022d.f10769b;
        E e = c3022d.f10768a;
        c3022d.f10768a = null;
        c3022d.f10769b = c3022d;
        this.f10760b = c3022d2;
        if (c3022d2 == null) {
            this.f10759a = null;
        } else {
            c3022d2.f10770c = null;
        }
        this.f10761c--;
        this.notFull.signal();
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10671a(C3022d<E> c3022d) {
        C3022d<E> c3022d2 = c3022d.f10769b;
        C3022d<E> c3022d3 = c3022d.f10770c;
        if (c3022d2 == null) {
            m10670a();
            return;
        }
        if (c3022d3 == null) {
            m10673b();
            return;
        }
        c3022d2.f10770c = c3022d3;
        c3022d3.f10769b = c3022d2;
        c3022d.f10768a = null;
        this.f10761c--;
        this.notFull.signal();
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
            return m10672a((LinkedBlockingDeque<E>) e);
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
            return m10674b(e);
        } finally {
            this.lock.unlock();
        }
    }

    public void putFirst(E e) throws InterruptedException {
        if (e == null) {
            throw new NullPointerException();
        }
        this.lock.lock();
        while (!m10672a((LinkedBlockingDeque<E>) e)) {
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
        while (!m10674b(e)) {
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
        while (!m10672a((LinkedBlockingDeque<E>) e)) {
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
        while (!m10674b(e)) {
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
            return m10670a();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.Deque
    public E pollLast() {
        this.lock.lock();
        try {
            return m10673b();
        } finally {
            this.lock.unlock();
        }
    }

    public E takeFirst() throws InterruptedException {
        this.lock.lock();
        while (true) {
            try {
                E m10670a = m10670a();
                if (m10670a != null) {
                    return m10670a;
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
                E m10673b = m10673b();
                if (m10673b != null) {
                    return m10673b;
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
                E m10670a = m10670a();
                if (m10670a != null) {
                    return m10670a;
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
                E m10673b = m10673b();
                if (m10673b != null) {
                    return m10673b;
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
            return this.f10759a == null ? null : this.f10759a.f10768a;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.Deque
    public E peekLast() {
        this.lock.lock();
        try {
            return this.f10760b == null ? null : this.f10760b.f10768a;
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
            for (C3022d<E> c3022d = this.f10759a; c3022d != null; c3022d = c3022d.f10770c) {
                if (obj.equals(c3022d.f10768a)) {
                    m10671a((C3022d) c3022d);
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
            for (C3022d<E> c3022d = this.f10760b; c3022d != null; c3022d = c3022d.f10769b) {
                if (obj.equals(c3022d.f10768a)) {
                    m10671a((C3022d) c3022d);
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
            return this.capacity - this.f10761c;
        } finally {
            this.lock.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    public int drainTo(Collection<? super E> collection, int i) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        this.lock.lock();
        try {
            int min = Math.min(i, this.f10761c);
            for (int i2 = 0; i2 < min; i2++) {
                collection.add(this.f10759a.f10768a);
                m10670a();
            }
            return min;
        } finally {
            this.lock.unlock();
        }
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
            return this.f10761c;
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
            for (C3022d<E> c3022d = this.f10759a; c3022d != null; c3022d = c3022d.f10770c) {
                if (obj.equals(c3022d.f10768a)) {
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
            Object[] objArr = new Object[this.f10761c];
            int i = 0;
            C3022d<E> c3022d = this.f10759a;
            while (c3022d != null) {
                int i2 = i + 1;
                objArr[i] = c3022d.f10768a;
                c3022d = c3022d.f10770c;
                i = i2;
            }
            return objArr;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        this.lock.lock();
        try {
            if (tArr.length < this.f10761c) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f10761c));
            }
            int i = 0;
            C3022d<E> c3022d = this.f10759a;
            while (c3022d != null) {
                tArr[i] = c3022d.f10768a;
                c3022d = c3022d.f10770c;
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
            C3022d<E> c3022d = this.f10759a;
            while (c3022d != null) {
                c3022d.f10768a = null;
                C3022d<E> c3022d2 = c3022d.f10770c;
                c3022d.f10769b = null;
                c3022d.f10770c = null;
                c3022d = c3022d2;
            }
            this.f10760b = null;
            this.f10759a = null;
            this.f10761c = 0;
            this.notFull.signalAll();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Deque
    public Iterator<E> iterator() {
        return new C3021c();
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return new C3020b();
    }

    /* renamed from: org.apache.commons.pool2.impl.LinkedBlockingDeque$a */
    /* loaded from: classes2.dex */
    private abstract class AbstractC3019a implements Iterator<E> {

        /* renamed from: a */
        C3022d<E> f10762a;

        /* renamed from: b */
        E f10763b;

        /* renamed from: d */
        private C3022d<E> f10765d;

        /* renamed from: a */
        abstract C3022d<E> mo10676a();

        /* renamed from: a */
        abstract C3022d<E> mo10677a(C3022d<E> c3022d);

        AbstractC3019a() {
            LinkedBlockingDeque.this.lock.lock();
            try {
                this.f10762a = mo10676a();
                this.f10763b = this.f10762a == null ? null : this.f10762a.f10768a;
            } finally {
                LinkedBlockingDeque.this.lock.unlock();
            }
        }

        /* renamed from: b */
        private C3022d<E> m10675b(C3022d<E> c3022d) {
            while (true) {
                C3022d<E> mo10677a = mo10677a(c3022d);
                if (mo10677a == null) {
                    return null;
                }
                if (mo10677a.f10768a != null) {
                    return mo10677a;
                }
                if (mo10677a == c3022d) {
                    return mo10676a();
                }
                c3022d = mo10677a;
            }
        }

        /* renamed from: b */
        void m10678b() {
            LinkedBlockingDeque.this.lock.lock();
            try {
                this.f10762a = m10675b(this.f10762a);
                this.f10763b = this.f10762a == null ? null : this.f10762a.f10768a;
            } finally {
                LinkedBlockingDeque.this.lock.unlock();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10762a != null;
        }

        @Override // java.util.Iterator
        public E next() {
            C3022d<E> c3022d = this.f10762a;
            if (c3022d == null) {
                throw new NoSuchElementException();
            }
            this.f10765d = c3022d;
            E e = this.f10763b;
            m10678b();
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            C3022d<E> c3022d = this.f10765d;
            if (c3022d == null) {
                throw new IllegalStateException();
            }
            this.f10765d = null;
            LinkedBlockingDeque.this.lock.lock();
            try {
                if (c3022d.f10768a != null) {
                    LinkedBlockingDeque.this.m10671a((C3022d) c3022d);
                }
            } finally {
                LinkedBlockingDeque.this.lock.unlock();
            }
        }
    }

    /* renamed from: org.apache.commons.pool2.impl.LinkedBlockingDeque$c */
    /* loaded from: classes2.dex */
    private class C3021c extends LinkedBlockingDeque<E>.AbstractC3019a {
        private C3021c() {
            super();
        }

        @Override // org.apache.commons.pool2.impl.LinkedBlockingDeque.AbstractC3019a
        /* renamed from: a */
        C3022d<E> mo10676a() {
            return LinkedBlockingDeque.this.f10759a;
        }

        @Override // org.apache.commons.pool2.impl.LinkedBlockingDeque.AbstractC3019a
        /* renamed from: a */
        C3022d<E> mo10677a(C3022d<E> c3022d) {
            return c3022d.f10770c;
        }
    }

    /* renamed from: org.apache.commons.pool2.impl.LinkedBlockingDeque$b */
    /* loaded from: classes2.dex */
    private class C3020b extends LinkedBlockingDeque<E>.AbstractC3019a {
        private C3020b() {
            super();
        }

        @Override // org.apache.commons.pool2.impl.LinkedBlockingDeque.AbstractC3019a
        /* renamed from: a */
        C3022d<E> mo10676a() {
            return LinkedBlockingDeque.this.f10760b;
        }

        @Override // org.apache.commons.pool2.impl.LinkedBlockingDeque.AbstractC3019a
        /* renamed from: a */
        C3022d<E> mo10677a(C3022d<E> c3022d) {
            return c3022d.f10769b;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        this.lock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (C3022d<E> c3022d = this.f10759a; c3022d != null; c3022d = c3022d.f10770c) {
                objectOutputStream.writeObject(c3022d.f10768a);
            }
            objectOutputStream.writeObject(null);
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f10761c = 0;
        this.f10759a = null;
        this.f10760b = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                return;
            } else {
                add(readObject);
            }
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