/*
 * File Name : TimedWaitingThread
 * Author : @YdMinS
 * Date : 2024-10-03
 * Description : This class tests the generated threads in the 'timed waiting' state.
 * Reference : The Complete Coding Interview Guide in Java
 */

package com.ydmins.concurrency_control.basic.timedwaiting_thread;

class Main{
    public static void main(String[] args){
        TimedWaitingThread t = new TimedWaitingThread();
        t.timedWaitingThread();
    }
}

public class TimedWaitingThread {

    public void timedWaitingThread(){
        Thread t = new Thread(() -> {
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });
        t.start();

        try{
            Thread.sleep(500);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

        System.out.println("TimedWaitingThread t: "+t.getState());
    }

    /*
     * TimedWaitingThread t: TIMED_WAITING
     */
}
