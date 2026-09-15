/**
 * Implements a Caesar cipher over ASCII letters.
 *
 * <p>This implementation shifts letters by a configurable amount and wraps
 * within the alphabet. Non-letter characters are preserved unchanged.</p>
 * 
 */
public class Caesar extends MonoAlphaSubstitution{
    private String alphabetChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int shift;

    /**
     * Creates a Caesar cipher that shifts letters by the default amount (21).
     */
    public Caesar() {
        super();
        shift = 0;
    }

    /**
     * Creates a Caesar cipher that shifts letters by the given amount.
     *
     * @param shiftBy the number of alphabet positions to shift; can be negative
     */
    public Caesar(int shiftBy) {
        super();
        shift = (shiftBy + 5)%26;
    }
    
    /**
     * Applies the Caesar shift to a single character.
     *
     * @param toShift the character to encrypt
     * @return the shifted character, or the input unchanged if not a letter
     */
    public char encrypt(char toShift) {
        if (alphabetChars.indexOf(toShift) < 0){
            return toShift;
        }
        else {
            int base = Character.isLowerCase(toShift) ? 'a' : 'A';
            int shiftAmount = (toShift - base + shift)%26;
            if (shiftAmount < 0) shiftAmount += 26;
            char res = (char) (base + shiftAmount);
            return res;
        }
    }

    /**
     * Reverses the Caesar shift for a single character.
     *
     * @param toShift the character to decrypt
     * @return the unshifted character, or the input unchanged if not a letter
     */
    public char decrypt(char toShift) {
        if (alphabetChars.indexOf(toShift) < 0){
            return toShift;
        }
        else {
            int base = Character.isLowerCase(toShift) ? 'a' : 'A';
            int shiftAmount = (toShift - base - shift)%26;
            if (shiftAmount < 0) shiftAmount += 26;
            char res = (char) (base + shiftAmount);
            return res;
        }
    }


    /**
     * Command line entry point.
     *
     * @param args expects: [encrypt|decrypt] <shift> "cipher text"
     */
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
        }
        else if (args.length > 3) {
            System.out.println("Too many parameters!"); 
            System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
        }
        else {
            String command = args[0];
            int shiftNum = Integer.parseInt(args[1]);
            String cipherText = args[2];
            Caesar cipher = new Caesar(shiftNum);
            if (!command.equals("encrypt") && !command.equals("decrypt")) {
                System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
                System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
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
