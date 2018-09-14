package duoxiancheng;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: xk
 * @Date: 2018/9/12
 * @Version 1.0
 */
public class Preloader {
    ProductInfo loadProductInfo() //用于载入数据产品信息的方法
            throws DataLoadException {
        System.out.println("数据正在加载中...");
        System.out.println("数据正在加载完毕！");
        return null;
    }

    private final FutureTask<ProductInfo> future =
            new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
                @Override
                public ProductInfo call() throws DataLoadException {
                    return loadProductInfo();
                }
            });

    private final Thread thread = new Thread(future);

    public void start() { thread.start(); }

    public ProductInfo get() //当调用get方法时，如果数据已经加载完成时，则返回数据；
            //如果数据没有加载完成，则处于阻塞状态，等待数据加载完成之后返回
            throws DataLoadException, InterruptedException {
        try {
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof DataLoadException)
                throw (DataLoadException) cause;
            else
                throw LaunderThrowable.launderThrowable(cause);
        }
    }

    interface ProductInfo {
    }
}
class DataLoadException extends Exception { }
