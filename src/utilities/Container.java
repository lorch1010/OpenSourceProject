package utilities;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;

public class Container extends AnimationTimer{
	private Canvas canvas;
	private Group root;
	private ViewResolver resolver;

	public Container(Controller controller, Canvas canvas){
		this.canvas = canvas;
		this.resolver = new ViewResolver(controller);
	}

	public void processEvent(){
		this.canvas.setOnMouseClicked(resolver);
		
		if(!this.resolver.getButtons().isEmpty()){
			for(int i=0;i<this.resolver.getButtons().size();i++){
				this.resolver.getButtons().get(i).setOnMouseClicked(resolver);
			}
		}
		
		/*if(this.resolver.getButton() != null){
			this.resolver.getButton().setOnMouseClicked(resolver);
		}*/
	}

	public Parent getSurface(){
		root = new Group();
		
		// add canvas and dialogue to the root
		root.getChildren().add(canvas);
		root.getChildren().add(resolver.getDialogue());
		if(resolver.getChoice() != null){
			root.getChildren().add(resolver.getChoice());
		}
		
		return root;
	}

	public void startup(){
		processEvent();
		start();
	}

	public void shutdown(){
		stop();
	}

	@Override
	public void handle(long now){
		resolver.renderView(canvas.getGraphicsContext2D());
		//shutdown();	
	}
}