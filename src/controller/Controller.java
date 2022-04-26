package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Main main;
    private String filename;
    private CsvConverter csvConverter;
    private LessonsService lessonsService;
    private List<Unterricht> unterrichtList;

    @FXML
    private Button buttonConvert;

    @FXML
    private Text textTitle;

    @FXML
    private Text textFieldServerResponse;

    @FXML
    private Label labelServerResponse;

    @FXML
    private TextArea textAreaData;

    @FXML
    private Button buttonSendServer;

    @FXML
    void doConvert(MouseEvent event) {
        try {
            filename = main.getFile().getName();
            System.out.println(filename);
            unterrichtList = CsvConverter.readLessionsFromCSV(filename);
            buttonSendServer.setDisable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        textAreaData.setText(unterrichtList.toString());
    }

    @FXML
    void doSendServer(MouseEvent event) {
        System.out.println("Send server");
        System.out.println(unterrichtList);
        buttonConvert.setDisable(true);
        if (unterrichtList != null) {
            lessonsService.setUnterrichtList(unterrichtList);
        }
        lessonsService.restart();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textAreaData.clear();
        textFieldServerResponse.setText("");
        buttonSendServer.setDisable(true);

        main = new Main();
        csvConverter = new CsvConverter();
        lessonsService = new LessonsService();
        filename = "";

        lessonsService.setOnSucceeded(event -> {
            this.textFieldServerResponse.setText(this.lessonsService.getValue());
        });

        lessonsService.setOnFailed(event -> {
            this.textFieldServerResponse.setText("An error accured while tying to send the data");
        });
    }
}

