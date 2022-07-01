public class Main {
    public static void main(String[] args) {
        Plate model = new Plate();
        model.setName("name744");;
        model.setColor("green");
        model.setDiameter(13);
        model.setCapacity(4);
        View view = new View();
        Controller ctrl = new Controller(model, view);
        ctrl.useView();
    }
}
