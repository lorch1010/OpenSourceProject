package basic;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Container extends AnimationTimer{
	private Group root;
	private CGBuilder cg;
	private DialogueBuilder dialogue;
	
	public Container(CGBuilder cg, DialogueBuilder dialogue){
		this.cg = cg;
		this.dialogue = dialogue;
	}
	public void processEvent(){
		this.cg.getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent mouseEvent){
				start();
			}
		});
	}
	
	public Parent getSurface(){
		root = new Group();
		root.getChildren().addAll(cg, dialogue);
		
		return root;
	}
	
	public void startup(){
		processEvent();
		//start();
	}
	
	@Override
	public void handle(long now){
		cg.createCG();
		dialogue.createDialogue();
		shutdown();
	}
	
	public void shutdown(){
		stop();
	}
}
