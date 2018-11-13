package ceshi;

/**
 * @Author: xk
 * @Date: 2018/10/15
 * @Version 1.0
 */
class   demo5 {
    public demo5(){
        System.out.println("hellA");
    }
    {
        System.out.println("hell2");
    }
    static {
        System.out.println("hell3");
    }
}
public class B extends demo5{
    public B(){
        System.out.println(1);
    }
    {
        System.out.println(2);
    }
    static {
        System.out.println(3);
    }
    public static void  main(String[] args){
        new B();
    }
}
