package demo;

public class Cuckoo extends Animal{

    public Cuckoo(String name) {
        super(name);
    }
    public void makeSound() {
        System.out.println("Cuckoooo");
    }
    public void flyAway() {
        System.out.println("I was offended. Goodbye!");
    }

}
