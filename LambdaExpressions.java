// Getting Started with Lambda Expressions
//
// New to Java version 8 are lambda expressions. Lambdas are more commonly found
// in functional programming languages, which means they are methods which can
// be created without belonging to a class, passed around as if it were itself
// an object, and executed on demand.
//
// Final note, lambdas must implement a functional interface.
// A functional interface is one which has only a single abstract method declared.
// It can have any number of default methods.
// Lambda expressions can be used as an instance of that functional interface.
// Any interface meeting the requirements is treated as a functional interface.
// You can read more about interfaces above.

import java.util.Map;
import java.util.HashMap;
import java.util.function.*;
import java.security.SecureRandom;

public class LambdaExpressions {
  public static void main(String[] args) {
    System.out.println("LambdaExpressions.main");
    // Lambda declaration syntax:
    // <zero or more parameters> -> <expression body or statement block>

    // We will use this hashmap in our examples below.
    Map<String, String> planets = new HashMap<>();
    planets.put("Mercury", "87.969");
    planets.put("Venus", "224.7");
    planets.put("Earth", "365.2564");
    planets.put("Mars", "687");
    planets.put("Jupiter", "4,332.59");
    planets.put("Saturn", "10,759");
    planets.put("Uranus", "30,688.5");
    planets.put("Neptune", "60,182");

    // Lambda with zero parameters using the Supplier functional interface
    // from java.util.function.Supplier. The actual lambda expression is
    // what comes after numPlanets =.
    Supplier<String> numPlanets = () -> Integer.toString(planets.size());
    System.out.format("Number of Planets: %s\n\n", numPlanets.get());

    // Lambda with one parameter and using the Consumer functional interface
    // from java.util.function.Consumer. This is because planets is a Map,
    // which implements both Collection and Iterable. The forEach used here,
    // found in Iterable, applies the lambda expression to each member of
    // the Collection. The default implementation of forEach behaves as if:
    /*
        for (T t : this)
            action.accept(t);
    */

    // The actual lambda expression is the parameter passed to forEach.
    planets.keySet().forEach((p) -> System.out.format("%s\n", p));
    System.out.println();

    // If you are only passing a single argument, then the above can also be
    // written as (note absent parentheses around p):
    planets.keySet().forEach(p -> System.out.format("%s\n", p));
    System.out.println();

    // Tracing the above, we see that planets is a HashMap, keySet() returns
    // a Set of its keys, forEach applies each element as the lambda
    // expression of: (parameter p) -> System.out.format("%s\n", p). Each
    // time, the element is said to be "consumed" and the statement(s)
    // referred to in the lambda body is applied. Remember the lambda body
    // is what comes after the ->.

    // The above without use of lambdas would look more traditionally like:
    for (String planet : planets.keySet()) {
      System.out.format("%s\n", planet);
    }
    System.out.println();

    // This example differs from the above in that a different forEach
    // implementation is used: the forEach found in the HashMap class
    // implementing the Map interface. This forEach accepts a BiConsumer,
    // which generically speaking is a fancy way of saying it handles
    // the Set of each Key -> Value pairs. This default implementation
    // behaves as if:
        /*
            for (Map.Entry<K, V> entry : map.entrySet())
                action.accept(entry.getKey(), entry.getValue());
        */

    // The actual lambda expression is the parameter passed to forEach.
    String orbits = "%s orbits the Sun in %s Earth days.\n";
    planets.forEach((K, V) -> System.out.format(orbits, K, V));
    System.out.println();

    // The above without use of lambdas would look more traditionally like:
    for (String planet : planets.keySet()) {
      System.out.format(orbits, planet, planets.get(planet));
    }
    System.out.println();

    // Or, if following more closely the specification provided by the
    // default implementation:
    for (Map.Entry<String, String> planet : planets.entrySet()) {
      System.out.format(orbits, planet.getKey(), planet.getValue());
    }

    // These examples cover only the very basic use of lambdas. It might not
    // seem like much or even very useful, but remember that a lambda can be
    // created as an object that can later be passed as parameters to other
    // methods.
  }
}
