package basic;
import basic.Scenes.FirstChapter.*;
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
import java.util.ArrayList;


public class Window extends Application{
	private Container container;
	
	// global variables
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
	    
	    //root.getChildren().add(canvas);

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

	    
        // scenes setup
	    Scene startScene = new Scene(root);  
	    primaryStage.setScene(startScene);
	  
	    // create a canvas for all other CGs
	    Canvas cgCanvas = new Canvas(1280, 720);
	    GraphicsContext cgGC = cgCanvas.getGraphicsContext2D();
	    // initial background after the game starts
	    Image initBackground = new Image("schoolGate.jpg", 1280, 720, false, false);
	    
	    // character images
	    Image character1 = new Image("male.jpg");
	    Image character2 = new Image("teacher.png");
	    
	    // background images
	    Image background1 = new Image("classroom.bmp", 1280, 720, false, false);
	    
	    ArrayList<Image> backgrounds = new ArrayList<>();
	    backgrounds.add(initBackground);
	    backgrounds.add(background1);
	    
	    ArrayList<Image> characters = new ArrayList<>();
	    characters.add(character1);
	    characters.add(character2);
	    
	    // ArrayList of character names
	    ArrayList<String> names = new ArrayList<>();
	    names.add("Me");
	    names.add("Mr. Peng");
	    
	    
	    // ArrayList of dialogue contents
	    ArrayList<String> contents = new ArrayList<>();
	    contents.add("Standing in fron of this high school in which I'll be spending the next three yeasr feels weird. Time flies");
	    contents.add("Hello, students. Hope you guys had a great summer.");
	    
	    cgGC.drawImage(initBackground, 0, 0);
	    
	    CGBuilder cg = new CGBuilder(cgCanvas, backgrounds, characters);
	    DialogueBuilder dialogue = new DialogueBuilder(names, contents);
	    
	    container = new Container(cg, dialogue);
	    theScene = new Scene(container.getSurface());
	    
	    //container.startup();
	    //primaryStage.setScene(theScene);
	    
	    
	    // *****************************************************************************************************
	    
	    /*
	    theScene = new Scene(new GameStart());
	    Scene classScene = new Scene(new Classroom());
	    Scene talkScene = new Scene(new ClassTalk());
	    Scene talkScene2 = new Scene(new ClassTalk2());
	    Scene talkScene3 = new Scene(new ClassTalk3());
	    Scene classOver1 = new Scene(new ClassOver_1());
	    Scene classOver2 = new Scene(new ClassOver_2());
	    Scene classOver3 = new Scene(new ClassOver_3());
	    Scene classOver4 = new Scene(new ClassOver_4());
	    Scene classOver5 = new Scene(new ClassOver_5());
	    Scene classOver6 = new Scene(new ClassOver_6());
	    Scene classOver7 = new Scene(new ClassOver_7());
	    Scene classOver8 = new Scene(new ClassOver_8());
	    Scene classOver9 = new Scene(new ClassOver_9());
	    Scene classOver10 = new Scene(new ClassOver_10());
	    Scene classOver11 = new Scene(new ClassOver_11());
	    Scene classOver12 = new Scene(new ClassOver_12());
	    Scene classOver13 = new Scene(new ClassOver_13());
	    Scene classOver14 = new Scene(new ClassOver_14());
	    Scene classOver15 = new Scene(new ClassOver_15());
	    Scene classOver16 = new Scene(new ClassOver_16());
	    Scene classOver17 = new Scene(new ClassOver_17());
	    Scene classOver18 = new Scene(new ClassOver_18());
	    Scene classOver19 = new Scene(new ClassOver_19());
	        
	    
	    theScene.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
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
	    
	    talkScene3.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(classOver1);
  	    		}
  	    	}
  	    });
	    
	    classOver1.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(classOver2);
  	    		}
  	    	}
  	    });
	    
	    classOver2.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(classOver3);
  	    		}
  	    	}
  	    });
	    
	    classOver3.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(classOver4);
  	    		}
  	    	}
  	    });
	    
	    classOver4.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(classOver5);
  	    		}
  	    	}
  	    });
	    
	    classOver5.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(classOver6);
  	    		}
  	    	}
  	    });
	    
	    classOver6.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(classOver7);
  	    		}
  	    	}
  	    });
	    
	    classOver7.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(classOver8);
  	    		}
  	    	}
  	    });
	    
	    classOver8.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(classOver9);
  	    		}
  	    	}
  	    });
	    
	    classOver9.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(classOver10);
  	    		}
  	    	}
  	    });
	    
	    classOver10.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(classOver11);
  	    		}
  	    	}
  	    });
	    
	    classOver11.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(classOver12);
  	    		}
  	    	}
  	    });
	    
	    classOver12.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(classOver13);
  	    		}
  	    	}
  	    });
	    
	    classOver13.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(classOver14);
  	    		}
  	    	}
  	    });
	    
	    classOver14.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(classOver15);
  	    		}
  	    	}
  	    });
	    
	    classOver15.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(classOver16);
  	    		}
  	    	}
  	    });
	    
	    classOver16.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(classOver17);
  	    		}
  	    	}
  	    });
	    
	    classOver17.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(classOver18);
  	    		}
  	    	}
  	    });
	    
	    classOver18.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
  	    	@Override
  	    	public void handle(MouseEvent mouseEvent){
  	    		if(mouseEvent.getButton() == MouseButton.SECONDARY){
  	    		  theStage.setScene(classOver19);
  	    		}
  	    	}
  	    });
  	    */
	    
	    //***************************************************************************************************
	    
	        
            
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
}