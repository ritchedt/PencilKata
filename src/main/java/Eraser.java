/**
 * Created by dritcher on 2/20/17.
 */
public class Eraser extends Pencil {

    private int allowableEraseAmount;
    private final Durability durability;

    public Eraser(){
        durability = Durability.ERASER_LOW;
        allowableEraseAmount = durability.getMaxDurabilityLength();
    }

    public Eraser(Durability durability){
        this.durability = durability;
        allowableEraseAmount = this.durability.getMaxDurabilityLength();
    }

    public void erase(Paper paper, String lastOccuranceOfWrittenWord){
        if(allowableEraseAmount > 0) {
            paper.erase(lastOccuranceOfWrittenWord);
            allowableEraseAmount--;
        }
    }

    public int getAllowableEraseAmount(){
        return allowableEraseAmount;
    }
}
