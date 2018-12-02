package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;

public class PushdownAutomaton {
    private int startStateN;
    private ArrayList<State> states;
    private List<Integer> endStatesN;
    private State currentState;
    private Stack<Character> stack;
    
    private String word;
    
    public PushdownAutomaton(List<String> list) {
        this.stack = new Stack<>();
        
        // startState
        String[] b = list.get(list.size() - 2).split("=");
        this.startStateN = Integer.parseInt(b[1]);
        
        // finalStates
        String[] e = list.get(list.size() - 1).split("=")[1].split(",");
        int[] a1 = Arrays.stream(e).mapToInt(Integer::parseInt).toArray();
        Integer[] a2 = new Integer[a1.length];
        for(int i = 0; i < a1.length; i++) a2[i] = a1[i];
        this.endStatesN = Arrays.asList(a2);
        
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
        System.out.println(this.startStateN);
        System.out.println(this.endStatesN);
        System.out.println(this.states);
        
    }
    
    public boolean process(String s) {
        this.word = s;
        stack.clear();
        int popFlag = 0;
        int charPointer = 0;
        boolean stopFlag = false;
        
        char[] letters = word.toCharArray();
        
        currentState = states.get(startStateN);
        
        while(!stopFlag && charPointer < letters.length) {
            stopFlag = true;
            
            for (int i = 0; i < currentState.getTransitions().size(); i++) {
                Transition transition = currentState.getTransitions().get(i);
                if(transition.getTransition() == letters[charPointer]) {
                    popFlag = canAddToStack(transition.getTopValue());
                    
                    if(popFlag != -1) {
                        addToStack(transition.getPushValue(), popFlag);
                        currentState = states.get(currentState.getToStatesPtrs().get(i));
                        stopFlag = false;
                    }
                }
            }
            charPointer++;
        }
        return check(stopFlag);
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
            for(Integer i: this.endStatesN) {
                if(currentState.getStateN() == i) {
                    if(stack.empty()) {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }
}
