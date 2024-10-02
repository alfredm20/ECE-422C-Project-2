package assignment2;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        boolean mode = args.length > 0 && args[0].equals("1");
        Scanner input = new Scanner(System.in);
        Game player = new Game(input, mode); //make a new game - game class
        player.runGame(input); //run the game - game class

    }




}
