package visual;

import javafx.scene.Group;
import javafx.scene.effect.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class Choice extends Group{
	final double MARGIN = 25; 
	// fields
	private String content_1;
	private String content_2;

	private VBox vbox = new VBox(20);
	private Button button1 = new Button("Invite her?");
	private Button button2 = new Button("Whatever, I don't care.");

	public Choice(String content_1, String content_2){
		this.content_1 = content_1;
		this.content_2 = content_2;	
	}

	public Choice(){
		//createChoice();
	}

	public void createChoice(){
		//vbox = new VBox(20);
		vbox.setLayoutX(450);
		vbox.setLayoutY(150);
		vbox.setMinWidth(300);
		vbox.setAlignment(Pos.CENTER);
		vbox.setMinWidth(300);
		vbox.setMaxWidth(450);

		//button1 = new Button("TEST Button1");
		button1.setId("btn");
		buttonDesign(button1);

		//button2 = new Button(" TEST Button2");
		button2.setId("btn");
		buttonDesign(button2);

		vbox.getChildren().addAll(button1, button2);

		getChildren().add(vbox);	
	}
	
	public Button getButton(){
		return button1;
	}
	
	public void clear(){
		getChildren().clear();
	}

	public void buttonDesign(Button button){
		DropShadow drop = new DropShadow();
		button.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
	    		@Override public void handle(MouseEvent e){
	    			button.setId("btn-pressed");
	    		}
	    	});

		button.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
	    		@Override public void handle(MouseEvent e){
	    			button.setEffect(drop);
	    		}
	    	});

		button.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>(){
	    		@Override public void handle(MouseEvent e){
	    			button.setEffect(null);
	    		}
	    	});

		button.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
	    		@Override public void handle(MouseEvent e){
	    			button.setId("btn");
	    		}
	    	});	
	}
} 