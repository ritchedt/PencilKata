/**
 * Created by dritcher on 2/18/17.
 */
public class Pencil {

    private int remainingCharacters;
    private int remainingSharpenAbility;
    private final PencilDurability pencilDurability;
    private final Length length;
    private static final int UPPER_CASE_CHARS_AMOUNT = 2;

    public Pencil(){
        pencilDurability = PencilDurability.LOW;
        length = Length.SHORT;

        remainingCharacters = pencilDurability.getMaxDurabilityLength();
        remainingSharpenAbility = length.getMaxSharpenAmount();
    }

    public Pencil(PencilDurability pencilDurability, Length length){
        this.pencilDurability = pencilDurability;
        this.length = length;

        remainingCharacters = this.pencilDurability.getMaxDurabilityLength();
        remainingSharpenAbility = this.length.getMaxSharpenAmount();
    }

    private void reduceAllowableChars(String message, int charIndex){
        if(!Character.isWhitespace(message.charAt(charIndex))) {
            if(Character.isUpperCase(message.charAt(charIndex))) {
                remainingCharacters = remainingCharacters - UPPER_CASE_CHARS_AMOUNT;
            }else{
                remainingCharacters--;
            }
        }
    }

    public void write(Paper paper, String message){
        for(int charIndex = 0; charIndex < message.length() && remainingCharacters > 0; charIndex++){
            paper.write(message.charAt(charIndex));
            reduceAllowableChars(message, charIndex);
        }
    }

    public void editFromMostRecentErasedEntry(Paper paper, String editedMessage){
        paper.removeEmptySpaceFromErasing();

        for(int charIndex = 0; charIndex < editedMessage.length() && remainingCharacters > 0; charIndex++){
            paper.editFromMostRecentErasedEntry(editedMessage.charAt(charIndex));
            reduceAllowableChars(editedMessage, charIndex);
        }
    }

    public int getRemainingCharacters(){
        return remainingCharacters;
    }

    public int getRemainingSharpenAbility(){
        return remainingSharpenAbility;
    }

    public void sharpen(){
        if(remainingSharpenAbility > 0) {
            remainingCharacters = pencilDurability.getMaxDurabilityLength();
            remainingSharpenAbility--;
        }
    }
}
