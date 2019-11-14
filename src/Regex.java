import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private ArrayList<String> symbolConsol = new ArrayList<>();
    public Regex(ReadSymbols readSymbols) throws ExceptionPr {
        separation(readSymbols);
    }
    public ArrayList<String> getSymbolConsol() {
        return symbolConsol;
    }
    private void separation(ReadSymbols readSymbols) throws ExceptionPr {
        String[] array = readSymbols.getConsol().split("[+,-,*,/]{1}");
        if (array.length == 1) throw new ExceptionPr();
        Pattern paternNoNumber = Pattern.compile("[+,-,*,/]{1}");
        Matcher matcherNoNumber = paternNoNumber.matcher(readSymbols.getConsol());
        for (int i = 0; i < array.length; i++) {
            this.symbolConsol.add(array[i].trim());
        }
        matcherNoNumber.find();
        this.symbolConsol.add(matcherNoNumber.group().trim());
    }
}
