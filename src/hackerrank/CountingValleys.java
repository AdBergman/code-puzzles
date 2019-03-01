package hackerrank;

/**
 * https://www.hackerrank.com/challenges/counting-valleys/
 */
public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int altitude = 0;
        int amountOfValleys = 0;
        for (char c : s.toCharArray()){
            if (c == 'D' && altitude == 0) amountOfValleys++;
            altitude = (c == 'U') ? ++altitude : --altitude;
        }
        return amountOfValleys;
    }
}

