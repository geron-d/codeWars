package kata.kuy4;

//In this kata you have to create all permutations of a non empty input string and remove duplicates, if present.
// This means, you have to shuffle all letters from the input in all possible orders.
//
//        Examples:
//
//        * With input 'a'
//        * Your function should return: ['a']
//        * With input 'ab'
//        * Your function should return ['ab', 'ba']
//        * With input 'aabb'
//        * Your function should return ['aabb', 'abab', 'abba', 'baab', 'baba', 'bbaa']
//        The order of the permutations doesn't matter.

import java.util.*;
import java.util.stream.Collectors;

public class Permutations {

    public static List<String> singlePermutations(String s) {
        if (s.length() < 2) {
            return Arrays.stream(s.split("")).collect(Collectors.toList());
        }

        Set<String> setPermutations = new TreeSet<>();

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            String residue = s.substring(0, i) + s.substring(i + 1);
            for (int j = 1; j < s.length(); j++) {
                setPermutations.add(letter + residue);
                residue = shiftLeft(residue);
            }
            List<String> listResidue = singlePermutations(residue);
            for (String value : listResidue) {
                setPermutations.add(letter + value);
            }
        }

        return new ArrayList<>(setPermutations);
    }

    public static String shiftLeft(String s) {
        return s.substring(1) + s.charAt(0);
    }
}