import java.io.*;
import java.util.*;


//fix bugs with static calling.
public class PigLatinTranslator {

   public static void main(String[] args) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      String untranslatedText = bf.readLine();
      System.out.println(translateText(untranslatedText));
   }

   public static String translateText (String sentence) {
      String result = "";
      sentence = sentence.toLowerCase();
      StringTokenizer st = new StringTokenizer(sentence);
      while(st.hasMoreTokens()) {
         result += translateWord(st.nextToken()) + " ";
      }
      return result.trim();
   }

   private static String translateWord (String word) {
      if(TranslationException.beginsWithVowel(word)) return word + "yay";
      else {
         int consonantBegin = TranslationException.beginsWithConsonant(word);
         if(consonantBegin > 1) return word.substring(consonantBegin) + word.substring(0,consonantBegin) + "ay";
         else return word.substring(1) + word.charAt(0) + "ay";
      }
   }

}
