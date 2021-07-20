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
         if(word.contains("-")) {
            String[] words = word.split("-");
            for(int i=0; i<words.length; i++) {
               words[i] = translateWord(words[i]);
            }
            boolean containsUpper = false;
            for(int i=0; i<words.length-1; i++) {
               containsUpper = TranslationException.containsUpperCase(words[i]);
               if(containsUpper) result += Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1) + "-";
               else result += words[i] + "-";
            }
            containsUpper = TranslationException.containsUpperCase(words[words.length-1]);
            if(containsUpper) result += Character.toUpperCase(words[words.length-1].charAt(0)) + words[words.length-1].substring(1) + "-";
            else result += words[words.length-1] + " ";
         } else {
            word = translateWord(word);
            if(containsUpperCase) result += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
            else result += word + " ";
         }
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
