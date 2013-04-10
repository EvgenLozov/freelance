package task_55801;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: Evgen
 * Date: 29.03.13
 * Time: 21:24
 * To change this template use File | Settings | File Templates.
 */
public class TestServer {
    private final int PORT=3000;
    private PrintWriter out=null;
    private BufferedReader in=null;

    public TestServer(){
        try{
            ServerSocket ss = new ServerSocket(PORT);
            Socket soc=ss.accept();
            out=new PrintWriter(soc.getOutputStream(),true);

            in=new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String input;
            while ((input = in.readLine()) != null) {
                out.println("S ::: "+input);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

          public static void main(String args[]){
                new TestServer();
            }
}
