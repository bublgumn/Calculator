import java.util.ArrayList;


public class Calculator {
    private String result;
    private boolean flagRims;
    private boolean flagArabs;
    public Calculator(ArrayList<String> symbolConsol) throws ExceptionPr {
        this.flagRims = ReadSymbols.getMapRims().containsKey(symbolConsol.get(0)) && ReadSymbols.getMapRims().containsKey(symbolConsol.get(1));
        this.flagArabs = ReadSymbols.getMapArabs().containsKey(symbolConsol.get(0)) && ReadSymbols.getMapArabs().containsKey(symbolConsol.get(1));
        calculation(symbolConsol);
    }
    private void calculation(ArrayList<String> symbolConsol) throws ExceptionPr {
        if (flagRims || flagArabs) {
            if (flagArabs) {
                if ("+".equals(symbolConsol.get(2).trim())) {
                    Integer result = ReadSymbols.getMapArabs().get(symbolConsol.get(0).trim()) +
                            ReadSymbols.getMapArabs().get(symbolConsol.get(1).trim());
                    this.result = result + "";
                } else if ("-".equals(symbolConsol.get(2).trim())) {
                    Integer result = ReadSymbols.getMapArabs().get(symbolConsol.get(0).trim()) -
                            ReadSymbols.getMapArabs().get(symbolConsol.get(1).trim());
                    this.result = result + "";
                } else if ("*".equals(symbolConsol.get(2).trim())) {
                    Integer result = ReadSymbols.getMapArabs().get(symbolConsol.get(0).trim()) *
                            ReadSymbols.getMapArabs().get(symbolConsol.get(1).trim());
                    this.result = result + "";
                } else if ("/".equals(symbolConsol.get(2).trim())) {
                    Integer result = ReadSymbols.getMapArabs().get(symbolConsol.get(0).trim()) /
                            ReadSymbols.getMapArabs().get(symbolConsol.get(1).trim());
                    this.result = result + "";
                }
            }
            if (flagRims) {
                Integer result = null;
                if ("+".equals(symbolConsol.get(2).trim())) {
                    result = ReadSymbols.getMapRims().get(symbolConsol.get(0).trim()) +
                            ReadSymbols.getMapRims().get(symbolConsol.get(1).trim());
                } else if ("-".equals(symbolConsol.get(2).trim())) {
                    result = ReadSymbols.getMapRims().get(symbolConsol.get(0).trim()) -
                            ReadSymbols.getMapRims().get(symbolConsol.get(1).trim());
                } else if ("*".equals(symbolConsol.get(2).trim())) {
                    result = ReadSymbols.getMapRims().get(symbolConsol.get(0).trim()) *
                            ReadSymbols.getMapRims().get(symbolConsol.get(1).trim());
                } else if ("/".equals(symbolConsol.get(2).trim())) {
                    result = ReadSymbols.getMapRims().get(symbolConsol.get(0).trim()) /
                            ReadSymbols.getMapRims().get(symbolConsol.get(1).trim());
                }
                if (result > 10) {
                    Integer value = result % 10;
                    result -= value;
                    if (value > 0) {
                        this.result = ReadSymbols.getMapArabsFromRims().get(result) + ReadSymbols.getMapArabsFromRims().get(value);
                    }
                    else this.result = ReadSymbols.getMapArabsFromRims().get(result);
                } else this.result = ReadSymbols.getMapArabsFromRims().get(result);

            }
        } else throw new ExceptionPr();
    }
    public String getResult() {
        return result;
    }
}
