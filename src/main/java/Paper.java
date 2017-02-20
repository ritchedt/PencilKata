/**
 * Created by dritcher on 2/18/17.
 */
public class Paper extends Pencil {

    private String paperContent = "";

    public void write(char content){
        paperContent += content;
    }

    public String getContent(){
        return paperContent;
    }

    public void erase(String content){
        int indexOfLastOccuranceOfWord = getContent().lastIndexOf(content);

        paperContent = new StringBuilder(getContent()).replace(indexOfLastOccuranceOfWord,
                indexOfLastOccuranceOfWord + content.length(), new String(new char[content.length()]).replace("\0", " ")).toString();
    }
}
