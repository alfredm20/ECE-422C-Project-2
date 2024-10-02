package assignment2;

import java.util.ArrayList;

public class History {

    static ArrayList<String> hist = new ArrayList<String>();
    static ArrayList<String> res = new ArrayList<String>();


    public static void updateHistory(String pAnswer, String result){
        hist.add(pAnswer);
        res.add(result);
    }

    public static void getHistory(int guesses){

        for(int i = 0; i < hist.size(); i++){
            System.out.println(hist.get(i) + "        " + res.get(i));
        }

        System.out.println(" ");
        System.out.println("You have " + guesses + " guesses left.");


    }
}
