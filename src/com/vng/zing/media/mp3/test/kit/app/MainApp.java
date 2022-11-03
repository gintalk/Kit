/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.app;

import com.vng.zing.common.ZUtil;
import com.vng.zing.media.mp3.test.kit.test.common.StackBasedQueue;

import java.util.Iterator;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author namnq
 */
public class MainApp {

    private static final AtomicInteger i = new AtomicInteger(0);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StackBasedQueue<Integer> queue = new StackBasedQueue<>();

        new Thread(() -> {
            ZUtil.sleep(10000);

            Iterator<Integer> iterator = queue.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

            ZUtil.sleep(5000);
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        }).start();

        new Thread(() -> {
            while (true) {
                pushOrPopRandomly("2", queue);
                ZUtil.sleep(randomIntInRange(50, 500));
            }
        }).start();
//
//        new Thread(() -> {
//            while (true) {
//                pushOrPopRandomly("3", queue);
//                ZUtil.sleep(randomIntInRange(50, 1000));
//            }
//        }).start();
//
//        new Thread(() -> {
//            while (true) {
//                pushOrPopRandomly("4", queue);
//                ZUtil.sleep(randomIntInRange(50, 1000));
//            }
//        }).start();
    }

    private static void pushOrPopRandomly(String name, Queue<Integer> queue) {
        int random = randomIntInRange(0, 3);
        switch (random) {
            case 0:
                int ii = i.getAndIncrement();
                System.out.println(name + " offers " + ii + " " + queue.offer(ii));
                break;
            case 1:
                System.out.println(name + " pops " + queue.poll());
                break;
            case 2:
                System.out.println(name + " sizes at " + queue.size());
                break;
        }
    }

    private static int randomIntInRange(int min, int max) {
        return new Random().ints(min, max).findFirst().getAsInt();
    }
}
