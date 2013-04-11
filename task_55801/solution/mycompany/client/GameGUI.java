package mycompany.client;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

public class GameGUI {
    private Client client;
    private SnakesAndLaddersGUI gui;
    private GameGUI(){
        final JFrame jFrame = new JFrame();
        jFrame.setSize(550,650);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        gui = new SnakesAndLaddersGUI();
        gui.setPreferredSize( new Dimension( 450,450 ) );

        Box boxRollDice = Box.createVerticalBox();
        Box boxIp = Box.createHorizontalBox();
        Box boxInformation = Box.createVerticalBox();


        final JTextArea messageField = new JTextArea(5,10);

        messageField.setText("Enter ip address of the server...\n");
        Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        messageField.setBorder(solidBorder);

        final JScrollPane scrollPane = new JScrollPane(messageField);

        final JButton rollDice = new JButton("Roll the dice");
        rollDice.setVisible(false);

        rollDice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.rollDice();
            }
        });

        final JTextField ipTextField = new JTextField();

        final JButton connectButton = new JButton("Connect");

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String serverIP = ipTextField.getText();

                try {
                    client = new mycompany.client.Client(serverIP, new ResponseHandler() {

                        @Override
                        public void handle(Scanner scanner) {

                            while (true)
                            {
                                String line = scanner.nextLine();
                                if (line.matches("message:.*")){
                                    String message = line.replaceAll("message: ","");
                                    messageField.setText(message + "\n" + messageField.getText());


                                }
                                else if (line.matches("turn:.*")){
                                    String turn = line.replaceAll("turn: ","");
                                    String[] strings = turn.split(";");
                                    Integer playerNumber = Integer.valueOf(strings[0]);
                                    Integer dice = Integer.valueOf(strings[1]);
                                    Integer start = Integer.valueOf(strings[2]);
                                    Integer end = Integer.valueOf(strings[3]);

                                    try{
                                        while(dice>0){
                                            gui.setPosition(playerNumber,start++);
                                            dice--;
                                            Thread.sleep(100);
                                        }
                                        gui.setPosition(playerNumber,end);
                                    }
                                    catch(Exception e){e.printStackTrace();}
                                }
                                else if (line.matches("start:.*")){
                                    Integer playerCount = Integer.valueOf(line.replace("start: ",""));
                                    gui.setNumberOfPlayers(playerCount);
                                    for (int i = 0; i<playerCount; i++)
                                        gui.setPosition(i,0);
                                }
                            }
                        }
                    });
                } catch (IOException e1) {
                    messageField.setText("Incorrect ip address of the server!\n" + messageField.getText());
                    return;
                }

                ipTextField.setVisible(false);

                connectButton.setVisible(false);

                jFrame.remove(connectButton);
                jFrame.remove(ipTextField);

                rollDice.setVisible(true);
            }
        });


        boxRollDice.add(rollDice);
        boxRollDice.add(Box.createVerticalStrut(5));

        boxIp.add(ipTextField);
        boxIp.add(Box.createHorizontalStrut(5));
        boxIp.add(connectButton);

        boxInformation.add(scrollPane);
        boxInformation.add(Box.createVerticalStrut(5));

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(gui);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(boxRollDice);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(boxIp);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(boxInformation);
        mainBox.add(Box.createVerticalStrut(20));

        jFrame.getContentPane().add(mainBox);

        jFrame.show();

    }

    public static void main(String[] args) {
        new GameGUI();
    }
}
