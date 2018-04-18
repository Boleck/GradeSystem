package controllers;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import models.ActivityEntity;
import models.SubjectModel;


public class HubStageController {
    public Canvas canvas;
    @FXML
    public void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.fillRect(75,75,100,100);
        //sample Subj
        ActivityEntity a = new ActivityEntity();
        a.setGroupId("7GGs332p");
        a.setBegin(new int[]{8,0});
        a.setDay(0);
        a.setDuration(45);
        a.setRoomId("e12Sd");
        a.setSubjectId("asdqw");
        a.setTeacherId("3rqd");





    }
}
