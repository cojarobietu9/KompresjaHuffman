package pl.edu.pw.ee.aisd2024ex5;


public class HuffNode implements Comparable<HuffNode> {
    private char symbol;
    private int frequency;
    private HuffNode left;
    private HuffNode right;


    public HuffNode(char symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
        if (frequency <= 0) {
            throw new IllegalArgumentException("Frequency should be greater than 0 for Node: " + symbol);
        }
    }

    public HuffNode(int frequency, HuffNode left, HuffNode right) {
        this.symbol = '\0';
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(HuffNode other){
        return Integer.compare(this.frequency, other.frequency);
    }

    public int getFrequency() {return frequency;}

    public char getSymbol() {return symbol;}

    public HuffNode getLeft(){return this.left;}

    public HuffNode getRight(){return this.right;}


}
