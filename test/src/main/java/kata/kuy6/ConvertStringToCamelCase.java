package kata.kuy6;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Complete the method/function so that it converts dash/underscore delimited words into camel casing. The first word
// within the output should be capitalized only if the original word was capitalized (known as Upper Camel Case, also
// often referred to as Pascal case).
//
//        Examples
//        "the-stealth-warrior" gets converted to "theStealthWarrior"
//        "The_Stealth_Warrior" gets converted to "TheStealthWarrior"
public class ConvertStringToCamelCase {

    public static String toCamelCaseStream(String str) {
        String[] words = str.split("[-_]");
        return Arrays.stream(words, 1, words.length)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .reduce(words[0], String::concat);
    }

    public static String toCamelCaseMatcher(String str) {
        Matcher m = Pattern.compile("[_|-](\\w)").matcher(str);
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            m.appendReplacement(sb, m.group(1).toUpperCase());
        }
        return m.appendTail(sb).toString();
    }

}
