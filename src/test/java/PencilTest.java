/**
 * Created by dritcher on 2/18/17.
 */
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PencilTest {

    private Pencil pencil;
    private Paper paper;

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
        Pencil pencilWithLowDurability = new Pencil(Pencil.Durability.LOW, Pencil.Length.SHORT);
        assertEquals(20, pencilWithLowDurability.getAllowableCharsWrittenAmount());
    }

    @Test
    public void pencilShouldHaveAHighPointDurability(){
        Pencil pencilWithHighDurability = new Pencil(Pencil.Durability.HIGH, Pencil.Length.SHORT);
        assertEquals(40, pencilWithHighDurability.getAllowableCharsWrittenAmount());
    }

    @Test
    public void pencilShouldBeAbleToWriteAMessageContaining20CharactersWithLowPointDurability(){
        String textToWrite = "ThisHasTwentyChars!!";
        Pencil pencilWithLowDurability = new Pencil(Pencil.Durability.LOW, Pencil.Length.SHORT);
        pencilWithLowDurability.write(paper, textToWrite);
        assertEquals(textToWrite, paper.getContent());
    }

    @Test
    public void pencilShouldNotBeAbleToWriteAMessageContainingMoreThan20CharactersWithLowPointDurability(){
        String textToWrite = "ThisHasMoreThanTwentyChars!!";
        Pencil pencilWithLowDurability = new Pencil(Pencil.Durability.LOW, Pencil.Length.SHORT);
        pencilWithLowDurability.write(paper, textToWrite);
        assertEquals("ThisHasMoreThanTwent", paper.getContent());
    }

    @Test
    public void pencilShouldBeAbleToWriteAMessageContaining40CharactersWithHighPointDurability(){
        String textToWrite = "ThisMessageHasExactlyFiftyCharsInLength!";
        Pencil pencilWithHighDurability = new Pencil(Pencil.Durability.HIGH, Pencil.Length.SHORT);
        pencilWithHighDurability.write(paper, textToWrite);
        assertEquals(textToWrite, paper.getContent());
    }

    @Test
    public void pencilShouldNotBeAbleToWriteAMessageContainingMoreThan40CharactersWithHighPointDurability(){
        String textToWrite = "ThisMessageHasMoreThanFiftyCharsInOverallLength!";
        Pencil pencilWithHighDurability = new Pencil(Pencil.Durability.HIGH, Pencil.Length.SHORT);
        pencilWithHighDurability.write(paper, textToWrite);
        assertEquals("ThisMessageHasMoreThanFiftyCharsInOveral", paper.getContent());
    }

    @Test
    public void pencilShouldRegainItsInitialPointDurabilitiyWhenItIsSharpneed(){
        String textToWrite = "ThisHasTwentyChars!!";
        pencil.write(paper, textToWrite);
        pencil.sharpen();
        textToWrite = "AndCanWriteMore";
        pencil.write(paper, textToWrite);
        assertEquals("ThisHasTwentyChars!!AndCanWriteMore", paper.getContent());
    }

    @Test
    public void pencilShouldHaveAShortLength(){
        Pencil shortPencil = new Pencil(Pencil.Durability.LOW, Pencil.Length.SHORT);
        assertEquals(1, shortPencil.getAllowableSharpenAmount());
    }

    @Test
    public void pencilShouldHaveALongLength(){
        Pencil longPencil = new Pencil(Pencil.Durability.HIGH, Pencil.Length.LONG);
        assertEquals(3, longPencil.getAllowableSharpenAmount());
    }

    @Test
    public void pencilOfShortLengthShouldOnlyBeAbleToBeSharpenedOnce(){
        Pencil shortPencil = new Pencil(Pencil.Durability.LOW, Pencil.Length.SHORT);
        String textToWrite = "ThisHasTwentyChars!!";
        shortPencil.write(paper, textToWrite);
        shortPencil.sharpen();

        textToWrite = "AndCanWriteEvenMore!";
        shortPencil.write(paper, textToWrite);
        assertEquals("ThisHasTwentyChars!!AndCanWriteEvenMore!", paper.getContent());
    }

    @Test
    public void pencilOfShortLengthShouldNotBeAbleToBeSharpenedMoreThanOnce(){
        Pencil shortPencil = new Pencil(Pencil.Durability.LOW, Pencil.Length.SHORT);
        String textToWrite = "ThisHasTwentyChars!!";
        shortPencil.write(paper, textToWrite);
        shortPencil.sharpen();

        textToWrite = "AndCanWriteEvenMore!";
        shortPencil.write(paper, textToWrite);
        textToWrite = "ThisShouldNotAppear";

        shortPencil.sharpen();
        shortPencil.write(paper, textToWrite);
        assertEquals("ThisHasTwentyChars!!AndCanWriteEvenMore!", paper.getContent());
    }

    @Test
    public void pencilOfLongLengthShouldOnlyBeAbleToBeSharpenedThreeTimes(){
        Pencil longPencil = new Pencil(Pencil.Durability.LOW, Pencil.Length.LONG);
        String textToWrite = "ThisHasTwentyChars!!";
        longPencil.write(paper, textToWrite);
        longPencil.sharpen();

        textToWrite = "AndCanWriteEvenMore!";
        longPencil.write(paper, textToWrite);
        longPencil.sharpen();

        textToWrite = "AndCanWriteEvenMore!";
        longPencil.write(paper, textToWrite);
        longPencil.sharpen();

        textToWrite = "AndCanWriteEvenMore!";
        longPencil.write(paper, textToWrite);
        assertEquals("ThisHasTwentyChars!!AndCanWriteEvenMore!AndCanWriteEvenMore!AndCanWriteEvenMore!", paper.getContent());
    }

    @Test
    public void pencilOfLongLengthShouldNotBeAbleToBeSharpenedMoreThanThreeTimes(){
        Pencil longPencil = new Pencil(Pencil.Durability.LOW, Pencil.Length.LONG);
        String textToWrite = "ThisHasTwentyChars!!";
        longPencil.write(paper, textToWrite);
        longPencil.sharpen();

        textToWrite = "AndCanWriteEvenMore!";
        longPencil.write(paper, textToWrite);
        longPencil.sharpen();

        textToWrite = "AndCanWriteEvenMore!";
        longPencil.write(paper, textToWrite);
        longPencil.sharpen();

        textToWrite = "AndCanWriteEvenMore!";
        longPencil.write(paper, textToWrite);
        longPencil.sharpen();

        textToWrite = "ThisShouldNotAppear";
        longPencil.write(paper, textToWrite);

        assertEquals("ThisHasTwentyChars!!AndCanWriteEvenMore!AndCanWriteEvenMore!AndCanWriteEvenMore!", paper.getContent());
    }

    @Test
    public void pencilShouldNotExahustAnyGraphiteDurabilityWhenIncludingSpaces(){
        String textToWrite = "This H a s Twe nt y Cha  rs ! !";
        pencil.write(paper, textToWrite);
        assertEquals(textToWrite, paper.getContent());
    }


}
