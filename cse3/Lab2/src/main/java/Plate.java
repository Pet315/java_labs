import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.Math.PI;
import static java.lang.Math.pow;


public class Plate extends Dishware implements ProxyPl.IPlate {

    private int diameter, capacity;

    public int getDiameter() {
        return diameter;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setDiameter(int diameter) {
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
    public String diameterEnough(int diameter) {
        if (diameter >= 15) {
            return "Everything is okay.";
        } else {
            return null;
        }
    }

    public boolean capacityEnough(int capacity) {
        return capacity > 2;
    }

    @Noted
    public double height(int V, int d) {
        return 4 * V / PI * pow(d, 2);
    }

    @Noted
    public String short_desc(int capacity) {
        return super.getDName() + " - " + capacity + " ml";
    }

    @Noted
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