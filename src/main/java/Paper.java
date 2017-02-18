/**
 * Created by dritcher on 2/18/17.
 */
public class Paper extends Pencil {

    String paperContent = "";

    public Paper(){
    }

    public void write(char content){
        paperContent += content;
    }

    public String getContent(){
        return paperContent;
    }
}
