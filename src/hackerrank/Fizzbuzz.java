package hackerrank;

/**
 * Write a short program that prints each number from 1 to 100 on a new line.
 * For each multiple of 3, print "Fizz" instead of the number.
 * For each multiple of 5, print "Buzz" instead of the number.
 * For numbers which are multiples of both 3 and 5, print "FizzBuzz" instead of the number.
 */

public class Fizzbuzz {
    private final static int LENGTH = 100;

    public static void main(String[] args) {

        for(int i = 1; i <= LENGTH; i++){
            if (i % 3 == 0) {
                System.out.print("Fizz");
            }
            if (i % 5 == 0){
                System.out.print("Buzz");
            } else if (i % 3 != 0){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
