package kata.kuy6;

//Description:
//        Encrypt this!
//
//        You want to create secret messages which can be deciphered by the Decipher this! kata. Here are the
//        conditions:
//
//        Your message is a string containing space separated words.
//        You need to encrypt each word in the message using the following rules:
//        The first letter must be converted to its ASCII code.
//        The second letter must be switched with the last letter
//        Keepin' it simple: There are no special characters in the input.
//        Examples:
//        Kata.encryptThis("Hello") => "72olle"
//        Kata.encryptThis("good") => "103doo"
//        Kata.encryptThis("hello world") => "104olle 119drlo"

import java.util.Arrays;
import java.util.stream.Collectors;

public class EncryptThis {
    public static String encryptThis(String text) {
        return Arrays.stream(text.split(" "))
                .map(w -> w.length() > 2 ? (int) w.charAt(0) + w.substring(w.length() - 1) + w.substring(2, w.length() - 1) + w.substring(1, 2) :
                        w.length() > 1 ? (int) w.charAt(0) + w.substring(1) :
                                w.length() == 1 ? (int) w.charAt(0) + "" : "")
                .collect(Collectors.joining(" "));
    }
}
