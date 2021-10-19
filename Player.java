public class Player {

  // initilization of player properties
  private int health = 10;
  private int damage = 2;
  private int bearHealth = 30;
  private int bearDamage = -1;
  private int setBearHealth = 30;
  private int setHealth = 10;
  private int playerNum = 0;

  private int winCount = 0;
  private int loseCount = 0;
  private int gameCount = 0;
  
  public Player(int bearHealth, int num)
  {
    this.setBearHealth = bearHealth;
    this.playerNum = num;
  }

  public Player(int bearHealth, int health, int damage, int num)
  {
    this.setBearHealth = bearHealth;
    this.playerNum = num;
    this.setHealth = health;
    this.damage = damage;
  }

  
  public void game()
  {
    int gameNum = gameCount;
    do
    {
      attack();
      if(gameNum!= gameCount)
      {
        break;
      }
    }while(true);
  }
  
  // the attack method
  public void attack() {
    
    // bear damage is random and should be from 0-4 (very rarely 4)
    bearDamage = (int) (Math.random() * 4);

    // change the values of player and bear health
    this.bearHealth -= this.damage;
    this.health -= this.bearDamage;

    // check if any or both the user and bear died to switch the panel.
    if (health <= 0 && bearHealth <= 0) {
      this.gameCount++;

      this.health = this.setHealth;
      this.bearHealth = this.setBearHealth;


    } else if (health <= 0) {
      this.gameCount++;
      this.loseCount++;

      this.health = this.setHealth;
      this.bearHealth = this.setBearHealth;
    } else if (bearHealth <= 0) {
      this.gameCount++;
      this.winCount++;

      this.health = this.setHealth;
      this.bearHealth = this.setBearHealth;
    }
  }

  public int getBearHealth()
  {
    return this.setBearHealth;
  }
  public int getWin()
  {
    return this.winCount;
  }
  public int getLose()
  {
    return this.loseCount;
  }
  public int getGame()
  {
    return this.gameCount;
  }
  public int getTie()
  {
    return (this.gameCount-this.loseCount)-this.winCount;
  }

  public String toString()
  {
     return ("**********\nPlayer "+this.playerNum + ": \nBearHealth: " + this.getBearHealth() + "\nWins: " + this.getWin() + "\nLosses: " + this.getLose() + "\nTies: " + this.getTie() + "\nGames Played: " + this.getGame() + "\nWinRate: " + ((double)this.getWin()/this.getGame())+ "\nLoseRate: " + ((double)this.getLose()/this.getGame())+"\nTieRate: "+((double)this.getTie()/this.getGame())+"\n**********");
  }
}