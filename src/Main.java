import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        List<String> readingFromFile = new ArrayList<>();
        List<String> acceptStates = new ArrayList<>();
        String numberOfStates;
        BufferedReader reader = new BufferedReader(new FileReader("/home/elijahmari/IdeaProjects/DFA/src/DFAFile"));
        String line;
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


        for(int i = 0; i < Integer.parseInt(numberOfStates); i++){
            //make the States objects
        }

        //another for loop for adding the transitions



    }
}