import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.pw.ee.aisd2024ex5.HuffCodeFile;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class HuffCodeFileTest {
    private ArrayList<Character> symbols;
    private ArrayList<String> codes;
    private File file;
    @BeforeEach
    void setUp(){
        symbols = new ArrayList<>();
        codes = new ArrayList<>();

        symbols.add('D');
        symbols.add('B');
        symbols.add('C');
        symbols.add('A');

        codes.add("0");
        codes.add("100");
        codes.add("101");
        codes.add("11");
    }
    @Test
    void testIfTheFileIsCreated() throws IOException {
        file = new File("pliczek.txt");
        HuffCodeFile hfile = new HuffCodeFile("wynik.txt");
        hfile.textToHuffCodeFile(symbols, codes, file);

    }


}
