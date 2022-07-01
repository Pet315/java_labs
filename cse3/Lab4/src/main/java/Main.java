public class Main {
    public static void main(String[] args) {
        Model.Plate model = new Model.ClassicPlate();
        model.setName("name744");;
        model.setColor("green");
        model.setDiameter(13);
        model.setCapacity(4);
        View view = new View();
        Controller ctrl = new Controller(model, view);
        ctrl.useView();

        // Command
        System.out.println("---");
        Controller.Command getDcm = new Controller.getDiameterCmd(model);
        Controller.Invoker inv1 = new Controller.Invoker(getDcm);
        System.out.println("diamCmd: " + inv1.getDiameterInv());

        // Proxy
        System.out.println("---");
        Model.IPlate plpr = new Controller.Proxy(model);
        System.out.println(plpr.height(model.getCapacity(), model.getDiameter()));
        System.out.println(plpr.height(-5, -1));
        System.out.println(plpr.short_desc(model.getCapacity()));

        // Decorator
        System.out.println("---");
        Model.IPlate cup = new Model.BullionPlate(model);
        Model.IPlate pot = new Model.SaladPlate(cup);
        System.out.println(cup.short_desc(cup.getCapacity()));
        System.out.println(pot.short_desc(pot.getCapacity()));

        // Strategy
        System.out.println("---");
        System.out.println(model.instruction());
        Model.Plate model2 = new Model.DeepPlate();
        System.out.println(model2.instruction());

    }
}
