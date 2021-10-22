class Main {
  public static void main(String[] args) {
    
    //Player(bearh health, player number, starting gold, cost of buying damage)
    Player p1 = new Player(30,1);
    Player p2 = new Player(40,2);
    Player p3 = new Player(20,3);
    Player p4 = new Player(15,4);
    Player p5 = new Player(10,5);
    Player p6 = new Player(5,6);
    Player p7 = new Player(50,7,5,2);
    Player p8 = new Player(50,8,10,2);
    Player p9 = new Player(50,9,5,1);
    Player p10 = new Player(50,10,10,1);

    Player[] pList = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10};
    

    //run for every player
    for(Player x: pList)
    {
      //run a thousand games of each
      for(int i = 0; i<1000; i++)
      {
        x.game();
      }
      
      //print out the data
      System.out.println(x.toString());
    }
    
  }
}

