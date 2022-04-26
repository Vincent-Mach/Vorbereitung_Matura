package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    static ServerSocket serverSocket;

    public static void createSocket() throws IOException {
        System.out.println("Server trying to connect...");
        serverSocket = new ServerSocket(2000);
    }

    public ServerSocket getServerSocket() {
        return this.serverSocket;
    }

    public static void main(String[] args) {
        System.out.println("Server running...");
        ServerHandler serverHandler = new ServerHandler();
        Socket socket;
        try {
            createSocket();
            socket = serverSocket.accept();
            serverHandler.getClient(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
