package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;


public class ResourceManager{
	private ResourceManager(){}

	public static String getUrl(String fileName){
		File file = new File(fileName);
		return file.toURI().toString();
	}

	public static String getResourceUrl(String classpath){
		return ResourceManager.class.getResource(classpath).toString();
	}

	public static Image loadImage(String fileName){
		Image character = null;
		FileInputStream image = null;
		
		try{
			image = new FileInputStream(fileName);
			character = new Image(image, 700, 600, true, false);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}

		return character;
	}

	public static Image loadBackground(String fileName){
		Image background = null;
		FileInputStream image = null;
		
		try{
			image = new FileInputStream(fileName);
			background = new Image(image, 1280, 720, false, false);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}

		return background; 
	}
}