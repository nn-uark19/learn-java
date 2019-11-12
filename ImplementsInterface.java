// Interfaces
// Interface declaration syntax
// <access-level> interface <interface-name> extends <super-interfaces> {
//     // Constants
//     // Method declarations
// }

// Example - Food:
interface Edible {
  public void eat();
  // Any class that implements this interface, must
  // implement this method.
}

interface Digestible {
  public void digest();
  // Since Java 8, interfaces can have default method.
  public default void defaultMethod() {
    System.out.println("Hi from default method ...");
  }
}

// We can now create a class that implements both of these interfaces.
class Fruit implements Edible, Digestible {
  @Override
  public void eat() {
    System.out.println("Fruit.eat");
  }

  @Override
  public void digest() {
    System.out.println("Fruit.digest");
  }
}

public class ImplementsInterface {
  public static void main(String[] args) {
    System.out.println("ImplementsInterface.main");
    Fruit fruit_instant = new Fruit();
    fruit_instant.digest();
    fruit_instant.eat();
  }
}
