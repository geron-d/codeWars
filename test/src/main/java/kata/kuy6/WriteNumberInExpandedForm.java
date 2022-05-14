package kata.kuy6;

//Write Number in Expanded Form
//        You will be given a number and you will need to return it as a string in Expanded Form. For example:
//
//        Kata.expandedForm(12); # Should return "10 + 2"
//        Kata.expandedForm(42); # Should return "40 + 2"
//        Kata.expandedForm(70304); # Should return "70000 + 300 + 4"
//        NOTE: All numbers will be whole numbers greater than 0.

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WriteNumberInExpandedForm {
    public static String expandedForm(int num) {
        String outs = "";
        for (int i = 10; i < num; i *= 10) {
            int rem = num % i;
            outs = (rem > 0) ? " + " + rem + outs : outs;
            num -= rem;
        }
        outs = num + outs;

        return outs;
    }

    public static String expandedFormStream(int num) {
        return IntStream.range(0, String.valueOf(num).length())
                .mapToObj(x -> String.valueOf(Character.getNumericValue(String.valueOf(num).charAt(x))
                        * (int) Math.pow(10, String.valueOf(num).substring(x).length() - 1)))
                .filter(x -> !x.equals("0"))
                .collect(Collectors.joining(" + "));
    }
}
