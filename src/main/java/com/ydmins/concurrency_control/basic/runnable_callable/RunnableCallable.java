/*
 * File Name : RunnableCallable
 * Author : @YdMinS
 * Date : 2024-10-10
 * Description : This class demonstrates the usage of Runnable and Callable interfaces for concurrent execution in Java.
 * Reference : The Complete Coding Interview Guide in Java
 */

package com.ydmins.concurrency_control.basic.runnable_callable;

import java.util.concurrent.*;

class Main{
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        RunnableCallable rc = new RunnableCallable();
        rc.runnableExecute();
        rc.callableExecute();

        /*
         * Entered Runnable
         * Submitting Callable
         * Retrieve the result of the future
         * Entered Callable
         * Runnable Executed
         * Callable Executed
         */
    }
}

public class RunnableCallable {

    public void runnableExecute(){
        Thread t = new Thread(()->{
            System.out.println("Entered Runnable");

            try{
                Thread.sleep(2000);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Exception : "+e);
            }
            System.out.println("Runnable Executed");
        });
        t.start();
    }

    public void callableExecute() throws InterruptedException
        , ExecutionException{
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callable = () -> {
            System.out.println("Entered Callable");
            Thread.sleep(2000);
            return "Callable Executed";
        };
        System.out.println("Submitting Callable");
        Future<String> future = executorService.submit(callable);
        System.out.println("Retrieve the result of the future");
        String result = future.get();
        System.out.println(result);
        executorService.shutdown();
    }
}
