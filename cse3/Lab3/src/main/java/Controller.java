public class Controller {
    private Plate model;
    private View view;

    public Controller(Plate model, View view) {
        this.model = model;
        this.view = view;
    }

    public String getDNameCtrl() {
        return model.getDName();
    }

    public String getColorCtrl() {
        return model.getColor();
    }

    public int getDiameterCtrl() {
        return model.getDiameter();
    }

    public int getCapacityCtrl() {
        return model.getCapacity();
    }

    public void setNameCtrl(String name) {
        model.setName(name);
    }

    public void setColorCtrl(String color) {
        model.setColor(color);
    }

    public void setDiameterCtrl(int diameter) {
        model.setDiameter(diameter);
    }

    public void setCapacityCtrl(int capacity) {
        model.setCapacity(capacity);
    }

    public String associationsCtrl() { return  model.associations("red"); }

    public double heightCtrl() { return model.height(6, 21); }

    public boolean diameterEnoughCtrl() { return model.diameterEnough(21); }

    public boolean capacityEnoughCtrl() { return model.capacityEnough(6); }

    public String shortdescCtrl() { return model.short_desc(6);}

    public void useView() {
        view.print(model.getDName(), model.getColor(), model.getDiameter(), model.getCapacity());
    }
}
