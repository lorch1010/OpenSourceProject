package basic;
import java.io.File;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import utilities.Container;
import utilities.ScriptController;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.effect.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;



public class Window extends Application{
    private Container container;

    // Declare global variables
    Button startButton;
    Button exitButton;
    Stage theStage;
    Scene theScene;


    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage){
        // Initialize theStage to primaryStage first
        theStage = primaryStage;

        // Set the stage title to "School Memories"
        primaryStage.setTitle("School Memories");
        primaryStage.setWidth(1280);
        primaryStage.setHeight(720);

        // Root setup
        Group root = new Group();

        // Canvas initialization
        Canvas canvas = new Canvas(1280, 720);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Read image file
        Image bg = new Image(new File("resources/backgrounds/schoolBuilding.jpg").toURI().toString(),
                1280, 720, false, false);

        // Draw the background
        gc.drawImage(bg, 0, 0);

        // Setup and draw the main title
        gc.setFill(Color.RED);
        gc.setStroke(Color.ORANGERED);
        gc.setLineWidth(2);
        Font theFont = Font.font("Ubuntu", FontWeight.BOLD, 60);
        gc.setFont(theFont);
        gc.fillText("School Memories", 425, 200);
        gc.strokeText("School Memories", 425, 200);

        // Create a vbox to store different buttons
        VBox vbox = new VBox(20);  // spacing = 20
        vbox.setLayoutX(600);
        vbox.setLayoutY(385);
        vbox.setAlignment(Pos.BOTTOM_CENTER);

        // Create the button "Start Game"
        startButton = setButton("Start Game");
        startButton.setOnAction(e-> ButtonClicked(e));

        // Create the button "Load Game"
        Button loadButton = setButton("Load Game");

        // Create the button "Settings"
        Button settingsButton = setButton("Settings");

        // Create the button "Credits"
        Button creditsButton = setButton("Credits");

        // Create the button "Exit Game"
        exitButton = setButton("Exit Game");
        exitButton.setOnAction(e-> ButtonClicked(e));

        // Add all the buttons to the vbox just created
        vbox.getChildren().addAll(startButton, loadButton, settingsButton, creditsButton, exitButton);

        // Add the canvas and the vbox to the root
        root.getChildren().addAll(canvas, vbox);

	    /*-------------------------READ THE SCRIPT-----------------------------*/
        //ScriptController sc = new ScriptController("initScript.sc");
        //ScriptController sc = new ScriptController("basicScript.txt");
        ScriptController sc = new ScriptController("resources/scripts/basicStoryline.txt");
	    /*---------------------------------------------------------------------------*/


        // Scenes setup
        Scene startScene = new Scene(root);
        startScene.getStylesheets().add("buttonStyle.css");
        primaryStage.setScene(startScene);

        // Create a canvas for all other CGs
        Canvas cgCanvas = new Canvas(1280, 720);
        GraphicsContext cgGC = cgCanvas.getGraphicsContext2D();
        // Draw initial background after the game starts
        Image initBackground = new Image(new File("resources/backgrounds/schoolPlayground.jpg").toURI().toString(),
                1280, 720, false, true);

        cgGC.drawImage(initBackground, 0, 0);

        container = new Container(sc, cgCanvas);
        theScene = new Scene(container.getSurface());
        theScene.getStylesheets().add("buttonStyle.css");

        primaryStage.show();
    }

    //Set a specific style for a button
    public Button setButton(String buttonName){
        Button result = new Button(buttonName);
        result.setId("lion-default");
        //Choose the bloom effect for the button
        Bloom bloom = new Bloom();

        result.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
            @Override public void handle(MouseEvent e){
                result.setEffect(bloom);
            }
        });
        result.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
            @Override public void handle(MouseEvent e){
                result.setEffect(null);
            }
        });

        return result;

    }

    //Define actions when Start and Exit buttons are pressed
    public void ButtonClicked(ActionEvent e){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText("Do you want to quit the game?");

        if(e.getSource() == startButton){
            container.startup();
            theStage.setScene(theScene);
        }
        if(e.getSource() == exitButton){
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                Platform.exit();
            }
        }
    }

    public void stop(){
        container.shutdown();
    }
}
