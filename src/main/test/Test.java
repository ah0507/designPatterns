import com.chensee.thread.thread2.MyFutureTask;
import com.chensee.thread.thread2.UserBehaviorDataDTO;

public class Test {

    private MyFutureTask myFutureTask = new MyFutureTask();

    @org.junit.Test
    public void aaa(){
        System.out.println("UserController的线程:" + Thread.currentThread());
        long begin = System.currentTimeMillis();
        UserBehaviorDataDTO userAggregatedResult = myFutureTask.getUserAggregatedResult(1111111111L);
        System.out.println(userAggregatedResult);
        long end = System.currentTimeMillis();
        System.out.println("===============总耗时:" + (end - begin) /1000.0000+ "秒");
    }

}
