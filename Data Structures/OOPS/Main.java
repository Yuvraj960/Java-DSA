import java.util.*;

// ============================================================================
// 1. CLASS AND OBJECT CONCEPTS
// ============================================================================

/**
 * Basic class demonstrating class and object concepts
 * A class is a blueprint for creating objects
 */

class Student {
    // Instance variables (attributes/properties)
    private String name;
    private int age;
    private String studentId;
    
    // Static variable (belongs to class, not instance)
    private static int totalStudents = 0;
    
    // Default constructor (non-parameterized)
    public Student() {
        this.name = "Unknown";
        this.age = 0;
        this.studentId = "STU000";
        totalStudents++;
        System.out.println("Default constructor called");
    }
    
    // Parameterized constructor
    public Student(String name, int age, String studentId) {
        this.name = name;  // 'this' keyword refers to current object
        this.age = age;
        this.studentId = studentId;
        totalStudents++;
        System.out.println("Parameterized constructor called for: " + this.name);
    }
    
    // Copy constructor
    public Student(Student other) {
        this.name = other.name;
        this.age = other.age;
        this.studentId = other.studentId + "_COPY";
        totalStudents++;
        System.out.println("Copy constructor called for: " + this.name);
    }
    
    // Method demonstrating 'this' keyword
    public void displayInfo() {
        System.out.println("Student Info:");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("ID: " + this.studentId);
    }
    
    // Method with parameter having same name as instance variable
    public void setName(String name) {
        this.name = name;  // 'this.name' refers to instance variable
                          // 'name' refers to parameter
    }
    
    // Static method
    public static int getTotalStudents() {
        return totalStudents;
    }
    
    // Getters and setters for encapsulation
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getStudentId() { return studentId; }
    
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
}

// ============================================================================
// 2. INHERITANCE CONCEPTS
// ============================================================================

// Base class for inheritance
class Person {
    protected String name;
    protected int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void displayPersonInfo() {
        System.out.println("Person: " + name + ", Age: " + age);
    }
    
    // Method to be overridden
    public void introduce() {
        System.out.println("Hi, I'm " + name);
    }
}

// Single Inheritance: Student extends Person
class StudentExtended extends Person {
    private String course;
    
    public StudentExtended(String name, int age, String course) {
        super(name, age);  // Call parent constructor
        this.course = course;
    }
    
    @Override
    public void introduce() {
        System.out.println("Hi, I'm " + name + " and I study " + course);
    }
    
    public void study() {
        System.out.println(name + " is studying " + course);
    }
}

// Multilevel Inheritance: GraduateStudent extends StudentExtended
class GraduateStudent extends StudentExtended {
    private String researchArea;
    
    public GraduateStudent(String name, int age, String course, String researchArea) {
        super(name, age, course);
        this.researchArea = researchArea;
    }
    
    @Override
    public void introduce() {
        System.out.println("Hi, I'm " + name + ", a graduate student researching " + researchArea);
    }
    
    public void doResearch() {
        System.out.println(name + " is researching " + researchArea);
    }
}

// Hierarchical Inheritance: Teacher also extends Person
class Teacher extends Person {
    private String subject;
    
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    
    @Override
    public void introduce() {
        System.out.println("Hi, I'm " + name + " and I teach " + subject);
    }
    
    public void teach() {
        System.out.println(name + " is teaching " + subject);
    }
}

// ============================================================================
// 3. POLYMORPHISM CONCEPTS
// ============================================================================

// Compile-time Polymorphism (Method Overloading)
class Calculator {
    // Method overloading - same method name, different parameters
    public int add(int a, int b) {
        return a + b;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    
    public String add(String a, String b) {
        return a + b;
    }
}

// Runtime Polymorphism (Method Overriding)
abstract class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract void makeSound();
    
    // Concrete method
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}

// ============================================================================
// 4. ENCAPSULATION CONCEPTS
// ============================================================================

class BankAccount {
    // Private variables - data hiding
    private String accountNumber;
    private double balance;
    private String ownerName;
    
    // Constructor
    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }
    
    // Public methods to access private data
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds");
        }
    }
    
    // Getter methods
    public double getBalance() {
        return balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getOwnerName() {
        return ownerName;
    }
    
    // No setter for balance - it can only be changed through deposit/withdraw
}

// ============================================================================
// 5. ABSTRACTION CONCEPTS
// ============================================================================

// Abstract class example
abstract class Shape {
    protected String color;
    
    public Shape(String color) {
        this.color = color;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract double calculateArea();
    
    // Concrete method
    public void displayColor() {
        System.out.println("Color: " + color);
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double calculateArea() {
        return length * width;
    }
}

// ============================================================================
// 6. INTERFACE CONCEPTS
// ============================================================================

// Interface for flying capability
interface Flyable {
    // All methods in interface are public and abstract by default
    void fly();
    
    // Default method (Java 8+)
    default void land() {
        System.out.println("Landing...");
    }
    
    // Static method (Java 8+)
    static void checkWeather() {
        System.out.println("Checking weather conditions for flight");
    }
}

// Interface for swimming capability
interface Swimmable {
    void swim();
    
    default void dive() {
        System.out.println("Diving...");
    }
}

// Multiple inheritance through interfaces
class Duck implements Flyable, Swimmable {
    private String name;
    
    public Duck(String name) {
        this.name = name;
    }
    
    @Override
    public void fly() {
        System.out.println(name + " is flying");
    }
    
    @Override
    public void swim() {
        System.out.println(name + " is swimming");
    }
    
    public void quack() {
        System.out.println(name + " says: Quack!");
    }
}

// Interface extending another interface
interface Drawable {
    void draw();
}

interface Colorable extends Drawable {
    void setColor(String color);
}

class ColoredCircle implements Colorable {
    private String color;
    
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
    
    @Override
    public void setColor(String color) {
        this.color = color;
        System.out.println("Circle color set to: " + color);
    }
}

// ============================================================================
// 7. ACCESS MODIFIERS DEMONSTRATION
// ============================================================================

class AccessModifierDemo {
    // Public - accessible from anywhere
    public String publicVariable = "Public Variable";
    
    // Private - accessible only within same class
    private String privateVariable = "Private Variable";
    
    // Protected - accessible within same package and subclasses
    protected String protectedVariable = "Protected Variable";
    
    // Default (package-private) - accessible within same package
    String defaultVariable = "Default Variable";
    
    // Public method
    public void publicMethod() {
        System.out.println("Public method called");
    }
    
    // Private method
    private void privateMethod() {
        System.out.println("Private method called");
    }
    
    // Protected method
    protected void protectedMethod() {
        System.out.println("Protected method called");
    }
    
    // Default method
    void defaultMethod() {
        System.out.println("Default method called");
    }
    
    // Method to access private variable from within class
    public void accessPrivateVariable() {
        System.out.println("Accessing private variable: " + privateVariable);
        privateMethod(); // Can call private method from within class
    }
}

// ============================================================================
// 8. MAIN CLASS - DEMONSTRATION
// ============================================================================

public class Main {
    public static void main(String[] args) {
        System.out.println("=== JAVA OOP CONCEPTS DEMONSTRATION ===\n");
        
        // 1. CLASS AND OBJECT DEMONSTRATION
        System.out.println("1. CLASS AND OBJECT CONCEPTS:");
        System.out.println("------------------------------");
        
        // Creating objects using different constructors
        Student student1 = new Student(); // Default constructor
        Student student2 = new Student("Alice", 20, "STU001"); // Parameterized constructor
        Student student3 = new Student(student2); // Copy constructor
        
        student1.displayInfo();
        student2.displayInfo();
        student3.displayInfo();
        
        System.out.println("Total students: " + Student.getTotalStudents());
        
        // 2. INHERITANCE DEMONSTRATION
        System.out.println("\n2. INHERITANCE CONCEPTS:");
        System.out.println("-------------------------");
        
        // Single inheritance
        StudentExtended student4 = new StudentExtended("Bob", 19, "Computer Science");
        student4.displayPersonInfo();
        student4.introduce();
        student4.study();
        
        // Multilevel inheritance
        GraduateStudent gradStudent = new GraduateStudent("Carol", 25, "AI", "Machine Learning");
        gradStudent.displayPersonInfo();
        gradStudent.introduce();
        gradStudent.doResearch();
        
        // Hierarchical inheritance
        Teacher teacher = new Teacher("Dr. Smith", 35, "Mathematics");
        teacher.displayPersonInfo();
        teacher.introduce();
        teacher.teach();
        
        // 3. POLYMORPHISM DEMONSTRATION
        System.out.println("\n3. POLYMORPHISM CONCEPTS:");
        System.out.println("--------------------------");
        
        // Compile-time polymorphism (Method Overloading)
        Calculator calc = new Calculator();
        System.out.println("Add integers: " + calc.add(5, 3));
        System.out.println("Add doubles: " + calc.add(5.5, 3.2));
        System.out.println("Add three integers: " + calc.add(1, 2, 3));
        System.out.println("Add strings: " + calc.add("Hello", " World"));
        
        // Runtime polymorphism (Method Overriding)
        Animal[] animals = {new Dog("Buddy"), new Cat("Whiskers")};
        for (Animal animal : animals) {
            animal.makeSound(); // Polymorphic call
            animal.sleep();
        }
        
        // 4. ENCAPSULATION DEMONSTRATION
        System.out.println("\n4. ENCAPSULATION CONCEPTS:");
        System.out.println("---------------------------");
        
        BankAccount account = new BankAccount("ACC123", "John Doe", 1000.0);
        System.out.println("Account: " + account.getAccountNumber() + 
                          ", Owner: " + account.getOwnerName() + 
                          ", Balance: $" + account.getBalance());
        
        account.deposit(500.0);
        account.withdraw(200.0);
        System.out.println("Final balance: $" + account.getBalance());
        
        // 5. ABSTRACTION DEMONSTRATION
        System.out.println("\n5. ABSTRACTION CONCEPTS:");
        System.out.println("-------------------------");
        
        Shape circle = new Circle("Red", 5.0);
        Shape rectangle = new Rectangle("Blue", 4.0, 6.0);
        
        circle.displayColor();
        System.out.println("Circle area: " + circle.calculateArea());
        
        rectangle.displayColor();
        System.out.println("Rectangle area: " + rectangle.calculateArea());
        
        // 6. INTERFACE DEMONSTRATION
        System.out.println("\n6. INTERFACE CONCEPTS:");
        System.out.println("-----------------------");
        
        Duck duck = new Duck("Donald");
        duck.fly();     // From Flyable interface
        duck.swim();    // From Swimmable interface
        duck.quack();   // Duck's own method
        duck.land();    // Default method from Flyable
        duck.dive();    // Default method from Swimmable
        
        Flyable.checkWeather(); // Static method from interface
        
        // Interface extending another interface
        ColoredCircle coloredCircle = new ColoredCircle();
        coloredCircle.draw();
        coloredCircle.setColor("Green");
        
        // 7. ACCESS MODIFIERS DEMONSTRATION
        System.out.println("\n7. ACCESS MODIFIERS:");
        System.out.println("---------------------");
        
        AccessModifierDemo demo = new AccessModifierDemo();
        System.out.println("Public variable: " + demo.publicVariable);
        // System.out.println(demo.privateVariable); // This would cause compilation error
        System.out.println("Protected variable: " + demo.protectedVariable);
        System.out.println("Default variable: " + demo.defaultVariable);
        
        demo.publicMethod();
        demo.protectedMethod();
        demo.defaultMethod();
        demo.accessPrivateVariable(); // This method internally accesses private variable
        
        System.out.println("\n=== END OF DEMONSTRATION ===");
    }
}