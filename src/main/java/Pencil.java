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
        LOW (100),
        HIGH(1000);

        private int maxCharLengthBeforeGoingDull;

        Durability(int maxCharLengthBeforeGoingDull){
            this.maxCharLengthBeforeGoingDull = maxCharLengthBeforeGoingDull;
        }

        private int getMaxCharLength(){
            return this.maxCharLengthBeforeGoingDull;
        }
    }


    public void write(Paper paper, String message){
        paper.write(message);
    }

    public int getPointDurability(){
        return durabilityOfPencil;
    }
}
