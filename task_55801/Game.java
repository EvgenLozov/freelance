package task_55801;

import task_55801.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Evgen
 * Date: 29.03.13
 * Time: 15:42
 * To change this template use File | Settings | File Templates.
 */
public class Game {

  private List<Player> players;
  private int currentPlayer = 0;

  private static HashMap<Integer,Integer> bonusesAndPenalties;

  public Game( List<Player> players )
  {
    this.players = players;
  }

  static {
    bonusesAndPenalties = new HashMap<Integer, Integer>();
    bonusesAndPenalties.put(1,38);
    bonusesAndPenalties.put(6,16);
      bonusesAndPenalties.put(11,49);
      bonusesAndPenalties.put(21,60);
      bonusesAndPenalties.put(24,87);
      bonusesAndPenalties.put(35,54);
      bonusesAndPenalties.put(51,67);
      bonusesAndPenalties.put(78,100);
      bonusesAndPenalties.put(14,4);
      bonusesAndPenalties.put(31,9);
      bonusesAndPenalties.put(44,26);
      bonusesAndPenalties.put(62,19);
      bonusesAndPenalties.put(64,42);
      bonusesAndPenalties.put(56,53);
      bonusesAndPenalties.put(84,28);
      bonusesAndPenalties.put(98,80);
      bonusesAndPenalties.put(95,75);
      bonusesAndPenalties.put(91,71);

  }

  public Player getCurrentPlayer(){
    return players.get(currentPlayer);
  }

  public int nextTurn(){
    int dice=(int)(Math.random()*5+1);
    movePlayer(players.get(currentPlayer), dice);
    currentPlayer++;

    if(currentPlayer >= players.size())
      currentPlayer = 0;

    return dice;
  }

  public List<Player> getWinners(){
    List<Player> winners = new ArrayList<Player>();

    for (Player player: players){
      if (player.isWinner())
        winners.add(player);
    }

    return winners;
  }


  public void movePlayer(Player player, int dice){
    Integer nextPosition = player.getPosition()+dice;

    if (nextPosition<100){
      for (Integer position: bonusesAndPenalties.keySet()){
        if (nextPosition.equals(position)){
          player.setPosition( bonusesAndPenalties.get( position ) );
          return;
        }
      }

      player.setPosition( nextPosition );
    }
  }
}
