package context;

import org.springframework.stereotype.Component;

@Component
public class View {
    public void print(String name, String color, int diameter, int capacity) {
        System.out.println("All attributes");
        System.out.println("Dishware: name - " + name + ", color - " + color);
        System.out.println("Plate: diameter - " + diameter + ", capacity - " + capacity);
    }
}