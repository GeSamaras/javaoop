import java.util.Arrays;

/**
 * This module contains the methods you should implement.
 * 
 * Update the code in Module.java and execute the lab like this:
 *  javac *.java && java Main
 * 
 */

public class Answer {
    /**
     * Return the string "Hello World!".
     * @return String the string with the message.
     */
    public static String hello()
    {
        // @TODO: Write your code here.
        return "Hello World!";
    }

    // Number basics

    /**
     * Return the square root of 2, rounded to 4 decimals. Use built in methods.
     * @return double the square root of two.
     */
    public static double squareOfTwo()
    {
        // @TODO: Write your code here.
        double power = Math.pow(10, 4);
        double square = Math.round(Math.sqrt(2) * power) / power;
        return square;
    }

    /**
     * Return the sum of a and b, rounded to two decimals.
     * @return double sum of the two numbers, rounded 2 decimals.
     */
    public static double addition(double a, double b)
    {
        // @TODO: Write your code here.
        double decimals = Math.pow(10, 2);
        return Math.round((a + b) * decimals) / decimals;
    }

    /**
     * Return the integer value of the incoming string str.
     * @return int value of string.
     */
    public static int intValString(String str)
    {
        // @TODO: Write your code here.
        return Integer.parseInt(str);
    }

    /**
     * Use string formatting to create a string with Math.PI and present it with
     * 5 decimals.
     * @return String with the value of pi with 5 decimals.
     */
    public static String formatPiAsString()
    {
        // @TODO: Write your code here.
        return String.format("%.5f", Math.PI);
    }

    /**
     * Round the incoming value val to it closest higher integer.
     * @return int as the rounded value.
     */
    public static int roundUp(double val)
    {
        // @TODO: Write your code here.
        return (int) Math.ceil(val);
    }

    /**
     * Round the incoming value val to it closest lower integer.
     * @return int as the rounded value.
     */
    public static int roundDown(double val)
    {
        // @TODO: Write your code here.
        return (int) Math.floor(val);
    }

    // Numbers in an array

    /**
     * Return the length of the incoming array arr.
     * @return int length of array.
     */
    public static int lengthOfArray(int[] arr)
    {
        // @TODO: Write your code here.
        return arr.length;
    }

    /**
     * Return the first item in the array.
     * @return int first item in the array.
     */
    public static int firstItemInArray(int[] arr)
    {
        // @TODO: Write your code here.
        return arr[0];
    }

    /**
     * Return the last item in the array.
     * @return int first item in the array.
     */
    public static int lastItemInArray(int[] arr)
    {
        // @TODO: Write your code here.
        return arr[arr.length - 1];
    }

    /**
     * Return the middle item in the array, if the middle has two values, then
     * return the average of the two values and round the result.
     * @return int mid item or average of mid items.
     */
    public static int midItemInArray(int[] arr)
    {
        // @TODO: Write your code here.
        int middle;
        if (arr.length % 2 == 1) {
            middle = arr[(arr.length / 2)];
        } else {
            int mid = arr.length / 2;
            middle = (int) Math.round(arr[mid - 1] + arr[mid]) / 2;
        }
        return middle;
    }

    /**
     * Sum all items in the array.
     * @return int sum of the items in the array.
     */
    public static int sumArray(int[] arr)
    {
        // @TODO: Write your code here.
        int sum = 0;
        for (int i: arr) {
            sum += i;
        }
        return sum;
    }
    /**
     * Find the largest value in the array.
     * @return int the largest value in the array.
     */
    public static int max(int[] arr)
    {
        // @TODO: Write your code here.
        int highest = arr[0];
        for (int i: arr) {
            if (i > highest) {
                highest = i;
            }
        }
        return highest;
    }

    /**
     * Check if the array is sorted in ascending order.
     * @return boolean true if sorted array else false.
     */
    public static Boolean isSorted(int[] arr)
    {
        // @TODO: Write your code here.
        int last = arr[0];
        for (int i: arr) {
            if (last > i) {
                return false;
            }
         }
        return true;
    }

    /**
     * Count the average of the items in the array, round up to the nearest
     * integer.
     * @return int average of the array items, rounded up.
     */
    public static int average(int[] arr)
    {
        // @TODO: Write your code here.
        int sum = sumArray(arr);
        double average = (double) sum / arr.length;
        average = Math.ceil(average);
        return (int) average;
    }


    /**
     * Clone the incoming array and reverse the items in the clone (change its
     * order and reverse all items in it).
     * @return int[] cloned array with reversed content.
     */
    public static int[] reverse(int[] arr)
    {
        // @TODO: Write your code here.
        int[] clone = arr.clone();
        for (int i = 0; i < clone.length / 2; i++) {
            int tmp = clone[i];
            clone[i] = clone[clone.length - i - 1];
            clone[clone.length - i - 1] = tmp;
        }
        return clone;
    }

    /**
     * Clone the incoming array into a new array and the sort it, return the 
     * cloned and sorted array.
     * @return int[] cloned array with sorted content.
     */
    public static int[] sort(int[] arr)
    {
        int[] clone = arr.clone();
        Arrays.sort(clone);
        return clone;
    }

    /**
     * Find the median value in the array arr, but do not modify the incoming
     * array.
     * @return int mean value in the array.
     */
    public static int median(int[] arr)
    {
        // @TODO: Write your code here.
                int[] clone = arr.clone();
        Arrays.sort(clone);
        int median = midItemInArray(clone);
        return median;
    }
}
