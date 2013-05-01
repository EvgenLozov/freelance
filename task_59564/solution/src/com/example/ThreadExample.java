package com.example;

/**
 * Created with IntelliJ IDEA.
 * User: Evgen
 * Date: 08.01.13
 * Time: 19:11
 * To change this template use File | Settings | File Templates.
 */
public class ThreadExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyTask());

        thread.start();

        for (int i = 0; i<10; i++) {
            System.out.println("In Main Thread.");

            try {
                Thread.sleep( 1000 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}

class MyTask implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i<10; i++) {
            System.out.println("In MyTask.");

            try {
                Thread.sleep( 1000 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}