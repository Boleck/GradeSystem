package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import models.ActivityEntity;

import java.util.ArrayList;
import java.util.List;

public class ScheduleView{
    private final double day;
    private final double duration;
    private  double offset;
    private double width;
    private double height;
    private Canvas canvas;
    private List<Shape> shapes = new ArrayList<>();

    public ScheduleView(double width, double height, Canvas canvas){
        this.width = width;
        this.height = height;
        this.offset = width * 0.10;
        double days = width * 0.90;
        this.day = days / 5;
        this.canvas = canvas;
        this.duration = height / 40;
        //7:00 - 17:00 - 10h - 40 x 15 min


        //10% + 90%/5
//        //Todo: settings from database - when first and last lesson
//        gridPane = new GridPane();
//        //draw basic stuff, like vertical lines between days, colors etc.
//        gridPane.setHgap(10);
//        gridPane.setVgap(10);
//        //gc.drawImage();
//        gridPane.
        

        //drawShape();


        //stworz
        //gc.fillRect();
    }

    private void drawShape() {
        //GraphicsContext gc = canvas.getGraphicsContext2D();
        for(int i = 0; i < shapes.size(); i++){
            Shape shape = shapes.get(i);
            shape.draw(canvas);
        }
    }

    public void addActivitySubject(ActivityEntity activity){
        RectangleSubject shape = new RectangleSubject(activity.getDay()*day + offset,(activity.getBeginHour()-7)*4*duration,day,(activity.getDuration()/15)*duration);
        shapes.add(shape);
        drawShape();
    }

    private int getXByDay(int day){
        return 0;
    }
    private int getYByTime(int hour, int minutes){
        return 0;
    }
    private int getHByDuration(int duration){
        return 0;
    }
}
