/*
 * File Name : DeadLock
 * Author : @YdMinS
 * Date : 2024-10-07
 * Description : This class provides an example of a deadlock occurring between two threads.
 * Reference : The Complete Coding Interview Guide in Java
 * Warning : Two threads in this class are designed to enter a deadlock state. The program must be terminated manually.
 */

package com.ydmins.concurrency_control.scenario.dead_lock;

public class DeadLock {
    public static void main(String[] args) {
        new Thread(new FirstThread(), "First-thread").start();
        new Thread(new SecondThread(), "Second-thread").start();
    }

    static class FirstThread implements Runnable{
        @Override
        public void run() {
            synchronized (Double.class){
                System.out.println("Double.class locked by "+Thread.currentThread().getName());
                synchronized (Float.class){
                    System.out.println("Float class locked by "+Thread.currentThread().getName());
                }
            }
        }
    }

    static class SecondThread implements Runnable{
        @Override
        public void run() {
            synchronized (Float.class){
                System.out.println("Float.class locked by "+Thread.currentThread().getName());
                synchronized (Double.class){
                    System.out.println("Double.class locked by "+Thread.currentThread().getName());
                }
            }
        }
    }

    /*
     * Double.class locked by First-thread
     * Float.class locked by Second-thread
     */
}
