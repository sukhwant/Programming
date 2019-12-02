
public class Fish extends Animal {

    @Override
    public void walk() {
        System.out.println("Swiming....");
    }

    @Override
    public void makeSound() {
        System.out.println("Fish is making Sound..");
    }

    @Override
    public void run() {
        System.out.println("Swiming fast...");
    }
}
