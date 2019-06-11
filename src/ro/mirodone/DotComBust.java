package ro.mirodone;

import java.util.ArrayList;

public class DotComBust {


    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<>();
    private int numOfGuesses = 0;


     void setUpGame(){
        DotCom one = new DotCom();
        one.setName("aol.com");
        DotCom two = new DotCom();
        two.setName("abc.com");
        DotCom three = new DotCom();
        three.setName("go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("aol.com, abc.com, go2.com ");
        System.out.println("Try to sink them all in the fewer number of guesses");

        for (DotCom dotComToSet : dotComsList){
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }

    }

     void startPlaying() {
        while (!dotComsList.isEmpty()){
            String userGuess = helper.getUserInput ("Enter a guess");
            checkUserGuess (userGuess);
        }
        finishGame();
    }

    private void checkUserGuess (String userGuess){

        numOfGuesses++;
        String result = "miss";

        for (DotCom dotComToTest : dotComsList){
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("hit")){
                break;
            }
            if (result.equals("kill")){
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {

        System.out.println("all dot coms are sunk!");
        if (numOfGuesses <=18) {
            System.out.println("it only took you "+ numOfGuesses + " guesses");
            System.out.println("You got out before your options sank");
        }else {
            System.out.println("Took you long enough "+ numOfGuesses + " guesses");
            System.out.println("no more options");
        }
    }
}
