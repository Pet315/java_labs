import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class UsingReflection {
    public static void main(String[] args) {
        Class<Dishware> class1 = Dishware.class;
        Class<Plate> class2 = Plate.class;

        //task3
        System.out.println("class1: " + class1.getName() + ", class2: " + class2.getName());

        //task3-2
        System.out.println("\nlist of methods:");
        for (Method method : class1.getDeclaredMethods()) {
            System.out.println(method);
        }
        for (Method method : class2.getDeclaredMethods()) {
            System.out.println(method);
        }

        //task3-6
        int mod1 = class1.getModifiers();
        System.out.println("\nmodifier\nclass1: " + Modifier.toString(mod1));
        if (Modifier.isPrivate(mod1)) { System.out.println("private"); }
        if (Modifier.isPublic(mod1)) { System.out.println("public"); }

        Class<ProxyPl.SomeProxy> class3 = ProxyPl.SomeProxy.class;
        int mod3 = class3.getModifiers();
        System.out.println("class3: " + Modifier.toString(class3.getModifiers()));
        if (Modifier.isStatic(mod3)) { System.out.println("static"); }
    }
}


//        Dishware obj3 = new Dishware("plate3", "yellow");
//        Plate obj4 = new Plate("plate4", "blue", 29, 4);