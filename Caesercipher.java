import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CaeserCipher {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String plaintext, int caeserKey) {
        StringBuilder ciphertext = new StringBuilder();
        
        for (int i = 0; i < plaintext.length(); i++) {
            int plainNumeric = ALPHABET.indexOf(plaintext.charAt(i));
            int cipherNumeric = (plainNumeric + caeserKey) % 26;
            char cipherChar = ALPHABET.charAt(cipherNumeric);
            ciphertext.append(cipherChar);
        }
        
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int caeserKey) {
        StringBuilder plaintext = new StringBuilder();
        
        for (int i = 0; i < ciphertext.length(); i++) {
            int cipherNumeric = ALPHABET.indexOf(ciphertext.charAt(i));
            int plainNumeric = (cipherNumeric - caeserKey) % 26;
            
            if (plainNumeric < 0) {
                plainNumeric = ALPHABET.length() + plainNumeric;
            }
            
            char plainChar = ALPHABET.charAt(plainNumeric);
            plaintext.append(plainChar);
        }
        
        return plaintext.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the PLAIN TEXT for Encryption:");
        String plaintext = br.readLine();

        System.out.println("Enter the CAESAR KEY between 0 and 25:");
        int caeserKey = Integer.parseInt(br.readLine());

        System.out.println("ENCRYPTION");
        String ciphertext = encrypt(plaintext, caeserKey);
        System.out.println("CIPHER TEXT: " + ciphertext);

        System.out.println("DECRYPTION");
        plaintext = decrypt(ciphertext, caeserKey);
        System.out.println("PLAIN TEXT: " + plaintext);
    }
}
