// You can include other, non-public outer-level classes in a .java file,
// but it is not good practice. Instead split classes into separate files.

// Class Declaration Syntax:
// <public/private/protected> class <class name> {
//    // data fields, constructors, functions all inside.
//    // functions are called as methods in Java.
// }
class Bicycle {
  // Bicycle's Fields/Variables
  public int cadence; // Public: Can be accessed from anywhere
  private int speed;  // Private: Only accessible from within the class
  protected int gear; // Protected: Accessible from the class and subclasses
  String name; // default: Only accessible from within this package
  static String className; // Static class variable

  // Static block
  // Java has no implementation of static constructors, but
  // has a static block that can be used to initialize class variables
  // (static variables).
  // This block will be called when the class is loaded.
  static {
    System.out.println("Bicycle.static initializer");
    className = "Bicycle";
  }

  // Constructors are a way of creating classes
  // This is a constructor
  public Bicycle() {
    // You can also call another constructor:
    // this(1, 50, 5, "Bontrager");
    System.out.println("Bicycle.Bicycle- no arguments");
    gear = 1;
    cadence = 50;
    speed = 5;
    name = "Bontrager";
  }
  // This is a constructor that takes arguments
  public Bicycle(int startCadence, int startSpeed, int startGear,
                 String name) {
    System.out.println("Bicycle.Bicycle- has arguments");
    this.gear = startGear;
    this.cadence = startCadence;
    this.speed = startSpeed;
    this.name = name;
  }

  // Method Syntax:
  // <public/private/protected> <return type> <function name>(<args>)

  // Java classes often implement getters and setters for their fields

  // Method declaration syntax:
  // <access modifier> <return type> <method name>(<args>)
  public int getCadence() {
    return cadence;
  }

  // void methods require no return statement
  public void setCadence(int newValue) {
    cadence = newValue;
  }
  public void setGear(int newValue) {
    gear = newValue;
  }
  public void speedUp(int increment) {
    speed += increment;
  }
  public void slowDown(int decrement) {
    speed -= decrement;
  }
  public void setName(String newName) {
    name = newName;
  }
  public String getName() {
    return name;
  }

  //Method to display the attribute values of this Object.
  @Override // Inherited from the Object class.
  public String toString() {
    return "gear: " + gear + " cadence: " + cadence + " speed: " + speed +
        " name: " + name;
  }
} // end class Bicycle


// PennyFarthing is a subclass of Bicycle
class PennyFarthing extends Bicycle {
  // (Penny Farthings are those bicycles with the big front wheel.
  // They have no gears.)

  public PennyFarthing(int startCadence, int startSpeed) {
    // Call the parent constructor with super
    super(startCadence, startSpeed, 0, "PennyFarthing");
    System.out.println("PennyFarthing.PennyFarthing- constructor with arguments");
  }

  // You should mark a method you're overriding with an @annotation.
  // To learn more about what annotations are and their purpose check this
  // out: http://docs.oracle.com/javase/tutorial/java/annotations/
  @Override
  public void setGear(int gear) {
    this.gear = -1;
  }
}

// Object casting
// Since the PennyFarthing class is extending the Bicycle class, we can say
// a PennyFarthing is a Bicycle and write :
// Bicycle bicycle = new PennyFarthing();
// This is called object casting where an object is taken for another one. There
// are lots of details and deals with some more intermediate concepts here:
// https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html

public class ExtendsClass {
  public static void main(String[] args) {
    System.out.println("ExtendsClass.main");
    ///////////////////////////////////////
    // Classes And Functions
    ///////////////////////////////////////
    System.out.println("\n->Classes & Functions");

    // (definition of the Bicycle class follows)

    // Use new to instantiate a class
    Bicycle trek = new Bicycle();

    // Call object methods
    trek.speedUp(3); // You should always use setter and getter methods
    trek.setCadence(100);

    // toString returns this Object's string representation.
    System.out.println("trek info: " + trek.toString());
    System.out.println();

    Bicycle goodBike = new PennyFarthing(40, 2);
    System.out.println(goodBike.toString());
    goodBike.setGear(2);  // call methods of Extended class
    System.out.println(goodBike.toString());
  }
}