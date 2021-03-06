package basic;
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
	
	// declare global variables
	Button startButton;
	Button exitButton;
	Stage theStage;
	Scene theScene;

	public static void main(String[] args){
        launch(args);
	}

	public void start(Stage primaryStage){
        // initialize theStage to primaryStage first
        theStage = primaryStage;
            
        // set the stage title to "School Memories"
        primaryStage.setTitle("School Memories");
	    primaryStage.setWidth(1280);
	    primaryStage.setHeight(720);
	   
	    // roots setup 
	    Group root = new Group();
	    
	    // canvas initializations 
	    Canvas canvas = new Canvas(1280, 720);
	    GraphicsContext gc = canvas.getGraphicsContext2D();
	    
        // read image file
	    Image bg = new Image("schoolBuilding.jpg", 1280, 720, false, false);	
	  
  	    // draw the background image
	    gc.drawImage(bg, 0, 0);	    

        // parameters for the main title
	    gc.setFill(Color.RED);
	    gc.setStroke(Color.ORANGERED);
	    gc.setLineWidth(2);
	    Font theFont = Font.font("Ubuntu", FontWeight.BOLD, 60);
	    gc.setFont(theFont);
	    gc.fillText("School Memories", 425, 200);
	    gc.strokeText("School Memories", 425, 200);

	    // create a vbox to store different buttons
	    VBox vbox = new VBox(20);  // spacing = 20
	    vbox.setLayoutX(600);
	    vbox.setLayoutY(385);
	    vbox.setAlignment(Pos.BOTTOM_CENTER);
	    

	    // choose the bloom effect for the buttons
	    Bloom bloom = new Bloom();
	    
	    // create the button "Start Game"
	    startButton = new Button("Start Game");
	    startButton.setId("lion-default");
	    
	    startButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
	    	@Override public void handle(MouseEvent e){
	    		startButton.setEffect(bloom);
	    	}
	    });
	    startButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
	    	@Override public void handle(MouseEvent e){
	    		startButton.setEffect(null);
	    	}
	    });
	    startButton.setOnAction(e-> ButtonClicked(e));	
        

        // create the button "Load Game"
	    Button loadButton = new Button("Load Game");
	    loadButton.setId("lion-default");
	    
	    loadButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
	    	@Override public void handle(MouseEvent e){
	    		loadButton.setEffect(bloom);
	    	}
	    });
	    loadButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
	    	@Override public void handle(MouseEvent e){
	    		loadButton.setEffect(null);
	    	}
	    });
	    
	    // create the button "Settings"
	    Button settingsButton = new Button("Settings");
	    settingsButton.setId("lion-default");
	    
	    settingsButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
	    	@Override public void handle(MouseEvent e){
	    		settingsButton.setEffect(bloom);
	    	}
	    });
	    settingsButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
	    	@Override public void handle(MouseEvent e){
	    		settingsButton.setEffect(null);
	    	}
	    });
	    
	    // create the button "Credits"
	    Button creditsButton = new Button("Credits");
	    creditsButton.setId("lion-default");
	    
	    creditsButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
	    	@Override public void handle(MouseEvent e){
	    		creditsButton.setEffect(bloom);
	    	}
	    });
	    creditsButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
	    	@Override public void handle(MouseEvent e){
	    		creditsButton.setEffect(null);
	    	}
	    });
	    
	    // create the button "Exit Game"	    
	    exitButton = new Button("Exit Game");
	    exitButton.setId("lion-default");
	    
	    exitButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
	    	@Override public void handle(MouseEvent e){
	    		exitButton.setEffect(bloom);
	    	}
	    });
	    exitButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
	    	@Override public void handle(MouseEvent e){
	    		exitButton.setEffect(null);
	    	}
	    });
	    exitButton.setOnAction(e-> ButtonClicked(e));	   

	    // add all the buttons to the vbox just created
	    vbox.getChildren().addAll(startButton, loadButton, settingsButton, creditsButton, exitButton);
	    
	    root.getChildren().addAll(canvas, vbox);

	    /*-------------------------READ THE SCRIPT-----------------------------*/
	    //ScriptController sc = new ScriptController("initScript.sc");
	    ScriptController sc = new ScriptController("basicScript.txt");
	    /*---------------------------------------------------------------------------*/
	    
	    
        // scenes setup
	    Scene startScene = new Scene(root);  
	    startScene.getStylesheets().add("buttonStyle.css");
	    primaryStage.setScene(startScene);
	  
	    // create a canvas for all other CGs
	    Canvas cgCanvas = new Canvas(1280, 720);
	    GraphicsContext cgGC = cgCanvas.getGraphicsContext2D();
	    // initial background after the game starts
	    Image initBackground = new Image("schoolPlayground.jpg", 1280, 720, false, true);
	    
	    cgGC.drawImage(initBackground, 0, 0);
	   	    
	    container = new Container(sc, cgCanvas);
	    theScene = new Scene(container.getSurface());
	    theScene.getStylesheets().add("buttonStyle.css");
		            
	    primaryStage.show();    
	}
	
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