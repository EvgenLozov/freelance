package mycompany.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {

    protected Socket clientSocket = null;
    private Scanner scanner ;
    private PrintWriter writer;
    private Player player;
    private MultiThreadedServer server;

    public Client(Socket clientSocket,MultiThreadedServer server ) {
        this.clientSocket = clientSocket;
        this.server = server;

        try {
            scanner = new Scanner(clientSocket.getInputStream());
            writer = new PrintWriter(clientSocket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException("Error getting client connection ", e);
        }

        player = new Player();
        Game.getInstance().addPlayer(player);
    }

    @Override
    public void run() {
        while (true) {
            String line = scanner.nextLine();
            Game game = Game.getInstance();

            if(!player.equals(game.getCurrentPlayer()))
                continue;

            int start = player.getPosition();
            int dice = game.nextTurn();
            int end = player.getPosition();

            String message = "turn: "+player.getNumber()+";"+dice+";"+start+";"+end;

            server.notifyAllClients(message);
            if(game.isWinnerDetermined()){
                server.notifyAllClients("message: Player "+player.getNumber()+" is winner!");
            }
            else {
                server.notifyAllClients("message: The player "+Game.getInstance().getCurrentPlayer().getNumber()+"’s turn");
                server.notifyAllClients("message: Player "+Game.getInstance().getCurrentPlayer().getNumber()+"’s has the dice: "+dice);
            }
        }
    }

    public void sendMessage(String message) {
        writer.println(message);
        writer.flush();
    }
}