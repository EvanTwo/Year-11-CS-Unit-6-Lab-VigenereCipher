public class VigenereCipher {

    private String key = "";
    private String alphabet = "";

    public VigenereCipher(String k){
        key = k.toLowerCase();
        alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    public String getAlphabet() {
        return alphabet;
    }
    public String getKey(){
        return key;
    }



    public String encode(String message){
        int x = key.length();
        StringBuilder fullKey = new StringBuilder();
        StringBuilder codedMessage = new StringBuilder();

        // generate the full key for the message
        for (int i = 0; fullKey.length() < message.length(); i++){
            if (i == x){
                i = 0;
            }
            fullKey.append(key.charAt(i));
        }

        char messageCharacter;
        char keyCharacter;
        int sum = 0;
        boolean characterCheck = false; // boolean for storing if character is in alphabet


        for (int i = 0; fullKey.length() > i; i++){
            sum = 0;
            characterCheck = false;
            messageCharacter = message.charAt(i);
            keyCharacter = fullKey.charAt(i);

            // check if current character is in alphabet
            for (int j = 0; j < alphabet.length(); j++) {
                if (messageCharacter == alphabet.charAt(j)) {
                    characterCheck = true;
                    break;
                }
            }
            // as long as character is in alphabet, add the key to message character to result in the cipher character
            if (characterCheck) {
                sum = alphabet.indexOf(messageCharacter) + alphabet.indexOf(keyCharacter);
                if (sum > 52) {
                    sum = sum - 26;
                }
                codedMessage.append(alphabet.charAt(sum));
            }
            else // add the unlisted character
                codedMessage.append(messageCharacter);
        }
        return (codedMessage.toString().toLowerCase()); // puts the answer in all lowercase
    }

    public String decode(String codedMessage){
        int x = key.length();
        StringBuilder fullKey = new StringBuilder();
        StringBuilder decodedMessage = new StringBuilder();

        // generate the full key for the message
        for (int i = 0; fullKey.length() < codedMessage.length(); i++){
            if (i == x){
                i = 0;
            }
            fullKey.append(key.charAt(i));
        }

        char codedMessageCharacter;
        char keyCharacter;
        int difference = 0;
        boolean characterCheck = false; // boolean for storing if character is in alphabet

        for (int i = 0; fullKey.length() > i; i++){
            difference = 0;
            characterCheck = false;
            codedMessageCharacter = codedMessage.charAt(i);
            keyCharacter = fullKey.charAt(i);

            // check if current character is in alphabet
            for (int j = 0; j < alphabet.length(); j++) {
                if (codedMessageCharacter == alphabet.charAt(j)) {
                    characterCheck = true;
                    break;
                }
            }
            // as long as character is in alphabet, add the key to message character to result in the cipher character
            if (characterCheck) {
                difference = alphabet.indexOf(codedMessageCharacter) - alphabet.indexOf(keyCharacter);
                if (difference < 0 ) {
                    difference = difference + 26;
                }
                decodedMessage.append(alphabet.charAt(difference));
            }
            else // add the unlisted character
                decodedMessage.append(codedMessageCharacter);
        }
        return (decodedMessage.toString().toLowerCase()); // puts the answer in all lowercase
    }

}
