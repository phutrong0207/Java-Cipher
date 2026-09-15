/**
 * An interface that declares methods related to encoding/decoding.
 *
 */
public interface Cipher {

    public String encrypt(String plainText);


    public String decrypt(String cipherText);
}