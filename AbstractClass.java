// Abstract Classes

// Abstract Class declaration syntax
// <access-level> abstract class <abstract-class-name> extends
// <super-abstract-classes> {
//     // Constants and variables
//     // Method declarations
// }

// Abstract Classes cannot be instantiated.
// Abstract classes may define abstract methods.
// Abstract methods have no body and are marked abstract
// Non-abstract child classes must @Override all abstract methods from their super-classes.
// Abstract classes can be useful when combining repetitive logic
// with customised behavior, but as Abstract classes require
// inheritance, they violate "Composition over inheritance"
// so consider other approaches using composition.
// https://en.wikipedia.org/wiki/Composition_over_inheritance

abstract class Animal {
  private int age;

  public abstract void makeSound();

  // Method can have a body
  public void eat() {
    System.out.println("I am an animal and I am Eating.");
    // Note: We can access private variable here.
    age = 30;
  }

  public void printAge() {
    System.out.println(age);
  }
}

class Dog extends Animal {
  // Note still have to override the abstract methods in the abstract class.
  @Override
  public void makeSound() {
    System.out.println("Bark");
    // age = 30;    ==> ERROR!    age is private to Animal
  }
}

// Final Classes

// Final Class declaration syntax
// <access-level> final <final-class-name> {
//     // Constants and variables
//     // Method declarations
// }

public class AbstractClass {
  public static void main(String[] args) {
    System.out.println("AbstractClass.main");
    Dog pluto = new Dog();
    pluto.makeSound();
    pluto.eat();
    pluto.printAge();
  }
}