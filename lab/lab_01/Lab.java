/**
 * This module contains lab specific code to assert the functions of the lab 
 * and to calculate the result.
 */
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class Lab {
    /**
     * Define the levels to PASS, PASS W HONOUR, PASS TOTAL.
     */
    static int PASS = 15;
    static int PASS_W_HONOUR = 19;
    static int PASS_TOTAL = 21;

    /**
     * Return a string with motivational feedback.
     * @returns {string} A string with a message.
     */
    static public String feedback (int points)
    {
        String msg = "Great, you are on fire and progress is made. 😋";
        if (points == 0) 
        {
            msg = "Try to earn 1 point to get started... 😏";
        }
        else if (points == 1)
        {
            msg = "Nice work, lets go, do another! 😉";
        }
        else if (points == PASS - 3)
        {
            msg = "Just three more to PASS. Lets go. 😅";
        }
        else if (points == PASS - 2)
        {
            msg = "Just two more to PASS. Lets go. 😅";
        }
        else if (points == PASS - 1)
        {
            msg = "Just one more to PASS. Lets go. 😅";
        }
        else if (points == PASS)
        {
            msg = "Excellent, you have PASSED. One more? 😁";
        }
        else if (points == PASS_W_HONOUR - 2)
        {
            msg = "Two more to PASS WITH HONOUR! Lets go. 😅";
        }
        else if (points == PASS_W_HONOUR - 1)
        {
            msg = "One more to PASS WITH HONOUR! Lets go. 😅";
        }
        else if (points == PASS_W_HONOUR)
        {
            msg = "That is the way, you PASSED WITH HONOUR! 😍";
        }
        else if (points == PASS_TOTAL)
        {
            msg = "What can I say. You impress me. 🙌";
        }

        return msg;
    }



    /**
     * Dictionary to hold statistics of each method call.
     */
    static Map<String, Statistic> stats = new LinkedHashMap<>();

    /**
    * Execute the testcase and assert that it was corrent or not and return a
    * status string the can be written out.
    * @param {Function} func - The function to test.
    * @param {Object} expected - The expected result from the function call.
    * @param {Object} args - The arguments to send to the function.
    * @param {number} point - The number of points that this functions is worth in total.
    * @returns {string} A string representation of the test case success or failure.
    */
    static public String assertIt(Method method, Object[] args, Object expected) {
        return assertIt(method, args, expected, 1);
    }

    static public String assertIt(
        Method method,
        Object[] args,
        Object expected,
        int point
    ) {
        // Call the method with the arguments
        Object result = null;
        try {
            result = method.invoke(null, args);
        } catch (Exception ex) {
            System.err.println(ex);
        }
        boolean success = false;

        // Verify that returned result matches the expected
        if (expected == null && result == null)
        {
            success = true;
        }
        else if (expected != null && result != null && expected.getClass() == result.getClass())
        {
            if (expected.getClass() == String.class && ((String)expected).equals((String)result))
            {
                success = true;
            }
            else if (expected.getClass() == Integer.class && (int)expected == (int)result)
            {
                success = true;
            }
            else if (expected.getClass() == Double.class && (double)expected == (double)result)
            {
                success = true;
            }
            else if (expected.getClass() == Boolean.class && (boolean)expected == (boolean)result)
            {
                success = true;
            }
        }

        // Calculate the stats
        String methodName = method.getName();
        if (stats.containsKey(methodName) == false)
        {
            stats.put(methodName, new Statistic(point));
        }
        stats.get(methodName).run(success);

        // Prepare the argument string
        String successStr = success ? "✅" : "❌";
        String points = String.valueOf(stats.get(methodName).points);
        String argStr = argsAsString(args);
        String expectedStr = expected != null ? argsAsString(new Object[]{expected}) : "";
        String resultStr = result != null ? argsAsString(new Object[]{result}) : "";
        String expectedType = expected != null ? expected.getClass().toString().substring(6) : "";
        String resultType = result != null ? result.getClass().toString().substring(6) : "";

        return String.format("%s %sp. %s(%s), expected: %s (%s), actual: %s (%s)", successStr, points, methodName, argStr, expectedStr, expectedType, resultStr, resultType);
    }



    /**
    * Format a value to its string representation.
    * @param {Object} args - A value to parse and format as a string.
    * @returns {string} A string representation of the value.
    */
    static String argsAsString(Object[] args)
    {
        String argStr = "";
        for (int i = 0; i < args.length; i++)
        {
            if (args[i].getClass() == String.class)
            {
                argStr += "\"" + args[i] + "\", ";
            }
            // else if (typeof arg === 'object' && Array.isArray(arg)) {
            //     argStr += `[${arg}], `
            // }
            else
            {
                argStr += args[i] + ", ";
            }
        }

        return argStr.length() > 2
            ? argStr = argStr.substring(0, argStr.length() - 2)
            : argStr
        ;
    }



    /**
    * Print out the results when the execution is done.
    * @returns {string} A string representation of the results.
    */
    static public String done ()
    {
        int passed = 0;
        int failed = 0;
        int total = 0;
        int result = 0;
        String str = "";
        boolean[] pointArray = new boolean[PASS_TOTAL];

        int step = 0;
        for (Statistic value : stats.values()) {
            passed += value.passed;
            failed += value.failed;
            total  += value.passed + value.failed;
            result += value.failed > 0 ? 0 : value.points;
            for (int i = 0; i < value.points; i++) {
                pointArray[step++] = value.failed == 0;
            }
        };

        String pointStr = "";
        for (int i = 1; i <= PASS_TOTAL; i++) {
            if (pointArray[i - 1]) {
                pointStr += " ⦿ ";
            } else if (i == PASS) {
                pointStr += " 😁 ";
            } else if (i == PASS_W_HONOUR) {
                pointStr += " 😍 ";
            } else if (i == PASS_TOTAL) {
                pointStr += " 🙌 ";
            } else {
                pointStr += " ⦾ ";
            }
        }

        str += " --------------------------------------------------------------------\n";
        str += "| Total: " + total + ", Passed ✅: " + passed + ", Failed ❌: " + failed;
        str += "\n|";
        str += "\n| Points needed to PASS=" + PASS + ", PASS WITH HONOUR=" + PASS_W_HONOUR + ", TOTAL=" + PASS_TOTAL;
        str += "\n| " + pointStr;
        str += "\n|\n| You have " + result + " points. " + feedback(result);
        str += "\n --------------------------------------------------------------------";

        return str;
    }
}



/**
 * Class to hold statistics summary for each method.
 */
class Statistic {
    public int run = 0;
    public int passed = 0;
    public int failed = 0;
    public int points;

    public Statistic (int aPoint)
    {
        points = aPoint;
    }

    public void run (boolean success)
    {
        run++;
        if (success) 
        {
            passed++;
        } 
        else
        {
            failed++;
        }
    }
}

