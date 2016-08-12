package basic;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.control.*;
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
	    gc.setFill(Color.ORANGE);
	    gc.setStroke(Color.BLACK);
	    gc.setLineWidth(2);
	    Font theFont = Font.font("Ubuntu", FontWeight.BOLD, 60);
	    gc.setFont(theFont);
	    gc.fillText("School Memories", 425, 200);
	    gc.strokeText("School Memories", 425, 200);

	    // create a vbox to store different buttons
	    VBox vbox = new VBox(20);  // spacing = 20
	    vbox.setLayoutX(600);
	    vbox.setLayoutY(400);
	    vbox.setAlignment(Pos.BOTTOM_CENTER);

	    // choose the bloom effect for the buttons
	    Bloom bloom = new Bloom();
	    
	    // create the button "Start Game"
	    startButton = new Button("Start Game");
	    startButton.setStyle("-fx-font: 18 arial");
	    
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
        loadButton.setStyle("-fx-font: 18 arial");
	    
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
        settingsButton.setStyle("-fx-font: 18 arial");
	    
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
        creditsButton.setStyle("-fx-font: 18 arial");
	    
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
        exitButton.setStyle("-fx-font: 18 arial");
	    
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
	    ScriptController sc = new ScriptController("script.sc");
	    /*---------------------------------------------------------------------------*/
	    
	    
        // scenes setup
	    Scene startScene = new Scene(root);  
	    primaryStage.setScene(startScene);
	  
	    // create a canvas for all other CGs
	    Canvas cgCanvas = new Canvas(1280, 720);
	    GraphicsContext cgGC = cgCanvas.getGraphicsContext2D();
	    // initial background after the game starts
	    Image initBackground = new Image("schoolPlayground.jpg", 1280, 720, false, true);
	    
	    cgGC.drawImage(initBackground, 0, 0);
	    
	    
	    container = new Container(sc, cgCanvas);
	    theScene = new Scene(container.getSurface());
		            
	    primaryStage.show();    
	}
	
	public void ButtonClicked(ActionEvent e){
            if(e.getSource() == startButton){
            	container.startup();
            	theStage.setScene(theScene);         	
            }
            if(e.getSource() == exitButton){
            	Platform.exit();
            }          
	}
	
	public void stop(){
		container.shutdown();
	}
}