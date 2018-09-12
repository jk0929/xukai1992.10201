package duoxiancheng;

/**
 * @Author: xk
 * @Date: 2018/9/10
 * @Version 1.0
 */
public class CountingSheep {
    volatile boolean asleep;

    void tryToSleep() {
        while (!asleep)
            countSomeSheep();
    }

    void countSomeSheep() {//数绵羊
        // One, two, three...
        System.out.println(124);
    }

    public static void main(String[] args)throws InterruptedException{
        CountingSheep sheep = new CountingSheep();
        sheep.asleep = false;
        new Thread(new Runnable() {
            @Override
            public void run() {
                sheep.asleep = true;
            }
        }).start();
        sheep.tryToSleep();
        Thread.sleep(2000);
    }
}
