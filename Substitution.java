/**
 * Base class for character-by-character substitution ciphers.
 *
 * <p>Subclasses implement encrypt(char)} and decrypt(char)}
 * to define the per-character transformation.</p>
 * 
 */
public abstract class Substitution implements Cipher{
    
    /**
     * Encrypts a single character.
     *
     * @param c the character to encrypt
     * @return the encrypted character
     */
    public abstract char encrypt(char c);

    /**
     * Decrypts a single character.
     *
     * @param c the character to decrypt
     * @return the decrypted character
     */
    public abstract char decrypt(char c);

    /**
     * Encrypts an entire string by applying {@link #encrypt(char)} to each character.
     *
     * @param plainText the plaintext to encrypt
     * @return the resulting ciphertext
     */
    public String encrypt(String plainText) {
        String res = "";
        for (char c : plainText.toCharArray()) {
            res += encrypt(c);
        }
        return res;
    }

    /**
     * Decrypts an entire string by applying {@link #decrypt(char)} to each character.
     *
     * @param cipherText the ciphertext to decrypt
     * @return the resulting plaintext
     */
    public String decrypt(String cipherText) {
        String res = "";
        for (char c : cipherText.toCharArray()) {
            res += decrypt(c);
        }
        return res;
    }

}
