package task_55801;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Evgen
 * Date: 29.03.13
 * Time: 9:19
 * To change this template use File | Settings | File Templates.
 */
public class DemoSwing {
    JLabel jLabel = new JLabel();

    DemoSwing(){
        final JFrame jFrame = new JFrame();
        jFrame.setSize(550,600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakesAndLaddersGUI gui = new SnakesAndLaddersGUI();
        gui.setPreferredSize( new Dimension( 450,450 ) );

        Box box = Box.createVerticalBox();
        Box box1 = Box.createHorizontalBox();
        Box boxInformation = Box.createVerticalBox();


        final JLabel messageLabel = new JLabel("Enter your ip address and click the button Connect.");
        Border solidBorder = BorderFactory.createLineBorder(Color.green, 1);
        messageLabel.setBorder(solidBorder);
        messageLabel.setForeground(Color.BLACK);
        messageLabel.setPreferredSize(new Dimension(450,25));


        final JButton jButton1 = new JButton("Roll the dice");
        jButton1.setVisible(false);

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("You threw the dice.");
            }
        });

        final JTextField ipTextField = new JTextField();

        final JButton connectButton = new JButton("Connect");

        final JLabel ip = new JLabel("Your IP Address: ");
        Font font = new Font(null, Font.BOLD, 10);
        ip.setFont(font);
        ip.setVisible(false);

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ip.setText(ip.getText() + ipTextField.getText());
                ip.setVisible(true);

                messageLabel.setText("The connections are made.");

                ipTextField.setVisible(false);

                connectButton.setVisible(false);

                jFrame.remove(connectButton);
                jFrame.remove(ipTextField);

                jButton1.setVisible(true);
            }
        });


        box.add(jButton1);
        box.add(Box.createVerticalStrut(1));

        box.add(jLabel);
        box.add(Box.createVerticalStrut(1));

        box1.add(ipTextField);
        box1.add(Box.createHorizontalStrut(1));
        box1.add(connectButton);

        boxInformation.add(messageLabel);
        boxInformation.add(Box.createVerticalStrut(10));
        boxInformation.add(ip);
        boxInformation.add(Box.createVerticalStrut(10));

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(gui);
        mainBox.add(Box.createVerticalStrut(15));
        mainBox.add(box);
        mainBox.add(Box.createVerticalStrut(7));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(2));
        mainBox.add(boxInformation);
        mainBox.add(Box.createVerticalStrut(10));

        jFrame.add(mainBox);

        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DemoSwing();
            }
        });
    }
}
