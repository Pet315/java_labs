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

    public Dishware(String name, String color) {
        this.setName(name);
        this.setColor(color);
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

    @Override
    public String toString()  {
        return "Dishware: name - " + name + ", color - " + color;
    }
}
