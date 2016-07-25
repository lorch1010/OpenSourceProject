package basic;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.VPos;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class DialogueBuilder extends Group{
	// declare global variables
	final double BASE_WIDTH = 1280;
	final double BASE_HEIGHT = 720;
	final double MARGIN = 25;
   
	// fields 
   	private String nameContent;
	private String content;
	private Rectangle nameRect = new Rectangle();
	private Rectangle rect = new Rectangle();
	private Text nameText = new Text(65, 440, "");
	private Text text = new Text();
	private Timeline timeline = new Timeline();
    
	// constructor
	public DialogueBuilder(String nameContent, String content){
		this.nameContent = nameContent;
		this.content = content;
		/*createRectangle();
		createDialogue();
		textAnimation();*/
		//this.rect = getRect();
		this.timeline = getAnimation();
		//this.text = getText();
		addAllContents();
	}
	
	public Rectangle getRect(){
		return rect;
 	}

	public void createRectangle(){
		// create a rectangle for name field
		nameRect.setX(50);
		nameRect.setY(400);
		nameRect.setWidth(200);
		nameRect.setHeight(100);
		nameRect.setArcHeight(30);
		nameRect.setArcWidth(30);
		nameRect.setFill(Color.BLACK);
		
		// create a rectangle for dialogue field
		rect.setX(MARGIN * 2);
		rect.setY(BASE_HEIGHT * 2 / 3 - MARGIN);
		rect.setWidth(BASE_WIDTH - MARGIN * 4);
		rect.setHeight(200);
		rect.setArcWidth(30);
		rect.setArcHeight(30);
		rect.setFill(Color.BLACK);
		
		//getChildren().addAll(nameRect, rect);
 	}

	public void createText(){
	    Font textFont = Font.font("Courier", FontWeight.THIN, 30);
	    Font nameFont = Font.font("DejaVu Sans", FontWeight.BOLD, 32);
	    
	    nameText.setText(nameContent);
	    nameText.setFont(nameFont);
	    nameText.setFill(Color.WHITE);
				 
	    text.setX(rect.getX() + MARGIN);
	    text.setY(rect.getY() + MARGIN);
	    text.setWrappingWidth(rect.getWidth() - MARGIN * 2);
	    text.setTextOrigin(VPos.TOP);
	    text.setFont(textFont);
	    text.setFill(Color.WHITE);
		//getChildren().addAll(text, nameText);
	}

	public Text getText(){
 		return text;
	}
	
	public void textAnimation(){	
	    IntegerProperty charCount = new SimpleIntegerProperty();
	    KeyFrame startFrame = new KeyFrame(Duration.ZERO, new KeyValue(charCount, 0));
	    KeyFrame endFrame = new KeyFrame(Duration.seconds(5), new KeyValue(charCount, content.length()));
	    timeline.getKeyFrames().addAll(startFrame, endFrame);
	    // click anywhere on the screen to skip the text animation
	    this.setOnMouseClicked(new EventHandler<MouseEvent>(){
	        @Override
	        public void handle(MouseEvent mouseEvent){
	        	timeline.jumpTo(Duration.seconds(5));
	        }
	    });
	        
	   	charCount.addListener(new ChangeListener<Number>(){
	        @Override 
	        public void changed(ObservableValue<? extends Number> observable,
	        			    	Number oldValue, Number newValue){
	        	String textToDisplay = content.substring(0,  newValue.intValue());
	        	text.setText(textToDisplay);
	        }
	    });        
	   	timeline.play();
	}
	
  	public Timeline getAnimation(){
		return timeline;
	}
  	
  	public void createDialogue(){
  		createRectangle();
  		createText();
  		textAnimation();
  	}
  	
  	public void addAllContents(){
  		getChildren().addAll(rect, nameRect);
  		getChildren().addAll(text, nameText);
  	}
}
