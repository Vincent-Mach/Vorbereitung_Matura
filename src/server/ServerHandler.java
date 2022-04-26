package server;

import model.Unterricht;
import server.DAO.UnterrichtDAO;
import server.DAO.UnterrichtDAOImpl;
import server.Database.DatabaseConnection;
import server.Database.DatabaseHandler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerHandler {
    List<Unterricht> unterrichtList;
    String serverResponse;
    UnterrichtDAO unterrichtDAO;

    public void getClient(Socket socket) {
        try(DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()))){

            System.out.println("Server: Try to get data form inputstream...");

            System.out.println("Server: Got Data from Inputstream");
            unterrichtList = (List<Unterricht>) in.readObject();
            System.out.println(unterrichtList);

            if (unterrichtList != null){
                System.out.println("Server: Give Data to DBHandler");
                unterrichtDAO = new UnterrichtDAOImpl(new DatabaseConnection("./lessons.properties"));
                unterrichtDAO.setLessons(unterrichtList);
            }
            this.serverResponse = "OK";
            out.writeUTF(this.serverResponse);
            out.flush();

        }catch(Exception e){
            System.out.println("Something wrong with Server");
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
