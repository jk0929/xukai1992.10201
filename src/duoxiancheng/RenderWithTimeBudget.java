package duoxiancheng;

import java.util.concurrent.*;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @Author: xk
 * @Date: 2018/9/16
 * @Version 1.0
 * 设置时间限制
 */
public class RenderWithTimeBudget {
    private static final Ad DEFAULT_AD = new Ad();
    private static final long TIME_BUDGET = 1000;
    private static final ExecutorService exec = Executors.newCachedThreadPool();

    Page renderPageWithAd() throws InterruptedException {
        long endNanos = System.nanoTime() + TIME_BUDGET;
        Future<Ad> f = exec.submit(new FetchAdTask());
        // 在等待广告的同时显示页面
        Page page = renderPageBody();
        Ad ad;
        try {
            // 只等待指定的时间长度
            long timeLeft = endNanos - System.nanoTime();
            ad = f.get(timeLeft, NANOSECONDS);
        } catch (ExecutionException e) {
            ad = DEFAULT_AD;
        } catch (TimeoutException e) {
            ad = DEFAULT_AD;
            f.cancel(true);
        }
        page.setAd(ad);
        return page;
    }

    Page renderPageBody() { return new Page(); }


    static class Ad {
    }

    static class Page {
        public void setAd(Ad ad) { }
    }

    static class FetchAdTask implements Callable<Ad> {
        @Override
        public Ad call() {
            return new Ad();
        }
    }
}
