import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyPl {
    public interface IPlate {
        int getDiameter();
        void setDiameter(int diameter);
        int getCapacity();
        void setCapacity(int capacity);
        String short_desc(int capacity);
    }

    static class SomeProxy implements InvocationHandler {
        private final IPlate plate;
        public SomeProxy(Plate plate) {
            this.plate = plate;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().startsWith("get")) {
                throw new IllegalAccessException("Not allowed 'getters'");
            }
            return method.invoke(plate, args);
        }
    }

    public static void main(String[] args) {
        Plate obj2 = new Plate("plate2","red", 18, 3);

        IPlate proxy = (IPlate) Proxy.newProxyInstance(obj2.getClass().getClassLoader(),
                obj2.getClass().getInterfaces(), new SomeProxy(obj2));

        System.out.println(proxy.short_desc(3)); // error
        System.out.println(proxy.getCapacity()); // error
    }
}
