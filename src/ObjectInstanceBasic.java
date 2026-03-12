/**
 * Object Instances: new keyword, heap memory, instance vs class members.
 */
public class ObjectInstanceBasic {

    static class Person {
        // Instance variables — each object gets its own copy
        String name;
        int    age;
        String email;

        // Class (static) variable — shared by ALL Person objects
        static int totalPeople = 0;

        Person(String name, int age, String email) {
            this.name  = name;
            this.age   = age;
            this.email = email;
            totalPeople++;    // incremented for every new Person
        }

        void greet() {
            System.out.printf("Hi! I'm %s, age %d. Reach me at %s%n", name, age, email);
        }

        boolean isAdult() { return age >= 18; }

        // Static method — belongs to class, not instance
        static void showCount() {
            System.out.println("Total people created: " + totalPeople);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Creating Object Instances ===");

        // new keyword: allocates memory on heap, calls constructor
        Person p1 = new Person("Alice", 25, "alice@example.com");
        Person p2 = new Person("Bob",   17, "bob@example.com");
        Person p3 = new Person("Carol", 30, "carol@example.com");

        System.out.println("3 objects created. Each has its OWN data:");
        p1.greet();
        p2.greet();
        p3.greet();

        // Instance methods called on each object
        System.out.println("\n=== Instance Method Calls ===");
        System.out.println(p1.name + " is adult: " + p1.isAdult());
        System.out.println(p2.name + " is adult: " + p2.isAdult());

        // Static variable is shared
        System.out.println("\n=== Static (Class) Variable ===");
        Person.showCount();

        // null reference
        System.out.println("\n=== Null Reference ===");
        Person nobody = null;
        System.out.println("nobody == null: " + (nobody == null));
        System.out.println("p1     == null: " + (p1 == null));

        // Object comparison
        System.out.println("\n=== Object Identity ===");
        Person copy = p1;  // both point to same object
        System.out.println("copy == p1: " + (copy == p1) + " (same object in memory)");
        System.out.println("p1   == p2: " + (p1   == p2) + " (different objects)");
    }
}
