package com.vng.zing.media.mp3.test.kit.test.common;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 25/10/2022
 */

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StackBasedQueue<T> extends AbstractQueue<T> {

    private final Stack<T> INBOX, OUTBOX;
    private final Lock READ_LOCK;
    private final Lock WRITE_LOCK;
    private int SIZE;

    public StackBasedQueue() {
        super();

        INBOX = new Stack<>();
        OUTBOX = new Stack<>();
        READ_LOCK = new ReentrantLock();
        WRITE_LOCK = new ReentrantLock();
        SIZE = 0;
    }

    /**
     * Returns an Iterator that does not allow concurrent modification
     */
    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    @Override
    public int size() {
        WRITE_LOCK.lock();
        READ_LOCK.lock();
        try {
            return SIZE;
        } finally {
            WRITE_LOCK.unlock();
            READ_LOCK.unlock();
        }
    }

    @Override
    public boolean offer(T t) {
        _checkNotNull(t);

        WRITE_LOCK.lock();
        try {
            _enqueue(t);

            return true;
        } finally {
            WRITE_LOCK.unlock();
        }
    }

    @Override
    public T poll() {
        READ_LOCK.lock();
        try {
            if (SIZE == 0) {
                return null;
            }

            return _dequeue();
        } finally {
            READ_LOCK.unlock();
        }
    }

    @Override
    public T peek() {
        READ_LOCK.lock();
        try {
            if (SIZE == 0) {
                return null;
            }

            _prepareOutbox();

            return OUTBOX.peek();
        } finally {
            READ_LOCK.unlock();
        }
    }

    private void _enqueue(T t) {
        INBOX.push(t);
        SIZE++;
    }

    private T _dequeue() {
        _prepareOutbox();

        T t = OUTBOX.pop();
        SIZE--;

        return t;
    }

    private void _prepareOutbox() {
        if (OUTBOX.empty()) {
            WRITE_LOCK.lock();
            try {
                if (OUTBOX.empty()) {
                    while (!INBOX.empty()) {
                        OUTBOX.push(INBOX.pop());
                    }
                }
            } finally {
                WRITE_LOCK.unlock();
            }
        }
    }

    private void _checkNotNull(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
    }

    private final class Itr implements Iterator<T> {

        private final Iterator<T> INBOX_ITERATOR;
        private final ListIterator<T> OUTBOX_ITERATOR;

        private Itr() {
            READ_LOCK.lock();
            WRITE_LOCK.lock();
            try {
                INBOX_ITERATOR = INBOX.iterator();

                OUTBOX_ITERATOR = OUTBOX.listIterator();
                while (OUTBOX_ITERATOR.hasNext()) {
                    OUTBOX_ITERATOR.next();
                }
            } finally {
                READ_LOCK.unlock();
                WRITE_LOCK.unlock();
            }
        }

        @Override
        public boolean hasNext() {
            return OUTBOX_ITERATOR.hasPrevious() || INBOX_ITERATOR.hasNext();
        }

        @Override
        public T next() {
            if (OUTBOX_ITERATOR.hasPrevious()) {
                return OUTBOX_ITERATOR.previous();
            }
            return INBOX_ITERATOR.next();
        }
    }
}
