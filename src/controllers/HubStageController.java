package controllers;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import models.ActivityEntity;
import models.SubjectModel;
import view.ScheduleView;


public class HubStageController {
    public Canvas canvas;
    public AnchorPane anchorPane;
    @FXML
    public void initialize() {

        GridPane grid = new GridPane();



        anchorPane.getChildren().add(grid);


        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTCORAL);
        //gc.fillRect(75,75,100,100);
        //sample Subj
        ActivityEntity a = new ActivityEntity();
        a.setGroupId("7GGs332p");
        a.setBeginHour(8);
        a.setBeginMinutes(0);
        a.setDay(0);
        a.setDuration(45);
        a.setRoomId("e12Sd");
        a.setSubjectId("asdqw");
        a.setTeacherId("3rqd");

        ScheduleView sv = new ScheduleView(canvas.getWidth(),canvas.getHeight(),canvas);
        sv.addActivitySubject(a);





    }
}
