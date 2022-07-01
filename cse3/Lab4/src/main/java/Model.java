import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Model {
    static class Dishware {

        private String name, color;

        public String getDName() {
            return name;
        }

        public String getColor() {
            return color;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setColor(String color) {
            this.color = color;
        }

//    public Dishware(String name, String color) {
//        this.setName(name);
//        this.setColor(color);
//    }

        @Override
        public String toString()  {
            return "Dishware: name - " + name + ", color - " + color;
        }
    }

    interface IPlate {
        String short_desc(int capacity);
        String instruction();
        int getCapacity();
        double height(int V, int d);
//        String associations(String color);
//        int getDiameter();
//        void setDiameter(int diameter);
//        void setCapacity(int capacity);
//        void setName(String name);
//        void setColor(String color);
//        String getDName();
//        String getColor();
//        boolean diameterEnough(int diameter);
//        boolean capacityEnough(int capacity);
    }

    static class Plate extends Dishware implements IPlate {

        private int diameter, capacity;
        private final IPlate chooseStrategy;
//        private static Plate singleton;

        Plate(IPlate chooseStrategy) {
            this.chooseStrategy = chooseStrategy;
        }

//        public static Plate getInstance() {
//            if (singleton == null) {
//                singleton = new ClassicPlate();
//            }
//            return singleton;
//        }

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

        public boolean diameterEnough(int diameter) {
            return diameter > 15;
        }

        public boolean capacityEnough(int capacity) {
            return capacity > 2;
        }

        public String short_desc(int capacity) {
            return "dishes - " + capacity + " ml";
        }

        public String instruction() {
            return this.chooseStrategy.instruction();
        }

        @Override
        public String toString() {
            return super.toString() + ", diameter - " + diameter + ", capacity - " + capacity;
        }
    }

    // gof-pattern: Decorator

    static class Decorator implements IPlate {
        Model.IPlate pl;
        int cap;

        public Decorator(Model.IPlate pl, int cap) {
            this.pl = pl;
            this.cap = cap;
        }

        @Override
        public String short_desc(int capacity) {
            return pl.short_desc(capacity + pl.getCapacity());
        }

        @Override
        public int getCapacity() {
            return cap;
        }

        @Override
        public double height(int V, int d) {
            return pl.height(V, d);
        }

        @Override
        public String instruction() {
            return pl.instruction();
        }

    }

    static class BullionPlate extends Decorator {
        public BullionPlate(IPlate pl) {
            super(pl, 250);
        }
    }

    static class SaladPlate extends Decorator {
        public SaladPlate(IPlate pl) {
            super(pl, 500);
        }
    }

    // gof-pattern: Strategy

    static class ClassicPlateStr implements IPlate {
        Model.IPlate pl;

        @Override
        public String instruction() {
            return "Use it for eating solid food";
        }

        @Override
        public String short_desc(int capacity) {
            return pl.short_desc(capacity);
        }

        @Override
        public int getCapacity() {
            return pl.getCapacity();
        }

        @Override
        public double height(int V, int d) {
            return pl.height(V, d);
        }

    }

    static class ClassicPlate extends Plate {
        public ClassicPlate() {
            super(new ClassicPlateStr());
        }
    }

    static class DeepPlateStr implements IPlate {
        Model.IPlate pl;

        @Override
        public String instruction() {
            return "Use it for eating liquid food";
        }

        @Override
        public String short_desc(int capacity) {
            return pl.short_desc(capacity);
        }

        @Override
        public int getCapacity() {
            return pl.getCapacity();
        }

        @Override
        public double height(int V, int d) {
            return pl.height(V, d);
        }

    }

    static class DeepPlate extends Plate {
        public DeepPlate() {
            super(new DeepPlateStr());
        }
    }

}
