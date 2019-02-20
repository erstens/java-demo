import com.demo.calc.SizeOfObject;
import com.demo.entity.ObjectEmpty;
import com.demo.entity.ObjectInteger;
import com.demo.entity.ObjectLong;

public class Main {
    public static void main(String[] args) {
        System.out.println("ObjectLong size " + SizeOfObject.sizeOf(new ObjectLong()));
        System.out.println("ObjectInteger size " + SizeOfObject.sizeOf(new ObjectInteger()));
        System.out.println("ObjectEmpty size " + SizeOfObject.sizeOf(new ObjectEmpty()));
    }
}
