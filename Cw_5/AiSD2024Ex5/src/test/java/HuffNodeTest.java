
import org.junit.jupiter.api.Test;
import pl.edu.pw.ee.aisd2024ex5.HuffNode;

import static org.junit.jupiter.api.Assertions.*;

public class HuffNodeTest {

@Test
    public void testPositiveifValuesCorrect() {
    //given
    HuffNode n1 = new HuffNode('A',7);
    HuffNode n2 = new HuffNode('B',5);
    HuffNode n3 = new HuffNode('C',1);
    //then
    assertTrue(n1.compareTo(n2)>0);
    assertTrue(n3.compareTo(n1)<0);

}
    @Test
    public void printErrorIfFreqIsZero() {
    //given
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            HuffNode n1 = new HuffNode('A', 0);
        });
    //then
        assertEquals("Frequency should be greater than 0 for Node: A", thrown.getMessage());
    }


}

