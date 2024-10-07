
# GUI JavaFX Project

This project is a minimalistic drawing interface implemented using JavaFX. The project allows users to select colors and draw on a canvas. It follows the Model-View-Controller (MVC) pattern.

## Requirements

To run this project, you will need to install the following:

- **Java Development Kit (JDK)** version 8 or later
- **JavaFX SDK** (if you're using a JDK version lower than 11)
- An **IDE** such as IntelliJ IDEA or Eclipse, or alternatively, you can compile and run the project from the command line.

## Installation

### 1. Install Java Development Kit (JDK)
Make sure that you have JDK 8 or later installed on your system. If you don’t have it installed, download and install the latest version from:
- [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html) (for JDK 8)
- [OpenJDK](https://jdk.java.net/)

### 2. Install JavaFX
If you are using JDK versions 9 or higher, you might need to install JavaFX separately. Follow these steps:

1. Download the JavaFX SDK from [OpenJFX](https://openjfx.io/).
2. Extract the SDK and set the `PATH_TO_FX` environment variable pointing to the extracted folder.

### 3. Set up the JavaFX libraries

#### If you're using IntelliJ IDEA:
- Open your project and navigate to **File** > **Project Structure**.
- Select **Modules**, then click **Dependencies**.
- Click **+** and add the path to your JavaFX SDK `lib` directory.
- Add the following VM options to your **Run Configuration**:
  ```
  --module-path PATH_TO_FX --add-modules javafx.controls,javafx.fxml
  ```

#### If you're using the command line:
For compiling:
```bash
javac --module-path PATH_TO_FX --add-modules javafx.controls,javafx.fxml YourApp.java
```

For running:
```bash
java --module-path PATH_TO_FX --add-modules javafx.controls,javafx.fxml YourApp
```

### 4. Clone and Run the Project

1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```

2. Navigate to the project directory:
   ```bash
   cd <project-directory>
   ```

3. Compile and run the project as described above.

## Usage

- Open the application.
- Use the color sliders to select a color.
- Draw on the canvas using your mouse.
- Reset the canvas by clicking the "Clear Image" button.

## Additional Resources

- [JavaFX Documentation](https://openjfx.io/openjfx-docs/)
- [Oracle JDK Documentation](https://docs.oracle.com/en/java/)
