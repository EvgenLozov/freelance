package thread;

/**
 * Created with IntelliJ IDEA.
 * User: Evgen
 * Date: 04.03.13
 * Time: 21:21
 * To change this template use File | Settings | File Templates.
 */
public class TestWaitNotify {
    public static void main(String[] args) {
        final Room room = new Room();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    room.set("string");
                    try {
                        Thread.sleep(7000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        System.out.println("Get obj of room: " + room.get().toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
            }
        }).start();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
