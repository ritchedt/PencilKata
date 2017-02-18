/**
 * Created by dritcher on 2/18/17.
 */
public class Pencil {

    int durabilityOfPencil;

    public Pencil(){
        this.durabilityOfPencil = Durability.LOW.getMaxCharLength();
    }

    public Pencil(Durability durability){
        this.durabilityOfPencil = durability.getMaxCharLength();
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
        for(int charIndex = 0; charIndex < message.length() && charIndex < this.durabilityOfPencil; charIndex++){
            paper.write(message.charAt(charIndex));
        }
    }

    public int getPointDurability(){
        return durabilityOfPencil;
    }
}
