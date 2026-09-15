# Java-Cipher
A cipher allowing the user to encrypt plain text into an secret message or decrypt a secret message back to plain text. There are several methods of encryption and decryption. This cipher adopts the object-oriented programming practice.

The cipher follows this hierachy:

<img width="1006" height="1152" alt="image" src="https://github.com/user-attachments/assets/fd4aada7-7897-4f04-84b3-4d0525d50420" />

Substitution ciphers de/encrypt one letter (or other small unit) at a time. What they have in common is that they implement the Cipher interface (know how to translate strings) based on en/decrypt methods that translate characters.

# MonoAlphaSubstitution

Monoalphabetical substitution ciphers are ciphers that de/encrypt characters according to one fixed translation table. Monoalphabetical.java is a concrete subclass of Substitution.java that overloads two abstract methods encrypt(char c) and decrypt(char c). Monoalphabetical.java has two public constructors: 

1. A default constructor (one that takes no arguments), which results in the trivial identity substitution (‘a’ \to ‘a’, ‘b’ \to ‘b’, …) where every letter is mapped to itself.

2. A constructor that takes one argument of type String, and interprets it as a mapping where every character at an odd position is the encoding of the one directly before it. The first character (at position 0) will be encoded as the second (at position 1), the third as the fourth and so on. This way the string "ABBCCD", should be interpreted as ‘A’ to ‘B’, ‘B’ to ‘C’, ‘C’ to ‘D’ and every other letter to itself. Another example is the key string "akbjcidhegffgehdicjbka", which In particular maps ‘i’ to ‘c’, ‘f’ to ‘f’, ‘e’ to ‘g’, and every other letter to itself and so would encode the string "Life is" as "Lcfg cs". To further clarify:

   If this constructor is given the empty string, it should result in all characters being mapped to themselves.
   
   You can assume that we will only test strings of even length, and that no two even positions have the same character (every letter is encoded uniquely).
   
   Notice that there is no restriction to letters from the English alphabet: a mapping given as “!..!” should result in a substitution that swaps fullstops and exclamation marks and   does not change anything else.
   
   Note that the mapping does not have to be uniquely reversible: in the first example above both ‘C’ and ‘D’ map to ‘D’, and therefore the encrypted character ‘D’ could originate from both ‘C’ and ‘D’. When testing your code on such mappings we will only consider the encrypt, not the decrypt method.

Example outputs: 
<img width="752" height="312" alt="image" src="https://github.com/user-attachments/assets/ab68b98f-8da1-4934-97b5-2d865f92c408" />

# Caesar

The Caesar cipher is a special case of a monoalphabetical substitution, where each character maps to the one k position later in the alphabet, for a fixed shift k which is the secret key.

Caesar.java is a subclass of the class Monoalphabetical.java. It has two constructors: a default constructor that causes both methods to work as the identity function and another constructor that takes one argument of type int that determines the shift according to which all en/decrypt methods operate: the actual shift instances should use is the given argument plus **12225 (all modulo 26)**.

Objects of type Caesar should be ciphers that translate both lower case and capital letters according to the shift specified at instantiation. All other characters should be translated to itself.

Example outputs: <img width="741" height="238" alt="image" src="https://github.com/user-attachments/assets/1ec2071a-c181-4058-ba96-678062a27332" />

# Vigenere

The Vigenère cipher is a 16th century encryption scheme first described by Giovan Battista Bellaso and later misattributed to French diplomat Blaise de Vigenère. It addresses the main weakness of earlier ciphers which are easily broken with a frequency analysis, as we have done in the first assignment.

The idea behind the Vigenère cipher is to disguise the plaintext letter frequencies by not encoding each letter according to the same translation table. Instead, it uses one translation table for each letter position in the plaintext. Such ciphers are called polyalphabetic substitutions because there is more than one mapping (alphabet) involved. This way, the most common letter ‘e’ for instance translates to different letters depending on where in the plaintext it occurs. In fact this cipher has resisted crypto-analytic attacks for well over two centuries, which earned it the nickname le chiffre indéchiffrable.

What makes this cipher particularly user-friendly is the way one specifies the secret key, i.e. the substitutions to use at each position. This is done by arranging several Caesar ciphers with different shifts based on some key word which is easy to remember for all communicating parties.

Suppose for example that the keyword is “COMPONETWOTWO”. Then the first character of the plaintext would be translated according to a Caesar cipher with shift 2, as 'C' - 'A' == 2, the first letter ‘C’ of the keyword is two letters after ‘A’ in the Roman alphabet. The second character will be translated using a Caesar cipher with shift 14 == 'O' - 'A' and so on. If the plaintext is longer than the key one continues at the start of the key word, so that the 14th position will again use the Caesar shift 2. If you encrypt the phrase “fun fun fun” with the key above, you should get “hiz thr big”. Notice that the letter ‘f’ maps to a different letter each time!

The class Vigenere.java is a concrete subclass of Substitution.java (because this is still a character-by-character encoding scheme). The Vigenere class should again have at least two public constructors: 

1. a default constructor (that takes no arguments), which creates objects whose en/decrypt methods behave as the identity. This class must include protected attribute called “caiphers”.
2. one more constructor that takes one argument of type String, the key word to be used for en/decryption. You may assume that the key word consists only of capital letters without spaces or punctuation.

Example outputs: <img width="433" height="367" alt="image" src="https://github.com/user-attachments/assets/23a74c35-c0c3-447e-9ebc-692176ec5c34" />




  
