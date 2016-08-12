package basic;
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
	}

	public Parent getSurface(){
		root = new Group();
		root.getChildren().add(canvas);
		root.getChildren().add(resolver.getDialogue());
		
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