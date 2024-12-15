import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.pw.ee.aisd2024ex5.Heap;
import pl.edu.pw.ee.aisd2024ex5.HuffNode;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeapTest {
    private ArrayList<HuffNode> testList;
    @BeforeEach
        void setUp(){
        testList = new ArrayList<>();
    }
    @Test
    void testIfHeapsCorrectly(){
        //given
        HuffNode n1 = new HuffNode('A',7);
        HuffNode n2 = new HuffNode('B',1);
        HuffNode n3 = new HuffNode('C',5);
        HuffNode n4 = new HuffNode('D',8);

        testList.add(n1);
        testList.add(n2);
        testList.add(n3);
        testList.add(n4);

        Heap heap = new Heap(testList);
        //then
        HuffNode h1 =heap.removeFromHeap();
        assertEquals(n2,h1, "n2 should have been removed the first, instead it was the node with:"+h1.getSymbol());

        HuffNode h2 =heap.removeFromHeap();
        assertEquals(n3,h2, "n3 should have been removed the second, instead it was the node with:"+h2.getSymbol());

        HuffNode h3 =heap.removeFromHeap();
        assertEquals(n1,h3, "n1 should have been removed the third, instead it was the node with:"+h3.getSymbol());

        HuffNode h4 =heap.removeFromHeap();
        assertEquals(n4,h4, "n4 should have been removed the fourth instead it was the node with:"+h4.getSymbol());
    }

    @Test
    void testIfHeapsCorrectlyforSameFrequencies(){
        //given
        HuffNode n1 = new HuffNode('A',7);
        HuffNode n2 = new HuffNode('B',1);
        HuffNode n3 = new HuffNode('C',1);
        HuffNode n4 = new HuffNode('D',1);

        testList.add(n1);
        testList.add(n2);
        testList.add(n3);
        testList.add(n4);

        Heap heap = new Heap(testList);
        //then
        HuffNode h1 =heap.removeFromHeap();
        assertEquals(n2,h1, "n2 should have been removed the first, instead it was the node with:"+h1.getSymbol());

        HuffNode h2 =heap.removeFromHeap();
        assertEquals(n4,h2, "n4 should have been removed the second, instead it was the node with:"+h2.getSymbol());

        HuffNode h3 =heap.removeFromHeap();
        assertEquals(n3,h3, "n3 should have been removed the third, instead it was the node with:"+h3.getSymbol());

        HuffNode h4 =heap.removeFromHeap();
        assertEquals(n1,h4, "n1 should have been removed the fourth instead it was the node with:"+h4.getSymbol());
    }


}
