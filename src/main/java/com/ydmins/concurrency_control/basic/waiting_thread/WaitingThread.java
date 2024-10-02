/*
 * File Name : WaitingThread
 * Author : @YdMinS
 * Date : 2024-10-02
 * Description : This class tests the generated threads in the 'waiting' state.
 * Reference : The Complete Coding Interview Guide in Java
 */

package com.ydmins.concurrency_control.basic.waiting_thread;

class Main{
    public static void main(String[] args) {
        WaitingThread waitingThread = new WaitingThread();
        waitingThread.waitingThread();
    }
}

public class WaitingThread {
    private static final Thread t1 = new T1();

    public void waitingThread(){
        t1.start();
    }

    private static class T1 extends Thread{
        @Override
        public void run(){
            Thread t2 = new Thread(new T2());
            t2.start();

            try{
                t2.join();
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    private static class T2 implements Runnable{
        @Override
        public void run() {
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
            System.out.println("WaitingThread T1: "+t1.getState());
        }
    }

    /*
     * WaitingThread T1: WAITING
     */
}
