package mycompany.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MultiThreadedServer implements Runnable {

    protected int serverPort = 9000;
    protected ServerSocket serverSocket = null;
    private int playerCount;

    private List<Client> clients = new ArrayList<Client>();
    private static final int PLAYER_COUNT = 2 ;

    public MultiThreadedServer(int port, int playerCount) {
        this.serverPort = port;
        this.playerCount = playerCount;
    }

    @Override
    public void run() {
        openServerSocket();
        List<Thread> clientsThreads = new ArrayList<Thread>();

        while (clients.size()<playerCount) {
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                throw new RuntimeException("Error accepting client connection", e);
            }
            Client client = new Client(clientSocket, this);
            Thread thread = new Thread(client);
            thread.start();
            clientsThreads.add(thread);

            clients.add(client);
            client.sendMessage("message: The connection is established.");
        }

        notifyAllClients("start: "+clients.size());
        notifyAllClients("message: The game is starting.");
        notifyAllClients("message: The player "+ Game.getInstance().getCurrentPlayer().getNumber()+"’s turn");
        for (Thread thread: clientsThreads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Client> getClients() {
        return clients;
    }

    public void notifyAllClients(String message){
        for (Client client: clients)
            client.sendMessage(message);
    }

    private void openServerSocket() {
        System.out.println("message: Opening server socket...");
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("message: Cannot open port " + this.serverPort, e);
        }
    }

    public static void main(String[] args) {
        int playerCount = PLAYER_COUNT;
        if(args.length > 0)
        {
            playerCount = Integer.parseInt(args[0]);
        }

        MultiThreadedServer server = new MultiThreadedServer(8000, playerCount);
        server.run();
    }
}