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
        BufferedReader reader = new BufferedReader(new FileReader("/home/elijahmari/IdeaProjects/DFA/src/DFAFile"));
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

        }
        else {
            throw new IOException("File has length of zero");
        }
    }
}