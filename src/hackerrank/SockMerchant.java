package hackerrank;

/**
 * https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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


        //Prewritten code from HackerRank
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
