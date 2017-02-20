/**
 * Created by dritcher on 2/18/17.
 */
public class Pencil {

    private int allowableCharsWrittenAmount;
    private int allowableSharpenAmount;
    private final Durability durability;
    private final Length length;
    private static final int UPPER_CASE_CHARS_AMOUNT = 2;

    public Pencil(){
        durability = Durability.PENCIL_LOW;
        length = Length.SHORT;

        allowableCharsWrittenAmount = durability.getMaxDurabilityLength();
        allowableSharpenAmount = length.getMaxSharpenAmount();
    }

    public Pencil(Durability durability, Length length){
        this.durability = durability;
        this.length = length;

        allowableCharsWrittenAmount = this.durability.getMaxDurabilityLength();
        allowableSharpenAmount = this.length.getMaxSharpenAmount();
    }

    private void reduceAllowableChars(String message, int charIndex){
        if(!Character.isWhitespace(message.charAt(charIndex))) {
            if(Character.isUpperCase(message.charAt(charIndex))) {
                allowableCharsWrittenAmount = allowableCharsWrittenAmount - UPPER_CASE_CHARS_AMOUNT;
            }else{
                allowableCharsWrittenAmount--;
            }
        }
    }

    public void write(Paper paper, String message){
        for(int charIndex = 0; charIndex < message.length() && allowableCharsWrittenAmount > 0; charIndex++){
            paper.write(message.charAt(charIndex));
            reduceAllowableChars(message, charIndex);
        }
    }

    public void editFromMostRecentErasedEntry(Paper paper, String editedMessage){
        paper.removeEmptySpaceFromErasing();

        for(int charIndex = 0; charIndex < editedMessage.length() && allowableCharsWrittenAmount > 0; charIndex++){
            paper.editFromMostRecentErasedEntry(editedMessage.charAt(charIndex));
            reduceAllowableChars(editedMessage, charIndex);
        }
    }

    public int getAllowableCharsWrittenAmount(){
        return allowableCharsWrittenAmount;
    }

    public int getAllowableSharpenAmount(){
        return allowableSharpenAmount;
    }

    public void sharpen(){
        if(allowableSharpenAmount > 0) {
            allowableCharsWrittenAmount = durability.getMaxDurabilityLength();
            allowableSharpenAmount--;
        }
    }
}
