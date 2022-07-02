import java.util.StringTokenizer;

/**
 * Very accurate english to pig latin translator
 */
public class PigLatinTranslator {

   /**
    * Translates english text into accurate pig latin text
    * @param sentence {@link String} body of text to be translated from english to pig latin
    * @return {@link String} body of text translated into pig latin from the given english statements
    */
   public static String translateText(String sentence) {
      StringBuilder result = new StringBuilder();
      StringTokenizer st = new StringTokenizer(sentence);
      while(st.hasMoreTokens()) {
         String word = st.nextToken();
         try {
            boolean next = true;
            for(char c : word.toCharArray()) {
               if(!Character.isDigit(c)) {next = false; break;}
            }
            if(next) {
               result.append(word).append(" "); continue;}
         } catch(Exception ignored){}
         boolean containsUpperCase = TranslationException.containsUpperCase(word);
         word = word.toLowerCase();
         if(word.contains("-")) {
            String[] words = word.split("-");
            for(int i=0; i<words.length; i++) {
               words[i] = translateWord(words[i]);
            }
            boolean containsUpper;
            for(int i=0; i<words.length-1; i++) {
               containsUpper = TranslationException.containsUpperCase(words[i]);
               if(containsUpper) result.append(Character.toUpperCase(words[i].charAt(0))).append(words[i].substring(1)).append("-");
               else result.append(words[i]).append("-");
            }
            containsUpper = TranslationException.containsUpperCase(words[words.length-1]);
            if(containsUpper) result.append(Character.toUpperCase(words[words.length - 1].charAt(0))).append(words[words.length - 1].substring(1)).append("-");
            else result.append(words[words.length - 1]).append(" ");
         } else {
            word = translateWord(word);
            if(containsUpperCase) result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
            else result.append(word).append(" ");
         }
      }
      return result.toString().trim();
   }

   /**
    * Translate a singular word from the english language to pig latin
    * @param word {@link String} of an english word to be translated into pig latin
    * @return {@link String} translation in pig latin of english word
    */
   private static String translateWord(String word) {
      if(word.split(" ").length > 1) return null;
      int punctuationIndex = 0;
      String punctuation = "";
      if(TranslationException.checkPunctuation(word)) {
         ++punctuationIndex;
         punctuation = word.substring(word.length()-1);
      }
      if(TranslationException.beginsWithVowel(word) || TranslationException.checkHVowel(word)) {
         String ret = word.substring(0, word.length() - punctuationIndex);
         if(word.endsWith("y")) return ret + "way" + punctuation;
         return ret + "yay" + punctuation;
      }
      else {
         int consonantBegin = TranslationException.beginsWithConsonant(word);
         if(consonantBegin > 1) return word.substring(consonantBegin, word.length()-punctuationIndex) + word.substring(0,consonantBegin) + "ay" + punctuation;
         else return word.substring(1, word.length()-punctuationIndex) + word.charAt(0) + "ay" + punctuation;
      }
   }

}
