package edu.miracosta.cs113;

/**
 * RandomClue.java : Your job is to ask your AssistantJack and get the correct
 * answer in <= 20 tries.  RandomClue is ONE solution to the problem,
 * where a set of random numbers is generated every attempt until all three
 * random numbers match the solution from the AssistantJack object.
 *
 * This is a sample solution, a driver using random number implementation.
 * You can use this file as a guide to create your own SEPARATE driver for
 * your implementation that can solve it in <= 20 times consistently.
 *
 * @author Nery Chapeton-Lamas (material from Kevin Lewis)
 * @version 1.0
 *
 */

import java.util.Random;
import java.util.Scanner;
import model.Theory;
import model.AssistantJack;

public class myClassSolver {

    /*
     * ALGORITHM:
     *
     * PROMPT "Which theory to test? (1, 2, 3[random]): "
     * READ answerSet
     * INSTANTIATE jack = new AssistantJack(answerSet)
     * DO
     *      weapon = random int between 1 and 6
     *      location = random int between 1 and 10
     *      murder = random int between 1 and 6
     *      solution = jack.checkAnswer(weapon, location, murder)
     * WHILE solution != 0
     *
     * OUTPUT "Total checks = " + jack.getTimesAsked()
     * IF jack.getTimesAsked() is greater than 20 THEN
     *      OUTPUT "FAILED"
     * ELSE
     *      OUTPUT "PASSED"
     * END IF
     */

    /**
     * Driver method for random guessing approach
     *
     * @param args not used for driver
     */
    public static void main(String[] args) {
        // DECLARATION + INITIALIZATION
        int answerSet,
                solution, murder=6, weapon=6, location=10;
        Theory answer;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        // INPUT
        System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");

        answerSet = keyboard.nextInt();
        keyboard.close();
        // PROCESSING
        jack = new AssistantJack(answerSet);

        boolean []mur= new boolean[murder];
        boolean []loc = new boolean[location];
        boolean []wep = new boolean[weapon];

        for(int i = 0; i<mur.length;i++){
            mur[i]=true;
        }
        for(int i = 0; i<loc.length;i++){
            loc[i]=true;
        }
        for(int i = 0; i<wep.length;i++){
            wep[i]=true;
        }
        do {
            int m = -1, l = -1, w = -1;
            for(int i =0; i<murder;i++)
                if(mur[i])
                    m = i;
            for(int i =0; i<location;i++)
                if(loc[i])
                    l = i;
             for(int i =0; i<weapon;i++)
                if(wep[i])
                    w = i;
            solution = jack.checkAnswer(weapon+1, location+1, murder+1);

            if(solution == 1) {
                mur[m] = false;
            }
                else if (solution == 2){
                loc[l] = false;
            }
                else if(solution == 3){
                    wep[w] = false;
            }

        } while(solution != 0);

                    answer = new Theory(weapon, location, murder);

                    // OUTPUT

                    //System.out.println("Answer: " + solution);
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);
                    if (jack.getTimesAsked() > 20) {
                        System.out.println("FAILED!! You're a horrible Detective...");
                    } else {
                        System.out.println("WOW! You might as well be called Batman!");
                    }
        }

}