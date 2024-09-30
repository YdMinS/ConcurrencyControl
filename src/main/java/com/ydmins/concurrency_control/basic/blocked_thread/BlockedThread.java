/*
 * File Name : RunnableThread
 * Author : @YdMinS
 * Date : 2024-09-30
 * Description : This class tests the generated threads in the 'blocked' state.
 * Reference : The Complete Coding Interview Guide in Java
 */

package com.ydmins.concurrency_control.basic.blocked_thread;

class Main{
    public static void main(String[] args){
        BlockedThread blockedThread = new BlockedThread();
        blockedThread.blockedThread();
    }
}

public class BlockedThread {
    public void blockedThread(){
        Thread t1 = new Thread(new SyncBlockCode());
        Thread t2 = new Thread(new SyncBlockCode());

        t1.start();

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Thread "+Thread.currentThread().getName()+" is interrupted.");
        }

        t2.start();

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            System.out.println("Thread "+Thread.currentThread().getName()+" is interrupted.");
        }

        System.out.println("Blocked thread t1 : "+t1.getState()+", name : "+t1.getName());
        System.out.println("Blocked thread t2 : "+t2.getState()+", name : "+t2.getName());

        System.exit(0);
    }

    private static class SyncBlockCode implements Runnable{
        @Override
        public void run(){
            System.out.println("Thread "+Thread.currentThread().getName()+" is in run() method.");
            syncMethod();
        }

        public static synchronized void syncMethod(){
            System.out.println("Thread "+Thread.currentThread().getName()+" is in syncMethod() method.");
            while(true){
                // Thread t1 is running in this while loop, so t2 is blocked.
            }
        }
    }

    /*
     * Thread Thread-0 is in run() method.
     * Thread Thread-0 is in syncMethod() method.
     * Thread Thread-1 is in run() method.
     * Blocked thread t1 : RUNNABLE, name : Thread-0
     * Blocked thread t2 : BLOCKED, name : Thread-1
     */
}
