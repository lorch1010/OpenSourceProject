package basic;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javafx.event.Event;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ScriptController {
	public ScriptController(String scriptFile){
		readScript(scriptFile);
	}
	
	public void readScript(String file){
		BufferedReader bufferedReader = null;
		try{
			FileReader reader = new FileReader(file);
			bufferedReader = new BufferedReader(reader);
			String line;
			
			while((line = bufferedReader.readLine()) != null){
				System.out.println(line);
			}
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void parseScript(String statement){
		// TO-DO
	}
}
