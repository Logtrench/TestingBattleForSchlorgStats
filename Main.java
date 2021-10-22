import java.util.*;

class Main {
  //The ai player, 50,#,10,2 is hard mode.
  public static Player p1 = new Player(50,1,10,2,4,0.25,1);
  
  
  public static void main(String[] args) {
    
    //letting the user run the code again to test the strats
    boolean run = true;
    
    
    do
    {
    
    //building the scanner
    Scanner in = new Scanner(System.in);
    
    //checking what the user wants to, find a strategy or run the found strategy
    String check = "";
    System.out.println("Which would you like to run, find a strategy [f]? or run the found strategy [r]?");

    check = in.next();
    double[] stats = new double[9];

    //do the choice
    if(check.equals("f"))
    {
      //run 2 million games to find a strategy
      for(int i = 0; i<2000000;i++)
      {
        stats = p1.game();
      }
      System.out.println(p1.toString());
       System.out.println("FINAL STATS:\n" + p1.getStats());
    }else if(check.equals("r"))
    {
      //run 1000 games to check stats
      for(int i = 0; i<1000; i++)
      {
        p1.gameTest(stats);
      }
      
      //print out the data
      System.out.println(p1.toString());
      System.out.println("FINAL STATS:\n" + p1.getStats());
    }

    
     
      //export info
      Data.main();
      
      //check if you wanna play again
      System.out.println("Would you like to run again? [true], [false]");
      run = in.nextBoolean();
      
    }while(run);
  }
    
}


