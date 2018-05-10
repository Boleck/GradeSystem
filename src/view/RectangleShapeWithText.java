package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class RectangleShapeWithText extends Shape {
    private Color color;
    private String textCenter;
    private String textTopLeft = "witam pana";

    public RectangleShapeWithText(double x, double y, double w, double h) {
        super(x, y, w, h);
    }


    public RectangleShapeWithText(double x, double y, double w, double h, String textCenter, String textTopLeft) {
        super(x, y, w, h);
        this.textCenter = textCenter;
        this.textTopLeft = textTopLeft;
    }

    public RectangleShapeWithText(double x, double y, double w, double h, String textCenter, String textTopLeft, Color color) {
        this(x, y, w, h, textCenter, textTopLeft);
        this.color = color;
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.getGraphicsContext2D().setFill(color);
        super.draw(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.GRAY);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(textTopLeft,x,y+10,width);
        gc.setFill(Color.BLACK);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText(textCenter,x+width/2,y +5 + height/2,width);
       //gc.
        //gc.fillText("Text",getX()+5,getY()+1);
    }
}
