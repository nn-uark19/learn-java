// Single-line comments start with //
/*
Multi-line comments look like this.
*/

// Import ArrayList class inside of the java.util package

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
// Import all classes inside of java.security package
import java.security.*;


public class JavaReview {
  // In order to run a java program, it must have a main method as an entry point.
  public static void main(String args[]) {
    ///////////////////////////////////////
    // I. Input/Output
    ///////////////////////////////////////
    /* I.1- Output */

    // Use System.out.println() to print lines.
    System.out.println("JavaReview.main");
    System.out.println("args = " + Arrays.deepToString(args));
    System.out.println("Integer: " + 10 + " Double: " + 3.14 + " Boolean: " + true);

    // To print without a newline, use System.out.print().
    System.out.print("Hello ");
    System.out.print("World");
    System.out.println();

    // Use System.out.printf() for easy formatted printing.
    System.out.printf("pi = %.5f\n", Math.PI); // => pi = 3.14159

    /* I.2- Input */
    // use Scanner to read input
    // must import java.util.Scanner;
    /*
    Scanner scanner = new Scanner(System.in);

    // read string input
    String name = scanner.next();

    // read byte input
    byte numByte = scanner.nextByte();

    // read int input
    int numInt = scanner.nextInt();

    // read long input
    float numFloat = scanner.nextFloat();

    // read double input
    double numDouble = scanner.nextDouble();

    // read boolean input
    boolean bool = scanner.nextBoolean();
     */

    ///////////////////////////////////////
    // II. Variables
    ///////////////////////////////////////

    /* II.1- Variable Declaration */
    // Declare a variable using <type> <name>
    int fooInt;
    // Declare multiple variables of the same type <type> <name1>, <name2>, <name3>
    int fooInt1, fooInt2, fooInt3;

    /* II.2- Variable Initialization */

    // Initialize a variable using <type> <name> = <val>
    int barInt = 1;
    // Initialize multiple variables of same type with same value <type> <name1>, <name2>, <name3>
    // <name1> = <name2> = <name3> = <val>
    int barInt1, barInt2, barInt3;
    barInt1 = barInt2 = barInt3 = 1;

    /* II.3- Variable types */
    // Byte - 8-bit signed two's complement integer (-128 <= byte <= 127)
    byte fooByte = 100;

    // If you would like to interpret a byte as an unsigned integer then this simple operation can help
    int unsignedIntLessThan256 = 0xff & fooByte;
    // this contrasts a cast which can be negative.
    int signedInt = (int) fooByte;

    // Short - 16-bit signed two's complement integer (-32,768 <= short <= 32,767)
    short fooShort = 10000;

    // Integer - 32-bit signed two's complement integer (-2,147,483,648 <= int <= 2,147,483,647)
    int bazInt = 1;

    // Long - 64-bit signed two's complement integer (-9,223,372,036,854,775,808 <= long <= 9,223,372,036,854,775,807)
    long fooLong = 100000L;
    // L is used to denote that this variable value is of type Long; anything without is treated as integer by default.

    // Note: byte, short, int and long are signed. They can have positive and negative values.
    // There are no unsigned variants.
    // char, however, is 16-bit unsigned.

    // Float - Single-precision 32-bit IEEE 754 Floating Point 2^-149 <= float <= (2-2^-23) * 2^127
    float fooFloat = 234.5f;
    // f or F is used to denote that this variable value is of type float; otherwise it is treated as double.

    // Double - Double-precision 64-bit IEEE 754 Floating Point 2^-1074 <= x <= (2-2^-52) * 2^1023
    double fooDouble = 123.4;

    // Boolean - true & false
    boolean fooBoolean = true;
    boolean barBoolean = false;

    // Char - A single 16-bit Unicode character
    char fooChar = 'A';

    // final variables can't be reassigned,
    final int HOURS_I_WORK_PER_WEEK = 9001;
    // but they can be initialized later.
    final double E;
    E = 2.71828;

    // BigInteger - Immutable arbitrary-precision integers
    // BigInteger is a data type that allows programmers to manipulate
    // integers longer than 64-bits. Integers are stored as an array of
    // of bytes and are manipulated using functions built into BigInteger
    // BigInteger can be initialized using an array of bytes or a string.
    // BigInteger fooBigInteger = new BigInteger(fooByteArray);

    // BigDecimal - Immutable, arbitrary-precision signed decimal number
    // A BigDecimal takes two parts: an arbitrary precision integer
    // unscaled value and a 32-bit integer scale
    // BigDecimal allows the programmer complete control over decimal
    // rounding. It is recommended to use BigDecimal with currency values
    // and where exact decimal precision is required.
    // BigDecimal can be initialized with an int, long, double or String
    // or by initializing the unscaled value (BigInteger) and scale (int).
    // BigDecimal fooBigDecimal = new BigDecimal(fooBigInteger, fooInt);

    // Be wary of the constructor that takes a float or double as
    // the inaccuracy of the float/double will be copied in BigDecimal.
    // Prefer the String constructor when you need an exact value.
    BigDecimal tenCents = new BigDecimal("0.1");

    // Strings
    String fooString = "My String Is Here!";

    // \n is an escaped character that starts a new line
    String barString = "Printing on a new line?\nNo Problem!";
    // \t is an escaped character that adds a tab character
    String bazString = "Do you want to add a tab?\tNo Problem!";
    System.out.println(fooString);
    System.out.println(barString);
    System.out.println(bazString);

    // String Building
    // #1 - with plus operator
    // That's the basic way to do it (optimized under the hood)
    String plusConcatenated = "Strings can " + "be concatenated " + "via + operator.";
    System.out.println(plusConcatenated);
    // Output: Strings can be concatenated via + operator.

    // #2 - with StringBuilder
    // This way doesn't create any intermediate strings. It just stores the string pieces, and ties them together
    // when toString() is called.
    // Hint: This class is not thread safe. A thread-safe alternative (with some impact on performance) is StringBuffer.
    StringBuilder builderConcatenated = new StringBuilder();
    builderConcatenated.append("You ");
    builderConcatenated.append("can use ");
    builderConcatenated.append("the StringBuilder class.");
    System.out.println(builderConcatenated.toString()); // only now is the string built
    // Output: You can use the StringBuilder class.

    // StringBuilder is efficient when the fully constructed String is not required until the end of some processing.
    StringBuilder stringBuilder = new StringBuilder();
    String inefficientString = "";
    for (int i = 0; i < 10; i++) {
      stringBuilder.append(i).append(" ");
      inefficientString += i + " ";
    }
    System.out.println(inefficientString);
    System.out.println(stringBuilder.toString());
    // inefficientString requires a lot more work to produce, as it generates a String on every loop iteration.
    // Simple concatenation with + is compiled to a StringBuilder and toString()
    // Avoid string concatenation in loops.

    // #3 - with String formatter
    // Another alternative way to create strings. Fast and readable.
    System.out.println(String.format("%s may prefer %s.", "Or you", "String.format()"));
    // Output: Or you may prefer String.format().

    // Arrays
    // The array size must be decided upon instantiation
    // The following formats work for declaring an array
    // <datatype>[] <var name> = new <datatype>[<array size>];
    // <datatype> <var name>[] = new <datatype>[<array size>];
    int[] intArray = new int[10];
    String[] stringArray = new String[1];
    boolean boolArray[] = new boolean[100];

    // Another way to declare & initialize an array
    int[] y = {9000, 1000, 1337};
    String names[] = {"Bob", "John", "Fred", "Juan Pedro"};
    boolean bools[] = {true, false, false};

    // Indexing an array - Accessing an element
    System.out.println("intArray @ 0: " + intArray[0]);

    // Arrays are zero-indexed and mutable.
    intArray[1] = 1;
    System.out.println("intArray @ 1: " + intArray[1]); // => 1

    // Other data types worth checking out
    // ArrayLists - Like arrays except more functionality is offered, and
    //              the size is mutable.
    // LinkedLists - Implementation of doubly-linked list. All of the
    //               operations perform as could be expected for a
    //               doubly-linked list.
    // Maps - A mapping of key Objects to value Objects. Map is
    //        an interface and therefore cannot be instantiated.
    //        The type of keys and values contained in a Map must
    //        be specified upon instantiation of the implementing
    //        class. Each key may map to only one corresponding value,
    //        and each key may appear only once (no duplicates).
    // HashMaps - This class uses a hashtable to implement the Map
    //            interface. This allows the execution time of basic
    //            operations, such as get and insert element, to remain
    //            constant-amortized even for large sets.
    // TreeMap - A Map that is sorted by its keys. Each modification
    //           maintains the sorting defined by either a Comparator
    //           supplied at instantiation, or comparisons of each Object
    //           if they implement the Comparable interface.
    //           Failure of keys to implement Comparable combined with failure to
    //           supply a Comparator will throw ClassCastExceptions.
    //           Insertion and removal operations take O(log(n)) time
    //           so avoid using this data structure unless you are taking
    //           advantage of the sorting.

    ///////////////////////////////////////
    // III. Operators
    ///////////////////////////////////////
    System.out.println("\n->Operators");

    int i1 = 1, i2 = 2; // Shorthand for multiple declarations

    // Arithmetic is straightforward
    System.out.println("1+2 = " + (i1 + i2)); // => 3
    System.out.println("2-1 = " + (i2 - i1)); // => 1
    System.out.println("2*1 = " + (i2 * i1)); // => 2
    System.out.println("1/2 = " + (i1 / i2)); // => 0 (int/int returns int)
    System.out.println("1/2.0 = " + (i1 / (double) i2)); // => 0.5

    // Modulo
    System.out.println("11%3 = " + (11 % 3)); // => 2

    // Comparison operators
    System.out.println("3 == 2? " + (3 == 2)); // => false
    System.out.println("3 != 2? " + (3 != 2)); // => true
    System.out.println("3 > 2? " + (3 > 2)); // => true
    System.out.println("3 < 2? " + (3 < 2)); // => false
    System.out.println("2 <= 2? " + (2 <= 2)); // => true
    System.out.println("2 >= 2? " + (2 >= 2)); // => true

    // Boolean operators
    System.out.println("3 > 2 && 2 > 3? " + ((3 > 2) && (2 > 3))); // => false
    System.out.println("3 > 2 || 2 > 3? " + ((3 > 2) || (2 > 3))); // => true
    System.out.println("!(3 == 2)? " + (!(3 == 2))); // => true

    // Bitwise operators!
    /*
    ~      Unary bitwise complement
    <<     Signed left shift
    >>     Signed/Arithmetic right shift
    >>>    Unsigned/Logical right shift
    &      Bitwise AND
    ^      Bitwise exclusive OR
    |      Bitwise inclusive OR
    */

    // Increment operators
    int i = 0;
    System.out.println("\n->Inc/Dec-rementation");
    // The ++ and -- operators increment and decrement by 1 respectively.
    // If they are placed before the variable, they increment then return;
    // after the variable they return then increment.
    System.out.println(i++); // i = 1, prints 0 (post-increment)
    System.out.println(++i); // i = 2, prints 2 (pre-increment)
    System.out.println(i--); // i = 1, prints 2 (post-decrement)
    System.out.println(--i); // i = 0, prints 0 (pre-decrement)

    ///////////////////////////////////////
    // Control Structures
    ///////////////////////////////////////
    System.out.println("\n->Control Structures");

    // If statements are c-like
    int j = 10;
    if (j == 10) {
      System.out.println("I get printed");
    } else if (j > 10) {
      System.out.println("I don't");
    } else {
      System.out.println("I also don't");
    }

    // While loop
    int fooWhile = 0;
    while (fooWhile < 100) {
      System.out.printf("%d ", fooWhile);
      // Increment the counter
      // Iterated 100 times, fooWhile 0,1,2...99
      fooWhile++;
    }
    System.out.println("\nfooWhile Value: " + fooWhile);

    // Do While Loop
    int fooDoWhile = 0;
    do {
      System.out.printf("%d ", fooDoWhile);
      // Increment the counter
      // Iterated 99 times, fooDoWhile 0->99
      fooDoWhile++;
    } while (fooDoWhile < 100);
    System.out.println("\nfooDoWhile Value: " + fooDoWhile);

    // For Loop
    // for loop structure => for(<start_statement>; <conditional>; <step>)
    int fooFor;
    for (fooFor = 0; fooFor < 10; fooFor++) {
      System.out.printf("%d ", fooFor);
      // Iterated 10 times, fooFor 0->9
    }
    System.out.println("\nfooFor Value: " + fooFor);

    // Nested For Loop Exit with Label
    outerloop:
    for (i = 0; i < 5; i++) {
      for (j = 0; j < 5; j++) {
        if (i * j > 6) {
          System.out.println("Breaking");
          break outerloop;
        }
        System.out.println(i + " " + j);
      }
    }

    // For Each Loop
    // The for loop is also able to iterate over arrays as well as objects
    // that implement the Iterable interface.
    int[] fooList = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    // for each loop structure => for (<object> : <iterable>)
    // reads as: for each element in the iterable
    // note: the object type must match the element type of the iterable.
    for (int bar : fooList) {
      System.out.printf("%d ", bar);
      //Iterates 9 times and prints 1-9 on new lines
    }
    System.out.println();

    // Switch Case
    // A switch works with the byte, short, char, and int data types.
    // It also works with enumerated types (discussed in Enum Types), the
    // String class, and a few special classes that wrap primitive types:
    // Character, Byte, Short, and Integer.
    // Starting in Java 7 and above, we can also use the String type.
    // Note: Do remember that, not adding "break" at end any particular case ends up in
    // executing the very next case(given it satisfies the condition provided) as well.
    int month = 3;
    String monthString;
    switch (month) {
      case 1:
        monthString = "January";
        break;
      case 2:
        monthString = "February";
        break;
      case 3:
        monthString = "March";
        break;
      default:
        monthString = "Some other month";
        break;
    }
    System.out.println("Switch Case Result: " + monthString);

    // Try-with-resources (Java 7+)
    // Try-catch-finally statements work as expected in Java but in Java 7+
    // the try-with-resources statement is also available. Try-with-resources
    // simplifies try-catch-finally statements by closing resources
    // automatically.

    // In order to use a try-with-resources, include an instance of a class
    // in the try statement. The class must implement java.lang.AutoCloseable.
    try (BufferedReader br = new BufferedReader(new FileReader("foo.txt"))) {
      // You can attempt to do something that could throw an exception.
      System.out.println(br.readLine());
      // In Java 7, the resource will always be closed, even if it throws
      // an Exception.
    } catch (Exception ex) {
      //The resource will be closed before the catch statement executes.
      System.out.printf("readLine() failed. %s", ex);
    }
    // No need for a finally statement in this case, the BufferedReader is
    // already closed. This can be used to avoid certain edge cases where
    // a finally statement might not be called.
    // To learn more:
    // https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html

    // Conditional Shorthand
    // You can use the '?' operator for quick assignments or logic forks.
    // Reads as "If (statement) is true, use <first value>, otherwise, use
    // <second value>"
    int foo = 5;
    String bar = (foo < 10) ? "A" : "B";
    System.out.println("bar : " + bar); // Prints "bar : A", because the statement is true.
    System.out.println("bar : " + (foo < 10 ? "A" : "B"));

    ////////////////////////////////////////
    // Converting Data Types
    ////////////////////////////////////////

    // Converting data

    // Convert String To Integer
    Integer.parseInt("123");//returns an integer version of "123"

    // Convert Integer To String
    Integer.toString(123);//returns a string version of 123

    // For other conversions check out the following classes:
    // Double
    // Long
    // String

    System.out.println(COUNTRIES);
  }

  // Double Brace Initialization
  // The Java Language has no syntax for how to create static Collections
  // in an easy way. Usually you end up in the following way:
  private static final Set<String> COUNTRIES = new HashSet<String>();

  static {
    COUNTRIES.add("DENMARK");
    COUNTRIES.add("SWEDEN");
    COUNTRIES.add("FINLAND");
  }

  // But there's a nifty way to achieve the same thing in an
  // easier way, by using something that is called Double Brace
  // Initialization.
  private static final Set<String> COUNTRIES2 = new HashSet<String>() {{
    add("DENMARK");
    add("SWEDEN");
    add("FINLAND");
  }};
  // The first brace is creating a new AnonymousInnerClass and the
  // second one declares an instance initializer block. This block
  // is called when the anonymous inner class is created.
  // This does not only work for Collections, it works for all
  // non-final classes.
}

