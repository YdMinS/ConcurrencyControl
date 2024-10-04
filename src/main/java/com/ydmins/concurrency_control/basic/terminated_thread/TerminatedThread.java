/*
 * File Name : WaitingThread
 * Author : @YdMinS
 * Date : 2024-10-04
 * Description : This class tests the generated threads in the 'terminated' state.
 * Reference : The Complete Coding Interview Guide in Java
 */

package com.ydmins.concurrency_control.basic.terminated_thread;

class Main{
    public static void main(String[] args){
        TerminatedThread terminatedThread = new TerminatedThread();
        terminatedThread.terminatedThread();
    }
}

public class TerminatedThread {
    public void terminatedThread(){
        Thread t = new Thread(()->{});
        t.start();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

        System.out.println("TerminatedThread t : "+t.getState());
    }

    /*
     * TerminatedThread t : TERMINATED
     */
}
