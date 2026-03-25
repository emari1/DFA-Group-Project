import com.sun.source.tree.NewArrayTree;

public class States {
    private int oldState;
    private int symbol;
    private int newState;

    public States(int oldState, int symbol, int newState){
        this.oldState = oldState;
        this.symbol = symbol;
        this.newState = newState;
    }

    public String toString(){
        return "oldState: " + oldState + " symbol: " + symbol + " newState: " + newState;
    } // for testing purposes
}
