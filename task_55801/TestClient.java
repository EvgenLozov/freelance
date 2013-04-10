package task_55801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: Evgen
 * Date: 29.03.13
 * Time: 21:23
 * To change this template use File | Settings | File Templates.
 */
public class TestClient {
    private final int PORT=3000; //Port number
    private PrintWriter out=null;
    private BufferedReader in=null;

    int c;

    public TestClient(){
        try{
            Socket socket = new Socket("127.0.0.1",PORT);
            in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public void setRequest(String request){
        out.println(request);
    }

    public String getResponse() throws IOException {
        return in.readLine();
    }
}


