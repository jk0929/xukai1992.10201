package duoxiancheng;

/**
 * @Author: xk
 * @Date: 2018/8/17
 * @Version 1.0
 */
public class demo1 {
    private static final int THREADNUM = 5;//线程数量
    public static void main(String[] args){
        //线程数量
        int threadmax = THREADNUM;
//        for(int i = 0; i < threadmax; i++) {
//            ThreadMode thread = new ThreadMode();
//            thread.getThread().start();
//        }
        for (int i=0;i<5;i++){
            Thread thread = new ThreadMode();
            thread.start();
        }
    }
}
 class ThreadMode extends Thread{//继承thread
    public Thread getThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i < 10 ; i++)
                {
                    System.out.print("\nout:"+i);
                }
            }
        });
        return thread;
    }

    @Override
    public void run(){
        for (int i=0;i<5;i++){
            System.out.println("线程:"+i);
        }
    }

}
