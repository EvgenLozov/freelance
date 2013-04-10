package thread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: Evgen
 * Date: 04.03.13
 * Time: 21:21
 * To change this template use File | Settings | File Templates.
 */
public class Room {
    private Queue<String> queue = new LinkedList<String>();

    public synchronized String get() throws InterruptedException {
            while(queue.isEmpty()){
                System.out.println("Customer: Queue is empty. Wait...");
                wait();
            }
            System.out.println("Customer: Queue is not empty.");

        return queue.poll();
    }

    public synchronized void set(String string){
            System.out.println("Producer: Add new element to queue");
            queue.add(string);
            System.out.println("Producer: NotifyAll customer");
            notifyAll();
    }


}

class NewThread implements Runnable {

    private Thread thread;

    NewThread(String name) {
        thread = new Thread(this,name);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Thread"+Thread.currentThread().getName()+"started");
    }
}
