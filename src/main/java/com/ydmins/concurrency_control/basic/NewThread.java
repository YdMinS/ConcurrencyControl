/*
 * File Name : NewThread
 * Author : @YdMinS
 * Date : 2024-09-25
 * Description : This class tests statuses of generated threads.
 * Reference : The Complete Coding Interview Guide in Java
 */

package com.ydmins.concurrency_control.basic;

import java.lang.*;

class Main {
    public static void main(String[] args) {
        NewThread newThread = new NewThread();
        newThread.newThread();
    }
}

public class NewThread {
    public void newThread(){
        Thread t1 = new Thread(() -> {});
        System.out.println("The state of thread t1 : "+t1.getState());

        Runnable r1 = () -> {};
        Thread t2 = new Thread(r1);
        System.out.println("The state of thread t2 : "+t2.getState());

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() { }
        });
        System.out.println("The state of thread t3 : "+t3.getState());

        Thread t4 = new Thread(new Thread(){
            @Override
            public void run() { }
        });
        System.out.println("The state of thread t4 : "+t4.getState());
    }

    /*
     * 실행 결과:
     * The state of thread t1 : NEW
     * The state of thread t2 : NEW
     * The state of thread t3 : NEW
     * The state of thread t4 : NEW
     */
}