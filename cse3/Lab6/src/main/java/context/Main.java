package context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class, View.class, Controller.class);

        Model.Plate model = context.getBean(Model.ClassicPlate.class);
        model.setName("name744");
        model.setColor("green");
        model.setDiameter(13);
        model.setCapacity(4);
        View view = context.getBean(View.class);
        Controller ctrl = context.getBean(Controller.class, model, view);
        ctrl.useView();

        // Command
        System.out.println("---");
        Controller.Command getDcm = context.getBean(Controller.getDiameterCmd.class, model);
        Controller.Invoker inv1 = context.getBean(Controller.Invoker.class, getDcm);
        System.out.println("diamCmd: " + inv1.getDiameterInv());

        // Proxy
        System.out.println("---");
        Model.IPlate plpr = context.getBean(Controller.Proxy.class, model);
        System.out.println(plpr.height(model.getCapacity(), model.getDiameter()));
        System.out.println(plpr.height(-5, -1));
        System.out.println(plpr.short_desc(model.getCapacity()));

        // Strategy
        System.out.println("---");
        System.out.println(model.instruction());
        ApplicationContext context2 =
                new AnnotationConfigApplicationContext(Config2.class);
        Model.Plate model2 = context2.getBean(Model.DeepPlate.class);
        System.out.println(model2.instruction());

        // Decorator
//        System.out.println("---");
//        ApplicationContext context3 =
//                new AnnotationConfigApplicationContext(Model.class);
//        Model.IPlate cup = context3.getBean(Model.BullionPlate.class, model);
//        System.out.println(cup.short_desc(cup.getCapacity()));
//        Model.IPlate pot = context3.getBean(Model.SaladPlate.class, cup);
//        System.out.println(pot.short_desc(pot.getCapacity()));

    }
}
