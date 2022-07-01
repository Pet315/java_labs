package dishes;

public class Dishware {
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
        return "name - " + name + ", color - " + color;
    }
}
