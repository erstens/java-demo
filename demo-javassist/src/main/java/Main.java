import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> c = Class.forName("Entity");
        Object o = c.newInstance();
        Method m = c.getDeclaredMethod("test", null);
        m.setAccessible(true);
        m.invoke(o, null);
    }
}
