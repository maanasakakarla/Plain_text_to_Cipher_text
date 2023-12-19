import java.util.Scanner;

public class VigenereCipher {
    public static String key = new String();
    public String extendedKey;
    public String plainText, cipherText;
    public String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int row, flag = 0, decrypt = 0;

    public String keyExtension(String plainText, String keyText) {
        int i, j = 0;
        String newKey = "";
        for (i = 0; i < plainText.length(); i++) {
            newKey += keyText.charAt(j);
            j++;
            if (j == keyText.length())
                j = 0;
        }
        return newKey;
    }

    public int valueOfChar(char x) {
        int i, pos = 0;
        for (i = 0; i < 26; i++) {
            if (x == ALPHABET.charAt(i)) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public char charOfValue(int y) {
        return ALPHABET.charAt(y);
    }

    public String encrypt(String text) {
        int i, p = 0, k = 0, tmp1 = 0;
        char tmp;
        String result = "";
        extendedKey = keyExtension(text, key);

        System.out.println("VIGENERE ENCRYPTION");
        System.out.println("PLAIN TEXT : " + text);
        System.out.println("VIGENERE KEY : " + extendedKey);

        for (i = 0; i < text.length(); i++) {
            p = valueOfChar(text.charAt(i));
            k = valueOfChar(extendedKey.charAt(i));
            tmp1 = (p + k) % 26;
            tmp = charOfValue(tmp1);
            result += tmp;
        }
        return result;
    }

    public String decrypt(String text) {
        int i, c = 0, k = 0, tmp1 = 0;
        char ch;
        String result = "";

        System.out.println("VIGENERE DECRYPTION");
        System.out.println("CIPHER TEXT : " + text);
        System.out.println("VIGENERE KEY : " + extendedKey);

        for (i = 0; i < text.length(); i++) {
            c = valueOfChar(text.charAt(i));
            k = valueOfChar(extendedKey.charAt(i));
            tmp1 = (c - k + 26) % 26;
            ch = charOfValue(tmp1);
            result += ch;
        }
        return result;
    }

    public static void main(String[] args) {
        VigenereCipher vc = new VigenereCipher();
        Scanner sc = new Scanner(System.in);

        System.out.println("ENTER KEY");
        key = sc.next();

        String text = new String();
        System.out.println("Enter PLAIN TEXT");
        text = sc.next();

        String ciphertext = vc.encrypt(text);
        System.out.println("\nCIPHER TEXT :" + ciphertext);

        String plaintext = vc.decrypt(ciphertext);
        System.out.println("\nPLAIN TEXT :" + plaintext);

        sc.close();
    }
}
