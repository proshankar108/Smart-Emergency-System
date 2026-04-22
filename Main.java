// ABSTRACTION
abstract class EmergencySystem {
    abstract void checkStatus(Person driver, int speed, boolean suddenBrake, boolean crash);
}

// ENCAPSULATION
class Person {
    String name;
    int id;
    String bloodGroup;
    String emergencyContact;
    String location;

    Person(String name, int id, String bloodGroup, String emergencyContact, String location) {
        this.name = name;
        this.id = id;
        this.bloodGroup = bloodGroup;
        this.emergencyContact = emergencyContact;
        this.location = location;
    }
}

// POLYMORPHISM (METHOD OVERLOADING)
class Alert {

    void send(String type, String message) {
        System.out.println("[" + type + "] " + message);
    }

    void send(String type, String name, String blood, String location, String contact) {
        System.out.println("[" + type + "] " + "Patient: " + name + " | Blood Group: " + blood + " | Emergency No: " + contact + " | Location: " + location);
    }

    void sendPolice(String name, String location, String contact) {
        System.out.println("[POLICE] Victim: " + name + " | Location: " + location + " | Emergency No: " + contact);
    }
}

// INHERITANCE
class SmartEmergencySystem extends EmergencySystem {

    void checkStatus(Person driver, int speed, boolean suddenBrake, boolean crash) {

        Alert alert = new Alert();

        System.out.println("==========================================");
        System.out.println("   Bachai - Smart Emergency Savior");
        System.out.println("==========================================\n");

        int risk = 0;

        if (speed > 80) risk += 2;
        if (suddenBrake) risk += 2;
        if (crash) risk += 3;

        if (risk >= 4 || crash) {

            // POLICE
            alert.sendPolice(driver.name, driver.location, driver.emergencyContact);

            // AMBULANCE
            alert.send("AMBULANCE", driver.name, driver.bloodGroup, driver.location, driver.emergencyContact);

            // FAMILY
            alert.send("FAMILY", "Update: " + driver.name + " had an accident at " + driver.location);

        }
        else {
            System.out.println("Status Normal");
        }
    }
}

// MAIN CLASS
public class Main {
    public static void main(String[] args) {

        Person driver = new Person("Shibshankar Mondal", 243, "A+", "01765650826", "Khilgaon, Dhaka");

        SmartEmergencySystem system = new SmartEmergencySystem();

        int speed = 95;
        boolean suddenBrake = true;
        boolean crash = true;
        system.checkStatus(driver, speed, suddenBrake, crash);
    }
}