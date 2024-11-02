import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SentenceScreenFittingTest {

    private SentenceScreenFitting s = new SentenceScreenFitting();

    @Test
    public void testSingleLetters() {
        String[] sentence = new String[]{"f", "p", "a"};
//        assertEquals(4, s.wordsTyping(sentence, 3, 7));
        assertThat(s.wordsTyping(sentence, 3, 7)).isEqualTo(4);
    }


    @Test
    public void testSingleColumn() {
        String[] sentence = new String[]{"hello"};
        assertThat(s.wordsTyping(sentence, 1, 1)).isEqualTo(0);
    }

    @Test
    public void testTightWords() {
        String[] sentence = new String[]{"i", "had", "apple", "pie"};
        assertThat(s.wordsTyping(sentence, 4, 5)).isEqualTo(1);
    }


    @Test
    public void testLargeMatrix() {
        String[] sentence = new String[]{"a"};
        assertThat(s.wordsTyping(sentence, 20_000, 20_000)).isEqualTo(20_00_00_000);
    }

    @Test
    public void testSmallMatrix() {
        String[] sentence = new String[]{"a"};
        assertThat(s.wordsTyping(sentence, 20, 20)).isEqualTo(200);
    }


    @Test
    public void testLargeMatrixTwo() {
        String[] sentence = new String[]{"i", "had", "apple", "pie", "i", "had", "apple", "pie", "i", "had", "apple", "pie"};
        assertThat(s.wordsTyping(sentence, 20_000, 20_000)).isEqualTo(83_33_333);
    }


    @Test
    public void testWords() {
        String[] sentence = new String[]{"hello", "world"};
        assertEquals(1, s.wordsTyping(sentence, 2, 8));
    }

    @Test
    public void testSingleLetterTight() {
        String[] sentence = new String[]{"a", "b", "c"};
        assertEquals(1, s.wordsTyping(sentence, 3, 1));
    }


    @Test
    public void testOtherWords() {
        String[] sentence = new String[]{"he", "sits", "dog"};
        assertEquals(3, s.wordsTyping(sentence, 5, 8));
    }

    @Test
    public void testWeird() {
        String[] sentence = new String[]{"try","to","be","better"};
        assertEquals(5293334, s.wordsTyping(sentence, 10000, 9001));
    }


}
