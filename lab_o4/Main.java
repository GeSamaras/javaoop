/**
 * The main program that executes the functions in the class Module and asserts
 * that they return the expected values.
 * 
 * Update the code in Module.java and execute the lab like this:
 *  javac *.java && java Main
 */
public class Main {
    private static int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
    private static int[] rev1 = {7, 6, 5, 4, 3, 2, 1};
    private static int[] arr2 = {3, 4, 5, 6, 7, 8};
    private static int[] rev2 = {8, 7, 6, 5, 4, 3};
    private static int[] arr3 = {3, 9, 1, 42, 9, 13};
    private static int[] arr4 = {42, 7, 0, 13, 8, 5};
    private static int[] sort1 = {3, 9, 1, 42, 9, 13};
    private static int[] sorted1 = {1, 3, 9, 9, 13, 42};
    private static int[] sort2 = {7, 2, 13, 42, 99, 21};
    private static int[] sorted2 = {2, 7, 13, 21, 42, 99};
    public static void main(String[] args) throws Exception {
        System.out.println(Lab.assertIt(Answer.class.getMethod("hello"), new Object[]{}, "Hello World!"));

        System.out.println(Lab.assertIt(Answer.class.getMethod("squareOfTwo"), new Object[]{}, 1.4142));

        System.out.println(Lab.assertIt(Answer.class.getMethod("addition", double.class, double.class), new Object[]{3.1415, 1.4142}, 4.56));
        System.out.println(Lab.assertIt(Answer.class.getMethod("addition", double.class, double.class), new Object[]{40.0001, 1.9998}, 42.00));

        System.out.println(Lab.assertIt(Answer.class.getMethod("intValString", String.class), new Object[]{"42 mopeds"}, null));
        System.out.println(Lab.assertIt(Answer.class.getMethod("intValString", String.class), new Object[]{"7"}, 7));

        System.out.println(Lab.assertIt(Answer.class.getMethod("formatPiAsString"), new Object[]{}, "3.14159"));

        System.out.println(Lab.assertIt(Answer.class.getMethod("roundUp", double.class), new Object[]{3.14}, 4));

        System.out.println(Lab.assertIt(Answer.class.getMethod("roundDown", double.class), new Object[]{3.14}, 3));

        System.out.println(Lab.assertIt(Answer.class.getMethod("lengthOfArray", int[].class), new Object[]{arr1}, 7));

        System.out.println(Lab.assertIt(Answer.class.getMethod("firstItemInArray", int[].class), new Object[]{arr1}, 1));
        System.out.println(Lab.assertIt(Answer.class.getMethod("firstItemInArray", int[].class), new Object[]{arr2}, 3));
        
        System.out.println(Lab.assertIt(Answer.class.getMethod("lastItemInArray", int[].class), new Object[]{arr1}, 7));
        System.out.println(Lab.assertIt(Answer.class.getMethod("lastItemInArray", int[].class), new Object[]{arr2}, 8));

        System.out.println(Lab.assertIt(Answer.class.getMethod("midItemInArray", int[].class), new Object[]{arr1}, 4));
        System.out.println(Lab.assertIt(Answer.class.getMethod("midItemInArray", int[].class), new Object[]{arr2}, 5));

        System.out.println(Lab.assertIt(Answer.class.getMethod("sumArray", int[].class), new Object[]{arr1}, 28));
        System.out.println(Lab.assertIt(Answer.class.getMethod("sumArray", int[].class), new Object[]{arr2}, 33));

        System.out.println(Lab.assertIt(Answer.class.getMethod("max", int[].class), new Object[]{arr3}, 42));
        System.out.println(Lab.assertIt(Answer.class.getMethod("max", int[].class), new Object[]{arr4}, 42));

        System.out.println(Lab.assertIt(Answer.class.getMethod("isSorted", int[].class), new Object[]{arr1}, true));
        System.out.println(Lab.assertIt(Answer.class.getMethod("isSorted", int[].class), new Object[]{arr3}, false));

        System.out.println(Lab.assertIt(Answer.class.getMethod("average", int[].class), new Object[]{arr3}, 13));
        System.out.println(Lab.assertIt(Answer.class.getMethod("average", int[].class), new Object[]{arr2}, 6));

        System.out.println(Lab.assertIt(Answer.class.getMethod("reverse", int[].class), new Object[]{arr1}, rev1, 2));
        System.out.println(Lab.assertIt(Answer.class.getMethod("reverse", int[].class), new Object[]{arr2}, rev2));

        System.out.println(Lab.assertIt(Answer.class.getMethod("sort", int[].class), new Object[]{sort1}, sorted1, 2));
        System.out.println(Lab.assertIt(Answer.class.getMethod("sort", int[].class), new Object[]{sort2}, sorted2));

        System.out.println(Lab.assertIt(Answer.class.getMethod("median", int[].class), new Object[]{arr1}, 4, 2));
        System.out.println(Lab.assertIt(Answer.class.getMethod("median", int[].class), new Object[]{sort2}, 17));

        System.out.println(Lab.done());
    }
}
