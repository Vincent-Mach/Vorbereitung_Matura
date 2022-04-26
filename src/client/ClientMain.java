package client;

import model.Unterricht;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class ClientMain {
    Socket socket;
    ClientHandler clientHandler;

    public void createSocket() throws IOException {
        System.out.println("Client: Create Socket");
        this.socket = new Socket("localhost",2000);
    }

    public Socket getSocket() {
        return socket;
    }

    public String sendServer(List<Unterricht> unterrichtList){
        clientHandler = new ClientHandler();
        System.out.println("Client: Send to Server");
        clientHandler.sendServer(this.socket, unterrichtList);
        return clientHandler.getServerResponse();
    }
}
