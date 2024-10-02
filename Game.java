package assignment2;

import java.util.Scanner;

public class Game {
    boolean testingMode;

    Game(Scanner input, boolean mode){ //constructor
        startMessage();
        this.testingMode = mode;
    }

    public void runGame(Scanner input){
        boolean startGame = true;

        if (!shouldIStart(input)) {
            System.exit(0); // If the player doesn't want to start, exit the program
        }

        String sCode = SecretCodeGenerator.getInstance().getNewSecretCode();

        if(testingMode){
            System.out.print("Generating secret code ...(for this example the secret code is " + sCode);
        }else{
            System.out.println("Generating secret code ...");
        }

       while(startGame){

           int numGuesses = GameConfiguration.guessNumber;


               System.out.println(" ");
               System.out.println("You have " + numGuesses + " guesses left.");

               while(numGuesses > 0){
                   System.out.println("What is your next guess?\n" +
                           "Type in the characters for your guess and press enter.\n" +
                           "Enter guess: ");

                   String answer = input.nextLine();

                   if (answer.length() == GameConfiguration.pegNumber) {
                       numGuesses--;
                   }

                   if(PlayerAnswer.checkAnswer(answer, sCode, numGuesses)){ //send answer to PlayerAnswer method if PlayerAnswer method returns that the answer is right, break
                       System.out.println(answer + " -> 4B_0W - You win");
                       break;
                   }

                   if(numGuesses > 0){
                       System.out.println("You have " + numGuesses + " guesses left.");
                   }
                   
                   if(numGuesses == 0){ //if numGuesses == 0, break
                       System.out.println("Sorry, you are out of guesses. You lose, boo-hoo.");
                   }


               }

               startGame = anotherGame(input);
       }


    }

    public static void startMessage(){
        System.out.println("Welcome to Mastermind. Here are the rules.");
        System.out.println(" ");
        System.out.println("This is a text version of the classic board game Mastermind.");
        System.out.println(" ");
        System.out.println("The computer will think of a secret code. The code consists of " + GameConfiguration.pegNumber + "\n" +
                "colored pegs. The pegs MUST be one of six colors: blue, green,\n" +
                "orange, purple, red, or yellow. A color may appear more than once in\n" +
                "the code. You try to guess what colored pegs are in the code and\n" +
                "what order they are in. After you make a valid guess the result\n" +
                "(feedback) will be displayed.");
        System.out.println(" ");
        System.out.println("The result consists of a black peg for each peg you have guessed\n" +
                "exactly correct (color and position) in your guess. For each peg in\n" +
                "the guess that is the correct color, but is out of position, you get\n" +
                "a white peg. For each peg, which is fully incorrect, you get no\n" +
                "feedback.");
        System.out.println(" ");
        System.out.println("Only the first letter of the color is displayed. B for Blue, R for\n" +
                "Red, and so forth. When entering guesses you only need to enter the\n" +
                "first character of each color as a capital letter.");
        System.out.println(" ");

    }

    public static boolean  shouldIStart(Scanner input) {

        while (true) {

            System.out.println("You have " + GameConfiguration.guessNumber + " guesses to figure out the secret code or you lose the\n" +
                    "game. Are you ready to play? (Y/N): "); //THIS IS PRINTED TWICE AFTER ASKING FOR ANOTHER GAME FOR SOME REASON???

            String yesOrNo = input.nextLine().trim();

            if (yesOrNo.equals("Y")) {
                return true;

            } else if (yesOrNo.equals("N")) {
                return false;

            }
        }
    }

    public static boolean anotherGame(Scanner input){
        System.out.println(" ");
        System.out.println("Are you ready for another game (Y/N): ");

        while(true){

            String yesOrNO = input.nextLine().trim();

            if(yesOrNO.equals("Y")){
                return true;

            }else if(yesOrNO.equals("N")){
                return false;

            }else{
                System.out.println("Enter either 'Y' or 'N': ");
            }

        }


    }

}
