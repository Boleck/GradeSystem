package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RectangleSubject extends Shape {
    public RectangleSubject(double x, double y, double w, double h) {
        super(x, y, w, h);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setCo
        gc.fillText("Text",getX()+5,getY()+1);
    }
}
