/**
 * Created by dritcher on 2/18/17.
 */
public class Paper extends Pencil {

    private int indexOfMostRecentErasedEntry = 0;
    private int lengthOfMostRecentErasedEntry = 0;
    private String paperContent = "";

    public void write(char content){
        paperContent += content;
    }

    public void editFromMostRecentErasedEntry(char editedContent){
        paperContent = paperContent.substring(0, indexOfMostRecentErasedEntry ) +
                editedContent + paperContent.substring(indexOfMostRecentErasedEntry, paperContent.length());

        indexOfMostRecentErasedEntry++;
    }

    public String getContent(){
        return paperContent;
    }

    public void erase(String content){
        int indexOfLastOccuranceOfWord = getContent().lastIndexOf(content);

        paperContent = new StringBuilder(getContent()).replace(indexOfLastOccuranceOfWord,
                indexOfLastOccuranceOfWord + content.length(),
                new String(new char[content.length()]).replace("\0", " ")).toString();

        indexOfMostRecentErasedEntry = indexOfLastOccuranceOfWord;
        lengthOfMostRecentErasedEntry = content.length();
    }

    public void removeEmptySpaceFromErasing(){
        paperContent = new StringBuilder(getContent()).replace(indexOfMostRecentErasedEntry,
                indexOfMostRecentErasedEntry + lengthOfMostRecentErasedEntry, "").toString();
    }
}
