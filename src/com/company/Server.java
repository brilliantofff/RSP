package src.com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static src.com.company.Player.registerPlayer;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081);
        Socket input = serverSocket.accept();
        Scanner in = new Scanner(input.getInputStream());
        PrintWriter out = new PrintWriter(input.getOutputStream(), true);
        boolean flag = true;
        while (!serverSocket.isClosed()) {
            if (input.isConnected()) {
                Player player = registerPlayer(in, out);
                Game game = new Game(out, player, flag);
                game.startGame();
            }
        }
        out.close();
        in.close();
        input.close();
        serverSocket.close();
    }
}
