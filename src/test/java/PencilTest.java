/**
 * Created by dritcher on 2/18/17.
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PencilTest {

    private Pencil pencil;
    private Paper paper;
    private Eraser eraser;
    private String textToWrite;

    @Before
    public void setUp(){
        pencil = new Pencil();
        paper = new Paper();
        eraser = new Eraser();
        textToWrite = "";
    }

    @After
    public void tearDown(){
        pencil = null;
        paper = null;
        eraser = null;
        textToWrite = null;
    }

    @Test
    public void paperShouldNotHaveAnythingWritten(){
        assertTrue(paper.getContent().equals(""));
    }

    @Test
    public void pencilShouldWriteMyNameIsDrewOnPaper(){
        textToWrite = "my name is drew";
        pencil.write(paper, textToWrite);

        assertTrue(paper.getContent().equals(textToWrite));
    }

    @Test
    public void pencilShouldHaveALowPointDurability(){
        assertEquals(20, pencil.getRemainingCharacters());
    }

    @Test
    public void pencilShouldHaveAHighPointDurability(){
        Pencil pencilWithHighDurability = new Pencil(PencilDurability.HIGH, Length.SHORT);
        assertEquals(40, pencilWithHighDurability.getRemainingCharacters());
    }

    @Test
    public void pencilShouldBeAbleToWriteAMessageContaining20CharactersWithLowPointDurability(){
        textToWrite = "thishastwentychars!!";
        pencil.write(paper, textToWrite);
        assertTrue(paper.getContent().equals(textToWrite));
    }

    @Test
    public void pencilShouldNotBeAbleToWriteAMessageContainingMoreThan20CharactersWithLowPointDurability(){
        textToWrite = "thishasmorethantwentychars!!";
        pencil.write(paper, textToWrite);
        assertTrue(paper.getContent().equals("thishasmorethantwent"));
    }

    @Test
    public void pencilShouldBeAbleToWriteAMessageContaining40CharactersWithHighPointDurability(){
        textToWrite = "thismessagehasexactlyfiftycharsinlength!";
        Pencil pencilWithHighDurability = new Pencil(PencilDurability.HIGH, Length.SHORT);
        pencilWithHighDurability.write(paper, textToWrite);
        assertTrue(paper.getContent().equals(textToWrite));
    }

    @Test
    public void pencilShouldNotBeAbleToWriteAMessageContainingMoreThan40CharactersWithHighPointDurability(){
        textToWrite = "thismessagehasmorethanfiftycharsinoveralllength!";
        Pencil pencilWithHighDurability = new Pencil(PencilDurability.HIGH, Length.SHORT);
        pencilWithHighDurability.write(paper, textToWrite);
        assertTrue(paper.getContent().equals("thismessagehasmorethanfiftycharsinoveral"));
    }

    @Test
    public void pencilShouldRegainItsInitialPointDurabilitiyWhenItIsSharpneed(){
        textToWrite = "thishastwentychars!!";
        pencil.write(paper, textToWrite);
        pencil.sharpen();
        textToWrite = "andcanwritemore";
        pencil.write(paper, textToWrite);
        assertTrue(paper.getContent().equals("thishastwentychars!!andcanwritemore"));
    }

    @Test
    public void pencilShouldHaveAShortLength(){
        assertEquals(1, pencil.getRemainingSharpenAbility());
    }

    @Test
    public void pencilShouldHaveALongLength(){
        Pencil longPencil = new Pencil(PencilDurability.HIGH, Length.LONG);
        assertEquals(3, longPencil.getRemainingSharpenAbility());
    }

    @Test
    public void pencilOfShortLengthShouldOnlyBeAbleToBeSharpenedOnce(){
        textToWrite = "thishastwentychars!!";
        pencil.write(paper, textToWrite);
        pencil.sharpen();

        textToWrite = "andcanwriteevenmore!";
        pencil.write(paper, textToWrite);
        assertTrue(paper.getContent().equals("thishastwentychars!!andcanwriteevenmore!"));
    }

    @Test
    public void pencilOfShortLengthShouldNotBeAbleToBeSharpenedMoreThanOnce(){
        textToWrite = "thishastwentychars!!";
        pencil.write(paper, textToWrite);
        pencil.sharpen();

        textToWrite = "andcanwriteevenmore!";
        pencil.write(paper, textToWrite);
        textToWrite = "thisshouldnotappear";

        pencil.sharpen();
        pencil.write(paper, textToWrite);
        assertTrue(paper.getContent().equals("thishastwentychars!!andcanwriteevenmore!"));
    }

    @Test
    public void pencilOfLongLengthShouldOnlyBeAbleToBeSharpenedThreeTimes(){
        Pencil longPencil = new Pencil(PencilDurability.LOW, Length.LONG);
        textToWrite = "thishastwentychars!!";
        longPencil.write(paper, textToWrite);
        longPencil.sharpen();

        textToWrite = "andcanwriteevenmore!";
        longPencil.write(paper, textToWrite);
        longPencil.sharpen();

        textToWrite = "andcanwriteevenmore!";
        longPencil.write(paper, textToWrite);
        longPencil.sharpen();

        textToWrite = "andcanwriteevenmore!";
        longPencil.write(paper, textToWrite);
        assertTrue(paper.getContent().equals("thishastwentychars!!andcanwriteevenmore!andcanwriteevenmore!andcanwriteevenmore!"));
    }

    @Test
    public void pencilOfLongLengthShouldNotBeAbleToBeSharpenedMoreThanThreeTimes(){
        Pencil longPencil = new Pencil(PencilDurability.LOW, Length.LONG);
        textToWrite = "thishastwentychars!!";
        longPencil.write(paper, textToWrite);
        longPencil.sharpen();

        textToWrite = "andcanwriteevenmore!";
        longPencil.write(paper, textToWrite);
        longPencil.sharpen();

        textToWrite = "andcanwriteevenmore!";
        longPencil.write(paper, textToWrite);
        longPencil.sharpen();

        textToWrite = "andcanwriteevenmore!";
        longPencil.write(paper, textToWrite);
        longPencil.sharpen();

        textToWrite = "thisshouldnotappear";
        longPencil.write(paper, textToWrite);

        assertTrue(paper.getContent().equals("thishastwentychars!!andcanwriteevenmore!andcanwriteevenmore!andcanwriteevenmore!"));
    }

    @Test
    public void pencilShouldNotExahustAnyGraphiteDurabilityWhenIncludingSpaces(){
        textToWrite = "this h a s twe nt y cha  rs ! !";
        pencil.write(paper, textToWrite);
        assertTrue(paper.getContent().equals(textToWrite));
    }

    @Test
    public void pencilShouldBeAbleToWriteAMessageContainingTenLowerCaseCharactersAndFiveUpperCaseCharactersWithLowPointDurability(){
        textToWrite = "This Has Twenty";
        pencil.write(paper, textToWrite);
        assertTrue(paper.getContent().equals(textToWrite));
    }

    @Test
    public void pencilShouldNotBeAbleToWriteAMessageContainingFiveteenLowerCaseCharactersAndTenUpperCaseCharactersWithLowPointDurability(){
        textToWrite = "THIS HAS more than TWEnty chars!!";
        pencil.write(paper, textToWrite);
        assertTrue(paper.getContent().equals("THIS HAS more th"));
    }

    @Test
    public void pencilShouldBeAbleToEraseCoolFromPaperContainingVeryCoolCool(){
        textToWrite = "Very Cool Cool";
        pencil.write(paper, textToWrite);
        eraser.erase(paper, "Cool");
        assertTrue(paper.getContent().equals("Very Cool     "));
    }

    @Test
    public void pencilShouldBeAbleToEraseTheFirstChuckThenTheSecondChuckFromPaperContainingWoodChuckChuckIfAWoodchuckCouldChuckWood(){
        textToWrite = "woodchuck chuck if a woodchuck could chuck wood";
        Pencil longPencil = new Pencil(PencilDurability.HIGH, Length.LONG);
        longPencil.write(paper, textToWrite);

        eraser.erase(paper, "chuck");
        eraser.erase(paper, "chuck");
        assertTrue(paper.getContent().equals("woodchuck chuck if a wood      could       wood"));
    }

    @Test
    public void eraserShouldHaveALowEraserDurability(){
        assertEquals(2, eraser.getRemainingEraseAmount());
    }

    @Test
    public void eraserShouldHaveAHighEraserDurability(){
        Eraser eraserWithHighDurability = new Eraser(EraserDurability.HIGH);
        assertEquals(4, eraserWithHighDurability.getRemainingEraseAmount());
    }

    @Test
    public void eraserWithHighEraserDurablitilyShouldBeAbleToEraseUpToFourTimes(){
        Pencil pencilWithHighDurability = new Pencil(PencilDurability.HIGH, Length.SHORT);
        Eraser eraserWithHighDurability = new Eraser(EraserDurability.HIGH);
        textToWrite = "repeat1 repeat2 repeat3 repeat4 repeat5";
        pencilWithHighDurability.write(paper, textToWrite);

        eraserWithHighDurability.erase(paper, "repeat5");
        eraserWithHighDurability.erase(paper, "repeat4");
        eraserWithHighDurability.erase(paper, "repeat3");
        eraserWithHighDurability.erase(paper, "repeat2");

        assertTrue(paper.getContent().equals("repeat1                                "));
    }

    @Test
    public void eraserWithHighEraserDurablitilyShouldNotBeAbleToEraseMoreThanFourTimes(){
        Pencil pencilWithHighDurability = new Pencil(PencilDurability.HIGH, Length.SHORT);
        Eraser eraserWithHighDurability = new Eraser(EraserDurability.HIGH);
        textToWrite = "repeat1 repeat2 repeat3 repeat4 repeat5";
        pencilWithHighDurability.write(paper, textToWrite);

        eraserWithHighDurability.erase(paper, "repeat5");
        eraserWithHighDurability.erase(paper, "repeat4");
        eraserWithHighDurability.erase(paper, "repeat3");
        eraserWithHighDurability.erase(paper, "repeat2");
        eraserWithHighDurability.erase(paper, "repeat1");

        assertTrue(paper.getContent().equals("repeat1                                "));
    }

    @Test
    public void previouslyErasedWordOrangeFromPaperShouldBeAppleWhenEditIsAppliedToPaperContent(){
        Pencil pencilWithHighDurability = new Pencil(PencilDurability.HIGH, Length.SHORT);
        textToWrite = "An orange a day keeps the doctor away";
        pencilWithHighDurability.write(paper, textToWrite);

        eraser.erase(paper, "orange");
        pencil.editFromMostRecentErasedEntry(paper, "apple");
        assertTrue(paper.getContent().equals("An apple a day keeps the doctor away"));
    }


}
