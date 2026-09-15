# Java-Cipher
A cipher allowing the user to encrypt plain text into an secret message or decrypt a secret message back to plain text. There are several methods of encryption and decryption. This cipher adopts the object-oriented programming practice.

The cipher follows this hierachy:
Interface Cipher.java <- Abstract class Substitution.java extends Cipher.java <- Vigenere.java and MonoAlphaSubstitution.java extends Cipher.java <- Caesar.java extends MonoAlphaSubstitution.java

Substitution ciphers de/encrypt one letter (or other small unit) at a time. What they have in common is that they implement the Cipher interface (know how to translate strings) based on en/decrypt methods that translate characters.

# MonoAlphaSubstitution

Monoalphabetical substitution ciphers are ciphers that de/encrypt characters according to one fixed translation table. Monoalphabetical.java is a concrete subclass of Substitution.java that overloads two abstract methods encrypt(char c) and decrypt(char c). Monoalphabetical.java has two public constructors: 

1. A default constructor (one that takes no arguments), which results in the trivial identity substitution (‘a’ to ‘a’, ‘b’ to ‘b’, …) where every letter is mapped to itself.

2. A constructor that takes one argument of type String, and interprets it as a mapping where every character at an odd position is the encoding of the one directly before it. The first character (at position 0) will be encoded as the second (at position 1), the third as the fourth and so on.

Example outputs: 
<img width="932" height="70" alt="image" src="https://github.com/user-attachments/assets/860ccf58-dfdb-4ff2-a467-6191b1f79262" />


# Caesar

The Caesar cipher is a special case of a monoalphabetical substitution, where each character maps to the one k position later in the alphabet, for a fixed shift k which is the secret key.

Caesar.java is a subclass of the class Monoalphabetical.java. It has two constructors: a default constructor that causes both methods to work as the identity function and another constructor that takes one argument of type int that determines the shift according to which all en/decrypt methods operate: the actual shift instances should use is the given argument plus **5 (all modulo 26)**.

Objects of type Caesar should be ciphers that translate both lower case and capital letters according to the shift specified at instantiation. All other characters should be translated to itself.

Example outputs: <img width="659" height="71" alt="image" src="https://github.com/user-attachments/assets/0679277d-7cea-487a-95d5-60d293372a47" />


# Vigenere

The Vigenère cipher is a method of encrypting alphabetic text where each letter of the plaintext is encoded with a different Caesar cipher, whose increment is determined by the corresponding letter of another text, the key. In a Caesar cipher, each letter of the alphabet is shifted along some number of places. In a Caesar cipher of shift 3, a would become D, b would become E, y would become B and so on. The Vigenère cipher has several Caesar ciphers in sequence with different shift values.

To illustrate, imagine using the key "ANAMAZINGCIPHER". The encryption process shifts the first letter of your original message by 0 positions, since 'A' is exactly zero steps away from 'A' in the alphabet. The subsequent letter undergoes a Caesar shift of 13, which is the alphabetical distance between 'N' and 'A'. You continue applying this pattern for each letter. Should your message be longer than the keyword itself, the key simply wraps around to the beginning, meaning the 16th character will once again be shifted by 0 (back to the first 'A'). By applying this specific key to the text "This message is encrypted", the resulting encrypted output is "Tuie lmfycot mj rnorxxgkf". As a point of interest, notice how the letter 's' appears four times in the original message, yet it translates to a completely different character ('e', 'f', 'y', and 'j') every single time!

The class Vigenere.java is a concrete subclass of Substitution.java (because this is still a character-by-character encoding scheme). The Vigenere class has two public constructors: 

1. a default constructor (that takes no arguments), which creates objects whose en/decrypt methods behave as the identity
2. one more constructor that takes one argument of type String, the key word to be used for en/decryption. The key word consists only of capital letters without spaces or punctuation.

Example outputs: <img width="760" height="66" alt="image" src="https://github.com/user-attachments/assets/9f0c5a3e-90f8-4862-b5a1-ccb5680e406f" />





  
