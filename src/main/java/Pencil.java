/**
 * Created by dritcher on 2/18/17.
 */
public class Pencil {

    private int allowableCharsWrittenAmount;
    private int allowableSharpenAmount;
    private final Durability durability;
    private final Length length;

    public Pencil(){
        durability = Durability.LOW;
        length = Length.SHORT;

        allowableCharsWrittenAmount = durability.getMaxCharLength();
        allowableSharpenAmount = length.getMaxSharpenAmount();
    }

    public Pencil(Durability durability, Length length){
        this.durability = durability;
        this.length = length;

        allowableCharsWrittenAmount = this.durability.getMaxCharLength();
        allowableSharpenAmount = this.length.getMaxSharpenAmount();
    }

    public void write(Paper paper, String message){
        for(int charIndex = 0; charIndex < message.length() && allowableCharsWrittenAmount > 0; charIndex++){
            paper.write(message.charAt(charIndex));

            if(!Character.isWhitespace(message.charAt(charIndex))) {
                if(Character.isUpperCase(message.charAt(charIndex))) {
                    allowableCharsWrittenAmount = allowableCharsWrittenAmount - 2;
                }else{
                    allowableCharsWrittenAmount--;
                }
            }
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
            allowableCharsWrittenAmount = durability.getMaxCharLength();
            allowableSharpenAmount--;
        }
    }
}
