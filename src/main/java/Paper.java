/**
 * Created by dritcher on 2/18/17.
 */
public class Paper {

    String paperContent = "";

    public Paper(){
    }

    public void write(String content){
        paperContent += content;
    }

    public String getContent(){
        return paperContent;
    }
}