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


        ActivityEntity a2 = new ActivityEntity();
        a2.setGroupId("7GGs332p");
        a2.setBeginHour(16);
        a2.setBeginMinutes(30);
        a2.setDay(2);
        a2.setDuration(45);
        a2.setRoomId("e12Sd");
        a2.setSubjectId("asdqw");
        a2.setTeacherId("3rqd");

        ActivityEntity a3 = new ActivityEntity();
        a3.setBeginHour(12);
        a3.setBeginMinutes(0);
        a3.setDay(1);
        a3.setDuration(30);

        ScheduleView sv = new ScheduleView(canvas.getWidth(),canvas.getHeight(),canvas);
        sv.addActivitySubject(a);
        sv.addActivitySubject(a2);
        sv.addActivitySubject(a3);





    }
}
