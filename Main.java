//ABSTRACTION
abstract class EmergencySystem {
    abstract void checkStatus(Person driver, int speed, boolean suddenBrake, boolean crash);
}

//ENCAPSULATION
class Person {
    private String name;
    private int id;
    private String bloodGroup;
    private String emergencyContact;
    private String location;

    Person(String name, int id, String bloodGroup, String emergencyContact, String location) {
        this.name = name;
        this.id = id;
        this.bloodGroup = bloodGroup;
        this.emergencyContact = emergencyContact;
        this.location = location;
    }

    public String getName() { 
        return name; 
    }
    public int getId() { 
        return id; 
    }
    public String getBloodGroup() {
        return bloodGroup;
        }
    public String getEmergencyContact() {
        return emergencyContact; 
        
    }
    public String getLocation() {
        return location; 
    }

    public void setName(String name) { 
        this.name = name; 
    }
    public void setId(int id) {
        this.id = id;
        }
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
        }
    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
        }
    public void setLocation(String location) { 
        this.location = location; 
    }
}

//POLYMORPHISM (OVERLOADING + OVERRIDING)

class Alert {
    void sendAlert(int id, String name, String location, String contact){
        System.out.println("General Alert");
    }
}

//Overriding Example
class PoliceAlert extends Alert {
    @Override
    void sendAlert(int id, String name, String location, String contact) {
        System.out.println("[POLICE] ID: " + id +
                " | Victim: " + name +
                " | Location: " + location +
                " | Emergency No: " + contact);
    }
}

//Overriding Example 
class AmbulanceAlert extends Alert {
    @Override
    void sendAlert(int id, String name, String location, String contact) {
        System.out.println("[AMBULANCE] ID: " + id +
                " | Patient: " + name +
                " | Blood Group: A+ " +
                " | Location: " + location +
                " | Emergency No: " + contact);
    }
}

//Overloading Example 
class FamilyAlert {
    void send(String message) {
        System.out.println("[FAMILY] " + message);
    }

    void send(String name, String location) {
        System.out.println("[FAMILY] Update: " + name + " had an accident at " + location);
    }
}

//INHERITANCE
class SmartEmergencySystem extends EmergencySystem {
    @Override
    void checkStatus(Person driver, int speed, boolean suddenBrake, boolean crash) {

        System.out.println("==========================================");
        System.out.println("   Bachai - Smart Emergency Savior");
        System.out.println("==========================================\n");

        int risk = 0;

        if (speed > 80) risk += 2;
        if (suddenBrake) risk += 2;
        if (crash) risk += 3;

        if (risk >= 4 || crash) {

            Alert police = new PoliceAlert();
            Alert ambulance = new AmbulanceAlert();
            FamilyAlert family = new FamilyAlert();

            // POLICE
            police.sendAlert(
                    driver.getId(),
                    driver.getName(),
                    driver.getLocation(),
                    driver.getEmergencyContact()
            );

            // AMBULANCE
            ambulance.sendAlert(
                    driver.getId(),
                    driver.getName(),
                    driver.getLocation(),
                    driver.getEmergencyContact()
            );

            // FAMILY (Overloading)
            family.send(driver.getName(), driver.getLocation());

        }
        else {
            System.out.println("Status Normal");
        }
    }
}

//MAIN CLASS
public class Main {
    public static void main(String[] args) {

        Person driver = new Person("Shibshankar Mondal", 243, "A+",  "01765650826", "Khilgaon, Dhaka"
        );

        SmartEmergencySystem system = new SmartEmergencySystem();

        int speed = 95;
        boolean suddenBrake = true;
        boolean crash = true;

        system.checkStatus(driver, speed, suddenBrake, crash);
    }
}