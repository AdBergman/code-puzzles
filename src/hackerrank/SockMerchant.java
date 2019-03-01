package hackerrank;

/**
 * https://www.hackerrank.com/challenges/sock-merchant/
 */

import java.util.HashSet;
import java.util.Set;

public class SockMerchant {

    // Complete the sockMerchant function below.
        static int sockMerchant(int n, int[] ar) {
            int numberOfPairs = 0;
            Set<Integer> currentSocksByColor = new HashSet<>();
            for (int i = 0; i < ar.length; i++){
                if(currentSocksByColor.contains(ar[i])){
                    numberOfPairs++;
                    currentSocksByColor.remove(ar[i]);
                } else {
                    currentSocksByColor.add(ar[i]);
                }
            }
            return numberOfPairs;
        }
}
