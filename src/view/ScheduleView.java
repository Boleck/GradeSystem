package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import models.ActivityEntity;
import utils.Utils;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class ScheduleView{
    private final double day;
    private final double duration;
    private final double offsetTop;
    private final double planHeight;
    private  double offset;
    private double width;
    private double height;
    private Canvas canvas;
    private List<Shape> shapes = new ArrayList<>();

    public ScheduleView(double width, double height, Canvas canvas){
        this.width = width;
        this.height = height;
        this.offset = width * 0.10;
        this.offsetTop = height * 0.05;
        this.planHeight =  height - offsetTop;
        double days = width * 0.90;
        this.day = days / 5;
        this.canvas = canvas;
        this.duration = planHeight / 40;
        //7:00 - 17:00 - 10h - 40 x 15 min

        GraphicsContext gc = canvas.getGraphicsContext2D();



        gc.setFill(Color.BLUE);
        gc.setLineWidth(1);
        gc.setStroke(Color.LIGHTGREY);
        for (int i = 0; i <=5; i++) {
            gc.beginPath();
            double start = offset + (i * day);
            gc.moveTo(start,offsetTop);
            gc.lineTo(start,planHeight);
            gc.stroke();

            RectangleShapeWithText week = new RectangleShapeWithText(start,0,day,offsetTop, DayOfWeek.of(i+1).name(),"",Color.WHITE);
            week.draw(canvas);
            for (int j = 0; j < 40; j++) {
                gc.setLineWidth(0.3);
                if (j % 4 == 0){
                    gc.setLineWidth(1);
                    int timeStart = 7+(j*15)/60;
                    RectangleShapeWithText shape = new RectangleShapeWithText(0,j*duration + offsetTop,offset,4*duration,"test",timeStart + ":00",Color.WHITE);
                    shape.draw(canvas);

                }
                gc.beginPath();
                gc.moveTo(0,j * duration + offsetTop);
                gc.lineTo(width,j * duration + offsetTop);
                gc.stroke();



            }
        }
        canvas.getGraphicsContext2D().setFill(Color.WHITE);

        //shapes.add(shape);
        //drawShape();

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
        Color newColor = new Color(0.98431372f, 0.98823529f,0.72941176f, 1);
        RectangleShapeWithText shape = new RectangleShapeWithText(activity.getDay()*day + offset,(activity.getBeginHour()-7)*4*duration + offsetTop,day,(activity.getDuration()/15)*duration,"czesc","turringi",newColor);
        //shapes.add(shape);
        //drawShape();
        shape.draw(canvas);
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
