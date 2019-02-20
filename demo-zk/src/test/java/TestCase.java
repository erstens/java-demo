import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import java.io.IOException;

public class TestCase {

    public String host = "zookeeper:2181";
    public int port = 2181;

    @Test
    public void c() {

        try {
            ZooKeeper zk = new ZooKeeper(host,port,new MyWatcher()) ;

            zk.create("/test/a","abc".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void r() {

        try {
            ZooKeeper zk = new ZooKeeper(host,port,new MyWatcher()) ;
            zk.delete("/test/a", -1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void u() {

        try {
            ZooKeeper zk = new ZooKeeper(host,port,new MyWatcher()) ;
            zk.setData("/test/a", "aaa".getBytes(), -1) ;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void d() {

        try {
            ZooKeeper zk = new ZooKeeper(host,port,new MyWatcher()) ;

            try {
                System.out.println(zk.getChildren("/dubbo", false));
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
