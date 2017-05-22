package utilities;
import java.lang.StringBuilder;
import java.lang.Integer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javafx.scene.Group;
import javafx.event.Event;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import visual.Background;
import visual.Cg;
import visual.Choice;
import visual.DialogueBuilder;
import javafx.scene.control.Button;

public class ScriptController implements Controller{	
	private LineReader scripts;
	private Map<String, String> vars;
	private Map<String, Cg> cgs;
	private Map<String, Background> bgs;
	private String nameToDisplay;
	private String message;	
	private String option1;
	private String option2;
	private DialogueBuilder dialogue;
	private Choice choice;

	public ScriptController(String scriptFile){
		this.vars = new HashMap<String, String>();
		this.cgs = new LinkedHashMap<String, Cg>();
		this.bgs = new LinkedHashMap<String, Background>();
		this.dialogue = new DialogueBuilder();
		this.choice = new Choice();
		
		readScript(scriptFile);
	}

	public void readScript(String file){
		BufferedReader bufferedReader = null;
		try{
			FileReader reader = new FileReader(file);
			bufferedReader = new BufferedReader(reader);
			this.scripts = new LineReader();
			String statement = null;
			while((statement = bufferedReader.readLine()) != null){
				statement = statement.trim();
				if(statement.length() == 0){
					continue;
				}
				if(statement.startsWith("//") || statement.startsWith("#")){
					continue;
				}
				scripts.addLine(statement);
			}
			reader.close();

		}catch(IOException e){
			e.printStackTrace();
		}	
	}

	public boolean isRunning(){
		return scripts != null && scripts.hasNext();
	}

	@Override
	public Controller invoke(){
		return this;
	}

	@Override
	public void handle(Event event){
		if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
			choice.clear();
			invokeScript();
		}	
	}

	@Override
	public void draw(GraphicsContext context){
		// draw background
		for(Background bg: bgs.values()){
			context.drawImage(bg.getImage(), bg.getX(), bg.getY());
		}	

		// then draw character
		for(Cg cg: cgs.values()){
			context.drawImage(cg.getImage(), cg.getX(), cg.getY());
		}

		// add dialogue at the end
		if((message != null) && !(message.isEmpty())){	
			dialogue.setName(nameToDisplay);
			dialogue.setText(message);
			dialogue.createDialogue();
		}	
		
		/*choice.setText(option1);
		choice.createChoice();*/
	}

	public Group getDialogue(){
		return dialogue;
	}
	
	public Group getChoice(){
		return choice;
	}
	
	public ArrayList<Button> getButtons(){
		return choice.getButtons();
	}
	
	/*public boolean buttonEmpty(){
		return choice.buttonEmpty();
	}*/

	public int getOptionId(){
		return choice.getOptionId();
	}
	
	
	/*---------------------------METHOD NEEDS TO BE UPDATED---------------------------------------*/
	/*---------------------------AS THE PRIMARY SCRIPT LANGUAGE CHANGED TO CHINESE----------------*/
	public void invokeScript(){
		this.message = "";
		this.nameToDisplay = "";
		this.option1 = "";
		this.option2 = "";
		
		while(scripts.hasNext()){
			String script = scripts.getNext();
			String[] tokens = script.split("\\s");  
			
			int tokenLength = tokens.length;
				
			if("set".equals(tokens[0])){
				vars.put("#{" + tokens[1] + "}", tokens[3]);
			}else if("cg".equals(tokens[0])){
				if("del".equals(tokens[1])){
					if(tokenLength == 2){
						cgs.clear();
					}else if(tokenLength > 2){
						cgs.remove(tokens[2]);
					}
				}else{
					cgs.put(tokens[1], new Cg(vars.get(tokens[1]), 70, 0));
				}			
			}else if("msg".equals(tokens[0])){	
					nameToDisplay = parseMsg(tokens[1]);	
						
					for(int i=2;i<tokenLength;i++){
						message = message + " " + parseMsg(tokens[i]);
					}				
					break;		
			}else if("bg".equals(tokens[0])){
				if("del".equals(tokens[1])){
					if(tokenLength == 2){
						bgs.clear();
					}else if(tokenLength > 2){
						bgs.remove(tokens[2]);
					}	
				}else{
					bgs.put(tokens[1], new Background(vars.get(tokens[1]), 0, 0));	
				}
			}else if("select".equals(tokens[0])){
				// do nothing and proceed to the next line of code
				//choice.setButton();
				
			}else if("a.".equals(tokens[0])){
				for(int i=1;i<tokenLength;i++){
					option1 = option1 + " " + parseMsg(tokens[i]);
				}
				choice.setOption1(option1);
			}else if("b.".equals(tokens[0])){
				for(int i=1;i<tokenLength;i++){
					option2 = option2 + " " + parseMsg(tokens[i]);
				}
				choice.setOption2(option2);
				choice.createChoice();
				
				break;
			}else if("if".equals(tokens[0])){
				if(getOptionId() == Integer.parseInt(tokens[1])){
					this.readScript(tokens[2]);
					this.invokeScript();
					break;	
				}else{
					// go to the next line
					continue;
				}
			}
		}	
	}

	public String parseMsg(String statement){
		StringBuilder param = new StringBuilder();
		StringBuilder msg = new StringBuilder();
		boolean start = false;

		for(int i=0;i<statement.length();i++){
			char temp = statement.charAt(i);
			
			if(start){
				if(temp == '}'){
					msg.append(vars.get("#{" + param + "}"));
					param.delete(0, param.length());
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