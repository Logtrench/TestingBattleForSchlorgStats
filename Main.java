class Main {
  public static void main(String[] args) {
    Player p1 = new Player(30,1);
    Player p2 = new Player(40,2);
    Player p3 = new Player(20,3);
    Player p4 = new Player(15,4);
    Player p5 = new Player(10,5);
    Player p6 = new Player(5,6);
    Player p7 = new Player(30,23,2,7);
    

    for(int i = 0; i<1000; i++)
    {
      p1.game();
    }

    for(int i = 0; i<1000; i++)
    {
      p2.game();
      
    }

    for(int i = 0; i<1000; i++)
    {
      p3.game();
    }

    for(int i = 0; i<1000; i++)
    {
      p4.game();
    }

    for(int i = 0; i<1000; i++)
    {
      p5.game();
    }

    for(int i = 0; i<1000; i++)
    {
      p6.game();
    }

    for(int i = 0; i<1000; i++)
    {
      p7.game();
    }


    System.out.println(p1.toString());
    System.out.println(p2.toString());
    System.out.println(p3.toString());
    System.out.println(p4.toString());
    System.out.println(p5.toString());
    System.out.println(p6.toString());
    System.out.println(p7.toString());
    
  }
}


