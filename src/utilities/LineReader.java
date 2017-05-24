package utilities;

import java.util.LinkedList;
import java.util.List;

public class LineReader{
    private int index;
    private List<String> content;

    public LineReader(){
        this(new LinkedList<String>());
    }

    public LineReader(List<String> content){
        this.content = content;
        this.index = 0;
    }

    public int getIndex(){
        return index;
    }

    public int getLines(){
        return content.size();
    }

    public void addLine(String line){
        this.content.add(line);
    }

    public boolean hasNext(){
        return index < content.size();
    }

    public String getNext(){
        return content.get(index++);
    }
}