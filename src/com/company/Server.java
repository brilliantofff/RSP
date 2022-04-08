package src.com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081);
        while (!serverSocket.isClosed()) {
            Socket input = serverSocket.accept();
            Thread thread = new Thread(new Player(input));
            thread.start();
        }
        serverSocket.close();
    }
}