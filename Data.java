import java.io.*;
class Data {

  public static void main() {
    try {

      // This will read the old scoreboard
      BufferedReader br = new BufferedReader(new FileReader("Stats.txt"));

      // this will write the old scoreboard into a temporary
      BufferedWriter bwt = new BufferedWriter(new FileWriter("Stats-temp.txt"));

      // this will read the temporary
      BufferedReader brt = new BufferedReader(new FileReader("Stats-temp.txt"));

      // creation of a string to read
      String s;

      // will write everything from the original file into the temporary
      while ((s = br.readLine()) != null) {
        bwt.write(s + "\n");

      }

      // reset of old file and writer which will copy temp file into new file along
      // with new score
      BufferedWriter bw = new BufferedWriter(new FileWriter("Stats.txt"));

      // add new score to temp file when nothing is read
      if ((s = br.readLine()) == null) {
        bwt.write("**********\n");
        bwt.write("H-a: " + Main.p1.ha + "\n");
        bwt.write("H-h: " + Main.p1.hh + "\n");
        bwt.write("H-d: " + Main.p1.hd + "\n");
        bwt.write("D-a: " + Main.p1.da + "\n");
        bwt.write("D-h: " + Main.p1.dh + "\n");
        bwt.write("D-d: " + Main.p1.dd + "\n");
        bwt.write("G-a: " + Main.p1.ga + "\n");
        bwt.write("G-h: " + Main.p1.gh + "\n");
        bwt.write("G-d: " + Main.p1.gd + "\n");
        bwt.write("The stats in csa:\n");
        bwt.write(Main.p1.ha + ", " + Main.p1.hh + ", " + Main.p1.hd + ", " + Main.p1.da + ", " + Main.p1.dh + ", " + Main.p1.dd + ", " + Main.p1.ga + ", " + Main.p1.gh + ", " + Main.p1.gd);
        bwt.write("\n**********\n");

      }

      // close reader and writier for first file so that others can right
      br.close();
      bwt.close();

      //writing the temp file into the scoreboard
      String t = "";
      while ((t = brt.readLine()) != null) {
        bw.write(t + "\n");
      }

      //closing the other reader and writer
      brt.close();
      bw.close();

      //deleting the Scoreboard temp file
      File newFile = new File("Stats-temp.txt");
      newFile.delete();

    } catch (FileNotFoundException e) {
      //if no file is found, create a new file
      System.out.println("Creating Stats File...");
      try {
        BufferedWriter bw = new BufferedWriter(new FileWriter("Stats.txt"));

        //add score
        bw.write("**********\n");
        bw.write("H-a: " + Main.p1.ha + "\n");
        bw.write("H-h: " + Main.p1.hh + "\n");
        bw.write("H-d: " + Main.p1.hd + "\n");
        bw.write("D-a: " + Main.p1.da + "\n");
        bw.write("D-h: " + Main.p1.dh + "\n");
        bw.write("D-d: " + Main.p1.dd + "\n");
        bw.write("G-a: " + Main.p1.ga + "\n");
        bw.write("G-h: " + Main.p1.gh + "\n");
        bw.write("G-d: " + Main.p1.gd + "\n");
        bw.write("The stats in csa:\n");
        bw.write(Main.p1.ha + ", " + Main.p1.hh + ", " + Main.p1.hd + ", " + Main.p1.da + ", " + Main.p1.dh + ", " + Main.p1.dd + ", " + Main.p1.ga + ", " + Main.p1.gh + ", " + Main.p1.gd);
        bw.write("WinRate: " + ((double)Main.p1.getWin()/Main.p1.getGame()) + "\n");
        bw.write("**********\n");

        //close writer
        bw.close();
      } catch (Exception f) {
        //print there was an error
        System.out.println("There was an error in the bufferReader, when there was no file");
      }

      return;
    } catch (Exception e) {
        //print if there was an error
      System.out.println("There was an error in the bufferReader, already having a file");

      return;
    }
  }

}