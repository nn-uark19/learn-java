
// Enum Type
//
// An enum type is a special data type that enables for a variable to be a set
// of predefined constants. The variable must be equal to one of the values
// that have been predefined for it. Because they are constants, the names of
// an enum type's fields are in uppercase letters. In the Java programming
// language, you define an enum type by using the enum keyword. For example,
// you would specify a days-of-the-week enum type as:
enum Day {
  SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
  THURSDAY, FRIDAY, SATURDAY
}

public class EnumDatatype {
  // Variable Enum
  Day day;

  public EnumDatatype(Day day) {
    this.day = day;
  }

  public void tellItLikeItIs() {
    switch (day) {
      case MONDAY:
        System.out.println("Mondays are bad.");
        break;
      case FRIDAY:
        System.out.println("Fridays are better.");
        break;
      case SATURDAY:
      case SUNDAY:
        System.out.println("Weekends are best.");
        break;
      default:
        System.out.println("Midweek days are so-so.");
        break;
    }
  }

  public static void main(String[] args) {
    System.out.println("EnumDatatype.main");
    EnumDatatype firstDay = new EnumDatatype(Day.MONDAY);
    firstDay.tellItLikeItIs(); // => Mondays are bad.
    EnumDatatype thirdDay = new EnumDatatype(Day.WEDNESDAY);
    thirdDay.tellItLikeItIs(); // => Midweek days are so-so.
  }
}

// Enum types are much more powerful than we show above.
// The enum body can include methods and other fields.
// You can see more at https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html

