import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeMap;

public class ReadSymbols {

    private static TreeMap<String, Integer> mapRims = new TreeMap<>();
    private static TreeMap<String, Integer> mapArabs = new TreeMap<>();
    private static TreeMap<Integer, String> mapArabsInRims = new TreeMap<>();
    private String consol;

    public ReadSymbols() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            //consol = reader.nextLine();
            //Scanner reader = new Scanner(System.in);
            consol = reader.readLine();
            reader.close();
        }
        catch (Exception e) {
            System.out.println("Попробуйте снова");
        }
    }

    public static TreeMap<String, Integer> getMapRims() {
        return mapRims;
    }

    public static TreeMap<String, Integer> getMapArabs() {
        return mapArabs;
    }

    public String getConsol() {
        return consol;
    }

    public static TreeMap<Integer, String> getMapArabsInRims() {
        return mapArabsInRims;
    }

    static {
        //Римские цифры
        mapRims.put("I", 1);
        mapRims.put("II", 2);
        mapRims.put("III", 3);
        mapRims.put("IV", 4);
        mapRims.put("V", 5);
        mapRims.put("VI", 6);
        mapRims.put("VII", 7);
        mapRims.put("VIII", 8);
        mapRims.put("IX", 9);
        mapRims.put("X", 10);

        //Арабские цифры
        mapArabs.put("1", 1);
        mapArabs.put("2", 2);
        mapArabs.put("3", 3);
        mapArabs.put("4", 4);
        mapArabs.put("5", 5);
        mapArabs.put("6", 6);
        mapArabs.put("7", 7);
        mapArabs.put("8", 8);
        mapArabs.put("9", 9);
        mapArabs.put("10", 10);

        //из Арабских в Римские
        mapArabsInRims.put(1, "I");
        mapArabsInRims.put(2, "II");
        mapArabsInRims.put(3, "III");
        mapArabsInRims.put(4, "IV");
        mapArabsInRims.put(5, "V");
        mapArabsInRims.put(6, "VI");
        mapArabsInRims.put(7, "VII");
        mapArabsInRims.put(8, "VIII");
        mapArabsInRims.put(9, "IX");
        mapArabsInRims.put(10, "X");
        mapArabsInRims.put(90, "XC");
        mapArabsInRims.put(50, "L");
        mapArabsInRims.put(40, "XL");
        mapArabsInRims.put(100, "C");
    }
}
