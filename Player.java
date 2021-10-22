import java.lang.*;

public class Player {

  
  //neural network
  double ha = 0;
  double hh = 0;
  double hd = 0;

  double ga = 0;
  double gh = 0;
  double gd = 0;

  double da = 0;
  double dh = 0;
  double dd = 0;

  int win;

  
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
  private int tieCount = 0;
  private int gameCount = 0;

  private int gold = 0;
  private int setGold = 0;
  private int setDmg = 2;
  private int price = 1;
  
  public Player(int bearHealth, int num)
  {
    this.setBearHealth = bearHealth;
    this.playerNum = num;
  }

  public Player(int bearHealth, int num, int startGold, int dmgPrice)
  {
    this.setBearHealth = bearHealth;
    this.playerNum = num;
    this.setGold = startGold;
    this.gold = this.setGold;
    this.price = dmgPrice;
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
    revise();
  }

  public void gameTest(double ha,double hh, double hd, double da, double dh, double dd, double ga, double gh, double gd)
  {
    this.ha = ha;
    this.hh = hh;
    this.hd = hd;
    this.da = da;
    this.dh = dh;
    this.dd = dd;
    this.ga = ga;
    this.gh = gh;
    this.gd = gd;
    
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
    
    //check if gold is in simulation:
    if(setGold!=0)
    {
      //earn gold based on damage taken
      this.gold += this.bearDamage;

      String choice = choice();

      if(choice.equals("health"))
      {
        if(this.gold>=5)
        {
          this.health +=3;
          this.gold -= 5;
        }
      }else if(choice.equals("damage"))
      {
        if(this.gold>=2)
        {
          this.health +=1;
          this.gold -= 2;
        }
        
      }else if (choice.equals("abstain"))
      {

      }





      /*
      //not a do ... while as should only run when parameters are met
      while(this.gold>price)
      {
        //buy gold whenever possible
        this.gold = this.gold-price;
        this.damage++;
      }*/
      
    }

    // check if any or both the user and bear died to switch the panel.
    if (health <= 0 && bearHealth <= 0) {
      this.gameCount++;
      this.tieCount++;

      this.health = this.setHealth;
      this.bearHealth = this.setBearHealth;
      this.damage = this.setDmg;
      this.gold = this.setGold;
      win = 2;


    } else if (health <= 0) {
      this.gameCount++;
      this.loseCount++;

      this.health = this.setHealth;
      this.bearHealth = this.setBearHealth;
      this.damage = this.setDmg;
      this.gold = this.setGold;

      win = 0;
      
    } else if (bearHealth <= 0) {
      this.gameCount++;
      this.winCount++;

      this.health = this.setHealth;
      this.bearHealth = this.setBearHealth;
      this.damage = this.setDmg;
      this.gold = this.setGold;

      win = 1;
    }
  }


  public String choice(){
    double buyHealth;
    double buyDamage;
    double abstain;

    buyHealth = this.health*hh + this.damage*dh + this.gold*gh;
    buyDamage = this.health*hd + this.damage*dd + this.gold*gd;
    abstain = this.health*ha + this.damage*da + this.gold*ga;

    if(buyHealth>buyDamage&&buyHealth>abstain)
    {
      return "health";
    } else if (buyDamage>buyHealth&&buyDamage>abstain)
    {
      return "damage";
    } else
    {
      return "abstain";
    }
  }

  public void revise(){
    if(win==0){
      //most variability
      ha += (Math.random()-(Math.random()))*4;
      hh += (Math.random()-(Math.random()))*4;
      hd += (Math.random()-(Math.random()))*4;

      da += (Math.random()-(Math.random()))*4;
      dh += (Math.random()-(Math.random()))*4;
      dd += (Math.random()-(Math.random()))*4;

      ga += (Math.random()-(Math.random()))*4;
      gh += (Math.random()-(Math.random()))*4;
      gd += (Math.random()-(Math.random()))*4;

    }else if(win==1)
    {
      //least variablity
      ha += (Math.random()-(Math.random()))*(1/4);
      hh += (Math.random()-(Math.random()))*(1/4);
      hd += (Math.random()-(Math.random()))*(1/4);

      da += (Math.random()-(Math.random()))*(1/4);
      dh += (Math.random()-(Math.random()))*(1/4);
      dd += (Math.random()-(Math.random()))*(1/4);

      ga += (Math.random()-(Math.random()))*(1/4);
      gh += (Math.random()-(Math.random()))*(1/4);
      gd += (Math.random()-(Math.random()))*(1/4);

    }else if(win==2)
    {
      //midpoint variablity
      ha += (Math.random()-(Math.random()));
      hh += (Math.random()-(Math.random()));
      hd += (Math.random()-(Math.random()));

      da += (Math.random()-(Math.random()));
      dh += (Math.random()-(Math.random()));
      dd += (Math.random()-(Math.random()));

      ga += (Math.random()-(Math.random()));
      gh += (Math.random()-(Math.random()));
      gd += (Math.random()-(Math.random()));
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
    return this.tieCount;
  }

  public String getStats(){
    return "H-a: " + ha + "\nH-h: " + hh + "\nH-d: " + hd + "\nD-a: " + da + "\nD-h: " + dh + "\nD-d: " + dd + "\nG-a: " + ga + "\nG-h: " + gh + "\nG-d: " + gd;
  }

  public String toString()
  {
     return ("**********\nPlayer "+this.playerNum + ": \nBearHealth: " + this.getBearHealth() + "\nWins: " + this.getWin() + "\nLosses: " + this.getLose() + "\nTies: " + this.getTie() + "\nGames Played: " + this.getGame() + "\nWinRate: " + ((double)this.getWin()/this.getGame())+ "\nLoseRate: " + ((double)this.getLose()/this.getGame())+"\nTieRate: "+((double)this.getTie()/this.getGame())+"\n**********");
  }
}