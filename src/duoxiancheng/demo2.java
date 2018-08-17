package duoxiancheng;

/**
 * @Author: xk
 * @Date: 2018/8/17
 * @Version 1.0
 */
public class demo2 {
    public static void main(String[] args){
        for (int i=0;i<5;i++){
            ThreadFactory.getThread().start();
        }
    }
}
class ThreadFactory{
    public static Thread getThread(){
        Thread thread = new Thread(new Runnable() {//实现runable接口
            @Override
            public void run() {
                for (int i =1;i<5;i++){
                    System.out.println("线程："+i);
                }
            }
        });
        return thread;
    }
}
