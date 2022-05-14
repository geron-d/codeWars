package kata.kuy6;

//Implement a pseudo-encryption algorithm which given a string S and an integer N concatenates all the odd-indexed
// characters of S with all the even-indexed characters of S, this process should be repeated N times.
//
//        Examples:
//
//        encrypt("012345", 1)  =>  "135024"
//        encrypt("012345", 2)  =>  "135024"  ->  "304152"
//        encrypt("012345", 3)  =>  "135024"  ->  "304152"  ->  "012345"
//
//        encrypt("01234", 1)  =>  "13024"
//        encrypt("01234", 2)  =>  "13024"  ->  "32104"
//        encrypt("01234", 3)  =>  "13024"  ->  "32104"  ->  "20314"
//        Together with the encryption function, you should also implement a decryption function which reverses the process.
//
//        If the string S is an empty value or the integer N is not positive, return the first argument without changes.

public class SimpleEncryption1_AlternatingSplit {
    public static String encrypt(final String text, int n) {
        if (n <= 0 || text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder firstPart = new StringBuilder();
        StringBuilder secondPart = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char aChar = text.charAt(i);
            if (i % 2 == 1) {
                firstPart.append(aChar);
            } else {
                secondPart.append(aChar);
            }
        }

        return encrypt(firstPart.append(secondPart).toString(), --n);
    }

    public static String decrypt(final String encryptedText, int n) {
        if (n <= 0 || encryptedText == null || encryptedText.isEmpty()) {
            return encryptedText;
        }

        StringBuilder text = new StringBuilder();
        final int half = encryptedText.length() / 2;
        for (int i = 0; i < half; i++) {
            text.append(encryptedText.charAt(half + i)).append(encryptedText.charAt(i));
        }
        if (encryptedText.length() % 2 == 1) {
            text.append(encryptedText.charAt(encryptedText.length() - 1));
        }

        return decrypt(text.toString(), --n);
    }
}
