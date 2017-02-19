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

    public enum Durability {
        LOW (20),
        HIGH(40);

        private int maxCharLengthBeforeGoingDull;

        Durability(int maxCharLengthBeforeGoingDull){
            this.maxCharLengthBeforeGoingDull = maxCharLengthBeforeGoingDull;
        }

        private int getMaxCharLength(){
            return this.maxCharLengthBeforeGoingDull;
        }
    }

    public enum Length {
        SHORT(1),
        LONG(3);

        private int maxTimesPencilCanBeSharpened;

        Length(int maxTimesPencilCanBeSharpened){
            this.maxTimesPencilCanBeSharpened = maxTimesPencilCanBeSharpened;
        }

        private int getMaxSharpenAmount(){
            return this.maxTimesPencilCanBeSharpened;
        }
    }


    public void write(Paper paper, String message){
        for(int charIndex = 0; charIndex < message.length() && allowableCharsWrittenAmount > 0; charIndex++){
            paper.write(message.charAt(charIndex));

            if(!Character.isWhitespace(message.charAt(charIndex))) {
                allowableCharsWrittenAmount--;
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
