package dishes;

import static java.lang.Math.PI;
import static java.lang.Math.pow;


public class Plate extends Dishware {

    private int id, diameter, capacity;

//    public Plate(String name, String color, int diameter, int capacity) {
//        super(name,color);
//        this.setDiameter(diameter);
//        this.setCapacity(capacity);
//    }

    public int getId() {
        return id;
    }

    public int getDiameter() {
        return diameter;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double height(int V, int d) {
        return (4 * V / PI * pow(d, 2));
    }

    public String associations(String color) {
        return switch (color) {
            case "white" -> "Any food/drink creates a contrast, and therefore looks more attractive";
            case "red", "orange", "yellow" -> "the portion seems too small; you are always tempted to " +
                    "put more on yourself";
            case "grey" -> "calms down, reduces the degree of emotions, motivates to eat/drink for a long " +
                    "time and slowly";
            case "green" -> "improves digestion, soothes, relaxes";
            default -> "designed for people who love surprises and try to surround themselves with " +
                    "unusual objects";
        };
    }

    public boolean diameterEnough(int diameter) { return diameter > 15; }

    public boolean capacityEnough(int capacity) {
        return capacity > 2;
    }

    public String short_desc(int capacity) {
        return super.getDName() + " - " + capacity + " ml";
    }

    @Override
    public String toString() {
        return "id - " + id + ", " + super.toString() + ", diameter - " + diameter + ", capacity - " + capacity;
    }

//    public static void main(String[] args) {
//        Plate obj1 = new Plate("plate1","white", 21, 6);
//        System.out.println(obj1);
//    }
}