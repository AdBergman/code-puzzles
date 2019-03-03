package dailyprog.bowlingscore;

public class Frame {
    private int[] rolls;
    private boolean strike = false;
    private boolean spare = false;
    private Frame nextFrame = null;
    private boolean lastFrame = false;
    private int frameScore;

    public Frame() {
    }

    public Frame(boolean lastFrame) {
        this.lastFrame = lastFrame;
    }

    public void setNextFrame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }


    public void setRolls(int[] balls) {
        this.rolls = balls;
    }

    public boolean isStrike() {
        return strike;
    }

    public void setStrike(boolean strike) {
        this.strike = strike;
    }

    public boolean isSpare() {
        return spare;
    }

    public void setSpare(boolean spare) {
        this.spare = spare;
    }

    public int getFrameScore() {
        return frameScore;
    }

    private int getRoll1(){
        return rolls[0];
    }

    private int getRoll2(){
        return rolls[1];
    }

    private int getRoll3(){
        return rolls[2];
    }

    public void calculateFrameScore() {
        if (!lastFrame) {
            calculateRegularFrameScore();
        } else {
            calculateLastFrameScore();
        }

    }

    private void calculateRegularFrameScore(){
        if (strike) {
            if (!nextFrame.lastFrame && nextFrame.strike) {
                frameScore = 10 + 10 + nextFrame.nextFrame.getRoll1();
            } else {
                frameScore = 10 + nextFrame.getRoll1() + nextFrame.getRoll2();
            }
        } else if (spare) {
            frameScore = 10 + nextFrame.getRoll1();
        } else {
            frameScore = getRoll1() + getRoll2();
        }
    }


    private void calculateLastFrameScore() {
        //only the first roll is scored
        if (getRoll1() == 10) {
            frameScore = 10 + getRoll2() + getRoll3(); //strike1
        } else if (spare){
            frameScore = 10 + getRoll3();
        }else {
            frameScore = getRoll1();
        }
    }
 }
