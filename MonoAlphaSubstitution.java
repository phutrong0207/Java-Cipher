/**
 * Implements a simple monoalphabetic substitution cipher.
 *
 * <p>The translation table is expected to be a string where even indices are
 * plaintext characters and the following odd indices are the corresponding
 * ciphertext characters.</p>
 * 
 */
public class MonoAlphaSubstitution extends Substitution{

    private String translationTable;

    /**
     * Creates an empty substitution cipher (no translation table).
     */
    public MonoAlphaSubstitution() {
        super();
        translationTable = "";
    }

    /**
     * Creates a substitution cipher with the given translation table.
     *
     * @param translation a string containing alternating plaintext/ciphertext pairs
     */
    public MonoAlphaSubstitution(String translation) {
        super();
        translationTable = translation; 
    }

    /**
     * Finds the index of the plaintext character in the translation table.
     *
     * @param c the plaintext character to locate
     * @return the index of the plaintext character, or -1 if not found
     */
    private int findEncryptIndex(char c) {
        for (int i = 0; i + 1 < translationTable.length(); i += 2) {
            if (translationTable.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Encrypts a single character using the translation table.
     *
     * @param c the plaintext character
     * @return the substituted ciphertext character, or the input if no mapping exists
     */
    public char encrypt(char c) {
        int newCharIndex = findEncryptIndex(c);
        if (newCharIndex < 0) return c;
        return translationTable.charAt(newCharIndex + 1);
    }

    /**
     * Finds the index of the ciphertext character in the translation table.
     *
     * @param c the ciphertext character to locate
     * @return the index of the ciphertext character, or -1 if not found
     */
    private int findDecryptIndex(char c) {
        for (int i = 1; i < translationTable.length(); i += 2) {
            if (translationTable.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Decrypts a single character using the translation table.
     *
     * @param c the ciphertext character
     * @return the substituted plaintext character, or the input if no mapping exists
     */
    public char decrypt(char c) {
        int newCharIndex = findDecryptIndex(c);
        if (newCharIndex < 0) return c;
        return translationTable.charAt(newCharIndex - 1);
    }

    /**
     * Command line entry point.
     *
     * @param args expects: [encrypt|decrypt] <translationTable> "cipher text"
     */
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Too few parameters!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        }
        else if (args.length > 3) {
            System.out.println("Too many parameters!"); 
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        }
        else {
            String command = args[0];
            String translation = args[1];
            String cipherText = args[2];
            MonoAlphaSubstitution cipher = new MonoAlphaSubstitution(translation);
            if (!command.equals("encrypt") && !command.equals("decrypt")) {
                System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
                System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
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
