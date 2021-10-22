class Main {
  public static Player p1 = new Player(50,1,10,2);
  public static void main(String[] args) {
    
    //Player(bearh health, player number, starting gold, cost of buying damage)
    // Player p1 = new Player(30,1);
    // Player p2 = new Player(40,2);
    // Player p3 = new Player(20,3);
    // Player p4 = new Player(15,4);
    // Player p5 = new Player(10,5);
    // Player p6 = new Player(5,6);
    
    
    // Player p8 = new Player(30,8,4,2);
    // Player p9 = new Player(15,9,5,2);
    // Player p10 = new Player(30,10,5,1);
    //p1,p2,p3,p4,p5,p6,
    Player[] pList = {p1};
    

    //run for every player
    for(Player x: pList)
    {
      //run a thousand games of each
      for(int i = 0; i<10000; i++)
      {
        x.gameTest(2590.7835586281444, 271.1650297937091, -155.18035270092457, 757.2718834138445, 1120.416363100365, 2069.5535031036466, -2513.824721597679, 1060.3550534214562, -1674.1587661938036);
        if(i%500==0)
        {
          System.out.println(x.getStats());
          System.out.println("**********");
        }
      }
      
      //print out the data
      System.out.println(x.toString());
      System.out.println("FINAL STATS:\n" + x.getStats());
      Data.main();
      

      
    }
    
  }
}


