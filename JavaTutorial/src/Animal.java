import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Animal {

    private String name;
    private String color;
    private int age;

    protected int country;
    public int numberOfLegs;

    public abstract void walk();

    public abstract void makeSound();

    public abstract void run();
}
