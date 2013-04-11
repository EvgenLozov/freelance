package mycompany.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<Player>();
    private int currentPlayer = 0;
    private boolean winnerDetermined;

    private static HashMap<Integer, Integer> bonusesAndPenalties;

    private static Game instance = new Game();

    private Game(){
    }

    public static Game getInstance(){
        return instance;
    }

    static {
        bonusesAndPenalties = new HashMap<Integer, Integer>();
        bonusesAndPenalties.put(1, 38);
        bonusesAndPenalties.put(14, 4);
        bonusesAndPenalties.put(6, 16);
        bonusesAndPenalties.put(9, 31);
        bonusesAndPenalties.put(11, 49);
        bonusesAndPenalties.put(21, 60);
        bonusesAndPenalties.put(24, 87);
        bonusesAndPenalties.put(35, 54);
        bonusesAndPenalties.put(51, 67);
        bonusesAndPenalties.put(56, 53);
        bonusesAndPenalties.put(62, 19);
        bonusesAndPenalties.put(73, 92);
        bonusesAndPenalties.put(78, 100);
        bonusesAndPenalties.put(84, 28);
        bonusesAndPenalties.put(91, 71);
        bonusesAndPenalties.put(95, 75);
        bonusesAndPenalties.put(98, 80);
        bonusesAndPenalties.put(31, 9);
        bonusesAndPenalties.put(44, 26);
        bonusesAndPenalties.put(64, 42);
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    public int nextTurn() {
        if (winnerDetermined)
            return 0;

        int dice = (int) (Math.random() * 5 + 1);
        movePlayer(players.get(currentPlayer), dice);

        if(!winnerDetermined)
            currentPlayer++;

        if (currentPlayer >= players.size())
            currentPlayer = 0;

        return dice;
    }

    public Player getWinner() {
        if(winnerDetermined)
            return players.get(currentPlayer);

        return null;
    }


    public void movePlayer(Player player, int dice) {
        Integer nextPosition = player.getPosition() + dice;

        if (nextPosition < 100) {
            for (Integer position : bonusesAndPenalties.keySet()) {
                if (nextPosition.equals(position)) {
                    player.setPosition(bonusesAndPenalties.get(position));
                    return;
                }
            }

            player.setPosition(nextPosition);
        }
        else  if (nextPosition == 100)
        {
            winnerDetermined = true;
            player.setPosition(nextPosition);
        }
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public boolean isWinnerDetermined() {
        return winnerDetermined;
    }
}
