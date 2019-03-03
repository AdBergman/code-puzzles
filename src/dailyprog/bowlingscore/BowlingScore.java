package dailyprog.bowlingscore;

/**
 * https://www.reddit.com/r/dailyprogrammer/comments/3ntsni/20151007_challenge_235_intermediate_scoring_a/
 */

public class BowlingScore {
    private static String input1 = "X X X X X X X X X XXX";            //correct: 300
    private static String input2 = "X -/ X 5- 8/ 9- X 81 1- 4/X";      //correct: 137
    private static String input3 = "62 71  X 9- 8/  X  X 35 72 5/8";   //correct: 140
    private Frame[] scoreboard = new Frame[10];


    public static void main(String[] args) {
        BowlingScore score = new BowlingScore();
        score.run(input1);
        score.run(input2);
        score.run(input3);
    }

    private void run(String input) {
        System.out.println(input);
        createFrames();
        populateFrames(input);
        System.out.println("Total score: " + scoreFrames() + "\n");
    }

    private void createFrames() {
        for (int i = 0; i < 9; i++) {
            scoreboard[i] = new Frame();
        }
        scoreboard[9] = new Frame(true);

        //link them for score calculation
        for (int i = 0; i < 9; i++) {
            scoreboard[i].setNextFrame(scoreboard[i + 1]);
        }
    }

    private void populateFrames(String input) {
        String[] frameInput = input.split("\\s+"); //seperate input into frames
        for (int i = 0; i < 10; i++) {
            char[] frameRolls = frameInput[i].toCharArray(); //seperate the frames into rolls
            int[] rolls = populateRolls(frameRolls, i);  //populate char rolls into int[]
            scoreboard[i].setRolls(rolls);
        }
    }

    private int[] populateRolls(char[] frameRolls, int frameNumber) {
        int[] rolls = new int[frameRolls.length];

        int currentRoll = 0;
        for (char c : frameRolls) {
            switch (c){
                case 'X' :
                    scoreboard[frameNumber].setStrike(true);
                    rolls[currentRoll] = 10;
                    break;
                case '/' :
                    scoreboard[frameNumber].setSpare(true);
                    rolls[currentRoll] = 10 - rolls[0];
                    break;
                case '-' :
                    rolls[currentRoll] = 0;
                    break;
                default :
                    rolls[currentRoll] = Character.getNumericValue(c);
            }
            currentRoll++;
        }
        return rolls;
    }

    private int scoreFrames(){
        int totalScore = 0;
        for (Frame f : scoreboard){
            f.calculateFrameScore();
            totalScore += f.getFrameScore();
        }
        return totalScore;
    }


}
