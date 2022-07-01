import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Noted
public class Plate extends Dishware implements ProxyPl.IPlate {

    private int diameter, capacity;

    @Noted
    public int getDiameter() {
        return diameter;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Plate(String name, String color, int diameter, int capacity) {
        super(name,color);
        this.setDiameter(diameter);
        this.setCapacity(capacity);
    }

    @Noted
    public String short_desc() {
        return super.getDName() + " - " + getCapacity() + " ml";
    }

    @Noted
    public String associations() {
        return switch (super.getColor()) {
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

    @Override
    public String toString() {
        return super.toString() + ", diameter - " + diameter + ", capacity - " + capacity;
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Plate obj1 = new Plate("plate1","white", 21, 6);

        for (Method method : Plate.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Noted.class)) {
                System.out.println("method_name: " + method.getName() + ", message: " + method.invoke(obj1));
            }
        }
    }
}