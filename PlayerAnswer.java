package assignment2;

import java.util.Objects;

public class PlayerAnswer {

    public static boolean checkAnswer(String pAnswer, String sCode, int numGuesses){

        if(!Objects.equals(pAnswer, "HISTORY") && pAnswer.length() != GameConfiguration.pegNumber ){
            System.out.println(pAnswer + " -> INVALID GUESS");
            System.out.println(" ");
            return false;
        }

        if(Objects.equals(pAnswer, sCode)){
            return true;

        }else if(pAnswer.equals("HISTORY")){
            History.getHistory(numGuesses);

        }else if(numGuesses > 0){
            compareAnswers(pAnswer, sCode);
        }

        return false;

    }

    public static void compareAnswers(String pAnswer, String sCode){


        String result = " ";

        int black = 0;
        int white = 0;

        char []pA = new char[pAnswer.length()];
        char []sC = new char[sCode.length()];

        for(int i = 0 ; i < pAnswer.length(); i++){
            pA[i] = pAnswer.charAt(i); //string to array
        }

        for(int i = 0; i < sCode.length(); i++){
            sC[i] = sCode.charAt(i);
        }

        for(int i = 0; i < pAnswer.length(); i++){ //put "B" where letters and spots are the same
            if(pA[i] == sC[i]){
                pA[i] = '-';
                sC[i] = '-';
                black++;
            }
        }

        for(int i = 0; i < pAnswer.length(); i++){
            for(int j = 0; j < sCode.length(); j++){

                if (pA[j] != '-') {
                    if(pA[j] == sC[i]){
                        white++;
                        pA[j] = '-';
                        break;
                    }
                }

            }

        }

        result = black + "B_" + white + "W";
        System.out.println(" ");
        System.out.println(pAnswer + " -> Result: " + result);
        System.out.println(" ");

        History.updateHistory(pAnswer, result); //send to history class

    }


}
