import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ExceptionPr {
        ReadSymbols readSymbols = new ReadSymbols();
        Regex regex = new Regex(readSymbols);
        Calculator calculator = new Calculator(regex.getSymbolConsol());
        System.out.println(calculator.getResult());
    }
}
