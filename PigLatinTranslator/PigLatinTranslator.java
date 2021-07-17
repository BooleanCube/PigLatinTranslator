import java.io.*;
import java.util.*;


//fix bugs with static calling.
public class PigLatinTranslator {

   public static void main(String[] args) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      String untranslatedText = bf.readLine();
      System.out.println(translateText(untranslatedText));
   }

   public static String translateText(String sentence) {
      String result = "";
      sentence = sentence.toLowerCase();
      StringTokenizer st = new StringTokenizer(sentence);
      while(st.hasMoreTokens()) {
         result += translateWord(st.nextToken()) + " ";
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
      if(TranslationException.beginsWithVowel(word)) return word.substring(0,word.length()-punctuationIndex) + "yay" + punctuation;
      else {
         int consonantBegin = TranslationException.beginsWithConsonant(word);
         if(consonantBegin > 1) return word.substring(consonantBegin, word.length()-punctuationIndex) + word.substring(0,consonantBegin) + "ay" + punctuation;
         else return word.substring(1, word.length()-punctuationIndex) + word.charAt(0) + "ay" + punctuation;
      }
   }

}
