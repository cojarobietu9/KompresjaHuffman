package pl.edu.pw.ee.aisd2024ex5;
import java.util.ArrayList;

public class GenerateHuffCode {
    private ArrayList<String> codes;
    private ArrayList<Character> symbols;

    public GenerateHuffCode(HuffTree tree) {
            this.codes=new ArrayList<>();
            this.symbols = new ArrayList<>();
            if(tree.getRoot().getSymbol()!='\0'&& tree.getRoot().getLeft()==null){
                this.codes.add("1");
                this.symbols.add(tree.getRoot().getSymbol());
            }
            else {
                generateCodes(tree.getRoot(), "");
            }
    }

    public void generateCodes(HuffNode node, String code) {
        if (node.getLeft() == null && node.getRight() == null) {
            this.codes.add(code);
            this.symbols.add(node.getSymbol());
        }
        else {
            generateCodes(node.getLeft(), code + "0");
            generateCodes(node.getRight(), code + "1");
        }
    }

    public ArrayList<String> getCodes(){
        return this.codes;
    }

    public ArrayList<Character> getSymbols(){
        return this.symbols;
    }
}
