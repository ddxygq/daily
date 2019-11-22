package com.keguang.daily.javabasic.thread.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @ Author: keguang
 * @ Date: 2019/11/19 10:33
 * @ version: v1.0.0
 * @ description: AtomicReference有一个非常有用的方法是compareAndSet()。
 * compareAndSet()方法可以将存储在AtomicReference中的引用同你的预期值做一个比较，
 * 如果他们是相同的(not equal as in equals() but same as in ==)，那么在AtomicReference实例上会设置一个新的引用。
 * 如果compareAndSet()方法给AtomicReference设置了新的引用，它会返回true。否则会返回false。
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        String initialReference = "initialReference";

        AtomicReference<String> atomicStringReference = new AtomicReference<>(initialReference);

        String newReference = "newReference";

        // true
        // 存储值与initialReference相同则更新为newReference，并且返回true；如果不相同，则返回false。
        boolean exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged:" + exchanged);

        // false
        exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged:" + exchanged);
    }
}
