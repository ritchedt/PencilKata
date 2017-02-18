/**
 * Created by dritcher on 2/18/17.
 */
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PencilTest {

    Pencil pencil;
    Paper paper;

    @Before
    public void setUp(){
        pencil = new Pencil();
        paper = new Paper();
    }

    @Test
    public void paperShouldNotHaveAnythingWritten(){
        assertEquals(paper.getContent(), "");
    }

    @Test
    public void pencilShouldWriteMyNameIsDrewOnPaper(){
        String textToWrite = "My name is Drew";
        pencil.write(paper, textToWrite);

        assertEquals(textToWrite, paper.getContent());
    }

    @Test
    public void pencilShouldHaveALowPointDurability(){
        Pencil pencilWithLowDurability = new Pencil(Pencil.Durability.LOW);
        assertEquals(20, pencilWithLowDurability.getPointDurability());
    }

    @Test
    public void pencilShouldHaveAHighPointDurability(){
        Pencil pencilWithHighDurability = new Pencil(Pencil.Durability.HIGH);
        assertEquals(40, pencilWithHighDurability.getPointDurability());
    }

    @Test
    public void pencilShouldBeAbleToWriteAMessageContaining20CharactersWithLowPointDurability(){
        String textToWrite = "ThisHasTwentyChars!!";
        Pencil pencilWithLowDurability = new Pencil(Pencil.Durability.LOW);
        pencilWithLowDurability.write(paper, textToWrite);
        assertEquals(textToWrite, paper.getContent());
    }

    @Test
    public void pencilShouldNotBeAbleToWriteAMessageContainingMoreThan20CharactersWithLowPointDurability(){
        String textToWrite = "ThisHasMoreThanTwentyChars!!";
        Pencil pencilWithLowDurability = new Pencil(Pencil.Durability.LOW);
        pencilWithLowDurability.write(paper, textToWrite);
        assertEquals("ThisHasMoreThanTwent", paper.getContent());
    }

    @Test
    public void pencilShouldBeAbleToWriteAMessageContaining40CharactersWithHighPointDurability(){
        String textToWrite = "ThisMessageHasExactlyFiftyCharsInLength!";
        Pencil pencilWithHighDurability = new Pencil(Pencil.Durability.HIGH);
        pencilWithHighDurability.write(paper, textToWrite);
        assertEquals(textToWrite, paper.getContent());
    }

    @Test
    public void pencilShouldNotBeAbleToWriteAMessageContainingMoreThan40CharactersWithHighPointDurability(){
        String textToWrite = "ThisMessageHasMoreThanFiftyCharsInLength!";
        Pencil pencilWithHighDurability = new Pencil(Pencil.Durability.HIGH);
        pencilWithHighDurability.write(paper, textToWrite);
        assertEquals("ThisMessageHasMoreThanFiftyCharsInLength", paper.getContent());
    }
}
