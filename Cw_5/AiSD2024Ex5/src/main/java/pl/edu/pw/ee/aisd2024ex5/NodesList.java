package pl.edu.pw.ee.aisd2024ex5;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.IOException;


public class NodesList {
    private ArrayList<HuffNode> nodes;
    public NodesList(File file)throws IOException {
        this.nodes = makeNodesList(file);
    }
    private ArrayList<HuffNode> makeNodesList(File file) throws IOException {
        ArrayList<Character> symbols = new ArrayList<>();
        ArrayList<Integer> frequencies = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            int ch;
            while ((ch = br.read()) != -1) {
                Character chc = Character.valueOf((char)ch);
                if (symbols.contains(chc)){
                    int index = symbols.indexOf((char) ch);
                    frequencies.set(index, frequencies.get(index) + 1);
                }
                else{
                    symbols.add((char) ch);
                    frequencies.add(1);
                }
            }
        }
        catch(IOException e){
            throw new IOException(e);
        }
        ArrayList<HuffNode> nodes = new ArrayList<>();
        for (int i = 0; i < frequencies.size(); i++){
            HuffNode node = new HuffNode(symbols.get(i), frequencies.get(i));
            nodes.add(node);
        }
        return nodes;
    }
    public ArrayList<HuffNode> getNodes() {
        return this.nodes;
    }
}
