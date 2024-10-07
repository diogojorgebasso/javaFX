package com.org.javafxdemo;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;

public class CanvasController {

    private final int SIZE_CIRCLE = 20;
    private Color color = Color.rgb(0, 0, 0);

    @FXML
    private Canvas canvas;
    @FXML
    private Rectangle colorDisplay;
    @FXML
    private Slider redSlider;
    @FXML
    private Slider greenSlider;
    @FXML
    private Slider blueSlider;

    EventHandler<MouseEvent> drawEventHandler = e -> draw(e.getX(), e.getY());

    private void draw(double x, double y ){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setFill(color);
        gc.setLineWidth(5);
        gc.fillOval(x, y, SIZE_CIRCLE, SIZE_CIRCLE);
    }

    private void updateColor() {
        int red = (int) redSlider.getValue();
        int green = (int) greenSlider.getValue();
        int blue = (int) blueSlider.getValue();

        color = Color.rgb(red, green, blue);

        // Apply the color to the rectangle
        colorDisplay.setFill(color);
    }

    @FXML
    protected void onClearImage() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void initialize(){
        canvas.addEventHandler(MOUSE_CLICKED, drawEventHandler);
        redSlider.valueProperty().addListener((_, _, _) -> updateColor());
        greenSlider.valueProperty().addListener((_, _, _) -> updateColor());
        blueSlider.valueProperty().addListener((_, _, _) -> updateColor());

        updateColor();
    }
}