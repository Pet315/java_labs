package context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {

    private final Model.Plate model;
    private final View view;

    @Autowired
    public Controller(Model.Plate model, View view) {
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

    public String namedshortdescCtrl() { return model.instruction();}

    public void useView() {
        view.print(model.getDName(), model.getColor(), model.getDiameter(), model.getCapacity());
    }

    public interface Command{
        int execute();
    }

//    @Component
    public static class getDiameterCmd implements Command {
        private final Model.Plate getDpl;
        public getDiameterCmd(Model.Plate getDpl) {
            this.getDpl=getDpl;
        }
        public int execute() {
            return getDpl.getDiameter();
        }
    }

//    @Component
    public static class Invoker {
        private final Command getDcm;
        public Invoker(Command getDcm) {
            this.getDcm = getDcm;
        }
        public int getDiameterInv() {
            return getDcm.execute();
        }
    }

    @Component
    static class Proxy implements Model.IPlate {

        Model.IPlate pl;

        @Autowired
        public Proxy(Model.IPlate pl) {
            this.pl = pl;
        }

        @Override
        public double height(int V, int d) {
            if (V < 0) {
                System.out.println("Incorrect variable V");
                return 0;
            } else if (d < 0) {
                System.out.println("Incorrect variable d");
                return 0;
            }
            System.out.println("Formula for function height(d,V): 4 * V / PI * pow(d, 2)");
            return pl.height(V, d);
        }

        @Override
        public String short_desc(int capacity) {
            return pl.short_desc(capacity);
        }

        @Override
        public String instruction() {
            return pl.instruction();
        }

        @Override
        public int getCapacity() {
            return pl.getCapacity();
        }
    }

}