/*
 * This module contains the methods you should implement.
 * 
 * Update the code in Module.java and execute the lab like this:
 *  javac *.java && java Main
 */
public class Answer {
    /**
     * Return the string "Hello World!".
     */
    public static String hello()
    {
        // TODO: Write your code here.
        return "Hello World!";
    }

    /**
     * Return the integer value 42.
     */
    public static int getInteger()
    {
        // TODO: Write your code here.
        return 42;
    }

    /**
     * Return the value of PI with 4 decimals.
     */
    public static double getDouble()
    {
        // TODO: Write your code here.
        return 3.1416;
    }

    /**
     * Return the boolean value true.
     */
    public static Boolean getBoolean()
    {
        // TODO: Write your code here.
        return true;
    }

    /**
     * Get the hours and minutes from the parameter list and convert it into 
     * minutes only, 1 hour is 60 minutes.
     */
    public static int toMinutes(int hour, int minute)
    {
        // TODO: Write your code here.
        return hour * 60 + minute;
    }

    /**
     * Convert incoming parameters hour, minute and second to seconds.
     */
    public static int toSeconds(int hour, int minute, int second)
    {
        // TODO: Write your code here.
        return hour * 60 * 60 + minute * 60 + second;
    }

    /**
     * Check if number is even and return true or false.
     */
    public static Boolean isEven(int number)
    {
        // TODO: Write your code here.
        return (number % 2 == 0) ? true : false;
    }

    // Expressions

    /**
     * Perform addition of the two parameters a and b, then double the sum and
     * return it.
     */
    public static int addAndDoubleInt(int a, int b)
    {
        // TODO: Write your code here.
        return (a + b) * 2;
    }

    /**
     * Calculate the area of a rectangle.
     */
    public static int rectangleArea(int width, int height)
    {
        // TODO: Write your code here.
        return width * height;
    }

    /**
     * Convert celsius degrees to fahrenheit degrees and round it to the closest
     * integer with no decimals.
     */
    public static double celsiusToFahrenheit(double celsius)
    {
        // TODO: Write your code here.
        return Math.round(celsius * 1.8 + 32.0);
    }

    /**
     * Return the value of PI with 9 decimals, do not hardcode PI, use builtin constant.
     */
    public static double piWithDecimals()
    {
        // TODO: Write your code here.

        // scientific notation for 9 decimals, to be divided
        double decimals = Math.pow(10, 9);
        return Math.round(Math.PI * decimals) / decimals;
    }

    /**
     * Calculate the area of a circle with five decimals.
     */
    public static double circleArea(int radius)
    {
        // TODO: Write your code here.
        int decimals = 5;
        return Math.round(Math.PI * radius * radius * Math.pow(10, decimals)) / Math.pow(10, decimals);
    }

    /**
     * Calculate the percentage of part compared to total and round to num
     * decimals.
     */
    public static double percentage(double total, double part, int decimals)
    {
        // TODO: Write your code here.
        return Math.round(part / total * 100 * Math.pow(10, decimals)) / Math.pow(10, decimals);
    }

    // Strings

    /**
     * Return a string with the format "hh:mm:ss", pad with zeros if needed.
     */
    public static String timeToString(int hour, int minute, int second)
    {
        // TODO: Write your code here.
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    /**
     * Convert seconds to hour, minutes and seconds by returning a string with
     * the format "hh:mm:ss", pad with zeros if needed.
     */
    public static String secondsToHHMMSS(int seconds)
    {
        // TODO: Write your code here.
        int hour = seconds / 60 / 60;
        int minute = (seconds - hour * 60 * 60) / 60;
        int second = seconds - hour * 60 * 60 - minute * 60;

        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    // Harder

    /**
     * Format the incoming name like "Firstname M. Lastname" where "M" is the
     * first letter in the middle name. If the middle name is empty, then return
     * "Firstname Lastname". Do not use a if statement, you may use the ternary
     * operator.
     * Return string with formatted name.
     */
    public static String nameFormatter(String first, String middle, String last)
    {
        // TODO: Write your code here.
        String middleInitial = (middle != null && !middle.isEmpty()) ? middle.substring(0, 1) + ". " : "";
    
        return String.format("%s %s%s", first, middleInitial, last);
    }

    /**
     * Check if the triangle is a right triangle (rätvinklig triangle) by using 
     * Pythagorean theorem a*a + b*b = c*c where c is the length of the
     * hyphotenusa. Use four decimals when comparing.
     * Return true or false.
     */
    public static Boolean pythagorean(double sideA, double sideB, double sideC)
    {
        // TODO: Write your code here.
        double triSides = sideA * sideA + sideB + sideB; 
        return (triSides == sideC * sideC) ? true : false;
    }

    /**
     * Take the amount in kronor and split by bills 500, 100, 20 and return a 
     * string saying the amount of each bill and how many kronors are left.
     * Do not use if statements or loops.
     * Return the string like "500 kr: %d, 100 kr: %d, 20 kr: %d, 1 kr: %d.".
     */
    public static String formatMoney(int amount)
    {
        int num500 = amount / 500;
        int remainder = amount % 500;
        
        int num100 = remainder / 100;
        remainder = remainder % 100;
        
        int num20 = remainder / 20;
        remainder = remainder % 20;
        
        int num1 = remainder;
    
        // Format the result string
        return String.format("500 kr: %d, 100 kr: %d, 20 kr: %d, 1 kr: %d.", num500, num100, num20, num1);    
    }
}
