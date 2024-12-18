import labs.Answer;
import labs.Lab;

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
        System.out.println(Lab.assertIt(Answer.class.getMethod("getInteger"), new Object[]{}, 42));
        System.out.println(Lab.assertIt(Answer.class.getMethod("getDouble"), new Object[]{}, 3.1416));
        System.out.println(Lab.assertIt(Answer.class.getMethod("getBoolean"), new Object[]{}, true));

        System.out.println(Lab.assertIt(Answer.class.getMethod("toMinutes", int.class, int.class), new Object[]{0, 0}, 0));
        System.out.println(Lab.assertIt(Answer.class.getMethod("toMinutes", int.class, int.class), new Object[]{2, 2}, 122));
        System.out.println(Lab.assertIt(Answer.class.getMethod("toMinutes", int.class, int.class), new Object[]{4, 61}, 301));

        System.out.println(Lab.assertIt(Answer.class.getMethod("toSeconds", int.class, int.class, int.class), new Object[]{0, 0, 0}, 0));
        System.out.println(Lab.assertIt(Answer.class.getMethod("toSeconds", int.class, int.class, int.class), new Object[]{12, 12, 12}, 43932));
        System.out.println(Lab.assertIt(Answer.class.getMethod("toSeconds", int.class, int.class, int.class), new Object[]{23, 59, 59}, 86399));

        System.out.println(Lab.assertIt(Answer.class.getMethod("isEven", int.class), new Object[]{4}, true));
        System.out.println(Lab.assertIt(Answer.class.getMethod("isEven", int.class), new Object[]{9}, false));

        System.out.println(Lab.assertIt(Answer.class.getMethod("addAndDoubleInt", int.class, int.class), new Object[]{0, 0}, 0));
        System.out.println(Lab.assertIt(Answer.class.getMethod("addAndDoubleInt", int.class, int.class), new Object[]{1, 2}, 6));
        System.out.println(Lab.assertIt(Answer.class.getMethod("addAndDoubleInt", int.class, int.class), new Object[]{4, 5}, 18));

        System.out.println(Lab.assertIt(Answer.class.getMethod("rectangleArea", int.class, int.class), new Object[]{1, 1}, 1));
        System.out.println(Lab.assertIt(Answer.class.getMethod("rectangleArea", int.class, int.class), new Object[]{2, 2}, 4));
        System.out.println(Lab.assertIt(Answer.class.getMethod("rectangleArea", int.class, int.class), new Object[]{3, 4}, 12));

        System.out.println(Lab.assertIt(Answer.class.getMethod("celsiusToFahrenheit", double.class), new Object[]{0}, 32.0));
        System.out.println(Lab.assertIt(Answer.class.getMethod("celsiusToFahrenheit", double.class), new Object[]{20.4}, 69.0));
        System.out.println(Lab.assertIt(Answer.class.getMethod("celsiusToFahrenheit", double.class), new Object[]{-20.1}, -4.0));

        System.out.println(Lab.assertIt(Answer.class.getMethod("piWithDecimals"), new Object[]{}, Math.round(Math.PI * Math.pow(10, 9)) / Math.pow(10, 9)));

        System.out.println(Lab.assertIt(Answer.class.getMethod("circleArea", int.class), new Object[]{1}, 3.14159));
        System.out.println(Lab.assertIt(Answer.class.getMethod("circleArea", int.class), new Object[]{2}, 12.56637));
        System.out.println(Lab.assertIt(Answer.class.getMethod("circleArea", int.class), new Object[]{3}, 28.27433));

        System.out.println(Lab.assertIt(Answer.class.getMethod("percentage", double.class, double.class, int.class), new Object[]{100.0, 50.11, 2}, 50.11));
        System.out.println(Lab.assertIt(Answer.class.getMethod("percentage", double.class, double.class, int.class), new Object[]{3.0, 2.0, 2}, 66.67));
        System.out.println(Lab.assertIt(Answer.class.getMethod("percentage", double.class, double.class, int.class), new Object[]{9.0, 8.0, 4}, 88.8889));

        System.out.println(Lab.assertIt(Answer.class.getMethod("timeToString", int.class, int.class, int.class), new Object[]{0, 0, 0}, "00:00:00"));
        System.out.println(Lab.assertIt(Answer.class.getMethod("timeToString", int.class, int.class, int.class), new Object[]{12, 1, 1}, "12:01:01"));
        System.out.println(Lab.assertIt(Answer.class.getMethod("timeToString", int.class, int.class, int.class), new Object[]{23, 59, 59}, "23:59:59"));

        System.out.println(Lab.assertIt(Answer.class.getMethod("secondsToHHMMSS", int.class), new Object[]{0}, "00:00:00"));
        System.out.println(Lab.assertIt(Answer.class.getMethod("secondsToHHMMSS", int.class), new Object[]{12 * 60 * 60 + 1 * 60 + 1}, "12:01:01"));
        System.out.println(Lab.assertIt(Answer.class.getMethod("secondsToHHMMSS", int.class), new Object[]{23 * 60 * 60 + 60 * 60 - 1}, "23:59:59"));

        System.out.println(Lab.assertIt(Answer.class.getMethod("nameFormatter", String.class, String.class, String.class), new Object[]{"Jane", "", "Doe"}, "Jane Doe", 2));
        System.out.println(Lab.assertIt(Answer.class.getMethod("nameFormatter", String.class, String.class, String.class), new Object[]{"John", "Unknown", "Doe"}, "John U. Doe", 2));

        System.out.println(Lab.assertIt(Answer.class.getMethod("pythagorean", double.class, double.class, double.class), new Object[]{1, 1, Math.sqrt(2)}, true, 2));
        System.out.println(Lab.assertIt(Answer.class.getMethod("pythagorean", double.class, double.class, double.class), new Object[]{3, 9, 3 * Math.sqrt(10)}, true));
        System.out.println(Lab.assertIt(Answer.class.getMethod("pythagorean", double.class, double.class, double.class), new Object[]{1, 1, 1}, false));

        System.out.println(Lab.assertIt(Answer.class.getMethod("formatMoney", int.class), new Object[]{621}, "500 kr: 1, 100 kr: 1, 20 kr: 1, 1 kr: 1.", 2));
        System.out.println(Lab.assertIt(Answer.class.getMethod("formatMoney", int.class), new Object[]{1542}, "500 kr: 3, 100 kr: 0, 20 kr: 2, 1 kr: 2."));
        System.out.println(Lab.assertIt(Answer.class.getMethod("formatMoney", int.class), new Object[]{2199}, "500 kr: 4, 100 kr: 1, 20 kr: 2, 1 kr: 19."));

        System.out.println(Lab.done());
    }
}
