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

    public int getOldState(){
        return oldState;
    }

    public int getSymbol() {
        return symbol;
    }

    public int getNewState(){
        return newState;
    }

    public String toString(){
        String symbol1 = (symbol == -1) ? "ε" : String.valueOf(symbol);
        return "oldState: " + oldState + " symbol: " + symbol1 + " newState: " + newState;
    } // for testing purposes
}
