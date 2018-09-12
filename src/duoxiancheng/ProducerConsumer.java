package duoxiancheng;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: xk
 * @Date: 2018/9/12
 * @Version 1.0
 */
public class ProducerConsumer {

    static class FileCrawler implements Runnable {//生产者
        private final BlockingQueue<File> fileQueue;
        private final FileFilter fileFilter;
        private final File root;

        public FileCrawler(BlockingQueue<File> fileQueue,
                           final FileFilter fileFilter,
                           File root) {
            this.fileQueue = fileQueue;
            this.root = root;
            this.fileFilter = new FileFilter() {
                public boolean accept(File f) {
                    return f.isDirectory() || fileFilter.accept(f);
                }
            };
        }

        private boolean alreadyIndexed(File f) {
            return false;
        }

        @Override
        public void run() {
            try {
                crawl(root);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();//中断
            }
        }

        private void crawl(File root) throws InterruptedException {
            File[] entries = root.listFiles(fileFilter);
            if (entries != null) {
                for (File entry : entries)
                    if (entry.isDirectory())
                        crawl(entry);//迭代循环
                    else if (!alreadyIndexed(entry))
                        fileQueue.put(entry);
            }
        }
    }

    static class Indexer implements Runnable {//消费者
        private final BlockingQueue<File> queue;

        public Indexer(BlockingQueue<File> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true)
                    indexFile(queue.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        public void indexFile(File file) {
            // Index the file...
        };
    }

    private static final int BOUND = 10;
    private static final int N_CONSUMERS = Runtime.getRuntime().availableProcessors();

    public static void startIndexing(File[] roots) {
        BlockingQueue<File> queue = new LinkedBlockingQueue<File>(BOUND);
        FileFilter filter = new FileFilter() {
            public boolean accept(File file) {
                return true;
            }
        };

        for (File root : roots)
            new Thread(new FileCrawler(queue, filter, root)).start();

        for (int i = 0; i < N_CONSUMERS; i++)
            new Thread(new Indexer(queue)).start();
    }
}
