import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.pw.ee.aisd2024ex5.GenerateHuffCode;
import pl.edu.pw.ee.aisd2024ex5.HuffNode;
import pl.edu.pw.ee.aisd2024ex5.HuffTree;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateHuffCodeTest {
    private ArrayList<Character> symbols;
    private ArrayList<String> codes;
    private HuffTree testTree;
    private ArrayList<HuffNode> testList;
    @BeforeEach
        void setUp(){
        testList = new ArrayList<>();
        testList.add(new HuffNode('A', 7));
        testList.add(new HuffNode('B', 1));
        testList.add(new HuffNode('C', 5));
        testList.add(new HuffNode('D', 8));
        testTree = new HuffTree(testList);
    }
@Test
    void testIfGeneratesHuffCodesCorrectly(){
        GenerateHuffCode gen = new GenerateHuffCode(testTree);
        this.codes =gen.getCodes();
        this.symbols = gen.getSymbols();
        ArrayList<String> correctCodes = new ArrayList<>();
        correctCodes.add("0");
        correctCodes.add("100");
        correctCodes.add("101");
        correctCodes.add("11");
        ArrayList<Character> correctSymbols = new ArrayList<>();
        correctSymbols.add('D');
        correctSymbols.add('B');
        correctSymbols.add('C');
        correctSymbols.add('A');
        assertEquals(correctCodes,this.codes, "nie lula! :(");
        assertEquals(correctSymbols,this.symbols,"kamil ślimak");
    }
}
