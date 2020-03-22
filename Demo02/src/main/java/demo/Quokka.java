package demo;

public class Quokka extends Animal {

    public Quokka(String name) {
        super(name);
    }

    public void smile() {
        System.out.println("Quokka always happy :))))))");
    }
    public void photoWithHuman() {
        smile();
        System.out.println("Click photo");
    }
}
