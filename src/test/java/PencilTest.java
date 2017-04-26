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
    private String textToWrite;

    @Before()
    public void setUp(){
        pencil = new Pencil();
        paper = new Paper();
        textToWrite = "";
    }

    @After
    public void tearDown(){
        pencil = null;
        paper = null;
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
        pencil = new Pencil(PencilDurability.HIGH, Length.SHORT);
        assertEquals(40, pencil.getRemainingCharacters());
    }

    @Test
    public void pencilShouldBeAbleToWriteAMessageContaining20CharactersWithLowPointDurability(){
        textToWrite = "thishastwentychars!!";
        pencil.write(paper, textToWrite);

        assertTrue(paper.getContent().equals(textToWrite));
    }

    @Test
    public void pencilShouldNotBeAbleToWriteAFullMessageContainingMoreThan20CharactersWithLowPointDurability(){
        textToWrite = "thishasmorethantwentychars!!";
        pencil.write(paper, textToWrite);

        assertTrue(paper.getContent().equals("thishasmorethantwent"));
    }

    @Test
    public void pencilShouldBeAbleToWriteAMessageContaining40CharactersWithHighPointDurability(){
        textToWrite = "thismessagehasexactlyfiftycharsinlength!";
        pencil = new Pencil(PencilDurability.HIGH, Length.SHORT);
        pencil.write(paper, textToWrite);

        assertTrue(paper.getContent().equals(textToWrite));
    }

    @Test
    public void pencilShouldNotBeAbleToWriteAFullMessageContainingMoreThan40CharactersWithHighPointDurability(){
        textToWrite = "thismessagehasmorethanfiftycharsinoveralllength!";
        pencil = new Pencil(PencilDurability.HIGH, Length.SHORT);
        pencil.write(paper, textToWrite);

        assertTrue(paper.getContent().equals("thismessagehasmorethanfiftycharsinoveral"));
    }

    @Test
    public void pencilShouldRegainItsInitialPointDurabilityWhenItIsSharpened(){
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
        pencil = new Pencil(PencilDurability.HIGH, Length.LONG);
        assertEquals(3, pencil.getRemainingSharpenAbility());
    }

    @Test
    public void pencilOfShortLengthShouldOnlyBeAbleToBeSharpenedOnce(){
        textToWrite = "thishastwentychars!!";
        pencil.write(paper, textToWrite);

        pencil.sharpen();
        textToWrite = "andcanwriteevenmore!";
        pencil.write(paper, textToWrite);

        assertEquals(0, pencil.getRemainingSharpenAbility());
        assertTrue(paper.getContent().equals("thishastwentychars!!andcanwriteevenmore!"));
    }

    @Test
    public void pencilOfShortLengthShouldNotBeAbleToBeSharpenedMoreThanOnce(){
        textToWrite = "thishastwentychars!!";
        pencil.write(paper, textToWrite);

        pencil.sharpen();
        textToWrite = "andcanwriteevenmore!";
        pencil.write(paper, textToWrite);

        pencil.sharpen();
        textToWrite = "thisshouldnotappear";
        pencil.write(paper, textToWrite);
        assertTrue(paper.getContent().equals("thishastwentychars!!andcanwriteevenmore!"));
    }

    @Test
    public void pencilOfLongLengthShouldOnlyBeAbleToBeSharpenedThreeTimes(){
        pencil = new Pencil(PencilDurability.LOW, Length.LONG);
        textToWrite = "thishastwentychars!!";
        pencil.write(paper, textToWrite);

        pencil.sharpen();
        textToWrite = "andcanwriteevenmore!";
        pencil.write(paper, textToWrite);

        pencil.sharpen();
        textToWrite = "andcanwriteevenmore!";
        pencil.write(paper, textToWrite);

        pencil.sharpen();
        textToWrite = "andcanwriteevenmore!";
        pencil.write(paper, textToWrite);

        assertEquals(0, pencil.getRemainingSharpenAbility());
        assertTrue(paper.getContent().equals("thishastwentychars!!andcanwriteevenmore!andcanwriteevenmore!andcanwriteevenmore!"));
    }

    @Test
    public void pencilOfLongLengthShouldNotBeAbleToBeSharpenedMoreThanThreeTimes(){
        pencil = new Pencil(PencilDurability.LOW, Length.LONG);
        textToWrite = "thishastwentychars!!";
        pencil.write(paper, textToWrite);

        pencil.sharpen();
        textToWrite = "andcanwriteevenmore!";
        pencil.write(paper, textToWrite);

        pencil.sharpen();
        textToWrite = "andcanwriteevenmore!";
        pencil.write(paper, textToWrite);

        pencil.sharpen();
        textToWrite = "andcanwriteevenmore!";
        pencil.write(paper, textToWrite);

        pencil.sharpen();
        textToWrite = "thisshouldnotappear";
        pencil.write(paper, textToWrite);

        assertTrue(paper.getContent().equals("thishastwentychars!!andcanwriteevenmore!andcanwriteevenmore!andcanwriteevenmore!"));
    }

    @Test
    public void pencilShouldNotExhaustAnyGraphiteDurabilityWhenIncludingSpaces(){
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
    public void pencilShouldNotBeAbleToWriteAMessageContainingFifteenLowerCaseCharactersAndTenUpperCaseCharactersWithLowPointDurability(){
        textToWrite = "THIS HAS more than TWEnty chars!!";
        pencil.write(paper, textToWrite);

        assertTrue(paper.getContent().equals("THIS HAS more th"));
    }

}
