public class TranslationException {

  public static boolean beginsWithVowel (String word) {
     String firstLetter = word.substring(0, 1);
     return firstLetter.equalsIgnoreCase("a") ||
         firstLetter.equalsIgnoreCase("e") ||
         firstLetter.equalsIgnoreCase("i") ||
         firstLetter.equalsIgnoreCase("o") ||
         firstLetter.equalsIgnoreCase("u");
  }

  public static boolean beginsWithConsonant (String word) {
     return word.startsWith("bl") ||
         word.startsWith("sc") ||
         word.startsWith("br") ||
         word.startsWith("sh") ||
         word.startsWith("ch") ||
         word.startsWith("sk") ||
         word.startsWith("cl") ||
         word.startsWith("sl") ||
         word.startsWith("cr") ||
         word.startsWith("sn") ||
         word.startsWith("dr") ||
         word.startsWith("sm") ||
         word.startsWith("dw") ||
         word.startsWith("sp") ||
         word.startsWith("fl") ||
         word.startsWith("sq") ||
         word.startsWith("fr") ||
         word.startsWith("st") ||
         word.startsWith("gl") ||
         word.startsWith("sw") ||
         word.startsWith("gr") ||
         word.startsWith("th") ||
         word.startsWith("kl") ||
         word.startsWith("tr") ||
         word.startsWith("ph") ||
         word.startsWith("tw") ||
         word.startsWith("pl") ||
         word.startsWith("wh") ||
         word.startsWith("pr") ||
         word.startsWith("wr");
  }

}
