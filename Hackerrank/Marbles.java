import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

/** Problem Statement:
  * Jill and Bob are playing the following game:
  * There are 10 cups on saucers arranged in a straight line. Each saucer is
  * numbered sequentially from 1 to 10.
  * The game starts when Jill watches Bob place a marble inside the cup on
  * saucer number .
  * Bob then takes  turns. In each turn, he swaps the cups on a pair of
  * saucers numbered a and b, where a != b.
  * After Bob completes all his turns, Jill chooses an integer from 1 to 10
  * denoting the saucer where she think the cup with the marble is located.
  * Given m and Bob's sequence of moves, print the saucer number denoting the
  * marble's location at the end of the game.
  * 
  * Input Format
  * The first line contains two space-separated integers describing the
  * respective values of m (the marble's initial location) and n (Bob's number
  * of turns). 
  * Each line i of the n subsequent lines contains two space-separated integers,
  * a(i) and b(i), describing the saucer numbers for the cups Bob swaps in his
  * i^th move.
  * 
  * Output Format:
  *     Print an integer denoting the saucer number of the cup containing the
  *     marble at the end of the game.
  * Sample Input:
  *     5 3
  *     2 5
  *     7 10
  *     2 9
  * Sample Output:
  *     9
  * Explanation:
  *     Bob places the marble in the cup on saucer m=5 and performs the
  *     following sequence of n=3 moves:
  *     1.  Swap the cups in positions a=2 and b=5, so the marble is now in
  *         the cup on saucer 2.
  *     2.  Swap the cups in positions a=7 and b=10; neither of these cups
  *         currently contains the marble, so the marble is still in the cup
  *         on saucer 2.
  *     3. Swap the cups in positions a=2 and b=9, so the marble is now in
  *        the cup on saucer 9.
  *     Because the marble is in the cup on saucer 9 at the end of the game,
  *     we print 9 as our answer
  */

public class Marbles {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            if(a == m)
                m = b;
            else if(b == m)
                m = a;
        }
        System.out.println(m);
    }
}