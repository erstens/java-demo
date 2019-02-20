import com.demo.calc.MemoryCounter;
import com.demo.entity.ObjectEmpty;
import com.demo.entity.ObjectInteger;
import com.demo.entity.ObjectLong;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        System.gc();
        System.out.println("Total memory: " + Runtime.getRuntime().totalMemory());
        System.out.println("Free memory: " + Runtime.getRuntime().freeMemory());
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Used memory current: " + usedMemory);
        MemoryCounter m = new MemoryCounter();
        System.out.println("ObjectLong " + m.estimate(new ObjectLong()));
        System.out.println("ObjectInteger " + m.estimate(new ObjectInteger()));
        System.out.println("ObjectEmpty " + m.estimate(new ObjectEmpty()));



    }
}
