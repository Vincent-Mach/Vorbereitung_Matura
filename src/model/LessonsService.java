package model;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.util.List;

public class LessonsService extends Service<String> {
    private List<Unterricht> unterrichtList;

    public LessonsService(List<Unterricht> unterrichtList) {
        this.unterrichtList = unterrichtList;
    }

    public LessonsService(){};

    public void setUnterrichtList(List<Unterricht> unterrichtList) {
        this.unterrichtList = unterrichtList;
    }

    @Override
    protected Task<String> createTask() {
        return new LessonsTask(this.unterrichtList);
    }

}
