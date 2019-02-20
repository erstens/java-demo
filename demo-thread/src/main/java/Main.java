public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println();
//        for(int i = 0 ;i < 10 ; i ++ ) {
//            int finalI = i;
//            Runnable r = () -> new Machine(finalI).say();
//            Thread t = new Thread(r);
//            t.start();
//        }
        System.out.println();
        System.out.println(-1 << 29);
        System.out.println(0 << 29);
        System.out.println(1 << 29);
        System.out.println(2 << 29);
        System.out.println(3 << 29);
        System.out.println(Integer.toBinaryString(-1 << 29));
        System.out.println(Integer.toBinaryString(0 << 29));
        System.out.println(Integer.toBinaryString(1 << 29));
        System.out.println(Integer.toBinaryString(2 << 29));
        System.out.println(Integer.toBinaryString(3 << 29));
        System.out.println();
        System.out.println(1|2);
        System.out.println(0|2);
        System.out.println();
        System.out.println(~0b01);
    }
}
