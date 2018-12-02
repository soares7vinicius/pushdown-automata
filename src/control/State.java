package control;

import java.util.ArrayList;

public class State {

    private int stateN; 
    private ArrayList<Transition> transitions; 
    private ArrayList<Integer> toStatesPtrs; 

    public State(int stateID) {
        this.stateN = stateID;
        transitions = new ArrayList<>();
        toStatesPtrs = new ArrayList<>();
    }


    public void addTransition(Transition transition, int toState) {
        transitions.add(transition);
        toStatesPtrs.add(toState);
    }

    public int getStateN() {
        return stateN;
    }

    public ArrayList<Transition> getTransitions() {
        return transitions;
    }

    public ArrayList<Integer> getToStatesPtrs() {
        return toStatesPtrs;
    }

    @Override
    public String toString() {
        return "State{" + "stateN=" + stateN + ", transitions=" + transitions + ", toStatesPtrs=" + toStatesPtrs + '}';
    }
    
    
}
