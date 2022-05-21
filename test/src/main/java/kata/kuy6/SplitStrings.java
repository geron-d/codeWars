package kata.kuy6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Complete the solution so that it splits the string into pairs of two characters. If the string contains an odd number
// of characters then it should replace the missing second character of the final pair with an underscore ('_').
//
//        Examples:
//
//        * 'abc' =>  ['ab', 'c_']
//        * 'abcdef' => ['ab', 'cd', 'ef']
public class SplitStrings {
    public static String[] solution(String s) {
        List<String> splitStrings = new ArrayList<>();
        s = (s.length() % 2 == 0) ? s : s + "_";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2) {
                splitStrings.add(chars[i] + "" + chars[i + 1]);
        }
        return splitStrings.toArray(String[]::new);
    }

}
