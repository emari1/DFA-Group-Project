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

        List<String> acceptStates;

        BufferedReader reader = new BufferedReader(new FileReader("/home/elijahmari/IdeaProjects/DFA/src/DFAFile"));
        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line);

        }


    }
}