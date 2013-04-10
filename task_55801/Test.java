package task_55801;

import task_55801.SnakesAndLaddersGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.util.ArrayList;

public class Test
{

  public static void main( String[] a )
  {

    final JFrame jFrame = new JFrame();
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setSize(450, 450);

    SnakesAndLaddersGUI gui = new SnakesAndLaddersGUI();


      jFrame.add(gui);

    jFrame.show();

    java.util.List<Player> players = new ArrayList<Player>();
    gui.setNumberOfPlayers(5);
    for( int i = 0; i < 5; i++ )
    {
      players.add( new Player(i, 1) );
      gui.setPosition( i, 1 );
    }
    try
    {
      Thread.sleep( 1500 );
    }
    catch( Exception e )
    {
      e.printStackTrace();
    }

    Game game = new Game( players );

    while( true )
    {
      try
      {
        int dice;
        Thread.sleep( 2000 );
        for( int i = 0; i < 5; i++ )
        {
          Player player = game.getCurrentPlayer();
          int pos = player.getPosition();
          dice = game.nextTurn();
          while( dice > 0 )
          {
            gui.setPosition( i, pos++ );
            dice--;
            Thread.sleep( 300 );
          }
          gui.setPosition( player.getNumber(), player.getPosition() );
        }
      }
      catch( Exception e )
      {
        e.printStackTrace();
      }
    }
  }
}
