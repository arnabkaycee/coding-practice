import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DecodeStringTest {

    private DecodeString ds = new DecodeString();

    @Test
    public void testNested() {
        Assertions.assertEquals("accaccacc", ds.decodeString("3[a2[c]]"));
    }


    @Test
    public void testOne() {
        Assertions.assertEquals("abccdcdcdxyz", ds.decodeString("abc3[cd]xyz"));
    }

    @Test
    public void testComplicated() {
        Assertions.assertEquals(
                "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef",
                ds.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }


    @Test
    public void testComplicated1() {
        Assertions.assertEquals(
                "zzzssef",
                ds.decodeString("3[z]2[s]ef"));
    }




}
