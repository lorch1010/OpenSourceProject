package visual;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.shape.Rectangle;
import javafx.geometry.VPos;

public class DialogueBuilder extends Group{
	// declare global variables
    final double BASE_WIDTH = 1280;
    final double BASE_HEIGHT = 720;
    final double MARGIN = 25;
   
	// class fields	
	private String content;
	private String name;
	private Rectangle rect = new Rectangle();
	private Rectangle nameRect = new Rectangle();
 	private Text text = new Text();
	private Text nameText = new Text(65, 440, "");
    
	// class constructor
	public DialogueBuilder(String name, String content){
		this.name = name;
		this.content = content;	
		//this.rect = getRect();
		//this.text = getText();
		setName(name);
		setText(content);
		createDialogue();
		addAllContents();	
	}
	
	public DialogueBuilder(){
		//createDialogue();
		addAllContents();
	}
	
	public Rectangle getRect(){
		return rect;
 	}	

	public void createRectangle(){
		// declare rect parameters
		rect.setX(MARGIN * 2);
		rect.setY(BASE_HEIGHT * 2 / 3 - MARGIN);
		rect.setWidth(BASE_WIDTH - MARGIN * 4);
		rect.setHeight(200);
		rect.setArcWidth(30);
		rect.setArcHeight(30);
		rect.setFill(Color.BLACK);

		// declare nameRect parameters
		nameRect.setX(50);
		nameRect.setY(400);
		nameRect.setWidth(200);
		nameRect.setHeight(200);
		nameRect.setArcWidth(30);
		nameRect.setArcHeight(30);
		nameRect.setFill(Color.BLACK);
 	}

	public void createText(){
	    Font textFont = Font.font("Courier", FontWeight.THIN, 30);
		Font nameFont = Font.font("DejaVu Sans", FontWeight.BOLD, 32);

		nameText.setFont(nameFont);
		nameText.setFill(Color.WHITE);
		  		 
	    text.setX(rect.getX() + MARGIN);
	    text.setY(rect.getY() + MARGIN);
	    text.setWrappingWidth(rect.getWidth() - MARGIN * 2);
	    text.setTextOrigin(VPos.TOP);
	    text.setFont(textFont);
	    text.setFill(Color.WHITE);
	}

	public void setName(String name){
		nameText.setText(name);
	}
	
	public void setText(String content){
		text.setText(content);
	}

	public Text getText(){
 		return text;
	}	

	public void createDialogue(){
		createRectangle();
		createText();
	}

	public void addAllContents(){
		getChildren().addAll(rect, nameRect);
		getChildren().addAll(text, nameText);
	}
}