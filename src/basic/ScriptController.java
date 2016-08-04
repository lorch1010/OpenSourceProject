package basic;
import java.lang.StringBuilder;
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
	// fields
	//private Map<String, String> vars;
	private String name = "";
	private String message = "";
	private ArrayList<String> names = new ArrayList<>();
	private ArrayList<String> messages = new ArrayList<>();
	
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
				//System.out.println(line);
				//displayMessage(line);
				invokeScript(line);
			}
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public void invokeScript(String file){
		//String obj = null, instruct = null;
		//String data = null, ops = null;
		//String msgToDisplay;
		String[] tokens = file.split("\\s");
		for(int i=0;i<tokens.length;i++){
			if("msg".equals(tokens[i])){
				name = parseMsg(tokens[i+1]);
				names.add(name);
				//System.out.println("Name: " + name);
			}else if(tokens[i].startsWith("#")){
				message = "";
				continue;
			}else{
				message = message + " " + parseMsg(tokens[i]);
			}
			
		}
		messages.add(message);
		//System.out.println("Message: " + message);
		
		/*StringTokenizer st = new StringTokenizer(file);
		while(st.hasMoreTokens()){
			instruct = st.nextToken();
			obj = st.nextToken();
			//data = st.nextToken();
			//ops = st.nextToken();
			
			if("msg".equals(instruct)){
				msgToDisplay = parseMsg(obj);
				// will print "charName" for unknown reasons
				System.out.println("Message: " + msgToDisplay);
			}
			
		}*/
	}
	
	public ArrayList<String> getNames(){
		return names;
	}
	
	public ArrayList<String> getMessages(){
		return messages;
	}
	
	public String parseMsg(String statement){
		StringBuilder param = new StringBuilder();
		StringBuilder msg = new StringBuilder();
		boolean start = false;
		
		for(int i=0;i<statement.length();i++){
			char temp = statement.charAt(i);
			
			if(start){
				if(temp == '}'){
					//msg.append(vars.get("#{" + param + "}"));
					msg.append(param);
					//param.delete(0, param.length());
					start = false;
				}else{
					param.append(temp);
				}
			}else if((temp == '#') && (i + 1 < statement.length()) && (statement.charAt(i + 1) == '{')){
				start = true;
				i++;
			}else{
				msg.append(temp);
			}
		}
		return msg.toString();
	}
}
