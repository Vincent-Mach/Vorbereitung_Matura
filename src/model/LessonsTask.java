package model;

import client.ClientMain;
import javafx.concurrent.Task;

import java.util.List;

public class LessonsTask extends Task<String> {
    private List<Unterricht> unterrichtList;
    ClientMain client;

    public LessonsTask(List<Unterricht> unterrichtList) {
        this.unterrichtList = unterrichtList;
    }

    @Override
    protected String call() throws Exception {
        client = new ClientMain();

        System.out.println("Send Server Task");
        client.createSocket();

        return  client.sendServer(this.unterrichtList);
    }

}
