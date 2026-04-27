import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//Elijah Mari, Maxwell Fadley, Kelvin Okocha, Edward Deensie

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //Computation of the epsilon-closure in a set of states.
    public static Set<Integer> epsilonClosure(Set<Integer> states, List<States> transitions) {
        Set<Integer> closure = new HashSet<>(states);
        Deque<Integer> stack = new ArrayDeque<>(states);
        while (!stack.isEmpty()) {
            int currentState = stack.pop();
            for (States s: transitions) {
                if (s.getOldState() == currentState && s.getSymbol() == -1) {
                    if (closure.add(s.getNewState())) {
                        stack.push(s.getNewState());
                    }
                }
            }
        }
        return closure;
    }
    //Given a set of current states and an input symbol,
    //Method returns all states that are reachable via the input symbol before closure.
    public static Set<Integer> move(Set<Integer> states, int symbol, List<States> transitions) {
        Set<Integer> result = new HashSet<>();
        for (int state : states) {
            for (States s: transitions) {
                if (s.getOldState() == state && s.getSymbol() == symbol) {
                    result.add(s.getNewState());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        List<String> readingFromFile = new ArrayList<>();
        List<String> acceptStates = new ArrayList<>();
        List<States> statesWTransitions = new ArrayList<>();

        String numberOfStates;
        BufferedReader reader = new BufferedReader(new FileReader("NFAFile"));
        String line;
        int whole=reader.read();
        System.out.println(whole);
        Scanner scanner = new Scanner(System.in);
        if(whole  != -1){
            System.out.println("input the string you would like to use");
            String userInput=scanner.nextLine();
            System.out.println(userInput);
            while((line = reader.readLine()) != null){
                System.out.println(line);
                readingFromFile.add(line);
            }

            System.out.println(readingFromFile.get(1));
            numberOfStates = readingFromFile.get(0);
            String acception = readingFromFile.get(1);
            String [] arr = acception.split(" ");
            acceptStates.addAll(Arrays.asList(arr));
            System.out.println(acceptStates.get(0));


//            for(int i = 2; i < Integer.parseInt(numberOfStates); i++){
//                //make the States objects
//                States state = new States(0,0,0);
//                statesWTransitions.add(state);
//            }

            for(int i = 2; i < readingFromFile.size(); i++){
            // i = 2 ignores the first 2 lines of the file, rest of it is the states
                String [] stateInfo = readingFromFile.get(i).split(" ");
                // get the 3 integers (old, symbol, new)
                States state = new States(
                    Integer.parseInt(stateInfo[0]),
                    Integer.parseInt(stateInfo[1]),
                    Integer.parseInt(stateInfo[2])
                );
                // make the state object with the old symbol new in our array, then add it to arraylist
                statesWTransitions.add(state);
            }


            boolean validInput = true;

            Set<Integer> currentStates = epsilonClosure(Set.of(1), statesWTransitions);

            for (int i = 0; i < userInput.length(); i++) {
                char c = userInput.charAt(i);
                if (c != '0' && c != '1') {
                    System.out.println("Invalid input: string must only contain 0s and 1s.");
                    validInput = false;
                    break;
                }
                int symbol = c - '0';

                Set<Integer> moved = move(currentStates, symbol, statesWTransitions);
                currentStates = epsilonClosure(moved, statesWTransitions);

            }

            if (validInput) {
                boolean accepted = false;
                for (int state : currentStates) {
                    if (acceptStates.contains(String.valueOf(state))) {
                        accepted = true;
                        break;
                    }
                }
                System.out.println(accepted ? "ACCEPT" : "REJECT");
            }

            // for (States st : statesWTransitions) { test for states
            //     System.out.println(st.toString());
            // }

        }
        else {
            throw new IOException("File has length of zero");
        }
    }
}
