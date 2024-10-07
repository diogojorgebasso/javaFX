
# GUI JavaFX TD - Intro

## TD - Software Engineering
### Author: Cédric Zanni

### Objective
The objective of this session is mainly to get acquainted with the management of graphical interfaces in Java using the JavaFX library.

### Graphical Interface in Java
We will use the JavaFX library to manage our graphical interface. To get familiar with it, follow the tutorial up to the section "Styling the UI with CSS" (we won't focus on that part which aims to improve the appearance of the generated interface).

Link to the tutorial: https://www.jetbrains.com/help/idea/developing-a-javafx-application-examples.html

For those compiling from the command line, instructions for compiling and executing JavaFX code can be found here:
https://openjfx.io/openjfx-docs/#install-javafx

Once you have completed the tutorial, can you make a connection with the Model-View-Controller (MVC) pattern presented at the end of the course? Answer to check at the end of the file before continuing the exercise!

### Implementation of a Drawing Interface

To get familiar with JavaFX and FXML, we will implement a minimalist drawing interface featuring a color selection mechanism and a canvas for drawing (see screenshot below).

#### Step 1
Start by adding a **Canvas** (for drawing) and a **Button** (to reset the image). To control the layout of elements in your interface, you can use the following Layouts: **BorderPane**, **GridPane**, **VBox**, **HBox**, ...

Example of a BorderPane:
```xml
<BorderPane>
    <top> fxml elements </top>
    <left> fxml elements </left>
    <center> fxml elements </center>
    <right> fxml elements </right>
    <bottom> fxml elements </bottom>
</BorderPane>
```
The zones associated with a layout are accessible in the documentation: https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html

To add a button:
```xml
<Button text="Clear image" layoutX="26.0" layoutY="32.0" onAction="#clearImage" />
```

For a canvas:
```xml
<Canvas fx:id="canvasColorPick" layoutX="4.0" layoutY="4.0" width="80" height="80" />
```

For a label (if you want to test your layout):
```xml
<Label text="Red"/>
```

#### Step 2
Implement the **clearImage** method to reset the canvas color. Use the following code to get the **GraphicsContext** associated with the Canvas, specify the color to use, and call the drawing method:
```java
GraphicsContext gc = canvas.getGraphicsContext2D();
gc.setFill(Color.WHITE);
gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
```

#### Step 3: Mouse Event - Drawing Points on Mouse Clicks
To handle mouse interactions, register an **EventHandler** in one of the graphical elements, such as:
```java
EventHandler<MouseEvent> drawEventHandler = new EventHandler<javafx.scene.input.MouseEvent>() {
    @Override
    public void handle(javafx.scene.input.MouseEvent e) {
        // 1. Access the controller's private element (canvas)
        // 2. Get the click position: e.getX(), e.getY()
    }
};
canvas.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, drawEventHandler);
```

#### Step 4: Slider and Listeners - Implementing a Color Selector
JavaFX uses the **Observable** pattern to handle user interactions with certain graphical elements. For example, the **Slider** class stores its current value in a **DoubleProperty** object, and you can register listeners to react to value changes:
```java
sliderColorR.valueProperty().addListener((observable, oldValue, newValue) -> {
    // Lambda can capture local scope, such as the controller in our case
});
```

To add a slider:
```xml
<Slider fx:id="sliderAttributName" blockIncrement="1" majorTickUnit="50" min="1" max="255" value="0" minorTickCount="1" showTickLabels="true" showTickMarks="true" />
```

### FXML
For more insights into FXML, refer to this document: [Introducing FXML](http://fxexperience.com/wp-content/uploads/2011/08/Introducing-FXML.pdf)

### Useful Information
To complete this project successfully, consult the following documentation:
- https://docs.oracle.com/javase/8/docs/api/
- https://docs.oracle.com/javase/8/javafx/api/toc.htm
