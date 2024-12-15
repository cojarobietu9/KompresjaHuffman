import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.pw.ee.aisd2024ex5.HuffNode;
import pl.edu.pw.ee.aisd2024ex5.NodesList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class NodeListTest {

    private File file;

    @BeforeEach
    void setUp(){
        file = new File("plik.txt");
    }


    @Test
    void testMultipleCharactersFile() throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("AABAdAdABBddBB");
        }
        NodesList nlist = new NodesList(file);
        ArrayList<HuffNode> result = nlist.getNodes();


            assertEquals(3, result.size(), "The result should have three entries.");
            assertEquals('A', result.get(0).getSymbol(), "The symbol for 0 should be 'A'.");
            assertEquals('B', result.get(1).getSymbol(), "The symbol for 1 should be 'B'.");
            assertEquals('d', result.get(2).getSymbol(), "The symbol for 2 should be 'd'.");
            assertEquals(5, result.get(0).getFrequency(), "The count for 'A' should be 5.");
            assertEquals(5, result.get(1).getFrequency(), "The count for 'B' should be 5.");
            assertEquals(4, result.get(2).getFrequency(), "The count for 'd' should be 4.");

    }
    @Test
    void testNoCharachter() throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("");
        }
        NodesList nlist = new NodesList(file);
        ArrayList<HuffNode> result = nlist.getNodes();

        assertEquals(0, result.size(), "The result should have zero entries.");

    }
    @Test
    void testSpecialCharacters() throws IOException{
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("@@%3@");
        }
        NodesList nlist = new NodesList(file);
        ArrayList<HuffNode> result = nlist.getNodes();


        assertEquals('@', result.get(0).getSymbol(), "The symbol for 0 should be '@'.");
        assertEquals(3, result.get(0).getFrequency(), "The count for '@' should be 3.");


    }
    @Test
    void testNoneexistentFile()throws IOException{
        File nonExistentFile = new File("tegoplikuniema.txt");

        IOException exception = assertThrows(IOException.class, () -> {new NodesList(nonExistentFile);});

        assertEquals("java.io.FileNotFoundException: tegoplikuniema.txt (No such file or directory)", exception.getMessage());
    }

}
