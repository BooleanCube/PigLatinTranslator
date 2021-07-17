import java.io.*;
import java.util.*;

public class PigLatinTranslator {

   public static void main(String[] args) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      String untranslatedText = bf.readLine();
      System.out.println(translateText(untranslatedText));
   }

   public static String translateText(String sentence) {
      String result = "";
      StringTokenizer st = new StringTokenizer(sentence);
      while(st.hasMoreTokens()) {
         String word = st.nextToken();
         boolean containsUpperCase = TranslationException.containsUpperCase(word);
         word = word.toLowerCase();
         word = translateWord(word);
         if(containsUpperCase) result += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
         else result += word + " ";
      }
      return result.trim();
   }

   private static String translateWord(String word) {
      int punctuationIndex = 0;
      String punctuation = "";
      if(TranslationException.checkPunctuation(word)) {
         ++punctuationIndex;
         punctuation = word.substring(word.length()-1);
      }
      if(TranslationException.beginsWithVowel(word) || TranslationException.checkHVowel(word)) {
         if(word.endsWith("y")) return word.substring(0,word.length()-punctuationIndex) + "way" + punctuation;
         return word.substring(0,word.length()-punctuationIndex) + "yay" + punctuation;
      }
      else {
         int consonantBegin = TranslationException.beginsWithConsonant(word);
         if(consonantBegin > 1) return word.substring(consonantBegin, word.length()-punctuationIndex) + word.substring(0,consonantBegin) + "ay" + punctuation;
         else return word.substring(1, word.length()-punctuationIndex) + word.charAt(0) + "ay" + punctuation;
      }
   }

}
