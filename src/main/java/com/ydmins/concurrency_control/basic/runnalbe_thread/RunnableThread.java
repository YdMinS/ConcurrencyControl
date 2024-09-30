/*
 * File Name : RunnableThread
 * Author : @YdMinS
 * Date : 2024-09-30
 * Description : This class tests the generated threads in the 'runnable' state.
 * Reference : The Complete Coding Interview Guide in Java
 */

package com.ydmins.concurrency_control.basic.runnalbe_thread;

class Main{
    public static void main(String[] args){
        RunnableThread runnableThread = new RunnableThread();
        runnableThread.runnableThread();
    }
}

public class RunnableThread {
    public void runnableThread(){
        Thread t1 = new Thread(() -> {});
        t1.start();
        System.out.println("The state of thread t1 : "+t1.getState());

        Runnable r1 = () -> {};
        Thread t2 = new Thread(r1);
        t2.start();
        System.out.println("The state of thread t2 : "+t2.getState());

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() { }
        });
        t3.start();
        System.out.println("The state of thread t3 : "+t3.getState());

        Thread t4 = new Thread(new Thread(){
            @Override
            public void run(){ }
        });
        t4.start();
        System.out.println("The state of thread t4 : "+t4.getState());
    }
    /*
     * The state of thread t1 : RUNNABLE
     * The state of thread t2 : RUNNABLE
     * The state of thread t3 : RUNNABLE
     * The state of thread t4 : RUNNABLE
     */
}
