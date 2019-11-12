// Final Classes

// Final Class declaration syntax
// <access-level> final <final-class-name> {
//     // Constants and variables
//     // Method declarations
// }

// Final classes are classes that cannot be inherited from and are therefore a
// final child. In a way, final classes are the opposite of abstract classes
// because abstract classes must be extended, but final classes cannot be
// extended.

final class SaberToothedCat extends Animal {
  // Note still have to override the abstract methods in the
  // abstract class.
  @Override
  public void makeSound() {
    System.out.println("Roar");
  }
}

// Final Methods
abstract class Mammal {
  // Final Method Syntax:
  // <access modifier> final <return type> <function name>(<args>)

  // Final methods, like, final classes cannot be overridden by a child
  // class, and are therefore the final implementation of the method.
  public final boolean isWarmBlooded() {
    return true;
  }
}

public class FinalClass {
  public static void main(String[] args) {
    System.out.println("FinalClass.main");

    Animal cat_instance = new SaberToothedCat();
    cat_instance.makeSound();

    // Mammal mammal_instance = new Mammal();
  }
}
