package duoxiancheng;
/**
 * @Author: xk
 * @Date: 2018/9/10
 * @Version 1.0
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException{
            Thread thread = new ReaderThread();
            thread.start();
            ready = true;
            Thread.sleep(2000);
            //在主线程sleep两秒时候，子线程对于number是不可见的，所以会输出为0；
            number = 42;
    }
}
