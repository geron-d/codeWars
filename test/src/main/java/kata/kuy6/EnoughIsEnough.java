package kata.kuy6;

//Given a list and a number, create a new list that contains each number of list at most N times, without reordering.
//        For example if the input number is 2, and the input list is [1,2,3,1,2,1,2,3],
//        you take [1,2,3,1,2], drop the next [1,2] since this would lead to 1 and 2 being in the result 3 times, and then take 3, which leads to [1,2,3,1,2,3].
//        With list [20,37,20,21] and number 1, the result would be [20,37,21].

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class EnoughIsEnough {
    public static int[] deleteNth(int[] elements, int max) {

        if (max < 1) return new int[0];

        final HashMap<Integer, Integer> map = new HashMap<>();
        final List<Integer> list = new ArrayList<>();

        for (final Integer i : elements) {
            final Integer v = map.put(i, map.getOrDefault(i, 0) + 1);
            if (v == null || v < max) list.add(i);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[] deleteNthStreamMerge(int[] elements, int maxOccurrences) {
        Map<Integer, Integer> occurrence = new HashMap<>();
        return IntStream.of(elements)
                .filter(motif -> occurrence.merge(motif, 1, Integer::sum) <= maxOccurrences)
                .toArray();
    }
}
