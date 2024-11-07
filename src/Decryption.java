public class Decryption {

    static String decryption(String decryptTextBefore, int decryptKey){
        char[] decryptCharBefore = decryptTextBefore.toCharArray();
        char[] decryptCharAfter = new char[decryptCharBefore.length];
        boolean isPresence = false;
        for (int i = 0; i < decryptCharBefore.length; i++) {
            for (int k = 0; k < CharacterData.ALPHABET_FULL_SIZE; k++) {
                if (decryptCharBefore[i] == CharacterData.ALPHABET_FULL[k]) {
                    isPresence = true;
                }
                if (isPresence){
                    if ((k-decryptKey) > 0) {
                        decryptCharAfter[i] = CharacterData.ALPHABET_FULL[(k - decryptKey)% CharacterData.ALPHABET_FULL_SIZE];
                    } else {
                        decryptCharAfter[i] = CharacterData.ALPHABET_FULL[(CharacterData.ALPHABET_FULL_SIZE + (k - decryptKey))% CharacterData.ALPHABET_FULL_SIZE];
                    }
                    isPresence = false;
                }
            }
        }
        return new String(decryptCharAfter);
    }
}
