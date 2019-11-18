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
                    this.result = rimsNumber(result);
                } else if (result < 0 && result > -11) {
                    result = Math.abs(result);
                    this.result = "-" + ReadSymbols.getMapArabsInRims().get(result);
                }
                else this.result = ReadSymbols.getMapArabsInRims().get(result);
            }
        } else throw new ExceptionPr();
    }

    private String rimsNumber (Integer arabsNumber) {
        String result = "";
        if (arabsNumber <= 39) {
            int sediment = arabsNumber % 10;
            int tens = (arabsNumber - (sediment)) / 10;
            for (int i = 0; i < tens; i++) {
                result = result + ReadSymbols.getMapArabsInRims().get(10);
            }
            if (sediment != 0)result = result + ReadSymbols.getMapArabsInRims().get(sediment);
        } else if (arabsNumber > 39 && arabsNumber <= 49) {
            result = result + ReadSymbols.getMapArabsInRims().get(40);
            int sediment = arabsNumber % 10;
            if (sediment != 0)result = result + ReadSymbols.getMapArabsInRims().get(sediment);
        } else if (arabsNumber > 49 && arabsNumber <= 89) {
            result = result + ReadSymbols.getMapArabsInRims().get(50);
            int sediment = arabsNumber % 10;
            int tens = (arabsNumber - (sediment) - 50) / 10;
            for (int i = 0; i < tens; i++) {
                result = result + ReadSymbols.getMapArabsInRims().get(10);
            }
            if (sediment != 0)result = result + ReadSymbols.getMapArabsInRims().get(sediment);
        } else if (arabsNumber > 89 && arabsNumber <= 101) {
            result = result + ReadSymbols.getMapArabsInRims().get(90);
            int sediment = arabsNumber % 10;
            if (sediment != 0)result = result + ReadSymbols.getMapArabsInRims().get(sediment);
        }
        return result;
    }

    public String getResult() {
        return result;
    }
}
