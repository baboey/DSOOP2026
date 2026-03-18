public class App {
    public void main() {
        Character Jacob = new Human("Jacob", "M", 23);
        Character Globnar = new Orc("Globnar", "M", 32);
        
        Jacob.getInfo();
        Globnar.getInfo();
    }
}

abstract class Character { // Abstraction
    protected String name; // Encapsulation
    protected String gender;
    protected int age;
    protected String race;
    
    public Character(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
     }
     
    abstract void getInfo();
}

class Human extends Character {
    public Human(String name, String gender, int age) {
        super(name, gender, age);
        this.race = "Human";
    }
    
    @Override // Inheritance
    void getInfo() {
        System.out.println("Hello!" + "\nName: " + name + "\nGender: " + gender + "\nAge: " + age + "\n");
    }
}

class Orc extends Character {
    public Orc(String name, String gender, int age) {
        super(name, gender, age);
        this.race = "Orc";
    }
    
    @Override // Inheritance
    void getInfo() {
        System.out.println("WAAAGH!!" + "\nName: " + name + "\nGender: " + gender + "\nAge: " + age + "\n"); // this is inefficient but I put it here to prove a point about abstracted function 
    }
}
