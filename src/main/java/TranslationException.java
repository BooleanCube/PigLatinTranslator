/**
 * Translation Exception class for making the translations as accurate as possible
 */
class TranslationException {

    /**
     * Checks if a word begins with a vowel
     * @param word {@link String} word
     * @return boolean indicating whether the word begins with a vowel or not
     */
   protected static boolean beginsWithVowel(String word) {
     return isVowel(word.charAt(0));
   }

    /**
     * Checks if a word begins with a consonant
     * @param word {@link String} word
     * @return integer indicating the amount of consonants it begins with.<br>(For example: "three" begins with 3 consonants)
     */
   protected static int beginsWithConsonant(String word) {
        int counter = 0;
        char last = '\u0000';
        while(counter < word.length()) {
            if(last == 'q' && word.charAt(counter) == 'u') {last=word.charAt(counter); ++counter;}
            else if(!isVowel(last) && word.charAt(counter) == 'y') break;
            else if(!isVowel(word.charAt(counter))) {last=word.charAt(counter); ++counter;}
            else break;
        }
        return counter;
   }

    /**
     * Checks if the character is a vowel
     * @param c character
     * @return boolean indicating whether the character in the parameter is a vowel or not
     */
   protected static boolean isVowel(char c) {
       String vowels = "aeiou";
       return vowels.indexOf(c)>-1;
   }

    /**
     * Checks if there is any punctuation at the end of a word
     * @param word {@link String} word
     * @return boolean indicating whether the word has punctuation at the end or not
     */
   protected static boolean checkPunctuation(String word) {
       return !Character.isLetterOrDigit(word.charAt(word.length()-1));
   }

    /**
     * Checks for the H-Vowel combo
     * @param word {@link String} word
     * @return boolean indicating whether or not the combo exists in the word
     */
   protected static boolean checkHVowel(String word) {
       return Character.toLowerCase(word.charAt(0)) == 'h' && isVowel(word.charAt(1));
   }

    /**
     * Checks whether the word contains an upper case character in the first character of the word
     * @param word {@link String} word
     * @return boolean indicating whether the first character is an upper case or not
     */
   protected static boolean containsUpperCase(String word) {
       return Character.isUpperCase(word.charAt(0));
   }

}
