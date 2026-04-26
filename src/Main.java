import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
//Elijah Mari, Maxwell Fadley, Kelvin Okocha, Edward Deensie

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        List<String> readingFromFile = new ArrayList<>();
        List<String> acceptStates = new ArrayList<>();
        List<States> statesWTransitions = new ArrayList<>();

        String numberOfStates;
        BufferedReader reader = new BufferedReader(new FileReader("DFAFile"));
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

            int currentState = 1;
            boolean validInput = true;

            for (int i = 0; i < userInput.length(); i++) {
                char c = userInput.charAt(i);
                if (c != '0' && c != '1' && c != '-1') {
                    System.out.println("Invalid input: string must only contain 0s, 1s, and -1s.");
                    validInput = false;
                    break;
                }
                int symbol = c - '0';
                boolean transitionFound = false;

                for (States st : statesWTransitions) {
                    if (st.getOldState() == currentState && st.getSymbol() == symbol) {
                        currentState = st.getNewState();
                        transitionFound = true;
                        break;
                    }
                }

                if (!transitionFound) {
                    System.out.println("No transition found from state " + currentState + " on symbol " + symbol);
                    validInput = false;
                    break;
                }
            }

            if (validInput) {
                if (acceptStates.contains(String.valueOf(currentState))) {
                    System.out.println("ACCEPT");
                } else {
                    System.out.println("REJECT");
                }
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
