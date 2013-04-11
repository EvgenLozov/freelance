package mycompany.server;

public class Player {

    private static int playerNumber = 0;

    private int number;
    private Integer position;

    public Player() {
        this.number = playerNumber++;
        this.position = 0;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (number != player.number) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
