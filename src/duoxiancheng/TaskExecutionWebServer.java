package duoxiancheng;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Author: xk
 * @Date: 2018/9/15
 * @Version 1.0
 */
public class TaskExecutionWebServer {
    private static final int NTHREADS = 100;
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    handleRequest(connection);
                }
            });
        }
    }

    private static void handleRequest(Socket connection) {
        // request-handling logic here
    }
}
