package duoxiancheng;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: xk
 * @Date: 2018/9/15
 * @Version 1.0
 */
public class OutOfTime {
    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();
//        timer.schedule(new ThrowTask(), 1);
//        SECONDS.sleep(1);
        timer.schedule(new ThrowTask(), 1);
//        SECONDS.sleep(5);//mian线程sleep了5秒
    }

    static class ThrowTask extends TimerTask {
        @Override
        public void run() {
            throw new RuntimeException();
        }
    }
}
