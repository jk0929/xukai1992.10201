package duoxiancheng;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: xk
 * @Date: 2018/9/15
 * @Version 1.0
 */
public class SingleThreadWebServer  {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Socket connection = socket.accept();
            handleRequest(connection);
        }
    }

    private static void handleRequest(Socket connection) {
        // request-handling logic here
    }
}
