import java.io.*;
import java.util.*;

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
      while (st.hasMoreTokens()) {
         result += translateWord(st.nextToken()) + " ";
      }
      return result.trim();
   }

   private static String translateWord (String word) {
      if (beginsWithVowel(word)) return word + "yay";
      else {
         if (beginsWithConsonant(word)) return word.substring(2) + word.substring(0,2) + "ay";
         else return word.substring(1) + word.charAt(0) + "ay";
      }
   }

   private static boolean beginsWithVowel (String word) {
      String firstLetter = word.substring(0, 1);
      return firstLetter.equalsIgnoreCase("a") ||
          firstLetter.equalsIgnoreCase("e") ||
          firstLetter.equalsIgnoreCase("i") ||
          firstLetter.equalsIgnoreCase("o") ||
          firstLetter.equalsIgnoreCase("u");
   }

   private static boolean beginsWithConsonant (String word) {
      return word.startsWith ("bl") ||
          word.startsWith ("sc") ||
          word.startsWith ("br") ||
          word.startsWith ("sh") ||
          word.startsWith ("ch") ||
          word.startsWith ("sk") ||
          word.startsWith ("cl") ||
          word.startsWith ("sl") ||
          word.startsWith ("cr") ||
          word.startsWith ("sn") ||
          word.startsWith ("dr") ||
          word.startsWith ("sm") ||
          word.startsWith ("dw") ||
          word.startsWith ("sp") ||
          word.startsWith ("fl") ||
          word.startsWith ("sq") ||
          word.startsWith ("fr") ||
          word.startsWith ("st") ||
          word.startsWith ("gl") ||
          word.startsWith ("sw") ||
          word.startsWith ("gr") ||
          word.startsWith ("th") ||
          word.startsWith ("kl") ||
          word.startsWith ("tr") ||
          word.startsWith ("ph") ||
          word.startsWith ("tw") ||
          word.startsWith ("pl") ||
          word.startsWith ("wh") ||
          word.startsWith ("pr") ||
          word.startsWith ("wr");
   }
}
