package mycompany.client;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    private final int PORT = 8000;
    private Socket socket;
    private PrintWriter out = null;
    private Scanner in = null;


    private String send(String line) throws IOException {
        out.println(line);

        return in.nextLine();
    }

    public Client(String ip, final ResponseHandler responder) throws IOException {
        socket = new Socket(ip, PORT);
        in = new Scanner(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream());

        new Thread(new Runnable() {
            @Override
            public void run() {
                responder.handle(in);
            }
        }).start();
    }

    public void rollDice()
    {
        out.println("");
        out.flush();
    }


    public PrintWriter getOut() {
        return out;
    }

    public Scanner getIn() {
        return in;
    }
}
