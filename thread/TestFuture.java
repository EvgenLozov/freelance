package thread;

/**
 * Created with IntelliJ IDEA.
 * User: Evgen
 * Date: 13.03.13
 * Time: 17:24
 * To change this template use File | Settings | File Templates.
 */
public class TestFuture {
    public static void main(String[] args) {
        Future f = getFuture();
        otherCode(2000);
        System.out.println(f.get());
        System.out.println(f.get());

    }

    public static Future getFuture(){
        final Future<String> future = new Future<String>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                future.set("test");
            }
        }).start();
        return future;
    }

    public static void otherCode(Integer timeSleep){
        try {
            Thread.sleep(timeSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
