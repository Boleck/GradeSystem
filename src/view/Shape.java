package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class Shape {
    double x;
    double y;
    double width;
    double height;

    public Shape(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public void draw(Canvas canvas) {
        canvas.getGraphicsContext2D().fillRect(getX(),getY(),getWidth(),getHeight());
    }
}
