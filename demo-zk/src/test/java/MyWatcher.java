import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public class MyWatcher implements Watcher {
//    private MyWatcher myWatcher ;
//    public MyWatcher(MyWatcher m) {
//        this.myWatcher = m ;
//    }
    public void process(WatchedEvent event) {
//        if (event.getState() == Event.KeeperState.SyncConnected) {
//            // 放开闸门, wait在connect方法上的线程将被唤醒
//            connectedSignal.countDown();
//        }
    }
}
