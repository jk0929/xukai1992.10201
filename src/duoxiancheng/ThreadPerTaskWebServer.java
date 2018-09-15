package duoxiancheng;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: xk
 * @Date: 2018/9/15
 * @Version 1.0
 */
public class ThreadPerTaskWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    handleRequest(connection);
                }
            };
            new Thread(task).start();
        }
    }

    private static void handleRequest(Socket connection) {
        // request-handling logic here
    }
}
