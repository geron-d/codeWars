package kata.kuy7;

//In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.
//
//        Examples
//        highAndLow("1 2 3 4 5")  // return "5 1"
//        highAndLow("1 2 -3 4 5") // return "5 -3"
//        highAndLow("1 9 3 4 -5") // return "9 -5"
//        Notes
//        All numbers are valid Int32, no need to validate them.
//        There will always be at least one number in the input string.
//        Output string must be two numbers separated by a single space, and highest number is first.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class HighestAndLowest {
    public static String highAndLow(String numbers) {
        OptionalInt max = Stream.of(numbers.split(" "))
                .mapToInt(Integer::parseInt)
                .max();

        OptionalInt min = Stream.of(numbers.split(" "))
                .mapToInt(Integer::parseInt)
                .min();

        return max.getAsInt() + " " + min.getAsInt();
    }

    static String highAndLowStatistics(String numbers) {
        var stats = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).summaryStatistics();
        return stats.getMax() + " " + stats.getMin();
    }

    public static String highAndLowList(String numbers) {
        // Code here or
        String[] num = numbers.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : num) {
            list.add(Integer.parseInt(s));
        }
        Collections.sort(list);

        return list.get(list.size() - 1) + " " + list.get(0);
    }
}
