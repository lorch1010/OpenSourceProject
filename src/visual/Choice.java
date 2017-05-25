package visual;
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.effect.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Choice extends Group{
    final double MARGIN = 25;

    // Class fields
    private VBox vbox = new VBox(20);
    private Button button1 = new Button();
    private Button button2 = new Button();
    private ArrayList<Button> buttons = new ArrayList<Button>();
    private int optionId = 0;
    //private boolean buttonInitialized = false;

    public Choice(){
        //createChoice();
        buttons.add(button1);
        buttons.add(button2);
    }

    public void setOption1(String option){
        button1.setText(option);
    }

    public void setOption2(String option){
        button2.setText(option);
    }

    public void createChoice(){
        vbox.setLayoutX(450);
        vbox.setLayoutY(150);
        vbox.setMinWidth(300);
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinWidth(300);
        vbox.setMaxWidth(450);

        DropShadow drop = new DropShadow();
        button1.setId("btn");
        buttonDesign(button1);

        button1.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
            @Override public void handle(MouseEvent e){
                button1.setEffect(drop);

                // Set optionId as 0
                optionId = 0;
            }
        });

        button2.setId("btn");
        buttonDesign(button2);

        button2.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
            @Override public void handle(MouseEvent e){
                button2.setEffect(drop);

                // Set optionId as 1
                optionId = 1;
            }
        });

        vbox.getChildren().addAll(button1, button2);
        getChildren().add(vbox);

        //buttonInitialized = true;

    }

    public ArrayList<Button> getButtons(){
        return buttons;
    }

    public void clear(){
        getChildren().clear();
    }

    public int getOptionId(){
        return optionId;
    }
	/*public void setButton(){
		buttonInitialized = true;
	}

	public boolean buttonEmpty(){
		return buttonInitialized;
	}*/

    public void buttonDesign(Button button){
        button.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
            @Override public void handle(MouseEvent e){
                button.setId("btn-pressed");
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