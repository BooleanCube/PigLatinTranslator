public class TranslationException {

   public static boolean beginsWithVowel(String word) {
     return isVowel(word.charAt(0));
   }

   public static int beginsWithConsonant(String word) {
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

   public static boolean isVowel(char c) {
       String vowels = "aeiou";
       return vowels.indexOf(c)>-1;
   }

   public static boolean checkPunctuation(String word) {
       return !Character.isLetterOrDigit(word.charAt(word.length()-1));
   }

   public static boolean checkHVowel(String word) {
       return Character.toLowerCase(word.charAt(0)) == 'h' && isVowel(word.charAt(1));
   }

   public static boolean containsUpperCase(String word) {
       return Character.isUpperCase(word.charAt(0));
   }

}
