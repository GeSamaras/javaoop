/**
 * The main program that executes the functions in the class Module and asserts
 * that they return the expected values.
 * 
 * Update the code in Module.java and execute the lab like this:
 *  javac *.java && java Main
 */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(Lab.assertIt(Answer.class.getMethod("hello"), new Object[]{}, "Hello World!"));

        System.out.println(Lab.assertIt(Answer.class.getMethod("stringLength", String.class), new Object[]{"Mumintrollet"}, 12));
        System.out.println(Lab.assertIt(Answer.class.getMethod("stringLength", String.class), new Object[]{" This is a string "}, 18));

        System.out.println(Lab.assertIt(Answer.class.getMethod("firstLastChar", String.class), new Object[]{"Mumin"}, "Mn"));
        System.out.println(Lab.assertIt(Answer.class.getMethod("firstLastChar", String.class), new Object[]{"Mu"}, "Mu"));
        System.out.println(Lab.assertIt(Answer.class.getMethod("firstLastChar", String.class), new Object[]{""}, ""));

        System.out.println(Lab.assertIt(Answer.class.getMethod("intValChar", String.class), new Object[]{"Cow say muu"}, 32));
        System.out.println(Lab.assertIt(Answer.class.getMethod("intValChar", String.class), new Object[]{"Mumin"}, 105));

        System.out.println(Lab.assertIt(Answer.class.getMethod("createStringFromChar", char.class, int.class), new Object[]{'a', 5}, "abcde"));
        System.out.println(Lab.assertIt(Answer.class.getMethod("createStringFromChar", char.class, int.class), new Object[]{'z', 1}, "z"));
        System.out.println(Lab.assertIt(Answer.class.getMethod("createStringFromChar", char.class, int.class), new Object[]{'M', 7}, "MNOPQRS"));

        System.out.println(Lab.assertIt(Answer.class.getMethod("swapCase", String.class), new Object[]{"MuminTROLL"}, "mUMINtroll"));
        System.out.println(Lab.assertIt(Answer.class.getMethod("swapCase", String.class), new Object[]{"I like #cake"}, "i LIKE #CAKE"));

        System.out.println(Lab.assertIt(Answer.class.getMethod("replaceSpace", String.class), new Object[]{" I like #cake "}, "I-like-#cake"));
        System.out.println(Lab.assertIt(Answer.class.getMethod("replaceSpace", String.class), new Object[]{"mumin troll"}, "mumin-troll"));

        System.out.println(Lab.assertIt(Answer.class.getMethod("replaceSpaceMultiple", String.class), new Object[]{" I  like  #cake "}, "I-like-#cake"));
        System.out.println(Lab.assertIt(Answer.class.getMethod("replaceSpaceMultiple", String.class), new Object[]{" Mumin \t troll   et"}, "Mumin-troll-et"));

        System.out.println(Lab.assertIt(Answer.class.getMethod("substring", String.class, int.class, int.class), new Object[]{"Mumintrollet", 5, 5}, "troll"));
        System.out.println(Lab.assertIt(Answer.class.getMethod("substring", String.class, int.class, int.class), new Object[]{"Mumintrollet", 0, 5}, "Mumin"));

        System.out.println(Lab.assertIt(Answer.class.getMethod("substringInString", String.class, String.class), new Object[]{"Mumintrollet", "troll"}, true));
        System.out.println(Lab.assertIt(Answer.class.getMethod("substringInString", String.class, String.class), new Object[]{"Mumintrollet", "Moomin"}, false));

        System.out.println(Lab.assertIt(Answer.class.getMethod("firstLastSubString", String.class), new Object[]{"Mumin bor i skogen."}, "Mumin skogen."));
        System.out.println(Lab.assertIt(Answer.class.getMethod("firstLastSubString", String.class), new Object[]{"I like cake"}, "I cake"));

        System.out.println(Lab.assertIt(Answer.class.getMethod("formatString", String.class, char.class, int.class, double.class), new Object[]{"Hi", 'Y', 42, Math.PI}, "Hi Y 042 3.14", 2));
        System.out.println(Lab.assertIt(Answer.class.getMethod("formatString", String.class, char.class, int.class, double.class), new Object[]{"Yooou", 'I', 7, Math.sqrt(2)}, "Yooou I 007 1.41"));

        System.out.println(Lab.assertIt(Answer.class.getMethod("checkPasswordConstraints", String.class), new Object[]{"Hemligt7"}, false, 2));
        System.out.println(Lab.assertIt(Answer.class.getMethod("checkPasswordConstraints", String.class), new Object[]{"He#ligt7"}, true));
        System.out.println(Lab.assertIt(Answer.class.getMethod("checkPasswordConstraints", String.class), new Object[]{"he#ligt"}, false));
        System.out.println(Lab.assertIt(Answer.class.getMethod("checkPasswordConstraints", String.class), new Object[]{"!#HEMligt777"}, true));

        System.out.println(Lab.assertIt(Answer.class.getMethod("countWords", String.class), new Object[]{" Mumintrollet lives  in the forest. "}, 5, 2));
        System.out.println(Lab.assertIt(Answer.class.getMethod("countWords", String.class), new Object[]{" Mumin-trolletlives  in the forest . "}, 5));

        System.out.println(Lab.assertIt(Answer.class.getMethod("reverseString", String.class), new Object[]{"Mumintrollet"}, "tellortnimuM", 2));
        System.out.println(Lab.assertIt(Answer.class.getMethod("reverseString", String.class), new Object[]{"Mikael"}, "leakiM"));

        System.out.println(Lab.assertIt(Answer.class.getMethod("isPalindrom", String.class), new Object[]{" Anna"}, true, 2));
        System.out.println(Lab.assertIt(Answer.class.getMethod("isPalindrom", String.class), new Object[]{"Was it a car or a cat I saw "}, true));
        System.out.println(Lab.assertIt(Answer.class.getMethod("isPalindrom", String.class), new Object[]{"Civec"}, false));

        System.out.println(Lab.done());
    }
}
