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
import javafx.scene.input.MouseButton;

public class Window extends Application{
	// global variables
	Button startButton;
	Button exitButton;
   	Stage theStage;
	Scene beginScene;
	Scene classScene;
	Scene talkScene;
	Scene talkScene2;
	

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
	    
	    // canvas initializations 
	    Canvas canvas = new Canvas(1280, 720);
	    root.getChildren().add(canvas);
	    root.getChildren().add(vbox);

	    GraphicsContext gc = canvas.getGraphicsContext2D();
	    
        // read image file
	    Image bg = new Image("background2.jpg");	    
  	    // draw the background image
	    gc.drawImage(bg, 0, 0);

        // parameters for the main title
	    gc.setFill(Color.RED);
	    gc.setStroke(Color.BLACK);
	    gc.setLineWidth(2);
	    Font theFont = Font.font("DejaVu Sans Light", FontWeight.BOLD, 60);
	    gc.setFont(theFont);
	    gc.fillText("School Memories", 400, 200);
	    gc.strokeText("School Memories", 400, 200);

        // scenes setup
	    Scene theScene = new Scene(root);  
	    primaryStage.setScene(theScene);
	    beginScene = new Scene(new GameStart());
	    classScene = new Scene(new Classroom());
	    talkScene = new Scene(new ClassTalk());
	    talkScene2 = new Scene(new ClassTalk2());
	    Scene talkScene3 = new Scene(new ClassTalk3());
	    beginScene.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  //classScene = new Scene(new Classroom());
  	    		  theStage.setScene(classScene);
  	    		}
  	    	}
  	    });
	    
	    classScene.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(talkScene);
  	    		}
  	    	}
  	    });
	    
	    talkScene.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(talkScene2);
  	    		}
  	    	}
  	    });
	    
	    talkScene2.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(talkScene3);
  	    		}
  	    	}
  	    });
	    
	    
	     
            
	    primaryStage.show();    
	}
	
	public void ButtonClicked(ActionEvent e){
            if(e.getSource() == startButton){
              theStage.setScene(beginScene);
            }
            if(e.getSource() == exitButton){
            	Platform.exit();
            }          
	}
}