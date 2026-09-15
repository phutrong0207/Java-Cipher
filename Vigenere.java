/**
 * Implements a Vigenère cipher by applying a sequence of Caesar shifts.
 *
 * <p>The key is used to determine a shift for each character in the input.
 * Non-alphabetic characters are passed through unchanged.</p>
 */
public class Vigenere extends Substitution{
    private String alphabetChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String secretKey;
    int currPosition = 0;

    /**
     * Creates a Vigenère cipher with a default key of all 'A'.
     */
    public Vigenere() {
        super();
        secretKey = "AAAAAAAAAAAAAAA";
    }

    /**
     * Creates a Vigenère cipher with the given key.
     *
     * @param key the secret key used to generate shifts
     */
    public Vigenere(String key) {
        super();
        secretKey = key;
    }

    /**
     * Encrypts a single character using the Vigenère key.
     *
     * @param toShift the character to encrypt
     * @return the encrypted character (or the input if it is not a letter)
     */
    public char encrypt(char toShift) {
        if (alphabetChars.indexOf(toShift) < 0){
            currPosition = (currPosition + 1) % secretKey.length();
            return toShift;
        }
        else {
            Caesar caeCipher = new Caesar(secretKey.charAt(currPosition) - 'A' + 21);//Caesar shift is plus by 12225 so need to add 21
            char newChar = caeCipher.encrypt(toShift);
            currPosition = (currPosition + 1) % secretKey.length();
            return newChar;
        }
    }

    /**
     * Decrypts a single character using the Vigenère key.
     *
     * @param toShift the character to decrypt
     * @return the decrypted character (or the input if it is not a letter)
     */
    public char decrypt(char toShift) {
        if (alphabetChars.indexOf(toShift) < 0){
            currPosition = (currPosition + 1) % secretKey.length();
            return toShift;
        }
        else {
            Caesar caeCipher = new Caesar(secretKey.charAt(currPosition) - 'A' + 21);//Caesar shift is plus by 12225 so need to add 21
            char newChar = caeCipher.decrypt(toShift);
            currPosition = (currPosition + 1) % secretKey.length();
            return newChar;
        }
    }


    /**
     * Command line entry point for the Vigenère cipher.
     *
     * @param args expects: [encrypt|decrypt] <key> "cipher text"
     */
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
        }
        else if (args.length > 3) {
            System.out.println("Too many parameters!"); 
            System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
        }
        else {
            String command = args[0];
            String shiftKey = args[1];
            String cipherText = args[2];
            Vigenere cipher = new Vigenere(shiftKey);
            if (!command.equals("encrypt") && !command.equals("decrypt")) {
                System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
                System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
            }
            else if (command.equals("encrypt")){
                System.out.println(cipher.encrypt(cipherText));
            }
            else {
                System.out.println(cipher.decrypt(cipherText));
            }
        }
    }
}
