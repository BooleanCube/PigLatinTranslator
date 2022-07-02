import org.junit.Assert;
import org.junit.Test;

public class TranslatorTests {

    @Test
    public void runTranslatorTests() {
        Assert.assertEquals("Expected: egularray\nObserved: " + PigLatinTranslator.translateText("regular"),
                "egularray",
                PigLatinTranslator.translateText("regular"));

        Assert.assertEquals("Expected: okayyay\nObserved: " + PigLatinTranslator.translateText("okay"),
                "okayyay",
                PigLatinTranslator.translateText("okay"));

        Assert.assertEquals("Expected: isthay ightmay ebay ayay ittlelay itbay oremay omplicatedcay.\nObserved: " + PigLatinTranslator.translateText("This might be a little bit more complicated."),
                "isthay ightmay ebay ayay ittlelay itbay oremay omplicatedcay.",
                PigLatinTranslator.translateText("This might be a little bit more complicated."));

        Assert.assertEquals("Expected: ethay upcay ackedcray andyay illedspay itsyay ontentscay. ethay encilpay asway utcay otay ebay arpshay atyay othbay endsyay.\nObserved: " + PigLatinTranslator.translateText("The cup cracked and spilled its contents. The pencil was cut to be sharp at both ends."),
                "ethay upcay ackedcray andyay illedspay itsyay ontentscay. ethay encilpay asway utcay otay ebay arpshay atyay othbay endsyay.",
                PigLatinTranslator.translateText("The cup cracked and spilled its contents. The pencil was cut to be sharp at both ends."));
    }

}
