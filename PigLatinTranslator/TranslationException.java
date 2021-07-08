public class TranslationException {

   public static boolean beginsWithVowel (String word) {
     return isVowel(word.charAt(0));
   }

   public static int beginsWithConsonant (String word) {
        int counter = 0;
        while(counter < word.length()) {
            if(!isVowel(word.charAt(counter))) ++counter;
            else break;
        }
        return counter;
   }

   public static boolean isVowel(char c) {
       String vowels = "aeiou";
       return vowels.indexOf(c) > -1;
   }

}
