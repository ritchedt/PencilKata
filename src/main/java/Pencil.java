/**
 * Created by dritcher on 2/18/17.
 */
public class Pencil {

    private int durabilityOfPencil;
    private Durability durability;

    public Pencil(){
        durability = Durability.LOW;
        durabilityOfPencil = durability.getMaxCharLength();
    }

    public Pencil(Durability durability){
        this.durability = durability;
        durabilityOfPencil = this.durability.getMaxCharLength();
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


    public void write(Paper paper, String message){
        for(int charIndex = 0; charIndex < message.length() && durabilityOfPencil > 0; charIndex++){
            paper.write(message.charAt(charIndex));
            durabilityOfPencil--;
        }
    }

    public int getPointDurability(){
        return durabilityOfPencil;
    }

    public void sharpen(){
        durabilityOfPencil = durability.getMaxCharLength();
    }
}
