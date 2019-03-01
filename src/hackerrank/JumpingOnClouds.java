package hackerrank;

/**
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds/
 */
public class JumpingOnClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int amountOfJumps = -1;
        for(int i = 0; i < c.length; i++){
            if (i < c.length -2 && c[i+2] == 0) {
                i++;
            }
            amountOfJumps++;
        }
        return amountOfJumps;
    }
}
