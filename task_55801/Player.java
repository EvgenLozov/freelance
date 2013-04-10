package task_55801;

public class Player
{

  private int number;
  private Integer position;
  private boolean winner;

  public Player( int number, Integer position )
  {
    this.number = number;
    this.position = position;
  }

  public Integer getPosition()
  {
    return position;
  }

  public void setPosition( Integer position )
  {
    this.position = position;
  }

  public boolean isWinner()
  {
    return winner;
  }

  public void setWinner( boolean winner )
  {
    this.winner = winner;
  }

  public int getNumber()
  {
    return number;
  }

  public void setNumber( int number )
  {
    this.number = number;
  }
}
