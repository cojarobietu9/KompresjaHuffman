import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.edu.pw.ee.aisd2024ex5.HuffNode;
import pl.edu.pw.ee.aisd2024ex5.HuffTree;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class HuffTreeTest {
    private HuffTree testTree;
    private ArrayList<HuffNode> testList;
    @BeforeEach
    void setUp() {
        testList = new ArrayList<>();
    }
    @Test
    void testIfHuffTreeReturnsCorrectRoot(){
        testList.add(new HuffNode('A', 7));
        testList.add(new HuffNode('B', 1));
        testList.add(new HuffNode('C', 5));
        testList.add(new HuffNode('D', 8));
        testTree = new HuffTree(testList);
        HuffNode root = testTree.getRoot();
        assertEquals(21, root.getFrequency(), "Frequency of the root should be 21, in this case it is: "+root.getFrequency());
        assertEquals('D', root.getLeft().getSymbol(),"It is not DD :<");
        assertEquals('A', root.getRight().getRight().getSymbol(),"It is not DD :<");
        assertEquals('B', root.getRight().getLeft().getLeft().getSymbol(),"It is not DD :<");
        assertEquals('C', root.getRight().getLeft().getRight().getSymbol(),"It is not DD :<");


    }

}
