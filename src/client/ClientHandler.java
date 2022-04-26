package client;

import model.Unterricht;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientHandler {
    String serverResponse;

    public void sendServer(Socket socket, List<Unterricht> unterrichtList){
        System.out.println("HAAAAAAAAAAAAAAAAAAAAA");
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()))){

            System.out.println("Client: Try to send Data to Server");

            if (unterrichtList != null) {
                out.writeObject(unterrichtList);
                out.flush();
            }else {
                this.serverResponse = "Empty Array of Data, Pleas check !";
            }

            this.serverResponse = in.readUTF();

            System.out.println("Client: " + this.serverResponse);
            //in.close();

        }catch(Exception e){
            System.out.println("Something wrong with Client");
            System.out.println(e);
            e.printStackTrace();
            this.serverResponse = "Error";
            //return this.serverResponse;
        }
        //return this.serverResponse;
    }

    public String getServerResponse() {
        return serverResponse;
    }
}
