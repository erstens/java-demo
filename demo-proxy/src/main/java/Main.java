import com.jdk.Body;
import com.jdk.BodyImpl;
import com.jdk.MyProxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        MyProxy p = new MyProxy(new BodyImpl()) ;
        Body b = (Body)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Body.class}, p);
        b.say();
        assert 1 == 2 :"=====================";
    }
}
