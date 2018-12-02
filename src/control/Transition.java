package control;

public class Transition {

    private char transition;
    private char topValue;
    private char pushValue;

    public char getTransition() {
        return transition;
    }

    public char getTopValue() {
        return topValue;
    }

    public char getPushValue() {
        return pushValue;
    }

    public Transition(char transition, char topValue, char pushValue) {
        this.transition = transition;
        this.topValue = topValue;
        this.pushValue = pushValue;
    }

    public void setTransition(char tr, char top, char push) {
        transition = tr;
        topValue = top;
        pushValue = push;
    }

    @Override
    public String toString() {
        return "Transition{" + "transition=" + transition + ", topValue=" + topValue + ", pushValue=" + pushValue + '}';
    }
    
    
}
