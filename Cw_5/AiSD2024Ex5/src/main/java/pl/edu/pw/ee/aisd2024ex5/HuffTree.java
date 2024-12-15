package pl.edu.pw.ee.aisd2024ex5;
import java.util.ArrayList;


public class HuffTree {

    private HuffNode root;

    public HuffTree(ArrayList<HuffNode> list) {
        createHuffTree(list);
    }

    public void createHuffTree(ArrayList<HuffNode> list) {
        Heap heap = new Heap(list);
        while (heap.getSize() > 1) {
            HuffNode node1 = heap.removeFromHeap();
            HuffNode node2 = heap.removeFromHeap();
            HuffNode newNode = new HuffNode(node1.getFrequency() + node2.getFrequency(), node1, node2);
            heap.addToHeap(newNode);
        }
        this.root = heap.removeFromHeap();
    }

    public HuffNode getRoot(){
        return root;
    }
}
