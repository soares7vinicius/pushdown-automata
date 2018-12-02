package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;

public class PushdownAutomaton {
    private int startState;
    private ArrayList<State> states;
    private List<Integer> endStates;
    private State currentState;
    private Stack<Character> stack;
    
    private String word;
    private String reading;
    
    public PushdownAutomaton(List<String> list) {
        this.reading = new String();
        this.stack = new Stack<>();
        
        // startState
        String[] b = list.get(list.size() - 2).split("=");
        this.startState = Integer.parseInt(b[1]);
        
        // finalStates
        String[] e = list.get(list.size() - 1).split("=")[1].split(",");
        int[] a1 = Arrays.stream(e).mapToInt(Integer::parseInt).toArray();
        Integer[] a2 = new Integer[a1.length];
        for(int i = 0; i < a1.length; i++) a2[i] = a1[i];
        this.endStates = Arrays.asList(a2);
        
        // states
        this.states = new ArrayList<>();
        for(int i = 0; i < list.size()-2; i++) {
            String[] splitter = list.get(i).split(",");
            int fromState = Integer.parseInt(splitter[0]);
            Transition transition = 
                    new Transition(splitter[1].charAt(0), splitter[2].charAt(0),
                    splitter[3].charAt(0));
            int toState = Integer.parseInt(splitter[4]);
            
            if(this.states.size() <= fromState) {
                this.states.add(new State(fromState));
            }
            this.states.get(fromState).addTransition(transition, toState);
        }
        
    }
    
    public boolean process(String s) {
        this.word = s;
        stack.clear();
        int popFlag = 0;
        int charPointer = 0;
        boolean stopFlag = false;
        
        char[] letters = word.toCharArray();
        
        currentState = states.get(startState);
        
        this.reading = new String();
        this.reading += "<html>";
        this.reading += s + "<br>";
        
        while(!stopFlag && charPointer < letters.length) {
            stopFlag = true;
            
            for (int i = 0; i < currentState.getTransitions().size(); i++) {
                Transition transition = currentState.getTransitions().get(i);
                if(transition.getTransition() == letters[charPointer]) {
                    popFlag = canAddToStack(transition.getTopValue());
                    
                    if(popFlag != -1) {
                        this.reading += this.formatReading(currentState, transition, word, charPointer);
                        addToStack(transition.getPushValue(), popFlag);
                        currentState = states.get(currentState.getToStatesPtrs().get(i));
                        stopFlag = false;
                    }
                }
            }
            charPointer++;
        }
        this.reading += "</html>";
        return check(stopFlag);
    }
    
    private String formatReading(State state, Transition transition, String s, int i) {
        return String.format("%s<font color='blue'>q%d</font><font color='red'>%s</font>%s<br>",
                s.substring(0,i), state.getStateN(), transition.getTransition(), s.substring(i+1, s.length()));
    }
    
    private int canAddToStack(char pre) {
        if(pre == '?') return 0;
        else if(!stack.empty()) {
            if(stack.peek() == pre) return 1;
        }
        return -1;
    }
    
    private void addToStack(char post, int popFlag) {
        if(popFlag == 1) stack.pop();
        if(post != '?') stack.push(post);
    }
    
    private boolean check(boolean stopFlag){
        boolean flag = false;
        
        if(stopFlag) return false;
        else {
            for(Integer i: this.endStates) {
                if(currentState.getStateN() == i) {
                    if(stack.empty()) {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public String getReading() {
        return reading;
    }
}
